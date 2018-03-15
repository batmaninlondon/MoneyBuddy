/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.myMoneyBuddy.mailerClasses.DesEncrypter;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.MbUtil;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.json.JSONObject;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ForgotPasswordAction extends ActionSupport implements SessionAware{
	
	Logger logger = Logger.getLogger(ForgotPasswordAction.class);
	private Map<String, Object> sessionMap;
    private String emailId;
    private String googleResponse;
    
    /*static final String FROM = "info@quantwealth.in";
    static final String FROMNAME = "MoneyBuddy";*/
	
    // Replace recipient@example.com with a "To" address. If your account 
    // is still in the sandbox, this address must be verified.
    //static final String TO = "emailwadhwani@gmail.com";
    
    // Replace smtp_username with your Amazon SES SMTP user name.
    //static final String SMTP_USERNAME = "AKIAIWUUSWP7Q6ZULO5Q";
    
    // Replace smtp_password with your Amazon SES SMTP password.
    //static final String SMTP_PASSWORD = "AsZxWpOv37ISx5HD/SSD6NkKgcf5qD165ORDlzXSiCvr";
    
    // The name of the Configuration Set to use for this message.
    // If you comment out or remove this variable, you will also need to
    // comment out or remove the header below.
    //static final String CONFIGSET = "ConfigSet";
    
    // Amazon SES SMTP host name. This example uses the US West (Oregon) region.
    // See http://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html#region-endpoints
    // for more information.
    //static final String HOST = "email-smtp.us-east-1.amazonaws.com";
    
    // The port you will connect to on the Amazon SES SMTP endpoint. 
    //static final int PORT = 587;
    
    //static final String SUBJECT = "Money Buddy is here!!";
    
/*    static final String BODY = String.join(
    	    System.getProperty("line.separator"),
    	    "<h1>Coming Soon</h1>",
    	    "<p>We are excited to annouce that we are launching our platform soon", 
    	    "  <a href='http://www.quantwealth.in'>MnoeyBuddy.in</a>."
    	);*/

    

    public final String MAIL_ResetPassword_SITE_LINK = "www.quantwealth.in/resetPassword";

    QueryCustomer customer = new QueryCustomer();
    
    String regexEmail = "^(.+)@(.+)$";
    Pattern patternEmail = Pattern.compile(regexEmail);
    
    private InputStream stream;
    
    /*@Override
    public void validate()  {
    	logger.debug("ForgotPasswordAction class : validate method : start");
    	if(StringUtils.isEmpty(getEmailId()) )
    		addFieldError("emailId","Email Id can't be blank!");
    	else if (!patternEmail.matcher(emailId).matches())
            addFieldError("emailId","Please enter a valid emil address");
    	else if (!customer.existsCustomer(getEmailId()))
    		addFieldError("emailId"," User does not exists.");
    	logger.debug("ForgotPasswordAction class : validate method : end");
    	
    }*/

    @Override
    public String execute() {
    	try 
    	{
	    	logger.debug("ForgotPasswordAction class : execute method : start");
	    	System.out.println("ForgotPasswordAction class : execute method called ");
	    	MbUtil mbUtil = new MbUtil();
	    	if(!mbUtil.isCaptchaValid(getGoogleResponse()))
	    	{
	    		String str = "Lookslikeyouarearobot";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    	    return ERROR;
	    	}
	    	
	    	if (!customer.existsCustomer(getEmailId())) {
	    		System.out.println("Verification not done for this email id ");
	    		logger.debug("ForgotPasswordAction class : execute method : Email Id does not exists "+getEmailId());
	    		String str = "emailIdDoesNotExists";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    		return SUCCESS;
	    	}
	    	if (customer.getVerificationStatus(getEmailId()).equalsIgnoreCase("N"))  {
	    		System.out.println("Verification not done for this email id ");
	    		logger.debug("ForgotPasswordAction class : execute method : verification is not done for "+getEmailId());
	    		String str = "verificationNotDone";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    		return SUCCESS;
	    	}
	    	sessionMap.put("emailId", getEmailId());
	    	logger.debug("ForgotPasswordAction class : execute method : stored emailId : "+getEmailId()+" in session id : "+sessionMap.getClass().getName());

	    	SendMail sendMail = new SendMail();

	    	Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(RegisterAction.class.getResourceAsStream(configPropFilePath));
			
			String mailLink = configProperties.getProperty("MAIL_FORGOT_PASSWORD_LINK");
			System.out.println("mailLink is : "+mailLink);
	    	
	    	String subject = configProperties.getProperty("MAIL_FORGOT_PASSWORD_SUBJECT");

	    	sendMail.MailSending(getEmailId(),subject,"ForgotPasswordMail","ForgotPasswordMail.txt",mailLink,"Reset Password");
	    	
	    	logger.debug("ForgotPasswordAction class : execute method : mail sent to "+getEmailId()+" to reset password for session id : "+sessionMap.getClass().getName());
	    	logger.debug("ForgotPasswordAction class : execute method : end");
	    	
	    	String str = "success";
		    stream = new ByteArrayInputStream(str.getBytes());
	    	return SUCCESS;
		} catch (MoneyBuddyException e) {	
    		logger.debug("EstimateAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.debug("EstimateAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		}
    }
    
   

	@Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    

    public Map<String, Object> getSession() {
		return sessionMap;
	}
    public String getEmailId() {
        return emailId;
    }

    public String getGoogleResponse() {
		return googleResponse;
	}

	public void setGoogleResponse(String googleResponse) {
		this.googleResponse = googleResponse;
	}

	public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

}

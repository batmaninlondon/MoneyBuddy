/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.mailerClasses.DesEncrypter;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.insertCustomerDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.MbUtil;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;

/*import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;*/
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class RegisterAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(RegisterAction.class);
	private SessionMap<String, Object> sessionMap;

    private String password;
    private String emailId;
    private String mobileNumber;
    private String googleResponse;
    QueryCustomer customer = new QueryCustomer();
    insertCustomerDetails newCustomer = new insertCustomerDetails();
    
    private InputStream stream;

    public String execute() {
    	try {
    	
    	logger.debug("RegisterAction class : execute method : start");
    	
    	System.out.println("RegisterAction class : execute method : email Id : "+getEmailId());
    	
    	MbUtil mbUtil = new MbUtil();
    	if(!mbUtil.isCaptchaValid(getGoogleResponse()))
    	{
    		String str = "Lookslikeyouarearobot";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    return ERROR;
    	}
    	
    	if (customer.existsCustomer(getEmailId())) {
    		System.out.println("RegisterAction class : execute method : UserAlreadyExists");
    		String str = "UserAlreadyExists";
    	    stream = new ByteArrayInputStream(str.getBytes());
        	return SUCCESS;
    	}
    	
    	if (customer.existsMobileNumber(getMobileNumber())) {
    		System.out.println("RegisterAction class : execute method : MobileNumberAlreadyExists");
    		String str = "MobileNumberAlreadyExists";
    	    stream = new ByteArrayInputStream(str.getBytes());
        	return SUCCESS;
    	}
    	
    	DesEncrypter desEncrypter = new DesEncrypter(getEmailId());
    	String hashedPassword = desEncrypter.encrypt(getPassword());

    	newCustomer.insertCustomer(getEmailId(),getMobileNumber(),hashedPassword);
    	SendMail sendMail = new SendMail();

    	Properties configProperties = new Properties();
		String configPropFilePath = "../../../config/config.properties";

		configProperties.load(RegisterAction.class.getResourceAsStream(configPropFilePath));
		
		String mailLink = configProperties.getProperty("MAIL_VERIFICATION_LINK");
		System.out.println("mailLink is : "+mailLink);
		
    	String link = mailLink+"?hashedPassword="+hashedPassword;
    	
    	System.out.println("link is : "+link);
    	
    	String subject = configProperties.getProperty("MAIL_VERIFICATION_SUBJECT");

    	sendMail.MailSending(getEmailId(),subject,"VerificationMail","VerificationMail.txt",link,"Verify Email");

    	System.out.println(" send email function completed from register user.");
    	
    	logger.debug("RegisterAction class : execute method : mail sent to "+getEmailId()+" to complete user registration");
    	logger.debug("RegisterAction class : execute method : end");
    	
    	System.out.println("RegisterAction class : execute method : returning success ");
    	
    	String str = "success";
	    stream = new ByteArrayInputStream(str.getBytes());
    	return SUCCESS;
    	} catch (MoneyBuddyException e) {	
    		logger.debug("RegisterAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.debug("RegisterAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		}
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = (SessionMap<String, Object>)sessionMap;
    }
    
    
	public SessionMap<String, Object> getSession() {
		return sessionMap;
	}
	
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGoogleResponse() {
		return googleResponse;
	}

	public void setGoogleResponse(String googleResponse) {
		this.googleResponse = googleResponse;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public InputStream getStream() {
		return stream;
	}
	public void setStream(InputStream stream) {
		this.stream = stream;
	}


}

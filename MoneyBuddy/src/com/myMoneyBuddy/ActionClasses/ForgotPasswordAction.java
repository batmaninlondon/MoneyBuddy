/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.MbUtil;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class ForgotPasswordAction extends ActionSupport implements SessionAware{
	
	Logger logger = Logger.getLogger(ForgotPasswordAction.class);
	private SessionMap<String,Object> sessionMap;
    private String emailId;
    private String googleResponse;
   
    private InputStream stream;

    @Override
    public String execute() {
    	
    	String customerId = null;
    	QueryCustomer customer = new QueryCustomer();   
    	try 
    	{
    		customerId = customer.getCustomerFromEmailId(getEmailId()).getCustomerId();
    		
	    	logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - start");
	    	System.out.println("ForgotPasswordAction class : execute method called ");
	    	MbUtil mbUtil = new MbUtil();
	    	if(!mbUtil.isCaptchaValid(getGoogleResponse()))
	    	{
	    		String str = "Lookslikeyouarearobot";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    	    logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - returned Lookslikeyouarearobot");
	    	    
	    	    return SUCCESS;
	    	}
	    	
	    	if (!customer.existsCustomer(getEmailId())) {
	    		System.out.println("Email Id does not exist in the database ");
	    		
	    		String str = "emailIdDoesNotExists";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    	    logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - returned emailIdDoesNotExists");
	    	    
	    		return SUCCESS;
	    	}
	    	if (customer.getVerificationStatus(getEmailId()).equalsIgnoreCase("N"))  {
	    		
	    		System.out.println("Verification not done for this email id ");
	    		
	    		String str = "verificationNotDone";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    	    logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - returned verificationNotDone");
	    	    
	    		return SUCCESS;
	    	}
	    			
	    	sessionMap.put("emailId", getEmailId());
	    	logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - stored emailId : "+getEmailId()+" in sessionMap");

	    	SendMail sendMail = new SendMail();

	    	Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(ForgotPasswordAction.class.getResourceAsStream(configPropFilePath));
			
			String mailLink = configProperties.getProperty("MAIL_FORGOT_PASSWORD_LINK");
			System.out.println("mailLink is : "+mailLink);
	    	
	    	String subject = configProperties.getProperty("MAIL_FORGOT_PASSWORD_SUBJECT");

	    	sendMail.MailSending(getEmailId(),subject,"ForgotPasswordMail","ForgotPasswordMail.txt",mailLink,"Reset Password");
	    	
	    	logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - mail sent to "+getEmailId()+" to reset password");
	    	
	    	String str = "success";
		    stream = new ByteArrayInputStream(str.getBytes());
		    
		    logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - end");
	    	
	    	return SUCCESS;
		} catch (MoneyBuddyException e) {	
			logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - returned error");
    	    
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - returned error");
    	    
			return ERROR;
		}
    }
    
   

	@Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
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

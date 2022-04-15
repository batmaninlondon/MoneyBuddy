/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.InsertCustomerDetails;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerPassword;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.DesEncrypter;
import com.myMoneyBuddy.Utils.MbUtil;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(RegisterAction.class);
	private SessionMap<String,Object> sessionMap;
    private String passwordRegister;
    private String emailIdRegister;
    /*private String mobileNumberRegister;*/
    private String googleResponseRegister;  
    private String googleRegister;
    //private InputStream stream;

    public String execute() {
    	
    	try {
    	
    		logger.debug("RegisterAction class - execute method - start ");
    	
	    	System.out.println("RegisterAction class : execute method : email Id : "+getEmailIdRegister());

	        QueryCustomer customer = new QueryCustomer();
	        InsertCustomerDetails newCustomer = new InsertCustomerDetails();
	        
	    	MbUtil mbUtil = new MbUtil();
	    	if(!mbUtil.isCaptchaValid(getGoogleResponseRegister()))
	    	{
	    		/*String str = "Lookslikeyouarearobot";
	    	    stream = new ByteArrayInputStream(str.getBytes());*/
	    		addActionMessage("Looks like, you are a robot.");
	    	    logger.debug("RegisterAction class - execute method - returned Lookslikeyouarearobot");
	    	    
	    	    return SUCCESS;
	    	}
	    	
	    	if (customer.existsCustomer(getEmailIdRegister())) {
	    		System.out.println("RegisterAction class : execute method : UserAlreadyExists");
	    		/*String str = "UserAlreadyExists";
	    	    stream = new ByteArrayInputStream(str.getBytes());*/
	    		addActionMessage("This emailId is already registered with MoneyBuddy.");
	    	    logger.debug("RegisterAction class - execute method - returned UserAlreadyExists");
	    	    
	        	return SUCCESS;
	    	}
	    	
	    	
	    	
	    	/*if (customer.existsMobileNumber(getMobileNumberRegister())) {
	    		System.out.println("RegisterAction class : execute method : MobileNumberAlreadyExists");
	    		String str = "MobileNumberAlreadyExists";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    		addActionMessage("This mobile number is already registered with MoneyBuddy.");
	    	    logger.debug("RegisterAction class - execute method - returned MobileNumberAlreadyExists");
	    	    
	        	return SUCCESS;
	    	}*/
	    	
	    	
	    	
	    	String customerId = newCustomer.insertCustomer(getEmailIdRegister());
	    	
	    	System.out.println("customerId+getPasswordRegister() : "+customerId+getPasswordRegister());
	    	
	    	String hashedPassword = DesEncrypter.MONEYBUDDY.encrypt(customerId+getPasswordRegister());
	    	
	    	System.out.println("hashedPassword : "+hashedPassword);
	    	
	    	UpdateCustomerPassword updateCustomerPassword = new UpdateCustomerPassword();
	    	updateCustomerPassword.updatePassword(customerId, getEmailIdRegister(), getPasswordRegister());
	    	
	    	SendMail sendMail = new SendMail();
	
	    	Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";
	
			configProperties.load(RegisterAction.class.getResourceAsStream(configPropFilePath));
			
			String mailLink = configProperties.getProperty("MAIL_VERIFICATION_LINK");
			System.out.println("mailLink is : "+mailLink);
			
	    	String link = mailLink+"?Hp="+hashedPassword;
	    	
	    	System.out.println("link is : "+link);
	    	
	    	String subject = configProperties.getProperty("MAIL_VERIFICATION_SUBJECT");
	
	    	sendMail.MailSending(getEmailIdRegister(),subject,"VerificationMail","VerificationMail.txt",link,"Verify Email","","");
	
	    	System.out.println(" send email function completed from register user.");
	    	
	    	logger.debug("RegisterAction class - execute method - mail sent to "+getEmailIdRegister()+" to complete user registration");
	    	
	    	System.out.println("RegisterAction class : execute method : returning success ");
	    	
	    	/*String str = "success";
		    stream = new ByteArrayInputStream(str.getBytes());*/
	    	addActionMessage("Thank you for registering with MoneyBuddy, please verify your email.");
		    logger.debug("RegisterAction class - execute method - returned Lookslikeyouarearobot");
		    logger.debug("RegisterAction class - execute method - end");
		    
	    	return SUCCESS;
	    	
    	} catch (MoneyBuddyException e) {	
    		logger.error("RegisterAction class - execute method - Caught Exception");
			e.printStackTrace();
			
			/*String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
    	    logger.error("RegisterAction class - execute method - returned error");
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.error("RegisterAction class - execute method - Caught Exception");
			e.printStackTrace();
			
			/*String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
    	    logger.error("RegisterAction class - execute method - returned error");
			return ERROR;
		}
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }
	


    public String getPasswordRegister() {
		return passwordRegister;
	}

	public void setPasswordRegister(String passwordRegister) {
		this.passwordRegister = passwordRegister;
	}

	public String getEmailIdRegister() {
		return emailIdRegister;
	}

	public void setEmailIdRegister(String emailIdRegister) {
		this.emailIdRegister = emailIdRegister;
	}
/*
	public String getMobileNumberRegister() {
		return mobileNumberRegister;
	}

	public void setMobileNumberRegister(String mobileNumberRegister) {
		this.mobileNumberRegister = mobileNumberRegister;
	}*/

	public String getGoogleResponseRegister() {
		return googleResponseRegister;
	}

	public void setGoogleResponseRegister(String googleResponseRegister) {
		this.googleResponseRegister = googleResponseRegister;
	}

	public String getGoogleRegister() {
		return googleRegister;
	}

	public void setGoogleRegister(String googleRegister) {
		this.googleRegister = googleRegister;
	}



	/*public InputStream getStream() {
		return stream;
	}
	public void setStream(InputStream stream) {
		this.stream = stream;
	}*/


}

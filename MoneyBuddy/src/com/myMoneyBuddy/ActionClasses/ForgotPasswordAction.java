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

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.MbUtil;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;

public class ForgotPasswordAction extends ActionSupport implements SessionAware{
	
	Logger logger = LogManager.getLogger(ForgotPasswordAction.class);
	private SessionMap<String,Object> sessionMap;
    private String emailIdForgotPassword;
    private String googleResponseFrgtPswd;
    //private String response;
   
    //private InputStream stream;

    @Override
    public String execute() {
    	
    	String customerId = null;
    	QueryCustomer customer = new QueryCustomer();   
    	try 
    	{
    		
    		
	    	logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - start");
	    	System.out.println("ForgotPasswordAction class : execute method called ");
	    	MbUtil mbUtil = new MbUtil();
	    	System.out.println("googleResponse : "+getGoogleResponseFrgtPswd());
	    	
	    	if(!mbUtil.isCaptchaValid(getGoogleResponseFrgtPswd()))
	    	{
	    		/*String str = "Lookslikeyouarearobot";
	    	    stream = new ByteArrayInputStream(str.getBytes());*/
	    	    logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - returned Lookslikeyouarearobot");
	    	    addActionMessage("Looks like you are a robot.");
	    	    
	    	    return SUCCESS;
	    	}
	    	
	    	if (!customer.existsCustomer(getEmailIdForgotPassword())) {
	    		System.out.println("Email Id does not exist in the database ");
	    		
	    		/*String str = "emailIdDoesNotExists";
	    	    stream = new ByteArrayInputStream(str.getBytes());*/
	    	    logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - returned emailIdDoesNotExists");
	    	    addActionMessage("EmailId is not registered with MoneyBuddy.");
	    	    
	    		return SUCCESS;
	    	}
	    	if (customer.getVerificationStatus(getEmailIdForgotPassword()).equalsIgnoreCase("N"))  {
	    		
	    		System.out.println("Verification not done for this email id ");
	    		
	    		/*String str = "verificationNotDone";
	    	    stream = new ByteArrayInputStream(str.getBytes());*/
	    	    logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - returned verificationNotDone");
	    	    addActionMessage("Verification pending for this Email Id.");
	    	    
	    		return SUCCESS;
	    	}
	    		
	    	Customers customers = customer.getCustomerFromEmailId(getEmailIdForgotPassword());
	    	customerId = customers.getCustomerId();
	    	String customerName = customers.getCustomerName();
	    	
	    	if (customerName == null  ) 
	    		customerName = "";
	    	
	    	sessionMap.put("emailId", getEmailIdForgotPassword());
	    	logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - stored emailId : "+getEmailIdForgotPassword()+" in sessionMap");

	    	QueryCustomer queryCustomer = new QueryCustomer();
	    	
	    	String hashedPassword = queryCustomer.getHashedPassword(emailIdForgotPassword);
	    	
	    	System.out.println("hashedPassword : "+hashedPassword);
	    	
	    	SendMail sendMail = new SendMail();

	    	Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(ForgotPasswordAction.class.getResourceAsStream(configPropFilePath));
			
			String mailLink = configProperties.getProperty("MAIL_FORGOT_PASSWORD_LINK");
			System.out.println("mailLink is : "+mailLink);
			
			String link = mailLink+"?Hp="+hashedPassword;
	    	
	    	System.out.println("link is : "+link);
	    	
	    	String subject = configProperties.getProperty("MAIL_FORGOT_PASSWORD_SUBJECT");

	    	sendMail.MailSending(getEmailIdForgotPassword(),subject,"ForgotPasswordMail","ForgotPasswordMail.txt",link,"Reset your password",customerName,"");
	    	
	    	logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - mail sent to "+getEmailIdForgotPassword()+" to reset password");
	    	
	    	/*String str = "success";
		    stream = new ByteArrayInputStream(str.getBytes());*/
		    
		    logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("ForgotPasswordAction class - execute method - customerId - "+customerId+" - end");
	    	
	    	addActionMessage("Email has been sent to reset your password.");
	    	return SUCCESS;
		} catch (MoneyBuddyException e) {	
			logger.error("ForgotPasswordAction class - execute method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			
			/*String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
    	    logger.error("ForgotPasswordAction class - execute method - customerId - "+customerId+" - returned error");
    	    
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.error("ForgotPasswordAction class - execute method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			
			/*String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
    	    logger.error("ForgotPasswordAction class - execute method - customerId - "+customerId+" - returned error");
    	    
			return ERROR;
		}
    } 
   
	@Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }
	

    public String getEmailIdForgotPassword() {
		return emailIdForgotPassword;
	}

	public void setEmailIdForgotPassword(String emailIdForgotPassword) {
		this.emailIdForgotPassword = emailIdForgotPassword;
	}

	public String getGoogleResponseFrgtPswd() {
		return googleResponseFrgtPswd;
	}

	public void setGoogleResponseFrgtPswd(String googleResponseFrgtPswd) {
		this.googleResponseFrgtPswd = googleResponseFrgtPswd;
	}



/*	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}*/

}

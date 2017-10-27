/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.mailerClasses.DesEncrypter;
import com.myMoneyBuddy.mailerClasses.sendMail;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.insertCustomerDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

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
	
	private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String emailId;
    private String mobileNumber;
    //public final String MAIL_ForgotPassword_SITE_LINK = "http://localhost:8080/userVerification";
    public final String MAIL_ForgotPassword_SITE_LINK = "www.quantwealth.in/userVerification";
    QueryCustomer customer = new QueryCustomer();
    insertCustomerDetails newCustomer = new insertCustomerDetails();
    
   /* String regexEmail = "^(.+)@(.+)$";
    String regexMobile = "\\d+";
    Pattern patternEmail = Pattern.compile(regexEmail);
    Pattern patternMobile = Pattern.compile(regexMobile);*/

    private InputStream stream;
    
/*    public void validate() {
    	logger.debug("RegisterAction class : validate method : start");
    	
        if ( StringUtils.isEmpty(getFirstName()) )
            addFieldError("firstName","first name can't be blank");
        else if (StringUtils.isEmpty(getLastName()))
            addFieldError("lastName"," last name can't be blank.");
        else if ( StringUtils.isEmpty(getPassword())) 
            addFieldError("password","Password can't be blank");
        else if ( StringUtils.isEmpty(getConfirmPassword()))
            addFieldError("confirmPassword","Confirm Password can't be blank");
        else if (!getPassword().equals(getConfirmPassword()))
            addFieldError("confirmPassword","Confirm password doesn't match with the above password");
        else  if (StringUtils.isEmpty(getEmailId()) )
            addFieldError("emailId","Email can't be blank");
        else if (!patternEmail.matcher(emailId).matches())
            addFieldError("emailId","Please enter a valid emil address");
        else if (customer.existsCustomer(getEmailId()))
            addFieldError("emailId"," User already exists. Please choose a different email Id");
        else if( StringUtils.isEmpty(getMobileNumber()))
            addFieldError("mobileNumber","Mobile No. can't be blank");
        else if (getMobileNumber().length()!=10)
            addFieldError("mobileNumber","Please enter a valid mobile number");
        else if (!patternMobile.matcher(mobileNumber).matches())
            addFieldError("mobileNumber","Please enter a valid mobile number");

        logger.debug("RegisterAction class : validate method : end");
    }*/
    public String execute() {
    	try {
    	
    	logger.debug("RegisterAction class : execute method : start");
    	
    	System.out.println("RegisterAction class : execute method : email Id : "+getEmailId());
    	
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
    	String subject="[MoneyBuddy] Please verify your email address.";

    	/*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
    	/*Date date = new Date();
    	String frmtdDate = dateFormat.format(date);*/

    	newCustomer.insertCustomer(getEmailId(), getFirstName(), getLastName(), getMobileNumber(),hashedPassword,null,null,null,null,null, "NO");
    	sendMail sendMail = new sendMail();

    	String link = MAIL_ForgotPassword_SITE_LINK+"?hashedPassword="+hashedPassword;

    	StringBuilder bodyText = new StringBuilder();
    	bodyText.append("<div>")
		    	.append("  Dear User<br/><br/>")
		    	.append("  Thank you for registration. Your mail ("+getEmailId()+") is under verification<br/>")
		    	.append("  Please click <a href=\""+link+"\">here</a> or open below link in browser<br/>")
		    	.append("  <a href=\""+link+"\">"+link+"</a>")
		    	.append("  <br/><br/>")
		    	.append("  Thanks,<br/>")
		    	.append("  MoneyBuddy Team")
		    	.append("</div>");

    	sendMail.MailSending(getEmailId(),bodyText,subject);
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
	
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
	public InputStream getStream() {
		return stream;
	}
	public void setStream(InputStream stream) {
		this.stream = stream;
	}


}

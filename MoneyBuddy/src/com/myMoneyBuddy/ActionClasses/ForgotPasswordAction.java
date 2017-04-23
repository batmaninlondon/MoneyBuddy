/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.regex.Pattern;

import com.myMoneyBuddy.mailerClasses.DesEncrypter;
import com.myMoneyBuddy.mailerClasses.sendMail;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

public class ForgotPasswordAction extends ActionSupport implements SessionAware{
	
	Logger logger = Logger.getLogger(ForgotPasswordAction.class);
	private Map<String, Object> sessionMap;
    private String emailId;

    public final String MAIL_ResetPassword_SITE_LINK = "http://localhost:8080/MoneyBuddy/resetPassword.jsp";

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
    	
    	try {
	    	logger.debug("ForgotPasswordAction class : execute method : start");
	
	    	if (!customer.existsCustomer(getEmailId())) {
	    		System.out.println("Verification not done for this email id ");
	    		logger.debug("ForgotPasswordAction class : execute method : Email Id does not exists "+getEmailId());
	    		String str = "emailIdDoesNotExists";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    		return SUCCESS;
	    	}
	    	if (customer.getVerificationStatus(getEmailId()).equalsIgnoreCase("NO"))  {
	    		System.out.println("Verification not done for this email id ");
	    		logger.debug("ForgotPasswordAction class : execute method : verification is not done for "+getEmailId());
	    		String str = "verificationNotDone";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    		return SUCCESS;
	    	}
	    	sessionMap.put("emailId", getEmailId());
	    	logger.debug("ForgotPasswordAction class : execute method : stored emailId : "+getEmailId()+" in session id : "+sessionMap.getClass().getName());
	    	
	    	String subject="Reset your MoneyBuddy password.";
	    	sendMail sendmail = new sendMail();
	    	String hashedPassword = customer.getPassword(getEmailId());
	    	String link = MAIL_ResetPassword_SITE_LINK+"?emailId="+emailId+"&hashedPassword="+hashedPassword;
	    	StringBuilder bodyText = new StringBuilder();
	    	bodyText.append("<div>")
	    	.append(" <br/><br/> <h1>Dear User</h1><br/><br/>")
	    	.append("  <p>Here's the link you requested to reset your MoneyBuddy password.</p><br/><br/><br/>")
	    	.append(" <h3> Please click <a href=\""+link+"\">here</a> or open below link in browser</h3><br/><br/>")
	    	.append("  <a href=\""+link+"\">"+link+"</a>")
	    	.append("  <br/><br/><br/><p>If you didn't request a password reset, please ignore this message and your password will stay the same.</p><br/><br/> <br/>")
	    	.append("  <h3>Thanks,</h3><br/><br/>")
	    	.append("  <h3>MoneyBuddy Team</h3>")
	    	.append("</div>");
	    	sendmail.MailSending(getEmailId(), bodyText,subject);
	    	
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

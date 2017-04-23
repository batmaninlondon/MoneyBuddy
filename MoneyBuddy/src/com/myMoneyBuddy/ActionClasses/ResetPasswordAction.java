/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.UpdateOldPassword;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerPassword;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class ResetPasswordAction extends ActionSupport implements SessionAware {
	
	Logger logger = Logger.getLogger(ResetPasswordAction.class);
    private String emailId;
    private String hashedPassword;
    private String newPassword;
    private String confirmPassword;

    HttpServletRequest request;

    QueryCustomer user = new QueryCustomer();

    private SessionMap<String, Object> sessionMap;
    private InputStream stream;
    
    /*@Override
    public void validate()  {
    	logger.debug("ResetPasswordAction class : validate method : start");

    	if(StringUtils.isEmpty(getNewPassword())  )
    		addFieldError("newPassword","Password can't be blank!");

    	else if(StringUtils.isEmpty(getConfirmPassword())  )
    		addFieldError("confirmPassword","Password can't be blank!");
    	else if(!getNewPassword().equals(getConfirmPassword())  )
    		addFieldError("confirmPassword","The Password do not match.");

    	logger.debug("ResetPasswordAction class : validate method : end");
    }*/

    @Override
    public String execute() {
        
    	try {
    	
    	logger.debug("ResetPasswordAction class : execute method : start");

    	//Set the current password as the old password
    	QueryCustomer customer = new QueryCustomer();
    	int customerId = customer.getCustomerId(getEmailId());
    	UpdateOldPassword updateOldPassword = new UpdateOldPassword();
    	updateOldPassword.updateOldPassword(Integer.toString(customerId));

    	//Update the password for the user
    	UpdateCustomerPassword updateUserPassword = new UpdateCustomerPassword();
    	updateUserPassword.updatePassword(Integer.toString(customerId), getEmailId(), getNewPassword());

    	logger.debug("ResetPasswordAction class : execute method : end");
    	String str = "success";
	    stream = new ByteArrayInputStream(str.getBytes());
	    if(sessionMap!=null){  
            sessionMap.invalidate();  
        } 

    	return SUCCESS;
    	}catch (MoneyBuddyException e) {	
    		logger.debug("ResetPasswordAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.debug("ResetPasswordAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		}
    }
 
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = (SessionMap)sessionMap;
    }
    
    public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
        
	public HttpServletRequest getServletRequest() {
		return this.request;
	}
    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
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

/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerPassword;
import com.myMoneyBuddy.DAOClasses.UpdateOldPassword;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport implements SessionAware {
	
	Logger logger = LogManager.getLogger(ResetPasswordAction.class);
    private String emailId;
    private String hashedPassword;
    private String newPassword;
    private SessionMap<String,Object> sessionMap;
    //private InputStream stream;

    @Override
    public String execute() {
        
    	String customerId = null;
    	
    	try {

	    	QueryCustomer customer = new QueryCustomer();
    		customerId = Integer.toString(customer.getCustomerId(getEmailId()));
    		
    		logger.debug("ResetPasswordAction class - execute method - customerId - "+customerId+" - start ");
	
	    	//Set the current password as the old password
	    	
	    	UpdateOldPassword updateOldPassword = new UpdateOldPassword();
	    	updateOldPassword.updateOldPassword(customerId);
	
	    	//Update the password for the user
	    	UpdateCustomerPassword updateUserPassword = new UpdateCustomerPassword();
	    	updateUserPassword.updatePassword(customerId, getEmailId(), getNewPassword());

		    if(sessionMap!=null){  
	            sessionMap.invalidate();  
	        } 
		    
		    
		    sessionMap.put("name", emailId);
	    	/*String str = "success";
		    stream = new ByteArrayInputStream(str.getBytes());*/
		    logger.debug("ResetPasswordAction class - execute method - customerId - "+customerId+" - returned success");
		    logger.debug("ResetPasswordAction class - execute method - customerId - "+customerId+" - end ");
		    
	    	return SUCCESS;
	    	
    	}catch (MoneyBuddyException e) {	
    		logger.error("ResetPasswordAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    		/*String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
    	    logger.error("ResetPasswordAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
		} 
    	catch (Exception e) {	
    		logger.error("ResetPasswordAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    		/*String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
    	    logger.error("ResetPasswordAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
		}
    }
 
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
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
/*
	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}*/

}

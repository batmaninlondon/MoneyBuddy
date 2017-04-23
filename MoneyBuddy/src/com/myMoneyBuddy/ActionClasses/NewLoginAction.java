/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.mailerClasses.DesEncrypter;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryCustomerPortfolio;
import com.myMoneyBuddy.DAOClasses.UpdateCurrentLoginTimestamp;
import com.myMoneyBuddy.DAOClasses.UpdateLastLoginTimestamp;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;


public class NewLoginAction extends ActionSupport implements SessionAware {
	
	Logger logger = Logger.getLogger(NewLoginAction.class);
	private Map<String, Object> sessionMap;
	
    private String emailId;
    private String password;

    QueryCustomer customer = new QueryCustomer();

    private List<String> groupNamesList = new ArrayList<String>();  
    
    private InputStream stream;
    
    /*public void validate() {
    	logger.debug("NewLoginAction class : validate method : start");
        if(StringUtils.isEmpty(getEmailId()) )  {
        	System.out.println(" Email id is null " );
        	String str = "EmailNull";
    	    stream = new ByteArrayInputStream(str.getBytes());
        	 addFieldError("emailId","Email Id can't be blank!");
             
        }
           
        else if (!customer.existsCustomer(getEmailId()))
            addFieldError("emailId"," Email does not exists.");

        else if ( StringUtils.isEmpty(getPassword()))
            addFieldError("password","Password can't be blank");
        else if(!(new DesEncrypter(getEmailId())).decrypt(customer.getPassword(getEmailId())).equals(getPassword())) {
            addFieldError("emailId"," Email Id and password doesn't match.");
        }
        logger.debug("NewLoginAction class : validate method : end");
    }*/
    public String execute() {
    	try {
    		
	    	logger.debug("NewLoginAction class : execute method : start");
	    	System.out.println("Start - NewLoginAction execute method ");
	    	if (!customer.existsCustomer(getEmailId())) {
	    		System.out.println("Verification not done for this email id ");
	    		logger.debug("NewLoginAction class : execute method : Email Id does not exists "+getEmailId());
	    		String str = "emailIdDoesNotExists";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    		return SUCCESS;
	    	}
	    	if(!(new DesEncrypter(getEmailId())).decrypt(customer.getPassword(getEmailId())).equals(getPassword())) {
	    		System.out.println("incorrectPassword ");
	    		logger.debug("NewLoginAction class : execute method : incorrectPassword for "+getEmailId());
	    		String str = "incorrectPassword";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    		return SUCCESS;
	        }
	    	if (customer.getVerificationStatus(getEmailId()).equalsIgnoreCase("NO"))  {
	    		System.out.println("Verification not done for this email id ");
	    		logger.debug("NewLoginAction class : execute method : verification is not done for "+getEmailId());
	    		String str = "verificationNotDone";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    		return SUCCESS;
	    	}
	    	
	
	    	System.out.println("Hi there 1  ");
	    	QueryCustomer queryCustomer = new QueryCustomer();
	    	System.out.println("Hi there 2  ");
	    	String customerId = queryCustomer.getCustomerId(getEmailId());
	    	String customerName = queryCustomer.getCustomerName(getEmailId());
	    	String customerMobileNumber = queryCustomer.getCustomerMobileNumber(getEmailId());
	
	    	System.out.println("Hi there 3  customerId : "+customerId);
	    	sessionMap.put("customerId", customerId);
	    	
	    	logger.debug("LoginAction class : execute method : stored customerId : "+customerId+" in session id : "+sessionMap.getClass().getName());
	    	
	    	sessionMap.put("customerName", customerName);
	    	logger.debug("LoginAction class : execute method : stored customerName : "+customerName+" in session id : "+sessionMap.getClass().getName());
	    	
	    	sessionMap.put("customerMobileNumber", customerMobileNumber);
	    	logger.debug("LoginAction class : execute method : stored customerMobileNumber : "+customerMobileNumber+" in session id : "+sessionMap.getClass().getName());
	    	
	    	System.out.println("Hi there 4  ");
	    	// Updating Last login timestamp
	    	UpdateLastLoginTimestamp lastLogin = new UpdateLastLoginTimestamp();
	    	lastLogin.updateLastLoginTimestamp(customerId);
	
	    	System.out.println("Hi there 5  ");
	    	// Update Current login timestamp
	    	UpdateCurrentLoginTimestamp currentLogin = new UpdateCurrentLoginTimestamp();
	    	currentLogin.updateCurrentLoginTimestamp(customerId);
	
	    	System.out.println("emailId : "+getEmailId());
	    	sessionMap.put("emailId", getEmailId());
	    	logger.debug("NewLoginAction class : execute method : stored emailId : "+emailId+" in session id : "+sessionMap.getClass().getName());
	    	
	    	DesEncrypter desEncrypter = new DesEncrypter(getEmailId());
	    	String hashedPassword = desEncrypter.encrypt(getPassword());
	    	System.out.println("hashedPassword : "+hashedPassword);
	    	sessionMap.put("hashedPassword", hashedPassword);
	    	logger.debug("NewLoginAction class : execute method : stored hashedPassword : "+hashedPassword+" in session id : "+sessionMap.getClass().getName());
	    	
	    	QueryCustomerPortfolio queryCustomerPortfolio = new QueryCustomerPortfolio();
	    	groupNamesList = (ArrayList)queryCustomerPortfolio.getGroupNameList(customerId);
	    	
	    	sessionMap.put("groupNamesList", groupNamesList);
	    	logger.debug("NewLoginAction class : execute method : stored groupNamesList in session id : "+sessionMap.getClass().getName());
	    
	    	
	    	logger.debug("NewLoginAction class : execute method : end");
	    	
	    	String str = "success";
		    stream = new ByteArrayInputStream(str.getBytes());
	    	return SUCCESS;
	    	
    	}catch (MoneyBuddyException e) {	
    		logger.debug("NewLoginAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.debug("NewLoginAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
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

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
	public List<String> getGroupNamesList() {
		return groupNamesList;
	}
	public void setGroupNamesList(List<String> groupNamesList) {
		this.groupNamesList = groupNamesList;
	}

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}
	

}

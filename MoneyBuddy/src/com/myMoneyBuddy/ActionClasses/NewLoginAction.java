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
import com.myMoneyBuddy.DAOClasses.UpdateLoginTimestamp;
import com.myMoneyBuddy.EntityClasses.Customers;
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
    private String login;

    QueryCustomer queryCustomer = new QueryCustomer();

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
    		
    		
    		Customers customer = queryCustomer.getCustomer(getEmailId());
	    	logger.debug("NewLoginAction class : execute method : start");
	    	//System.out.println("Start - NewLoginAction execute method ");
	    	if (customer == null) {
	    		System.out.println("Emaid id not valid ");
	    		logger.debug("NewLoginAction class : execute method : Email Id does not exists "+getEmailId());
	    		String str = "emailIdDoesNotExists";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    		return SUCCESS;
	    	}
	    	if(!(new DesEncrypter(getEmailId())).decrypt(queryCustomer.getPassword(getEmailId())).equals(getPassword())) {
	    		String pswd = new DesEncrypter(getEmailId()).decrypt(queryCustomer.getPassword(getEmailId()));
	    		System.out.println("VALUE OF PASSWORD IS : "+pswd);
	    		
	    		System.out.println("incorrectPassword ");
	    		logger.debug("NewLoginAction class : execute method : incorrectPassword for "+getEmailId());
	    		String str = "incorrectPassword";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    		return SUCCESS;
	        }
	    	if (customer.getVerificationStatus().equalsIgnoreCase("N"))  {
	    		System.out.println("Verification not done for this email id ");
	    		logger.debug("NewLoginAction class : execute method : verification is not done for "+getEmailId());
	    		String str = "verificationNotDone";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    		return SUCCESS;
	    	}
	    	
	    	
	
	    	//System.out.println("Hi there 1  ");
	    	//QueryCustomer queryCustomer = new QueryCustomer();
	    	//System.out.println("Hi there 2  ");
	    	int customerId = Integer.parseInt(customer.getCustomerId());
	    	String customerName = customer.getCustomerName();
	    	String customerMobileNumber = customer.getMobileNumber();
	
	    	System.out.println("customerId : "+customerId);
	    	sessionMap.put("customerId", Integer.toString(customerId));
	    	
	    	logger.debug("LoginAction class : execute method : stored customerId : "+customerId+" in session id : "+sessionMap.getClass().getName());
	    	
	    	sessionMap.put("customerName", customerName);
	    	logger.debug("LoginAction class : execute method : stored customerName : "+customerName+" in session id : "+sessionMap.getClass().getName());
	    	
	    	sessionMap.put("customerMobileNumber", customerMobileNumber);
	    	logger.debug("LoginAction class : execute method : stored customerMobileNumber : "+customerMobileNumber+" in session id : "+sessionMap.getClass().getName());
	    	
	    	//System.out.println("Hi there 4  ");
	    	// Updating Last login timestamp
	    	UpdateLoginTimestamp lastLogin = new UpdateLoginTimestamp();
	    	lastLogin.updateLoginTimestamp(Integer.toString(customerId));
	
	    	//System.out.println("Hi there 5  ");
	    	// Update Current login timestamp
	    	/*UpdateCurrentLoginTimestamp currentLogin = new UpdateCurrentLoginTimestamp();
	    	currentLogin.updateCurrentLoginTimestamp(Integer.toString(customerId));*/
	
	    	System.out.println("emailId : "+getEmailId());
	    	sessionMap.put("emailId", getEmailId());
	    	logger.debug("NewLoginAction class : execute method : stored emailId : "+emailId+" in session id : "+sessionMap.getClass().getName());
	    	
	    	DesEncrypter desEncrypter = new DesEncrypter(getEmailId());
	    	String hashedPassword = desEncrypter.encrypt(getPassword());
	    	//System.out.println("hashedPassword : "+hashedPassword);
	    	sessionMap.put("hashedPassword", hashedPassword);
	    	logger.debug("NewLoginAction class : execute method : stored hashedPassword : "+hashedPassword+" in session id : "+sessionMap.getClass().getName());
	    	
	    	QueryCustomerPortfolio queryCustomerPortfolio = new QueryCustomerPortfolio();
	    	groupNamesList = (ArrayList)queryCustomerPortfolio.getGroupNameList(Integer.toString(customerId));
	    	
	    	sessionMap.put("groupNamesList", groupNamesList);
	    	logger.debug("NewLoginAction class : execute method : stored groupNamesList in session id : "+sessionMap.getClass().getName());
	    	
	    	if ("loopedLogin".equals(getLogin())) {
		    	if (customer.getKycStatus().equalsIgnoreCase("DONE"))  {
		    		System.out.println("KYC is done for this customer ");
		    		logger.debug("NewLoginAction class : execute method : kyc is done for "+getEmailId());
		    		String str = "kycAlreadyDone";
		    	    stream = new ByteArrayInputStream(str.getBytes());
		    		return SUCCESS;
		    	}
	    	}
	    	
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
   
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

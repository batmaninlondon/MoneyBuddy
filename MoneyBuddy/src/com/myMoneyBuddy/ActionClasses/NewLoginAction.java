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
import com.myMoneyBuddy.DAOClasses.UpdateLoginTimestamp;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.MbUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class NewLoginAction extends ActionSupport implements SessionAware {
	
	Logger logger = Logger.getLogger(NewLoginAction.class);
	private SessionMap<String,Object> sessionMap;	
    private String emailId;
    private String password;
    private String googleResponse;
    private InputStream stream;

    public String execute() {
    	
    	String str = null;
    	String customerId = null;
    	try {
    		
    		logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - start");
    		QueryCustomer queryCustomer = new QueryCustomer(); 
    		Customers customer = queryCustomer.getCustomerFromEmailId(getEmailId());
    		if (customer != null ) 
    			customerId = customer.getCustomerId();
	    	
	    	
	    	MbUtil mbUtil = new MbUtil();
	    	if(!mbUtil.isCaptchaValid(getGoogleResponse()))
	    	{
	    		String strMsg = "Lookslikeyouarearobot";
	    	    stream = new ByteArrayInputStream(strMsg.getBytes());
	    	    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned Lookslikeyouarearobot");
		    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
	    	    
	    	    return SUCCESS;
	    	}
	    	if (customer == null) {
	    		System.out.println("Emaid id not valid ");
	    		str = "emailIdDoesNotExists";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    	    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned emailIdDoesNotExists");
		    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
	    	    
	    		return SUCCESS;
	    	}
	    	if(!(new DesEncrypter(getEmailId())).decrypt(queryCustomer.getPassword(getEmailId())).equals(getPassword())) {
	    		String pswd = new DesEncrypter(getEmailId()).decrypt(queryCustomer.getPassword(getEmailId()));
	    		System.out.println("VALUE OF PASSWORD IS : "+pswd);
	    		
	    		System.out.println("incorrectPassword ");
	    		str = "incorrectPassword";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    	    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned incorrectPassword");
		    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
		    	
	    		return SUCCESS;
	        }
	    	if (customer.getVerificationStatus().equalsIgnoreCase("N"))  {
	    		System.out.println("Verification not done for this email id ");
	    		str = "verificationNotDone";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    	    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned verificationNotDone");
		    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
		    	
	    		return SUCCESS;
	    	}
	    	
	    	String custDetUploaded = customer.getCusDetailsUploaded();
	    	String addCustDetUploaded = customer.getAddCusDetailsUploaded();
	    	
	    	System.out.println("customerId : "+customerId);
	    	
	    	sessionMap.put("customerId", customerId);
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored customerId in sessionMap");
	    	
	    	sessionMap.put("customerName", customer.getCustomerName());
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored customerName in sessionMap");
	    	
	    	sessionMap.put("customerMobileNumber", customer.getMobileNumber());
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored customerMobileNumber in sessionMap");
	    	
	    	sessionMap.put("panCard", customer.getPanCard());
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored panCard in sessionMap");
	    	
	    	sessionMap.put("kycStatus", customer.getKycStatus());
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored kycStatus in sessionMap");
	    	
	    	if (custDetUploaded == null )  
	    		custDetUploaded = "N";
	    	else 
	    		custDetUploaded = "Y";
	    	
	    	sessionMap.put("custDetUploaded", custDetUploaded);
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored custDetUploaded in sessionMap");
	    	
	    	if (addCustDetUploaded == null )  
	    		addCustDetUploaded = "N";
	    	else 
	    		addCustDetUploaded = "Y";
	    		
	    	sessionMap.put("addCustDetUploaded", addCustDetUploaded);
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored addCustDetUploaded in sessionMap");
	    	
	    	System.out.println("kycStaus in session : "+sessionMap.get("kycStatus"));
	    	System.out.println("custDetUploaded in session : "+sessionMap.get("custDetUploaded"));
	    	System.out.println("addCustDetUploaded in session : "+sessionMap.get("addCustDetUploaded"));

	    	UpdateLoginTimestamp lastLogin = new UpdateLoginTimestamp();
	    	lastLogin.updateLoginTimestamp(customerId);

	    	System.out.println("emailId : "+getEmailId());
	    	sessionMap.put("emailId", getEmailId());
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored emailId in sessionMap");
	    	
	    	DesEncrypter desEncrypter = new DesEncrypter(getEmailId());
	    	String hashedPassword = desEncrypter.encrypt(getPassword());

	    	sessionMap.put("hashedPassword", hashedPassword);
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored hashedPassword in sessionMap");
	    	
	    	System.out.println("value of fundSelected from seesion : "+sessionMap.get("fundSelected"));
	    	
	    	System.out.println("Value of session variale OnetimeInvestment : "+ sessionMap.get("OnetimeInvestment"));
	    	if ("TRUE".equals(sessionMap.get("fundSelected"))) {

	    		if ("TRUE".equals(sessionMap.get("OnetimeInvestment"))) {
	    			System.out.println("fundOnetimeSelected");
		    		str = "fundOnetimeSelected";
		    		stream = new ByteArrayInputStream(str.getBytes());
		    		logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned fundOnetimeSelected");
			    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
			    	
			    	return SUCCESS;
		    	}
	    		else {
	    			System.out.println("fundSIPSelected ... ");
	    			str = "fundSIPSelected";
		    		stream = new ByteArrayInputStream(str.getBytes());
		    		logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned fundSIPSelected");
			    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
			    	
			    	return SUCCESS;
	    		}
	    	}
	    	
	    	str = "success";
		    stream = new ByteArrayInputStream(str.getBytes());
		    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
	    	
	    	return SUCCESS;
	    	
    	}catch (MoneyBuddyException e) {	
    		logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - Caught MoneyBuddyException");
    		e.printStackTrace();
    		
    		str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
		} 
    	catch (Exception e) {	
    		logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    		str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
		}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
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

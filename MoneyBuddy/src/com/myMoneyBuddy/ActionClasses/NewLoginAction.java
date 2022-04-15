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

import com.myMoneyBuddy.DAOClasses.InsertCustomerDetails;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryTransactionDetails;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerRedemptionCart;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerStpCart;
import com.myMoneyBuddy.DAOClasses.UpdateLoginTimestamp;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.DesEncrypter;
import com.myMoneyBuddy.Utils.MbUtil;
import com.opensymphony.xwork2.ActionSupport;

public class NewLoginAction extends ActionSupport implements SessionAware {
	
	Logger logger = LogManager.getLogger(NewLoginAction.class);
	private SessionMap<String,Object> sessionMap;	
    private String emailIdLogin;
    private String passwordLogin;
    private String googleResponseLogin;
    private String transactionType;
    private String googleLogin;
    //private InputStream stream;

    public String execute() {

    	String customerId = null;
    	try {
    		
    		System.out.println("googleLogin in NewLoginAction is : "+getGoogleLogin());
    		/*System.out.println("passwordLogin in NewLoginAction is : "+getPasswordLogin());*/
    		System.out.println("googleResponse : "+getGoogleResponseLogin());
    		logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - start");
    		QueryCustomer queryCustomer = new QueryCustomer(); 
    		Customers customer = queryCustomer.getCustomerFromEmailId(getEmailIdLogin());
    		
    		
    		
    		if (customer != null ) {
    			customerId = customer.getCustomerId();
    			System.out.println("customerId : "+customerId);
    			
    		}
	    	
	    	
	    	MbUtil mbUtil = new MbUtil();
	    	if(!mbUtil.isCaptchaValid(getGoogleResponseLogin()))
	    	{
	    		System.out.println("Looks like you are a robot...... ");
	    		addActionMessage("Looks like you are a robot.");
	    	    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned Lookslikeyouarearobot");
		    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
	    	    
	    	    return INPUT;
	    	}
	    	
	    	if (customer == null) {
	    		if ("GoogleLogin".equals(getGoogleLogin()))   {
	    			InsertCustomerDetails newCustomer = new InsertCustomerDetails();
	    			customerId = newCustomer.insertCustomer(getEmailIdLogin());
	    			newCustomer.updateVerificationStatus(customerId);
	    			customer = queryCustomer.getCustomerFromEmailId(getEmailIdLogin());
	    		}
	    		
	    		else {
		    		System.out.println("Emaid id not valid ");
		    		addActionMessage("This email ID is not registered, please sign up to use MoneyBuddy");
		    	    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned emailIdDoesNotExists");
			    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
		    	    
		    		return INPUT;
	    		}
	    	}
	    	
	    	if (!"GoogleLogin".equals(getGoogleLogin()))  {
	    	
	    	  
	    	if (null == queryCustomer.getPassword(getEmailIdLogin()))  {
	    		System.out.println("null password  ");
	    		addActionMessage("Incorrect Password, Please enter correct password");
	    	    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned incorrectPassword");
		    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
		    	
	    		return INPUT;
	    	}
	        String decrypted = DesEncrypter.MONEYBUDDY.decrypt(queryCustomer.getPassword(getEmailIdLogin()));
	    	int len = customerId.length();
	    	
	    	String decryptedPswd = decrypted.substring(len);
	    	if(! decryptedPswd.equals(getPasswordLogin())) {
	    		
	    		System.out.println("incorrectPassword ");
	    		addActionMessage("Incorrect Password, Please enter correct password");
	    	    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned incorrectPassword");
		    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
		    	
	    		return INPUT;
	        }
	    	}
	    	if (customer.getVerificationStatus().equalsIgnoreCase("N"))  {
	    		System.out.println("Verification not done for this email id ");
	    		addActionMessage("Verification pending for this Email Id.");
	    	    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned verificationNotDone");
		    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
		    	
	    		return INPUT;
	    	}
	    	
	    	
	    	if ("ADMIN".equals(customer.getUserType()))  {
	    		
	    		sessionMap.put("customerId", customerId);
	    		return "adminLogin";
	    	}
	    
	    	UpdateCustomerRedemptionCart updateCustomerRedemptionCart = new UpdateCustomerRedemptionCart();
    		updateCustomerRedemptionCart.emptyCustomerRedCart(customerId);
	    	
    		UpdateCustomerStpCart  updateCustomerStpCart = new UpdateCustomerStpCart();
    		updateCustomerStpCart.emptyCustomerStpCart(customerId);
    		
	    	sessionMap.put("customerId", customerId);
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored customerId in sessionMap");
	    	
	    	
	    	sessionMap.put("customerName", customer.getCustomerName());
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored customerName in sessionMap");
	    	
	    	sessionMap.put("customerMobileNumber", customer.getMobileNumber());
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored customerMobileNumber in sessionMap");

	    	UpdateLoginTimestamp lastLogin = new UpdateLoginTimestamp();
	    	lastLogin.updateLoginTimestamp(customerId);

	    	System.out.println("emailId : "+getEmailIdLogin());
	    	sessionMap.put("emailId", getEmailIdLogin());
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored emailId in sessionMap");
	    	
	    	DesEncrypter desEncrypter = new DesEncrypter();
	    	String hashedPassword = desEncrypter.encrypt(getEmailIdLogin());

	    	sessionMap.put("hashedPassword", hashedPassword);
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored hashedPassword in sessionMap");
	    	
	    	if ("FORM_SENT".equals(customer.getAofFormStatus()))  {
	    		return "aofFormSent";
	    	}
	    	
	    	QueryCustomerCart queryCustomerCart = new QueryCustomerCart();
	    	
	    	if (queryCustomerCart.cartExists(customerId)) {
	    		return "customerCartExists";
	    	}
	    	
	    	QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
	    	
	    	if (queryTransactionDetails.haveInvestments(customerId))  {
	    		return "haveInvestment";
	    	}
	    	
		    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
	    	
	    	return SUCCESS;
	    	
    	}catch (MoneyBuddyException e) {	
    		logger.error("NewLoginAction class - execute method - customerId - "+customerId+" - Caught MoneyBuddyException");
    		e.printStackTrace();

    	    logger.error("NewLoginAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
		} 
    	catch (Exception e) {	
    		logger.error("NewLoginAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();

    	    logger.error("NewLoginAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
		}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

    public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}

	public String getEmailIdLogin() {
		return emailIdLogin;
	}

	public void setEmailIdLogin(String emailIdLogin) {
		this.emailIdLogin = emailIdLogin;
	}

	public String getGoogleResponseLogin() {
		return googleResponseLogin;
	}

	public void setGoogleResponseLogin(String googleResponseLogin) {
		this.googleResponseLogin = googleResponseLogin;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getGoogleLogin() {
		return googleLogin;
	}

	public void setGoogleLogin(String googleLogin) {
		this.googleLogin = googleLogin;
	}	

}

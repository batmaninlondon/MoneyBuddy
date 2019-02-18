/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.util.HashMap;
import java.util.Map;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryTransactionDetails;
import com.myMoneyBuddy.DAOClasses.UpdateLoginTimestamp;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.myMoneyBuddy.Utils.DesEncrypter;
import com.myMoneyBuddy.Utils.MbUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class NewLoginAction extends ActionSupport implements SessionAware {
	
	Logger logger = Logger.getLogger(NewLoginAction.class);
	private SessionMap<String,Object> sessionMap;	
    private String emailIdLogin;
    private String passwordLogin;
    private String googleResponseLogin;
    //private InputStream stream;

    public String execute() {

    	String customerId = null;
    	try {
    		System.out.println("googleResponse : "+getGoogleResponseLogin());
    		logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - start");
    		QueryCustomer queryCustomer = new QueryCustomer(); 
    		Customers customer = queryCustomer.getCustomerFromEmailId(getEmailIdLogin());
    		if (customer != null ) {
    			customerId = customer.getCustomerId();
    			System.out.println("customerId : "+customerId);
    		}
	    	
	    	
	    	MbUtil mbUtil = new MbUtil();
	    	/*if(!mbUtil.isCaptchaValid(getGoogleResponseLogin()))
	    	{
	    		System.out.println("Looks like you are a robot. ");
	    		String strMsg = "Lookslikeyouarearobot";
	    	    stream = new ByteArrayInputStream(strMsg.getBytes());
	    		addActionMessage("Looks like you are a robot.");
	    	    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned Lookslikeyouarearobot");
		    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
	    	    
	    	    return INPUT;
	    	}*/
	    	if (customer == null) {
	    		System.out.println("Emaid id not valid ");
	    		/*str = "emailIdDoesNotExists";
	    	    stream = new ByteArrayInputStream(str.getBytes());*/
	    		addActionMessage(getEmailIdLogin()+"is not registered with MoneyBuddy.");
	    	    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned emailIdDoesNotExists");
		    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
	    	    
	    		return INPUT;
	    	}
	    	if(!(new DesEncrypter()).decrypt(queryCustomer.getPassword(getEmailIdLogin())).equals(getPasswordLogin())) {
	    		String pswd = new DesEncrypter().decrypt(queryCustomer.getPassword(getEmailIdLogin()));
	    		System.out.println("VALUE OF PASSWORD IS : "+pswd);
	    		
	    		System.out.println("incorrectPassword ");
	    		/*str = "incorrectPassword";
	    	    stream = new ByteArrayInputStream(str.getBytes());*/
	    		addActionMessage("EmailId and Password does not match.");
	    	    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned incorrectPassword");
		    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
		    	
	    		return INPUT;
	        }
	    	if (customer.getVerificationStatus().equalsIgnoreCase("N"))  {
	    		System.out.println("Verification not done for this email id ");
	    		/*str = "verificationNotDone";
	    	    stream = new ByteArrayInputStream(str.getBytes());*/
	    		addActionMessage("Verification pending for this Email Id.");
	    	    logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned verificationNotDone");
		    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
		    	
	    		return INPUT;
	    	}
	    	
	    	
	    	if ("ADMIN".equals(customer.getUserType()))  {
	    		return "adminLogin";
	    	}
	    	//String custDetUploaded = customer.getCusDetailsUploaded();
	    	//String addCustDetUploaded = customer.getAddCusDetailsUploaded();
	    	
	    	System.out.println("customerId : "+customerId);
	    	
	    	sessionMap.put("customerId", customerId);
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored customerId in sessionMap");
	    	
	    	sessionMap.put("customerName", customer.getCustomerName());
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored customerName in sessionMap");
	    	
	    	sessionMap.put("customerMobileNumber", customer.getMobileNumber());
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored customerMobileNumber in sessionMap");
	    	
	    	/*sessionMap.put("panCard", customer.getPanCard());
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored panCard in sessionMap");*/
	    	
	    	/*sessionMap.put("kycStatus", customer.getKycStatus());
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored kycStatus in sessionMap");
	    	*/
	    	/*if (custDetUploaded == null || "N".equals(custDetUploaded))  
	    		custDetUploaded = "N";
	    	else 
	    		custDetUploaded = "Y";
	    	
	    	sessionMap.put("custDetUploaded", custDetUploaded);
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored custDetUploaded in sessionMap");
	    	*/
	    	/*if (addCustDetUploaded == null || "N".equals(addCustDetUploaded))  
	    		addCustDetUploaded = "N";
	    	else 
	    		addCustDetUploaded = "Y";
	    		
	    	sessionMap.put("addCustDetUploaded", addCustDetUploaded);
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored addCustDetUploaded in sessionMap");*/
	    	
	    	//System.out.println("kycStaus in session : "+sessionMap.get("kycStatus"));
	    	/*System.out.println("custDetUploaded in session : "+sessionMap.get("custDetUploaded"));*/
	    	/*System.out.println("addCustDetUploaded in session : "+sessionMap.get("addCustDetUploaded"));*/

	    	UpdateLoginTimestamp lastLogin = new UpdateLoginTimestamp();
	    	lastLogin.updateLoginTimestamp(customerId);

	    	System.out.println("emailId : "+getEmailIdLogin());
	    	sessionMap.put("emailId", getEmailIdLogin());
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored emailId in sessionMap");
	    	
	    	DesEncrypter desEncrypter = new DesEncrypter();
	    	String hashedPassword = desEncrypter.encrypt(getPasswordLogin());

	    	sessionMap.put("hashedPassword", hashedPassword);
	    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - stored hashedPassword in sessionMap");
	    	
	    	//System.out.println("value of fundSelected from seesion : "+sessionMap.get("fundSelected"));
	    	
	    	System.out.println("Value of session variale OnetimeInvestment : "+ sessionMap.get("OnetimeInvestment"));
	    	if ("TRUE".equals(sessionMap.get("fundSelected"))) {

/*	    		if ("TRUE".equals(sessionMap.get("OnetimeInvestment"))) {
	    			System.out.println("fundOnetimeSelected");
		    		str = "fundOnetimeSelected";
		    		stream = new ByteArrayInputStream(str.getBytes());
		    		logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned fundOnetimeSelected");
			    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
			    	
			    	return "fundOnetimeSelected";
		    	}
	    		else {
	    			System.out.println("fundSIPSelected ... ");
	    			str = "fundSIPSelected";
		    		stream = new ByteArrayInputStream(str.getBytes());
		    		logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - returned fundSIPSelected");
			    	logger.debug("NewLoginAction class - execute method - customerId - "+customerId+" - end");
			    	
			    	return "fundSIPSelected";
	    		}*/
	    		
	    		
	    		if (sessionMap.get("FolioNumList") == null || "undefined".equals(sessionMap.get("FolioNumList")))  {
	    			System.out.println("sessionMap.get FolioNumList is NULL");
	    			FundDetailsDataModel fundDetailsDataModel =  (FundDetailsDataModel)sessionMap.get("selectedFundDetailsDataModel");
	    			
	    			QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
	    			String folioNumList = queryTransactionDetails.getFolioNumsList(customerId, fundDetailsDataModel.getFundId());
	    			sessionMap.put("FolioNumList", folioNumList);
	    		}
	    		else {
	    			System.out.println("sessionMap.get FolioNumList :"+sessionMap.get("FolioNumList").toString()+":");
	    		}
	    		return "fundSelected";
	    	}
	    	
	    	QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
	    	
	    	if (queryTransactionDetails.haveInvestments(customerId))  {
	    		return "haveInvestment";
	    	}
	    	/*str = "success";
		    stream = new ByteArrayInputStream(str.getBytes());*/
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

/*	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}*/
	

}

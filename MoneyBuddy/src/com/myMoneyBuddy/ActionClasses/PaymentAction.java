/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Session;
import javax.ws.rs.core.Request;

import com.myMoneyBuddy.DAOClasses.QueryCustomerPortfolio;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.insertCustomerAccountDetails;
import com.myMoneyBuddy.EntityClasses.Transactions;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.mailerClasses.sendMail;
import com.myMoneyBuddy.webServices.WebServiceMFOrder;
import com.myMoneyBuddy.webServices.WebServiceStarMF;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.tempuri.IStarMFWebService;
import org.tempuri.MFOrderEntry;


public class PaymentAction extends ActionSupport implements SessionAware {

	Logger logger = Logger.getLogger(PaymentAction.class);
	private SessionMap<String, Object> sessionMap;
	
	private String clientHolding;
	private String taxStatus;
	private String occupationName;
	private String genderType;
	private String dateOfBirth;
	private String accountType;
	private String residentialAddress;
	private String accountNumber;
	private String residentialCity;
	private String neftCode;
	private String residentialState;
	private String residentialPin;
	private String residentialCountry;
	private String groupName;
	
	private InputStream stream;
	private List<String> groupNamesList = new ArrayList<String>(); 
    
/*    public void validate() {
    	
    	System.out.println("Payment Action : bankName : "+getBankName());
    	System.out.println("Payment Action : accountNumber : "+getAccountNumber());
    	System.out.println("Payment Action : accountPassword : "+getAccountPassword());
    	System.out.println("Payment Action : cvvNumber : "+getCvvNumber());
    	System.out.println("Payment Action : groupName : "+getGroupName());
    	
    	logger.debug("PaymentAction class : validate method : start");
    	
    	if(StringUtils.isEmpty(getAccountNumber()) )
            addFieldError("accountNumber","Account Number can't be blank!");
        else if ( StringUtils.isEmpty(getAccountPassword()))
            addFieldError("accountPassword","Account Password can't be blank");
        else if ( StringUtils.isEmpty(getCvvNumber()))
            addFieldError("cvvNumber","CVV Number can't be blank");
        else if ( customerPortfolio.existsGroupName(getGroupName())) {
        	System.out.println("Payment Action : Group Name already exists. Please choose a different group Name : "+getGroupName());
            addFieldError("groupName","Group Name already exists. Please choose a different group Name");
        }
    	
    	logger.debug("PaymentAction class : validate method : end");
    }*/
    
    public String execute()  {

    	try {
    		
    		System.out.println("Payment Action class : execute method : transactionType : "+sessionMap.get("transactionType").toString());
    		
    		QueryCustomerPortfolio customerPortfolio = new QueryCustomerPortfolio();
	    	String subject ;
	    	sendMail sendmail = new sendMail();
	    	StringBuilder bodyText = new StringBuilder();
	    	String MAIL_SITE_LINK = "www.quantwealth.in/login";
    	
    	
	    	//System.out.println("Inside payment execute mehtod - start ");
    	
	    	if ( customerPortfolio.existsGroupName(getGroupName())) {
	        	System.out.println("Payment Action : Group Name already exists. Please choose a different group Name : "+getGroupName());
	        	String str = "groupNameAlreadyExists";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    		return SUCCESS;
	            
	        }

			/*String CLIENT_HOLDING = ; // Considering Single account
			String CLIENT_TAXSTATUS = getTaxStatus(); // Considering Individual
			String CLIENT_OCCUPATIONCODE = getOccupationName(); // will take from Client
			String CLIENT_DOB = getDateOfBirth(); // will take from Client
			String CLIENT_GENDER = getGenderType(); // will take from Client
			String CLIENT_GUARDIAN = ""; // considering, it is not on behalf of minor
			String CLIENT_ACCTYPE_1 = getAccountType(); // will take from Client
			String CLIENT_ACCNO_1 = getAccountNumber(); // will take from Client
			String CLIENT_NEFT_IFSCCODE_1 = getNeftCode(); // will take from Client
			String CLIENT_ADD_1 = getResidentialAddress();  // will take from Client
			String CLIENT_CITY = getResidentialCity(); // will take from Client
			String CLIENT_STATE = getResidentialState(); // will take from Client
			String CLIENT_PINCODE = getResidentialPin(); // will take from Client
			String CLIENT_COUNTRY = getResidentialCountry(); // will take from Client
*/			
	    	
	    	String customerId;
			String CLIENT_EMAIL;
			String CLIENT_APPNAME1;
			
			String CLIENT_PAN;
			String CLIENT_CM_MOBILE;
			
			
		    customerId = sessionMap.get("customerId").toString();
	    	//System.out.println("CLIENT_CODE/customerId : "+customerId);
	    	
	    	CLIENT_APPNAME1 = sessionMap.get("customerName").toString();
	    	//System.out.println("CLIENT_APPNAME1 : "+CLIENT_APPNAME1);
	    	
	    	CLIENT_EMAIL = sessionMap.get("emailId").toString();
	    	//System.out.println("CLIENT_EMAIL : "+CLIENT_EMAIL);

	    	
	    	CLIENT_PAN = sessionMap.get("panCard").toString();
	    	//System.out.println("CLIENT_PAN : "+CLIENT_PAN);
	    	
	    	CLIENT_CM_MOBILE = sessionMap.get("customerMobileNumber").toString();
	    	//System.out.println("CLIENT_CM_MOBILE : "+CLIENT_CM_MOBILE);

	    	QueryProducts queryProducts = new QueryProducts();
	    	Map<String, Double> productDetailsMapForBuy;
    	
	    	sessionMap.put("groupName", getGroupName());
	    	logger.debug("PaymentAction class : execute method : stored investmentTypeName : "+getGroupName()+" in session id : "+sessionMap.getClass().getName());
	    	Trading trading = new Trading();
		
	    	String ucc = trading.createClient(getClientHolding(), getTaxStatus(), getOccupationName(), getDateOfBirth(),
				getGenderType(), "", getAccountType(), getAccountNumber(), getNeftCode(),
				getResidentialAddress(), getResidentialCity(), getResidentialState(), getResidentialPin(), getResidentialCountry(),
				customerId, CLIENT_APPNAME1, CLIENT_EMAIL, CLIENT_PAN, CLIENT_CM_MOBILE);
		
	    	String[] uccSpilts = ucc.split("\\|");
	    	
	    	//System.out.println("uccSpilts[0] : "+uccSpilts[0]);
	    	
		if(uccSpilts[0].equals("100") ) {
			String paymentUrl = null;
			
			String amount;
			if (sessionMap.get("transactionType").toString() == "UPFRONT")  {
				amount = sessionMap.get("upfrontInvestment").toString();
				
		    	productDetailsMapForBuy = queryProducts.getProductAmountList(sessionMap.get("riskCategory").toString(),sessionMap.get("planName").toString(),Double.parseDouble(sessionMap.get("upfrontInvestment").toString()));
		    	
			}
			else {
				amount = sessionMap.get("sip").toString();
				
		    	productDetailsMapForBuy = queryProducts.getProductAmountList(sessionMap.get("riskCategory").toString(),sessionMap.get("planName").toString(),Double.parseDouble(sessionMap.get("sip").toString()));
		    	
			}
			paymentUrl = trading.executeTrade(sessionMap.get("customerId").toString(), amount, productDetailsMapForBuy,
					"NEW",sessionMap.get("transactionType").toString(),"BUY",Integer.parseInt(sessionMap.get("years").toString()),"Y",
					"Customer bought some mutual funds",getGroupName());
			
			String str ;
			if ( !paymentUrl.equals("NotSet")) {
			
				sessionMap.put("paymentUrl", paymentUrl);
		
		    	System.out.println("paymentUrl from session : "+sessionMap.get("paymentUrl").toString());
		    	
		    	logger.debug("PaymentAction class : execute method : stored paymentUrl : "+paymentUrl+" in session id : "+sessionMap.getClass().getName());
				
				groupNamesList = (ArrayList)customerPortfolio.getGroupNameList(sessionMap.get("customerId").toString());
				sessionMap.put("groupNamesList", groupNamesList);
		    	logger.debug("PaymentAction class : execute method : updated groupNamesList in session id : "+sessionMap.getClass().getName());
		    	
		    	//if ( (Long.parseLong(getAccountNumber()) % 2) == 0)  {
		    		
		    		System.out.println(" account number is even, considering payment successful !! ");
		    		
			    	subject = "Payment recieved for your recent transaction";
		        	bodyText.append("<div>")
		        	.append(" <br/><br/> <h1>Dear User</h1><br/><br/>")
		        	.append("  <p>Payment for your recent transaction has been received</p><br/><br/><br/>")
		        	.append(" <h3> Please click <a href=\""+MAIL_SITE_LINK+"\">here</a> to login and check the staus of all your transactions.</h3><br/><br/>")
		        	.append("  <h3>Thanks,</h3><br/><br/>")
		        	.append("  <h3>MoneyBuddy Team</h3>")
		        	.append("</div>");
		        	sendmail.MailSending(sessionMap.get("emailId").toString(), bodyText,subject);
		        	
		        	str = "success|"+paymentUrl;

	    		
			}
			else{
				str = "allOrderFailed";

			}
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return SUCCESS;
	    	/*}
	    	else {
	    		
	    		System.out.println(" account number is odd, considering payment failure !! ");
	    		
	    		subject = "Payment Faied for your recent transaction";
	        	bodyText.append("<div>")
	        	.append(" <br/><br/> <h1>Dear User</h1><br/><br/>")
	        	.append("  <p>Payment for your recent transaction has been failed.</p><br/><br/><br/>")
	        	.append(" <h3> Please click <a href=\""+MAIL_SITE_LINK+"\">here</a> to login and check the staus of all your transactions.</h3><br/><br/>")
	        	.append("  <h3>Thanks,</h3><br/><br/>")
	        	.append("  <h3>MoneyBuddy Team</h3>")
	        	.append("</div>");
	        	sendmail.MailSending(sessionMap.get("emailId").toString(), bodyText,subject);
	        	
	        	String str = "paymentFailure";
	    	    stream = new ByteArrayInputStream(str.getBytes());
	    		return SUCCESS;
	    	}*/
		}
		else {
			String str = "clientCreationFailure";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return SUCCESS;
		}
    	

        
		} catch (MoneyBuddyException e) {	
    		logger.debug("PaymentAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.debug("PaymentAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
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
	

	public String getClientHolding() {
		return clientHolding;
	}

	public void setClientHolding(String clientHolding) {
		this.clientHolding = clientHolding;
	}

	public String getTaxStatus() {
		return taxStatus;
	}

	public void setTaxStatus(String taxStatus) {
		this.taxStatus = taxStatus;
	}

	public String getOccupationName() {
		return occupationName;
	}

	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}

	public String getGenderType() {
		return genderType;
	}

	public void setGenderType(String genderType) {
		this.genderType = genderType;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getResidentialCity() {
		return residentialCity;
	}

	public void setResidentialCity(String residentialCity) {
		this.residentialCity = residentialCity;
	}

	public String getNeftCode() {
		return neftCode;
	}

	public void setNeftCode(String neftCode) {
		this.neftCode = neftCode;
	}

	public String getResidentialState() {
		return residentialState;
	}

	public void setResidentialState(String residentialState) {
		this.residentialState = residentialState;
	}

	public String getResidentialPin() {
		return residentialPin;
	}

	public void setResidentialPin(String residentialPin) {
		this.residentialPin = residentialPin;
	}

	public String getResidentialCountry() {
		return residentialCountry;
	}

	public void setResidentialCountry(String residentialCountry) {
		this.residentialCountry = residentialCountry;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}
	
}

/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.QueryAdditionalCustomerDetails;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryCustomerDetails;
import com.myMoneyBuddy.DAOClasses.QueryCustomerPortfolio;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.UpdateCustomer;
import com.myMoneyBuddy.DAOClasses.insertBankDetails;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.EntityClasses.CustomerDetails;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.mailerClasses.SendMail;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;


public class PaymentAction extends ActionSupport implements SessionAware {

	Logger logger = Logger.getLogger(PaymentAction.class);
	private SessionMap<String, Object> sessionMap;

	private String accountType;
	private String accountNumber;
	private String neftCode;
	private String bankName;
	
	private InputStream stream;
	   
    public String execute()  {

    	try {
    		    		
    		System.out.println("Payment Action class : execute method : transactionType : "+sessionMap.get("transactionType").toString());

    		QueryCustomerPortfolio customerPortfolio = new QueryCustomerPortfolio();
	    	
	    	System.out.println("Hi There 1 .");
	    	String customerId;
	    	String CLIENT_HOLDING = "SI"; // Considering Single account
			String CLIENT_EMAIL;
			String CLIENT_APPNAME1;
			
			System.out.println("Hi There 2 .");
			String CLIENT_PAN;
			String CLIENT_CM_MOBILE;
			
			
		    customerId = sessionMap.get("customerId").toString();
		    System.out.println("Hi There 3 .");
		    System.out.println("CLIENT_CODE/customerId : "+customerId);
		    System.out.println("Hi There 4 .");
	    	
	    	CLIENT_APPNAME1 = sessionMap.get("customerName").toString();
	    	System.out.println("CLIENT_APPNAME1 : "+CLIENT_APPNAME1);
	    	
	    	CLIENT_EMAIL = sessionMap.get("emailId").toString();
	    	System.out.println("CLIENT_EMAIL : "+CLIENT_EMAIL);

	    	
	    	CLIENT_PAN = sessionMap.get("panCard").toString();
	    	//System.out.println("CLIENT_PAN : "+CLIENT_PAN);
	    	
	    	CLIENT_CM_MOBILE = sessionMap.get("customerMobileNumber").toString();
	    	System.out.println("CLIENT_CM_MOBILE : "+CLIENT_CM_MOBILE);

	    	QueryProducts queryProducts = new QueryProducts();
	    	Map<String, Double> productDetailsMapForBuy = new HashMap<String, Double>();
    	
	    	//sessionMap.put("groupName", getGroupName());
	    	//logger.debug("PaymentAction class : execute method : stored investmentTypeName : "+getGroupName()+" in session id : "+sessionMap.getClass().getName());
	    	
	    	insertBankDetails bankDetails = new insertBankDetails();
	    	bankDetails.insertBankDetail(customerId, getBankName(), getAccountType(), getAccountNumber(), getNeftCode());
	    	
	    	QueryCustomer queryCustomer = new QueryCustomer();
	    	
	    	Customers customer = queryCustomer.getCustomer(CLIENT_EMAIL);
	    	
	    	QueryCustomerDetails queryCustomerDetails = new QueryCustomerDetails();
	    	
	    	CustomerDetails customerDetails = queryCustomerDetails.getCustomerDetails(customerId);
	    	
	    	QueryAdditionalCustomerDetails queryAddCusDetails = new QueryAdditionalCustomerDetails();

	    	Trading trading = new Trading();
		
	    	String bseClientCreatedStatus = "N";
	    	
	    	bseClientCreatedStatus = queryCustomer.getBseClientCreationStatus(customerId);
	    	
	    	if ("N".equals(bseClientCreatedStatus))  {
		    	String ucc = trading.createClient(CLIENT_HOLDING, customerDetails.getTaxStatus(), customerDetails.getOccupation(), customerDetails.getDateOfBirth(),
		    			customerDetails.getGender(), "", getAccountType(), getAccountNumber(), getNeftCode(),
		    			customerDetails.getAddressLineOne()+" "+customerDetails.getAddressLineTwo()+" "+customerDetails.getAddressLineThree(), customerDetails.getResidentialCity(), 
		    			customerDetails.getResidentialState(), customerDetails.getResidentialPin(), customerDetails.getResidentialCountry(),
					customerId, CLIENT_APPNAME1, CLIENT_EMAIL, CLIENT_PAN, CLIENT_CM_MOBILE);
			
		    	String[] uccSpilts = ucc.split("\\|");
		    	
		    	System.out.println("uccSpilts[0] : "+uccSpilts[0]);
		    	
		    	if(uccSpilts[0].equals("100") ) {
		    		
		    		if(uccSpilts[1].contains("RECORD INSERTED SUCCESSFULLY") ) {
			    		
			    		UpdateCustomer updateCustomer = new UpdateCustomer();
			    		updateCustomer.updateBseClientCreationStatus(customerId, "Y");
			    		bseClientCreatedStatus = "Y";
		    		}
		    		
		    	}
	    	
	    	}
	    	
	    	
		if("Y".equals(bseClientCreatedStatus)) {
			String paymentUrl = null;
			
			String amount;
			System.out.println("transactionType : "+sessionMap.get("transactionType").toString());
			if (sessionMap.get("transactionType").toString() == "UPFRONT")  {
				amount = sessionMap.get("upfrontInvestment").toString();
		    	
		    	List<CustomerCart> customerCartList = (List<CustomerCart>) sessionMap.get("customerCartList");
		    	

		    	for (int i =0 ; i< customerCartList.size() ;i++) {
		    		System.out.println("Value of i is : "+i+" customerCartList.get(i).getProductName : "+customerCartList.get(i).getProductName());
		    		if ( !"Total".equals(customerCartList.get(i).getProductName()))  {
		    			productDetailsMapForBuy.put(customerCartList.get(i).getProductId(), Double.parseDouble(customerCartList.get(i).getAmount()));
		    		}
		    	}
		    	paymentUrl = trading.executeTrade(sessionMap.get("customerId").toString(), amount, productDetailsMapForBuy,
						"NEW",null,null,null,sessionMap.get("transactionType").toString(),"BUY",0,getAccountNumber(),getBankName(),getNeftCode(),getBankMode(getBankName()),"Y",
						"Customer bought some mutual funds",null, sessionMap);
		    	
			}
			else {
				amount = sessionMap.get("sipAmount").toString();
				
				String mandateIdResponse = trading.generateMandateId(customerId, amount, "I", getAccountNumber(), getAccountType(), getNeftCode(), 
								sessionMap.get("sipStartDate").toString(), sessionMap.get("sipEndDate").toString());
				
				String[] mandateIdResponseSpilts = mandateIdResponse.split("\\|"); 
		    	
		    	System.out.println("mandateIdResponseSpilts[0] : "+mandateIdResponseSpilts[0]);
		    	System.out.println("mandateIdResponseSpilts[1] : "+mandateIdResponseSpilts[1]);
		    	System.out.println("mandateIdResponseSpilts[2] : "+mandateIdResponseSpilts[2]);
		    	
		    	String mandateId = mandateIdResponseSpilts[2];
		    	
		    	System.out.println("mandateId : "+mandateId);
		    	
				
		    	productDetailsMapForBuy = queryProducts.getProductAmountList((HashMap<String,Double>)sessionMap.get("productRatioList"),
		    			Double.parseDouble(sessionMap.get("sipAmount").toString()));
		    	
		    	paymentUrl = trading.executeTrade(sessionMap.get("customerId").toString(), amount, productDetailsMapForBuy,
						"NEW",sessionMap.get("sipDate").toString(),sessionMap.get("sipStartDate").toString(),sessionMap.get("sipEndDate").toString(),
						sessionMap.get("transactionType").toString(),"BUY",Integer.parseInt(sessionMap.get("sipDuration").toString()),
						getAccountNumber(),getBankName(),getNeftCode(),getBankMode(getBankName()),"Y",
						"Customer bought some mutual funds",mandateId,sessionMap);
			}
			
			
			String str ;
			if ( !paymentUrl.equals("NotSet")) {
		        	
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
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getNeftCode() {
		return neftCode;
	}

	public void setNeftCode(String neftCode) {
		this.neftCode = neftCode;
	}

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}
	
	public String getBankMode(String bankName)  {
		
		String bankMode;
		
		switch (bankName)  {
			case "ICI" : 
			case "SBI" : 
			case "162" :
				bankMode="DIRECT";break;
			case "HDF" :
				bankMode="NODAL";break;
			default : 
				bankMode="INVALID";
		}
		return bankMode;
	}

	
}

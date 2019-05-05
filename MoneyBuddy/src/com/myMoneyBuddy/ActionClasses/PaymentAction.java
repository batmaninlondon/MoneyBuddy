/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.myMoneyBuddy.DAOClasses.QueryBankDetails;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryCustomerDetails;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.DAOClasses.QuerySecondaryFundDetails;
import com.myMoneyBuddy.DAOClasses.QuerySipDetails;
import com.myMoneyBuddy.DAOClasses.QueryTransactionDetails;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.UpdateCustomer;
import com.myMoneyBuddy.DAOClasses.GenerateAofForm;
import com.myMoneyBuddy.DAOClasses.InsertBankDetails;
import com.myMoneyBuddy.DAOClasses.InsertCustomerDetails;
import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.EntityClasses.CustomerDetails;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.CommonUtil;
import com.myMoneyBuddy.Utils.DesEncrypter;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class PaymentAction extends ActionSupport implements SessionAware {

	Logger logger = Logger.getLogger(PaymentAction.class);
	private SessionMap<String,Object> sessionMap;
	private String firstOrderFlag;
	private String tranDetailId;
	private String paymentUrl;
	private String sipAmount;
	private String actionMsg;


	public String execute()  {

    	String CLIENT_HOLDING = "SI"; // Considering Single account
    	String customerId = null;
    	
    	try {

    		System.out.println(" HI THERE FROM PAYMENT ACTION !!!! ");
    		if (null == getFirstOrderFlag())
    			setFirstOrderFlag("N");
    		System.out.println("firstOrderFlag : "+getFirstOrderFlag());
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		QueryBankDetails queryBankDetails = new QueryBankDetails();
    		BankDetails bankDetails = queryBankDetails.fetchBankDetails(customerId);
    		
    		DesEncrypter desEncrypter = new DesEncrypter();

	    	QueryCustomer queryCustomer = new QueryCustomer();
	    	
	    	Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
    	
	    	Trading trading = new Trading();
	    	
	    	String bseClientCreatedStatus = customer.getBseClientCreated();
	    	
	    	if ("N".equals(bseClientCreatedStatus))  {
	    		
	    		QueryCustomerDetails queryCustomerDetails = new QueryCustomerDetails();
	    		CustomerDetails customerDetails = queryCustomerDetails.getCustomerDetails(customerId);
	    		
		    	String ucc = trading.createClient(CLIENT_HOLDING, customerDetails.getTaxStatus(), customerDetails.getOccupation(), customerDetails.getDateOfBirth(),
		    			customerDetails.getGender(), "", bankDetails.getAccountType(), desEncrypter.decrypt(bankDetails.getAccountNumber()), bankDetails.getIfscCode(),
		    			customerDetails.getAddressLineOne()+" "+customerDetails.getAddressLineTwo()+" "+customerDetails.getAddressLineThree(), customerDetails.getResidentialCity(), 
		    			customerDetails.getResidentialState(), customerDetails.getResidentialPin(), customerDetails.getResidentialCountry(),
					customerId, customer.getCustomerName(), customer.getEmailId(), customer.getPanCard(), customer.getMobileNumber());
			
		    	String[] uccSpilts = ucc.split("\\|");
		    	
		    	System.out.println("uccSpilts[0] : "+uccSpilts[0]);
		    	
		    	if(uccSpilts[0].equals("100") ) {
		    		
		    		if(uccSpilts[1].contains("SUCCESSFULLY") ) {
			    		
			    		UpdateCustomer updateCustomer = new UpdateCustomer();
			    		updateCustomer.updateBseClientCreationStatus(customerId, "Y");
			    		bseClientCreatedStatus = "Y";
		    		}
		    		
		    	}
	    	
	    	}
	    	  	
		if("Y".equals(bseClientCreatedStatus)) {	
			
			String paymentUrl = null;
			
			CommonUtil commonUtil = new CommonUtil();
				
			QueryCustomerCart queryCustomerCart = new QueryCustomerCart();
			
			List<CustomerCart> customerCartList = queryCustomerCart.getCustomerCart(customerId);
							
			String mandateId = customer.getIsipMandateId();
			
			if ( "NOT_GENERATED".equals(mandateId))  {
									
				String mandateIdResponse = trading.generateMandateId(customerId, "I", desEncrypter.decrypt(bankDetails.getAccountNumber()), bankDetails.getAccountType(), bankDetails.getIfscCode());
				
				String[] mandateIdResponseSpilts = mandateIdResponse.split("\\|"); 
		    	
		    	System.out.println("mandateIdResponseSpilts[0] : "+mandateIdResponseSpilts[0]);
		    	System.out.println("mandateIdResponseSpilts[1] : "+mandateIdResponseSpilts[1]);
		    	System.out.println("mandateIdResponseSpilts[2] : "+mandateIdResponseSpilts[2]);
		    	
		    	mandateId = mandateIdResponseSpilts[2];
		    	
		    	InsertCustomerDetails insertCustomerDetails = new InsertCustomerDetails();
		    	insertCustomerDetails.updateMandateId(mandateId, customerId);
			}
	    	
	    	System.out.println("mandateId : "+mandateId);
			
	    	
	    	paymentUrl = trading.executeTrade(customerId, customer.getPanCard(),customerCartList,
					"NEW","BUY",desEncrypter.decrypt(bankDetails.getAccountNumber()),bankDetails.getBankName(),bankDetails.getIfscCode(),
					commonUtil.getBankMode(bankDetails.getBankName()),getFirstOrderFlag(),
					mandateId,getTranDetailId(), sessionMap);
	    	
	    	System.out.println("paymentUrl : "+paymentUrl);

			if (null == paymentUrl)
	    		return "sipOrderFofN";
			
			if ( !paymentUrl.equals("NotSet")) {
			
				if (!paymentUrl.contains("<html>"))  {
					setActionMsg("ActionMsg-"+paymentUrl);
					return "failedWithPaymentGateway";
				}
				setPaymentUrl(paymentUrl);
				return SUCCESS;
				
			}
			else {
				
				setActionMsg("ActionMsg-allOrderFailed with BSE");
				return "allOrderFailed";
			}
		}
		else {
			setActionMsg("ActionMsg-clientCreationFailed with BSE");
    		return "clientCreationFailure";
		}

		} catch (MoneyBuddyException e) {	
    		logger.error("PaymentAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.error("PaymentAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			return ERROR;
		}

    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }
	
	public String getTranDetailId() {
		return tranDetailId;
	}

	public void setTranDetailId(String tranDetailId) {
		this.tranDetailId = tranDetailId;
	}

	public String getFirstOrderFlag() {
		return firstOrderFlag;
	}

	public void setFirstOrderFlag(String firstOrderFlag) {
		this.firstOrderFlag = firstOrderFlag;
	}

	public String getPaymentUrl() {
		return paymentUrl;
	}

	public void setPaymentUrl(String paymentUrl) {
		this.paymentUrl = paymentUrl;
	}

	public String getSipAmount() {
		return sipAmount;
	}

	public void setSipAmount(String sipAmount) {
		this.sipAmount = sipAmount;
	}
 
    public String getActionMsg() {
		return actionMsg;
	}

	public void setActionMsg(String actionMsg) {
		this.actionMsg = actionMsg;
	}
	
}

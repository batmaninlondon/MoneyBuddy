/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.QueryBankDetails;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerCart;
import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.CommonUtil;
import com.myMoneyBuddy.Utils.DesEncrypter;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentAction extends ActionSupport implements SessionAware {

	Logger logger = LogManager.getLogger(PaymentAction.class);
	private SessionMap<String,Object> sessionMap;
	private String firstOrderFlag;
	private String tranDetailId;
	private String paymentUrl;
	private String sipAmount;
	private String actionMsg;


	public String execute()  {

    	String customerId = null;
    	
    	try {

    		if (null == getFirstOrderFlag())
    			setFirstOrderFlag("N");
    		System.out.println("firstOrderFlag : "+getFirstOrderFlag());
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		sessionMap.put("firstOrderFlag", getFirstOrderFlag());
	    	logger.debug("PaymentAction class - execute method - customerId - "+customerId+" - stored firstOrderFlag in sessionMap");
    		
    		QueryBankDetails queryBankDetails = new QueryBankDetails();
    		BankDetails bankDetails = queryBankDetails.fetchBankDetails(customerId);
    		
    		DesEncrypter desEncrypter = new DesEncrypter();

	    	QueryCustomer queryCustomer = new QueryCustomer();
	    	
	    	Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
    	
	    	Trading trading = new Trading();

			String paymentUrl = null;
			
			CommonUtil commonUtil = new CommonUtil();
				
			QueryCustomerCart queryCustomerCart = new QueryCustomerCart();
			
			List<CustomerCart> customerCartList = queryCustomerCart.getCustomerCart(customerId);
							
			String mandateId = customer.getIsipMandateId();
			
			/*if ( "NOT_GENERATED".equals(mandateId))  {
									
				String mandateIdResponse = trading.generateMandateId(customerId, "I", desEncrypter.decrypt(bankDetails.getAccountNumber()), bankDetails.getAccountType(), bankDetails.getIfscCode());
				
				String[] mandateIdResponseSpilts = mandateIdResponse.split("\\|"); 
		    	
		    	System.out.println("mandateIdResponseSpilts[0] : "+mandateIdResponseSpilts[0]);
		    	System.out.println("mandateIdResponseSpilts[1] : "+mandateIdResponseSpilts[1]);
		    	System.out.println("mandateIdResponseSpilts[2] : "+mandateIdResponseSpilts[2]);
		    	
		    	mandateId = mandateIdResponseSpilts[2];
		    	
		    	InsertCustomerDetails insertCustomerDetails = new InsertCustomerDetails();
		    	insertCustomerDetails.updateMandateId(mandateId, customerId);
			}*/
	    	
	    	System.out.println("mandateId : "+mandateId);
	    	
	    	
	    	paymentUrl = trading.executeTrade(customerId, customer.getPanCard(),customerCartList,
					"NEW","BUY",desEncrypter.decrypt(bankDetails.getAccountNumber()),bankDetails.getBankName(),bankDetails.getIfscCode(),
					commonUtil.getBankMode(bankDetails.getBankName()),getFirstOrderFlag(),
					mandateId,getTranDetailId(), sessionMap);
	    	
	    	System.out.println("paymentUrl : "+paymentUrl);
	    	
	    	
	    	
	    	UpdateCustomerCart updateCustomerCart = new UpdateCustomerCart();
			if (null == paymentUrl)  {
				
				updateCustomerCart.emptyCustomerCart(customerId);
	    		return "sipOrderFofN";
			}
			
			if ( !paymentUrl.equals("NotSet")) {
			
				if (!paymentUrl.contains("<html>"))  {
					setActionMsg("ActionMsg-"+paymentUrl);
					return "failedWithPaymentGateway";
				}
				
				updateCustomerCart.emptyCustomerCart(customerId);
				setPaymentUrl(paymentUrl);
				return SUCCESS;
				
			}
			else {
				
				setActionMsg("ActionMsg-allOrderFailed with BSE");
				return "allOrderFailed";
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

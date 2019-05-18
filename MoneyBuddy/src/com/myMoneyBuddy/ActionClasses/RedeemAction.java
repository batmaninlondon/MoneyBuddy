/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.InsertCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class RedeemAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(RedeemAction.class);
	private SessionMap<String,Object> sessionMap;
	
	private String fundId;
	private String schemeName;
	private String folioNumber;
	private String totalAmount;
	private String totalQuantity;
	private String redeemAmount;
	private String redeemQuantity;;
	private String redeemType;
	private String amtOrQuan;

    public String execute() {
    	
    	String customerId = null;
    	String allRedeem = "N";
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		QueryCustomer queryCustomer = new QueryCustomer();
	    	
	    	Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
	    	
    		logger.debug("RedeemAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" RedeemAction execute method Called !!");
	    	
	    	System.out.println(" RedeemAction execute method fundId : "+getFundId());
	    	System.out.println(" RedeemAction execute method schemeName : "+getSchemeName());
	    	System.out.println(" RedeemAction execute method folioNumber : "+getFolioNumber());
	    	System.out.println(" RedeemAction execute method totalAmount : "+getTotalAmount());
	    	System.out.println(" RedeemAction execute method totalQuantity : "+getTotalQuantity());
	    	System.out.println(" RedeemAction execute method redeemAmount : "+getRedeemAmount());
	    	System.out.println(" RedeemAction execute method redeemQuantity : "+getRedeemQuantity());
	    	System.out.println(" RedeemAction execute method redeemType : "+getRedeemType());
	    	System.out.println(" RedeemAction execute method amtOrQuan : "+getAmtOrQuan());
	    	
	    	if ("1".equals(getRedeemType()))  {
	    		allRedeem = "Y";
	    	}
	    	Trading trading = new Trading();
	    	
	    	trading.executeRedemption(customerId, customer.getPanCard(), getFundId(), Double.valueOf(getRedeemAmount()), 
	    					Double.valueOf(getRedeemQuantity()), allRedeem, "NEW", "UPFRONT", "SELL", getFolioNumber() );
	    	
	    	if ("Y".equals(allRedeem))  {
	    		
	    		
	    	}
	    	
	
    	    logger.debug("RedeemAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("RedeemAction class - execute method - customerId - "+customerId+" - end");
	    	
	    	return SUCCESS;
    	} 
    	catch ( Exception e )  {
    		logger.error("RedeemAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("RedeemAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getRedeemAmount() {
		return redeemAmount;
	}

	public void setRedeemAmount(String redeemAmount) {
		this.redeemAmount = redeemAmount;
	}

	public String getRedeemQuantity() {
		return redeemQuantity;
	}

	public void setRedeemQuantity(String redeemQuantity) {
		this.redeemQuantity = redeemQuantity;
	}

	public String getRedeemType() {
		return redeemType;
	}

	public void setRedeemType(String redeemType) {
		this.redeemType = redeemType;
	}

	public String getAmtOrQuan() {
		return amtOrQuan;
	}

	public void setAmtOrQuan(String amtOrQuan) {
		this.amtOrQuan = amtOrQuan;
	}

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getFolioNumber() {
		return folioNumber;
	}

	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}


}

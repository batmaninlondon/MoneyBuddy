/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.InsertCustomerCart;
import com.myMoneyBuddy.DAOClasses.InsertCustomerRedemptionCart;
import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryCustomerRedemptionCart;
import com.myMoneyBuddy.DAOClasses.QueryPrimaryFundDetails;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.EntityClasses.RedemptionCart;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class AddToRedemptionCartAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(AddToRedemptionCartAction.class);
	private SessionMap<String,Object> sessionMap;
	
	
	private String redeemFundId;
	private String folioNum;
	private String totalAmount;
	private String totalQuantity;

    public String execute() {
    	
    	String customerId = null;
    	
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		QueryCustomerRedemptionCart queryCustomerRedemptionCart = new QueryCustomerRedemptionCart();
    		InsertCustomerRedemptionCart insertCustomerRedemptionCart = new InsertCustomerRedemptionCart();
    		
    		QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
			String redeemSchemeName = queryPrimaryFundDetails.getSchemeName(getRedeemFundId());
			String minRedAmount = queryPrimaryFundDetails.getMinRedAmount(getRedeemFundId());

			if ( !("".equals(redeemFundId) || redeemFundId == null) )
				if (!queryCustomerRedemptionCart.existsFund(customerId, redeemFundId, folioNum) )  {
					insertCustomerRedemptionCart.insertRow(customerId, redeemFundId, redeemSchemeName,minRedAmount,totalAmount,totalQuantity,"Select","Select",folioNum);
				}
    		
    		
    		List<RedemptionCart> customerRedemptionCartList = queryCustomerRedemptionCart.getCustomerRedemptionCart(customerId);

	    	sessionMap.put("customerRedemptionCartList", customerRedemptionCartList);
	    	logger.debug("AddToRedemptionCartAction class - execute method - customerId - "+customerId+" - stored customerRedemptionCartList in sessionMap"); 
	    	
	
	    	return SUCCESS;
	    	
    	} 
    	catch ( Exception e )  {
    		logger.error("AddToRedemptionCartAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("AddToRedemptionCartAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getRedeemFundId() {
		return redeemFundId;
	}

	public void setRedeemFundId(String redeemFundId) {
		this.redeemFundId = redeemFundId;
	}

	public String getFolioNum() {
		return folioNum;
	}

	public void setFolioNum(String folioNum) {
		this.folioNum = folioNum;
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

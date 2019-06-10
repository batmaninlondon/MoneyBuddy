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
import com.myMoneyBuddy.DAOClasses.QueryCustomerRedemptionCart;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.RedemptionCart;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class RedeemAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(RedeemAction.class);
	private SessionMap<String,Object> sessionMap;
	
/*	private String fundId;
	private String schemeName;
	private String folioNumber;
	private String totalAmount;
	private String totalQuantity;
	private String redeemAmount;
	private String redeemQuantity;;
	private String redeemType;
	private String amtOrQuan;*/

    public String execute() {
    	
    	String customerId = null;
    	String allRedeem = "N";
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		QueryCustomerRedemptionCart queryCustomerRedemptionCart = new QueryCustomerRedemptionCart();
    		List<RedemptionCart> customerRedemptionCartList = queryCustomerRedemptionCart.getCustomerRedemptionCart(customerId);
    		
    		QueryCustomer queryCustomer = new QueryCustomer();
	    	
	    	Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
	    	
    		logger.debug("RedeemAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" RedeemAction execute method Called !!");

	    	for (int i =0;i<customerRedemptionCartList.size()-1;i++)  {
	    	
		    	if ("Full".equals( customerRedemptionCartList.get(i).getRedemptionOption()  ))  {
		    		allRedeem = "Y";
		    	}
		    	Trading trading = new Trading();
		    	
		    	trading.executeRedemption(customerId, customer.getPanCard(), customerRedemptionCartList.get(i).getProductId(), Double.valueOf(customerRedemptionCartList.get(i).getRedAmount() ), 
		    					Double.valueOf(customerRedemptionCartList.get(i).getRedUnits()), allRedeem, "NEW", "UPFRONT", "SELL", customerRedemptionCartList.get(i).getFolioNumber() );
	    	
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


}

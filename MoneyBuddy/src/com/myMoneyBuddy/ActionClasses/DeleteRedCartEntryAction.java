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

import com.myMoneyBuddy.DAOClasses.QueryCustomerRedemptionCart;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerRedemptionCart;
import com.myMoneyBuddy.EntityClasses.RedemptionCart;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteRedCartEntryAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(DeleteRedCartEntryAction.class);
	private SessionMap<String,Object> sessionMap;
	private String redCartId;

    public String execute() {
    	
    	String customerId = null;
    	
    	try {
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("DeleteRedCartEntryAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" DeleteRedCartEntryAction execute method Called !!");

	    	UpdateCustomerRedemptionCart updateCustomerRedemptionCart = new UpdateCustomerRedemptionCart();
	    	updateCustomerRedemptionCart.deleteCustomerRedCartEntry(customerId,getRedCartId());
	    	
	    	QueryCustomerRedemptionCart queryCustomerRedemptionCart = new QueryCustomerRedemptionCart();
    		
    		List<RedemptionCart> customerRedemptionCartList = queryCustomerRedemptionCart.getCustomerRedemptionCart(customerId);

	    	sessionMap.put("customerRedemptionCartList", customerRedemptionCartList);
	    	logger.debug("DeleteRedCartEntryAction class - execute method - customerId - "+customerId+" - stored customerRedemptionCartList in sessionMap"); 

	    	return SUCCESS;
	    		
	    	
    	}
    	catch ( Exception e )  {
    		logger.error("DeleteRedCartEntryAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("DeleteRedCartEntryAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getRedCartId() {
		return redCartId;
	}

	public void setRedCartId(String redCartId) {
		this.redCartId = redCartId;
	}

}

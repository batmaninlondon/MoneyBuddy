/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.InsertCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerRedemptionCart;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.opensymphony.xwork2.ActionSupport;

public class LogOffAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(LogOffAction.class);
	private SessionMap<String,Object> sessionMap;

    public String execute() {
    	
    	String customerId = null;
    	
    	try {
    		logger.debug("LogOffAction class - execute method - start ");
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		UpdateCustomerRedemptionCart updateCustomerRedemptionCart = new UpdateCustomerRedemptionCart();
    		updateCustomerRedemptionCart.emptyCustomerRedCart(customerId);
    		
    		sessionMap.invalidate();
    		
    		logger.debug("LogOffAction class - execute method - end ");
    		
	    	return SUCCESS;
	    	
    	} 
    	catch ( Exception e )  {
    		logger.error("LogOffAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("LogOffAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }


}

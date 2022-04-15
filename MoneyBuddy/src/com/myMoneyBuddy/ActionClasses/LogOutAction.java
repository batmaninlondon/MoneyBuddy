/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.UpdateCustomerRedemptionCart;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerStpCart;
import com.opensymphony.xwork2.ActionSupport;

public class LogOutAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(LogOutAction.class);
	private SessionMap<String,Object> sessionMap;

    public String execute() {
    	
    	String customerId = null;
    	
    	try {
    		logger.debug("LogOutAction class - execute method - start ");
    		
    		if (!sessionMap.isEmpty() )   {
    		customerId = sessionMap.get("customerId").toString();
    		
    		if ( customerId != null ) {
    		
    		UpdateCustomerRedemptionCart updateCustomerRedemptionCart = new UpdateCustomerRedemptionCart();
    		updateCustomerRedemptionCart.emptyCustomerRedCart(customerId);
    		
    		UpdateCustomerStpCart  updateCustomerStpCart = new UpdateCustomerStpCart();
    		updateCustomerStpCart.emptyCustomerStpCart(customerId);
    		}
    		}
    		
    		sessionMap.invalidate();
    		
    		logger.debug("LogOutAction class - execute method - end ");
    		
	    	return SUCCESS;
	    	
    	} 
    	catch ( Exception e )  {
    		logger.error("LogOutAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("LogOutAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }


}

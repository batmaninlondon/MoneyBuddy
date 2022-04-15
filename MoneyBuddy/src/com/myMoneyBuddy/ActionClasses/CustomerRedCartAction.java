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
import com.myMoneyBuddy.EntityClasses.RedemptionCart;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerRedCartAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(CustomerRedCartAction.class);
	private SessionMap<String,Object> sessionMap;

    public String execute() {
    	
    	String customerId = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("CustomerRedCartAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" CustomerRedCartAction execute method Called !!");

	    	QueryCustomerRedemptionCart queryCustomerRedemptionCart = new QueryCustomerRedemptionCart();
	    	List<RedemptionCart> customerRedemptionCartList = queryCustomerRedemptionCart.getCustomerRedemptionCart(customerId);
	    	
	    	sessionMap.put("customerRedemptionCartList", customerRedemptionCartList);
	    	logger.debug("CustomerRedCartAction class - execute method - customerId - "+customerId+" - stored customerRedemptionCartList in sessionMap");   
	    	logger.debug("CustomerRedCartAction class - execute method - customerId - "+customerId+" - end");	
   	
	    	return SUCCESS;
    	} 
    	catch ( Exception e )  {
    		logger.error("CustomerRedCartAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    	    logger.error("CustomerRedCartAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

}

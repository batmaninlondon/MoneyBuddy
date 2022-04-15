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

import com.myMoneyBuddy.DAOClasses.QueryStpCart;
import com.myMoneyBuddy.EntityClasses.StpCart;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerStpCartAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(CustomerStpCartAction.class);
	private SessionMap<String,Object> sessionMap;

    public String execute() {
    	
    	String customerId = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("CustomerStpCartAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" CustomerStpCartAction execute method Called !!");

	    	QueryStpCart queryStpCart = new QueryStpCart();
	    	List<StpCart> customerStpCartList = queryStpCart.getCustomerStpCart(customerId);
	    	
	    	sessionMap.put("customerStpCartList", customerStpCartList);
	    	logger.debug("CustomerStpCartAction class - execute method - customerId - "+customerId+" - stored customerStpCartList in sessionMap");   
	    	logger.debug("CustomerStpCartAction class - execute method - customerId - "+customerId+" - end");	
   	
	    	return SUCCESS;
    	} 
    	catch ( Exception e )  {
    		logger.error("CustomerStpCartAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    	    logger.error("CustomerStpCartAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

}

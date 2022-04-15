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

import com.myMoneyBuddy.DAOClasses.QuerySwitchCart;
import com.myMoneyBuddy.EntityClasses.SwitchCart;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerSwitchCartAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(CustomerSwitchCartAction.class);
	private SessionMap<String,Object> sessionMap;

    public String execute() {
    	
    	String customerId = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("CustomerSwitchCartAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" CustomerSwitchCartAction execute method Called !!");

	    	QuerySwitchCart querySwitchCart = new QuerySwitchCart();
	    	List<SwitchCart> customerSwitchCartList = querySwitchCart.getCustomerSwitchCart(customerId);
	    	
	    	sessionMap.put("customerSwitchCartList", customerSwitchCartList);
	    	logger.debug("CustomerSwitchCartAction class - execute method - customerId - "+customerId+" - stored customerSwitchCartList in sessionMap");   
	    	logger.debug("CustomerSwitchCartAction class - execute method - customerId - "+customerId+" - end");	
   	
	    	return SUCCESS;
    	} 
    	catch ( Exception e )  {
    		logger.error("CustomerSwitchCartAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    	    logger.error("CustomerSwitchCartAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

}

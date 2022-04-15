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
import com.myMoneyBuddy.DAOClasses.UpdateCustomerStpCart;
import com.myMoneyBuddy.EntityClasses.StpCart;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteStpCartEntryAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(DeleteStpCartEntryAction.class);
	private SessionMap<String,Object> sessionMap;
	private String stpCartId;

    public String execute() {
    	
    	String customerId = null;
    	
    	try {
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("DeleteStpCartEntryAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" DeleteStpCartEntryAction execute method Called !!");

	    	UpdateCustomerStpCart  updateCustomerStpCart = new UpdateCustomerStpCart();
	    	updateCustomerStpCart.deleteCustomerStpCartEntry(customerId, stpCartId);
	    	
	    	QueryStpCart queryStpCart = new QueryStpCart();
	    	List<StpCart> customerStpCartList = queryStpCart.getCustomerStpCart(customerId);
	    	
	    	sessionMap.put("customerStpCartList", customerStpCartList);
	    	logger.debug("DeleteStpCartEntryAction class - execute method - customerId - "+customerId+" - stored customerStpCartList in sessionMap"); 

	    	return SUCCESS;
	    		
	    	
    	}
    	catch ( Exception e )  {
    		logger.error("DeleteStpCartEntryAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("DeleteStpCartEntryAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getStpCartId() {
		return stpCartId;
	}

	public void setStpCartId(String stpCartId) {
		this.stpCartId = stpCartId;
	}


}

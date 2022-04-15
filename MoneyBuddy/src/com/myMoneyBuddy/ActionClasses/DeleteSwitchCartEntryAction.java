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
import com.myMoneyBuddy.DAOClasses.UpdateCustomerSwitchCart;
import com.myMoneyBuddy.EntityClasses.SwitchCart;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteSwitchCartEntryAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(DeleteSwitchCartEntryAction.class);
	private SessionMap<String,Object> sessionMap;
	private String switchCartId;

    public String execute() {
    	
    	String customerId = null;
    	
    	try {
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("DeleteSwitchCartEntryAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" DeleteSwitchCartEntryAction execute method Called !!");

	    	UpdateCustomerSwitchCart  updateCustomerSwitchCart = new UpdateCustomerSwitchCart();
	    	updateCustomerSwitchCart.deleteCustomerSwitchCartEntry(customerId, switchCartId);
	    	
	    	QuerySwitchCart querySwitchCart = new QuerySwitchCart();
	    	List<SwitchCart> customerSwitchCartList = querySwitchCart.getCustomerSwitchCart(customerId);
	    	
	    	sessionMap.put("customerSwitchCartList", customerSwitchCartList);
	    	logger.debug("DeleteSwitchCartEntryAction class - execute method - customerId - "+customerId+" - stored customerSwitchCartList in sessionMap"); 

	    	return SUCCESS;
	    		
	    	
    	}
    	catch ( Exception e )  {
    		logger.error("DeleteSwitchCartEntryAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("DeleteSwitchCartEntryAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getSwitchCartId() {
		return switchCartId;
	}

	public void setSwitchCartId(String switchCartId) {
		this.switchCartId = switchCartId;
	}


}

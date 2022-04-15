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

import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerCartAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(CustomerCartAction.class);
	private SessionMap<String,Object> sessionMap;
	
	private String anySipOrder;
	private String anyUpfrontOrder;

    public String execute() {
    	
    	String customerId = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("CustomerCartAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" CustomerCartAction execute method Called !!");

	    	QueryCustomerCart queryCustomerCart = new QueryCustomerCart();
	    	List<CustomerCart> customerCartList = queryCustomerCart.getCustomerCart(customerId);
	    	
	    	sessionMap.put("customerCartList", customerCartList);
	    	logger.debug("CustomerCartAction class - execute method - customerId - "+customerId+" - stored customerCartList in sessionMap");   
	    	logger.debug("CustomerCartAction class - execute method - customerId - "+customerId+" - end");
			
	    	if (customerCartList.stream().anyMatch(o -> "UPFRONT".equalsIgnoreCase(o.getTransactionType())))
	    		setAnyUpfrontOrder("TRUE");
	    	else
	    		setAnyUpfrontOrder("FALSE");
			if (customerCartList.stream().anyMatch(o -> "SIP".equalsIgnoreCase(o.getTransactionType())))
				setAnySipOrder("TRUE");
			else
				setAnySipOrder("FALSE");
			
    		System.out.println("anySipOrder : "+anySipOrder);
    		System.out.println("anyUpfrontOrder : "+anyUpfrontOrder);
    		sessionMap.put("anySipOrder", anySipOrder);
    		sessionMap.put("anyUpfrontOrder", anyUpfrontOrder);
			
	
	    	
	    	return SUCCESS;
    	} 
    	catch ( Exception e )  {
    		logger.error("CustomerCartAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    		
    	    logger.error("CustomerCartAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getAnySipOrder() {
		return anySipOrder;
	}

	public void setAnySipOrder(String anySipOrder) {
		this.anySipOrder = anySipOrder;
	}

	public String getAnyUpfrontOrder() {
		return anyUpfrontOrder;
	}

	public void setAnyUpfrontOrder(String anyUpfrontOrder) {
		this.anyUpfrontOrder = anyUpfrontOrder;
	}


}

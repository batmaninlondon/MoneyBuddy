/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.util.List;
import java.util.Map;
import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class CustomerCartAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(CustomerCartAction.class);
	private SessionMap<String,Object> sessionMap;

    public String execute() {
    	
    	String customerId = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("CustomerCartAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" CustomerCartAction execute method Called !!");
	    	
	    	sessionMap.put("transactionType", "UPFRONT");
	    	logger.debug("CustomerCartAction class - execute method - customerId - "+customerId+" - stored transactionType as UPFRONT in sessionMap");

	    	QueryCustomerCart queryCustomerCart = new QueryCustomerCart();
	    	List<CustomerCart> customerCartList = queryCustomerCart.getCustomerCart(customerId);
	    	
	    	System.out.println(" size of customerCartList is : "+customerCartList.size());
	    	
	    	sessionMap.put("customerCartList", customerCartList);
	    	logger.debug("CustomerCartAction class - execute method - customerId - "+customerId+" - stored customerCartList in sessionMap");    	
	
    	    logger.debug("CustomerCartAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("CustomerCartAction class - execute method - customerId - "+customerId+" - end");
	    	
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


}

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

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryStpCart;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.UpdateCustomerStpCart;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.StpCart;
import com.opensymphony.xwork2.ActionSupport;

public class StpAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(StpAction.class);
	private SessionMap<String,Object> sessionMap;

    public String execute() {
    	
    	String customerId = null;
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		QueryStpCart queryStpCart = new QueryStpCart();
    		List<StpCart> customerStpCartList = queryStpCart.getCustomerStpCart(customerId);
    		
    		QueryCustomer queryCustomer = new QueryCustomer();
	    	
	    	Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
	    	
    		logger.debug("StpAction class - execute method - customerId - "+customerId+" - start ");
	    	System.out.println(" StpAction execute method Called !!");

	    	for (int i =0;i<customerStpCartList.size()-1;i++)  {

		    	Trading trading = new Trading();
		    	trading.executeStp(customerId, customerStpCartList.get(i).getWithdrawalFundId(), customerStpCartList.get(i).getFolioNumber(),
		    			customerStpCartList.get(i).getPurchaseFundId(), customerStpCartList.get(i).getStpAmount(), customerStpCartList.get(i).getStpDuration(),
		    			customerStpCartList.get(i).getStpDate(), customerStpCartList.get(i).getStpCartId());
		    	
		    	
	    	}

	    	UpdateCustomerStpCart updateCustomerStpCart = new UpdateCustomerStpCart();
	    	updateCustomerStpCart.emptyCustomerStpCart(customerId);
	
    	    logger.debug("StpAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("StpAction class - execute method - customerId - "+customerId+" - end");
	    	
	    	return SUCCESS;
    	} 
    	catch ( Exception e )  {
    		logger.error("StpAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("StpAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }


}

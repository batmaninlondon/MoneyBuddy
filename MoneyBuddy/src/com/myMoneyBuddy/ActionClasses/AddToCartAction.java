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

import com.myMoneyBuddy.DAOClasses.InsertCustomerCart;
import com.myMoneyBuddy.DAOClasses.QueryCustomerCart;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.opensymphony.xwork2.ActionSupport;

public class AddToCartAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(AddToCartAction.class);
	private SessionMap<String,Object> sessionMap;
	
	private String transactionType;
	private String anySipOrder;
	private String anyUpfrontOrder;

    public String execute() {
    	
    	String customerId = null;
    	
    	try {
    		
    		System.out.println(" transactionType in AddToCartAction is : "+getTransactionType());
    		customerId = sessionMap.get("customerId").toString();
    		
    		QueryCustomerCart queryCustomerCart = new QueryCustomerCart();
    		InsertCustomerCart insertCustomerCart = new InsertCustomerCart();
    		
    		FundDetailsDataModel selectedFundDetailsDataModel = (FundDetailsDataModel) sessionMap.get("selectedFundDetailsDataModel");
    		
    		if ("UPFRONT".equalsIgnoreCase(getTransactionType()))  {
    			
    			if (!queryCustomerCart.existsFund(customerId, selectedFundDetailsDataModel.getFundId(), "UPFRONT"))  {
    				insertCustomerCart.insertRow(selectedFundDetailsDataModel, customerId, transactionType);
    			}
    			else {
    				if (!queryCustomerCart.existsSimilarRow(customerId, selectedFundDetailsDataModel.getFundId(), transactionType))  {
    					insertCustomerCart.insertRow(selectedFundDetailsDataModel, customerId, transactionType);
    				}
    			}
    			
    		}
    		else {
    			if (!queryCustomerCart.existsFund(customerId, selectedFundDetailsDataModel.getFundId(), "SIP"))  {
    				insertCustomerCart.insertRow(selectedFundDetailsDataModel, customerId, transactionType);
    			}
    			else {
    				if (!queryCustomerCart.existsSimilarRow(customerId, selectedFundDetailsDataModel.getFundId(), transactionType))  {
    					insertCustomerCart.insertRow(selectedFundDetailsDataModel, customerId, transactionType);
    				}
    			}
    		}
    		
    		List<CustomerCart> customerCartList = queryCustomerCart.getCustomerCart(customerId);

	    	sessionMap.put("customerCartList", customerCartList);
	    	logger.debug("AddToCartAction class - execute method - customerId - "+customerId+" - stored customerCartList in sessionMap"); 
	    	
	    	if (customerCartList.stream().anyMatch(o -> "UPFRONT".equalsIgnoreCase(o.getTransactionType())))
	    		setAnyUpfrontOrder("TRUE");
	    	else
	    		setAnyUpfrontOrder("FALSE");
			if (customerCartList.stream().anyMatch(o -> "SIP".equalsIgnoreCase(o.getTransactionType())))
				setAnySipOrder("TRUE");
			else
				setAnySipOrder("FALSE");
			
    		System.out.println("anySipOrder : "+anySipOrder);
    		System.out.println("get anyUpfrontOrder : "+getAnyUpfrontOrder());
    		sessionMap.put("anySipOrder", anySipOrder);
    		sessionMap.put("anyUpfrontOrder", anyUpfrontOrder);
	
	    	return SUCCESS;
	    	
    	} 
    	catch ( Exception e )  {
    		logger.error("AddToCartAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("AddToCartAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
    	}
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
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

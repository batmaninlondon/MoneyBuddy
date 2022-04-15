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

import com.myMoneyBuddy.DAOClasses.InsertCustomerStpCart;
import com.myMoneyBuddy.DAOClasses.QueryStpCart;
import com.myMoneyBuddy.EntityClasses.StpCart;
import com.opensymphony.xwork2.ActionSupport;

public class AddToStpCartAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(AddToStpCartAction.class);
	private SessionMap<String,Object> sessionMap;
	
	private String stpFundId;
	private String stpAmount;
	private String stpFolioNum;
	
	
    public String execute() {

    	String customerId = null;
    	
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
			
			QueryStpCart queryStpCart = new QueryStpCart();	
			InsertCustomerStpCart insertCustomerStpCart = new InsertCustomerStpCart();
			
			if (!queryStpCart.existsFund(customerId, stpFundId, stpFolioNum) )  {
				insertCustomerStpCart.insertRow(customerId, stpFundId, stpFolioNum,stpAmount);
			}
		
		
			List<StpCart> customerStpCartList = queryStpCart.getCustomerStpCart(customerId);
	
	    	sessionMap.put("customerStpCartList", customerStpCartList);
	    	logger.debug("AddToStpCartAction class - execute method - customerId - "+customerId+" - stored customerStpCartList in sessionMap"); 
	    	
	
	    	return SUCCESS;
    	
		} 
    	catch (Exception e) {	
    		logger.error("AddToStpCartAction class - execute method - Caught Exception");
			e.printStackTrace();

    	    logger.error("AddToStpCartAction class - execute method - returned error");
    	    
			return ERROR;
		} 

    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getStpFundId() {
		return stpFundId;
	}

	public void setStpFundId(String stpFundId) {
		this.stpFundId = stpFundId;
	}

	public String getStpAmount() {
		return stpAmount;
	}

	public void setStpAmount(String stpAmount) {
		this.stpAmount = stpAmount;
	}

	public String getStpFolioNum() {
		return stpFolioNum;
	}

	public void setStpFolioNum(String stpFolioNum) {
		this.stpFolioNum = stpFolioNum;
	}

}

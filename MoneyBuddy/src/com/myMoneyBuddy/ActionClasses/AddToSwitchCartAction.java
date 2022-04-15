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

import com.myMoneyBuddy.DAOClasses.InsertCustomerSwitchCart;
import com.myMoneyBuddy.DAOClasses.QuerySwitchCart;
import com.myMoneyBuddy.EntityClasses.SwitchCart;
import com.opensymphony.xwork2.ActionSupport;

public class AddToSwitchCartAction extends ActionSupport  implements SessionAware{

	Logger logger = LogManager.getLogger(AddToSwitchCartAction.class);
	private SessionMap<String,Object> sessionMap;
	
	private String switchFundId;
	private String switchAmount;
	private String switchUnit;
	private String switchFolioNum;
	
	
    public String execute() {
  	
    	String customerId = null;
    	
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
			System.out.println("Calling AddToSwitchCartAction class - start : switchAmount is : "+switchAmount+" and switchUnit : "+switchUnit);
			
			QuerySwitchCart querySwitchCart = new QuerySwitchCart();	
			InsertCustomerSwitchCart insertCustomerSwitchCart = new InsertCustomerSwitchCart();
			
			if (!querySwitchCart.existsFund(customerId, switchFundId, switchFolioNum) )  {
				insertCustomerSwitchCart.insertRow(customerId, switchFundId, switchFolioNum,switchAmount,switchUnit);
			}
		
		
			List<SwitchCart> customerSwitchCartList = querySwitchCart.getCustomerSwitchCart(customerId);
	
	    	sessionMap.put("customerSwitchCartList", customerSwitchCartList);
	    	logger.debug("AddToSwitchCartAction class - execute method - customerId - "+customerId+" - stored customerSwitchCartList in sessionMap"); 
	    	
	
	    	return SUCCESS;
    	
		} 
    	catch (Exception e) {	
    		logger.error("AddToSwitchCartAction class - execute method - Caught Exception");
			e.printStackTrace();

    	    logger.error("AddToSwitchCartAction class - execute method - returned error");
    	    
			return ERROR;
		} 

    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public String getSwitchFundId() {
		return switchFundId;
	}

	public void setSwitchFundId(String switchFundId) {
		this.switchFundId = switchFundId;
	}

	public String getSwitchAmount() {
		return switchAmount;
	}

	public void setSwitchAmount(String switchAmount) {
		this.switchAmount = switchAmount;
	}

	public String getSwitchUnit() {
		return switchUnit;
	}

	public void setSwitchUnit(String switchUnit) {
		this.switchUnit = switchUnit;
	}

	public String getSwitchFolioNum() {
		return switchFolioNum;
	}

	public void setSwitchFolioNum(String switchFolioNum) {
		this.switchFolioNum = switchFolioNum;
	}



}

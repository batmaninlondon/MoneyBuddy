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

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.StpDataModel;
import com.opensymphony.xwork2.ActionSupport;

public class PortfolioStpDataAction extends ActionSupport implements SessionAware{
	
	Logger logger = LogManager.getLogger(PortfolioStpDataAction.class);
	private SessionMap<String,Object> sessionMap;

	private List<StpDataModel> stpDataModel;


	public String execute()   {
		System.out.println(" Called getActiveStpData  ...........................................................................................");
		String customerId = sessionMap.get("customerId").toString();
		QueryProducts queryProducts = new QueryProducts();
		try {
			QueryCustomer queryCustomer = new QueryCustomer(); 
			Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
			String userType = customer.getUserType();
			
			if ("ADMIN".equals(userType))  {
				customerId = sessionMap.get("customerIdFromAdmin").toString();
	    	}
			stpDataModel = queryProducts.getStpData(customerId);
			setStpDataModel(stpDataModel);
			return SUCCESS;
		} catch (MoneyBuddyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
	}


	public List<StpDataModel> getStpDataModel() {
		return stpDataModel;
	}


	public void setStpDataModel(List<StpDataModel> stpDataModel) {
		this.stpDataModel = stpDataModel;
	}

	@Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }


}

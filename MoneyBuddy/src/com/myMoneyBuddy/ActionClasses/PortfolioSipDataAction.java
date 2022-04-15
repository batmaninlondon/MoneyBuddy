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
import com.myMoneyBuddy.ModelClasses.SipDataModel;
import com.opensymphony.xwork2.ActionSupport;

public class PortfolioSipDataAction extends ActionSupport implements SessionAware{
	
	Logger logger = LogManager.getLogger(PortfolioSipDataAction.class);
	private SessionMap<String,Object> sessionMap;

	private List<SipDataModel> sipDataModel;


	public String execute()   {
		System.out.println(" Called getActiveSipData  ...........................................................................................");
		String customerId = sessionMap.get("customerId").toString();
		
		QueryProducts queryProducts = new QueryProducts();
		try {
			QueryCustomer queryCustomer = new QueryCustomer(); 
			Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
			String userType = customer.getUserType();
			
			if ("ADMIN".equals(userType))  {
				customerId = sessionMap.get("customerIdFromAdmin").toString();
	    	}
			sipDataModel = queryProducts.getSipData(customerId);
			setSipDataModel(sipDataModel);
			return SUCCESS;
		} catch (MoneyBuddyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
	}


	public List<SipDataModel> getSipDataModel() {
		return sipDataModel;
	}


	public void setSipDataModel(List<SipDataModel> sipDataModel) {
		this.sipDataModel = sipDataModel;
	}

	@Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }


}

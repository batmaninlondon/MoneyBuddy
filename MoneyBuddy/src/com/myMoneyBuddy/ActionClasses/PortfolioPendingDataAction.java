/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.util.LinkedList;
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
import com.myMoneyBuddy.ModelClasses.PendingOrderDataModel;
import com.opensymphony.xwork2.ActionSupport;

public class PortfolioPendingDataAction extends ActionSupport implements SessionAware{
	
	Logger logger = LogManager.getLogger(PortfolioPendingDataAction.class);
	private SessionMap<String,Object> sessionMap;

	private List<PendingOrderDataModel> pendingOrderDataModel = new LinkedList<PendingOrderDataModel>();


	public String execute()   {
		System.out.println(" Called getPendingOrderData  ...........................................................................................");
		String customerId = sessionMap.get("customerId").toString();
		QueryProducts queryProducts = new QueryProducts();
		try {
			QueryCustomer queryCustomer = new QueryCustomer(); 
			Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
			String userType = customer.getUserType();
			
			if ("ADMIN".equals(userType))  {
				customerId = sessionMap.get("customerIdFromAdmin").toString();
	    	}
			
			String totalPendingOrders = queryProducts.getTotalPendingTransactions(customerId);
			
			System.out.println("SAVITA WADHWANI : totalPendingOrders : "+totalPendingOrders);
			
			if (!totalPendingOrders.equals("0"))
				pendingOrderDataModel = queryProducts.getPendingOrderData(customerId);
			setPendingOrderDataModel(pendingOrderDataModel);
			return SUCCESS;
		} catch (MoneyBuddyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
	}

	public List<PendingOrderDataModel> getPendingOrderDataModel() {
		return pendingOrderDataModel;
	}


	public void setPendingOrderDataModel(List<PendingOrderDataModel> pendingOrderDataModel) {
		this.pendingOrderDataModel = pendingOrderDataModel;
	}

	@Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }


}

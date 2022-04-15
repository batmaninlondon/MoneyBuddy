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
import com.myMoneyBuddy.ModelClasses.InvestmentDetailsDataModel;
import com.opensymphony.xwork2.ActionSupport;

public class PortfolioHistoryDataAction extends ActionSupport implements SessionAware{
	
	Logger logger = LogManager.getLogger(PortfolioHistoryDataAction.class);
	private SessionMap<String,Object> sessionMap;

	private List<InvestmentDetailsDataModel> allFundsInvestmentDetailsDataModel;


	public String execute()   {
		System.out.println(" Called getTransactionHistoryData  ...........................................................................................");
		String customerId = sessionMap.get("customerId").toString();
		QueryProducts queryProducts = new QueryProducts();
		try {
			QueryCustomer queryCustomer = new QueryCustomer(); 
			Customers customer = queryCustomer.getCustomerFromCustomerId(customerId);
			String userType = customer.getUserType();
			
			if ("ADMIN".equals(userType))  {
				customerId = sessionMap.get("customerIdFromAdmin").toString();
	    	}
			
			System.out.println("customerId in getTransactionHistoryData: "+customerId);
			
			allFundsInvestmentDetailsDataModel = queryProducts.getAllFundsInvestmentDetailsData(customerId);
			setAllFundsInvestmentDetailsDataModel(allFundsInvestmentDetailsDataModel);
			
			System.out.println("Size of allFundsInvestmentDetailsDataModel : "+allFundsInvestmentDetailsDataModel.size());
			return SUCCESS;
		} catch (MoneyBuddyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
	}

	public List<InvestmentDetailsDataModel> getAllFundsInvestmentDetailsDataModel() {
		return allFundsInvestmentDetailsDataModel;
	}


	public void setAllFundsInvestmentDetailsDataModel(List<InvestmentDetailsDataModel> allFundsInvestmentDetailsDataModel) {
		this.allFundsInvestmentDetailsDataModel = allFundsInvestmentDetailsDataModel;
	}

	@Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }


}

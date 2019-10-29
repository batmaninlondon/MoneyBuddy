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

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.InvestmentDetailsDataModel;
import com.myMoneyBuddy.ModelClasses.SipDataModel;
import com.opensymphony.xwork2.ActionSupport;

public class PortfolioHistoryDataAction extends ActionSupport implements SessionAware{
	
	Logger logger = Logger.getLogger(PortfolioHistoryDataAction.class);
	private SessionMap<String,Object> sessionMap;

	private List<InvestmentDetailsDataModel> allFundsInvestmentDetailsDataModel;


	public String execute()   {
		System.out.println(" Called getTransactionHistoryData  ...........................................................................................");
		String customerId = sessionMap.get("customerId").toString();
		QueryProducts queryProducts = new QueryProducts();
		try {
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

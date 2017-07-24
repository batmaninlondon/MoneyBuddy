/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.InvestmentDetailsDataModel;
import com.myMoneyBuddy.DAOClasses.PortfolioDataModel;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

public class InvestmentDetailsAction extends ActionSupport implements SessionAware{
	
	Logger logger = Logger.getLogger(InvestmentDetailsAction.class);
	private Map<String, Object> sessionMap;

	private List<InvestmentDetailsDataModel> investmentDetailsDataModel;
	private String dummyMsg;
	private String productName;


	public String execute() {

		try {
		logger.debug("InvestmentDetailsAction class : execute method : start");
		dummyMsg = "InvestmentDetails representation";
		

		QueryProducts queryProducts = new QueryProducts();
		/*dashboardDataModel = queryProducts.getDashboardData(sessionMap.get("customerId").toString(),investmentTypeName);*/
		
		System.out.println("InvestmentDetails action class called - start ");
		
		investmentDetailsDataModel = queryProducts.getInvestmentDetailsData(sessionMap.get("customerId").toString(),getProductName());

		System.out.println("InvestmentDetails action class called - end ");
		
		logger.debug("InvestmentDetailsAction class : execute method : end");

		return SUCCESS;
		}
		catch (MoneyBuddyException e) {	
			logger.debug("InvestmentDetailsAction class : execute method : Caught MoneyBuddyException for customerId : "+sessionMap.get("customerId").toString());
			e.printStackTrace();
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.debug("InvestmentDetailsAction class : execute method : Caught Exception for customerId : "+sessionMap.get("customerId").toString());
			e.printStackTrace();
			return ERROR;
		} 
	}

	public List<InvestmentDetailsDataModel> getInvestmentDetailsDataModel() {
		return investmentDetailsDataModel;
	}

	public void setInvestmentDetailsDataModel(List<InvestmentDetailsDataModel> investmentDetailsDataModel) {
		this.investmentDetailsDataModel = investmentDetailsDataModel;
	}

	public String getDummyMsg() {
		return dummyMsg;
	}

	public void setDummyMsg(String dummyMsg) {
		this.dummyMsg = dummyMsg;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public Map<String, Object> getSession() {
		return sessionMap;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


}

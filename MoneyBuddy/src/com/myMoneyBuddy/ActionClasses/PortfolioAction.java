/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.PortfolioDataModel;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

public class PortfolioAction extends ActionSupport implements SessionAware{
	
	Logger logger = Logger.getLogger(PortfolioAction.class);
	private Map<String, Object> sessionMap;

	private List<PortfolioDataModel> portfolioDataModel;
	private String dummyMsg;

	public List<PortfolioDataModel> getPortfolioDataModel() {
		return portfolioDataModel;
	}

	public void setPortfolioDataModel(
			List<PortfolioDataModel> portfolioDataModel) {
		this.portfolioDataModel = portfolioDataModel;
	}

	public String getDummyMsg() {
		return dummyMsg;
	}

	public void setDummyMsg(String dummyMsg) {
		this.dummyMsg = dummyMsg;
	}

	public String execute() {

		try {
		logger.debug("PortfolioAction class : execute method : start");
		dummyMsg = "Portfolio representation";

		QueryProducts queryProducts = new QueryProducts();
		/*dashboardDataModel = queryProducts.getDashboardData(sessionMap.get("customerId").toString(),investmentTypeName);*/
		
		System.out.println("portfolio action class called - start ");
		
		portfolioDataModel = queryProducts.getPortfolioData(sessionMap.get("customerId").toString());

		System.out.println("portfolio action class called - end ");
		
		logger.debug("PortfolioAction class : execute method : end");

		return SUCCESS;
		}
		catch (MoneyBuddyException e) {	
			logger.debug("PortfolioAction class : execute method : Caught MoneyBuddyException for customerId : "+sessionMap.get("customerId").toString());
			e.printStackTrace();
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.debug("PortfolioAction class : execute method : Caught Exception for customerId : "+sessionMap.get("customerId").toString());
			e.printStackTrace();
			return ERROR;
		} 
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public Map<String, Object> getSession() {
		return sessionMap;
	}


}

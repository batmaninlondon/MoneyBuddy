/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.DashboardDataModel;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

public class DashboardAction extends ActionSupport implements SessionAware{
	
	Logger logger = Logger.getLogger(DashboardAction.class);
	private Map<String, Object> sessionMap;

	private List<DashboardDataModel> dashboardDataModel;
	private String dummyMsg;
	/*private String investmentTypeName;*/

	public List<DashboardDataModel> getDashboardDataModel() {
		return dashboardDataModel;
	}

	public void setDashboardDataModel(
			List<DashboardDataModel> dashboardDataModel) {
		this.dashboardDataModel = dashboardDataModel;
	}

	public String getDummyMsg() {
		return dummyMsg;
	}

	public void setDummyMsg(String dummyMsg) {
		this.dummyMsg = dummyMsg;
	}

	public String execute() {

		try {
		logger.debug("DashboardAction class : execute method : start");
		dummyMsg = "Dashboard representation";

		QueryProducts queryProducts = new QueryProducts();
		/*dashboardDataModel = queryProducts.getDashboardData(sessionMap.get("customerId").toString(),investmentTypeName);*/
		
		dashboardDataModel = queryProducts.getDashboardData(sessionMap.get("customerId").toString());

		logger.debug("DashboardAction class : execute method : end");

		return SUCCESS;
		}
		catch (MoneyBuddyException e) {	
			logger.debug("DashboardAction class : execute method : Caught MoneyBuddyException for customerId : "+sessionMap.get("customerId").toString());
			e.printStackTrace();
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.debug("DashboardAction class : execute method : Caught Exception for customerId : "+sessionMap.get("customerId").toString());
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

/*	public String getInvestmentTypeName() {
		return investmentTypeName;
	}

	public void setInvestmentTypeName(String investmentTypeName) {
		this.investmentTypeName = investmentTypeName;
	}*/




}

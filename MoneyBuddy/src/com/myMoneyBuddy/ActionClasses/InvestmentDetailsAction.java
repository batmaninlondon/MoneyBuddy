/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.InvestmentDetailsDataModel;
import com.myMoneyBuddy.ModelClasses.PortfolioDataModel;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

public class InvestmentDetailsAction extends ActionSupport implements SessionAware{
	
	Logger logger = Logger.getLogger(InvestmentDetailsAction.class);
	private Map<String, Object> sessionMap;

	private List<InvestmentDetailsDataModel> investmentDetailsDataModel;
	private String dummyMsg;
	private String productName;

	private InputStream stream;
	
	public String execute() {

		try {
			logger.debug("InvestmentDetailsAction class : execute method : start");
			dummyMsg = "InvestmentDetails representation";
			
			HashMap<String,List<InvestmentDetailsDataModel>> investmentDetailsDataModelList = (HashMap<String,List<InvestmentDetailsDataModel>>) sessionMap.get("investmentDetailsDataModelList");
			
			investmentDetailsDataModel = investmentDetailsDataModelList.get(getProductName());
	
			/*QueryProducts queryProducts = new QueryProducts();
			dashboardDataModel = queryProducts.getDashboardData(sessionMap.get("customerId").toString(),investmentTypeName);
			System.out.println("InvestmentDetails action class called - start ");
			System.out.println("InvestmentDetails action class :  productName : "+getProductName());
			System.out.println("InvestmentDetails action class :  productName.length() : "+getProductName().length());
			
			//sessionMap.remove("investmentDetailsDataModel");
			
			investmentDetailsDataModel = queryProducts.getInvestmentDetailsData(sessionMap.get("customerId").toString(),getProductName());*/
	
			sessionMap.put("investmentDetailsDataModel", investmentDetailsDataModel);
			logger.debug("InvestmentDetailsAction class : execute method : stored investmentDetailsDataModel : "+investmentDetailsDataModel+" in session id : "+sessionMap.getClass().getName());
			
			System.out.println("InvestmentDetailsAction class : execute method : investmentDetailsDataModel.size() : "+investmentDetailsDataModel.size());
			
			System.out.println("InvestmentDetails action class called - end ");
			
			logger.debug("InvestmentDetailsAction class : execute method : end");
	
			String str = "success";
		    stream = new ByteArrayInputStream(str.getBytes());
			return SUCCESS;
		} 
    	catch (Exception e) {	
    		logger.debug("InvestmentDetailsAction class : execute method : Caught Exception for customerId : "+sessionMap.get("customerId").toString());
			e.printStackTrace();
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
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

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

}

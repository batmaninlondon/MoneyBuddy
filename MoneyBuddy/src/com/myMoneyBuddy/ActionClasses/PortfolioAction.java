/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.InvestmentDetailsDataModel;
import com.myMoneyBuddy.ModelClasses.PendingOrderDataModel;
import com.myMoneyBuddy.ModelClasses.PortfolioDataModel;
import com.myMoneyBuddy.ModelClasses.SipDataModel;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class PortfolioAction extends ActionSupport implements SessionAware{
	
	Logger logger = Logger.getLogger(PortfolioAction.class);
	private SessionMap<String,Object> sessionMap;

	private String totalRateOfGrowth;
	private String totalCurrentAmount;
	private List<PortfolioDataModel> portfolioDataModel;
	private List<PendingOrderDataModel> pendingOrderDataModel;
	private List<SipDataModel> sipDataModel;

	private HashMap<String,List<InvestmentDetailsDataModel>> investmentDetailsDataModelList = new HashMap<String,List<InvestmentDetailsDataModel>>();
	
	private List<InvestmentDetailsDataModel> investmentDetailsDataModel;
	private List<InvestmentDetailsDataModel> allFundsInvestmentDetailsDataModel;

	public String execute() {

		try {
		logger.debug("PortfolioAction class : execute method : start");

		QueryProducts queryProducts = new QueryProducts();
		
		System.out.println("portfolio action class called - start ");

		portfolioDataModel = queryProducts.getPortfolioData(sessionMap.get("customerId").toString());
		setPortfolioDataModel(portfolioDataModel);
		
		pendingOrderDataModel = queryProducts.getPendingOrderData(sessionMap.get("customerId").toString());
		setPendingOrderDataModel(pendingOrderDataModel);
		
		HashMap<String,String> dataSet = new HashMap<String,String>();
		
		
		String[] colors = { "Red", "Blue", "Yellow", "Green", "Purple", "Orange" };
		int i =0;
		for (PortfolioDataModel portfolioDataModelElement : portfolioDataModel){
			if ("Total".equals(portfolioDataModelElement.getFundName())) {
				setTotalCurrentAmount(portfolioDataModelElement.getCurrentAmount());
				System.out.println("TOTAL AMOUNT SET TO : "+getTotalCurrentAmount() );
				
				//sessionMap.put("totalCurrentAmount", portfolioDataModelElement.getCurrentAmount());
				//logger.debug("PortfolioAction class : execute method : stored totalCurrentAmount in session id : "+sessionMap.getClass().getName());
				
				setTotalRateOfGrowth(portfolioDataModelElement.getRateOfGrowth());
				System.out.println("TOTAL GROWTH RATE SET TO : "+ getTotalRateOfGrowth() );
				//sessionMap.put("totalRateOfGrowth", portfolioDataModelElement.getRateOfGrowth());
				//logger.debug("PortfolioAction class : execute method : stored totalRateOfGrowth in session id : "+sessionMap.getClass().getName());
			}
			else {
				dataSet.put(colors[i],portfolioDataModelElement.getCurrentAmount());
				i = (i == 5) ? i=0 : i++;
				
			}
		}

		//sessionMap.put("portfolioDataModel", portfolioDataModel);
		logger.debug("PortfolioAction class : execute method : stored portfolioDataModel in session id : "+sessionMap.getClass().getName());
		
		sipDataModel = queryProducts.getSipData(sessionMap.get("customerId").toString());
		setSipDataModel(sipDataModel);

		sessionMap.put("sipDataModel", sipDataModel);
		logger.debug("PortfolioAction class : execute method : stored sipDataModel in session id : "+sessionMap.getClass().getName());

		String fundId = null;
		for (PortfolioDataModel portfolioDataModelElement : portfolioDataModel) {
			fundId = portfolioDataModelElement.getFundId();
			System.out.println("fundId : "+fundId);
			
			investmentDetailsDataModel = queryProducts.getInvestmentDetailsData(sessionMap.get("customerId").toString(),fundId);
			investmentDetailsDataModelList.put(fundId,investmentDetailsDataModel);
			
		}
		// Savita Wadhwani - Added this for chart testing - start
		
		investmentDetailsDataModel = queryProducts.getInvestmentDetailsData(sessionMap.get("customerId").toString(),"RELLFCP-GR");
		setInvestmentDetailsDataModel(investmentDetailsDataModel);
		
		System.out.println("Size of investmentDetailsDataModel : "+investmentDetailsDataModel.size());
		
		// Savita Wadhwani - Added this for chart testing - end
		
		allFundsInvestmentDetailsDataModel = queryProducts.getAllFundsInvestmentDetailsData(sessionMap.get("customerId").toString());
		setAllFundsInvestmentDetailsDataModel(allFundsInvestmentDetailsDataModel);
		
		System.out.println("Size of allFundsInvestmentDetailsDataModel : "+allFundsInvestmentDetailsDataModel.size());
		
		sessionMap.put("allFundsInvestmentDetailsDataModel", allFundsInvestmentDetailsDataModel);
		logger.debug("PortfolioAction class : execute method : stored allFundsInvestmentDetailsDataModel in session id : "+sessionMap.getClass().getName());
		
		for (String key : investmentDetailsDataModelList.keySet())  {
			System.out.println("key : "+key);
			for (InvestmentDetailsDataModel dataMadel : investmentDetailsDataModelList.get(key))  {
				System.out.println("dataMadel.getTransactionDate() : "+dataMadel.getTransactionDate());
				System.out.println("dataMadel.getUnits() : "+dataMadel.getUnits());
				System.out.println("dataMadel.getNavPurchased() : "+dataMadel.getNavPurchased());
				System.out.println("dataMadel.getTransactionType() : "+dataMadel.getTransactionType());
				
			}
		}
		sessionMap.put("investmentDetailsDataModelList", investmentDetailsDataModelList);
		logger.debug("PortfolioAction class : execute method : stored investmentDetailsDataModelList in session id : "+sessionMap.getClass().getName());
		
		logger.debug("PortfolioAction class : execute method : end");
    	
		return SUCCESS;
		}
		catch (MoneyBuddyException e) {	
			logger.error("PortfolioAction class : execute method : Caught MoneyBuddyException for customerId : "+sessionMap.get("customerId").toString());
			e.printStackTrace();
			
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.error("PortfolioAction class : execute method : Caught Exception for customerId : "+sessionMap.get("customerId").toString());
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


	public List<PortfolioDataModel> getPortfolioDataModel() {
		return portfolioDataModel;
	}

	public void setPortfolioDataModel(
			List<PortfolioDataModel> pMdl) {
		this.portfolioDataModel = pMdl;
	}

	@Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public HashMap<String, List<InvestmentDetailsDataModel>> getInvestmentDetailsDataModelList() {
		return investmentDetailsDataModelList;
	}


	public void setInvestmentDetailsDataModelList(
			HashMap<String, List<InvestmentDetailsDataModel>> investmentDetailsDataModelList) {
		this.investmentDetailsDataModelList = investmentDetailsDataModelList;
	}


	public List<InvestmentDetailsDataModel> getInvestmentDetailsDataModel() {
		return investmentDetailsDataModel;
	}


	public void setInvestmentDetailsDataModel(List<InvestmentDetailsDataModel> investmentDetailsDataModel) {
		this.investmentDetailsDataModel = investmentDetailsDataModel;
	}


	public List<InvestmentDetailsDataModel> getAllFundsInvestmentDetailsDataModel() {
		return allFundsInvestmentDetailsDataModel;
	}


	public void setAllFundsInvestmentDetailsDataModel(List<InvestmentDetailsDataModel> allFundsInvestmentDetailsDataModel) {
		this.allFundsInvestmentDetailsDataModel = allFundsInvestmentDetailsDataModel;
	}


	public List<PendingOrderDataModel> getPendingOrderDataModel() {
		return pendingOrderDataModel;
	}


	public void setPendingOrderDataModel(List<PendingOrderDataModel> pendingOrderDataModel) {
		this.pendingOrderDataModel = pendingOrderDataModel;
	}


	public String getTotalRateOfGrowth() {
		return totalRateOfGrowth;
	}


	public void setTotalRateOfGrowth(String totalRateOfGrowth) {
		this.totalRateOfGrowth = totalRateOfGrowth;
	}


	public String getTotalCurrentAmount() {
		return totalCurrentAmount;
	}


	public void setTotalCurrentAmount(String totalCurrentAmount) {
		this.totalCurrentAmount = totalCurrentAmount;
	}


}

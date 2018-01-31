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
import com.myMoneyBuddy.ModelClasses.SipDataModel;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

public class PortfolioAction extends ActionSupport implements SessionAware{
	
	Logger logger = Logger.getLogger(PortfolioAction.class);
	private Map<String, Object> session;

	private List<PortfolioDataModel> portfolioDataModel;
	private List<SipDataModel> sipDataModel;
	
	// Savita Wadhwani - Added this for chart testing - start 
	private List<PortfolioDataModel> newPortfolioDataModel;
	// Savita Wadhwani - Added this for chart testing - end
	
	private String dummyMsg;
	private HashMap<String,List<InvestmentDetailsDataModel>> investmentDetailsDataModelList = new HashMap<String,List<InvestmentDetailsDataModel>>();
	
	private List<InvestmentDetailsDataModel> investmentDetailsDataModel;
	private List<InvestmentDetailsDataModel> allFundsInvestmentDetailsDataModel;
/*	
	private InputStream stream;*/

	public String execute() {

		try {
		logger.debug("PortfolioAction class : execute method : start");
		dummyMsg = "Portfolio representation";

		QueryProducts queryProducts = new QueryProducts();
		/*dashboardDataModel = queryProducts.getDashboardData(sessionMap.get("customerId").toString(),investmentTypeName);*/
		
		System.out.println("portfolio action class called - start ");

		//session.remove("portfolioDataModel");
		portfolioDataModel = queryProducts.getPortfolioData(session.get("customerId").toString());
		setPortfolioDataModel(portfolioDataModel);
		
		for (PortfolioDataModel portfolioDataModelElement : portfolioDataModel){
			if ("Total".equals(portfolioDataModelElement.getFundName())) {
				session.put("totalCurrentAmount", portfolioDataModelElement.getCurrentAmount());
				logger.debug("PortfolioAction class : execute method : stored totalCurrentAmount in session id : "+session.getClass().getName());
				session.put("totalRateOfGrowth", portfolioDataModelElement.getRateOfGrowth());
				logger.debug("PortfolioAction class : execute method : stored totalRateOfGrowth in session id : "+session.getClass().getName());
			}
		}
		
		// Savita Wadhwani - Added this for chart testing - start 
		newPortfolioDataModel = portfolioDataModel;
		setNewPortfolioDataModel(newPortfolioDataModel);
		// Savita Wadhwani - Added this for chart testing - end
		
		//session.put("portfolioDataModel", null);
		session.put("portfolioDataModel", portfolioDataModel);
		logger.debug("PortfolioAction class : execute method : stored portfolioDataModel in session id : "+session.getClass().getName());
		
		sipDataModel = queryProducts.getSipData(session.get("customerId").toString());
		setSipDataModel(sipDataModel);

		
		//session.put("portfolioDataModel", null);
		session.put("sipDataModel", sipDataModel);
		logger.debug("PortfolioAction class : execute method : stored sipDataModel in session id : "+session.getClass().getName());

		String fundId = null;
		for (PortfolioDataModel portfolioDataModelElement : portfolioDataModel) {
			fundId = portfolioDataModelElement.getFundId();
			System.out.println("fundId : "+fundId);
			
			investmentDetailsDataModel = queryProducts.getInvestmentDetailsData(session.get("customerId").toString(),fundId);
			investmentDetailsDataModelList.put(fundId,investmentDetailsDataModel);
			
		}
		// Savita Wadhwani - Added this for chart testing - start
		
		investmentDetailsDataModel = queryProducts.getInvestmentDetailsData(session.get("customerId").toString(),"RELLFCP-GR");
		setInvestmentDetailsDataModel(investmentDetailsDataModel);
		
		System.out.println("Size of investmentDetailsDataModel : "+investmentDetailsDataModel.size());
		
		// Savita Wadhwani - Added this for chart testing - end
		
		allFundsInvestmentDetailsDataModel = queryProducts.getAllFundsInvestmentDetailsData(session.get("customerId").toString());
		setAllFundsInvestmentDetailsDataModel(allFundsInvestmentDetailsDataModel);
		
		System.out.println("Size of allFundsInvestmentDetailsDataModel : "+allFundsInvestmentDetailsDataModel.size());
		
		session.put("allFundsInvestmentDetailsDataModel", allFundsInvestmentDetailsDataModel);
		logger.debug("PortfolioAction class : execute method : stored allFundsInvestmentDetailsDataModel in session id : "+session.getClass().getName());
		
		for (String key : investmentDetailsDataModelList.keySet())  {
			System.out.println("key : "+key);
			for (InvestmentDetailsDataModel dataMadel : investmentDetailsDataModelList.get(key))  {
				System.out.println("dataMadel.getTransactionDate() : "+dataMadel.getTransactionDate());
				System.out.println("dataMadel.getUnits() : "+dataMadel.getUnits());
				System.out.println("dataMadel.getNavPurchased() : "+dataMadel.getNavPurchased());
				System.out.println("dataMadel.getTransactionType() : "+dataMadel.getTransactionType());
				
			}
		}
		session.put("investmentDetailsDataModelList", investmentDetailsDataModelList);
		logger.debug("PortfolioAction class : execute method : stored investmentDetailsDataModelList in session id : "+session.getClass().getName());
		
		/*Double TotalInvestedAmount = 0.0;
		Double TotalCurrentAmount = 0.0;
		for ( PortfolioDataModel portfolioDataModelElement : portfolioDataModel )  {
			
			
			TotalInvestedAmount = TotalInvestedAmount + Double.parseDouble(portfolioDataModelElement.getInvestedAmount());
			TotalCurrentAmount = TotalCurrentAmount + Double.parseDouble(portfolioDataModelElement.getCurrentAmount());
		}
		
		Double TotalrateOfGrowth = ((TotalCurrentAmount - TotalInvestedAmount)/TotalInvestedAmount)*100;
	
		
		session.put("TotalInvestedAmount", String.format("%.2f", TotalInvestedAmount));
		logger.debug("PortfolioAction class : execute method : stored TotalInvestedAmount in session id : "+session.getClass().getName());

		session.put("TotalCurrentAmount", String.format("%.2f", TotalCurrentAmount));
		logger.debug("PortfolioAction class : execute method : stored TotalCurrentAmount in session id : "+session.getClass().getName());
		
		session.put("TotalrateOfGrowth", String.format("%.2f", TotalrateOfGrowth));
		logger.debug("PortfolioAction class : execute method : stored TotalrateOfGrowth in session id : "+session.getClass().getName());
		
		System.out.println("Vivek printing session information "+session.get("portfolioDataModel"));
		System.out.println("portfolio action class called - end ");*/
		
		logger.debug("PortfolioAction class : execute method : end");

/*		String str = "success";
    	stream = new ByteArrayInputStream(str.getBytes());*/
    	
		return SUCCESS;
		}
		catch (MoneyBuddyException e) {	
			logger.debug("PortfolioAction class : execute method : Caught MoneyBuddyException for customerId : "+session.get("customerId").toString());
			e.printStackTrace();
/*			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.debug("PortfolioAction class : execute method : Caught Exception for customerId : "+session.get("customerId").toString());
			e.printStackTrace();
/*			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
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
	// Savita Wadhwani - Added this for chart testing - start 

	public List<PortfolioDataModel> getNewPortfolioDataModel() {
		return newPortfolioDataModel;
	}


	public void setNewPortfolioDataModel(List<PortfolioDataModel> newPortfolioDataModel) {
		this.newPortfolioDataModel = newPortfolioDataModel;
	}	
	// Savita Wadhwani - Added this for chart testing - end

	public String getDummyMsg() {
		return dummyMsg;
	}



	public void setDummyMsg(String dummyMsg) {
		this.dummyMsg = dummyMsg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}
/*
	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

*/
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



}

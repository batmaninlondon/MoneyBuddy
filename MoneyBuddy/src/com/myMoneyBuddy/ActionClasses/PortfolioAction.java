/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.EntityClasses.Customers;
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

	private String customerName;
	private String profitDir;
	private String profitValue;
	private String curDate;
	private String totalRateOfGrowth;
	private String totalCurrentAmount;
	private String totalInvestedAmount;
	private String totalProfitAmount;
	private List<PortfolioDataModel> portfolioDataModel;
	private List<PendingOrderDataModel> pendingOrderDataModel = new LinkedList<PendingOrderDataModel>();;
	private List<SipDataModel> sipDataModel;
	private String totalUpfrontInvestments;
	private String totalSips;
	private String totalTransactions;
	private String totalPendingOrders;

	//private HashMap<String,List<InvestmentDetailsDataModel>> investmentDetailsDataModelList = new HashMap<String,List<InvestmentDetailsDataModel>>();
	
	//private List<InvestmentDetailsDataModel> investmentDetailsDataModel;
	private List<InvestmentDetailsDataModel> allFundsInvestmentDetailsDataModel;

	public String execute() {

		String customerId = sessionMap.get("customerId").toString();
		try {
		logger.debug("PortfolioAction class : execute method : start");

		
		
		QueryCustomer queryCustomer = new QueryCustomer();
		
		setCustomerName(queryCustomer.getCustomerNameFromId(customerId));
		
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");  
		setCurDate(dateFormat.format(date));  
		
		QueryProducts queryProducts = new QueryProducts();
		
		System.out.println("portfolio action class called - start ");

		portfolioDataModel = queryProducts.getPortfolioData(customerId);
		setPortfolioDataModel(portfolioDataModel);
		
		setTotalPendingOrders(queryProducts.getTotalPendingTransactions(customerId));
		
		if (!getTotalPendingOrders().equals("0"))
			pendingOrderDataModel = queryProducts.getPendingOrderData(customerId);
		setPendingOrderDataModel(pendingOrderDataModel);

		for (PortfolioDataModel portfolioDataModelElement : portfolioDataModel){
			if ("Total".equals(portfolioDataModelElement.getSchemeName())) {
				setTotalCurrentAmount(portfolioDataModelElement.getCurrentAmount());
				setTotalRateOfGrowth(portfolioDataModelElement.getRateOfGrowth());
				setTotalInvestedAmount(portfolioDataModelElement.getInvestedAmount());
				setTotalProfitAmount(portfolioDataModelElement.getProfit());
				
			}
		}
		
		

		//sessionMap.put("portfolioDataModel", portfolioDataModel);
		logger.debug("PortfolioAction class : execute method : stored portfolioDataModel in session id : "+sessionMap.getClass().getName());
		
		sipDataModel = queryProducts.getSipData(customerId);
		setSipDataModel(sipDataModel);

		/*sessionMap.put("sipDataModel", sipDataModel);
		logger.debug("PortfolioAction class : execute method : stored sipDataModel in session id : "+sessionMap.getClass().getName());
*/
		//String fundId = null;
		/*for (PortfolioDataModel portfolioDataModelElement : portfolioDataModel) {
			fundId = portfolioDataModelElement.getFundId();
			System.out.println("fundId : "+fundId);
			
			investmentDetailsDataModel = queryProducts.getInvestmentDetailsData(sessionMap.get("customerId").toString(),fundId);
			investmentDetailsDataModelList.put(fundId,investmentDetailsDataModel);
			
		}*/
				
		allFundsInvestmentDetailsDataModel = queryProducts.getAllFundsInvestmentDetailsData(customerId);
		setAllFundsInvestmentDetailsDataModel(allFundsInvestmentDetailsDataModel);
		
		System.out.println("Size of allFundsInvestmentDetailsDataModel : "+allFundsInvestmentDetailsDataModel.size());
		
		/*sessionMap.put("allFundsInvestmentDetailsDataModel", allFundsInvestmentDetailsDataModel);
		logger.debug("PortfolioAction class : execute method : stored allFundsInvestmentDetailsDataModel in session id : "+sessionMap.getClass().getName());
		*/
		/*for (String key : investmentDetailsDataModelList.keySet())  {
			System.out.println("key : "+key);
			for (InvestmentDetailsDataModel dataMadel : investmentDetailsDataModelList.get(key))  {
				System.out.println("dataMadel.getTransactionDate() : "+dataMadel.getTransactionDate());
				System.out.println("dataMadel.getUnits() : "+dataMadel.getUnits());
				System.out.println("dataMadel.getNavPurchased() : "+dataMadel.getNavPurchased());
				System.out.println("dataMadel.getTransactionType() : "+dataMadel.getTransactionType());
				
			}
		}*/
		/*sessionMap.put("investmentDetailsDataModelList", investmentDetailsDataModelList);
		logger.debug("PortfolioAction class : execute method : stored investmentDetailsDataModelList in session id : "+sessionMap.getClass().getName());
		*/
		
		if (Double.valueOf(totalProfitAmount) < 0)  {
			setProfitDir("down");
			setProfitValue("NA");
		}
		else {
				setProfitDir("up");
				setProfitValue(totalProfitAmount);
			
		}
		
		System.out.println("profitDir : "+profitDir+" : profitValue : "+profitValue);
		
		logger.debug("PortfolioAction class : execute method : end");
    	
		return SUCCESS;
		}
		catch (MoneyBuddyException e) {	
			logger.error("PortfolioAction class : execute method : Caught MoneyBuddyException for customerId : "+customerId);
			e.printStackTrace();
			
			return ERROR;
		} 
    	catch (Exception e) {	
    		logger.error("PortfolioAction class : execute method : Caught Exception for customerId : "+customerId);
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

/*	public HashMap<String, List<InvestmentDetailsDataModel>> getInvestmentDetailsDataModelList() {
		return investmentDetailsDataModelList;
	}


	public void setInvestmentDetailsDataModelList(
			HashMap<String, List<InvestmentDetailsDataModel>> investmentDetailsDataModelList) {
		this.investmentDetailsDataModelList = investmentDetailsDataModelList;
	}*/


/*	public List<InvestmentDetailsDataModel> getInvestmentDetailsDataModel() {
		return investmentDetailsDataModel;
	}


	public void setInvestmentDetailsDataModel(List<InvestmentDetailsDataModel> investmentDetailsDataModel) {
		this.investmentDetailsDataModel = investmentDetailsDataModel;
	}*/


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


	public String getTotalInvestedAmount() {
		return totalInvestedAmount;
	}


	public void setTotalInvestedAmount(String totalInvestedAmount) {
		this.totalInvestedAmount = totalInvestedAmount;
	}


	public String getTotalProfitAmount() {
		return totalProfitAmount;
	}


	public void setTotalProfitAmount(String totalProfitAmount) {
		this.totalProfitAmount = totalProfitAmount;
	}


	public String getTotalCurrentAmount() {
		return totalCurrentAmount;
	}


	public void setTotalCurrentAmount(String totalCurrentAmount) {
		this.totalCurrentAmount = totalCurrentAmount;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getProfitDir() {
		return profitDir;
	}


	public void setProfitDir(String profitDir) {
		this.profitDir = profitDir;
	}


	public String getProfitValue() {
		return profitValue;
	}


	public void setProfitValue(String profitValue) {
		this.profitValue = profitValue;
	}


	public String getCurDate() {
		return curDate;
	}


	public void setCurDate(String curDate) {
		this.curDate = curDate;
	}


	public String getTotalUpfrontInvestments() {
		return totalUpfrontInvestments;
	}


	public void setTotalUpfrontInvestments(String totalUpfrontInvestments) {
		this.totalUpfrontInvestments = totalUpfrontInvestments;
	}


	public String getTotalSips() {
		return totalSips;
	}


	public void setTotalSips(String totalSips) {
		this.totalSips = totalSips;
	}


	public String getTotalTransactions() {
		return totalTransactions;
	}


	public void setTotalTransactions(String totalTransactions) {
		this.totalTransactions = totalTransactions;
	}


	public String getTotalPendingOrders() {
		return totalPendingOrders;
	}


	public void setTotalPendingOrders(String totalPendingOrders) {
		this.totalPendingOrders = totalPendingOrders;
	}


}

package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class PortfolioDataModel implements Serializable{

	private String fundId;
	private String fundName;
	private String units;
	private String investedAmount;
	private String currentAmount;
	private String profit;
	private String rateOfGrowth;
	private String transactionStartDate;
	private String fundSector;
	
	
	public PortfolioDataModel() {

	}


	public PortfolioDataModel(String fundId, String fundName, String units, String investedAmount, String currentAmount,
			String profit, String rateOfGrowth, String transactionStartDate, String fundSector) {
		super();
		this.fundId = fundId;
		this.fundName = fundName;
		this.units = units;
		this.investedAmount = investedAmount;
		this.currentAmount = currentAmount;
		this.profit = profit;
		this.rateOfGrowth = rateOfGrowth;
		this.transactionStartDate = transactionStartDate;
		this.fundSector = fundSector;
	}


	public String getFundId() {
		return fundId;
	}


	public void setFundId(String fundId) {
		this.fundId = fundId;
	}


	public String getFundName() {
		return fundName;
	}


	public void setFundName(String fundName) {
		this.fundName = fundName;
	}


	public String getUnits() {
		return units;
	}


	public void setUnits(String units) {
		this.units = units;
	}


	public String getInvestedAmount() {
		return investedAmount;
	}


	public void setInvestedAmount(String investedAmount) {
		this.investedAmount = investedAmount;
	}


	public String getCurrentAmount() {
		return currentAmount;
	}


	public void setCurrentAmount(String currentAmount) {
		this.currentAmount = currentAmount;
	}


	public String getProfit() {
		return profit;
	}


	public void setProfit(String profit) {
		this.profit = profit;
	}


	public String getRateOfGrowth() {
		return rateOfGrowth;
	}


	public void setRateOfGrowth(String rateOfGrowth) {
		this.rateOfGrowth = rateOfGrowth;
	}


	public String getTransactionStartDate() {
		return transactionStartDate;
	}


	public void setTransactionStartDate(String transactionStartDate) {
		this.transactionStartDate = transactionStartDate;
	}


	public String getFundSector() {
		return fundSector;
	}


	public void setFundSector(String fundSector) {
		this.fundSector = fundSector;
	}
	
}

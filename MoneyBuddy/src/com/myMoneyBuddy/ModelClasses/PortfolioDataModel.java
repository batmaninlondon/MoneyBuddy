package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class PortfolioDataModel implements Serializable{

	private String fundId;
	private String fundName;
	private String units;
	private String investedAmount;
	private String currentAmount;
	private String rateOfGrowth;
	private String transactionStartDate;
	
	
	public PortfolioDataModel() {

	}


	public PortfolioDataModel(String fundId, String fundName, String units, String investedAmount, String currentAmount,
			String rateOfGrowth, String transactionStartDate) {
		super();
		this.fundId = fundId;
		this.fundName = fundName;
		this.units = units;
		this.investedAmount = investedAmount;
		this.currentAmount = currentAmount;
		this.rateOfGrowth = rateOfGrowth;
		this.transactionStartDate = transactionStartDate;
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
	
}

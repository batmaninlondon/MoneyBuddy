package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class InvestmentDetailsDataModel implements Serializable{

	private String fundId;
	private String fundName;
	private String transactionDate;
	private String units;
	private String navPurchased;
	private String transactionType;
	private String buySell;
	
	
	public InvestmentDetailsDataModel() {

	}


	public InvestmentDetailsDataModel( String fundId, String fundName, String transactionDate, String units, String navPurchased, 
				String transactionType, String buySell ) {
		super();
		this.fundId = fundId;
		this.fundName = fundName;
		this.transactionDate = transactionDate;
		this.units = units;
		this.navPurchased = navPurchased;
		this.transactionType = transactionType;
		this.buySell = buySell;
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


	public String getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}


	public String getUnits() {
		return units;
	}


	public void setUnits(String units) {
		this.units = units;
	}


	public String getNavPurchased() {
		return navPurchased;
	}


	public void setNavPurchased(String navPurchased) {
		this.navPurchased = navPurchased;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public String getBuySell() {
		return buySell;
	}


	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}




	
}

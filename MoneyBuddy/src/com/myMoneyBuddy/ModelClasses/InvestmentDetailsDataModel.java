package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class InvestmentDetailsDataModel implements Serializable{

	private String transactionId;
	private String fundName;
	private String folioNumber;
	private String transactionDate;
	private String transactionAmount;
	private String units;
	private String navPurchased;
	private String transactionType;
	
	
	public InvestmentDetailsDataModel() {

	}


	public InvestmentDetailsDataModel( String transactionId, String fundName, String folioNumber, String transactionDate, String transactionAmount, String units, String navPurchased, 
				String transactionType) {
		super();
		this.transactionId = transactionId;
		this.fundName = fundName;
		this.folioNumber = folioNumber;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.units = units;
		this.navPurchased = navPurchased;
		this.transactionType = transactionType;
	}


	public String getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


	public String getFundName() {
		return fundName;
	}


	public void setFundName(String fundName) {
		this.fundName = fundName;
	}


	public String getFolioNumber() {
		return folioNumber;
	}


	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}


	public String getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}


	public String getTransactionAmount() {
		return transactionAmount;
	}


	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
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

}

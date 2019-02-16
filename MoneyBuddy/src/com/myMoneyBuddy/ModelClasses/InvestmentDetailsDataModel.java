package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class InvestmentDetailsDataModel implements Serializable{

	private String transactionId;
	private String schemeName;
	private String folioNumber;
	private String transactionDate;
	private String transactionAmount;
	private String units;
	private String navPurchased;
	private String transactionType;
	
	
	public InvestmentDetailsDataModel() {

	}


	public InvestmentDetailsDataModel( String transactionId, String schemeName, String folioNumber, String transactionDate, String transactionAmount, String units, String navPurchased, 
				String transactionType) {
		super();
		this.transactionId = transactionId;
		this.schemeName = schemeName;
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


	public String getSchemeName() {
		return schemeName;
	}


	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
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

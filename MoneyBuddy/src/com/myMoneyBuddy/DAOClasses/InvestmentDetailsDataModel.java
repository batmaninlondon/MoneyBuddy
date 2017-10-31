package com.myMoneyBuddy.DAOClasses;

import java.io.Serializable;

public class InvestmentDetailsDataModel implements Serializable{

	private String transactionDate;
	private String units;
	private String navPurchased;
	private String transactionType;
	
	
	public InvestmentDetailsDataModel() {

	}


	public InvestmentDetailsDataModel(String transactionDate, String units, String navPurchased, String transactionType) {
		super();
		this.transactionDate = transactionDate;
		this.units = units;
		this.navPurchased = navPurchased;
		this.transactionType = transactionType;
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




	
}

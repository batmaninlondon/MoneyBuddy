package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class StpDataModel implements Serializable{

	
	private String startDate;
	private String purchaseFundId;
	private String withdrawalSchemeName;
	private String purchaseSchemeName;
	private String folioNumber;
	private String amount;
	private String nextStpDate;
	
	
	public StpDataModel() {

	}



	public StpDataModel(String startDate, String purchaseFundId, String withdrawalSchemeName, String purchaseSchemeName,
			String folioNumber, String amount, String nextStpDate) {
		super();
		this.startDate = startDate;
		this.purchaseFundId = purchaseFundId;
		this.withdrawalSchemeName = withdrawalSchemeName;
		this.purchaseSchemeName = purchaseSchemeName;
		this.folioNumber = folioNumber;
		this.amount = amount;
		this.nextStpDate = nextStpDate;
	}



	public String getpurchaseFundId() {
		return purchaseFundId;
	}


	public void setpurchaseFundId(String purchaseFundId) {
		this.purchaseFundId = purchaseFundId;
	}


	public String getWithdrawalSchemeName() {
		return withdrawalSchemeName;
	}


	public void setWithdrawalSchemeName(String withdrawalSchemeName) {
		withdrawalSchemeName = withdrawalSchemeName;
	}


	public String getPurchaseSchemeName() {
		return purchaseSchemeName;
	}


	public void setPurchaseSchemeName(String purchaseSchemeName) {
		purchaseSchemeName = purchaseSchemeName;
	}


	public String getFolioNumber() {
		return folioNumber;
	}


	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}



	public String getStartDate() {
		return startDate;
	}



	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public String getPurchaseFundId() {
		return purchaseFundId;
	}



	public void setPurchaseFundId(String purchaseFundId) {
		this.purchaseFundId = purchaseFundId;
	}

	public String getAmount() {
		return amount;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getNextStpDate() {
		return nextStpDate;
	}



	public void setNextStpDate(String nextStpDate) {
		this.nextStpDate = nextStpDate;
	}

}

package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class PendingOrderDataModel implements Serializable{

	private String fundId;
	private String transactionId;
	private String schemeName;
	private String amount;
	private String transactionStatus;
	private String transactionStartDate;
	private String transactionType;
	
	
	public PendingOrderDataModel() {

	}

	public PendingOrderDataModel(String fundId, String transactionId, String schemeName, String amount, 
			String transactionStatus, String transactionStartDate, String transactionType) {
		super();
		this.fundId = fundId;
		this.transactionId = transactionId;
		this.schemeName = schemeName;
		this.amount = amount;
		this.transactionStatus = transactionStatus;
		this.transactionStartDate = transactionStartDate;
		this.transactionType = transactionType;
	}


	public String getFundId() {
		return fundId;
	}


	public void setFundId(String fundId) {
		this.fundId = fundId;
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getTransactionStartDate() {
		return transactionStartDate;
	}


	public void setTransactionStartDate(String transactionStartDate) {
		this.transactionStartDate = transactionStartDate;
	}

}

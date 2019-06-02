package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class PendingOrderDataModel implements Serializable{

	private String fundId;
	private String transactionId;
	private String schemeName;
	private String upfrontAmount;
	private String sipAmount;
	private String transactionStatus;
	private String transactionStartDate;
	private String transactionType;
	
	
	public PendingOrderDataModel() {

	}

	public PendingOrderDataModel(String fundId, String transactionId, String schemeName, String upfrontAmount, String sipAmount,
			String transactionStatus, String transactionStartDate, String transactionType) {
		super();
		this.fundId = fundId;
		this.transactionId = transactionId;
		this.schemeName = schemeName;
		this.upfrontAmount = upfrontAmount;
		this.sipAmount = sipAmount;
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

	public String getUpfrontAmount() {
		return upfrontAmount;
	}

	public void setUpfrontAmount(String upfrontAmount) {
		this.upfrontAmount = upfrontAmount;
	}

	public String getSipAmount() {
		return sipAmount;
	}

	public void setSipAmount(String sipAmount) {
		this.sipAmount = sipAmount;
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

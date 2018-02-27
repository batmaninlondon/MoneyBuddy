package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class PendingOrderDataModel implements Serializable{

	private String fundId;
	private String transactionId;
	private String fundName;
	private String investedAmount;
	private String transactionStatus;
	private String transactionStartDate;
	
	
	public PendingOrderDataModel() {

	}

	public PendingOrderDataModel(String fundId, String transactionId, String fundName, String investedAmount,
			String transactionStatus, String transactionStartDate) {
		super();
		this.fundId = fundId;
		this.transactionId = transactionId;
		this.fundName = fundName;
		this.investedAmount = investedAmount;
		this.transactionStatus = transactionStatus;
		this.transactionStartDate = transactionStartDate;
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


	public String getFundName() {
		return fundName;
	}


	public void setFundName(String fundName) {
		this.fundName = fundName;
	}


	public String getInvestedAmount() {
		return investedAmount;
	}


	public void setInvestedAmount(String investedAmount) {
		this.investedAmount = investedAmount;
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

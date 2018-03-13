package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class OrderDataModel implements Serializable{

	private String transactionId;
	private String fundName;
	//private String units;
	private String amount;
	private String transactionDate;
	private String transactionStatus;

	public OrderDataModel() {

	}

	public OrderDataModel(String transactionId, String fundName, String amount, String transactionDate, String transactionStatus) {
		super();
		this.transactionId = transactionId;
		this.fundName = fundName;
		//this.units = units;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.transactionStatus = transactionStatus;
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

/*	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}*/

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

}

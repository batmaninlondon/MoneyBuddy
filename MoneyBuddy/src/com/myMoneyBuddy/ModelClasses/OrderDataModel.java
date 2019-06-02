package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class OrderDataModel implements Serializable{

	private String transactionId;
	private String schemeName;
	private String upfrontAmount;
	private String sipAmount;
	private String transactionDate;
	private String transactionStatus;

	public OrderDataModel() {

	}

	public OrderDataModel(String transactionId, String schemeName, String upfrontAmount, String sipAmount, String transactionDate, String transactionStatus) {
		super();
		this.transactionId = transactionId;
		this.schemeName = schemeName;
		this.upfrontAmount = upfrontAmount;
		this.sipAmount = sipAmount;
		this.transactionDate = transactionDate;
		this.transactionStatus = transactionStatus;
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

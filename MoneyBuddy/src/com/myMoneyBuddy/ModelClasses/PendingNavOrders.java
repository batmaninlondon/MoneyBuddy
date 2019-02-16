package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class PendingNavOrders implements Serializable{

	private String bseOrderId;
	private String rta;
	private String schemeType;
	private String transactionDate;
	private String transactionFolioNum;
	
	
	public PendingNavOrders() {

	}


	public PendingNavOrders(String bseOrderId, String rta, String schemeType, String transactionDate,
			String transactionFolioNum) {
		super();
		this.bseOrderId = bseOrderId;
		this.rta = rta;
		this.schemeType = schemeType;
		this.transactionDate = transactionDate;
		this.transactionFolioNum = transactionFolioNum;
	}


	public String getBseOrderId() {
		return bseOrderId;
	}


	public void setBseOrderId(String bseOrderId) {
		this.bseOrderId = bseOrderId;
	}


	public String getRta() {
		return rta;
	}


	public void setRta(String rta) {
		rta = rta;
	}


	public String getSchemeType() {
		return schemeType;
	}


	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}


	public String getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}


	public String getTransactionFolioNum() {
		return transactionFolioNum;
	}


	public void setTransactionFolioNum(String transactionFolioNum) {
		this.transactionFolioNum = transactionFolioNum;
	}



}

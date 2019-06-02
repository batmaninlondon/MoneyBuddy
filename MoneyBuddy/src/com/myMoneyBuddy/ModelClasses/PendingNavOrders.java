package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class PendingNavOrders implements Serializable{

	private String bseOrderId;
	private String bseRegNum;
	private String transactionType;
	private String rta;
	private String schemeType;
	private String transactionDate;
	private String frmtTransactionDate;
	private String transactionFolioNum;
	
	
	public PendingNavOrders() {

	}


	public PendingNavOrders(String bseOrderId, String bseRegNum, String transactionType, String rta, String schemeType, String transactionDate,
			String frmtTransactionDate, String transactionFolioNum) {
		super();
		this.bseOrderId = bseOrderId;
		this.bseRegNum = bseRegNum;
		this.transactionType = transactionType;
		this.rta = rta;
		this.schemeType = schemeType;
		this.frmtTransactionDate = frmtTransactionDate;
		this.transactionDate = transactionDate;
		this.transactionFolioNum = transactionFolioNum;
	}


	public String getBseOrderId() {
		return bseOrderId;
	}


	public void setBseOrderId(String bseOrderId) {
		this.bseOrderId = bseOrderId;
	}


	public String getBseRegNum() {
		return bseRegNum;
	}


	public void setBseRegNum(String bseRegNum) {
		this.bseRegNum = bseRegNum;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
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


	public String getFrmtTransactionDate() {
		return frmtTransactionDate;
	}


	public void setFrmtTransactionDate(String frmtTransactionDate) {
		this.frmtTransactionDate = frmtTransactionDate;
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

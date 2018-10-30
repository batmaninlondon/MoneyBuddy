package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class SipDataModel implements Serializable{

	private String sipStartDate;
	private String fundId;
	private String fundName;
	private String folioNumber;
	private String fundCategory;
	private String investedAmount;
	private String nextSipDate;
	
	
	public SipDataModel() {

	}


	public SipDataModel(String sipStartDate, String fundId, String fundName, String folioNumber,String fundCategory, String investedAmount, String nextSipDate) {
		super();
		this.sipStartDate = sipStartDate;
		this.fundId = fundId;
		this.fundName = fundName;
		this.folioNumber = folioNumber;
		this.fundCategory = fundCategory;
		this.investedAmount = investedAmount;
		this.nextSipDate = nextSipDate;
	}


	public String getSipStartDate() {
		return sipStartDate;
	}


	public void setSipStartDate(String sipStartDate) {
		this.sipStartDate = sipStartDate;
	}


	public String getFundId() {
		return fundId;
	}


	public void setFundId(String fundId) {
		this.fundId = fundId;
	}


	public String getFundName() {
		return fundName;
	}


	public void setFundName(String fundName) {
		this.fundName = fundName;
	}


	public String getFolioNumber() {
		return folioNumber;
	}


	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}


	public String getFundCategory() {
		return fundCategory;
	}


	public void setFundCategory(String fundCategory) {
		this.fundCategory = fundCategory;
	}


	public String getInvestedAmount() {
		return investedAmount;
	}


	public void setInvestedAmount(String investedAmount) {
		this.investedAmount = investedAmount;
	}


	public String getNextSipDate() {
		return nextSipDate;
	}


	public void setNextSipDate(String nextSipDate) {
		this.nextSipDate = nextSipDate;
	}

}

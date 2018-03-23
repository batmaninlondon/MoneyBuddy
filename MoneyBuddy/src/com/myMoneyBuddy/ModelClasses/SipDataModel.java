package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class SipDataModel implements Serializable{

	private String sipStartDate;
	private String fundName;
	private String investedAmount;
	private String nextSipDate;
	
	
	public SipDataModel() {

	}


	public SipDataModel(String sipStartDate, String fundName, String investedAmount, String nextSipDate) {
		super();
		this.sipStartDate = sipStartDate;
		this.fundName = fundName;
		this.investedAmount = investedAmount;
		this.nextSipDate = nextSipDate;
	}


	public String getSipStartDate() {
		return sipStartDate;
	}


	public void setSipStartDate(String sipStartDate) {
		this.sipStartDate = sipStartDate;
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


	public String getNextSipDate() {
		return nextSipDate;
	}


	public void setNextSipDate(String nextSipDate) {
		this.nextSipDate = nextSipDate;
	}

}

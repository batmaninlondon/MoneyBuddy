package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class SipDataModel implements Serializable{

	private String sipStartDate;
	private String fundId;
	private String schemeName;
	private String folioNumber;
	private String schemeType;
	private String investedAmount;
	private String nextSipDate;
	
	
	public SipDataModel() {

	}


	public SipDataModel(String sipStartDate, String fundId, String schemeName, String folioNumber,String schemeType, String investedAmount, String nextSipDate) {
		super();
		this.sipStartDate = sipStartDate;
		this.fundId = fundId;
		this.schemeName = schemeName;
		this.folioNumber = folioNumber;
		this.schemeType = schemeType;
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


	public String getSchemeName() {
		return schemeName;
	}


	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}


	public String getFolioNumber() {
		return folioNumber;
	}


	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}


	public String getSchemeType() {
		return schemeType;
	}


	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
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

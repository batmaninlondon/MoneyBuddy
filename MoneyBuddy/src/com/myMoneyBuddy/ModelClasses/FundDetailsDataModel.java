package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class FundDetailsDataModel implements Serializable{

	private String fundId;
	private String fundName;
	private String sector;
	private String subSector;
	private String fundStartDate;
	private String rating;
	private String risk;
	private String returnsOneYear;
	private String returnsThreeYears;
	private String returnsFiveYears;
	private String returnsSinceInception;
	private String minSipAmount;
	private String minLumsumAmount;
	private String minSipDuration;
	private String fundCategory;
	private String pdfFilePath;
	
	
	public FundDetailsDataModel() {

	}


	public FundDetailsDataModel(String fundId, String fundName, String sector, String subSector, String fundStartDate,
			String rating, String risk, String returnsOneYear, String returnsThreeYears, String returnsFiveYears, 
			String returnsSinceInception, String minSipAmount, String minLumsumAmount,
			String minSipDuration, String fundCategory, String pdfFilePath) {
		super();
		this.fundId = fundId;
		this.fundName = fundName;
		this.sector = sector;
		this.subSector = subSector;
		this.fundStartDate = fundStartDate;
		this.rating = rating;
		this.risk = risk;
		this.returnsOneYear = returnsOneYear;
		this.returnsThreeYears = returnsThreeYears;
		this.returnsFiveYears = returnsFiveYears;
		this.returnsSinceInception = returnsSinceInception;
		this.minSipAmount = minSipAmount;
		this.minLumsumAmount = minLumsumAmount;
		this.minSipDuration = minSipDuration;
		this.fundCategory = fundCategory;
		this.pdfFilePath = pdfFilePath;
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


	public String getSector() {
		return sector;
	}


	public void setSector(String sector) {
		this.sector = sector;
	}


	public String getSubSector() {
		return subSector;
	}


	public void setSubSector(String subSector) {
		this.subSector = subSector;
	}


	public String getFundStartDate() {
		return fundStartDate;
	}


	public void setFundStartDate(String fundStartDate) {
		this.fundStartDate = fundStartDate;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getRisk() {
		return risk;
	}


	public void setRisk(String risk) {
		this.risk = risk;
	}


	public String getReturnsOneYear() {
		return returnsOneYear;
	}


	public void setReturnsOneYear(String returnsOneYear) {
		this.returnsOneYear = returnsOneYear;
	}


	public String getReturnsThreeYears() {
		return returnsThreeYears;
	}


	public void setReturnsThreeYears(String returnsThreeYears) {
		this.returnsThreeYears = returnsThreeYears;
	}


	public String getReturnsFiveYears() {
		return returnsFiveYears;
	}


	public void setReturnsFiveYears(String returnsFiveYears) {
		this.returnsFiveYears = returnsFiveYears;
	}


	public String getReturnsSinceInception() {
		return returnsSinceInception;
	}


	public void setReturnsSinceInception(String returnsSinceInception) {
		this.returnsSinceInception = returnsSinceInception;
	}


	public String getMinSipAmount() {
		return minSipAmount;
	}


	public void setMinSipAmount(String minSipAmount) {
		this.minSipAmount = minSipAmount;
	}


	public String getMinLumsumAmount() {
		return minLumsumAmount;
	}


	public void setMinLumsumAmount(String minLumsumAmount) {
		this.minLumsumAmount = minLumsumAmount;
	}


	public String getMinSipDuration() {
		return minSipDuration;
	}


	public void setMinSipDuration(String minSipDuration) {
		this.minSipDuration = minSipDuration;
	}


	public String getFundCategory() {
		return fundCategory;
	}


	public void setFundCategory(String fundCategory) {
		this.fundCategory = fundCategory;
	}


	public String getPdfFilePath() {
		return pdfFilePath;
	}


	public void setPdfFilePath(String pdfFilePath) {
		this.pdfFilePath = pdfFilePath;
	}





}

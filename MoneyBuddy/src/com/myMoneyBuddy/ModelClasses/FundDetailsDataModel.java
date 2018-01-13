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
	private String returnsThreeYears;
	private String minSipAmount;
	private String minLumsumAmount;
	private String minSipDuration;
	
	
	public FundDetailsDataModel() {

	}


	public FundDetailsDataModel(String fundId, String fundName, String sector, String subSector, String fundStartDate,
			String rating, String risk, String returnsThreeYears, String minSipAmount, String minLumsumAmount,
			String minSipDuration) {
		super();
		this.fundId = fundId;
		this.fundName = fundName;
		this.sector = sector;
		this.subSector = subSector;
		this.fundStartDate = fundStartDate;
		this.rating = rating;
		this.risk = risk;
		this.returnsThreeYears = returnsThreeYears;
		this.minSipAmount = minSipAmount;
		this.minLumsumAmount = minLumsumAmount;
		this.minSipDuration = minSipDuration;
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


	public String getReturnsThreeYears() {
		return returnsThreeYears;
	}


	public void setReturnsThreeYears(String returnsThreeYears) {
		this.returnsThreeYears = returnsThreeYears;
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





}

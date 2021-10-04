package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class FundDetailsDataModel implements Serializable{

	private String fundId;
	private String schemeName;
	private String schemeType;
	private String category;
	private String startDate;
	private String rating;
	private String risk;
	private String returnsOneYear;
	private String returnsThreeYears;
	private String returnsFiveYears;
	private String returnsSinceInception;
	private String minSipAmount;
	private String minPurchaseAmount;
	private String upfrontMultiplier;
	private String minStpAmount;
	private String minSipDuration;
	private String pdfFilePath;
	private String sipFlag;
	private String stpWithdrawalFlag;
	private String stpPurchaseFlag;
	private String swpFlag;
	private String switchFlag;
	
	
	public FundDetailsDataModel() {

	}

	public FundDetailsDataModel(String fundId, String schemeName, String schemeType, String category, String startDate,
			String rating, String risk, String returnsOneYear, String returnsThreeYears, String returnsFiveYears,
			String returnsSinceInception, String minSipAmount, String minPurchaseAmount, String upfrontMultiplier, String minStpAmount,
			String minSipDuration, String pdfFilePath, String sipFlag, String stpWithdrawalFlag, String stpPurchaseFlag,
			String swpFlag, String switchFlag) {
		super();
		this.fundId = fundId;
		this.schemeName = schemeName;
		this.schemeType = schemeType;
		this.category = category;
		this.startDate = startDate;
		this.rating = rating;
		this.risk = risk;
		this.returnsOneYear = returnsOneYear;
		this.returnsThreeYears = returnsThreeYears;
		this.returnsFiveYears = returnsFiveYears;
		this.returnsSinceInception = returnsSinceInception;
		this.minSipAmount = minSipAmount;
		this.minPurchaseAmount = minPurchaseAmount;
		this.upfrontMultiplier = upfrontMultiplier;
		this.minStpAmount = minStpAmount;
		this.minSipDuration = minSipDuration;
		this.pdfFilePath = pdfFilePath;
		this.sipFlag = sipFlag;
		this.stpWithdrawalFlag = stpWithdrawalFlag;
		this.stpPurchaseFlag = stpPurchaseFlag;
		this.swpFlag = swpFlag;
		this.switchFlag = switchFlag;
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


	public String getSchemeType() {
		return schemeType;
	}


	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}



	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}



	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
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


	public String getMinPurchaseAmount() {
		return minPurchaseAmount;
	}


	public void setMinPurchaseAmount(String minPurchaseAmount) {
		this.minPurchaseAmount = minPurchaseAmount;
	}


	public String getUpfrontMultiplier() {
		return upfrontMultiplier;
	}

	public void setUpfrontMultiplier(String upfrontMultiplier) {
		this.upfrontMultiplier = upfrontMultiplier;
	}

	public String getMinSipDuration() {
		return minSipDuration;
	}


	public void setMinSipDuration(String minSipDuration) {
		this.minSipDuration = minSipDuration;
	}


	public String getPdfFilePath() {
		return pdfFilePath;
	}


	public void setPdfFilePath(String pdfFilePath) {
		this.pdfFilePath = pdfFilePath;
	}


	public String getSipFlag() {
		return sipFlag;
	}


	public void setSipFlag(String sipFlag) {
		this.sipFlag = sipFlag;
	}

	public String getMinStpAmount() {
		return minStpAmount;
	}


	public void setMinStpAmount(String minStpAmount) {
		this.minStpAmount = minStpAmount;
	}


	public String getStpWithdrawalFlag() {
		return stpWithdrawalFlag;
	}


	public void setStpWithdrawalFlag(String stpWithdrawalFlag) {
		this.stpWithdrawalFlag = stpWithdrawalFlag;
	}


	public String getStpPurchaseFlag() {
		return stpPurchaseFlag;
	}


	public void setStpPurchaseFlag(String stpPurchaseFlag) {
		this.stpPurchaseFlag = stpPurchaseFlag;
	}


	public String getSwpFlag() {
		return swpFlag;
	}


	public void setSwpFlag(String swpFlag) {
		this.swpFlag = swpFlag;
	}


	public String getSwitchFlag() {
		return switchFlag;
	}


	public void setSwitchFlag(String switchFlag) {
		this.switchFlag = switchFlag;
	}


}

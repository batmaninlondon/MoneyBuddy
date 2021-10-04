package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class PortfolioDataModel implements Serializable{

	private String fundId;
	private String schemeName;
	private String folioNumber;
	private String units;
	private String investedAmount;
	private String currentAmount;
	private String profit;
	private String rateOfGrowth;
	/*private String transactionStartDate;*/
	private String schemeType;
	private String stpWithdrawalFlag;
	
	
	public PortfolioDataModel() {

	}


	public PortfolioDataModel(String fundId, String schemeName, String folioNumber, String units, String investedAmount, String currentAmount,
			String profit, String rateOfGrowth, String schemeType, String stpWithdrawalFlag) {
		super();
		this.fundId = fundId;
		this.schemeName = schemeName;
		this.folioNumber = folioNumber;
		this.units = units;
		this.investedAmount = investedAmount;
		this.currentAmount = currentAmount;
		this.profit = profit;
		this.rateOfGrowth = rateOfGrowth;
		this.schemeType = schemeType;
		this.stpWithdrawalFlag = stpWithdrawalFlag;
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


	public String getUnits() {
		return units;
	}


	public void setUnits(String units) {
		this.units = units;
	}


	public String getInvestedAmount() {
		return investedAmount;
	}


	public void setInvestedAmount(String investedAmount) {
		this.investedAmount = investedAmount;
	}


	public String getCurrentAmount() {
		return currentAmount;
	}


	public void setCurrentAmount(String currentAmount) {
		this.currentAmount = currentAmount;
	}


	public String getProfit() {
		return profit;
	}


	public void setProfit(String profit) {
		this.profit = profit;
	}


	public String getRateOfGrowth() {
		return rateOfGrowth;
	}


	public void setRateOfGrowth(String rateOfGrowth) {
		this.rateOfGrowth = rateOfGrowth;
	}


	public String getSchemeType() {
		return schemeType;
	}


	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}


	public String getStpWithdrawalFlag() {
		return stpWithdrawalFlag;
	}


	public void setStpWithdrawalFlag(String stpWithdrawalFlag) {
		this.stpWithdrawalFlag = stpWithdrawalFlag;
	}


	@Override
	public String toString() {
		return "\nPortfolioDataModel [fundId=" + fundId + ", schemeName=" + schemeName + ", folioNumber=" + folioNumber
				+ ", units=" + units + ", investedAmount=" + investedAmount + ", currentAmount=" + currentAmount
				+ ", profit=" + profit + ", rateOfGrowth=" + rateOfGrowth + ", schemeType=" + schemeType
				+ ", stpWithdrawalFlag=" + stpWithdrawalFlag + "]";
	}

}

package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class OldPortfolioDataModel implements Serializable{

	private String customerId;
	private String schemeName;
	private String folioNumber;
	private String investedAmount;
	private String unitsHeld;
	private String currentValue;
	private String profit;
	
	
	public OldPortfolioDataModel() {

	}


	public OldPortfolioDataModel(String customerId, String schemeName, String folioNumber, String investedAmount,
			String unitsHeld, String currentValue, String profit) {
		super();
		this.customerId = customerId;
		this.schemeName = schemeName;
		this.folioNumber = folioNumber;
		this.investedAmount = investedAmount;
		this.unitsHeld = unitsHeld;
		this.currentValue = currentValue;
		this.profit = profit;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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


	public String getInvestedAmount() {
		return investedAmount;
	}


	public void setInvestedAmount(String investedAmount) {
		this.investedAmount = investedAmount;
	}


	public String getUnitsHeld() {
		return unitsHeld;
	}


	public void setUnitsHeld(String unitsHeld) {
		this.unitsHeld = unitsHeld;
	}


	public String getCurrentValue() {
		return currentValue;
	}


	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}


	public String getProfit() {
		return profit;
	}


	public void setProfit(String profit) {
		this.profit = profit;
	}


}

package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class BusinessDashboardDataModel implements Serializable{

	private String signUps;
	private String aofCreation;
	private String verfiedAccounts;
	private String activatedAccounts;
	private String investedAmount;
	private String currentAmount;
	private String sipRegistered;
	private String numOfSipClients;
	private String monthlyRunningSipValue;
	private String stpRegistered;
	private String numOfStpClients;
	private String monthlyRunningStpValue;
	
	
	public BusinessDashboardDataModel() {

	}


	public BusinessDashboardDataModel(String signUps, String aofCreation, String verfiedAccounts,
			String activatedAccounts, String investedAmount, String currentAmount, String sipRegistered,
			String numOfSipClients, String monthlyRunningSipValue, String stpRegistered, String numOfStpClients,
			String monthlyRunningStpValue) {
		super();
		this.signUps = signUps;
		this.aofCreation = aofCreation;
		this.verfiedAccounts = verfiedAccounts;
		this.activatedAccounts = activatedAccounts;
		this.investedAmount = investedAmount;
		this.currentAmount = currentAmount;
		this.sipRegistered = sipRegistered;
		this.numOfSipClients = numOfSipClients;
		this.monthlyRunningSipValue = monthlyRunningSipValue;
		this.stpRegistered = stpRegistered;
		this.numOfStpClients = numOfStpClients;
		this.monthlyRunningStpValue = monthlyRunningStpValue;
	}


	public String getSignUps() {
		return signUps;
	}


	public void setSignUps(String signUps) {
		this.signUps = signUps;
	}


	public String getAofCreation() {
		return aofCreation;
	}


	public void setAofCreation(String aofCreation) {
		this.aofCreation = aofCreation;
	}


	public String getVerfiedAccounts() {
		return verfiedAccounts;
	}


	public void setVerfiedAccounts(String verfiedAccounts) {
		this.verfiedAccounts = verfiedAccounts;
	}


	public String getActivatedAccounts() {
		return activatedAccounts;
	}


	public void setActivatedAccounts(String activatedAccounts) {
		this.activatedAccounts = activatedAccounts;
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


	public String getSipRegistered() {
		return sipRegistered;
	}


	public void setSipRegistered(String sipRegistered) {
		this.sipRegistered = sipRegistered;
	}


	public String getNumOfSipClients() {
		return numOfSipClients;
	}


	public void setNumOfSipClients(String numOfSipClients) {
		this.numOfSipClients = numOfSipClients;
	}


	public String getMonthlyRunningSipValue() {
		return monthlyRunningSipValue;
	}


	public void setMonthlyRunningSipValue(String monthlyRunningSipValue) {
		this.monthlyRunningSipValue = monthlyRunningSipValue;
	}


	public String getStpRegistered() {
		return stpRegistered;
	}


	public void setStpRegistered(String stpRegistered) {
		this.stpRegistered = stpRegistered;
	}


	public String getNumOfStpClients() {
		return numOfStpClients;
	}


	public void setNumOfStpClients(String numOfStpClients) {
		this.numOfStpClients = numOfStpClients;
	}


	public String getMonthlyRunningStpValue() {
		return monthlyRunningStpValue;
	}


	public void setMonthlyRunningStpValue(String monthlyRunningStpValue) {
		this.monthlyRunningStpValue = monthlyRunningStpValue;
	}

	
}

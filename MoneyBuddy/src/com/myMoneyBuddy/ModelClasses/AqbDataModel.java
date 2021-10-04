package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class AqbDataModel implements Serializable{

	private String customerId;
	private String quarter;
	private String year;
	private String aqbAmount;
	private String qurterlyFee;
	
	
	public AqbDataModel() {

	}


	public AqbDataModel(String customerId, String quarter, String year, String aqbAmount, String qurterlyFee) {
		super();
		this.customerId = customerId;
		this.quarter = quarter;
		this.year = year;
		this.aqbAmount = aqbAmount;
		this.qurterlyFee = qurterlyFee;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getQuarter() {
		return quarter;
	}


	public void setQuarter(String quarter) {
		quarter = quarter;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		year = year;
	}


	public String getAqbAmount() {
		return aqbAmount;
	}


	public void setAqbAmount(String aqbAmount) {
		this.aqbAmount = aqbAmount;
	}


	public String getQurterlyFee() {
		return qurterlyFee;
	}


	public void setQurterlyFee(String qurterlyFee) {
		this.qurterlyFee = qurterlyFee;
	}

	
}

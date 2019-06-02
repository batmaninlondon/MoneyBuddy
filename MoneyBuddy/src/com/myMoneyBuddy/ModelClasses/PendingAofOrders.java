package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class PendingAofOrders implements Serializable{

	private String customerId;
	private String customerName;
	private String aofCreationDate;	
	
	public PendingAofOrders() {

	}

	public PendingAofOrders(String customerId, String customerName, String aofCreationDate) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.aofCreationDate = aofCreationDate;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getAofCreationDate() {
		return aofCreationDate;
	}


	public void setAofCreationDate(String aofCreationDate) {
		this.aofCreationDate = aofCreationDate;
	}


}

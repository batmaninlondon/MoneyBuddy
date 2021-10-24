package com.myMoneyBuddy.Utils;

public class RtaDataModel {

	private String customerId;
	private String customerName;
	private String fundId;
	private String schemeName;
	private String folioNumber;
	private String units;
	private String currentAmount;

	public RtaDataModel() {

	}

	public RtaDataModel(String customerId, String customerName, String fundId, String schemeName, String folioNumber, String units,
			String currentAmount) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.fundId = fundId;
		this.schemeName = schemeName;
		this.folioNumber = folioNumber;
		this.units = units;
		this.currentAmount = currentAmount;
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

	public String getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(String currentAmount) {
		this.currentAmount = currentAmount;
	}

	@Override
	public String toString() {
		return "\nRtaDataModel [customerId=" + customerId + ", customerName=" + customerName + ", fundId=" + fundId
				+ ", schemeName=" + schemeName + ", folioNumber=" + folioNumber + ", units=" + units
				+ ", currentAmount=" + currentAmount + "]";
	}



}

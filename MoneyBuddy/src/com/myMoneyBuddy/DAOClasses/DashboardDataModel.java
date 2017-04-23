/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

public class DashboardDataModel {

	private String productName;
	private String productId;
	private String totalQuantity;
	private String pendingOrders;
	private String availableToSell;
	/*private String marketPrice;
	private String buyingPrice;
	private String marketValue;
	private String gain;*/
	/*private String groupName;*/
	private String orderId;
	private String reverseFeed;
	private String transactionDate;
	private String transactionAmount;
        
	public DashboardDataModel() {

	}

	public DashboardDataModel(String productName, String productId,
			String totalQuantity, String pendingOrders,
			String availableToSell, String orderId, 
			String reverseFeed, String transactionDate, String transactionAmount) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.totalQuantity = totalQuantity;
		this.pendingOrders = pendingOrders;
		this.availableToSell = availableToSell;
		this.orderId = orderId;
		this.reverseFeed = reverseFeed;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
	}
	
	/*public DashboardDataModel(String productName, String productId,
				String totalQuantity, String pendingOrders,
				String availableToSell, String marketPrice, String buyingPrice,
				String marketValue, String gain, String groupName, String orderId, 
				String reverseFeed, String transactionDate, String transactionAmount) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.totalQuantity = totalQuantity;
		this.pendingOrders = pendingOrders;
		this.availableToSell = availableToSell;
		this.marketPrice = marketPrice;
		this.buyingPrice = buyingPrice;
		this.marketValue = marketValue;
		this.gain = gain;
		this.groupName = groupName;
		this.orderId = orderId;
		this.reverseFeed = reverseFeed;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
	}*/
        
	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getTotalQuantity() {
		return totalQuantity;
	}


	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}


	public String getPendingOrders() {
		return pendingOrders;
	}


	public void setPendingOrders(String pendingOrders) {
		this.pendingOrders = pendingOrders;
	}


	public String getAvailableToSell() {
		return availableToSell;
	}


	public void setAvailableToSell(String availableToSell) {
		this.availableToSell = availableToSell;
	}


/*	public String getMarketPrice() {
		return marketPrice;
	}


	public void setMarketPrice(String marketPrice) {
		this.marketPrice = marketPrice;
	}*/

/*
	public String getBuyingPrice() {
		return buyingPrice;
	}


	public void setBuyingPrice(String buyingPrice) {
		this.buyingPrice = buyingPrice;
	}


	public String getMarketValue() {
		return marketValue;
	}


	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}


	public String getGain() {
		return gain;
	}


	public void setGain(String gain) {
		this.gain = gain;
	}*/

/*	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}*/

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getReverseFeed() {
		return reverseFeed;
	}

	public void setReverseFeed(String reverseFeed) {
		this.reverseFeed = reverseFeed;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

}

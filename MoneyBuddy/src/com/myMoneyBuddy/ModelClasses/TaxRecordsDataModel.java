package com.myMoneyBuddy.ModelClasses;

import java.io.Serializable;

public class TaxRecordsDataModel implements Serializable{

	private int serialNum;
	private String redemptionDate;
	private Double redemptionPrice;
	private Double redemptionUnits;
	private String purchaseDate;
	private Double purchasePrice;
	private Double purchaseUnits;
	private String pnlLongTerm;
	private String pnlShortTerm;
	
	
	public TaxRecordsDataModel() {

	}
	
	public TaxRecordsDataModel(TaxRecordsDataModel taxRecordsDataModel) {

		this.serialNum = taxRecordsDataModel.serialNum;
		this.redemptionDate = taxRecordsDataModel.redemptionDate;
		this.redemptionPrice = taxRecordsDataModel.redemptionPrice;
		this.redemptionUnits = taxRecordsDataModel.redemptionUnits;
		this.purchaseDate = taxRecordsDataModel.purchaseDate;
		this.purchasePrice = taxRecordsDataModel.purchasePrice;
		this.purchaseUnits = taxRecordsDataModel.purchaseUnits;
		this.pnlLongTerm = taxRecordsDataModel.pnlLongTerm;
		this.pnlShortTerm = taxRecordsDataModel.pnlShortTerm;
		
	}



	public TaxRecordsDataModel(int serialNum, String redemptionDate, Double redemptionPrice, Double redemptionUnits,
			String purchaseDate, Double purchasePrice, Double purchaseUnits, String pnlLongTerm, String pnlShortTerm) {
		super();
		this.serialNum = serialNum;
		this.redemptionDate = redemptionDate;
		this.redemptionPrice = redemptionPrice;
		this.redemptionUnits = redemptionUnits;
		this.purchaseDate = purchaseDate;
		this.purchasePrice = purchasePrice;
		this.purchaseUnits = purchaseUnits;
		this.pnlLongTerm = pnlLongTerm;
		this.pnlShortTerm = pnlShortTerm;
	}


	public int getSerialNum() {
		return serialNum;
	}


	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}


	public String getRedemptionDate() {
		return redemptionDate;
	}


	public void setRedemptionDate(String redemptionDate) {
		this.redemptionDate = redemptionDate;
	}


	public Double getRedemptionPrice() {
		return redemptionPrice;
	}


	public void setRedemptionPrice(Double redemptionPrice) {
		this.redemptionPrice = redemptionPrice;
	}


	public Double getRedemptionUnits() {
		return redemptionUnits;
	}


	public void setRedemptionUnits(Double redemptionUnits) {
		this.redemptionUnits = redemptionUnits;
	}


	public String getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public Double getPurchasePrice() {
		return purchasePrice;
	}


	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}


	public Double getPurchaseUnits() {
		return purchaseUnits;
	}


	public void setPurchaseUnits(Double purchaseUnits) {
		this.purchaseUnits = purchaseUnits;
	}


	public String getPnlLongTerm() {
		return pnlLongTerm;
	}


	public void setPnlLongTerm(String pnlLongTerm) {
		this.pnlLongTerm = pnlLongTerm;
	}


	public String getPnlShortTerm() {
		return pnlShortTerm;
	}


	public void setPnlShortTerm(String pnlShortTerm) {
		this.pnlShortTerm = pnlShortTerm;
	}



}

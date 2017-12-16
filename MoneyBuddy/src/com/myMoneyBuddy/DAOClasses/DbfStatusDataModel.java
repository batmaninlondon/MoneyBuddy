package com.myMoneyBuddy.DAOClasses;

import java.io.Serializable;

public class DbfStatusDataModel implements Serializable{

	private String dbfDataDate;
	private String rta;
	private String dbfFileType;
	
	
	public DbfStatusDataModel() {

	}

	public DbfStatusDataModel(String dbfDataDate, String rta, String dbfFileType) {
		super();
		this.dbfDataDate = dbfDataDate;
		this.rta = rta;
		this.dbfFileType = dbfFileType;
	}

	public String getDbfDataDate() {
		return dbfDataDate;
	}

	public void setDbfDataDate(String dbfDataDate) {
		this.dbfDataDate = dbfDataDate;
	}

	public String getRta() {
		return rta;
	}

	public void setRta(String rta) {
		this.rta = rta;
	}

	public String getDbfFileType() {
		return dbfFileType;
	}

	public void setDbfFileType(String dbfFileType) {
		this.dbfFileType = dbfFileType;
	}



}

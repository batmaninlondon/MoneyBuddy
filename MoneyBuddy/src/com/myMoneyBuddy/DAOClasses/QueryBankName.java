package com.myMoneyBuddy.DAOClasses;

import java.util.HashMap;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

public class QueryBankName {
	
	public String displayBankName(String bankName) throws MoneyBuddyException { 
		
		HashMap<String,String> bankNames = new HashMap<String,String>();
		
		bankNames.put("ICI","ICICI");
		bankNames.put("SBI","SBI");
		bankNames.put("HDF","HDFC");
		bankNames.put("162","KOTAK");
		bankNames.put("UTI","AXIS");
		bankNames.put("PNB","PNB");
		bankNames.put("SIB","SIB");
		bankNames.put("SCB","SCB");
		bankNames.put("UBI","UBI");
		bankNames.put("UNI","UBI");
		bankNames.put("YBK","YBT");
		bankNames.put("RBL","RB");
		bankNames.put("DCB","DCB");
		
		String displayBankName = bankNames.get(bankName);
		
		return displayBankName;
		
	}

}

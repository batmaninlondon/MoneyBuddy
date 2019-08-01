package com.myMoneyBuddy.DAOClasses;

import java.util.HashMap;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

public class QueryDisplayName {
	
	public String displayBankName(String bankName) throws MoneyBuddyException { 
		
		System.out.println("bankName is displayBankName is : "+bankName);
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
		System.out.println("displayBankName is displayBankName is : "+displayBankName);
		
		return displayBankName;
		
	}
	
	public String displayOccupation(String occupation) throws MoneyBuddyException { 
		
		HashMap<String,String> occupations = new HashMap<String,String>();
		
		occupations.put("PriSecJob","Private Sector job");
		occupations.put("PubSecJob","Public Sector job");
		occupations.put("GovSer","Government Service");
		occupations.put("Business","Business");
		occupations.put("Professional","Professional");
		occupations.put("Retired","Retired");
		occupations.put("Student","Student");
		occupations.put("HouseWife","Housewife");
		occupations.put("Others","Others");
		
		String displayOccupation = occupations.get(occupation);
		
		return displayOccupation;
		
	}

}

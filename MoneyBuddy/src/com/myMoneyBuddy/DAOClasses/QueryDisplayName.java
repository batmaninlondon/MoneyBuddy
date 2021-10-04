package com.myMoneyBuddy.DAOClasses;

import java.util.HashMap;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

public class QueryDisplayName {
	
	public String displayBankName(String bankName) throws MoneyBuddyException { 
		
		System.out.println("bankName is displayBankName is : "+bankName);
		HashMap<String,String> bankNames = new HashMap<String,String>();
		
		bankNames.put("ICI","ICICI Bank");
		bankNames.put("SBI","SBI Bank");
		bankNames.put("HDF","HDFC Bank");
		bankNames.put("162","KOTAK Bank");
		bankNames.put("UTI","AXIS Bank");
		bankNames.put("PNB","PNB Bank");
		bankNames.put("SIB","South India Bank");
		bankNames.put("SCB","Standard Chartered Bank");
		bankNames.put("UBI","Union Bank of India");
		bankNames.put("UNI","United Bank of India");
		bankNames.put("YBK","Yes Bank Ltd");
		bankNames.put("RBL","RBL Bank");
		bankNames.put("DCB","DCB Bank");
		bankNames.put("DEN","DENA Bank");
		bankNames.put("BBR","Bank of Baroda");
		bankNames.put("IDS","IndusInd Bank");
		bankNames.put("IDB","IDBI Bank");
		bankNames.put("CNB","Canara Bank");
		
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

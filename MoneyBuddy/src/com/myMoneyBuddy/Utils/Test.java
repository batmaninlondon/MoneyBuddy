package com.myMoneyBuddy.Utils;

public class Test {
	
	public static void main (String args[])  {
		
		try  {
		CsvToDatabaseUtil csvToDatabaseUtil= new CsvToDatabaseUtil();
		csvToDatabaseUtil.navEnteries();
		
		}
		catch(Exception e)  {
			e.printStackTrace();
		}
		
	}

}

package com.myMoneyBuddy.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CommonUtil {

	
	public boolean copyFileUsingFileUtils(String srcFilePath, String destFilePath){
		boolean isFileCopied = false;
		
		try {
			FileUtils.copyFile(new File(srcFilePath), new File(destFilePath),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isFileCopied;
	}
	
	public String theMonth(int month){
	    String[] monthNames = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	    return monthNames[month];
	}
	
	public String getBankMode(String bankName)  {
		
		String bankMode;
		
		switch (bankName)  {
			case "ICI" : 
			case "SBI" :
			case "UTI" :
			case "YBK" :
			case "162" :
				bankMode="DIRECT";break;
			case "HDF" :
			case "DCB" :
			case "PNB" :
			case "SIB" :
			case "SCB" :
			case "UBI" :
			case "UNI" :
			case "RBL" :
				bankMode="NODAL";break;
			default : 
				bankMode="INVALID";
		}
		return bankMode;
	}
}

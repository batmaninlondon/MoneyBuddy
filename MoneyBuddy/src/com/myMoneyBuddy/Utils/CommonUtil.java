package com.myMoneyBuddy.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import com.myMoneyBuddy.DAOClasses.Trading;

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
			case "HDF" :
				bankMode="DIRECT";break;
			case "DCB" :
			case "PNB" :
			case "SIB" :
			case "SCB" :
			case "UBI" :
			case "UNI" :
			case "RBL" :
			case "DEN" :
				bankMode="NODAL";break;
			default : 
				bankMode="INVALID";
		}
		return bankMode;
	}
	
	public Map<Date, Date> getStpDates(String stpDate,String stpDuration)  {

		Map<Date,Date> stpDetails = new HashMap<Date,Date>();
		
		try {
			
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance();
	        c.setTime(currentDate);
			
	        Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";
	
			configProperties.load(Trading.class.getResourceAsStream(configPropFilePath));
			
			String stpBufferDays = configProperties.getProperty("STP_BUFFER_DAYS");
			c.add(Calendar.DATE, Integer.parseInt(stpBufferDays));
	
			Date minStpStartDate = c.getTime();
				
		    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		    
		    minStpStartDate = sdf.parse(sdf.format(minStpStartDate));
		    
		    Calendar cal = Calendar.getInstance();
			
			String stpStartMonth="";
			String stpEndMonth="";
			
			if ( Integer.parseInt(stpDate) <=   (cal.get(Calendar.DATE)) ) {
					stpStartMonth = (("11".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? theMonth(0) : theMonth(cal.get(Calendar.MONTH)+1));
					stpEndMonth = theMonth(cal.get(Calendar.MONTH));
				}
				else {
					stpStartMonth = theMonth(cal.get(Calendar.MONTH));
					stpEndMonth = (("0".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? theMonth(11) : theMonth(cal.get(Calendar.MONTH)-1));
				}
				
				String stpEndYear = Integer.toString(cal.get(Calendar.YEAR)+Integer.parseInt(stpDuration));
				String stpStartYear = (("11".equals(Integer.toString(cal.get(Calendar.MONTH)))) ? Integer.toString(cal.get(Calendar.YEAR)+1) : Integer.toString(cal.get(Calendar.YEAR)));
				
				String stpStartDate = stpStartMonth+"/"+stpDate+"/"+stpStartYear;
				String stpEndDate = stpEndMonth+"/"+stpDate+"/"+stpEndYear;
				
			    Date curStpStartDate = sdf.parse(stpStartDate);
			    Date curStpEndDate = sdf.parse(stpEndDate);
				
				
				if (minStpStartDate.after(curStpStartDate)) {
			    	c.setTime(curStpStartDate);
			    	c.add(Calendar.MONTH,+1);
			    	curStpStartDate = c.getTime();
			    	
			    	c.setTime(curStpEndDate);
			    	c.add(Calendar.MONTH,+1);
			    	curStpEndDate = c.getTime();
			    	
			    }

				
				
				stpDetails.put(curStpStartDate, curStpEndDate);
				
				
			
		}
		catch ( Exception e )  {
			System.out.println(" caught exception !!! ");
		}
		
		return stpDetails;
	}
}

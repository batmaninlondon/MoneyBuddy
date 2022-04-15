package com.myMoneyBuddy.Utils;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.DAOClasses.QueryPrimaryFundDetails;
import com.myMoneyBuddy.ModelClasses.ClientData;

public class RtaSpecificData {
	
	static Logger logger = LogManager.getLogger(RtaSpecificData.class);



	public static void main(String args[]) {

		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Client Records");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		List<ClientData> clientDataList = new LinkedList<ClientData>();
		String[][] bookData = new String[100][30] ;
		 
			 
		List<RtaDataModel> rtaDataModel;

		try {	
			
		logger.debug("PortfolioAction class : execute method : start");

		rtaDataModel = getData("CAMS");

		
		bookData[0][0]="FolioNumber";
		bookData[0][1]="UnitBalance";
		bookData[0][2]="CustomerName";
		bookData[0][3]="LatestValue";
		bookData[0][4]="FundName";
		
		int i=1;
		for ( RtaDataModel rtaData : rtaDataModel )   {
			bookData[i][0]=rtaData.getFolioNumber();
			bookData[i][1]=rtaData.getUnits();
			bookData[i][2]=rtaData.getCustomerName();
			bookData[i][3]=rtaData.getCurrentAmount();
			bookData[i][4]=rtaData.getSchemeName();
			i++;
		}
		
		
				
		logger.debug("PortfolioAction class : execute method : stored portfolioDataModel ");
		
		logger.debug("PortfolioAction class : execute method : end");
		

		
		int rowCount = 0;
        
        for (String[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);
             
            int columnCount = 0;
             
            for (String field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if ( field != null)  {
                if (  isInteger(field)) {
                	cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                    cell.setCellValue(Double.parseDouble(field));
                } else  {
                	cell.setCellValue((String) field);
                }
                }
                
            }
            
            
             
        }
         
         
        try (FileOutputStream outputStream = new FileOutputStream("WebContent/assets/ClientRecord/CAMS_FUND_DATA.xlsx")) {
            workbook.write(outputStream);
        }
		
        System.out.println("END !! ");
		
		}
		
		
		
		
		
		catch (Exception e) {	
			e.printStackTrace();
			
		} 
	}
	

	public static  List<RtaDataModel> getData(String rta){
	
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	    	       
		try
		{
			logger.debug("QueryProducts class - getPortfolioData method - start");
		
			Date todayDate = Calendar.getInstance().getTime();
			SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
			
			hibernateSession.beginTransaction();
	
			List<RtaDataModel> rtaDataModel = new LinkedList<RtaDataModel>();
			
	        Query  buySellRecordsQuery;
	      
	        Query query = hibernateSession.createQuery("select t.transactionFolioNum ,  c.customerId , p.fundId, c.customerName "
	        		+ " from TransactionDetails t, Customers c, PrimaryFundDetails p, SecondaryFundDetails s "
	        		+ " where t.transactionStatus='8' and c.customerId=t.customerId and p.fundId=t.fundId and s.fundId = p.fundId "
	        		+ " and s.rta =:rta group by t.customerId,t.fundId,t.transactionFolioNum ");
	        
	        query.setParameter("rta",rta);
	          
			Double totalInvestedAmount = 0.0;
			Double totalCurrentAmount = 0.0;
			
			String stpWithdrawalFlag = "Y";
			for(Iterator itFunds=query.iterate(); itFunds.hasNext();)	{
				Object[] rowFunds = (Object[]) itFunds.next();
				
				double soldUnit = 0.0;	
										
					double investedAmount = 0.0;
					double availableUnits = 0.0;
					double currentAmount = 0.0;
	  
				     String oldstring;
				     
				     String schemeName = null;
				     String schemeType = null;
				     DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
				     Date date;
				     	
				     query = hibernateSession.createQuery("select navValue from NavHistory where fundId = :fundId order by navHistoryId desc ");
						query.setParameter("fundId",rowFunds[2].toString());
						query.setMaxResults(1);
						String currentNavValue = query.uniqueResult().toString();
				     
						System.out.println("currentNavValue : "+currentNavValue+" for fund is : "+rowFunds[2].toString());
						
						System.out.println("customer Id : "+rowFunds[1].toString()+" and fund id : "+rowFunds[2].toString()+" and folio number is : "+rowFunds[0].toString());
			     	buySellRecordsQuery = hibernateSession.createQuery("select t.transactionDetailId, t.transactionAmount, t.quantity, t.unitPrice,"
			     			+ " t.updateDate, t.buySell , t.transactionFolioNum,  p.schemeName,p.schemeType, p.stpWithdrawalFlag " + 
			     			" from TransactionDetails t, PrimaryFundDetails p " + 
			     			" where p.fundId=t.fundId and p.fundId= :fundId and t.customerId= :customerId and t.transactionFolioNum = :transactionFolioNum " + 
			     			" and t.unitPrice is not null and t.transactionStatus='8'" );
				      
			     	buySellRecordsQuery.setParameter("customerId",rowFunds[1].toString());
			     	buySellRecordsQuery.setParameter("fundId",rowFunds[2].toString());
			     	buySellRecordsQuery.setParameter("transactionFolioNum", rowFunds[0].toString());
			     	
			     	java.util.List buySellList = buySellRecordsQuery.list();
				     
			     	for (Iterator buySellIt=buySellList.iterator(); buySellIt.hasNext();)  {
				     	
			     		
			     		
				    	 Object[] buySellRecordRow = (Object[]) buySellIt.next();
				    	 
				    	 schemeName = buySellRecordRow[7].toString();
				     	schemeType = buySellRecordRow[8].toString();
				     	stpWithdrawalFlag = buySellRecordRow[9].toString();
				     	
				    	 if ("SELL".equals(buySellRecordRow[5].toString()))  {
				    		 System.out.println("Inside the loop of SELL for fund id : "+rowFunds[2].toString()+" for buy");
					    	 soldUnit += Double.parseDouble(buySellRecordRow[2].toString());
					    	 oldstring = buySellRecordRow[4].toString().substring(0, 10);
		
					    	 date = (Date)formatter.parse(oldstring);
					    	 String updateDate = newFormat.format(date);
					         
				    	 }
			     	}
				     
			     	for (Iterator buySellIt=buySellList.iterator(); buySellIt.hasNext();)  {
				    	   
				    	 Object[] buySellRecordRow = (Object[]) buySellIt.next();
					       
				    	if ("BUY".equals(buySellRecordRow[5].toString()))  {
					       
				    		 System.out.println("Inside the loop of BUY for fund id : "+rowFunds[2].toString()+"for buy");
				    		
					    	 if (soldUnit != 0 )   {
					    		 System.out.println("Inside the loop of BUY sold unit ARE NOT zero : for fund id : "+rowFunds[2].toString()+" for buy");
							    	   
					    		 if (Double.parseDouble(buySellRecordRow[2].toString()) > soldUnit)  {
					    			 availableUnits += (Double.parseDouble(buySellRecordRow[2].toString()) - soldUnit);
					    			 investedAmount += (Double.parseDouble(buySellRecordRow[2].toString()) - soldUnit)* (Double.parseDouble(buySellRecordRow[3].toString()));
					    			 soldUnit = 0;	
					    			 System.out.println("availableUnits : "+availableUnits+" are for fund id : "+rowFunds[2].toString()+" for sell");
						    		 System.out.println("investedAmount : "+investedAmount+" are for fund id : "+rowFunds[2].toString()+" for sell");
					    		 }
					    		 else {
					    			 soldUnit -= Double.parseDouble(buySellRecordRow[2].toString());	   
					    		 }
					    	 }
						       
					    	 else {
					    		 System.out.println("Inside the loop of BUY sold unit ARE  zero : for fund id : "+rowFunds[2].toString()+" for buy");
					    		 availableUnits +=  Double.valueOf(buySellRecordRow[2].toString());
					    		 investedAmount += (Double.parseDouble(buySellRecordRow[1].toString()));
					    		 System.out.println("availableUnits : "+availableUnits+" are for fund id : "+rowFunds[2].toString()+" for buy");
					    		 System.out.println("investedAmount : "+investedAmount+" are for fund id : "+rowFunds[2].toString()+" for buy");
					    	 }
						       
					    	 oldstring = buySellRecordRow[4].toString().substring(0, 10);
		 
					    	 date = (Date)formatter.parse(oldstring);
							       	
					    	 String updateDate = newFormat.format(date);
							       	
				    	}
			     	}
				       
			     	System.out.println(" fund id is : "+rowFunds[2].toString());
				     currentAmount = availableUnits* Double.parseDouble(currentNavValue);
				     
				     String stpAllowed = "Y";
				     if ("Y".equals(stpWithdrawalFlag))   {
				    	 
				    	 QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
				    	 String availableFundsList = queryPrimaryFundDetails.getAvailableStpFundsList(rowFunds[2].toString());
				    	 
				    	 if ("".equals(availableFundsList))  {
				    		 stpAllowed = "N";
				    	 }
				    	 
				    	 if ( "Y".equals(stpAllowed))   {
				    		 String minStpAmount = queryPrimaryFundDetails.getMinStpAmount(rowFunds[2].toString());
				    		 
				    		 if (Double.parseDouble(minStpAmount) > currentAmount)   {
				    			 stpAllowed = "N";
				    		 }
				    	 }
				    	 
				     }
				     else {
				    	 stpAllowed = "N";
				     }
				     
				     System.out.println("availableUnits : "+availableUnits+" and currentAmount : "+currentAmount+" for fund id : "+rowFunds[2].toString());
				     final double THRESHOLD = .0001;
				     final double zeroVal = 0.0;
				     if ( Math.abs(availableUnits - zeroVal) >= THRESHOLD)  {
				    	 System.out.println("availableUnits and zeroVal are not equal using threshold");
				    	 rtaDataModel.add(new RtaDataModel(rowFunds[1].toString(),rowFunds[3].toString(),rowFunds[2].toString(),schemeName,rowFunds[0].toString(),
					    		  String.format("%.4f", availableUnits),String.format("%.2f",currentAmount)));
					     totalInvestedAmount +=  investedAmount;
					     totalCurrentAmount +=  currentAmount;
				     }
			
			}
			
			totalInvestedAmount = Double.parseDouble(String.format("%.4f", totalInvestedAmount));
			totalCurrentAmount = Double.parseDouble(String.format("%.4f", totalCurrentAmount));
			
			
			//portfolioDataModel.add(new PortfolioDataModel("","Total","","",String.format("%.2f",totalInvestedAmount),String.format("%.2f",totalCurrentAmount),String.format("%.2f",(totalCurrentAmount-totalInvestedAmount)),"","","N"));
	
			logger.debug("QueryProducts class - getPortfolioData method - return rtaDataModel of "+rtaDataModel.size()+ " record");
			logger.debug("QueryProducts class - getPortfolioData method - end");
				
			return rtaDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryProducts class - getPortfolioData method - Caught NumberFormatException");
			e.printStackTrace();
			return null;
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class - getPortfolioData method - Caught HibernateException");
			e.printStackTrace();
			return null;
		}
		catch (Exception e ) {
			logger.error("QueryProducts class - getPortfolioData method - Caught Exception");
			e.printStackTrace();
			return null;
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public static boolean isInteger(Object field) {
	    try { 
	        java.lang.Float.parseFloat(field.toString()); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
	}



}

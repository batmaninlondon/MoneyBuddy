package com.myMoneyBuddy.GAT;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.myMoneyBuddy.DAOClasses.QueryTransactionDetails;
import com.myMoneyBuddy.DAOClasses.UploadCustomerNav;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.SendMail;

public class ExcelToDb {
    public static void main( String [] args ) {
        
    	try {
    		
    		/*System.out.println("ReadSpreadSheet CLASS EXECUTION -------  START");
			String navFileName="C://xlsx/DailyNav.xls";
        
    		Vector navDataHolder=read(navFileName);
    		saveToDatabase(navDataHolder);
    		System.out.println("ReadSpreadSheet CLASS EXECUTION -------  END");*/
    		
    		System.out.println(" ExcelToDb Start ...........");
    		
    		String fileName="C://xlsx/6Jan.xls";
        
    		Vector dataHolder=read(fileName);
    		saveToDatabase(dataHolder);
    		System.out.println(" ExcelToDb End ...........");
        
        	/*File karvyFile = new File(karvyFileName);
        	karvyFile.delete();
            
            String camsFileName="D://xlsFiles/MoneyBuddyCams.xls";
            
            Vector camsDataHolder=read(camsFileName);
            saveToDatabase(camsDataHolder);
            
            File camsFile = new File(camsFileName);
            camsFile.delete();*/
        }
        catch (Exception e){
        	e.printStackTrace(); 
        }    
    }
    
    public static Vector read(String fileName)    {
        Vector cellVectorHolder = new Vector();
        try{
            FileInputStream myInput = new FileInputStream(fileName);
            //POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
            //XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
            org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(myInput);
            
            //XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            org.apache.poi.ss.usermodel.Sheet mySheet = workbook.getSheetAt(0);
            
            Iterator rowIter = mySheet.rowIterator();
            int fcell = 0;
            int lcell = 0;
            while(rowIter.hasNext()){
                HSSFRow myRow = (HSSFRow) rowIter.next();
                fcell = myRow.getFirstCellNum();
                lcell = myRow.getLastCellNum();
                if(containsValue(myRow, fcell, lcell) == true & 
                		!("TRANSACTION REPORT".equals(myRow.getCell(0).toString())) & 
                		!("Product Code".equals(myRow.getCell(0).toString()))){
                	//System.out.println("Outside if FirstColumn :"+myRow.getCell(0)+":");

		                Iterator cellIter = myRow.cellIterator();
		                //Vector cellStoreVector=new Vector();
		                List list = new ArrayList();
		                
		                while(cellIter.hasNext()){
		                    HSSFCell myCell = (HSSFCell) cellIter.next();
		                    list.add(myCell);
		                }
		                cellVectorHolder.addElement(list);
                	
                }
            }
            
            
        }catch (Exception e){
        	e.printStackTrace(); 
        }
        return cellVectorHolder;
    }
    private static void saveToDatabase(Vector dataHolder) throws MoneyBuddyException {
        //String ClientAdd="";
        String allottedNav="";
        String allottedUnits="";
        String folioNum="";
        String bseOrderId="";
        String Bytes="";
        String bseRegNum = "";
        String trnDate = "";
        String trnType = "";
        
        List<String> ExtraBseOrderId = new ArrayList<String>();
        List<String> ExtraBseRegNum = new ArrayList<String>();
        /*System.out.println(dataHolder);*/

        Workbook workbook;
		try {
			workbook = WorkbookFactory.create(new File("C://xlsx/6Jan.xls"));
		
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();

        
        Iterator<Row> rowIterator = sheet.rowIterator();
        QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
        List<String> bseOrdIdAndRegNumList = queryTransactionDetails.getPendingBseOrdIdAndRegNum();
        List<String> allBseOrdIdAndRegNumList = queryTransactionDetails.getAllBseOrdIdAndRegNum();
        
        for ( int i = 0 ; i < bseOrdIdAndRegNumList.size();i++)  {
        	System.out.println("bseOrdIdAndRegNumList.get("+i+") : "+bseOrdIdAndRegNumList.get(i));
        }
        
        boolean extraBseOrderIdExists = false;
        boolean extraBseRegNumExists = false;
        
        
        if (rowIterator.hasNext())
        	rowIterator.next();
        
        while (rowIterator.hasNext()) {
        	
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            boolean bseOrderIdExists = false;
            boolean bseRegNumExists = false;
           
            
            while (cellIterator.hasNext()) {
            	
                Cell cell = cellIterator.next();
                
                String cellValue = dataFormatter.formatCellValue(cell);
                
                if ( cell.getColumnIndex() == 0 ) { 
                	trnDate = cellValue;
                }
                
                else if ( cell.getColumnIndex() == 1 ) {
                	/*System.out.println("cell.getColumnIndex() : "+cell.getColumnIndex()+" and cellValue : "+cellValue);*/
                	bseOrderId = cellValue;
                	if (! "0".equals(bseOrderId))  {
	                	if (bseOrdIdAndRegNumList.contains(bseOrderId))  {
	                		bseOrderIdExists = true;
	                		
	                		
	                		System.out.println("Contains bseOrderId : "+bseOrderId );
	                		
	                		
	                	}
	                	
	                	if (! allBseOrdIdAndRegNumList.contains(bseOrderId))
	                	{
	                		 extraBseOrderIdExists = true;
	                		 ExtraBseOrderId.add(bseOrderId);
	                     	System.out.println("Does not Contains bseOrderId : "+bseOrderId );
	                     }
                	}
                }
               
                else if ( cell.getColumnIndex() == 12 ) { 
                	folioNum = cellValue;
                }
                else if ( cell.getColumnIndex() == 18 ) { 
                	allottedNav = cellValue;
                }
                else if ( cell.getColumnIndex() == 19 ) {
                	allottedUnits = cellValue;
                }
                
                else if ( cell.getColumnIndex() == 26 ) {
                	bseRegNum = cellValue;
                	if (! "0".equals(bseRegNum))  {
                		trnType="SIP";
	                	if (bseOrdIdAndRegNumList.contains(bseRegNum))  {
	                		bseRegNumExists = true;
	                		
	                		
	                		System.out.println("Contains bseRegNum : "+bseRegNum );
	                		
	                		
	                	}
	                	if (! allBseOrdIdAndRegNumList.contains(bseRegNum)) {
	                		 extraBseRegNumExists = true;
	                		 ExtraBseRegNum.add(bseRegNum);
	                     	System.out.println("Does not Contains bseRegNum : "+bseRegNum );
	                     }
                	}
                	else {
                		trnType="UPFRONT";
                		
                	}
                }
                
                
               /* if ( cell.getColumnIndex() == 1 || cell.getColumnIndex() == 12 || cell.getColumnIndex() == 18 || cell.getColumnIndex() == 19)  
                System.out.print(cellValue + "\t");*/
            }
            if (bseOrderIdExists || bseRegNumExists)  {
            	
            	
            		
            		System.out.println("bseOrderId : "+bseOrderId+" and bseRegNum : "+bseRegNum+" and folioNum : "+folioNum+
            				" and allottedNav : "+allottedNav+"allottedUnits : "+allottedUnits);
            	UploadCustomerNav UploadCustomerNav = new UploadCustomerNav();
        		UploadCustomerNav.uploadCusNav(bseOrderId, bseRegNum, folioNum, allottedNav, allottedUnits);
            	
            }
            
            System.out.println();
        }
        
        if (extraBseOrderIdExists || extraBseRegNumExists)  {
        	
        	String bseOrderIds="";
        	String bseRegNums="";
        	
        	for ( int i=0;i<ExtraBseOrderId.size();i++)  {
        		
        		bseOrderIds += ExtraBseOrderId.get(i)+",";
        		System.out.println(" update bseOrderIds  : "+bseOrderIds);
        	}
        	
        	for ( int i=0;i<ExtraBseRegNum.size();i++)  {
        		bseRegNums += ExtraBseRegNum.get(i)+",";
        		System.out.println(" update bseRegNums  : "+bseRegNums);
        	}
        	
        	SendMail sendMail = new SendMail();
        	sendMail.FaultyIdMailSending(bseOrderIds, bseRegNums);
        }
        
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        for(Iterator iterator = dataHolder.iterator();iterator.hasNext();) {
            List<String> list = (List<String>) iterator.next();
            
            //System.out.println("list is : "+list);
            
            /*System.out.println("Size of list : "+list.size());
            for (int i = 0 ;i<list.size();i++) {
            	System.out.println(" list : "+i+" = "+list.get(i).toString());
            }*/
            /*transactionNumber = list.get(7).toString();
            transactionNumber = transactionNumber.substring(0, transactionNumber.length() - 2);
            price = list.get(17).toString();
            units = list.get(19).toString();*/
            
            /*bseOrderId = list.get(1).toString();
            allottedNav = list.get(18).toString();
            allottedUnits = list.get(19).toString();
            folioNum = list.get(12).toString();*/
            
            
            //System.out.println("bseOrderId : "+bseOrderId+" and allottedNav : "+allottedNav+" and allottedUnits : "+allottedUnits+" and folioNum : "+folioNum);
            
           /* Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
            Query query = null;
            try {
            	
            	hibernateSession.beginTransaction();
				query = hibernateSession.createQuery("update TransactionDetails set quantity = :quantity , unitPrice = :unitPrice , transactionStatus = :transactionStatus where transactionDetailId = :transactionDetailId");
				query.setParameter("quantity", units);
				query.setParameter("unitPrice", price);
				query.setParameter("transactionStatus", "8");
				query.setParameter("transactionDetailId", transactionNumber);
				int updateResult = query.executeUpdate();
				System.out.println(updateResult + " rows updated in transactionDetails table ");
				hibernateSession.getTransaction().commit();
            }
            catch (Exception e) {	
    			e.printStackTrace();

    		} 
            finally {
    			if(hibernateSession !=null )
    					hibernateSession.close();
    		}*/

        }



        }
    public static boolean containsValue(HSSFRow row, int fcell, int lcell) 
    {
        boolean flag = false;
        for (int i = fcell; i < lcell; i++) {
        if (StringUtils.isEmpty(String.valueOf(row.getCell(i))) == true || 
            StringUtils.isWhitespace(String.valueOf(row.getCell(i))) == true || 
            StringUtils.isBlank(String.valueOf(row.getCell(i))) == true || 
            String.valueOf(row.getCell(i)).length() == 0 || 
            row.getCell(i) == null) {} 
        else {
                    flag = true;
            }
        }
            return flag;
    }


/*    public static void populateUnitPriceAndNav (String transactionFolioNum, String navValue, String unitsPurchased, 
    					String bseOrderId, String bseRegNum, String transactionDate, String transactnType)  {
	
	

	
	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	
	try {
		
		

		System.out.println("UploadCustomerNavAction class : execute method : called ");
		
		System.out.println("transactionFolioNum : "+transactionFolioNum+" : unitPrice : "+navValue+" : quantity : "+unitsPurchased+""
				+ " : bseOrderId : "+bseOrderId+" : bseRegNum : "+bseRegNum+" : transactionDate : "+transactionDate);
		   		
		hibernateSession.beginTransaction();
		
		Query query;
		if ("SIP".equals(transactnType))  {

    		query = hibernateSession.createQuery("select transactionDetailId,transactionAmount from TransactionDetails where bseRegistrationNumber = :bseRegistrationNumber"
    				+ " and transactionDate = :transactionDate ");
    		query.setParameter("bseRegistrationNumber", bseRegNum);
    		query.setParameter("transactionDate", transactionDate);
    		
		}
		else {
		
			query = hibernateSession.createQuery("select transactionDetailId,transactionAmount from TransactionDetails where bseOrderId = :bseOrderId ");
    		query.setParameter("bseOrderId", bseOrderId);
    		
		}
    		
		List<Object[]> transactionDetailList = query.list();

		String transactionDetailId = transactionDetailList.get(0)[0].toString();
		Double transactionAmount = Double.valueOf(transactionDetailList.get(0)[1].toString());

		hibernateSession.getTransaction().commit();

		Double calculatedAmount = Double.valueOf(navValue) * Double.valueOf(unitsPurchased);

		System.out.println(" NAV value : "+navValue+" : units : "+unitsPurchased);
		
		System.out.println("calculated amount : "+calculatedAmount+" : transactionAmount : "+transactionAmount);

		
		hibernateSession.beginTransaction();

		query = hibernateSession.createQuery("select t.fundId, c.panCard, t.customerId, t.transactionFolioNum,s.amcCode,t.transactionType "
								+ "from Customers c, TransactionDetails t, SecondaryFundDetails s "
								+ "where t.customerId = c.customerId and t.fundId = s.fundId and t.transactionDetailId= :transactionDetailId");
		

		query.setParameter("transactionDetailId", transactionDetailId);
		
		List<Object[]> queryResult = query.list(); 
		
		String fundId = queryResult.get(0)[0].toString();
		String panCard = queryResult.get(0)[1].toString();
		String customerId = queryResult.get(0)[2].toString();
		String folioNum = null;
		if (queryResult.get(0)[3] != null )  {
			folioNum = queryResult.get(0)[3].toString();	
		}
		
		String amcCode = queryResult.get(0)[4].toString();
		String transactionType = queryResult.get(0)[5].toString();
		
		System.out.println(" panCard : "+panCard+" : customerId : "+customerId+" : folioNum : "+folioNum+" : amcCode : "+amcCode);
		
		hibernateSession.getTransaction().commit();
		
		if ("".equals(folioNum) || folioNum == null)  {
			
			hibernateSession.beginTransaction();

			FolioDetails tempFolioDetails = new FolioDetails( transactionFolioNum, customerId, panCard,fundId,amcCode,"MoneyBuddy");
			hibernateSession.save(tempFolioDetails);
			
			hibernateSession.getTransaction().commit();

		}

		hibernateSession.beginTransaction();
		query = hibernateSession.createQuery("update TransactionDetails set transactionFolioNum = :transactionFolioNum , "
				+ "unitPrice = :unitPrice , quantity = :quantity , bseOrderId = :bseOrderId, transactionStatus = :transactionStatus , reverseFeed = :reverseFeed "
				+ " where transactionDetailId = :transactionDetailId");

		query.setParameter("transactionFolioNum", transactionFolioNum);
		query.setParameter("unitPrice", navValue);
		query.setParameter("quantity", unitsPurchased);
		query.setParameter("bseOrderId", bseOrderId);
		query.setParameter("transactionDetailId", transactionDetailId);
		query.setParameter("transactionStatus", "8");
		query.setParameter("reverseFeed", "Y");
		
		int updateResult = query.executeUpdate();
		System.out.println(updateResult + " rows updated in transactionDetails table ");
		hibernateSession.getTransaction().commit();	
		    	
    	Customers customers = new QueryCustomer().getCustomerFromCustomerId(customerId);
    	
    	String emailId = customers.getEmailId();
    	String customerName = customers.getCustomerName();
    	
    	SendMail sendMail = new SendMail();

    	Properties configProperties = new Properties();
		String configPropFilePath = "../../../config/config.properties";

		configProperties.load(ForgotPasswordAction.class.getResourceAsStream(configPropFilePath));
		
		if ("UPFRONT".equals(transactionType))  {
 			String mailLink = configProperties.getProperty("MAIL_UPFRONT_TRANSACTION_EXECUTED_LINK");
			System.out.println("mailLink is : "+mailLink);
	    	
	    	String subject = configProperties.getProperty("MAIL_UPFRONT_TRANSACTION_EXECUTED_SUBJECT");

	    	sendMail.MailSending(emailId,subject,"UpfrontTransactionExecutedMail","UpfrontTransactionExecutedMail.txt",mailLink,"LoginToMoneyBuddy",customerName);
		}
		else if ("SIP".equalsIgnoreCase(transactionType)){
			String mailLink = configProperties.getProperty("MAIL_SIP_TRANSACTION_EXECUTED_LINK");
			System.out.println("mailLink is : "+mailLink);
	    	
	    	String subject = configProperties.getProperty("MAIL_SIP_TRANSACTION_EXECUTED_SUBJECT");

	    	sendMail.MailSending(emailId,subject,"SipTransactionExecutedMail","SipTransactionExecuted.txt",mailLink,"LoginToMoneyBuddy",customerName);
		}
		else if ("REDEMPTION".equalsIgnoreCase(transactionType)){
			String mailLink = configProperties.getProperty("MAIL_REDEMPTION_TRANSACTION_EXECUTED_LINK");
			System.out.println("mailLink is : "+mailLink);
	    	
	    	String subject = configProperties.getProperty("MAIL_REDEMPTION_TRANSACTION_EXECUTED_SUBJECT");

	    	sendMail.MailSending(emailId,subject,"RedemptionTransactionExecutedMail","RedemptionTransactionExecuted.txt",mailLink,"LoginToMoneyBuddy",customerName);
		}
		else if ("STP".equalsIgnoreCase(transactionType)){
			String mailLink = configProperties.getProperty("MAIL_STP_TRANSACTION_EXECUTED_LINK");
			System.out.println("mailLink is : "+mailLink);
	    	
	    	String subject = configProperties.getProperty("MAIL_STP_TRANSACTION_EXECUTED_SUBJECT");

	    	sendMail.MailSending(emailId,subject,"StpTransactionExecutedMail","StpTransactionExecuted.txt",mailLink,"LoginToMoneyBuddy",customerName);
		}
    	
    	
    	
    	String str = "success";
	    stream = new ByteArrayInputStream(str.getBytes());
    	
    	
	}
	catch (Exception e) {	
		
		e.printStackTrace();
		
		String str = "error";
	    stream = new ByteArrayInputStream(str.getBytes());
	    
	    
	}
	finally {
		if(hibernateSession !=null )
				hibernateSession.close();
	}

	
    }*/
}


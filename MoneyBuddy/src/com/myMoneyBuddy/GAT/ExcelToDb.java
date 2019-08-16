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
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.DAOClasses.QueryTransactionDetails;
import com.myMoneyBuddy.DAOClasses.UploadCustomerNav;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class ExcelToDb {
    public static void main( String [] args ) {
        
    	try {
    		
    		/*System.out.println("ReadSpreadSheet CLASS EXECUTION -------  START");
			String navFileName="C://xlsx/DailyNav.xls";
        
    		Vector navDataHolder=read(navFileName);
    		saveToDatabase(navDataHolder);
    		System.out.println("ReadSpreadSheet CLASS EXECUTION -------  END");*/
    		
    		String fileName="C://xlsx/5678.xls";
        
    		Vector dataHolder=read(fileName);
    		saveToDatabase(dataHolder);
        
        
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
        /*System.out.println(dataHolder);*/

        Workbook workbook;
		try {
			workbook = WorkbookFactory.create(new File("C://xlsx/5678.xls"));
		
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();

        
        Iterator<Row> rowIterator = sheet.rowIterator();
        QueryTransactionDetails queryTransactionDetails = new QueryTransactionDetails();
        List<String> bseOrderIdList = queryTransactionDetails.getPendingBseOrderId();
        
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            boolean bseOrderIdExists = false;
            while (cellIterator.hasNext()) {
            	
                Cell cell = cellIterator.next();
                
                String cellValue = dataFormatter.formatCellValue(cell);
                
                
                if ( cell.getColumnIndex() == 1 ) {
                	/*System.out.println("cell.getColumnIndex() : "+cell.getColumnIndex()+" and cellValue : "+cellValue);*/
                	bseOrderId = cellValue;
                	if (bseOrderIdList.contains(bseOrderId))  {
                		bseOrderIdExists = true;
                		
                		
                		System.out.println("Contains bseOrderId : "+bseOrderId );
                		
                		
                	}
                	 else {
                     	System.out.println("Does not Contains bseOrderId : "+bseOrderId );
                     }
                }
               
                else if ( cell.getColumnIndex() == 12 ) { 
                	/*System.out.print("cell.getColumnIndex() : "+cell.getColumnIndex()+" and cellValue : "+cellValue);*/
                	folioNum = cellValue;
                }
                else if ( cell.getColumnIndex() == 18 ) { 
                	/*System.out.print("cell.getColumnIndex() : "+cell.getColumnIndex()+" and cellValue : "+cellValue);*/
                	allottedNav = cellValue;
                }
                else if ( cell.getColumnIndex() == 19 ) {
                	/*System.out.print("cell.getColumnIndex() : "+cell.getColumnIndex()+" and cellValue : "+cellValue);*/
                	allottedUnits = cellValue;
                }
                
                
               
                
               /* if ( cell.getColumnIndex() == 1 || cell.getColumnIndex() == 12 || cell.getColumnIndex() == 18 || cell.getColumnIndex() == 19)  
                System.out.print(cellValue + "\t");*/
            }
            if (bseOrderIdExists)  {
            	
            		
            		System.out.println("bseOrderId : "+bseOrderId+" and folioNum : "+folioNum+
            				" and allottedNav : "+allottedNav+"allottedUnits : "+allottedUnits);
            	UploadCustomerNav UploadCustomerNav = new UploadCustomerNav();
        		UploadCustomerNav.uploadCusNav(bseOrderId, folioNum, allottedNav, allottedUnits);
            	
            }
            
            System.out.println();
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
    }
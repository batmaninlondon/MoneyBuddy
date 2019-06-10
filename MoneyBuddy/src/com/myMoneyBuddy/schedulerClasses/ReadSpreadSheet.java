package com.myMoneyBuddy.schedulerClasses;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.myMoneyBuddy.DAOClasses.QuerySecondaryFundDetails;
import com.myMoneyBuddy.EntityClasses.NavHistory;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class ReadSpreadSheet implements org.quartz.Job {
	
	public void execute(JobExecutionContext cntxt) throws JobExecutionException {
		
		try {
    		
    		System.out.println("ReadSpreadSheet CLASS EXECUTION -------  START");
			String navFileName="C://xlsx/DailyNav.xls";
        
    		Vector navDataHolder=read(navFileName);
    		saveToDatabase(navDataHolder);
    		System.out.println("ReadSpreadSheet CLASS EXECUTION -------  END");

        }
		
        catch (Exception e){
        	e.printStackTrace(); 
        } 

	}
/*    public static void main( String [] args ) {
        
    	try {
    		
    		String navFileName="C://xlsx/DailyNav.xls";
        
    		Vector navDataHolder=read(navFileName);
    		saveToDatabase(navDataHolder);

        }
        catch (Exception e){
        	e.printStackTrace(); 
        }    
    }*/
    
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
        String navDate="";
        String navValue="";
        //String fundId="";
        String isin="";
        String fundData;
        
        System.out.println(dataHolder);

        QuerySecondaryFundDetails querySecondaryFundDetails = new QuerySecondaryFundDetails();
        
        HashMap<String,String> schemeCodesAndFundIds = querySecondaryFundDetails.allSchemeCodesAndFundIds();
        
        for(Iterator iterator = dataHolder.iterator();iterator.hasNext();) {
            List list = (List) iterator.next();
            
            /*System.out.println("Size of list : "+list.size());
            for (int i = 0 ;i<list.size();i++) {
            	System.out.println(" list : "+i+" = "+list.get(i).toString());
            }*/
            fundData = list.get(0).toString();
            
            String[] dataSpilts = fundData.split("\\;");
            
            //System.out.println("dataSpilts size : "+dataSpilts.length);
            
            if ( dataSpilts.length == 6 )  {
	            isin = dataSpilts[1];
	            navValue = dataSpilts[4];
	            navDate = dataSpilts[5];

	            Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	            Query query = null;
	            try {
	            	
	            	if (schemeCodesAndFundIds.containsKey(isin))  {
	            		
	            		 Date dNow = new Date();
	            		  
	            		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        			
	        			String frmtdDate = dateFormat.format(dNow);
	        			
	            		
	            		  
	            		System.out.println("isin : "+isin+" : navValue : "+navValue+" : navDate : "+frmtdDate);
		            	hibernateSession.beginTransaction();
		    			
		    			NavHistory tempNavHistory = new NavHistory(frmtdDate,navValue,schemeCodesAndFundIds.get(isin));
		
		    			hibernateSession.save(tempNavHistory);
		
		    			hibernateSession.getTransaction().commit();
	            	}
		    			
	            }
	            
	            
	            catch (Exception e) {	
	    			e.printStackTrace();
	
	    		} 
	            finally {
	    			if(hibernateSession !=null )
	    					hibernateSession.close();
	    		}
            }

        }

        System.out.println(" ALL DATA ENTERIES DONE !!!!!!!! ");

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
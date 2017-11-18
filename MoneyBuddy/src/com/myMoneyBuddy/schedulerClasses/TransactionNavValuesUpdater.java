package com.myMoneyBuddy.schedulerClasses;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
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
import com.myMoneyBuddy.Utils.HibernateUtil;

public class TransactionNavValuesUpdater implements org.quartz.Job{



	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		try {

			String karvyFileName="D://xlsFiles/MoneyBuddyKarvy.xls";
			String camsFileName="D://xlsFiles/MoneyBuddyCams.xls";
			File karvyFile = new File(karvyFileName);
			File camsFile = new File(camsFileName);

			if(karvyFile.exists())  {

				Vector KarvyDataHolder=read(karvyFileName);
				saveToDatabase(KarvyDataHolder);

				karvyFile.delete();
			}

			if(camsFile.exists())  {

				Vector camsDataHolder=read(camsFileName);
				saveToDatabase(camsDataHolder);

				camsFile.delete();
			}
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
	private static void saveToDatabase(Vector dataHolder) {
		//String ClientAdd="";
		String price="";
		String units="";
		String transactionNumber="";
		String Bytes="";
		System.out.println(dataHolder);

		for(Iterator iterator = dataHolder.iterator();iterator.hasNext();) {
			List list = (List) iterator.next();

			/*System.out.println("Size of list : "+list.size());
            for (int i = 0 ;i<list.size();i++) {
            	System.out.println(" list : "+i+" = "+list.get(i).toString());
            }*/
			transactionNumber = list.get(7).toString();
			transactionNumber = transactionNumber.substring(0, transactionNumber.length() - 2);
			price = list.get(17).toString();
			units = list.get(19).toString();


			System.out.println("transactionNumber : "+transactionNumber);
			System.out.println("price : "+price);
			System.out.println("units : "+units);

			Session session = null;
			Query query = null;
			try {
				session = HibernateUtil.getSessionAnnotationFactory().openSession();
				session.beginTransaction();
				query = session.createQuery("update TransactionDetails set quantity = :quantity , unitPrice = :unitPrice , transactionStatus = :transactionStatus where transactionDetailId = :transactionDetailId");
				query.setParameter("quantity", units);
				query.setParameter("unitPrice", price);
				query.setParameter("transactionStatus", "COMPLETE");
				query.setParameter("transactionDetailId", transactionNumber);
				int updateResult = query.executeUpdate();
				System.out.println(updateResult + " rows updated in transactionDetails table ");
				session.getTransaction().commit();
			}
			catch (Exception e) {	
				e.printStackTrace();

			} 
			finally {
				//HibernateUtil.getSessionAnnotationFactory().close();
				session.close();
			}

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
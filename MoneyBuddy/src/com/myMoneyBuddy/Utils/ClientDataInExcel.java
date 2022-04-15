package com.myMoneyBuddy.Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.ClientData;

public class ClientDataInExcel {
	
		public static void main(String[] args) throws IOException,MoneyBuddyException {
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Client Records");
			Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	
			List<ClientData> clientDataList = new LinkedList<ClientData>();
			 String[][] bookData = new String[100][30] ;
			 
			try
			{
				hibernateSession.beginTransaction();
				
				Query query = hibernateSession.createQuery("select distinct(amcCode) from SecondaryFundDetails order by amcCode asc ");
				
				List<String> amcList = query.list();
				
				hibernateSession.getTransaction().commit();
				
				bookData[0][0]="CustomerID";
				bookData[0][1]="CustomerName";
				bookData[0][2]="TotalAmount";
				bookData[0][3]="TotalSIPAmount";
				int j = 4;
				
				for ( String amc : amcList )   {
					bookData[0][j++]=amc;
				}
					
				Double[] totalRecord = new Double[amcList.size()+2];
				
				for ( int i=0 ;  i < totalRecord.length ; i++)
					totalRecord[i] = 0.0;
				
				
				hibernateSession.beginTransaction();
				
				query = hibernateSession.createQuery("select c.customerId,c.customerName , sum(t.unitPrice*t.quantity) from Customers c, TransactionDetails t " + 
						"where t.transactionStatus = '8' and c.customerId=t.customerId group by t.customerId ");
				
				List<Object[]> customersList = query.list();
				String customerId = "";
				String customerName = "";
				String totalAmount = "";
				hibernateSession.getTransaction().commit();
				
				String amount = "";
				for ( int i = 0; i < customersList.size() ;i++ ) {
					
					customerId = customersList.get(i)[0].toString();
					customerName = customersList.get(i)[1].toString();
					totalAmount = customersList.get(i)[2].toString();
					if (totalAmount != null)
						totalAmount = String.format("%.2f",Double.parseDouble(totalAmount));
					else 
						totalAmount = "0.0";
					
					totalRecord[0] += Double.parseDouble(totalAmount);
					 
					bookData[(i+1)][0]=customerId;
					bookData[(i+1)][1]=customerName;
					bookData[(i+1)][2]=totalAmount;
					
					hibernateSession.beginTransaction();
					
					query = hibernateSession.createQuery("select sum(sipAmount) from SipDetails "
							+ " where sipCompletionStatus='N' and customerId = :customerId and sipDate is not null ");
					
					query.setParameter("customerId", customerId );
						
					Object result = query.uniqueResult();
					
					if (result != null)
						bookData[(i+1)][3] = result.toString();
					else 
						bookData[(i+1)][3] = "0.0";
					
					totalRecord[1] += Double.parseDouble(bookData[(i+1)][3].toString());
					
					hibernateSession.getTransaction().commit();
									
					hibernateSession.beginTransaction();
					
					query = hibernateSession.createSQLQuery("select sum(t.UNIT_PRICE*t.QUANTITY) from "
							+ " ( select * from TRANSACTION_DETAILS where CUSTOMER_ID= :customerId and TRANSACTION_STATUS='8' ) t "
							+ " RIGHT JOIN SECONDARY_FUND_DETAILS s ON  t.FUND_ID=s.FUND_ID "
							+ " group by s.AMC_CODE order by s.AMC_CODE asc");
					
					query.setParameter("customerId", customerId );
						
					List<String> amountsList = query.list();
					
					hibernateSession.getTransaction().commit();
					
					for ( int k = 0; k < amountsList.size() ;k++ ) {
						
						if (null != amountsList.get(k))  
							amount = String.format("%.2f",amountsList.get(k));
						else 
							amount="0.0";
						
						bookData[(i+1)][(k+4)]=amount;
						totalRecord[k+2] += Double.parseDouble(amount);
						
					}
				}
				
				int total = customersList.size()+1;
				bookData[total][1] = "TOTAL";
				
				
				for ( int i = 0; i < totalRecord.length ;i++ ) {
					bookData[total][(i+2)]= String.format("%.2f",totalRecord[i]); 
				}
				
				
		
			}
			catch ( HibernateException e ) {
				
				e.printStackTrace();
				throw new MoneyBuddyException(e.getMessage(),e);
			}
			catch (Exception e ) {
				
				e.printStackTrace();
				throw new MoneyBuddyException(e.getMessage(),e);
			}
			finally {
				if(hibernateSession !=null )
						hibernateSession.close();
			}
			
			
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
	         
	         
	        try (FileOutputStream outputStream = new FileOutputStream("WebContent/assets/ClientRecord/ClientRecords.xlsx")) {
	            workbook.write(outputStream);
	        }
	        
	        SendMail sendMail = new SendMail();
	        /*sendMail.sendMailwithAttachement();*/
	        
	        
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

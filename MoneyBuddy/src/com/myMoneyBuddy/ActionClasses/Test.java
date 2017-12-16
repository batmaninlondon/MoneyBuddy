package com.myMoneyBuddy.ActionClasses;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.EntityClasses.CustomerPortfolio;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

import java.io.*;
import com.linuxense.javadbf.*;

public class Test {
	
	
	public static void main(String args[])  {
	
		
		
		
		
		try {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String frmtdDate = dateFormat.format(date);
    		
		  	DBFField fields[] = new DBFField[4];
		  
		  	fields[0] = new DBFField();
		    fields[0].setFieldName("TRANS_ID");
		    fields[0].setDataType( DBFField.FIELD_TYPE_C);
		    fields[0].setFieldLength(25);

		    fields[1] = new DBFField();
		    fields[1].setFieldName( "CUST_ID");
		    fields[1].setDataType( DBFField.FIELD_TYPE_C);
		    fields[1].setFieldLength(20);

		    fields[2] = new DBFField();
		    fields[2].setFieldName( "TRANS_DATE");
		    fields[2].setDataType( DBFField.FIELD_TYPE_C);
		    fields[2].setFieldLength(20);
		    
		    fields[3] = new DBFField();
		    fields[3].setFieldName( "DBF_DATE");
		    fields[3].setDataType( DBFField.FIELD_TYPE_C);
		    fields[3].setFieldLength(20);

		    
		    DBFWriter writer = new DBFWriter();
		    writer.setFields( fields);

        
		    Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

		   try
			{
				session.beginTransaction();
				
/*				
				query = session.createQuery("from CustomerPortfolio where productId = :productId and customerId = :customerId and investmentTypeName = :groupName");
				query.setParameter("productId",currentProductId);
				query.setParameter("customerId",customerId);
				query.setParameter("groupName",groupName);

				List<CustomerPortfolio> customerPortfolio = query.list();*/

				
				
				Query query =  session.createQuery("from DbfDataDetails where dbfDataDate = :dbfDataDate");
				query.setParameter("dbfDataDate", "2017-10-05");
				List<DbfFileStatusDetails> dbfDataDetailsList = query.list();

				Object rowData[] = new Object[4];
				
				for(DbfFileStatusDetails dbfDataDetail : dbfDataDetailsList){

				   /* rowData[0] = dbfDataDetail.getTransactionDetailId();
				    rowData[1] = dbfDataDetail.getCustomerId();
				    rowData[2] = dbfDataDetail.getTransactionDetailDate();*/
				    rowData[3] = dbfDataDetail.getDbfDataDate();

				    writer.addRecord( rowData);

					rowData = new Object[4];
				}
				
				//session.getTransaction().commit();
				
				Properties properties = new Properties();
				String propFilePath = "../../../config/config.properties";

				properties.load(Trading.class.getResourceAsStream(propFilePath));
				
				String srcDirName = properties.getProperty("SRC_DIR_NAME");

			    FileOutputStream fos = new FileOutputStream(srcDirName+frmtdDate+".dbf");
			    writer.write( fos);
			    fos.close();
				
				System.out.println("Done ! ");

			}
			catch ( HibernateException e ) {

				e.printStackTrace();
				throw new MoneyBuddyException(e.getMessage(),e);
			}
		   catch (IOException e ) {

				e.printStackTrace();
				throw new MoneyBuddyException(e.getMessage(),e);
		   }
			catch (Exception e ) {

				e.printStackTrace();
				throw new MoneyBuddyException(e.getMessage(),e);
			}
			finally {
				/*if(factory!=null)
				factory.close();*/
				//HibernateUtil.getSessionAnnotationFactory().close();
				session.close();
			}


		} 
	 
   	catch (Exception e) {	

			e.printStackTrace();

		} 


	}
		
		
		
		
		
		
		
		
		
		
		
/*	   	try {

    		
		  	DBFField fields[] = new DBFField[4];
		  
		  	fields[0] = new DBFField();
		    fields[0].setFieldName("cust_id");
		    fields[0].setDataType( DBFField.FIELD_TYPE_C);
		    fields[0].setFieldLength(10);

		    fields[1] = new DBFField();
		    fields[1].setFieldName( "email_id");
		    fields[1].setDataType( DBFField.FIELD_TYPE_C);
		    fields[1].setFieldLength(30);

		    fields[2] = new DBFField();
		    fields[2].setFieldName( "mobile_num");
		    fields[2].setDataType( DBFField.FIELD_TYPE_C);
		    fields[2].setFieldLength(20);
		    
		    fields[3] = new DBFField();
		    fields[3].setFieldName( "name");
		    fields[3].setDataType( DBFField.FIELD_TYPE_C);
		    fields[3].setFieldLength(20);
		    
		  	
		  	fields[0] = new DBFField();
		    fields[0].setName("cust_id");
		    fields[0].setType(DBFDataType.CHARACTER);
		    fields[0].setFieldLength(20);

		    fields[1] = new DBFField();
		    fields[1].setName("email_id");
		    fields[1].setType(DBFDataType.CHARACTER);
		    fields[1].setFieldLength( 20);

		    fields[2] = new DBFField();
		    fields[2].setName("mobile_num");
		    fields[2].setType(DBFDataType.CHARACTER);
		    fields[2].setFieldLength( 20);
		    
		    fields[3] = new DBFField();
		    fields[3].setName("name");
		    fields[3].setType(DBFDataType.CHARACTER);
		    fields[3].setFieldLength( 20);

		    String defaultCharacterEncoding = System.getProperty("file.encoding");
		    System.out.println(defaultCharacterEncoding);
		    System.setProperty("file.encoding", "UTF-8");
		    
		    DBFWriter writer = new DBFWriter();
		    writer.setFields( fields);

		    // now populate DBFWriter
		    //

		    Object rowData[] = new Object[4];
		    rowData[0] = "1000";
		    rowData[1] = "John";
		    rowData[2] = "5000";
		    rowData[3] = "5001";

		    writer.addRecord( rowData);

		    rowData = new Object[4];
		    rowData[0] = "1001";
		    rowData[1] = "Lalit";
		    rowData[2] = "6000";
		    rowData[3] = "5002";

		    writer.addRecord( rowData);

		    rowData = new Object[4];
		    rowData[0] = "1002";
		    rowData[1] = "Rohit";
		    rowData[2] = "7000";
		    rowData[3] = "5002";

		    writer.addRecord( rowData);

		    FileOutputStream fos = new FileOutputStream("D://DbfFiles/Test.dbf");
		    
		    
		    writer.write( fos);
		    
		    fos.close();
		        
		    SessionFactory factory = new AnnotationConfiguration()
					.configure()
					.addAnnotatedClass(Customers.class)
					.buildSessionFactory();
		    Session session = factory.openSession();
		    
		   try
			{
				session.beginTransaction();
				
				
				Query query =  session.createQuery("from Customers ");
				List<Customers> customersList = query.list();
				Object rowData[] = new Object[4];
				
				for(Customers customer : customersList){

				    rowData[0] = customer.getCustomerId();
				    rowData[1] = customer.getEmailId();
				    rowData[2] = customer.getMobileNumber();
				    rowData[3] = customer.getFirstName();

				    writer.addRecord( rowData);

					rowData = new Object[4];
				}
				
				session.getTransaction().commit();
				
				System.out.println("Done ! ");

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
				if(factory!=null)
					factory.close();
			}
		    

		    FileOutputStream fos = new FileOutputStream("D://DbfFiles/Test.dbf");
		    writer.write( fos);
		    fos.close();

		} catch (MoneyBuddyException e) {	
			logger.debug("EstimateAction class : execute method : Caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
   	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
   	catch (MalformedURLException  e) {	

			e.printStackTrace();
			
		} 
   	catch (IOException  e) {	

			e.printStackTrace();

		} 
	 
   	catch (Exception e) {	

			e.printStackTrace();

		} */

	   	


	public static boolean copyFileUsingFileUtils(String srcFilePath, String destFilePath){
		boolean isFileCopied = false;
		
		try {
			FileUtils.copyFile(new File(srcFilePath), new File(destFilePath),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isFileCopied;
	}
	
	public void copyFileUsingNIO(){
		 String fromFile = "ftp://ftp.arin.net/pub/stats/arin/delegated-arin-extended-latest";
	        String toFile = "F:\\arin.txt";

	        try {

	            URL website = new URL(fromFile);
	            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
	            FileOutputStream fos = new FileOutputStream(toFile);
	            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	            fos.close();
	            rbc.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	

}


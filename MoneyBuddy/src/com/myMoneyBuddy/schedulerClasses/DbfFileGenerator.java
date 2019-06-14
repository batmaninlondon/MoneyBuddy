package com.myMoneyBuddy.schedulerClasses;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFWriter;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class DbfFileGenerator implements org.quartz.Job{



	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

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

        
		    Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		    
		   try
			{
			   hibernateSession.beginTransaction();
				
				
			   Query query =  hibernateSession.createQuery("from DbfDataDetails where dbfDataDate = :dbfDataDate");
				query.setParameter("dbfDataDate", frmtdDate);
				List<DbfFileStatusDetails> dbfDataDetailsList = query.list();
				Object rowData[] = new Object[4];
				hibernateSession.getTransaction().commit();
				
				for(DbfFileStatusDetails dbfDataDetail : dbfDataDetailsList){

				    /*rowData[0] = dbfDataDetail.getTransactionDetailId();
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
				if(hibernateSession !=null )
						hibernateSession.close();
			}


		} 
	 
   	catch (Exception e) {	

			e.printStackTrace();

		} 


	}

}

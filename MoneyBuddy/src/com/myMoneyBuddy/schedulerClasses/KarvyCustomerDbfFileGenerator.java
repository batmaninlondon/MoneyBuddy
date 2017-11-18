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
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFWriter;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfDataDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class KarvyCustomerDbfFileGenerator implements org.quartz.Job{

	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		try {			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String frmtdDate = dateFormat.format(date);
    		
		  	DBFField fields[] = new DBFField[16];
		  
		  	fields[0] = new DBFField();
		    fields[0].setFieldName("field1");
		    fields[0].setDataType( DBFField.FIELD_TYPE_C);
		    fields[0].setFieldLength(20);

		    fields[1] = new DBFField();
		    fields[1].setFieldName("field2");
		    fields[1].setDataType( DBFField.FIELD_TYPE_C);
		    fields[1].setFieldLength(15);

		    fields[2] = new DBFField();
		    fields[2].setFieldName("field3");
		    fields[2].setDataType( DBFField.FIELD_TYPE_C);
		    fields[2].setFieldLength(15);
		    
		    fields[3] = new DBFField();
		    fields[3].setFieldName("field4");
		    fields[3].setDataType( DBFField.FIELD_TYPE_C);
		    fields[3].setFieldLength(3);
		    
		    fields[4] = new DBFField();
		    fields[4].setFieldName("field5");
		    fields[4].setDataType( DBFField.FIELD_TYPE_C);
		    fields[4].setFieldLength(20);

		    fields[5] = new DBFField();
		    fields[5].setFieldName("field6");
		    fields[5].setDataType( DBFField.FIELD_TYPE_C);
		    fields[5].setFieldLength(20);
		    
		    fields[6] = new DBFField();
		    fields[6].setFieldName("field7");
		    fields[6].setDataType( DBFField.FIELD_TYPE_C);
		    fields[6].setFieldLength(15);
		    
		    fields[7] = new DBFField();
		    fields[7].setFieldName("field8");
		    fields[7].setDataType( DBFField.FIELD_TYPE_C);
		    fields[7].setFieldLength(18);
		    
		    fields[8] = new DBFField();
		    fields[8].setFieldName("field9");
		    fields[8].setDataType( DBFField.FIELD_TYPE_C);
		    fields[8].setFieldLength(70);
		    
		    fields[9] = new DBFField();
		    fields[9].setFieldName("field10");
		    fields[9].setDataType( DBFField.FIELD_TYPE_C);
		    fields[9].setFieldLength(1);
		    
		    fields[10] = new DBFField();
		    fields[10].setFieldName("field11");
		    fields[10].setDataType( DBFField.FIELD_TYPE_C);
		    fields[10].setFieldLength(1);
		    
		    fields[11] = new DBFField();
		    fields[11].setFieldName("field12");
		    fields[11].setDataType( DBFField.FIELD_TYPE_C);
		    fields[11].setFieldLength(2);

		    fields[12] = new DBFField();
		    fields[12].setFieldName("field13");
		    fields[12].setDataType( DBFField.FIELD_TYPE_C);
		    fields[12].setFieldLength(30);
		    
		    fields[13] = new DBFField();
		    fields[13].setFieldName("field14");
		    fields[13].setDataType( DBFField.FIELD_TYPE_C);
		    fields[13].setFieldLength(10);
		    
		    fields[14] = new DBFField();
		    fields[14].setFieldName("field15");
		    fields[14].setDataType( DBFField.FIELD_TYPE_C);
		    fields[14].setFieldLength(20);

		    fields[15] = new DBFField();
		    fields[15].setFieldName("field16");
		    fields[15].setDataType( DBFField.FIELD_TYPE_C);
		    fields[15].setFieldLength(1);

		    
		    DBFWriter writer = new DBFWriter();
		    writer.setFields( fields);

		    Properties properties = new Properties();
			String propFilePath = "../../../config/config.properties";

			properties.load(KarvyCustomerDbfFileGenerator.class.getResourceAsStream(propFilePath));
			
			System.out.println("BATCH_IMAGE_NUMBER : "+properties.getProperty("BATCH_IMAGE_NUMBER"));
			
        
			Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
		    
		   try
			{
				
			   session.beginTransaction();
				
			   Query query =  session.createQuery("from Customers where karvyFileGenerated = :karvyFileGenerated");
			   query.setParameter("karvyFileGenerated", "N");
			   List<Customers> customersList = query.list();		
			   //session.getTransaction().commit();
				
				
				Object rowData[] = new Object[16];
				
				int i = 1;
				for(Customers customer : customersList){

				    rowData[0] = properties.getProperty("BATCH_IMAGE_NUMBER");
				    rowData[1] = Integer.toString(i);
				    //rowData[1] = Integer.toString(i);
				    rowData[2] = properties.getProperty("ARN_CODE")+customer.getPanCard();
				    rowData[3] = ""; 

				    rowData[4] = properties.getProperty("BROKER_CODE");
				    rowData[5] = properties.getProperty("ARN_CODE");
				    rowData[6] = "";
				    rowData[7] = customer.getFolioNumber();
				    
				    rowData[8] = customer.getFirstName()+" "+customer.getLastName();
				    rowData[9] = "1";
				    rowData[10] = "N";
				    rowData[11] = "ON";
				    
				    rowData[12] = "AOF";
				    rowData[13] = customer.getPanCard();
				    rowData[14] = customer.getCustomerId();
				    rowData[15] = "Y";

				    writer.addRecord( rowData);

					rowData = new Object[16];
				    i++;
				}
				
				
				
				String srcDirName = properties.getProperty("SRC_DIR_NAME");

			    FileOutputStream fos = new FileOutputStream(srcDirName+"Karvy_Customer"+frmtdDate+".dbf");
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

}

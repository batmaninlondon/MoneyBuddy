package com.myMoneyBuddy.schedulerClasses;

import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.myMoneyBuddy.DAOClasses.Trading;

public class ClientRecordsGenerator implements org.quartz.Job{

	Logger logger = LogManager.getLogger(ClientRecordsGenerator.class);

	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		try {
			
			logger.debug("ClientRecordsGenerator class - execute method - start");
			System.out.println("ClientRecordsGenerator CLASS EXECUTION -------  START");
			
			Trading trading = new Trading();
			
			//URL cl = this.getClass().getResource("../../../../../assets/ClientRecord/ClientRecords.xlsx");
			
			Class clsobj = Class.forName("com.myMoneyBuddy.schedulerClasses.ClientRecordsGenerator");  
			  
	         ClassLoader ClsLoader = clsobj.getClassLoader();  
	  
	         if (ClsLoader == null) {  
	            System.out.println("System class was used.");  
	         } else {  
	            // returns the class loader  
	            Class loaderCls = ClsLoader.getClass();  
	  
	            System.out.println("Associated with ClassLoader = " +loaderCls.getName());  
	         }  
			
			ClassLoader cl = ClientRecordsGenerator.class.getClassLoader();
			
			System.out.println(" value of cl is : "+cl.toString());
			InputStream st = ClientRecordsGenerator.class.getResourceAsStream("/assets/ClientRecord/ClientRecords.xlsx");

			System.out.println(" value of cl is : "+st);
			
			/*String directoryName = cl.getResource("./../../assets/ClientRecord").getPath().substring(1);*/
	       /* String directoryName = cl.getResource("./../../assets/AofForms").getPath().substring(1);
			
			System.out.println("directoryNameeeee : "+directoryName);*/
			
			//String directoryName = cl.getResource("./../../assets/ClientRecord").getPath().substring(1);

			/*System.out.println("directoryName is : "+directoryName);
			
			String fileName = directoryName+"ClientRecords.xlsx";
			
			System.out.println("fileName is : "+fileName);*/
			
			/*InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("assets/ClientRecord/ClientRecords.xlsx");
			
			System.out.println("inputStream : "+inputStream.available());*/
			
			
			
			
			
			trading.clientRecords();
			
			
			System.out.println("ClientRecordsGenerator CLASS EXECUTION -------  END");
			logger.debug("ClientRecordsGenerator class - execute method - end");
		} 
	 
   	catch (Exception e) {	

			e.printStackTrace();

		} 


	}

}

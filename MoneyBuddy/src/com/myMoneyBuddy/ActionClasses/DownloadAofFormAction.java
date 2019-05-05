/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.GenerateKycForm;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.DAOClasses.UpdateCustomer;
import com.myMoneyBuddy.Utils.CommonUtil;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class DownloadAofFormAction extends ActionSupport implements SessionAware  {

	Logger logger = Logger.getLogger(DownloadAofFormAction.class);
	private SessionMap<String,Object> sessionMap;

	private InputStream stream;
	
	private String aofForm;
	
    public String execute() {
    	
    	String customerId = null;
    	
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("DownloadAofFormAction class - execute method - customerId - "+customerId+" - start ");
    		
    		System.out.println("DownloadAofFormAction class : execute method : start");
    		    		
    		QueryCustomer queryCustomer = new QueryCustomer();
    		
    		String emailId = queryCustomer.getCustomerEmailId(customerId);
    		
    		Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(GenerateKycForm.class.getResourceAsStream(configPropFilePath));
			
           String mailLink = configProperties.getProperty("MAIL_AOF_FORM_LINK");
			System.out.println("mailLink is : "+mailLink);
	    	
	    	String subject = configProperties.getProperty("MAIL_AOF_FORM_SUBJECT");
	    	
	    	/*Path path = Paths.get(DownloadAofFormAction.class.getResource("/").toURI()).getParent().getParent().getParent();
	    	
	    	String pathName = path + "/MoneyBuddy/resources/AofForms/";
	    	
	    	System.out.println("PATH NAME IS : "+pathName);*/
	    	
	    	ClassLoader cl = getClass().getClassLoader();
			
			String directoryName = cl.getResource("./../../assets/AofForms").getPath().substring(1);
			
			System.out.println("directoryName : "+directoryName);
			System.out.println("directoryName : "+cl.getResource("./../../assets/AofForms").getPath().toString());
			
			//String directoryName = "../../../resources/AofForms/";
			
			/*URL url = this.getClass().getResource("/Account_Opening_Form_1.pdf");
			String absoluteDiskPath = url.getPath();*/
			
			//System.out.println("absoluteDiskPath : "+absoluteDiskPath);
			
			/*ServletContext context = getContext();
			String fullPath = context.getRealPath("/WEB-INF/Account_Opening_Form_1.pdf");*/
			//InputStream resourceContent = context.getResourceAsStream("/WEB-INF/Account_Opening_Form_1.pdf");
			
			
			/*ClassLoader classLoader = ClassLoader.getSystemClassLoader();
	    	 
	    	File file = new File(classLoader.getResource("AofForms/Account_Opening_Form_1.pdf").getFile());
		    	
			 System.out.println("pdfFile : "+file.getPath().toString());
			 
			 String path = new File(classLoader.getResource("Account_Opening_Form_1.pdf").getPath()).toString();
			 
			 System.out.println(" Path is : "+path);*/
	         
			
	    	//String directoryName = configProperties.getProperty("KYC_PDF_DIRECTORY");
			
			
	    	
	    	setAofForm(queryCustomer.getAoFFormName(customerId)+".pdf");
	    	System.out.println(" Aof Form name is : "+getAofForm());
			//setAofForm("Account_Opening_Form_1.pdf");
       		SendMail sendMail = new SendMail();
       		sendMail.sendAofFormMail(directoryName+getAofForm(), emailId,subject,"AccountOpeningForm.txt",mailLink,"");
       		
       		UpdateCustomer updateCustomer = new UpdateCustomer();
       		updateCustomer.updateAofFormStatus(customerId, "FORM_SENT");
       		
       		logger.debug("DownloadAofFormAction class - execute method - mail sent with kyc form for customerId - "+customerId);
       	
           logger.debug("DownloadAofFormAction class - execute method - customerId - "+customerId+" - end ");
			
			return SUCCESS;
		} 
    	catch (Exception e) {	
    		logger.debug("DownloadAofFormAction class - execute method - Caught Exception for customerId - "+customerId);
			e.printStackTrace();

			return ERROR;
		} 

    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

	public String getAofForm() {
		return aofForm;
	}

	public void setAofForm(String aofForm) {
		this.aofForm = aofForm;
	}


}

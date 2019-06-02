/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.GenerateKycForm;
import com.myMoneyBuddy.DAOClasses.InsertCustomerDetails;
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
    		
    		String customerName = queryCustomer.getCustomerNameFromId(customerId);
    		
    		Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(GenerateKycForm.class.getResourceAsStream(configPropFilePath));
			
           String mailLink = configProperties.getProperty("MAIL_AOF_FORM_LINK");
			System.out.println("mailLink is : "+mailLink);
	    	
	    	String subject = configProperties.getProperty("MAIL_AOF_FORM_SUBJECT");
	    	
	    	
	    	ClassLoader cl = getClass().getClassLoader();
			
			String directoryName = cl.getResource("./../../assets/AofForms").getPath().substring(1);
			
			System.out.println("directoryNameeeee : "+directoryName);
			
			logger.debug("DownloadAofFormAction class - execute method - directoryName - "+directoryName);
				    	
	    	setAofForm(queryCustomer.getAoFFormName(customerId)+".pdf");
	    	System.out.println(" Aof Form name is : "+getAofForm());
	    	
	    	
			//setAofForm("Account_Opening_Form_1.pdf");
       		SendMail sendMail = new SendMail();
       		if ("Account_Opening_Form_1".equals(getAofForm()) || "Account_Opening_Form_3".equals(getAofForm())) {
       			sendMail.sendAofFormMail("/"+directoryName+getAofForm(), emailId,subject,"AccountOpeningFormKycDone.txt",mailLink,"",customerName);
       		}
       		else {
       			sendMail.sendAofFormMail("/"+directoryName+getAofForm(), emailId,subject,"AccountOpeningFormKycNotDone.txt",mailLink,"",customerName);
       		}
       		
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

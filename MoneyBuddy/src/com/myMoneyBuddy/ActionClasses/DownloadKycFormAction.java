/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myMoneyBuddy.DAOClasses.GenerateKycForm;
import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadKycFormAction extends ActionSupport implements SessionAware  {

	Logger logger = LogManager.getLogger(DownloadKycFormAction.class);
	private SessionMap<String,Object> sessionMap;

	private InputStream stream;
	
	private String kycForm;
	
    public String execute() {
    	
    	String customerId = null;
    	
    	try {
    		
    		customerId = sessionMap.get("customerId").toString();
    		
    		logger.debug("DownloadKycFormAction class - execute method - customerId - "+customerId+" - start ");
    		
    		System.out.println("DownloadKycFormAction class : execute method : start");
    		    		
    		QueryCustomer queryCustomer = new QueryCustomer();
    		
    		String emailId = queryCustomer.getCustomerEmailId(customerId);
    		
    		Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(GenerateKycForm.class.getResourceAsStream(configPropFilePath));
			
           String mailLink = configProperties.getProperty("MAIL_KYC_FORM_LINK");
			System.out.println("mailLink is : "+mailLink);
	    	
	    	String subject = configProperties.getProperty("MAIL_KYC_FORM_SUBJECT");
	    	
	    	ClassLoader cl = getClass().getClassLoader();
			
			String directoryName = cl.getResource("./../../assets/KycForms").getPath().substring(1);
			
	    	//String directoryName = configProperties.getProperty("KYC_PDF_DIRECTORY");
	    	
	    	setKycForm("KYC_Application_Form_"+customerId+".pdf");
	    	
       		SendMail sendMail = new SendMail();
       		sendMail.sendKycFormMail(directoryName+"/"+getKycForm(), emailId,subject,"KycNotDone.txt",mailLink,"");
       		
       		logger.debug("DownloadKycFormAction class - execute method - mail sent with kyc form for customerId - "+customerId);
       	
           logger.debug("DownloadKycFormAction class - execute method - customerId - "+customerId+" - end ");
			
			return SUCCESS;
		} 
    	catch (Exception e) {	
    		logger.debug("DownloadKycFormAction class - execute method - Caught Exception for customerId - "+customerId);
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

	public String getKycForm() {
		return kycForm;
	}

	public void setKycForm(String kycForm) {
		this.kycForm = kycForm;
	}

}

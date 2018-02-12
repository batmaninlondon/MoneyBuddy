/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.DAOClasses.QueryCustomerPortfolio;
import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.GAT.PredictedValueCalculation;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.mailerClasses.SendMail;
import com.opensymphony.xwork2.ActionSupport;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class PopulateBankDetailsAction extends ActionSupport implements SessionAware  {

	
	
	Logger logger = Logger.getLogger(PopulateBankDetailsAction.class);
	private Map<String, Object> sessionMap;

	private InputStream stream;
	
	
	private String bankName;
	private String accountType;
	private String accountNumber;
	private String reAccountNumber;
	private String ifscCode;
	
	
    public String execute() {

    	logger.debug("PopulateBankDetailsAction class : execute method : start");
    	Session hibernateSession = null;
    	
    	System.out.println("bankName : "+getBankName());
    	System.out.println("accountType : "+getAccountType());
    	System.out.println("accountNumber : "+getAccountNumber());
    	System.out.println("reAccountNumber : "+getReAccountNumber());
    	System.out.println("ifscCode : "+getIfscCode());
    	try {
 
    		QueryCustomerPortfolio customerPortfolio = new QueryCustomerPortfolio();
    		
    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDateForDB = dateFormat.format(date);
			
			String customerId = sessionMap.get("customerId").toString();
			
			hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

			hibernateSession.beginTransaction();
				
				BankDetails tempBankDetails = new BankDetails(customerId, getBankName(),getAccountType(),
						getAccountNumber(),getIfscCode(),frmtdDateForDB);

				hibernateSession.save(tempBankDetails);

				logger.debug("PopulateBankDetailsAction class : execute method : stored BankDetails in session id : "+sessionMap.getClass().getName());
				hibernateSession.getTransaction().commit();
				
				QueryCustomer customer = new QueryCustomer();
				String emailId = sessionMap.get("emailId").toString();
				
				SendMail sendmail = new SendMail();
				StringBuilder bodyText = new StringBuilder();
				String MAIL_SITE_LINK = "www.quantwealth.in/login";
				
				String subject = "Payment recieved for your recent transaction";
	        	bodyText.append("<div>")
	        	.append(" <br/><br/> <h1>Dear User</h1><br/><br/>")
	        	.append("  <p>Payment for your recent transaction has been received</p><br/><br/><br/>")
	        	.append(" <h3> Please click <a href=\""+MAIL_SITE_LINK+"\">here</a> to login and check the staus of all your transactions.</h3><br/><br/>")
	        	.append("  <h3>Thanks,</h3><br/><br/>")
	        	.append("  <h3>MoneyBuddy Team</h3>")
	        	.append("</div>");
	        	sendmail.MailSending(emailId, bodyText,subject);
	        	
 
		    	
		    	logger.debug("ForgotPasswordAction class : execute method : mail sent to "+emailId+" to reset password for session id : "+sessionMap.getClass().getName());
		    	
				
			logger.debug("PopulateBankDetailsAction class : execute method : end");
			
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.debug("PopulateBankDetailsAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
    	finally {
    		hibernateSession.close();
    	}

    }
    
    public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getReAccountNumber() {
		return reAccountNumber;
	}


	public void setReAccountNumber(String reAccountNumber) {
		this.reAccountNumber = reAccountNumber;
	}


	public String getIfscCode() {
		return ifscCode;
	}


	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}


	@Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    

    public Map<String, Object> getSession() {
		return sessionMap;
	}


	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}




}

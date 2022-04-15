/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;

public class PopulateBankDetailsAction extends ActionSupport implements SessionAware  {
	
	Logger logger = LogManager.getLogger(PopulateBankDetailsAction.class);
	private SessionMap<String,Object> sessionMap;
	private InputStream stream;
	private String bankName;
	private String accountType;
	private String accountNumber;
	private String reAccountNumber;
	private String ifscCode;
	
	
    public String execute() {

    	logger.debug("PopulateBankDetailsAction class : execute method : start");
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	
    	System.out.println("bankName : "+getBankName());
    	System.out.println("accountType : "+getAccountType());
    	System.out.println("accountNumber : "+getAccountNumber());
    	System.out.println("reAccountNumber : "+getReAccountNumber());
    	System.out.println("ifscCode : "+getIfscCode());
    	try {
     		
    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDateForDB = dateFormat.format(date);
			
			String customerId = sessionMap.get("customerId").toString();

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
        	
        	//sendmail.MailSending(emailId, bodyText,subject);
 
		    	
		    	logger.debug("ForgotPasswordAction class : execute method : mail sent to "+emailId+" to reset password for session id : "+sessionMap.getClass().getName());
	    	
				
			logger.debug("PopulateBankDetailsAction class : execute method : end");
			
			String str = "success";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return SUCCESS;
		} 
    	catch (Exception e) {	
			logger.error("PopulateBankDetailsAction class : execute method : Caught Exception for session id : "+sessionMap.getClass().getName());
			e.printStackTrace();
			
			String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
			return ERROR;
		} 
    	finally {
			if(hibernateSession !=null )
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
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}




}

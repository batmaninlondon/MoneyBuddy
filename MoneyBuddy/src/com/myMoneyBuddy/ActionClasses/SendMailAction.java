/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myMoneyBuddy.DAOClasses.QueryKycStatus;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
import com.myMoneyBuddy.EntityClasses.Subscriber;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.mailerClasses.SendMail;
import com.myMoneyBuddy.webServices.WebServiceMFOrder;
import com.myMoneyBuddy.webServices.WebServiceStarMF;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.tempuri.IStarMFWebService;
import org.tempuri.MFOrderEntry;

/**
 *
 * @author Savita Wadhwani
 */
public class SendMailAction extends ActionSupport  implements SessionAware{

	Logger logger = Logger.getLogger(SendMailAction.class);
	private Map<String, Object> sessionMap;
	
	private String senderName;
	private String senderEmailId;
	private String senderMobileNum;
	private String senderMessage;

    private InputStream stream;

    public String execute() {

    	
    	try {
    		
    	logger.debug("SendMailAction class : execute method : start");
    	System.out.println(" SendMailAction execute method Called !!");
    	
    	System.out.println(" SendMailAction execute method : Name : "+getSenderName());
    	System.out.println(" SendMailAction execute method : emailId : "+getSenderEmailId());
    	System.out.println(" SendMailAction execute method : mobileNumber : "+getSenderMobileNum());
    	System.out.println(" SendMailAction execute method : message : "+getSenderMessage());

		
		SendMail sendMail = new SendMail();
		String subject="[MoneyBuddy] ThankYou for your message";

    	StringBuilder bodyText = new StringBuilder();

    	bodyText.append("<div>")
			    	.append("  Dear "+getSenderName()+"<br/><br/>")
			    	.append("  We will get back to you  <br/>")
			    	.append("  <br/><br/>")
			    	.append("  Thanks,<br/>")
			    	.append("  MoneyBuddy Team")
			    	.append("</div>");
	    	
	    	
    	sendMail.MailSending(getSenderEmailId(),bodyText,subject);
    	System.out.println(" SendMailAction execute method : mail sent to the user ");
		
    	subject="[MoneyBuddy] message from "+getSenderName()+" email id : "+getSenderEmailId();
    	
    	bodyText.append("<div>")
    	.append("   <br/><br/>")
    	.append("  "+getSenderMessage()+"<br/>")
	 	.append("</div>");
    	
    	sendMail.MailSending("mf.moneybuddy@gmail.com",bodyText,subject);
    	System.out.println(" SendMailAction execute method : mail sent to moneyBuddy team");
    	
    	logger.debug("SendMailAction execute method : end");
    	
    	System.out.println(" Returned Success !!");

    	String str = "success";
    	stream = new ByteArrayInputStream(str.getBytes());

    	return SUCCESS;
    	} 
    	/*catch ( MoneyBuddyException e )  {
    		logger.error("KycCheckAction class : execute method : caught MoneyBuddyException for session id : "+sessionMap.getClass().getName());
    		e.printStackTrace();
    		String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return ERROR;
    	}*/
    	catch ( Exception e )  {
    		logger.error("SendMailAction class : execute method : caught Exception for session id : "+sessionMap.getClass().getName());
    		e.printStackTrace();
    		String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return ERROR;
    	}
    	
    }
    
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    

    public Map<String, Object> getSession() {
		return sessionMap;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderEmailId() {
		return senderEmailId;
	}

	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}

	public String getSenderMobileNum() {
		return senderMobileNum;
	}

	public void setSenderMobileNum(String senderMobileNum) {
		this.senderMobileNum = senderMobileNum;
	}

	public String getSenderMessage() {
		return senderMessage;
	}

	public void setSenderMessage(String senderMessage) {
		this.senderMessage = senderMessage;
	}




}
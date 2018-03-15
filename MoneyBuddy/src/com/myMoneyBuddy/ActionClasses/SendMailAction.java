/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.ActionClasses;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import com.myMoneyBuddy.Utils.MbUtil;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

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
	private String googleResponse;

    private InputStream stream;

    public String execute() {

    	
    	try {
    		
    	logger.debug("SendMailAction class : execute method : start");
    	System.out.println(" SendMailAction execute method Called !!");
    	
    	MbUtil mbUtil = new MbUtil();
    	if(!mbUtil.isCaptchaValid(getGoogleResponse()))
    	{
    		String str = "Lookslikeyouarearobot";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    return ERROR;
    	}

    	SendMail sendMail = new SendMail();

    	Properties configProperties = new Properties();
		String configPropFilePath = "../../../config/config.properties";

		configProperties.load(RegisterAction.class.getResourceAsStream(configPropFilePath));
		
		String mailLink = configProperties.getProperty("MAIL_CONTACT_US_LINK");
		System.out.println("mailLink is : "+mailLink);
    	
    	String subject = configProperties.getProperty("MAIL_CONTACT_US_SUBJECT");

    	sendMail.MailSending(getSenderEmailId(),subject,"ContactUsMail","ContactUsMail.txt",mailLink,"");
    	
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

	public String getGoogleResponse() {
		return googleResponse;
	}

	public void setGoogleResponse(String googleResponse) {
		this.googleResponse = googleResponse;
	}

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}


}

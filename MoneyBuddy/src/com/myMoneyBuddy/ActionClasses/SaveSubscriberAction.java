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
import java.util.Properties;

import com.myMoneyBuddy.DAOClasses.QueryKycStatus;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfFileStatusDetails;
import com.myMoneyBuddy.EntityClasses.Subscriber;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.Utils.MbUtil;
import com.myMoneyBuddy.Utils.SendMail;
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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONObject;

/**
 *
 * @author Savita Wadhwani
 */
public class SaveSubscriberAction extends ActionSupport  implements SessionAware{
	

	Logger logger = Logger.getLogger(SaveSubscriberAction.class);
	private Map<String, Object> sessionMap;
	
	private String emailId;
	private String googleResponse;
	//private String mobileNumber;
   
    QueryKycStatus kyc = new QueryKycStatus();

    private InputStream stream;

    public String execute() {

    	
    	Session hibernateSession = null;
    	
    	try {
    		
    	logger.debug("SaveSubscriberAction class : execute method : start");
    	System.out.println(" SaveSubscriberAction execute method Called !!");
    	
    	MbUtil mbUtil = new MbUtil();
    	if(!mbUtil.isCaptchaValid(getGoogleResponse()))
    	{
    		String str = "Lookslikeyouarearobot";
    	    stream = new ByteArrayInputStream(str.getBytes());
    	    return ERROR;
    	}
    	
    	System.out.println(" SaveSubscriberAction execute method : First Name : "+getEmailId());
    	//System.out.println(" SaveSubscriberAction execute method : Last Name : "+getMobileNumber());
    	
    	hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession(); 
	    
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String frmtdDate = dateFormat.format(date);
		
		hibernateSession.beginTransaction();
		Object result = hibernateSession.createQuery("select count(*) from Subscriber where emailId = '"+getEmailId()+"' ").uniqueResult();
		
		hibernateSession.getTransaction().commit();
    	
    	System.out.println(" result : "+result.toString());
    	
		if ( "0".equals(result.toString()) )  {
			Subscriber tempSubscriber = new Subscriber(getEmailId(),"SUBSCRIBER",frmtdDate);
			hibernateSession.beginTransaction();
			hibernateSession.save(tempSubscriber);
			hibernateSession.getTransaction().commit();
			
			SendMail sendMail = new SendMail();

	    	Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(RegisterAction.class.getResourceAsStream(configPropFilePath));
			
			String mailLink = configProperties.getProperty("MAIL_SUBSCRIPTION_LINK");
			System.out.println("mailLink is : "+mailLink);
	    	
	    	String subject = configProperties.getProperty("MAIL_SUBSCRIPTION_SUBJECT");

	    	sendMail.MailSending(getEmailId(),subject,"SubscriptionMail","SubscriptionMail.txt",null,"");
			
			System.out.println("str set to subscribedSuccessfully ");
			String str = "subscribedSuccessfully";
	    	stream = new ByteArrayInputStream(str.getBytes());
			
		}
		else {
	    	
	    	System.out.println("str set to alreadySubscribed ");
	    	String str = "alreadySubscribed";
	    	stream = new ByteArrayInputStream(str.getBytes());
		}

    	
    	System.out.println(" send email function completed from subscriber.");
		
    	logger.debug("KycCheckAction class : execute method : end");
    	
    	System.out.println(" Returned Success !!");

    	/*String str = "success";
    	stream = new ByteArrayInputStream(str.getBytes());*/

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
    		logger.error("KycCheckAction class : execute method : caught Exception for session id : "+sessionMap.getClass().getName());
    		e.printStackTrace();
    		String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());
    		return ERROR;
    	}
    	finally {
    		hibernateSession.close();
    	}
    	
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

	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGoogleResponse() {
		return googleResponse;
	}

	public void setGoogleResponse(String googleResponse) {
		this.googleResponse = googleResponse;
	}

/*	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
    

*/
	

}

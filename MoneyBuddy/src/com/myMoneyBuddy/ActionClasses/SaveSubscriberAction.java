/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.ActionClasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.Subscriber;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.Utils.MbUtil;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;

public class SaveSubscriberAction extends ActionSupport {
	
	Logger logger = LogManager.getLogger(SaveSubscriberAction.class);	
	private String emailId;
	private String googleResponse;
   // private InputStream stream;

    public String execute() {
 	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	
    	try {
    		
    		logger.debug("SaveSubscriberAction class - execute method - start ");
	    	System.out.println(" SaveSubscriberAction execute method Called !!");
	    	
	    	MbUtil mbUtil = new MbUtil();
	    	if(!mbUtil.isCaptchaValid(getGoogleResponse()))
	    	{
	    		/*String str = "Lookslikeyouarearobot";
	    	    stream = new ByteArrayInputStream(str.getBytes());*/
	    	    logger.debug("SaveSubscriberAction class - execute method - returned Lookslikeyouarearobot");
	    	    logger.debug("SaveSubscriberAction class - execute method - end ");
	    	    addActionMessage("Looks like you are a robot.");
	    	    
	    	    return SUCCESS;
	    	}
	    	
	    	System.out.println(" SaveSubscriberAction execute method : First Name : "+getEmailId()); 
		    
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
	
				configProperties.load(SaveSubscriberAction.class.getResourceAsStream(configPropFilePath));
				
				String mailLink = configProperties.getProperty("MAIL_SUBSCRIPTION_LINK");
				System.out.println("mailLink is : "+mailLink);
		    	
		    	String subject = configProperties.getProperty("MAIL_SUBSCRIPTION_SUBJECT");
	
		    	sendMail.MailSending(getEmailId(),subject,"SubscriptionMail","SubscriptionMail.txt",mailLink,"Wealth creation with MoneyBuddy","","");
				
				System.out.println("str set to subscribedSuccessfully ");
				//String str = "subscribedSuccessfully";
				addActionMessage("Thank You for subscribing with MoneyBuddy.");
				logger.debug("SaveSubscriberAction class - execute method - emailId - "+getEmailId()+" is subscribed with MoneyBuddy");
		    	logger.debug("SaveSubscriberAction class - execute method - returned subscribedSuccessfully");
		    	//stream = new ByteArrayInputStream(str.getBytes());
				
			}
			else {
		    	
		    	System.out.println("str set to alreadySubscribed ");
		    	
		    	/*String str = "alreadySubscribed";
		    	stream = new ByteArrayInputStream(str.getBytes());*/
		    	
		    	addActionMessage("You have already subscribed with MoneyBuddy.");
		    	logger.debug("SaveSubscriberAction class - execute method - emailId - "+getEmailId()+" is already subscribed with MoneyBuddy");
		    	logger.debug("SaveSubscriberAction class - execute method - returned alreadySubscribed");
			}

	    	System.out.println(" send email function completed from subscriber.");
			
	    	logger.debug("SaveSubscriberAction class - execute method - end ");
	
	    	return SUCCESS;
    	} 
    	catch ( Exception e )  {
    		logger.error("SaveSubscriberAction class - execute method - Caught Exception");
			e.printStackTrace();
			
			/*String str = "error";
    	    stream = new ByteArrayInputStream(str.getBytes());*/
    	    logger.error("SaveSubscriberAction class - execute method - returned error");
			return ERROR;
    	}
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
    	
    }
/*
	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}*/

	
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

}

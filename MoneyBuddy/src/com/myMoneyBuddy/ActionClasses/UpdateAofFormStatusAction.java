/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAofFormStatusAction extends ActionSupport {
	
	Logger logger = LogManager.getLogger(UpdateAofFormStatusAction.class);	
    
    private String customerId;
   
    public String execute() {
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
    	try {
    		
    		logger.debug("UpdateAofFormStatusAction class - execute method - customerId - "+customerId+" - start ");

    		System.out.println("UpdateAofFormStatusAction class : execute method : called ");
    		
    		System.out.println("customerId : "+customerId);
    		
    		hibernateSession.beginTransaction();
    		
    		Query query;

    		query = hibernateSession.createQuery("update Customers set aofFormStatus = :aofFormStatus "
    				+ "where customerId = :customerId");

			query.setParameter("aofFormStatus", "ACTIVATED");
			query.setParameter("customerId", getCustomerId());
			
			int updateResult = query.executeUpdate();
			System.out.println(updateResult + " rows updated in Customers table for customerId : "+getCustomerId());

    		hibernateSession.getTransaction().commit();
    		
    		if ( updateResult == 0)  {
				/*setErrorMsg("EmailId does not exists!! ");*/
				addActionMessage("Customer Id "+getCustomerId()+" does not exists !");
			}
    		else   {
    			addActionMessage("Successfully updated Aof Form status for Customer Id : "+getCustomerId());
    			
    			QueryCustomer queryCustomer = new QueryCustomer();
        		String emailId = queryCustomer.getCustomerEmailId(customerId);
        		String cutomerName = queryCustomer.getCustomerName(emailId);
        		
    			SendMail sendMail = new SendMail();
    			
    	    	Properties configProperties = new Properties();
    			String configPropFilePath = "../../../config/config.properties";
    	
    			configProperties.load(RegisterAction.class.getResourceAsStream(configPropFilePath));
    			
    			String mailLink = configProperties.getProperty("MAIL_ACCOUNT_ACTIVATED_LINK");
    			System.out.println("mailLink is : "+mailLink);
    			    	    	
    	    	String subject = configProperties.getProperty("MAIL_ACCOUNT_ACTIVATED_SUBJECT");
    	
    	    	sendMail.MailSending(emailId,subject,"Account Activation Email","AccountActivated.txt",mailLink,"Invest Now",cutomerName,"");
    	
    	    	System.out.println(" send email function completed from account activation for customerId : "+customerId);
    	    	
    	    	logger.debug("UpdateAofFormStatusAction class - execute method - mail sent to "+emailId+" to communicate account activation  ");
	    	}
    		
		    logger.debug("UpdateAofFormStatusAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("UpdateAofFormStatusAction class - execute method - customerId - "+customerId+" - end");
	    	
	    	return SUCCESS;
	    	
    	}
    	catch (Exception e) {	
    		logger.error("UpdateAofFormStatusAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("UpdateAofFormStatusAction class - execute method - customerId - "+customerId+" - returned error");
    	    
    		return ERROR;
		}
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
    }

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}

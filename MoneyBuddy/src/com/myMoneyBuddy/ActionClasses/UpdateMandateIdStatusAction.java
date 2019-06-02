/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.DAOClasses.QueryCustomer;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.FolioDetails;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.Utils.SendMail;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateMandateIdStatusAction extends ActionSupport {
	
	Logger logger = Logger.getLogger(UpdateMandateIdStatusAction.class);	
    
    private String customerId;
    private String mandateAmount;
   
    public String execute() {
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
    	try {
    		
    		logger.debug("UpdateMandateIdStatusAction class - execute method - customerId - "+customerId+" - start ");

    		System.out.println("UpdateMandateIdStatusAction class : execute method : called ");
    		
    		System.out.println("customerId : "+customerId);
    		   		
    		hibernateSession.beginTransaction();
    		
    		Query query;

    		query = hibernateSession.createQuery("update Customers set mandateIdStatus = :mandateIdStatus , mandateAmount = :mandateAmount "
    				+ "where customerId = :customerId");

			query.setParameter("mandateIdStatus", "ACTIVATED");
			query.setParameter("mandateAmount", getMandateAmount());
			query.setParameter("customerId", getCustomerId());
			
			int updateResult = query.executeUpdate();
			System.out.println(updateResult + " rows updated in Customers table for customerId : "+getCustomerId());

    		hibernateSession.getTransaction().commit();
    		
    		if ( updateResult == 0)  {
				/*setErrorMsg("EmailId does not exists!! ");*/
				addActionMessage("Customer Id "+getCustomerId()+" does not exists !");
			}
    		else 
    			addActionMessage("Successfully updated Mandate Id status for Customer Id : "+getCustomerId());
    		
		    logger.debug("UpdateMandateIdStatusAction class - execute method - customerId - "+customerId+" - returned success");
	    	logger.debug("UpdateMandateIdStatusAction class - execute method - customerId - "+customerId+" - end");
	    	
	    	return SUCCESS;
	    	
    	}
    	catch (Exception e) {	
    		logger.error("UpdateMandateIdStatusAction class - execute method - customerId - "+customerId+" - Caught Exception");
    		e.printStackTrace();
    	    logger.error("UpdateMandateIdStatusAction class - execute method - customerId - "+customerId+" - returned error");
    	    
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

	public String getMandateAmount() {
		return mandateAmount;
	}

	public void setMandateAmount(String mandateAmount) {
		this.mandateAmount = mandateAmount;
	}

}

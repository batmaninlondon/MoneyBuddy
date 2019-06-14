/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.ActionClasses;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.Utils.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAofFormStatusAction extends ActionSupport {
	
	Logger logger = Logger.getLogger(UpdateAofFormStatusAction.class);	
    
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
    		else 
    			addActionMessage("Successfully updated Aof Form status for Customer Id : "+getCustomerId());
    		
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

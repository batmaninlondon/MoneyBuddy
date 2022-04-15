/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.AdditionalCustomerDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class InsertAdditionalCustomerDetails {

	Logger logger = LogManager.getLogger(InsertAdditionalCustomerDetails.class);
	
    public void insertAddCusDetails (String customerId, String fatherName, String maritalStatus, String nationality,
			String status, String grossAnnualIncome, String politicallyExposed) throws MoneyBuddyException
    {


    	logger.debug("InsertAdditionalCustomerDetails class - insertAddCusDetails method - customerId - "+customerId+" - start");
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

    	try {
			
			hibernateSession.beginTransaction();
			
			AdditionalCustomerDetails tempAdditionalCustomer = new AdditionalCustomerDetails(customerId, fatherName, maritalStatus,
						nationality, status, grossAnnualIncome,politicallyExposed);

		    hibernateSession.saveOrUpdate(tempAdditionalCustomer);
		    hibernateSession.getTransaction().commit();
		    
    		logger.debug("InsertAdditionalCustomerDetails class - insertAddCusDetails method - customerId - "+customerId+" - new record inserted in AdditionalCustomerDetails table");
    		
    		logger.debug("InsertAdditionalCustomerDetails class - insertAddCusDetails method - customerId - "+customerId+" - end");
    	}
    	catch ( HibernateException e ) {
			logger.error("InsertAdditionalCustomerDetails class - insertAddCusDetails method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("InsertAdditionalCustomerDetails class - insertAddCusDetails method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

    }
 
}


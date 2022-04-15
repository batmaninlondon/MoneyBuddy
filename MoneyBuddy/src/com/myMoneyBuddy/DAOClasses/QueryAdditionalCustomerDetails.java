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

public class QueryAdditionalCustomerDetails {

	Logger logger = LogManager.getLogger(QueryAdditionalCustomerDetails.class);
		
	public AdditionalCustomerDetails getAddCusDetails(String customerId) throws MoneyBuddyException {
			
		logger.debug("QueryAdditionalCustomerDetails class - getAddCusDetails method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	
		AdditionalCustomerDetails addCusDetails = new AdditionalCustomerDetails();
	
		try
		{
			
			System.out.println("customerId is : "+customerId);
			hibernateSession.beginTransaction();
			addCusDetails = (AdditionalCustomerDetails) hibernateSession.get(AdditionalCustomerDetails.class, customerId);
			hibernateSession.getTransaction().commit();

			logger.debug("QueryAdditionalCustomerDetails class - getAddCusDetails method - customerId - "+customerId+" - return AdditionalCustomerDetails record");
			
			logger.debug("QueryAdditionalCustomerDetails class - getAddCusDetails method - customerId - "+customerId+" - end");
			return addCusDetails;
		}
		catch ( HibernateException e ) {
			logger.error("QueryAdditionalCustomerDetails class - getAddCusDetails method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryAdditionalCustomerDetails class - getAddCusDetails method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}



}

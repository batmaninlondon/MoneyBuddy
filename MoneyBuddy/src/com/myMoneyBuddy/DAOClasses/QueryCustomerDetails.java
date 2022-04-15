/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.CustomerDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class QueryCustomerDetails {

	Logger logger = LogManager.getLogger(QueryCustomerDetails.class);
		
	public CustomerDetails getCustomerDetails(String customerId) throws MoneyBuddyException {
			
		logger.debug("QueryCustomerDetails class - getCustomerDetails method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			hibernateSession.beginTransaction();
			CustomerDetails customerDetail = (CustomerDetails) hibernateSession.get(CustomerDetails.class, customerId);
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomerDetails class - getCustomerDetails method - customerId - "+customerId+" - return customerDetail record");
			logger.debug("QueryCustomerDetails class - getCustomerDetails method - customerId - "+customerId+" - end");
			
			return customerDetail;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomerDetails class - getCustomerDetails method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomerDetails class - getCustomerDetails method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}


}

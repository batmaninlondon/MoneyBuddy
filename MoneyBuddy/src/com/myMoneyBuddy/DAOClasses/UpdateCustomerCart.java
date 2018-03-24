/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class UpdateCustomerCart {
	
	Logger logger = Logger.getLogger(UpdateCustomerCart.class);

	public void deleteCustomerCartEntry (String customerId, String cartId) throws MoneyBuddyException {

		logger.debug("UpdateCustomerCart class - deleteCustomerCartEntry method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in deleteCustomerCartEntry : "+customerId);
		System.out.println("cartId : in deleteCustomerCartEntry : "+cartId);

		try {

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("delete from CustomerCart where cartId = :cartId and customerId = :customerId ");

			query.setParameter("cartId", cartId);
			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomerCart class - deleteCustomerCartEntry method - customerId - "+customerId+" - deleted a row from CustomerCart table for cartId : "+cartId);

			logger.debug("UpdateCustomerCart class - deleteCustomerCartEntry method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.debug("UpdateCustomerCart class - deleteCustomerCartEntry method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("UpdateCustomerCart class - deleteCustomerCartEntry method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

}


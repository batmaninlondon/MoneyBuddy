/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerPasswordsHistory;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.mailerClasses.DesEncrypter;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class UpdateCustomerCart {
	
	Logger logger = Logger.getLogger(UpdateCustomerCart.class);

	public void deleteCustomerCartEntry (String customerId, String cartId) throws MoneyBuddyException {

		logger.debug("UpdateCustomerCart class : deleteCustomerCartEntry method : start");
		
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

			logger.debug("UpdateCustomerCart class : deleteCustomerCartEntry method : deleted a row from CustomerCart table for customerId : "+customerId+" and cartId : "+cartId);

			logger.debug("UpdateCustomerCart class : deleteCustomerCartEntry method : end");

		}
		catch ( HibernateException e ) {
			logger.debug("UpdateCustomerCart class : deleteCustomerCartEntry method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("UpdateCustomerCart class : deleteCustomerCartEntry method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();

		}

	}

}


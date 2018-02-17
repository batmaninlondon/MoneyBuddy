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


public class UpdateCustomerPassword {
	
	Logger logger = Logger.getLogger(UpdateCustomerPassword.class);

	public void updatePassword (String customerId, String emailId, String newPassword) throws MoneyBuddyException {

		logger.debug("UpdateCustomerPassword class : UpdatePassword method : start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			DesEncrypter desEncrypter = new DesEncrypter(emailId);
			newPassword = desEncrypter.encrypt(newPassword);
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("update CustomerPasswordsHistory set password = :newPassword" + " where customerId = :customerId");

			query.setParameter("newPassword", newPassword);

			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomerPassword class : UpdatePassword method : updated data of CustomerPasswordsHistory table to set password for customerId : "+customerId);
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("update Customers set password = :newPassword" + " where customerId = :customerId");

			query.setParameter("newPassword", newPassword);

			query.setParameter("customerId", customerId);

			result = query.executeUpdate();
			hibernateSession.getTransaction().commit();
			

			System.out.println("newPassword : "+newPassword);
			
			logger.debug("UpdateCustomerPassword class : UpdatePassword method : updated data of Customers table to set password for customerId : "+customerId);
			logger.debug("UpdateCustomerPassword class : UpdatePassword method : end");

		}
		catch ( HibernateException e ) {
			logger.debug("UpdateCustomerPassword class : UpdatePassword method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("UpdateCustomerPassword class : UpdatePassword method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();

		}

	}


}


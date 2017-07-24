/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerPasswordsHistory;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
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
		
		SessionFactory factory = new AnnotationConfiguration()
																.configure()
																.addAnnotatedClass(CustomerPasswordsHistory.class).addAnnotatedClass(Customers.class)
																.buildSessionFactory();
										//addAnnotationClass(Company.class).buildSessionFactory();
		Session session = factory.openSession();

/*		SessionFactory factoryCustomers = new AnnotationConfiguration()
												.configure()
												.addAnnotatedClass(Customers.class)
												.buildSessionFactory();
										//addAnnotationClass(Company.class).buildSessionFactory();
		Session sessionCustomers = factoryCustomers.openSession();*/

		try {

			DesEncrypter desEncrypter = new DesEncrypter(emailId);
			newPassword = desEncrypter.encrypt(newPassword);
			session.beginTransaction();
			Query query = session.createQuery("update CustomerPasswordsHistory set password = :newPassword" + " where customerId = :customerId");

			query.setParameter("newPassword", newPassword);

			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			session.getTransaction().commit();

			logger.debug("UpdateCustomerPassword class : UpdatePassword method : updated data of CustomerPasswordsHistory table to set password for customerId : "+customerId);
			
			session.beginTransaction();
			query = session.createQuery("update Customers set password = :newPassword" + " where customerId = :customerId");

			query.setParameter("newPassword", newPassword);

			query.setParameter("customerId", customerId);

			result = query.executeUpdate();
			session.getTransaction().commit();
			
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
			if(factory !=null)
				factory.close();

		}

	}


}


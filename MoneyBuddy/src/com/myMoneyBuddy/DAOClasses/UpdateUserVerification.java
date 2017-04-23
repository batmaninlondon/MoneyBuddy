/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class UpdateUserVerification {

	Logger logger = Logger.getLogger(UpdateUserVerification.class);
	
	public void userVerification (String hashedPassword) throws MoneyBuddyException {

		SessionFactory factory = new AnnotationConfiguration()
										.configure()
										.addAnnotatedClass(Customers.class)
										.buildSessionFactory();
						//addAnnotationClass(Company.class).buildSessionFactory();
		Session session = factory.openSession();

		try {

			logger.debug("UpdateUserVerification class : UserVerification method : start");
			
			session.beginTransaction();

			Query query = session.createQuery("update Customers set verificationStatus = :verificationStatus" + " where password = :hashedPassword");

			query.setParameter("verificationStatus", "YES");
			query.setParameter("hashedPassword", hashedPassword);

			int result = query.executeUpdate();

			session.getTransaction().commit();

			logger.debug("UpdateUserVerification class : UserVerification method : updated data of Customers table to set verificationStatus to YES ");
			logger.debug("UpdateUserVerification class : UserVerification method : end");
			
		}
		catch ( HibernateException e ) {
			logger.debug("UpdateUserVerification class : UserVerification method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("UpdateUserVerification class : UserVerification method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(factory!=null)
				factory.close();
		}

	}


}


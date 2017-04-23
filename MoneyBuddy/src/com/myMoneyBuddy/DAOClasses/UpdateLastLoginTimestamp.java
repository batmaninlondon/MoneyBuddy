/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerLoginActivity;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class UpdateLastLoginTimestamp {
	
	Logger logger = Logger.getLogger(UpdateLastLoginTimestamp.class);

	public void updateLastLoginTimestamp (String customerId) throws MoneyBuddyException {

		logger.debug("UpdateLastLoginTimestamp class : UpdateLastLoginTimestamp method : start");
		
		SessionFactory factory = new AnnotationConfiguration()
										.configure()
										.addAnnotatedClass(CustomerLoginActivity.class)
										.buildSessionFactory();
							//addAnnotationClass(Company.class).buildSessionFactory();
		Session session = factory.openSession();

		try {

			session.beginTransaction();

			CustomerLoginActivity userTimestampDetails = (CustomerLoginActivity)session.get(CustomerLoginActivity.class,customerId);
			String  currentTime = userTimestampDetails.getCurrentLoginTimestamp();

			Query query = session.createQuery("update CustomerLoginActivity set lastLoginTimestamp = :lastLoginTimestamp" + " where customerId = :customerId");

			query.setParameter("lastLoginTimestamp", currentTime);

			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			session.getTransaction().commit();

			logger.debug("UpdateLastLoginTimestamp class : UpdateLastLoginTimestamp method : updated data of CustomerLoginActivity table to set lastLoginTimestamp for customerId : "+customerId);
			logger.debug("UpdateLastLoginTimestamp class : UpdateLastLoginTimestamp method : end");
			
		}
		catch ( HibernateException e ) {
			logger.debug("UpdateLastLoginTimestamp class : UpdateLastLoginTimestamp method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("UpdateLastLoginTimestamp class : UpdateLastLoginTimestamp method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(factory!=null)
				factory.close();
		}

	}


}


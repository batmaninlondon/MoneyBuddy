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

public class UpdateUserVerification {

	Logger logger = Logger.getLogger(UpdateUserVerification.class);
	
	public void userVerification (String hashedPassword) throws MoneyBuddyException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			logger.debug("UpdateUserVerification class - userVerification method - start");
			
			hibernateSession.beginTransaction();

			Query query = hibernateSession.createQuery("update Customers set verificationStatus = :verificationStatus" + " where password = :hashedPassword");

			query.setParameter("verificationStatus", "Y");
			query.setParameter("hashedPassword", hashedPassword);

			int result = query.executeUpdate();

			hibernateSession.getTransaction().commit();

			logger.debug("UpdateUserVerification class - userVerification method - updated data of Customers table to set verificationStatus to Y ");
			logger.debug("UpdateUserVerification class - userVerification method - end");
			
		}
		catch ( HibernateException e ) {
			logger.debug("UpdateUserVerification class - userVerification method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("UpdateUserVerification class - userVerification method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}


}


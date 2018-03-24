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

public class UpdateOldPassword {

	Logger logger = Logger.getLogger(UpdateOldPassword.class);
	
	public void updateOldPassword (String customerId) throws MoneyBuddyException {

		logger.debug("UpdateOldPassword class - updateOldPassword method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("update CustomerPasswordsHistory set old_password = password" + " where customerId = :customerId");

			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateOldPassword class - updateOldPassword method - customerId - "+customerId+" - updated data of CustomerPasswordsHistory table to set old_password ");
			logger.debug("UpdateOldPassword class - updateOldPassword method - customerId - "+customerId+" - end");
			
		}
		catch ( HibernateException e ) {
			logger.debug("UpdateOldPassword class - updateOldPassword method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("UpdateOldPassword class - updateOldPassword method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}


}


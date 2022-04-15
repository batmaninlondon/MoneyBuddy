/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.CustomerLoginActivity;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class UpdateLoginTimestamp {
	
	Logger logger = LogManager.getLogger(UpdateLoginTimestamp.class);

	public void updateLoginTimestamp (String customerId) throws MoneyBuddyException {

		logger.debug("UpdateLoginTimestamp class - updateLoginTimestamp method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			hibernateSession.beginTransaction();

			CustomerLoginActivity userTimestampDetails = (CustomerLoginActivity)hibernateSession.get(CustomerLoginActivity.class,customerId);
			String  currentTime = userTimestampDetails.getCurrentLoginTimestamp();

			Query query = hibernateSession.createQuery("update CustomerLoginActivity set lastLoginTimestamp = :lastLoginTimestamp" + " where customerId = :customerId");

			query.setParameter("lastLoginTimestamp", currentTime);

			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			hibernateSession.beginTransaction();

			query = hibernateSession.createQuery("update CustomerLoginActivity set currentLoginTimestamp = :currentLoginTimestamp" + " where customerId = :customerId");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDate = dateFormat.format(date);

			query.setParameter("currentLoginTimestamp", frmtdDate);

			query.setParameter("customerId", customerId);

			result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateLoginTimestamp class - updateLoginTimestamp method - customerId - "+customerId+" updated data of CustomerLoginActivity table to set lastLoginTimestamp ");
			logger.debug("UpdateLoginTimestamp class - updateLoginTimestamp method - customerId - "+customerId+" - end");
			
		}
		catch ( HibernateException e ) {
			logger.error("UpdateLoginTimestamp class - updateLoginTimestamp method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateLoginTimestamp class - updateLoginTimestamp method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}


}


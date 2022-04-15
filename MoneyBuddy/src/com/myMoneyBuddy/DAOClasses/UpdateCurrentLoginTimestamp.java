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

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class UpdateCurrentLoginTimestamp {
	
	Logger logger = LogManager.getLogger(UpdateCurrentLoginTimestamp.class);

	public void updateCurrentLoginTimestamp (String customerId) throws MoneyBuddyException {

		logger.debug("UpdateCurrentLoginTimestamp class - updateCurrentLoginTimestamp method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			hibernateSession.beginTransaction();

			Query query = hibernateSession.createQuery("update CustomerLoginActivity set currentLoginTimestamp = :currentLoginTimestamp" + " where customerId = :customerId");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDate = dateFormat.format(date);

			query.setParameter("currentLoginTimestamp", frmtdDate);

			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();
			
			logger.debug("UpdateCurrentLoginTimestamp class - updateCurrentLoginTimestamp method - customerId - "+customerId+" - updated data of CustomerLoginActivity table to set currentLoginTimestamp");
			logger.debug("UpdateCurrentLoginTimestamp class - updateCurrentLoginTimestamp method - customerId - "+customerId+" - end");
			
		}
		catch ( HibernateException e ) {
			logger.error("UpdateCurrentLoginTimestamp class - updateCurrentLoginTimestamp method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCurrentLoginTimestamp class - updateCurrentLoginTimestamp method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

}


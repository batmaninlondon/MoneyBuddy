/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerLoginActivity;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class UpdateLoginTimestamp {
	
	Logger logger = Logger.getLogger(UpdateLoginTimestamp.class);

	public void updateLoginTimestamp (String customerId) throws MoneyBuddyException {

		logger.debug("UpdateLastLoginTimestamp class : UpdateLastLoginTimestamp method : start");
		
		Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			session.beginTransaction();

			CustomerLoginActivity userTimestampDetails = (CustomerLoginActivity)session.get(CustomerLoginActivity.class,customerId);
			String  currentTime = userTimestampDetails.getCurrentLoginTimestamp();

			Query query = session.createQuery("update CustomerLoginActivity set lastLoginTimestamp = :lastLoginTimestamp" + " where customerId = :customerId");

			query.setParameter("lastLoginTimestamp", currentTime);

			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			session.getTransaction().commit();

			session.beginTransaction();

			query = session.createQuery("update CustomerLoginActivity set currentLoginTimestamp = :currentLoginTimestamp" + " where customerId = :customerId");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDate = dateFormat.format(date);

			query.setParameter("currentLoginTimestamp", frmtdDate);

			query.setParameter("customerId", customerId);

			result = query.executeUpdate();
			session.getTransaction().commit();

			logger.debug("UpdateLoginTimestamp class : UpdateLoginTimestamp method : updated data of CustomerLoginActivity table to set lastLoginTimestamp for customerId : "+customerId);
			logger.debug("UpdateLoginTimestamp class : UpdateLoginTimestamp method : end");
			
		}
		catch ( HibernateException e ) {
			logger.debug("UpdateLoginTimestamp class : UpdateLoginTimestamp method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("UpdateLoginTimestamp class : UpdateLoginTimestamp method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();
		}

	}


}


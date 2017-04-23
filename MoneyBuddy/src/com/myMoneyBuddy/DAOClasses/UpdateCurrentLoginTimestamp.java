/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerLoginActivity;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class UpdateCurrentLoginTimestamp {
	
	Logger logger = Logger.getLogger(UpdateCurrentLoginTimestamp.class);

	public void updateCurrentLoginTimestamp (String customerId) throws MoneyBuddyException {

		logger.debug("UpdateCurrentLoginTimestamp class : UpdateCurrentLoginTimestamp method : start");
		
		SessionFactory factory = new AnnotationConfiguration()
										.configure()
										.addAnnotatedClass(CustomerLoginActivity.class)
										.buildSessionFactory();
						//addAnnotationClass(Company.class).buildSessionFactory();
		Session session = factory.openSession();

		try {

			session.beginTransaction();

			Query query = session.createQuery("update CustomerLoginActivity set currentLoginTimestamp = :currentLoginTimestamp" + " where customerId = :customerId");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDate = dateFormat.format(date);

			query.setParameter("currentLoginTimestamp", frmtdDate);

			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			session.getTransaction().commit();
			
			logger.debug("UpdateCurrentLoginTimestamp class : UpdateCurrentLoginTimestamp method : updated data of CustomerLoginActivity table to set currentLoginTimestamp for customerId : "+customerId);
			logger.debug("UpdateCurrentLoginTimestamp class : UpdateCurrentLoginTimestamp method : end");
			
		}
		catch ( HibernateException e ) {
			logger.debug("UpdateCurrentLoginTimestamp class : UpdateCurrentLoginTimestamp method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("UpdateCurrentLoginTimestamp class : UpdateCurrentLoginTimestamp method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(factory!=null)
				factory.close();
		}

	}

}


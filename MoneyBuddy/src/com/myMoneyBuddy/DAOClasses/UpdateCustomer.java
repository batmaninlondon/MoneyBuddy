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


public class UpdateCustomer {
	
	Logger logger = Logger.getLogger(UpdateCustomer.class);

	public void updatePancard (String customerId, String panCard, String kycStatus) throws MoneyBuddyException {

		logger.debug("UpdateCustomer class : updatePancard method : start");
		
		Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in updatePancard : "+customerId);
		System.out.println("panCard : in updatePancard : "+panCard);
		System.out.println("kycStatus : in updatePancard : "+kycStatus);

		try {

			session.beginTransaction();
			Query query = session.createQuery("update Customers set panCard = :panCard , kycStatus = :kycStatus where customerId = :customerId");

			query.setParameter("panCard", panCard);

			query.setParameter("kycStatus", kycStatus);
			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			session.getTransaction().commit();

			logger.debug("UpdateCustomer class : updatePancard method : updated data of Customers table to set panCard and kycStatus for customerId : "+customerId);

			logger.debug("UpdateCustomer class : updatePancard method : end");

		}
		catch ( HibernateException e ) {
			logger.debug("UpdateCustomer class : updatePancard method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("UpdateCustomer class : updatePancard method : Caught Exception");
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
	
	
	public void updateBseClientCreationStatus (String customerId, String bseClientCreationStatus) throws MoneyBuddyException {

		logger.debug("UpdateCustomer class : updateBseClientCreationStatus method : start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in updateBseClientCreationStatus : "+customerId);
		System.out.println("bseClientCreationStatus : in updateBseClientCreationStatus : "+bseClientCreationStatus);

		try {

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("update Customers set bseClientCreated = :bseClientCreated where customerId = :customerId");

			query.setParameter("bseClientCreated", bseClientCreationStatus);
			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomer class : updateBseClientCreationStatus method : updated data of Customers table to set bseClientCreated for customerId : "+customerId);

			logger.debug("UpdateCustomer class : updateBseClientCreationStatus method : end");

		}
		catch ( HibernateException e ) {
			logger.debug("UpdateCustomer class : updateBseClientCreationStatus method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("UpdateCustomer class : updateBseClientCreationStatus method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			hibernateSession.close();

		}

	}


}


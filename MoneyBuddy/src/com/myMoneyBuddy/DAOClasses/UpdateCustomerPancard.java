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


public class UpdateCustomerPancard {
	
	Logger logger = Logger.getLogger(UpdateCustomerPancard.class);

	public void updatePancard (String customerId, String panCard, String kycStatus) throws MoneyBuddyException {

		logger.debug("UpdateCustomerPancard class : updatePancard method : start");
		
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

			logger.debug("UpdateCustomerPancard class : updatePancard method : updated data of Customers table to set panCard and kycStatus for customerId : "+customerId);

			logger.debug("UpdateCustomerPancard class : updatePancard method : end");

		}
		catch ( HibernateException e ) {
			logger.debug("UpdateCustomerPancard class : updatePancard method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("UpdateCustomerPancard class : updatePancard method : Caught Exception");
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


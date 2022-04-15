/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class UpdateCustomerRedemptionCart {
	
	Logger logger = LogManager.getLogger(UpdateCustomerRedemptionCart.class);

	public void deleteCustomerRedCartEntry (String customerId, String redCartId) throws MoneyBuddyException {

		logger.debug("UpdateCustomerRedemptionCart class - deleteCustomerRedCartEntry method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in deleteCustomerRedCartEntry : "+customerId);
		System.out.println("redCartId : in deleteCustomerRedCartEntry : "+redCartId);

		try {

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("delete from RedemptionCart where redCartId = :redCartId and customerId = :customerId ");

			query.setParameter("redCartId", redCartId);
			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomerRedemptionCart class - deleteCustomerRedCartEntry method - customerId - "+customerId+" - deleted a row from RedemptionCart table for redCartId : "+redCartId);

			logger.debug("UpdateCustomerRedemptionCart class - deleteCustomerRedCartEntry method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerRedemptionCart class - deleteCustomerRedCartEntry method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerRedemptionCart class - deleteCustomerRedCartEntry method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public void emptyCustomerRedCart (String customerId) throws MoneyBuddyException {

		logger.debug("UpdateCustomerRedemptionCart class - emptyCustomerRedCart method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in emptyCustomerRedCart : "+customerId);

		try {

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("delete from RedemptionCart where customerId = :customerId ");

			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomerRedemptionCart class - emptyCustomerRedCart method - customerId - "+customerId+" - deleted all rows from RedemptionCart table ");

			logger.debug("UpdateCustomerRedemptionCart class - emptyCustomerRedCart method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerRedemptionCart class - emptyCustomerRedCart method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerRedemptionCart class - emptyCustomerRedCart method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public void updateCustomerRedCartEntry (String customerId, String redCartId, String redAmount, String redUnits, String redemptionOption,
											String redemptionType) throws MoneyBuddyException {

		logger.debug("UpdateCustomerRedemptionCart class - updateCustomerRedCartEntry method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in updateCustomerRedCartEntry : "+customerId);
		System.out.println("GOING TO CALL updateCustomerRedCartEntry : redCartId: "+redCartId+" : redAmount : "+redAmount+" : redUnits : "+redUnits+" : redemptionOption : "
									+redemptionOption+" : redemptionType : "+redemptionType);

		try {
			

			hibernateSession.beginTransaction();
		
			Query query = hibernateSession.createQuery("update RedemptionCart set redAmount = :redAmount, redUnits = :redUnits, redemptionOption = :redemptionOption, "
					+ " redemptionType = :redemptionType where redCartId = :redCartId");
			
			query.setParameter("redAmount", redAmount);
			query.setParameter("redUnits", redUnits);
			query.setParameter("redemptionOption", redemptionOption);
			query.setParameter("redemptionType", redemptionType);
			query.setParameter("redCartId", redCartId);
			
			query.executeUpdate();
			hibernateSession.getTransaction().commit();
		
			logger.debug("UpdateCustomerRedemptionCart class - updateCustomerRedCartEntry method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerRedemptionCart class - updateCustomerRedCartEntry method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerRedemptionCart class - updateCustomerRedCartEntry method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

}


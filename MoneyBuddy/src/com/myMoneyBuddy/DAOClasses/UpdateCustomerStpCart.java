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

public class UpdateCustomerStpCart {
	
	Logger logger = LogManager.getLogger(UpdateCustomerStpCart.class);

	public void deleteCustomerStpCartEntry (String customerId, String stpCartId) throws MoneyBuddyException {

		logger.debug("UpdateCustomerStpCart class - deleteCustomerStpCartEntry method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in deleteCustomerRedCartEntry : "+customerId);
		System.out.println("stpCartId : in deleteCustomerRedCartEntry : "+stpCartId);

		try {

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("delete from StpCart where stpCartId = :stpCartId and customerId = :customerId ");

			query.setParameter("stpCartId", stpCartId);
			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomerStpCart class - deleteCustomerStpCartEntry method - customerId - "+customerId+" - deleted a row from StpCart table for stpCartId : "+stpCartId);

			logger.debug("UpdateCustomerStpCart class - deleteCustomerStpCartEntry method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerStpCart class - deleteCustomerStpCartEntry method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerStpCart class - deleteCustomerStpCartEntry method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public void emptyCustomerStpCart (String customerId) throws MoneyBuddyException {

		logger.debug("UpdateCustomerStpCart class - emptyCustomerStpCart method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in emptyCustomerStpCart : "+customerId);

		try {

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("delete from StpCart where customerId = :customerId ");

			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomerStpCart class - emptyCustomerStpCart method - customerId - "+customerId+" - deleted all rows from StpCart table ");

			logger.debug("UpdateCustomerStpCart class - emptyCustomerStpCart method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerStpCart class - emptyCustomerStpCart method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerStpCart class - emptyCustomerStpCart method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public void updateCustomerStpCartEntry (String customerId, String stpCartId, String purchaseFundSchemeName, String stpAmount, 
								String stpTenure,String stpDate) throws MoneyBuddyException {

		logger.debug("UpdateCustomerStpCart class - updateCustomerStpCartEntry method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in updateCustomerStpCartEntry : "+customerId);
		System.out.println("GOING TO CALL updateCustomerStpCartEntry : stpCartId: "+stpCartId+" : stpAmount : "+stpAmount+" : stpTenure : "+stpTenure+
									" : stpDate : "+stpDate);

		try {
			
			QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
			String purchaseFundId = queryPrimaryFundDetails.getFundId(purchaseFundSchemeName);
			hibernateSession.beginTransaction();
		
			Query query = hibernateSession.createQuery("update StpCart set stpAmount = :stpAmount, stpDuration = :stpDuration, stpDate = :stpDate, "
					+ " purchaseFundId = :purchaseFundId, purchaseFundSchemeName = :purchaseFundSchemeName where stpCartId = :stpCartId");
			
			query.setParameter("stpAmount", stpAmount);
			query.setParameter("stpDuration", stpTenure);
			query.setParameter("stpDate", stpDate);
			query.setParameter("purchaseFundId", purchaseFundId);
			query.setParameter("purchaseFundSchemeName", purchaseFundSchemeName);
			query.setParameter("stpCartId", stpCartId);
			
			query.executeUpdate();
			hibernateSession.getTransaction().commit();
		
			logger.debug("UpdateCustomerStpCart class - updateCustomerStpCartEntry method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerStpCart class - updateCustomerStpCartEntry method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerStpCart class - updateCustomerStpCartEntry method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

}


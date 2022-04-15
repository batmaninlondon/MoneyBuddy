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

public class UpdateCustomerSwitchCart {
	
	Logger logger = LogManager.getLogger(UpdateCustomerSwitchCart.class);

	public void deleteCustomerSwitchCartEntry (String customerId, String switchCartId) throws MoneyBuddyException {

		logger.debug("UpdateCustomerSwitchCart class - deleteCustomerSwitchCartEntry method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in deleteCustomerRedCartEntry : "+customerId);
		System.out.println("switchCartId : in deleteCustomerRedCartEntry : "+switchCartId);

		try {

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("delete from SwitchCart where switchCartId = :switchCartId and customerId = :customerId ");

			query.setParameter("switchCartId", switchCartId);
			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomerSwitchCart class - deleteCustomerSwitchCartEntry method - customerId - "+customerId+" - deleted a row from SwitchCart table for switchCartId : "+switchCartId);

			logger.debug("UpdateCustomerSwitchCart class - deleteCustomerSwitchCartEntry method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerSwitchCart class - deleteCustomerSwitchCartEntry method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerSwitchCart class - deleteCustomerSwitchCartEntry method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public void emptyCustomerSwitchCart (String customerId) throws MoneyBuddyException {

		logger.debug("UpdateCustomerSwitchCart class - emptyCustomerSwitchCart method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in emptyCustomerSwitchCart : "+customerId);

		try {

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("delete from SwitchCart where customerId = :customerId ");

			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomerSwitchCart class - emptyCustomerSwitchCart method - customerId - "+customerId+" - deleted all rows from SwitchCart table ");

			logger.debug("UpdateCustomerSwitchCart class - emptyCustomerSwitchCart method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerSwitchCart class - emptyCustomerSwitchCart method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerSwitchCart class - emptyCustomerSwitchCart method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public void updateCustomerSwitchCartEntry (String customerId, String switchCartId, String purchaseFundSchemeName, String switchAmount, 
								String switchUnit, String switchOption, String switchType ) throws MoneyBuddyException {

		logger.debug("UpdateCustomerSwitchCart class - updateCustomerSwitchCartEntry method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in updateCustomerSwitchCartEntry : "+customerId);

		try {
			
			QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
			String purchaseFundId = queryPrimaryFundDetails.getFundId(purchaseFundSchemeName);
			hibernateSession.beginTransaction();
		
			Query query = hibernateSession.createQuery("update SwitchCart set switchAmount = :switchAmount, switchUnit = :switchUnit, switchOption = :switchOption, "
					+ " switchType = :switchType, purchaseFundId =:purchaseFundId, purchaseFundSchemeName = :purchaseFundSchemeName where switchCartId = :switchCartId");
			
			query.setParameter("switchAmount", switchAmount);
			query.setParameter("switchUnit", switchUnit);
			query.setParameter("switchOption", switchOption);
			query.setParameter("switchType", switchType);
			query.setParameter("purchaseFundId", purchaseFundId);
			query.setParameter("purchaseFundSchemeName", purchaseFundSchemeName);
			query.setParameter("switchCartId", switchCartId);
			
			query.executeUpdate();
			hibernateSession.getTransaction().commit();
		
			logger.debug("UpdateCustomerSwitchCart class - updateCustomerSwitchCartEntry method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerSwitchCart class - updateCustomerSwitchCartEntry method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerSwitchCart class - updateCustomerSwitchCartEntry method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

}


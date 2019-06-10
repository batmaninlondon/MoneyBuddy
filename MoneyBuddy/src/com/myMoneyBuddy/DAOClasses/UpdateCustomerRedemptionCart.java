/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class UpdateCustomerRedemptionCart {
	
	Logger logger = Logger.getLogger(UpdateCustomerRedemptionCart.class);

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
	
	public void updateCustomerRedCartEntry (String customerId, String redCartId, String amount, String units, String redemptionOption,
											String redemptionType) throws MoneyBuddyException {

		logger.debug("UpdateCustomerRedemptionCart class - updateCustomerRedCartEntry method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in updateCustomerRedCartEntry : "+customerId);
		System.out.println("redCartId : in updateCustomerRedCartEntry : "+redCartId);

		try {
			

			hibernateSession.beginTransaction();
		
			Query query = hibernateSession.createQuery("update RedemptionCart set redAmount = :amount, redUnits = :units, redemptionOption = :redemptionOption, "
					+ " redemptionType = :redemptionType where redCartId = :redCartId");
			query.setParameter("amount", amount);
			query.setParameter("units", units);
			query.setParameter("redemptionOption", redemptionOption);
			query.setParameter("redemptionType", redemptionType);
			query.setParameter("redCartId", redCartId);
			
			query.executeUpdate();
			hibernateSession.getTransaction().commit();
		
			
			
			
/*			hibernateSession.beginTransaction();
			Query query ;
			if (sipTenure == null || "".equals(sipTenure) )  {
				System.out.println(" Inside NULL loop : value of sipTenure is :"+sipTenure+":");
				if (upfrontAmount == null || "".equals(upfrontAmount) )  
					upfrontAmount = "0";
				query = hibernateSession.createQuery("select redCartId, amount,unit from RedemptionCart where customerId=:customerId"
						+ " and productId=:productId and folioNumber=:folioNumber and cartId != :cartId  and transactionType='UPFRONT' ");
			}
			else {
				System.out.println(" Inside NOT NULL loop : value of sipTenure is :"+sipTenure+":");
				if (sipAmount == null || "".equals(sipAmount) )  
					sipAmount = "0";
				query = hibernateSession.createQuery("select cartId, sipAmount from CustomerCart where customerId=:customerId"
						+ " and productId=:productId and folioNumber=:folioNumber and sipDuration=:sipDuration "
						+ " and sipDate=:sipDate and cartId != :cartId  and transactionType='SIP' ");
				query.setParameter("sipDuration",sipTenure);
				query.setParameter("sipDate",sipDate);
			}
			
			query.setParameter("customerId",customerId);
			query.setParameter("productId",productId);
			query.setParameter("folioNumber",folioNum);
			query.setParameter("cartId",cartId);
			
			Iterator it=query.iterate();
			hibernateSession.getTransaction().commit();
			
			if (it.hasNext())  {
				Object[] row = (Object[]) it.next();
				
				System.out.println("sipTenure is : "+sipTenure);
				hibernateSession.beginTransaction();
				if (sipTenure == null || "".equals(sipTenure) )  {
					query = hibernateSession.createQuery("update CustomerCart set upfrontAmount = :amount, folioNumber=:folioNumber where cartId = :cartId"
							+ " and transactionType='UPFRONT' ");
					query.setParameter("amount", Integer.toString((Integer.parseInt(row[1].toString())+Integer.parseInt(upfrontAmount))));
				}
				else {
					query = hibernateSession.createQuery("update CustomerCart set sipAmount = :amount, folioNumber=:folioNumber,"
    						+ " sipDuration=:sipDuration, sipDate=:sipDate where cartId = :cartId and transactionType='SIP'");
    				query.setParameter("sipDuration",sipTenure);
    				query.setParameter("sipDate",sipDate);
    				query.setParameter("amount", Integer.toString((Integer.parseInt(row[1].toString())+Integer.parseInt(sipAmount))));
				}
	
				
				query.setParameter("folioNumber", folioNum);
				query.setParameter("cartId", row[0].toString());
				query.executeUpdate();
				hibernateSession.getTransaction().commit();
				
				hibernateSession.beginTransaction();
				query = hibernateSession.createQuery("delete from CustomerCart where cartId = :cartId and customerId = :customerId ");

				query.setParameter("cartId", cartId);
				query.setParameter("customerId", customerId);

				query.executeUpdate();
				hibernateSession.getTransaction().commit();
				
			}
			else {
    			hibernateSession.beginTransaction();
    			if (sipTenure == null || "".equals(sipTenure) )  {
    				query = hibernateSession.createQuery("update CustomerCart set upfrontAmount = :amount, folioNumber=:folioNumber where cartId = :cartId");
    				query.setParameter("amount", upfrontAmount);
    			}
    			else {
    				query = hibernateSession.createQuery("update CustomerCart set sipAmount = :amount, folioNumber=:folioNumber,"
    						+ " sipDuration=:sipDuration, sipDate=:sipDate where cartId = :cartId");
    				query.setParameter("sipDuration",sipTenure);
    				query.setParameter("sipDate",sipDate);
    				query.setParameter("amount", sipAmount);
    			}
	
				
				query.setParameter("folioNumber", folioNum);
				query.setParameter("cartId", cartId);
				query.executeUpdate();
				hibernateSession.getTransaction().commit();
			}*/


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


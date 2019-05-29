/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.PendingOrderDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class UpdateCustomerCart {
	
	Logger logger = Logger.getLogger(UpdateCustomerCart.class);

	public void deleteCustomerCartEntry (String customerId, String cartId) throws MoneyBuddyException {

		logger.debug("UpdateCustomerCart class - deleteCustomerCartEntry method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in deleteCustomerCartEntry : "+customerId);
		System.out.println("cartId : in deleteCustomerCartEntry : "+cartId);

		try {

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("delete from CustomerCart where cartId = :cartId and customerId = :customerId ");

			query.setParameter("cartId", cartId);
			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			hibernateSession.getTransaction().commit();

			logger.debug("UpdateCustomerCart class - deleteCustomerCartEntry method - customerId - "+customerId+" - deleted a row from CustomerCart table for cartId : "+cartId);

			logger.debug("UpdateCustomerCart class - deleteCustomerCartEntry method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerCart class - deleteCustomerCartEntry method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerCart class - deleteCustomerCartEntry method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public void updateCustomerCartEntry (String customerId, String cartId, String productId, String investmentAmount, 
											String sipTenure, String sipDate, String folioNum) 
														throws MoneyBuddyException {

		logger.debug("UpdateCustomerCart class - updateCustomerCartEntry method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("customerId : in updateCustomerCartEntry : "+customerId);
		System.out.println("cartId : in updateCustomerCartEntry : "+cartId);

		try {
			
			/*if ("untilStopped".equals(sipTenure))  {
				sipTenure="99";
			}*/
			
			hibernateSession.beginTransaction();
			Query query ;
			if (sipTenure == null || "".equals(sipTenure) )  {
				System.out.println(" Inside NULL loop : value of sipTenure is :"+sipTenure+":");
				query = hibernateSession.createQuery("select cartId, amount from CustomerCart where customerId=:customerId"
						+ " and productId=:productId and folioNumber=:folioNumber and cartId != :cartId  and transactionType='UPFRONT' ");
			}
			else {
				System.out.println(" Inside NOT NULL loop : value of sipTenure is :"+sipTenure+":");
				query = hibernateSession.createQuery("select cartId, amount from CustomerCart where customerId=:customerId"
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
					query = hibernateSession.createQuery("update CustomerCart set amount = :amount, folioNumber=:folioNumber where cartId = :cartId"
							+ " and transactionType='UPFRONT' ");
				}
				else {
					query = hibernateSession.createQuery("update CustomerCart set amount = :amount, folioNumber=:folioNumber,"
    						+ " sipDuration=:sipDuration, sipDate=:sipDate where cartId = :cartId and transactionType='SIP'");
    				query.setParameter("sipDuration",sipTenure);
    				query.setParameter("sipDate",sipDate);
				}
	
				query.setParameter("amount", Integer.toString((Integer.parseInt(row[1].toString())+Integer.parseInt(investmentAmount))));
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
    				query = hibernateSession.createQuery("update CustomerCart set amount = :amount, folioNumber=:folioNumber where cartId = :cartId");
    			}
    			else {
    				query = hibernateSession.createQuery("update CustomerCart set amount = :amount, folioNumber=:folioNumber,"
    						+ " sipDuration=:sipDuration, sipDate=:sipDate where cartId = :cartId");
    				query.setParameter("sipDuration",sipTenure);
    				query.setParameter("sipDate",sipDate);
    			}
	
				query.setParameter("amount", investmentAmount);
				query.setParameter("folioNumber", folioNum);
				query.setParameter("cartId", cartId);
				query.executeUpdate();
				hibernateSession.getTransaction().commit();
			}


			logger.debug("UpdateCustomerCart class - updateCustomerCartEntry method - customerId - "+customerId+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("UpdateCustomerCart class - updateCustomerCartEntry method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("UpdateCustomerCart class - updateCustomerCartEntry method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

}


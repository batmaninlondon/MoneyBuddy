/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.RedemptionCart;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class QueryCustomerRedemptionCart {

	Logger logger = Logger.getLogger(QueryCustomerRedemptionCart.class);
		
	public List<RedemptionCart> getCustomerRedemptionCart(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomerRedemptionCart class - getCustomerRedemptionCart method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		try
		{
			hibernateSession.flush();
			System.out.println("customerId is : "+customerId);
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("from RedemptionCart where customerId = :customerId ");
			query.setParameter("customerId", customerId);
			hibernateSession.getTransaction().commit();
			List<RedemptionCart> redemptionCartList = query.list();
			
			Double totalRedAmount = 0.0;
			Double totalRedUnits = 0.0;
			
			for (int i = 0; i < redemptionCartList.size(); i++) {
				RedemptionCart redemptionCartListElement = redemptionCartList.get(i);
				totalRedAmount += Double.parseDouble(redemptionCartListElement.getRedAmount());
				totalRedUnits += Double.parseDouble(redemptionCartListElement.getRedUnits());
			}
			
			redemptionCartList.add(new RedemptionCart(null,null,"Total",null,totalRedAmount.toString(),totalRedUnits.toString(),null,null,null,null,null,null,null));
			
			logger.debug("QueryCustomerRedemptionCart class - getCustomerRedemptionCart method - customerId - "+customerId+" - returns redemptionCartList of - "+(redemptionCartList.size()-1)+" records");
			logger.debug("QueryCustomerRedemptionCart class - getCustomerRedemptionCart method - customerId - "+customerId+" - end");
			
			return redemptionCartList;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomerRedemptionCart class - getCustomerRedemptionCart method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomerRedemptionCart class - getCustomerRedemptionCart method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public boolean existsFund(String customerId, String productId, String folioNumber) throws MoneyBuddyException {
		
		logger.debug("QueryCustomerRedemptionCart class - existsFund method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			hibernateSession.beginTransaction();
    		
    		Query query = hibernateSession.createQuery("select count(*) from RedemptionCart where customerId=:customerId and "
    				+ "productId=:productId and folioNumber=:folioNumber");
    		query.setParameter("customerId", customerId);
    		query.setParameter("productId", productId);
    		query.setParameter("folioNumber", folioNumber);
    		String count = query.uniqueResult().toString();
    		
    		hibernateSession.getTransaction().commit();
    		
    		System.out.println("folioNumber is in existsFund : "+folioNumber+" and customerId : "+
    				customerId+"and productId : "+productId+" and count is : "+count);
    		
    		if ("0".equals(count))  {
    			System.out.println("QueryCustomerRedemptionCart class - existsFund method - customerId - "+customerId+" - fund does not exists returns false");
    			logger.debug("QueryCustomerRedemptionCart class - existsFund method - customerId - "+customerId+" - fund does not exists returns false");
    			logger.debug("QueryCustomerRedemptionCart class - existsFund method - customerId - "+customerId+" - end");
    			return false;
    		}
    		else  {
    			System.out.println("QueryCustomerRedemptionCart class - existsFund method - customerId - "+customerId+" - fund exists returns true");
    			logger.debug("QueryCustomerRedemptionCart class - existsFund method - customerId - "+customerId+" - fund exists returns true");
    			logger.debug("QueryCustomerRedemptionCart class - existsFund method - customerId - "+customerId+" - end");
    			return true;
    		}

		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomerRedemptionCart class - existsFund method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomerRedemptionCart class - existsFund method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
}

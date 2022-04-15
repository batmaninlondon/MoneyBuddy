/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.RedemptionCart;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class QueryCustomerRedemptionCart {

	Logger logger = LogManager.getLogger(QueryCustomerRedemptionCart.class);
		
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
				RedemptionCart redCartListElement = redemptionCartList.get(i);
				
				totalRedAmount += Double.parseDouble(redCartListElement.getRedAmount());
				System.out.println("totalRedAmount : "+totalRedAmount);
				totalRedUnits += Double.parseDouble(redCartListElement.getRedUnits());
				
				totalRedAmount = Math.round(totalRedAmount * 10000.0) / 10000.0;
				totalRedUnits = Math.round(totalRedUnits * 10000.0) / 10000.0;
			}
			
			redemptionCartList.add(new RedemptionCart(null,null,"Total",null,totalRedAmount.toString(),totalRedUnits.toString(),null,null,null,null,null,null,null,null));
			
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
	
	public boolean existsFund(String customerId, String fundId, String folioNumber) throws MoneyBuddyException {
		
		logger.debug("QueryCustomerRedemptionCart class - existsFund method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			hibernateSession.beginTransaction();
    		
    		Query query = hibernateSession.createQuery("select count(*) from RedemptionCart where customerId=:customerId and "
    				+ "fundId=:fundId and folioNumber=:folioNumber");
    		query.setParameter("customerId", customerId);
    		query.setParameter("fundId", fundId);
    		query.setParameter("folioNumber", folioNumber);
    		String count = query.uniqueResult().toString();
    		
    		hibernateSession.getTransaction().commit();
    		
    		System.out.println("folioNumber is in existsFund : "+folioNumber+" and customerId : "+
    				customerId+"and fundId : "+fundId+" and count is : "+count);
    		
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

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

import com.myMoneyBuddy.EntityClasses.StpCart;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class QueryStpCart {

	Logger logger = LogManager.getLogger(QueryStpCart.class);
		
	public List<StpCart> getCustomerStpCart(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryStpCart class - getCustomerStpCart method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		try
		{
			hibernateSession.flush();
			System.out.println("customerId is : "+customerId);
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("from StpCart where customerId = :customerId ");
			query.setParameter("customerId", customerId);
			hibernateSession.getTransaction().commit();
			List<StpCart> stpCartList = query.list();
			
			Double totalStpAmount = 0.0;
			
			for (int i = 0; i < stpCartList.size(); i++) {
				StpCart stpCartListElement = stpCartList.get(i);
				
				totalStpAmount += Double.parseDouble(stpCartListElement.getStpAmount());
				
				totalStpAmount = Math.round(totalStpAmount * 10000.0) / 10000.0;
			}
			
			stpCartList.add(new StpCart(null,null,"Total",null,null,null,null,null,null,totalStpAmount.toString(),null,null,null));
			
			logger.debug("QueryStpCart class - getCustomerStpCart method - customerId - "+customerId+" - returns stpCartList of - "+(stpCartList.size()-1)+" records");
			logger.debug("QueryStpCart class - getCustomerStpCart method - customerId - "+customerId+" - end");
			
			return stpCartList;
		}
		catch ( HibernateException e ) {
			logger.error("QueryStpCart class - getCustomerStpCart method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryStpCart class - getCustomerStpCart method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public boolean existsFund(String customerId, String withdrawalFundId, String folioNumber) throws MoneyBuddyException {
		
		logger.debug("QueryStpCart class - existsFund method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			hibernateSession.beginTransaction();
    		
    		Query query = hibernateSession.createQuery("select count(*) from StpCart where customerId=:customerId and "
    				+ "withdrawalFundId=:withdrawalFundId and folioNumber=:folioNumber");
    		query.setParameter("customerId", customerId);
    		query.setParameter("withdrawalFundId", withdrawalFundId);
    		query.setParameter("folioNumber", folioNumber);
    		String count = query.uniqueResult().toString();
    		
    		hibernateSession.getTransaction().commit();
    		
    		System.out.println("folioNumber is in existsFund : "+folioNumber+" and customerId : "+
    				customerId+"and withdrawalFundId : "+withdrawalFundId+" and count is : "+count);
    		
    		if ("0".equals(count))  {
    			System.out.println("QueryStpCart class - existsFund method - customerId - "+customerId+" - fund does not exists returns false");
    			logger.debug("QueryStpCart class - existsFund method - customerId - "+customerId+" - fund does not exists returns false");
    			logger.debug("QueryStpCart class - existsFund method - customerId - "+customerId+" - end");
    			return false;
    		}
    		else  {
    			System.out.println("QueryStpCart class - existsFund method - customerId - "+customerId+" - fund exists returns true");
    			logger.debug("QueryStpCart class - existsFund method - customerId - "+customerId+" - fund exists returns true");
    			logger.debug("QueryStpCart class - existsFund method - customerId - "+customerId+" - end");
    			return true;
    		}

		}
		catch ( HibernateException e ) {
			logger.error("QueryStpCart class - existsFund method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryStpCart class - existsFund method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
}

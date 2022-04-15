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

import com.myMoneyBuddy.EntityClasses.SwitchCart;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class QuerySwitchCart {

	Logger logger = LogManager.getLogger(QuerySwitchCart.class);
		
	public List<SwitchCart> getCustomerSwitchCart(String customerId) throws MoneyBuddyException {
		
		logger.debug("QuerySwitchCart class - getCustomerSwitchCart method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		try
		{
			hibernateSession.flush();
			System.out.println("customerId is : "+customerId);
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("from SwitchCart where customerId = :customerId ");
			query.setParameter("customerId", customerId);
			hibernateSession.getTransaction().commit();
			List<SwitchCart> switchCartList = query.list();
			
			Double totalSwitchAmount = 0.0;
			Double totalSwitchUnit = 0.0;
			
			for (int i = 0; i < switchCartList.size(); i++) {
				SwitchCart switchCartListElement = switchCartList.get(i);
				
				totalSwitchAmount += Double.parseDouble(switchCartListElement.getSwitchAmount());
				totalSwitchUnit += Double.parseDouble(switchCartListElement.getSwitchUnit());
				
				totalSwitchAmount = Math.round(totalSwitchAmount * 10000.0) / 10000.0;
				totalSwitchUnit = Math.round(totalSwitchUnit * 10000.0) / 10000.0;
			}
			
			switchCartList.add(new SwitchCart(null,null,"Total",null,null,null,null,null,null,null,
								totalSwitchAmount.toString(),totalSwitchUnit.toString(),null,null,null,null));
			
			logger.debug("QuerySwitchCart class - getCustomerSwitchCart method - customerId - "+customerId+" - returns switchCartList of - "+(switchCartList.size()-1)+" records");
			logger.debug("QuerySwitchCart class - getCustomerSwitchCart method - customerId - "+customerId+" - end");
			
			return switchCartList;
		}
		catch ( HibernateException e ) {
			logger.error("QuerySwitchCart class - getCustomerSwitchCart method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QuerySwitchCart class - getCustomerSwitchCart method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public boolean existsFund(String customerId, String withdrawalFundId, String folioNumber) throws MoneyBuddyException {
		
		logger.debug("QuerySwitchCart class - existsFund method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			hibernateSession.beginTransaction();
    		
    		Query query = hibernateSession.createQuery("select count(*) from SwitchCart where customerId=:customerId and "
    				+ "withdrawalFundId=:withdrawalFundId and folioNumber=:folioNumber");
    		query.setParameter("customerId", customerId);
    		query.setParameter("withdrawalFundId", withdrawalFundId);
    		query.setParameter("folioNumber", folioNumber);
    		String count = query.uniqueResult().toString();
    		
    		hibernateSession.getTransaction().commit();
    		
    		System.out.println("folioNumber is in existsFund : "+folioNumber+" and customerId : "+
    				customerId+"and withdrawalFundId : "+withdrawalFundId+" and count is : "+count);
    		
    		if ("0".equals(count))  {
    			System.out.println("QuerySwitchCart class - existsFund method - customerId - "+customerId+" - fund does not exists returns false");
    			logger.debug("QuerySwitchCart class - existsFund method - customerId - "+customerId+" - fund does not exists returns false");
    			logger.debug("QuerySwitchCart class - existsFund method - customerId - "+customerId+" - end");
    			return false;
    		}
    		else  {
    			System.out.println("QuerySwitchCart class - existsFund method - customerId - "+customerId+" - fund exists returns true");
    			logger.debug("QuerySwitchCart class - existsFund method - customerId - "+customerId+" - fund exists returns true");
    			logger.debug("QuerySwitchCart class - existsFund method - customerId - "+customerId+" - end");
    			return true;
    		}

		}
		catch ( HibernateException e ) {
			logger.error("QuerySwitchCart class - existsFund method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QuerySwitchCart class - existsFund method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
}

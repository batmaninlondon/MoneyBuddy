/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.RedemptionCart;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

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
				RedemptionCart redCartListElement = redemptionCartList.get(i);
				
				
				hibernateSession.beginTransaction();
    			String latestNavValue = hibernateSession.createQuery("select navValue from NavHistory where fundId='"+redCartListElement.getFundId()+"' and NAV_DATE = "
    					+ " (select max(navDate) from NavHistory where fundId='"+redCartListElement.getFundId()+"')").uniqueResult().toString();
    			hibernateSession.getTransaction().commit();
    			
    			Double totalUnits = 0.0;
    			
    			hibernateSession.beginTransaction();
    			Object result = hibernateSession.createQuery("select sum(quantity) from TransactionDetails where customerId='"+customerId+"' "
    								+ " and fundId='"+redCartListElement.getFundId()+"' and transactionStatus='8' and "
    										+ " transactionFolioNum='"+redCartListElement.getFolioNumber()+"' and buySell='BUY'").uniqueResult();
    			 
    			String totalBuyUnit = "0";
     			if ( result != null) {
     				totalBuyUnit = result.toString();
     			}
    			 
    			 hibernateSession.getTransaction().commit();
    			
    			hibernateSession.beginTransaction();
    			
    			result = hibernateSession.createQuery("select sum(quantity) from TransactionDetails where customerId='"+customerId+"' "
						+ " and fundId='"+redCartListElement.getFundId()+"' and transactionStatus='8' and "
						+ " transactionFolioNum='"+redCartListElement.getFolioNumber()+"' and buySell='SELL'").uniqueResult();
    			
    			String totalSellUnit = "0";
    			if ( result != null) {
    				totalSellUnit = result.toString();
    			}
    			
    			
    			hibernateSession.getTransaction().commit();
    			
    			totalUnits = Double.parseDouble(totalBuyUnit) - Double.parseDouble(totalSellUnit);
    			
    			totalUnits = Math.round(totalUnits * 10000.0) / 10000.0;
    			
    			Double totalAmount = totalUnits * Double.parseDouble(latestNavValue);
    			
    			totalAmount = Math.round(totalAmount * 10000.0) / 10000.0;
    			    			
    			Double redUnits = Double.parseDouble(redCartListElement.getRedUnits());
    			
    			if ( redUnits > totalUnits)  {
    				redUnits = totalUnits;
    			}
    			
    			Double redAmount = redUnits *  Double.parseDouble(latestNavValue);
    			redUnits = Math.round(redUnits * 10000.0) / 10000.0;
    			redAmount = Math.round(redAmount * 10000.0) / 10000.0;
    			    				
				hibernateSession.beginTransaction();
				
				query = hibernateSession.createQuery("update RedemptionCart set latestNav = :latestNav , redAmount = :redAmount , redUnits = :redUnits , "
						+ " totalAmount = :totalAmount, totalUnits = :totalUnits where customerId = :customerId and fundId = :fundId and folioNumber = :folioNumber ");
			
    			query.setParameter("latestNav", latestNavValue);
    			query.setParameter("redAmount", Double.toString(redAmount));
    			query.setParameter("redUnits", Double.toString(redUnits));
    			query.setParameter("totalAmount", Double.toString(totalAmount));
    			query.setParameter("totalUnits", Double.toString(totalUnits));
    			query.setParameter("folioNumber", redCartListElement.getFolioNumber());
    			query.setParameter("customerId", customerId);
    			query.setParameter("fundId", redCartListElement.getFundId());
    			
    			query.executeUpdate();
    			
    			hibernateSession.getTransaction().commit();
    			
			}
			
			hibernateSession.beginTransaction();
			
			query = hibernateSession.createQuery("from RedemptionCart where customerId = :customerId ");
			query.setParameter("customerId", customerId);
			hibernateSession.getTransaction().commit();
			redemptionCartList = query.list();
			
			for (int i = 0; i < redemptionCartList.size(); i++) {
				RedemptionCart redCartListElement = redemptionCartList.get(i);
				
				totalRedAmount += Double.parseDouble(redCartListElement.getRedAmount());
				totalRedUnits += Double.parseDouble(redCartListElement.getRedUnits());
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

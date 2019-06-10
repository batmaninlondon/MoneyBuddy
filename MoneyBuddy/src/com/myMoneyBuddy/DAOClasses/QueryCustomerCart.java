/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class QueryCustomerCart {

	Logger logger = Logger.getLogger(QueryCustomerCart.class);
		
	public List<CustomerCart> getCustomerCart(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomerCart class - getCustomerCart method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		try
		{
			hibernateSession.flush();
			System.out.println("customerId is : "+customerId);
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("from CustomerCart where customerId = :customerId order by transactionType desc ");
			query.setParameter("customerId", customerId);
			hibernateSession.getTransaction().commit();
			List<CustomerCart> customerCartList = query.list();
			
			Double totalUpfrontAmount = 0.0;
			Double totalSipAmount = 0.0;
			
			for (int i = 0; i < customerCartList.size(); i++) {
				CustomerCart customerCartListElement = customerCartList.get(i);
				
				if ("UPFRONT".equals(customerCartListElement.getTransactionType()))
					totalUpfrontAmount += Double.parseDouble(customerCartListElement.getUpfrontAmount());
				else
					totalSipAmount += Double.parseDouble(customerCartListElement.getSipAmount());
			}
			
			customerCartList.add(new CustomerCart(null,null,"Total",null,null,totalUpfrontAmount.toString(),totalSipAmount.toString(),null,null,null,null,null,null,null,null,null,null));
			
			logger.debug("QueryCustomerCart class - getCustomerCart method - customerId - "+customerId+" - returns customerCartList of - "+(customerCartList.size()-1)+" records");
			logger.debug("QueryCustomerCart class - getCustomerCart method - customerId - "+customerId+" - end");
			
			return customerCartList;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomerCart class - getCustomerCart method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomerCart class - getCustomerCart method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public List<CustomerCart> getCustomerCartUpfront(String customerId) throws MoneyBuddyException {
			
		logger.debug("QueryCustomerCart class - getCustomerCartUpfront method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		try
		{
			hibernateSession.flush();
			System.out.println("customerId is : "+customerId);
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("from CustomerCart where customerId = :customerId and transactionType = 'UPFRONT' ");
			query.setParameter("customerId", customerId);
			hibernateSession.getTransaction().commit();
			List<CustomerCart> customerCartList = query.list();
			
			Double totalUpfrontAmount = 0.0;
			
			for (int i = 0; i < customerCartList.size(); i++) {
				CustomerCart customerCartListElement = customerCartList.get(i);
				totalUpfrontAmount += Double.parseDouble(customerCartListElement.getUpfrontAmount());
			}
			
			customerCartList.add(new CustomerCart(null,null,"Total",null,null,totalUpfrontAmount.toString(),"0",null,null,null,null,null,null,null,null,null,null));
			
			logger.debug("QueryCustomerCart class - getCustomerCartUpfront method - customerId - "+customerId+" - returns customerCartList of - "+(customerCartList.size()-1)+" records");
			logger.debug("QueryCustomerCart class - getCustomerCartUpfront method - customerId - "+customerId+" - end");
			
			return customerCartList;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomerCart class - getCustomerCartUpfront method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomerCart class - getCustomerCartUpfront method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public List<CustomerCart> getCustomerCartSip(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomerCart class - getCustomerCartSip method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		try
		{
			hibernateSession.flush();
			System.out.println("customerId is : "+customerId);
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("from CustomerCart where customerId = :customerId and transactionType = 'SIP' ");
			query.setParameter("customerId", customerId);
			hibernateSession.getTransaction().commit();
			List<CustomerCart> customerCartList = query.list();
			
			Double totalSipAmount = 0.0;
			
			for (int i = 0; i < customerCartList.size(); i++) {
				CustomerCart customerCartListElement = customerCartList.get(i);
				
				totalSipAmount += Double.parseDouble(customerCartListElement.getSipAmount());
				
			}
			
			customerCartList.add(new CustomerCart(null,null,"Total",null,null,"0",totalSipAmount.toString(),null,null,null,null,null,null,null,null,null,null));
			
			logger.debug("QueryCustomerCart class - getCustomerCartSip method - customerId - "+customerId+" - returns customerCartList of - "+(customerCartList.size()-1)+" records");
			logger.debug("QueryCustomerCart class - getCustomerCartSip method - customerId - "+customerId+" - end");
			
			return customerCartList;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomerCart class - getCustomerCartSip method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomerCart class - getCustomerCartSip method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}

	public boolean existsCamsFund(String customerId, String transactionType) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - existsCamsFund method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			
			hibernateSession.beginTransaction();
    		
    		Query query = hibernateSession.createQuery("select count(*) from CustomerCart where customerId = :customerId "
    				+ "and rta='CAMS' and transactionType = :transactionType");
    		query.setParameter("customerId", customerId);
    		query.setParameter("transactionType", transactionType);
    		String count = query.uniqueResult().toString();
    		
    		hibernateSession.getTransaction().commit();
    		
    		if ("0".equals(count))  {
    			logger.debug("QueryCustomer class - existsCamsFund method - customerId - "+customerId+" - CAMS fund exists returns true");
    			logger.debug("QueryCustomer class - existsCamsFund method - customerId - "+customerId+" - end");
    			return false;
    		}
    		else  {
    			logger.debug("QueryCustomer class - existsCamsFund method - customerId - "+customerId+" - CAMS fund exists returns true");
    			logger.debug("QueryCustomer class - existsCamsFund method - customerId - "+customerId+" - end");
    			return true;
    		}

		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - existsCamsFund method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - existsCamsFund method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public boolean existsFund(String customerId, String productId, String transactionType) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - existsFund method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			System.out.println("transactionType is in existsFund : "+transactionType);
			hibernateSession.beginTransaction();
    		
    		Query query = hibernateSession.createQuery("select count(*) from CustomerCart where customerId=:customerId and "
    				+ "productId=:productId and transactionType=:transactionType");
    		query.setParameter("customerId", customerId);
    		query.setParameter("productId", productId);
    		query.setParameter("transactionType", transactionType);
    		String count = query.uniqueResult().toString();
    		
    		hibernateSession.getTransaction().commit();
    		
    		System.out.println("transactionType is in existsFund : "+transactionType+" and customerId : "+
    				customerId+"and productId : "+productId+" and count is : "+count);
    		
    		if ("0".equals(count))  {
    			System.out.println("QueryCustomer class - existsFund method - customerId - "+customerId+" - fund does not exists returns false");
    			logger.debug("QueryCustomer class - existsFund method - customerId - "+customerId+" - fund does not exists returns false");
    			logger.debug("QueryCustomer class - existsFund method - customerId - "+customerId+" - end");
    			return false;
    		}
    		else  {
    			System.out.println("QueryCustomer class - existsFund method - customerId - "+customerId+" - fund exists returns true");
    			logger.debug("QueryCustomer class - existsFund method - customerId - "+customerId+" - fund exists returns true");
    			logger.debug("QueryCustomer class - existsFund method - customerId - "+customerId+" - end");
    			return true;
    		}

		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - existsFund method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - existsFund method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	
	public boolean cartExists(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - cartExists method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			hibernateSession.beginTransaction();
    		
    		Query query = hibernateSession.createQuery("select count(*) from CustomerCart where customerId=:customerId ");
    		query.setParameter("customerId", customerId);
    		String count = query.uniqueResult().toString();
    		
    		hibernateSession.getTransaction().commit();
    		
    		if ("0".equals(count))  {
    			System.out.println("QueryCustomer class - cartExists method - customerId - "+customerId+" - no record found in customer cart ");
    			logger.debug("QueryCustomer class - cartExists method - customerId - "+customerId+" -  record found in customer cart");
    			logger.debug("QueryCustomer class - cartExists method - customerId - "+customerId+" - end");
    			return false;
    		}
    		else  {
    			System.out.println("QueryCustomer class - cartExists method - customerId - "+customerId+" - "+count+" record found in customer cart");
    			logger.debug("QueryCustomer class - cartExists method - customerId - "+customerId+" - "+count+" record found in customer cart");
    			logger.debug("QueryCustomer class - cartExists method - customerId - "+customerId+" - end");
    			return true;
    		}

		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - cartExists method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - cartExists method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public boolean existsSimilarRow(String customerId, String productId, String transactionType) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - existsSimilarRow method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			
			hibernateSession.beginTransaction();
			Query query;
			if ( "UPFRONT".equals(transactionType))  {
				query = hibernateSession.createQuery("select count(*) from CustomerCart where customerId=:customerId"
    				+ " and productId=:productId and transactionType=:transactionType and folioNumber='New'");
			}
			else {
				query = hibernateSession.createQuery("select count(*) from CustomerCart where customerId=:customerId"
	    				+ " and productId=:productId and transactionType=:transactionType and folioNumber='New' and sipDuration='99' and sipDate='1' ");
			}
    		query.setParameter("customerId", customerId);
    		query.setParameter("productId", productId);
    		query.setParameter("transactionType", transactionType);
    		String count = query.uniqueResult().toString();
    		
    		hibernateSession.getTransaction().commit();
    		
    		if ("0".equals(count))  {
    			logger.debug("QueryCustomer class - existsSimilarRow method - customerId - "+customerId+" - new folio for fund does not exists returns false");
    			logger.debug("QueryCustomer class - existsSimilarRow method - customerId - "+customerId+" - end");
    			return false;
    		}
    		else  {
    			logger.debug("QueryCustomer class - existsSimilarRow method - customerId - "+customerId+" - new folio for fund exists returns true");
    			logger.debug("QueryCustomer class - existsSimilarRow method - customerId - "+customerId+" - end");
    			return true;
    		}

		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - existsSimilarRow method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - existsSimilarRow method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
}

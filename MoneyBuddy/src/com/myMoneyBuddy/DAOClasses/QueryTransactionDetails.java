/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class QueryTransactionDetails {

	Logger logger = Logger.getLogger(QueryTransactionDetails.class);

	public TransactionDetails getTransactionDetails(String transactionDetailId) throws MoneyBuddyException {
		
		logger.debug("QueryTransactionDetails class : getTransactionDetails method : start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		hibernateSession.clear();
		
		TransactionDetails transactionDetails = new TransactionDetails();
	
	
		try
		{
			System.out.println("transactionDetailId is : "+transactionDetailId);
			hibernateSession.beginTransaction();
			transactionDetails = (TransactionDetails) hibernateSession.get(TransactionDetails.class, transactionDetailId);
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryTransactionDetails class : getTransactionDetails method : end");
			return transactionDetails;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryTransactionDetails class : getTransactionDetails method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryTransactionDetails class : getTransactionDetails method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}
	}
	
	public HashMap<String,String> getPendingNavsOrders() throws MoneyBuddyException {
		
		logger.debug("QueryTransactionDetails class : getPendingNavsOrders method : start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		HashMap<String,String> pendingNavOrders = new HashMap<String,String>();
	
		try
		{
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select bseOrderId,transactionFolioNum from TransactionDetails where transactionStatus = '7'");
			List<Object[]> transactionDetailsList = query.list();
			String bseOrderId = "";
			String folioNum = "";
			for ( int i = 0; i < transactionDetailsList.size() ;i++ ) {
				
				if (null == transactionDetailsList.get(i)[0])
					bseOrderId = "";
				else
					bseOrderId = transactionDetailsList.get(i)[0].toString();
				
				if (null == transactionDetailsList.get(i)[1])
					folioNum = "";
				else
					folioNum = transactionDetailsList.get(i)[1].toString();
				
					
				pendingNavOrders.put(bseOrderId, folioNum);
			}
			
			Iterator it = pendingNavOrders.entrySet().iterator();
			 
			while ( it.hasNext() )  {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println("key : "+pair.getKey()+" and value : "+pair.getValue());
				
			}
			hibernateSession.getTransaction().commit();
			
			
			logger.debug("QueryTransactionDetails class : getPendingNavsOrders method : end");
			return pendingNavOrders;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryTransactionDetails class : getPendingNavsOrders method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryTransactionDetails class : getPendingNavsOrders method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}
	}


}

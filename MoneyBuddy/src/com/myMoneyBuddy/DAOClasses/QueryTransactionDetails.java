/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
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
	
/*	public HashMap<String,String> getPendingNavsOrders() throws MoneyBuddyException {
		
		logger.debug("QueryTransactionDetails class : getTransactionDetails method : start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		TransactionDetails transactionDetails = new TransactionDetails();
	
	
		try
		{
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select bseOrderId,TRANSACTION_FOLIO_NUM FROM ebdb.TRANSACTION_DETAILS  where TRANSACTION_STATUS='7';");
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
	}*/


}

/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerPasswordsHistory;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

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


}

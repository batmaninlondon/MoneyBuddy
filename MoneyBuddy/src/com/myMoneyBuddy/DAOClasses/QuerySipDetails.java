/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerPasswordsHistory;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.SipDetails;
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

public class QuerySipDetails {

	Logger logger = Logger.getLogger(QuerySipDetails.class);

	public SipDetails getSipDetails(String transactionDetailId) throws MoneyBuddyException {
		
		logger.debug("QuerySipDetails class : getSipDetails method : start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		hibernateSession.clear();
		
		SipDetails sipDetails = new SipDetails();
	
	
		try
		{
			System.out.println("transactionDetailId is : "+transactionDetailId);
			hibernateSession.beginTransaction();
			sipDetails = (SipDetails) hibernateSession.get(SipDetails.class, transactionDetailId);
			hibernateSession.getTransaction().commit();
			
			logger.debug("QuerySipDetails class : getSipDetails method : end");
			return sipDetails;
		}
		catch ( HibernateException e ) {
			logger.debug("QuerySipDetails class : getSipDetails method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QuerySipDetails class : getSipDetails method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}
	}


}

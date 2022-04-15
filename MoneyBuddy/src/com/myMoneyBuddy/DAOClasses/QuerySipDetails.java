/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class QuerySipDetails {

	Logger logger = LogManager.getLogger(QuerySipDetails.class);

	public SipDetails getSipDetails(String transactionDetailId) throws MoneyBuddyException {
		
		logger.debug("QuerySipDetails class - getSipDetails method - transactionDetailId - "+transactionDetailId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		hibernateSession.clear();
		
		SipDetails sipDetails = new SipDetails();
	
	
		try
		{
			System.out.println("transactionDetailId is : "+transactionDetailId);
			hibernateSession.beginTransaction();
			sipDetails = (SipDetails) hibernateSession.get(SipDetails.class, transactionDetailId);
			hibernateSession.getTransaction().commit();
			
			logger.debug("QuerySipDetails class - getSipDetails method - transactionDetailId - "+transactionDetailId+" - return SipDetails record");
			logger.debug("QuerySipDetails class - getSipDetails method - transactionDetailId - "+transactionDetailId+" - end");
			
			return sipDetails;
		}
		catch ( HibernateException e ) {
			logger.error("QuerySipDetails class - getSipDetails method - transactionDetailId - "+transactionDetailId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QuerySipDetails class - getSipDetails method - transactionDetailId - "+transactionDetailId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}


}

/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.SecondaryFundDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class QuerySecondaryFundDetails {
	
	Logger logger = Logger.getLogger(QuerySecondaryFundDetails.class);
	
	
	public SecondaryFundDetails getSecondaryFundDetails(String fundId) throws MoneyBuddyException {
		

		
		logger.debug("QuerySecondaryFundDetails class - getSecondaryFundDetails method - fundId - "+fundId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		hibernateSession.clear();
		
		SecondaryFundDetails secondaryFundDetails = new SecondaryFundDetails();
	
	
		try
		{
			System.out.println("fundId is : "+fundId);
			hibernateSession.beginTransaction();
			secondaryFundDetails = (SecondaryFundDetails) hibernateSession.get(SecondaryFundDetails.class, fundId);
			hibernateSession.getTransaction().commit();
			
			logger.debug("QuerySecondaryFundDetails class - getSecondaryFundDetails method - fundId - "+fundId+" - returns SecondaryFundDetails record");
			logger.debug("QuerySecondaryFundDetails class - getSecondaryFundDetails method - fundId - "+fundId+" - end");
			
			return secondaryFundDetails;
		}
		catch ( HibernateException e ) {
			logger.debug("QuerySecondaryFundDetails class - getSecondaryFundDetails method - fundId - "+fundId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QuerySecondaryFundDetails class - getSecondaryFundDetails method - fundId - "+fundId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}
	
		
	}
	
}

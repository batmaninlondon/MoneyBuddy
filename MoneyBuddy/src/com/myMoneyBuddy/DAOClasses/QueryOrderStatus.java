/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class QueryOrderStatus {

	Logger logger = LogManager.getLogger(QueryOrderStatus.class);

	public String getStatusDetail(String orderStatus) throws MoneyBuddyException {
			
		logger.debug("QueryOrderStatus class - getStatusDetail method - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			String userStatus;
			
			hibernateSession.beginTransaction();
			userStatus = hibernateSession.createQuery("select userStatus from OrderStatus where orderStatus = '"+orderStatus+"'").uniqueResult().toString();
	
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryOrderStatus class - getStatusDetail method - return statusDetail ");
			logger.debug("QueryOrderStatus class - getStatusDetail method - end");
			
			return userStatus;
		}
		catch ( HibernateException e ) {
			logger.error("QueryOrderStatus class - getStatusDetail method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryOrderStatus class - getStatusDetail method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}


}

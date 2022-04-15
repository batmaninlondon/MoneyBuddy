/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.BusinessDashboardDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class QueryBussinessData {

	Logger logger = LogManager.getLogger(QueryBussinessData.class);

	public BusinessDashboardDataModel getBusinessData() throws MoneyBuddyException {
		
		logger.debug("QueryTransactionDetails class - getBusinessData method - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("select count(*) from Customers ");
			
			String signUps = query.uniqueResult().toString();
			
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select count(*) from Customers  where aofFormStatus not in ('NOT_ACTIVATED') ");
			
			String aofCreation = query.uniqueResult().toString();
			
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select count(*) from Customers  where verificationStatus='Y' ");
			
			String verfiedAccounts = query.uniqueResult().toString();
			
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select count(*) from Customers  where aofFormStatus='ACTIVATED' ");
			
			String activatedAccounts = query.uniqueResult().toString();
			
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select sum(transactionAmount) from TransactionDetails  where transactionStatus='8' ");
			
			String investedAmount = query.uniqueResult().toString();
			
			investedAmount = String.format("%.2f", Double.parseDouble(investedAmount));
			
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select sum(quantity*unitPrice) from TransactionDetails   where transactionStatus='8' ");
			
			String currentAmount = query.uniqueResult().toString();
			currentAmount = String.format("%.2f", Double.parseDouble(currentAmount));
			
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select count(*) from SipDetails ");
			
			String sipRegistered = query.uniqueResult().toString();
			
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select count(distinct s.customerId) from SipDetails s ");
			
			String numOfSipClients = query.uniqueResult().toString();
			
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select sum( sipAmount) from SipDetails  where sipCompletionStatus='N' ");
			
			String monthlyRunningSipValue = "0";
			 if (null != query.list().get(0))  
			 {
				 monthlyRunningSipValue = query.uniqueResult().toString();
			 }
			 
			monthlyRunningSipValue = String.format("%.2f", Double.parseDouble(monthlyRunningSipValue));
			
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select count(*) from StpDetails ");
			
			String stpRegistered = query.uniqueResult().toString();
			
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select count(distinct s.customerId) from StpDetails s  ");
			
			String numOfStpClients = query.uniqueResult().toString();
			
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select sum( stpAmount) from StpDetails  where stpCompletionStatus in ('N','MAIL_SENT') ");
			 
			 String monthlyRunningStpValue = "0";
			 if (null != query.list().get(0))  
			 {
				 monthlyRunningStpValue = query.uniqueResult().toString();
			 }
			monthlyRunningStpValue = String.format("%.2f", Double.parseDouble(monthlyRunningStpValue));
			
			hibernateSession.getTransaction().commit();
			
			BusinessDashboardDataModel businessDashboardData = new BusinessDashboardDataModel(signUps, aofCreation, verfiedAccounts, 
					activatedAccounts, investedAmount, currentAmount, sipRegistered, numOfSipClients, monthlyRunningSipValue, stpRegistered, 
					numOfStpClients, monthlyRunningStpValue);
			
			logger.debug("QueryTransactionDetails class - getBusinessData method - end");
			
			return businessDashboardData;
		}
		catch ( HibernateException e ) {
			logger.error("QueryTransactionDetails class - getBusinessData method Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryTransactionDetails class - getBusinessData method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	
	
}

/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.KycStatus;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class QueryKycStatus {

	Logger logger = Logger.getLogger(QueryKycStatus.class);
	
	public String getKycStatusForPanCard(String panCard) throws MoneyBuddyException{
		
		Session hibernateSession = null;
		try
		{
			logger.debug("QueryKycStatus class : getKycStatusForPanCard method : start");
			
			hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
			
			hibernateSession.beginTransaction();
			KycStatus kyc = (KycStatus)hibernateSession.get(KycStatus.class,panCard);
			String status = kyc.getStatus();
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryKycStatus class : getKycStatusForPanCard method : end");
			return status;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryKycStatus class : getKycStatusForPanCard method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryKycStatus class : getKycStatusForPanCard method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}

	}

	public boolean existsPanCard(String panCard) throws MoneyBuddyException {

		Session hibernateSession = null;
		try
		{
			logger.debug("QueryKycStatus class : existsPanCard method : start");
			
			hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
			
			hibernateSession.beginTransaction();
			KycStatus kyc = (KycStatus)hibernateSession.get(KycStatus.class,panCard);
			if (kyc == null ) {
				logger.error("QueryKycStatus class : existsPanCard method : No entry found in the database table for panCard : "+panCard);
				return false;
			}
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryKycStatus class : existsPanCard method : end");
			return true;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryKycStatus class : existsPanCard method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryKycStatus class : existsPanCard method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}

	}
}

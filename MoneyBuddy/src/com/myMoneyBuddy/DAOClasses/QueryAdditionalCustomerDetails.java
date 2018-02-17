/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.AdditionalCustomerDetails;
import com.myMoneyBuddy.EntityClasses.CustomerPasswordsHistory;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class QueryAdditionalCustomerDetails {

	Logger logger = Logger.getLogger(QueryAdditionalCustomerDetails.class);
		
	public AdditionalCustomerDetails getAddCusDetails(String customerId) throws MoneyBuddyException {
			
		logger.debug("QueryAdditionalCustomerDetails class : getAddCusDetails method : start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	
		AdditionalCustomerDetails addCusDetails = new AdditionalCustomerDetails();
	
	
		try
		{
			hibernateSession.beginTransaction();
			addCusDetails = (AdditionalCustomerDetails) hibernateSession.createQuery("from AdditionalCustomerDetails where customerId = '"+customerId+"'").uniqueResult();
	
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryAdditionalCustomerDetails class : getCugetAddCusDetailsstomer method : end");
			return addCusDetails;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryAdditionalCustomerDetails class : getAddCusDetails method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryAdditionalCustomerDetails class : getAddCusDetails method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}
	}



}

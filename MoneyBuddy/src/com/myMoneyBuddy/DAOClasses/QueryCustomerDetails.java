/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerDetails;
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

public class QueryCustomerDetails {

	Logger logger = Logger.getLogger(QueryCustomerDetails.class);
		
	public CustomerDetails getCustomerDetails(String customerId) throws MoneyBuddyException {
			
		logger.debug("QueryCustomerDetails class : getCustomerDetails method : start");
		Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			CustomerDetails customerDetail = (CustomerDetails) session.get(CustomerDetails.class, customerId);
			
			return customerDetail;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomerDetails class : getCustomerDetails method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomerDetails class : getCustomerDetails method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();
		}
	}


}

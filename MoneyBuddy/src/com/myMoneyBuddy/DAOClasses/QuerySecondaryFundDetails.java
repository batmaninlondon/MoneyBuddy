/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.PrimaryFundDetails;
import com.myMoneyBuddy.EntityClasses.SecondaryFundDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;



public class QuerySecondaryFundDetails {
	
	Logger logger = Logger.getLogger(QuerySecondaryFundDetails.class);
	
	
	public SecondaryFundDetails getSecondaryFundDetails(String fundId) throws MoneyBuddyException {
		

		
		logger.debug("QuerySecondaryFundDetails class : getSecondaryFundDetails method : start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		hibernateSession.clear();
		
		SecondaryFundDetails secondaryFundDetails = new SecondaryFundDetails();
	
	
		try
		{
			System.out.println("fundId is : "+fundId);
			hibernateSession.beginTransaction();
			secondaryFundDetails = (SecondaryFundDetails) hibernateSession.get(SecondaryFundDetails.class, fundId);
			hibernateSession.getTransaction().commit();
			
			logger.debug("QuerySecondaryFundDetails class : getSecondaryFundDetails method : end");
			return secondaryFundDetails;
		}
		catch ( HibernateException e ) {
			logger.debug("QuerySecondaryFundDetails class : getSecondaryFundDetails method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QuerySecondaryFundDetails class : getSecondaryFundDetails method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}
	
		
	}
	
}

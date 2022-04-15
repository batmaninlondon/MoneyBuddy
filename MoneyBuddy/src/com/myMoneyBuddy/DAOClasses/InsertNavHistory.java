/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.NavHistory;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class InsertNavHistory {
	
	Logger logger = LogManager.getLogger(InsertNavHistory.class);

	public void insertNewNav (String fundId, String navValue) throws MoneyBuddyException {

		logger.debug("InsertNavHistory class - insertNewNav method - fundId - "+fundId+" and navValue - "+navValue+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		System.out.println("insertNewNav : fundId : "+fundId+" and navValue : "+navValue);

		try {
			
			Date date = new Date();
			String navDate= new SimpleDateFormat("yyyy-MM-dd").format(date);

			hibernateSession.beginTransaction();

			NavHistory tempNavHistory = new NavHistory(navDate,navValue,fundId);

			hibernateSession.saveOrUpdate(tempNavHistory);
			
			hibernateSession.getTransaction().commit();

			logger.debug("InsertNavHistory class - insertNewNav method - fundId - "+fundId+" and navValue - "+navValue+" - added a row into NavHistory");

			logger.debug("InsertNavHistory class - insertNewNav method - fundId - "+fundId+" and navValue - "+navValue+" - end");

		}
		catch ( HibernateException e ) {
			logger.error("InsertNavHistory class - insertNewNav method - fundId - "+fundId+" and navValue - "+navValue+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("InsertNavHistory class - insertNewNav method - fundId - "+fundId+" and navValue - "+navValue+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

}


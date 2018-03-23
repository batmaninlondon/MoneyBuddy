/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.AdditionalCustomerDetails;
import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class InsertAdditionalCustomerDetails {

	Logger logger = Logger.getLogger(InsertAdditionalCustomerDetails.class);
	
    public void insertAddCusDetails (String customerId, String fatherName, String maritalStatus, String nationality,
			String status, String grossAnnualIncome, String politicallyExposed) throws MoneyBuddyException
    {


    	logger.debug("InsertAdditionalCustomerDetails class - insertAddCusDetails method - customerId - "+customerId+" - start");
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

    	try {
			
			hibernateSession.beginTransaction();
			
			AdditionalCustomerDetails tempAdditionalCustomer = new AdditionalCustomerDetails(customerId, fatherName, maritalStatus,
						nationality, status, grossAnnualIncome,politicallyExposed);
		    hibernateSession.beginTransaction();
		    hibernateSession.saveOrUpdate(tempAdditionalCustomer);
		    hibernateSession.getTransaction().commit();
		    
    		logger.debug("InsertAdditionalCustomerDetails class - insertAddCusDetails method - customerId - "+customerId+" - new record inserted in AdditionalCustomerDetails table");
    		
    		logger.debug("InsertAdditionalCustomerDetails class - insertAddCusDetails method - customerId - "+customerId+" - end");
    	}
    	catch ( HibernateException e ) {
			logger.debug("InsertAdditionalCustomerDetails class - insertAddCusDetails method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("InsertAdditionalCustomerDetails class - insertAddCusDetails method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    	finally {
    		hibernateSession.close();
    		
    	}

    }
 
}


/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerPasswordsHistory;
import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.EntityClasses.CustomerLoginActivity;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.Subscriber;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class InsertCustomerCart {

	Logger logger = Logger.getLogger(InsertCustomerCart.class);
	
    public void addCustomerCart (String customerId, String productId, String productName, String amount,
			String cartCreationDate, String status) throws MoneyBuddyException
    {

    	logger.debug("insertCustomerCart class : addCustomerCart method : start");
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	CustomerCart tempCustomerCart = null;
    	
    	try {

    		hibernateSession.beginTransaction();
   	        tempCustomerCart = new CustomerCart(customerId,productId,productName,amount.toString(),cartCreationDate,status);
   	        hibernateSession.save(tempCustomerCart);
   	        hibernateSession.getTransaction().commit();
    		
    		logger.debug("insertCustomerCart class : addCustomerCart method : end");

    	}
    	catch ( HibernateException e ) {
			logger.debug("insertCustomerCart class : addCustomerCart method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("insertCustomerCart class : addCustomerCart method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    	finally {
    		/*if(factory!=null)
			factory.close();*/
    		//HibernateUtil.getSessionAnnotationFactory().close();
    		hibernateSession.clear();
    		hibernateSession.close();
    		
    	}

    }
 
}


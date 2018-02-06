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
import java.util.List;

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
    	
    	Session hibernateSession = null;
    	CustomerCart tempCustomerCart = null;
    	Query query ;
    	try {
    		hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    		
    		hibernateSession.beginTransaction();
    		
    		query = hibernateSession.createQuery("select distinct(productId) from CustomerCart where customerId = :customerId ");
    		query.setParameter("customerId", customerId);
    		List<String> cartProductIdList = query.list();
    		
    		hibernateSession.getTransaction().commit();
    		
    		System.out.println("amount :"+amount);
    		if ( cartProductIdList.contains(productId) )  {
    			
    			System.out.println(productId+" exist in customerCart");
    			hibernateSession.beginTransaction();
    			query = hibernateSession.createQuery("select amount from CustomerCart where customerId = :customerId and productId = :productId ");
    			query.setParameter("customerId", customerId);
    			query.setParameter("productId", productId);
    			
    			Object result = query.uniqueResult();
    			
    			if (null == result) throw new MoneyBuddyException("amount not found, which productId exsited ");
    			
    			Double updatedAmount = Double.parseDouble(result.toString()) + Double.parseDouble(amount);
    			
    			System.out.println("Existed amount : "+result.toString()+" currentAmount: "+amount+" updated amount : "+updatedAmount);
    			hibernateSession.getTransaction().commit();
    			hibernateSession.beginTransaction();
    			
    			query = hibernateSession.createQuery("update CustomerCart set amount = :amount where customerId = :customerId and productId = :productId ");
    			query.setParameter("amount", Double.toString(updatedAmount));
    			query.setParameter("customerId", customerId);
    			query.setParameter("productId", productId);
    			query.executeUpdate();
    			
    			hibernateSession.getTransaction().commit();
    			
    		}
    		else {
    			System.out.println(productId+" does not exist in customerCart");
    			
	    		hibernateSession.beginTransaction();
	   	        tempCustomerCart = new CustomerCart(customerId,productId,productName,amount,cartCreationDate,status);
	   	        hibernateSession.save(tempCustomerCart);
	   	        hibernateSession.refresh(tempCustomerCart);
	   	        
	   	        hibernateSession.getTransaction().commit();
   	        
    		}
    		
   	        
    		logger.debug("insertCustomerCart class : addCustomerCart method : end");

    	}
    	catch ( MoneyBuddyException e ) {
			logger.debug("insertCustomerCart class : addCustomerCart method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
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
    		hibernateSession.close();
    		
    	}

    }
 
}


/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerCart;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class InsertCustomerCart {

	Logger logger = Logger.getLogger(InsertCustomerCart.class);
	
    public void addCustomerCart (String customerId, String productId, String productName, String amount,
			String cartCreationDate, String status) throws MoneyBuddyException
    {

    	logger.debug("InsertCustomerCart class - addCustomerCart method - customerId - "+customerId+" - start");
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	CustomerCart tempCustomerCart = null;
    	Query query ;
    	try {
    		
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
    			logger.debug("InsertCustomerCart class - addCustomerCart method - customerId - "+customerId+" - record updated in CustomerCart table for productId - "+productId);
    			
    		}
    		else {
    			System.out.println(productId+" does not exist in customerCart");
    			
	    		hibernateSession.beginTransaction();
	   	        tempCustomerCart = new CustomerCart(customerId,productId,productName,amount,cartCreationDate,status);
	   	        hibernateSession.save(tempCustomerCart);
	   	        hibernateSession.flush();
	   	        hibernateSession.refresh(tempCustomerCart);
	   	        
	   	        hibernateSession.getTransaction().commit();
	   	        logger.debug("InsertCustomerCart class - addCustomerCart method - customerId - "+customerId+" - new record inserted in CustomerCart table");
   	        
    		}
    		
    		logger.debug("InsertCustomerCart class - addCustomerCart method - customerId - "+customerId+" - end");

    	}
    	catch ( MoneyBuddyException e ) {
    		logger.error("InsertCustomerCart class - addCustomerCart method - customerId - "+customerId+" - Caught MoneyBuddyException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    	catch ( HibernateException e ) {
    		logger.error("InsertCustomerCart class - addCustomerCart method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("InsertCustomerCart class - addCustomerCart method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

    }
 
}


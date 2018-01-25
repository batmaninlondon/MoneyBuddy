/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerCart;
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

public class QueryCustomerCart {

	Logger logger = Logger.getLogger(QueryCustomerCart.class);
		
	public List<CustomerCart> getCustomerCart(String customerId) throws MoneyBuddyException {
			
		logger.debug("QueryCustomerCart class : getCustomerCart method : start");
		Session hibernateSession = null;
		//hibernateSession.clear();
		try
		{
			
			hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
			hibernateSession.flush();
			System.out.println("customerId is : "+customerId);
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("from CustomerCart where customerId = :customerId ");
			query.setParameter("customerId", customerId);
			hibernateSession.getTransaction().commit();
			List<CustomerCart> customerCartList = query.list();
			
			
			/*for (int i=0; i<customerCartList.size(); i++){
    			CustomerCart row = (CustomerCart) customerCartList.get(i);
    		   System.out.println("Entry of fundId in customerCartList is : "+row.getProductId());
    		   System.out.println("Entry of amount in customerCartList is : "+row.getAmount());
    		   System.out.println("Entry of date in customerCartList is : "+row.getCartCreationDate());
    		}*/
			

			logger.debug("QueryCustomerCart class : getCustomerCart method : end");
			return customerCartList;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomerCart class : getCustomerCart method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomerCart class : getCustomerCart method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			hibernateSession.close();
		}
	}

}

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

public class QueryCustomerCart {

	Logger logger = Logger.getLogger(QueryCustomerCart.class);
		
	public List<CustomerCart> getCustomerCart(String customerId) throws MoneyBuddyException {
			
		logger.debug("QueryCustomerCart class - getCustomerCart method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		try
		{
			hibernateSession.flush();
			System.out.println("customerId is : "+customerId);
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("from CustomerCart where customerId = :customerId ");
			query.setParameter("customerId", customerId);
			hibernateSession.getTransaction().commit();
			List<CustomerCart> customerCartList = query.list();
			
			Double totalAmount = 0.0;
			
			for (int i = 0; i < customerCartList.size(); i++) {
				CustomerCart customerCartListElement = customerCartList.get(i);
				totalAmount += Double.parseDouble(customerCartListElement.getAmount());
			}
			
			customerCartList.add(new CustomerCart(null,null,"Total",totalAmount.toString(),null,null));
			
			logger.debug("QueryCustomerCart class - getCustomerCart method - customerId - "+customerId+" - returns customerCartList of - "+(customerCartList.size()-1)+" records");
			logger.debug("QueryCustomerCart class - getCustomerCart method - customerId - "+customerId+" - end");
			
			return customerCartList;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomerCart class - getCustomerCart method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomerCart class - getCustomerCart method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}

}

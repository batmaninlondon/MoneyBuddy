/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerPortfolio;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class QueryCustomerPortfolio {
	
	Logger logger = Logger.getLogger(QueryCustomerPortfolio.class);

	public boolean existsGroupName(String groupName) throws MoneyBuddyException {
		
		logger.debug("QueryCustomerPortfolio class : existsGroupName method : start");
		
		SessionFactory factoryCustomerPortfolio = new AnnotationConfiguration()
														.configure()
														.addAnnotatedClass(CustomerPortfolio.class)
														.buildSessionFactory();
		Session sessionCustomerPortfolio = factoryCustomerPortfolio.openSession();

		try
		{
			sessionCustomerPortfolio.beginTransaction();
			Query query = sessionCustomerPortfolio.createQuery("from CustomerPortfolio where investmentTypeName = :groupName");
			query.setParameter("groupName",groupName);
			List<CustomerPortfolio> customerPortfolioList = query.list();

			if (customerPortfolioList.size() != 0)  
			{
				return true;
			}
			sessionCustomerPortfolio.getTransaction().commit();
			
			logger.debug("QueryCustomerPortfolio class : existsGroupName method : end");
			return false;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomerPortfolio class : existsGroupName method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomerPortfolio class : existsGroupName method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(factoryCustomerPortfolio!=null)
				factoryCustomerPortfolio.close();
		}

	}
    
	public List<String> getGroupNameList(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomerPortfolio class : getGroupNameList method : start");
		
		SessionFactory factory = new AnnotationConfiguration()
										.configure()
										.addAnnotatedClass(CustomerPortfolio.class)
										.buildSessionFactory();
		Session session = factory.openSession();



		try
		{
			session.beginTransaction();
			Query query = session.createQuery("select c.investmentTypeName from CustomerPortfolio c  where customerId = :customerId group by c.investmentTypeName");
			query.setParameter("customerId",customerId);

			List<String> groupNamesList = query.list();

			for(String groupName : groupNamesList){
				System.out.println(" Group Name in the list is : "+groupName);
			}
			
			session.getTransaction().commit();

			logger.debug("QueryCustomerPortfolio class : getGroupNameList method : end");
			return groupNamesList;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomerPortfolio class : getGroupNameList method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomerPortfolio class : getGroupNameList method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(factory!=null)
				factory.close();

		}

	}

}
/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerPasswordsHistory;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class QueryCustomer {

	Logger logger = Logger.getLogger(QueryCustomer.class);
		
	public String getPassword(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class : getPassword method : start");
		
		SessionFactory factory = new AnnotationConfiguration()
										.configure()
										.addAnnotatedClass(CustomerPasswordsHistory.class)
										.buildSessionFactory();
		Session session = factory.openSession();

		try
		{
			session.beginTransaction();
			QueryCustomer queryUser = new QueryCustomer();
			String customerId = queryUser.getCustomerId(emailId);
			CustomerPasswordsHistory customer = (CustomerPasswordsHistory)session.get(CustomerPasswordsHistory.class,customerId);
			String password = customer.getPassword();
			session.getTransaction().commit();
			
			logger.debug("QueryCustomer class : getPassword method : end");
			return password;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class : getPassword method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class : getPassword method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(factory!=null)
				factory.close();
		}
	}

	public String getHashedPassword(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class : getHashedPassword method : start");
		
		SessionFactory factory = new AnnotationConfiguration()
										.configure()
										.addAnnotatedClass(Customers.class)
										.buildSessionFactory();
		Session session = factory.openSession();

		try
		{
			session.beginTransaction();
			QueryCustomer queryCustomer = new QueryCustomer();
			String customerId = queryCustomer.getCustomerId(emailId);
			Customers user = (Customers)session.get(Customers.class,customerId);
			String hashedPassword = user.getPassword();
			session.getTransaction().commit();
			
			logger.debug("QueryCustomer class : getHashedPassword method : end");
			return hashedPassword;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class : getHashedPassword method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class : getHashedPassword method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(factory!=null)
				factory.close();
		}

	}
        
	public String getCustomerId(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class : getCustomerId method : start");
		
		SessionFactory factory = new AnnotationConfiguration()
										.configure()
										.addAnnotatedClass(Customers.class)
										.buildSessionFactory();
		Session session = factory.openSession();

		String customerId =  null;

		try
		{
			session.beginTransaction();
			Query query = session.createQuery("from Customers where emailId = :emailId");
			query.setParameter("emailId",emailId);
			List<Customers> customersList = query.list();

			for(Customers customer : customersList){
				customerId =   customer.getCustomerId();
			}

			session.getTransaction().commit();
			
			logger.debug("QueryCustomer class : getCustomerId method : end");
			return customerId;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class : getCustomerId method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class : getCustomerId method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(factory!=null)
				factory.close();
		}

	}
	
	public String getCustomerName(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class : getCustomerName method : start");
		
		SessionFactory factory = new AnnotationConfiguration()
										.configure()
										.addAnnotatedClass(Customers.class)
										.buildSessionFactory();
		Session session = factory.openSession();

		String customerName =  null;


		try
		{
			session.beginTransaction();
			Query query = session.createQuery("from Customers where emailId = :emailId");
			query.setParameter("emailId",emailId);
			List<Customers> customersList = query.list();

			for(Customers customer : customersList){
				customerName = customer.getFirstName()+customer.getLastName();
			}

			session.getTransaction().commit();
			
			logger.debug("QueryCustomer class : getCustomerName method : end");
			return customerName;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class : getCustomerName method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class : getCustomerName method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(factory!=null)
				factory.close();
		}

	}
	
	public String getCustomerMobileNumber(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class : getCustomerMobileNumber method : start");
		
		SessionFactory factory = new AnnotationConfiguration()
										.configure()
										.addAnnotatedClass(Customers.class)
										.buildSessionFactory();
		Session session = factory.openSession();

		String customerMobileNumber =  null;


		try
		{
			session.beginTransaction();
			Query query = session.createQuery("from Customers where emailId = :emailId");
			query.setParameter("emailId",emailId);
			List<Customers> customersList = query.list();

			for(Customers customer : customersList){
				customerMobileNumber = customer.getMobileNumber();
			}

			session.getTransaction().commit();
			
			logger.debug("QueryCustomer class : getCustomerMobileNumber method : end");
			return customerMobileNumber;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class : getCustomerMobileNumber method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class : getCustomerMobileNumber method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(factory!=null)
				factory.close();
		}

	}

	public String getVerificationStatus(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class : getVerificationStatus method : start");
		
		SessionFactory factory = new AnnotationConfiguration()
										.configure()
										.addAnnotatedClass(Customers.class)
										.buildSessionFactory();
		Session session = factory.openSession();

		try
		{
			session.beginTransaction();

			QueryCustomer queryCustomer = new QueryCustomer();
			String customerId = queryCustomer.getCustomerId(emailId);
			Customers customer = (Customers)session.get(Customers.class,customerId);
			String verificationStatus = customer.getVerificationStatus();
			session.getTransaction().commit();
			
			logger.debug("QueryCustomer class : getVerificationStatus method : end");
			return verificationStatus;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class : getVerificationStatus method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class : getVerificationStatus method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(factory!=null)
				factory.close();
		}

	}

	public boolean existsCustomer(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class : existsUser method : start");
		
		SessionFactory factory = new AnnotationConfiguration()
										.configure()
										.addAnnotatedClass(Customers.class)
										.buildSessionFactory();
		Session session = factory.openSession();

		try
		{
			session.beginTransaction();
			QueryCustomer queryUser = new QueryCustomer();
			String customerId = queryUser.getCustomerId(emailId);
			System.out.println("QueryCustomer class : existsUser method : customerId : "+customerId);
			Customers customer = (Customers)session.get(Customers.class,customerId);
			System.out.println("QueryCustomer class : existsUser method : customer : "+customer.getCustomerId());
			if (customer == null ) {
				return false;
			}

			session.getTransaction().commit();
			
			logger.debug("QueryCustomer class : existsUser method : end");
			return true;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class : existsCustomer method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class : existsCustomer method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(factory!=null)
				factory.close();
		}

	}

}

/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

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

public class QueryCustomer {

	Logger logger = Logger.getLogger(QueryCustomer.class);
		
	public Customers getCustomer(String emailId) throws MoneyBuddyException {
			
		logger.debug("QueryCustomer class : getCustomer method : start");
		Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
	
		Customers customer = new Customers();
	
	
		try
		{
			session.beginTransaction();
			customer = (Customers) session.createQuery("from Customers where emailId = '"+emailId+"'").uniqueResult();
	
			//session.getTransaction().commit();
			
			logger.debug("QueryCustomer class : getCustomer method : end");
			return customer;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class : getCustomer method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class : getCustomer method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();
		}
	}



	public String getPassword(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class : getPassword method : start");
		
		Session session =  HibernateUtil.getSessionAnnotationFactory().openSession();
	

		try
		{
			session.beginTransaction();
			QueryCustomer queryUser = new QueryCustomer();
			int customerId = queryUser.getCustomerId(emailId);
			CustomerPasswordsHistory customer = (CustomerPasswordsHistory)session.get(CustomerPasswordsHistory.class,Integer.toString(customerId));
			String password = customer.getPassword();
			//session.getTransaction().commit();
			
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
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();
		}
	}

	public String getHashedPassword(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class : getHashedPassword method : start");
		
		Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			session.beginTransaction();
			QueryCustomer queryCustomer = new QueryCustomer();
			int customerId = queryCustomer.getCustomerId(emailId);
			Customers user = (Customers)session.get(Customers.class,Integer.toString(customerId));
			String hashedPassword = user.getPassword();
			//session.getTransaction().commit();
			
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
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();
		}

	}
        
	public int getCustomerId(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class : getCustomerId method : start");
		
		Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

		Object result;
		int customerId =0 ;

		try
		{
			session.beginTransaction();
			result = session.createQuery("select customerId from Customers where emailId = '"+emailId+"'").uniqueResult();
			
			if (result != null)
				customerId = Integer.parseInt(result.toString());
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
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();
		}

	}
	
	public String getCustomerName(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class : getCustomerName method : start");
		
		Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

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

			//session.getTransaction().commit();
			
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
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();
		}

	}
	
	public String getCustomerMobileNumber(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class : getCustomerMobileNumber method : start");
		
		Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

		Object result;
		String customerMobileNumber =  null;


		try
		{
			session.beginTransaction();
			result = session.createQuery("select mobileNumber from Customers where emailId = '"+emailId+"'").uniqueResult();

			if ( result != null )
				customerMobileNumber = result.toString();
			
			//session.getTransaction().commit();
			
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
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();
		}

	}

	public String getVerificationStatus(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class : getVerificationStatus method : start");
		
		Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			session.beginTransaction();

			QueryCustomer queryCustomer = new QueryCustomer();
			int customerId = queryCustomer.getCustomerId(emailId);
			Customers customer = (Customers)session.get(Customers.class,Integer.toString(customerId));
			String verificationStatus = customer.getVerificationStatus();
			//session.getTransaction().commit();
			
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
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();
		}

	}

	public boolean existsCustomer(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class : existsUser method : start");
		
		Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			session.beginTransaction();
			QueryCustomer queryUser = new QueryCustomer();
			int customerId = queryUser.getCustomerId(emailId);
			System.out.println("QueryCustomer class : existsUser method : customerId : "+customerId);
			Customers customer = (Customers)session.get(Customers.class,Integer.toString(customerId));
			//System.out.println("QueryCustomer class : existsUser method : customer : "+customer.getCustomerId());
			if (customer == null ) {
				System.out.println("QueryCustomer class : existsUser method : customer is null ");
				return false;
			}
			System.out.println("QueryCustomer class : existsUser method : customer is not null");
			//session.getTransaction().commit();
			
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
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();
		}

	}
	
public boolean existsMobileNumber(String mobileNumber) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class : existsMobileNumber method : start");
		
		Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{

			session.beginTransaction();
			
			Query query = session.createQuery("select mobileNumber from Customers");
			
			List<String> mobileNumberList = query.list();
			//session.getTransaction().commit();
			for (String mobileNum : mobileNumberList)  {

				if (mobileNum.equals(mobileNumber) ) {
					System.out.println("QueryCustomer class : existsMobileNumber method : Mobile number already exists ");
					return true;
				}
			}

			System.out.println("QueryCustomer class : existsMobileNumber method : Mobile number does not exists ");
			
			
			logger.debug("QueryCustomer class : existsMobileNumber method : end");
			return false;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class : existsMobileNumber method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class : existsMobileNumber method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();
		}

	}

}

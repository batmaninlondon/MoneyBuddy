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

public class QueryCustomer {

	Logger logger = Logger.getLogger(QueryCustomer.class);
		
	public Customers getCustomerFromEmailId(String emailId) throws MoneyBuddyException {
			
		logger.debug("QueryCustomer class - getCustomerFromEmailId method - emailId - "+emailId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		hibernateSession.clear();

		try
		{
			Customers customer = new Customers();
			System.out.println("Email id is : "+emailId);
			hibernateSession.beginTransaction();
			customer = (Customers) hibernateSession.createQuery("from Customers where emailId = '"+emailId+"'").uniqueResult();
	
			System.out.println("customer.getEmailId() : "+customer.getEmailId());
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - getCustomerFromEmailId method - emailId - "+emailId+" - return Customers record");
			logger.debug("QueryCustomer class - getCustomerFromEmailId method - emailId - "+emailId+" - end");
			
			return customer;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class - getCustomerFromEmailId method - emailId - "+emailId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class - getCustomerFromEmailId method - emailId - "+emailId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}
	}

	public Customers getCustomerFromCustomerId(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getCustomerFromCustomerId method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		hibernateSession.clear();
		
		Customers customer = new Customers();
		try
		{
			System.out.println("customerId is : "+customerId);
			hibernateSession.beginTransaction();
			customer = (Customers) hibernateSession.get(Customers.class, customerId);
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - getCustomerFromCustomerId method - customerId - "+customerId+" - return Customers record");
			logger.debug("QueryCustomer class - getCustomerFromCustomerId method - customerId - "+customerId+" - end");
			
			return customer;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class - getCustomerFromCustomerId method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class - getCustomerFromCustomerId method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}
	}

	public String getPassword(String emailId) throws MoneyBuddyException {

		Session hibernateSession =  HibernateUtil.getSessionAnnotationFactory().openSession();
		String customerId = null;

		try
		{
			QueryCustomer queryUser = new QueryCustomer();
			customerId = Integer.toString(queryUser.getCustomerId(emailId));
			logger.debug("QueryCustomer class - getPassword method - customerId - "+customerId+" - start");
			
			hibernateSession.beginTransaction();
			
			CustomerPasswordsHistory customer = (CustomerPasswordsHistory)hibernateSession.get(CustomerPasswordsHistory.class,customerId);
			String password = customer.getPassword();
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - getPassword method - customerId - "+customerId+" - retrun password");
			logger.debug("QueryCustomer class - getPassword method - customerId - "+customerId+" - end");
			
			return password;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class - getPassword method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class - getPassword method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}
	}
	
	
	public String getBseClientCreationStatus(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getBseClientCreationStatus method - customerId - "+customerId+" - start");
		
		Session hibernateSession =  HibernateUtil.getSessionAnnotationFactory().openSession();
	

		try
		{
			hibernateSession.beginTransaction();
			Customers customer = (Customers)hibernateSession.get(Customers.class,customerId);
			String bseClientCreationStatus = customer.getBseClientCreated();
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - getBseClientCreationStatus method - customerId - "+customerId+" - return bseClientCreationStatus ");
			logger.debug("QueryCustomer class - getBseClientCreationStatus method - customerId - "+customerId+" - end");
			
			return bseClientCreationStatus;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class - getBseClientCreationStatus method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class - getBseClientCreationStatus method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}
	}
	
	public String getIsipMandateId(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getIsipMandateId method - customerId - "+customerId+" - start");
		
		Session hibernateSession =  HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			hibernateSession.beginTransaction();
			Customers customer = (Customers)hibernateSession.get(Customers.class,customerId);
			String isipMandateId = customer.getIsipMandateId();
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - getIsipMandateId method - customerId - "+customerId+" - return isipMandateId ");
			logger.debug("QueryCustomer class - getIsipMandateId method - customerId - "+customerId+" - end");
			
			return isipMandateId;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class - getIsipMandateId method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class - getIsipMandateId method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}
	}

	public String getHashedPassword(String emailId) throws MoneyBuddyException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		String customerId = null;
		
		try
		{
			QueryCustomer queryCustomer = new QueryCustomer();
			customerId = Integer.toString(queryCustomer.getCustomerId(emailId));
			logger.debug("QueryCustomer class - getHashedPassword method - customerId - "+customerId+" - start");
			hibernateSession.beginTransaction();
			
			Customers user = (Customers)hibernateSession.get(Customers.class,customerId);
			String hashedPassword = user.getPassword();
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - getHashedPassword method - customerId - "+customerId+" - return hashedPassword ");
			logger.debug("QueryCustomer class - getHashedPassword method - customerId - "+customerId+" - end");
			
			return hashedPassword;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class - getHashedPassword method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class - getHashedPassword method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}

	}
        
	public int getCustomerId(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getCustomerId method - emailId - "+emailId+" - start");
		Session hibernateSession = null;

		Object result;
		int customerId =0 ;

		try
		{
			hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
			hibernateSession.beginTransaction();
			System.out.println("HI there 1 + emailID : "+emailId);
			result = hibernateSession.createQuery("select customerId from Customers where emailId = '"+emailId+"'").uniqueResult();
			hibernateSession.getTransaction().commit();

			if (result != null) {
				System.out.println("HI there 1"+result.toString());
				customerId = Integer.parseInt(result.toString());
			}
				
			logger.debug("QueryCustomer class - getCustomerId method - emailId - "+emailId+" - return customerId - "+customerId);
			logger.debug("QueryCustomer class - getCustomerId method - emailId - "+emailId+" - end");
			
			return customerId;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class - getCustomerId method - emailId - "+emailId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class - getCustomerId method - emailId - "+emailId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.clear();
			hibernateSession.close();
		}

	}
	
	public String getCustomerName(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getCustomerName method - emailId - "+emailId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		String customerName =  null;

		try
		{
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("from Customers where emailId = :emailId");
			query.setParameter("emailId",emailId);
			List<Customers> customersList = query.list();

			for(Customers customer : customersList){
				customerName = customer.getCustomerName();
			}

			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - getCustomerName method - emailId - "+emailId+" - returns customerName - "+customerName);
			logger.debug("QueryCustomer class - getCustomerName method - emailId - "+emailId+" - end");
			
			return customerName;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class - getCustomerName method - emailId - "+emailId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class - getCustomerName method - emailId - "+emailId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}

	}
	
	public String getCustomerMobileNumber(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getCustomerMobileNumber method - emailId - "+emailId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		Object result;
		String customerMobileNumber =  null;


		try
		{
			hibernateSession.beginTransaction();
			result = hibernateSession.createQuery("select mobileNumber from Customers where emailId = '"+emailId+"'").uniqueResult();

			if ( result != null )
				customerMobileNumber = result.toString();
			
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - getCustomerMobileNumber method - emailId - "+emailId+" - return customerMobileNumber - "+customerMobileNumber);
			logger.debug("QueryCustomer class - getCustomerMobileNumber method - emailId - "+emailId+" - end");
			
			return customerMobileNumber;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class - getCustomerMobileNumber method - emailId - "+emailId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class - getCustomerMobileNumber method - emailId - "+emailId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}

	}

	public String getVerificationStatus(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getVerificationStatus method - emailId - "+emailId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			hibernateSession.beginTransaction();

			QueryCustomer queryCustomer = new QueryCustomer();
			int customerId = queryCustomer.getCustomerId(emailId);
			Customers customer = (Customers)hibernateSession.get(Customers.class,Integer.toString(customerId));
			String verificationStatus = customer.getVerificationStatus();
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - getVerificationStatus method - emailId - "+emailId+" - returns verificationStatus - "+verificationStatus);
			logger.debug("QueryCustomer class - getVerificationStatus method - emailId - "+emailId+" - end");
			
			return verificationStatus;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class - getVerificationStatus method - emailId - "+emailId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class - getVerificationStatus method - emailId - "+emailId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}

	}

	public boolean existsCustomer(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - existsCustomer method - emailId - "+emailId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			hibernateSession.beginTransaction();
			QueryCustomer queryUser = new QueryCustomer();
			int customerId = queryUser.getCustomerId(emailId);
			System.out.println("QueryCustomer class : existsUser method : customerId : "+customerId);
			Customers customer = (Customers)hibernateSession.get(Customers.class,Integer.toString(customerId));
			if (customer == null ) {
				System.out.println("QueryCustomer class : existsUser method : customer is null ");
				
				logger.debug("QueryCustomer class - existsCustomer method - emailId - "+emailId+" - customer does not exists returns false");
				logger.debug("QueryCustomer class - existsCustomer method - emailId - "+emailId+" - end");
				return false;
			}
			System.out.println("QueryCustomer class : existsUser method : customer is not null");
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - existsCustomer method - emailId - "+emailId+" - customer exists returns true");
			logger.debug("QueryCustomer class - existsCustomer method - emailId - "+emailId+" - end");
			
			return true;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class - existsCustomer method - emailId - "+emailId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class - existsCustomer method - emailId - "+emailId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}

	}
	
	public boolean existsMobileNumber(String mobileNumber) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - existsMobileNumber method - mobileNumber - "+mobileNumber+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{

			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("select mobileNumber from Customers");
			
			List<String> mobileNumberList = query.list();
			hibernateSession.getTransaction().commit();
			for (String mobileNum : mobileNumberList)  {

				if (mobileNum.equals(mobileNumber) ) {
					System.out.println("QueryCustomer class : existsMobileNumber method : Mobile number already exists ");
					
					logger.debug("QueryCustomer class - existsMobileNumber method - mobileNumber - "+mobileNumber+" - mobile number exists returns true");
					logger.debug("QueryCustomer class - existsMobileNumber method - mobileNumber - "+mobileNumber+" - end");
					return true;
				}
			}

			System.out.println("QueryCustomer class : existsMobileNumber method : Mobile number does not exists ");
			
			logger.debug("QueryCustomer class - existsMobileNumber method - mobileNumber - "+mobileNumber+" - mobile number does not exists returns false");
			logger.debug("QueryCustomer class - existsMobileNumber method - mobileNumber - "+mobileNumber+" - end");
			
			return false;
		}
		catch ( HibernateException e ) {
			logger.debug("QueryCustomer class - existsMobileNumber method - mobileNumber - "+mobileNumber+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryCustomer class - existsMobileNumber method - mobileNumber - "+mobileNumber+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();
		}

	}

}

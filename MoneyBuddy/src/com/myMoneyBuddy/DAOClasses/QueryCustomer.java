/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.CustomerPasswordsHistory;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.PendingAofOrders;
import com.myMoneyBuddy.ModelClasses.PendingMandateOrders;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class QueryCustomer {

	Logger logger = LogManager.getLogger(QueryCustomer.class);
		
	public Customers getCustomerFromEmailId(String emailId) throws MoneyBuddyException {
			
		logger.debug("QueryCustomer class - getCustomerFromEmailId method - emailId - "+emailId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			Customers customer = new Customers();
			System.out.println("Email id is : "+emailId);
			hibernateSession.beginTransaction();
			customer = (Customers) hibernateSession.createQuery("from Customers where emailId = '"+emailId+"'").uniqueResult();

			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - getCustomerFromEmailId method - emailId - "+emailId+" - return Customers record");
			logger.debug("QueryCustomer class - getCustomerFromEmailId method - emailId - "+emailId+" - end");
			
			return customer;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - getCustomerFromEmailId method - emailId - "+emailId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getCustomerFromEmailId method - emailId - "+emailId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
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
			logger.error("QueryCustomer class - getCustomerFromCustomerId method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getCustomerFromCustomerId method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}

	public String getPassword(String emailId) throws MoneyBuddyException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
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
			logger.error("QueryCustomer class - getPassword method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getPassword method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
		
	public String getBseClientCreationStatus(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getBseClientCreationStatus method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	
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
			logger.error("QueryCustomer class - getBseClientCreationStatus method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getBseClientCreationStatus method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public String getUserTypeFromCustomerId(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getUserTypeFromCustomerId method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	
		try
		{
			hibernateSession.beginTransaction();
			Customers customer = (Customers)hibernateSession.get(Customers.class,customerId);
			String userType = customer.getUserType();
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - getUserTypeFromCustomerId method - customerId - "+customerId+" - return userType ");
			logger.debug("QueryCustomer class - getUserTypeFromCustomerId method - customerId - "+customerId+" - end");
			
			return userType;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - getUserTypeFromCustomerId method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getUserTypeFromCustomerId method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}

	public String getCustomerEmailId(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getCustomerEmailId method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	
		try
		{
			hibernateSession.beginTransaction();
			Customers customer = (Customers)hibernateSession.get(Customers.class,customerId);
			String emailId = customer.getEmailId();
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - getCustomerEmailId method - customerId - "+customerId+" - return emailId - "+emailId);
			logger.debug("QueryCustomer class - getCustomerEmailId method - customerId - "+customerId+" - end");
			
			return emailId;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - getCustomerEmailId method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getCustomerEmailId method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public String getAofFormStatus(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getAofFormStatus method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	
		try
		{
			hibernateSession.beginTransaction();
			Customers customer = (Customers)hibernateSession.get(Customers.class,customerId);
			String aofFormStatus = customer.getAofFormStatus();
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - getAofFormStatus method - customerId - "+customerId+" - return aofFormStatus - "+aofFormStatus);
			logger.debug("QueryCustomer class - getAofFormStatus method - customerId - "+customerId+" - end");
			
			return aofFormStatus;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - getAofFormStatus method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getAofFormStatus method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public String getKycStatus(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getKycStatus method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	
		try
		{
			hibernateSession.beginTransaction();
			Customers customer = (Customers)hibernateSession.get(Customers.class,customerId);
			String kycStatus = customer.getKycStatus();
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - getKycStatus method - customerId - "+customerId+" - return kycStatus ");
			logger.debug("QueryCustomer class - getKycStatus method - customerId - "+customerId+" - end");
			
			return kycStatus;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - getKycStatus method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getKycStatus method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public String getIsipMandateId(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getIsipMandateId method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

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
			logger.error("QueryCustomer class - getIsipMandateId method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getIsipMandateId method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public String getCustomerNameFromId(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getCustomerNameFromId method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			hibernateSession.beginTransaction();
			Customers customer = (Customers)hibernateSession.get(Customers.class,customerId);
			String customerName = customer.getCustomerName();
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryCustomer class - getCustomerNameFromId method - customerId - "+customerId+" - return customerName ");
			logger.debug("QueryCustomer class - getCustomerNameFromId method - customerId - "+customerId+" - end");
			
			return customerName;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - getCustomerNameFromId method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getCustomerNameFromId method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	
	public String getAoFFormName(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getAoFFormName method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		String aoFFormName;
		try
		{
			hibernateSession.beginTransaction();
			String kycStatus = hibernateSession.createQuery("select kycStatus from Customers where customerId = '"+customerId+"'").uniqueResult().toString();
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			String taxStatus = hibernateSession.createQuery("select taxStatus from CustomerDetails where customerId = '"+customerId+"'").uniqueResult().toString();
			hibernateSession.getTransaction().commit();
			
			if ("Individual".equalsIgnoreCase(taxStatus))  {
				if ("DONE".equalsIgnoreCase(kycStatus))  
					aoFFormName = "Account_Opening_Form_1";
				else 
					aoFFormName = "Account_Opening_Form_2"; 
			}
			else {
				if ("DONE".equalsIgnoreCase(kycStatus))  
					aoFFormName = "Account_Opening_Form_3";
				else 
					aoFFormName = "Account_Opening_Form_4"; 
			}
			logger.debug("QueryCustomer class - getAoFFormName method - customerId - "+customerId+" - return customerName ");
			logger.debug("QueryCustomer class - getAoFFormName method - customerId - "+customerId+" - end");
			
			return aoFFormName;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - getAoFFormName method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getAoFFormName method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
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
			logger.error("QueryCustomer class - getHashedPassword method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getHashedPassword method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
        
	public int getCustomerId(String emailId) throws MoneyBuddyException {
		
		logger.debug("QueryCustomer class - getCustomerId method - emailId - "+emailId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		Object result;
		int customerId =0 ;

		try
		{
			
			hibernateSession.beginTransaction();
			result = hibernateSession.createQuery("select customerId from Customers where emailId = '"+emailId+"'").uniqueResult();
			hibernateSession.getTransaction().commit();

			if (result != null) 
				customerId = Integer.parseInt(result.toString());
				
			logger.debug("QueryCustomer class - getCustomerId method - emailId - "+emailId+" - return customerId - "+customerId);
			logger.debug("QueryCustomer class - getCustomerId method - emailId - "+emailId+" - end");
			
			return customerId;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - getCustomerId method - emailId - "+emailId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getCustomerId method - emailId - "+emailId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
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
			logger.error("QueryCustomer class - getCustomerName method - emailId - "+emailId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getCustomerName method - emailId - "+emailId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
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
			logger.error("QueryCustomer class - getCustomerMobileNumber method - emailId - "+emailId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getCustomerMobileNumber method - emailId - "+emailId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
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
			logger.error("QueryCustomer class - getVerificationStatus method - emailId - "+emailId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getVerificationStatus method - emailId - "+emailId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
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
			hibernateSession.getTransaction().commit();
			if (customer == null ) {
				System.out.println("QueryCustomer class : existsUser method : customer is null ");
				
				logger.debug("QueryCustomer class - existsCustomer method - emailId - "+emailId+" - customer does not exists returns false");
				logger.debug("QueryCustomer class - existsCustomer method - emailId - "+emailId+" - end");
				return false;
			}
			System.out.println("QueryCustomer class : existsUser method : customer is not null");
			
			
			logger.debug("QueryCustomer class - existsCustomer method - emailId - "+emailId+" - customer exists returns true");
			logger.debug("QueryCustomer class - existsCustomer method - emailId - "+emailId+" - end");
			
			return true;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - existsCustomer method - emailId - "+emailId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - existsCustomer method - emailId - "+emailId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
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
			logger.error("QueryCustomer class - existsMobileNumber method - mobileNumber - "+mobileNumber+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - existsMobileNumber method - mobileNumber - "+mobileNumber+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	
	public List<PendingMandateOrders> getPendingMandate() throws MoneyBuddyException {
		
		 
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		List<PendingMandateOrders> pendingMandateOrders = new LinkedList<PendingMandateOrders>();
	
		try
		{
			logger.debug("QueryCustomer class - getPendingMandate method - start");
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select customerId, customerName, mandateCreationDate, mandateAmount, isipMandateId "
					+ " from Customers where mandateIdStatus='GENERATED'");
			
			List<Object[]> customersList = query.list();
			String customerId = "";
			String customerName = "";
			String mandateCreationDate = "";
			String mandateAmount = "";
			String mandateId = "";
			
			for ( int i = 0; i < customersList.size() ;i++ ) {
				
				customerId = customersList.get(i)[0].toString();
				customerName = customersList.get(i)[1].toString();
				mandateCreationDate = customersList.get(i)[2].toString();
				mandateAmount = customersList.get(i)[3].toString();
				mandateId = customersList.get(i)[4].toString();
				
				pendingMandateOrders.add( new PendingMandateOrders(customerId,customerName,mandateId,mandateCreationDate,mandateAmount));
				
			}
			
			hibernateSession.getTransaction().commit();
			
			
			logger.debug("QueryCustomer class - getPendingMandate method - return pendingMandateOrders for mandateIdStatus GENERATED ");
			logger.debug("QueryCustomer class - getPendingMandate method - end");
			
			return pendingMandateOrders;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - getPendingMandate method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getPendingMandate method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}

	public List<PendingAofOrders> getPendingAof() throws MoneyBuddyException {
		
		 
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		List<PendingAofOrders> pendingAofOrders = new LinkedList<PendingAofOrders>();
	
		try
		{
			logger.debug("QueryCustomer class - getPendingAof method - start");
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select customerId, customerName, aofCreationDate "
					+ " from Customers where aofFormStatus='FORM_SENT'");
			
			List<Object[]> customersList = query.list();
			String customerId = "";
			String customerName = "";
			String aofCreationDate = "";
			
			for ( int i = 0; i < customersList.size() ;i++ ) {
				
				customerId = customersList.get(i)[0].toString();
				customerName = customersList.get(i)[1].toString();
				aofCreationDate = customersList.get(i)[2].toString();
				
				pendingAofOrders.add( new PendingAofOrders(customerId,customerName,aofCreationDate));
				
			}
			
			hibernateSession.getTransaction().commit();
			
			
			logger.debug("QueryCustomer class - getPendingAof method - return pendingAofOrders for aofFormStatus FORM_SENT ");
			logger.debug("QueryCustomer class - getPendingAof method - end");
			
			return pendingAofOrders;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - getPendingAof method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getPendingAof method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}

	public String getEmailId (String hashedPassword) throws MoneyBuddyException {

    	logger.debug("QueryCustomer class - getEmailId method - start");
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {
			
			hibernateSession.beginTransaction();
			Object result = hibernateSession.createQuery("select emailId from Customers where password = '"+hashedPassword+"'").uniqueResult();
			hibernateSession.getTransaction().commit();
			String emailId ;
			if (result != null) 
				emailId  = result.toString();
			else {
				emailId = "NotExist";
			}
			System.out.println("Value of emailId is : "+emailId);
    		
			logger.debug("QueryCustomer class - getEmailId method - end");
			
			return emailId;
		}
		catch ( HibernateException e ) {
			logger.error("QueryCustomer class - getEmailId method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryCustomer class - getEmailId method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
}

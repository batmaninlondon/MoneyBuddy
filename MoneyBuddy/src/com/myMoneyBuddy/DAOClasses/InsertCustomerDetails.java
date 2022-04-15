/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.CustomerLoginActivity;
import com.myMoneyBuddy.EntityClasses.CustomerPasswordsHistory;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.Subscriber;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class InsertCustomerDetails {

	Logger logger = LogManager.getLogger(InsertCustomerDetails.class);

    public String insertCustomer (String emailId) throws MoneyBuddyException
    {
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		String customerId = null;
    	try {
    		
    		logger.debug("InsertCustomerDetails class - insertCustomer method - customerId - "+customerId+" - start");
    		
    		hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    		hibernateSession.beginTransaction();
        	
    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		Date date = new Date();
    		String frmtdDate = dateFormat.format(date);

    		Customers tempCustomer = new Customers(emailId,null,null,null,"N",null,"NC","N","N","CUSTOMER","N","N","N",null,"CLIENT",
    				"NOT_ACTIVATED",null,null,null,"NOT_ACTIVATED");

    		hibernateSession.save(tempCustomer);
    		hibernateSession.getTransaction().commit();

    		
    		
    		hibernateSession.close();
    		
    		hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

    		QueryCustomer queryCustomer = new QueryCustomer();
    		customerId = Integer.toString(queryCustomer.getCustomerId(emailId));
    		
    		logger.debug("InsertCustomerDetails class - insertCustomer method - customerId - "+customerId+" - new record inserted in Customers table");
    		
    		hibernateSession.beginTransaction();
    		
    		Subscriber tempSubscriber = new Subscriber(emailId,"CUSTOMER",frmtdDate);

    		hibernateSession.save(tempSubscriber);
    		hibernateSession.getTransaction().commit();
    		
    		logger.debug("InsertCustomerDetails class - insertCustomer method - customerId - "+customerId+" - new record inserted in Subscriber table");
    		
    		System.out.println("insertCustomerDetails class : insertCustomer method : emailId : "+emailId);
    		System.out.println("insertCustomerDetails class : insertCustomer method : customerId : "+customerId);

    		CustomerPasswordsHistory tempUserPasswords = new CustomerPasswordsHistory(customerId,null,null);
    		hibernateSession.beginTransaction();
    		hibernateSession.save(tempUserPasswords);

    		hibernateSession.getTransaction().commit();
    		
    		logger.debug("InsertCustomerDetails class - insertCustomer method - customerId - "+customerId+" - new record inserted in CustomerPasswordsHistory table");

    		CustomerLoginActivity tempUserTimeDetails = new CustomerLoginActivity(customerId,null,frmtdDate);

    		hibernateSession.beginTransaction();
    		hibernateSession.save(tempUserTimeDetails);
    		hibernateSession.getTransaction().commit();
    		
    		logger.debug("InsertCustomerDetails class - insertCustomer method - customerId - "+customerId+" - new record inserted in CustomerLoginActivity table");
    		
    		logger.debug("InsertCustomerDetails class - insertCustomer method - customerId - "+customerId+" - end");
    		
    		return customerId;

    	}
    	catch ( HibernateException e ) {
    		logger.error("InsertCustomerDetails class - insertCustomer method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("InsertCustomerDetails class - insertCustomer method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

    }
    
    public void updateVerificationStatusFromEmailId (String emailId) throws MoneyBuddyException {

    	logger.debug("InsertCustomerDetails class - updateVerificationStatusFromEmailId method - start");
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			hibernateSession.beginTransaction();

			Query query = hibernateSession.createQuery("update Customers set verificationStatus = :verificationStatus where emailId = :emailId");

			query.setParameter("verificationStatus", "Y");

			query.setParameter("emailId", emailId);

			int result = query.executeUpdate();
			
			System.out.println(result+" rows updated !! ");

			hibernateSession.getTransaction().commit();
			
		}
		catch ( HibernateException e ) {
			logger.error("InsertCustomerDetails class - updateVerificationStatusFromEmailId method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("InsertCustomerDetails class - updateVerificationStatusFromEmailId method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
    
    
    
    public void updateVerificationStatus (String customerId) throws MoneyBuddyException {

    	logger.debug("InsertCustomerDetails class - updateVerificationStatus method - start");
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			hibernateSession.beginTransaction();

			Query query = hibernateSession.createQuery("update Customers set verificationStatus = :verificationStatus where customerId = :customerId");

			query.setParameter("verificationStatus", "Y");

			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			
			System.out.println("Value of customerId is : "+customerId);
			System.out.println(result+" rows updated !! ");

			hibernateSession.getTransaction().commit();
			
			logger.debug("InsertCustomerDetails class - updateVerificationStatus method - end");
			
		}
		catch ( HibernateException e ) {
			logger.error("InsertCustomerDetails class - updateVerificationStatus method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("InsertCustomerDetails class - updateVerificationStatus method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
    
    public void updateMandateId (String mandateId,String customerId) throws MoneyBuddyException {

    	logger.debug("InsertCustomerDetails class - updateMandateId method - start");
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDateForDB = dateFormat.format(date);
			
			hibernateSession.beginTransaction();

			Query query = hibernateSession.createQuery("update Customers set isipMandateId = :isipMandateId, mandateCreationDate = :mandateCreationDate, "
					+ " mandateIdStatus = :mandateIdStatus, mandateAmount = :mandateAmount where customerId = :customerId");

			query.setParameter("isipMandateId", mandateId);
			query.setParameter("mandateCreationDate", frmtdDateForDB);
			query.setParameter("mandateAmount", "120000");
			query.setParameter("mandateIdStatus", "GENERATED");
			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			
			System.out.println(result+" rows updated !! ");

			hibernateSession.getTransaction().commit();
    		
			logger.debug("InsertCustomerDetails class - updateMandateId method - updated data of Customers table to set verificationStatus Y");
    		
			logger.debug("InsertCustomerDetails class - updateMandateId method - end");
		}
		catch ( HibernateException e ) {
			logger.error("InsertCustomerDetails class - updateMandateId method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("InsertCustomerDetails class - updateMandateId method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}


    public void updateMobileNum (String mobileNumber,String customerId) throws MoneyBuddyException {

    	logger.debug("InsertCustomerDetails class - updateMobileNum method - start");
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {
			
			hibernateSession.beginTransaction();

			Query query = hibernateSession.createQuery("update Customers set mobileNumber = :mobileNumber where customerId = :customerId");

			query.setParameter("mobileNumber", mobileNumber);
			query.setParameter("customerId", customerId);

			int result = query.executeUpdate();
			
			System.out.println(result+" rows updated !! ");

			hibernateSession.getTransaction().commit();
    		
			logger.debug("InsertCustomerDetails class - updateMobileNum method - updated data of Customers table to set verificationStatus Y");
    		
			logger.debug("InsertCustomerDetails class - updateMobileNum method - end");
		}
		catch ( HibernateException e ) {
			logger.error("InsertCustomerDetails class - updateMobileNum method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("InsertCustomerDetails class - updateMobileNum method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

}


/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerPasswordsHistory;
import com.myMoneyBuddy.EntityClasses.CustomerLoginActivity;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.Subscriber;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class InsertCustomerDetails {

	Logger logger = Logger.getLogger(InsertCustomerDetails.class);

    public void insertCustomer (String emailId,String mobileNumber, String password) throws MoneyBuddyException
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

    		Customers tempCustomer = new Customers(emailId,null,mobileNumber,password,"N",null,"NC","N","N","CUSTOMER","N","N","N","NOT_GENERATED","CLIENT");

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

    		CustomerPasswordsHistory tempUserPasswords = new CustomerPasswordsHistory(customerId,password,null);
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
    
    public void updateVerificationStatus (String password) throws MoneyBuddyException {

    	logger.debug("InsertCustomerDetails class - updateVerificationStatus method - start");
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			hibernateSession.beginTransaction();

			Query query = hibernateSession.createQuery("update Customers set verificationStatus = :verificationStatus where password = :password");

			query.setParameter("verificationStatus", "Y");

			query.setParameter("password", password);

			int result = query.executeUpdate();
			
			System.out.println("Value of password is : "+password);
			System.out.println(result+" rows updated !! ");

			hibernateSession.getTransaction().commit();
    		
			logger.debug("InsertCustomerDetails class - updateVerificationStatus method - updated data of Customers table to set verificationStatus Y");
    		
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

			hibernateSession.beginTransaction();

			Query query = hibernateSession.createQuery("update Customers set isipMandateId = :isipMandateId where customerId = :customerId");

			query.setParameter("isipMandateId", mandateId);

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



}


/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerPasswordsHistory;
import com.myMoneyBuddy.EntityClasses.CustomerLoginActivity;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class insertCustomerDetails {

	Logger logger = Logger.getLogger(insertCustomerDetails.class);
	
    public void insertCustomer (String emailId,String firstName,String lastName,String mobileNumber,String password,String verificationStatus) throws MoneyBuddyException
    {

    	logger.debug("insertCustomerDetails class : insertCustomer method : start");
    	
    	SessionFactory factoryCustomers = new AnnotationConfiguration()
    											.configure()
    											.addAnnotatedClass(Customers.class)
    											.buildSessionFactory();
    											//addAnnotationClass(Company.class).buildSessionFactory();
    	Session sessionCustomers = factoryCustomers.openSession();

    	SessionFactory factoryCustomerPasswordsHistory = new AnnotationConfiguration()
    															.configure()
    															.addAnnotatedClass(CustomerPasswordsHistory.class)
    															.buildSessionFactory();
    															//addAnnotationClass(Company.class).buildSessionFactory();
    	Session sessionCustomerPasswordsHistory = factoryCustomerPasswordsHistory.openSession();

    	SessionFactory factoryCustomerLoginActivity = new AnnotationConfiguration()
    														.configure()
    														.addAnnotatedClass(CustomerLoginActivity.class)
    														.buildSessionFactory();
    														//addAnnotationClass(Company.class).buildSessionFactory();
    	Session sessionCustomerLoginActivity = factoryCustomerLoginActivity.openSession();

    	try {

    		Customers tempCustomer = new Customers(firstName,lastName,emailId,mobileNumber,password,verificationStatus);
    		sessionCustomers.beginTransaction();
    		sessionCustomers.save(tempCustomer);
    		sessionCustomers.getTransaction().commit();
    		
    		logger.debug("insertCustomerDetails class : insertCustomer method : inserted data to Customers table for emailId : "+emailId);

    		QueryCustomer queryCustomer = new QueryCustomer();
    		String customerId = queryCustomer.getCustomerId(emailId);

    		CustomerPasswordsHistory tempUserPasswords = new CustomerPasswordsHistory(customerId,password,null);
    		sessionCustomerPasswordsHistory.beginTransaction();
    		sessionCustomerPasswordsHistory.save(tempUserPasswords);

    		sessionCustomerPasswordsHistory.getTransaction().commit();

    		logger.debug("insertCustomerDetails class : insertCustomer method : inserted data to CustomerPasswordsHistory table for customerId : "+customerId);
    		
    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		Date date = new Date();
    		String frmtdDate = dateFormat.format(date);

    		CustomerLoginActivity tempUserTimeDetails = new CustomerLoginActivity(customerId,null,frmtdDate);

    		sessionCustomerLoginActivity.beginTransaction();
    		sessionCustomerLoginActivity.save(tempUserTimeDetails);
    		sessionCustomerLoginActivity.getTransaction().commit();
    		
    		logger.debug("insertCustomerDetails class : insertCustomer method : inserted data to CustomerLoginActivity table for customerId : "+customerId);
    		
    		logger.debug("insertCustomerDetails class : insertCustomer method : end");

    	}
    	catch ( HibernateException e ) {
			logger.debug("insertCustomerDetails class : insertCustomer method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("insertCustomerDetails class : insertCustomer method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    	finally {
    		if(factoryCustomers!=null)
    			factoryCustomers.close();
    		
    		if(factoryCustomerPasswordsHistory!=null)
    			factoryCustomerPasswordsHistory.close();
    		
    		if(factoryCustomerLoginActivity!=null)
    			factoryCustomerLoginActivity.close();
    	}

    }
    
    public void updateVerificationStatus (String password) throws MoneyBuddyException {

		logger.debug("insertCustomerDetails class : updateVerificationStatus method : start");
		SessionFactory factory = new AnnotationConfiguration()
										.configure()
										.addAnnotatedClass(Customers.class)
										.buildSessionFactory();
							//addAnnotationClass(Company.class).buildSessionFactory();
		Session session = factory.openSession();

		try {

			session.beginTransaction();

			Query query = session.createQuery("update Customers set verificationStatus = :verificationStatus" + " where password = :password");

			query.setParameter("verificationStatus", "YES");

			query.setParameter("password", password);

			int result = query.executeUpdate();

			session.getTransaction().commit();
    		
    		logger.debug("insertCustomerDetails class : updateVerificationStatus method : updated data of Customers table to set verificationStatus YES");
    		
    		logger.debug("insertCustomerDetails class : updateVerificationStatus method : end");
		}
		catch ( HibernateException e ) {
			logger.debug("insertCustomerDetails class : updateVerificationStatus method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("insertCustomerDetails class : updateVerificationStatus method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(factory!=null)
				factory.close();
		}

	}



}

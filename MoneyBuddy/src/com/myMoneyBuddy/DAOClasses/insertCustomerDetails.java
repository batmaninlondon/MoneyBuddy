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
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class insertCustomerDetails {

	Logger logger = Logger.getLogger(insertCustomerDetails.class);
	
    public void insertCustomer (String emailId,String customerName,String dateOfBirth,String mobileNumber,
    		String gender, String occupation, String taxStatus, String addressLineOne, String addressLineTwo,
    		String addressLineThree, String residentialCity, String residentialState, String residentialPin,
    		String residentialCountry, String panCard, String password,String verificationStatus) throws MoneyBuddyException
    {

    	logger.debug("insertCustomerDetails class : insertCustomer method : start");
    	
    	Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

    	
    	try {

    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		Date date = new Date();
    		String frmtdDate = dateFormat.format(date);
    		
    		Customers tempCustomer = new Customers(emailId,customerName,mobileNumber,password,verificationStatus,gender,occupation,
    				dateOfBirth,addressLineOne,addressLineTwo,addressLineThree,residentialCity,residentialState,residentialPin,residentialCountry,
    				taxStatus,panCard,"NC",null,"N","N","CUSTOMER");
    		session.beginTransaction();
    		session.save(tempCustomer);
    		session.getTransaction().commit();
    		
    		Subscriber tempSubscriber = new Subscriber(emailId,mobileNumber,"CUSTOMER",frmtdDate);
    		session.beginTransaction();
    		session.save(tempSubscriber);
    		session.getTransaction().commit();
    		
    		logger.debug("insertCustomerDetails class : insertCustomer method : inserted data to Customers table for emailId : "+emailId);

    		QueryCustomer queryCustomer = new QueryCustomer();
    		int customerId = queryCustomer.getCustomerId(emailId);
    		
    		System.out.println("insertCustomerDetails class : insertCustomer method : emailId : "+emailId);
    		System.out.println("insertCustomerDetails class : insertCustomer method : customerId : "+customerId);


    		CustomerPasswordsHistory tempUserPasswords = new CustomerPasswordsHistory(Integer.toString(customerId),password,null);
    		session.beginTransaction();
    		session.save(tempUserPasswords);

    		session.getTransaction().commit();

    		logger.debug("insertCustomerDetails class : insertCustomer method : inserted data to CustomerPasswordsHistory table for customerId : "+customerId);

    		CustomerLoginActivity tempUserTimeDetails = new CustomerLoginActivity(Integer.toString(customerId),null,frmtdDate);

    		session.beginTransaction();
    		session.save(tempUserTimeDetails);
    		session.getTransaction().commit();
    		
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
    		/*if(factory!=null)
			factory.close();*/
    		//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();
    		
    	}

    }
    
    public void updateVerificationStatus (String password) throws MoneyBuddyException {

		logger.debug("insertCustomerDetails class : updateVerificationStatus method : start");
		Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			session.beginTransaction();

			Query query = session.createQuery("update Customers set verificationStatus = :verificationStatus" + " where password = :password");

			query.setParameter("verificationStatus", "Y");

			query.setParameter("password", password);

			int result = query.executeUpdate();

			session.getTransaction().commit();
    		
    		logger.debug("insertCustomerDetails class : updateVerificationStatus method : updated data of Customers table to set verificationStatus Y");
    		
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
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();
		}

	}



}


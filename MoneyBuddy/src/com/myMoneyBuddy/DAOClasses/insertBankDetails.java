/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerPasswordsHistory;
import com.myMoneyBuddy.EntityClasses.BankDetails;
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

public class insertBankDetails {

	Logger logger = Logger.getLogger(insertBankDetails.class);
	
    public void insertBankDetail (String customerId,String bankName, String accountType,
    		String accountNumber, String ifscCode) throws MoneyBuddyException
    {

    	logger.debug("insertBankDetails class : insertBankDetail method : start");
    	
    	Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

    	
    	try {

    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDateForDB = dateFormat.format(date);
			
			session.beginTransaction();
			
			BankDetails tempBankDetails = new BankDetails(customerId, bankName, accountType,
					accountNumber, ifscCode, frmtdDateForDB);

			session.save(tempBankDetails);

			session.getTransaction().commit();
    		
    		logger.debug("insertBankDetails class : insertBankDetail method : end");

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


/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

//import com.myMoneyBuddy.ActionClasses.LoginAction;
import com.myMoneyBuddy.EntityClasses.CustomerAccountDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;


public class insertCustomerAccountDetails {
	
	Logger logger = Logger.getLogger(insertCustomerAccountDetails.class);

    public void insertCustomerAccountDetail (String transactionId, String customerId, String bankName,String accountNumber,String accountPassword,String cvvNumber) throws MoneyBuddyException{

    	logger.debug("insertCustomerAccountDetails class : insertCustomerAccountDetail method : start");
    	
    	Session session = HibernateUtil.getSessionAnnotationFactory().openSession();


    	try {

    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		Date date = new Date();
    		String frmtdDate = dateFormat.format(date);

    		CustomerAccountDetails tempCustomerAccountDetail = new CustomerAccountDetails(transactionId,customerId,bankName,accountNumber,
    				accountPassword,cvvNumber,frmtdDate,frmtdDate);
    		session.beginTransaction();
    		session.save(tempCustomerAccountDetail);
    		session.getTransaction().commit();
    		
    		logger.debug("insertCustomerAccountDetails class : insertCustomerAccountDetail method : inserted data to CustomerAccountDetails table for customerId : "+customerId);
    		logger.debug("insertCustomerAccountDetails class : insertCustomerAccountDetail method : end");

    	}
    	catch ( HibernateException e ) {
			logger.debug("insertCustomerAccountDetails class : insertCustomerAccountDetail method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("insertCustomerAccountDetails class : insertCustomerAccountDetail method : Caught Exception");
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


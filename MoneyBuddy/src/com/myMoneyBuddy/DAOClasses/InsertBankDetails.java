/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.BankDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class InsertBankDetails {

	Logger logger = Logger.getLogger(InsertBankDetails.class);
	
    public void insertBankDetail (String customerId,String bankName, String accountType,
    		String accountNumber, String ifscCode) throws MoneyBuddyException
    {

    	logger.debug("InsertBankDetails class - insertBankDetail method - customerId - "+customerId+" - start");
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

    	try {

    		System.out.println("Bank Details : accountNumber : "+accountNumber+" : ifscCode : "+ifscCode);
    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDateForDB = dateFormat.format(date);
			
			hibernateSession.beginTransaction();
			
			BankDetails tempBankDetails = new BankDetails(customerId, bankName, accountType,
					accountNumber, ifscCode, frmtdDateForDB);

			hibernateSession.save(tempBankDetails);

			hibernateSession.getTransaction().commit();
    		
			logger.debug("InsertBankDetails class - insertBankDetail method - customerId - "+customerId+" - new record inserted in BankDetails table");
    		
    		logger.debug("InsertBankDetails class - insertBankDetail method - customerId - "+customerId+" - end");

    	}
    	catch ( HibernateException e ) {
    		logger.error("InsertBankDetails class - insertBankDetail method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("InsertBankDetails class - insertBankDetail method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

    }


}


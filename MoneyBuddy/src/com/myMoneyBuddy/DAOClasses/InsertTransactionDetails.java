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

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class InsertTransactionDetails {

	Logger logger = LogManager.getLogger(InsertTransactionDetails.class);
	
    public void insertRejectedTransactionDetails (String transactionDetailId ) throws MoneyBuddyException
    {

    	logger.debug("InsertTransactionDetails class - insertRejectedTransactionDetails method - transactionDetailId - "+transactionDetailId+" - start");
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

    	try {
    		
    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String frmtdDateForDB = dateFormat.format(date);
			
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("update TransactionDetails set transactionType = :transactionType , buySell = :buySell,"
					+ " transactionAmount = :transactionAmount, quantity = :quantity, unitPrice = :unitPrice "
					+ " where transactionDetailId = :transactionDetailId");
			
			query.setParameter("transactionType", "SIPMissed");
			query.setParameter("buySell", "SIPMissed");
			query.setParameter("transactionAmount", null);
			query.setParameter("quantity", null);
			query.setParameter("unitPrice", null);

			query.setParameter("transactionDetailId", transactionDetailId);

			int result = query.executeUpdate();
						
			/*String nextTransactionId = "1";
						
			Query query = hibernateSession.createQuery("select transactionId from TransactionDetails where transactionId not like '%-%' "
					+ " order by transactionDetailId desc ");
			
			query.setMaxResults(1);
			
			nextTransactionId = Integer.toString(Integer.parseInt(query.uniqueResult().toString())+1);
			
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			
    		TransactionDetails tempTransactionDetail  = new TransactionDetails(nextTransactionId, transactionDetails.getBseOrderId(),transactionDetails.getBseRegistrationNumber(),
    				null, transactionDetails.getCustomerId(),transactionDetails.getTransactionType(),transactionDetails.getTransactionCode(),
					"SELL", "PARTIAL", transactionDetails.getTransactionAmount(),"8","Order rejected for BSE order id : "+transactionDetails.getBseOrderId(),
					"0","Y",transactionDetails.getFundId(),transactionDetails.getQuantity(),transactionDetails.getUnitPrice(),frmtdDateForDB,
					frmtdDateForDB,"N",transactionDetails.getTransactionFolioNum(),null,"Y"); 		

			hibernateSession.save(tempTransactionDetail);*/

			hibernateSession.getTransaction().commit();
    		
			logger.debug("InsertTransactionDetails class - insertRejectedTransactionDetails method - transactionDetailId - "+transactionDetailId+" - new record inserted in TransactionDetails table");
    		
    		logger.debug("InsertTransactionDetails class - insertRejectedTransactionDetails method - transactionDetailId - "+transactionDetailId+" - end");

    	}
    	catch ( HibernateException e ) {
    		logger.error("InsertTransactionDetails class - insertRejectedTransactionDetails method - transactionDetailId - "+transactionDetailId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("InsertTransactionDetails class - insertRejectedTransactionDetails method - transactionDetailId - "+transactionDetailId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

    }


}


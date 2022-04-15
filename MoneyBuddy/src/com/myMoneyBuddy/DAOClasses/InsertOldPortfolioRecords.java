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
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.OldPortfolioRecords;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class InsertOldPortfolioRecords {

	Logger logger = LogManager.getLogger(InsertOldPortfolioRecords.class);
	
	
	public void insertRow ( String customerId, String schemeName, String isin, String investedValue, String units, String folioNumber, String currentValue) 
						throws MoneyBuddyException
    {

    	logger.debug("InsertOldPortfolioRecords class - insertRow method - customerId - "+customerId+" - start");
    	
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	OldPortfolioRecords tempOldPortfolioRecords = null;
    	try {

    			
    			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    			Date date = new Date();
    			String frmtdDate = dateFormat.format(date);
    			
	    		hibernateSession.beginTransaction();
	    	
	    		tempOldPortfolioRecords = new OldPortfolioRecords(customerId,schemeName,isin,investedValue,units,folioNumber,currentValue,"0",null,frmtdDate);
	    		
	   	        hibernateSession.save(tempOldPortfolioRecords);
	   	        hibernateSession.flush();
	   	        hibernateSession.refresh(tempOldPortfolioRecords);
	   	        
	   	        hibernateSession.getTransaction().commit();
	   	        logger.debug("InsertOldPortfolioRecords class - insertRow method - customerId - "+customerId+" - new record inserted in CustomerCart table");
   	        

    		
    		logger.debug("InsertOldPortfolioRecords class - insertRow method - customerId - "+customerId+" - end");

    	}
    	catch ( HibernateException e ) {
    		logger.error("InsertOldPortfolioRecords class - insertRow method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("InsertOldPortfolioRecords class - insertRow method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    	finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

    }
	
	

}





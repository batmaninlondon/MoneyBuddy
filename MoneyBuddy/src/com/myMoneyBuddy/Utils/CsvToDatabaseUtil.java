package com.myMoneyBuddy.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.myMoneyBuddy.DAOClasses.InsertNavHistory;
import com.myMoneyBuddy.DAOClasses.QuerySecondaryFundDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

public class CsvToDatabaseUtil {
	
	Logger logger = LogManager.getLogger(CsvToDatabaseUtil.class);
	
	public void navEnteries()  throws MoneyBuddyException {
		
		logger.debug("CsvToDatabaseUtil class - navEnteries method - start");
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
    	
    	
		try {

			QuerySecondaryFundDetails querySecondaryFundDetails = new QuerySecondaryFundDetails();
			List<String> schemeCodes = querySecondaryFundDetails.allSchemeCodes();
			
			InsertNavHistory insertNavHistory = new InsertNavHistory();
			String fundId =  null;
			
			BufferedReader bReader = new BufferedReader(new FileReader("C://CSV/data.csv"));

            while (bReader != null) {
                String read;
                read = bReader.readLine();
                if (read != null && read.length() >0) 
                {
                    String[] array = read.split("\\|");
                    
                    if (schemeCodes.contains(array[1]))  {

                    	fundId = querySecondaryFundDetails.getFundId(array[1]);
                    	
                    	System.out.println("Fetch fundId : "+fundId+" for the scheme code : "+array[1]);
                    	insertNavHistory.insertNewNav(fundId, array[6]);
                    	
                    }
                } 

            }
			
            bReader.close();
    		
			logger.debug("CsvToDatabaseUtil class - navEnteries method - end");
		}
		catch ( IOException e ) {
			logger.error("CsvToDatabaseUtil class - navEnteries method - Caught IOException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("CsvToDatabaseUtil class - navEnteries method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("CsvToDatabaseUtil class - navEnteries method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
			
		}
		
	}
	


}

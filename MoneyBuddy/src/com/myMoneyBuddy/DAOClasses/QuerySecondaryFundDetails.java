/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.SecondaryFundDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class QuerySecondaryFundDetails {
	
	Logger logger = LogManager.getLogger(QuerySecondaryFundDetails.class);
	
	
	public SecondaryFundDetails getSecondaryFundDetails(String fundId) throws MoneyBuddyException {
		

		
		logger.debug("QuerySecondaryFundDetails class - getSecondaryFundDetails method - fundId - "+fundId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		hibernateSession.clear();
		
		SecondaryFundDetails secondaryFundDetails = new SecondaryFundDetails();
	
	
		try
		{
			System.out.println("fundId is : "+fundId);
			hibernateSession.beginTransaction();
			secondaryFundDetails = (SecondaryFundDetails) hibernateSession.get(SecondaryFundDetails.class, fundId);
			hibernateSession.getTransaction().commit();
			
			logger.debug("QuerySecondaryFundDetails class - getSecondaryFundDetails method - fundId - "+fundId+" - returns SecondaryFundDetails record");
			logger.debug("QuerySecondaryFundDetails class - getSecondaryFundDetails method - fundId - "+fundId+" - end");
			
			return secondaryFundDetails;
		}
		catch ( HibernateException e ) {
			logger.error("QuerySecondaryFundDetails class - getSecondaryFundDetails method - fundId - "+fundId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QuerySecondaryFundDetails class - getSecondaryFundDetails method - fundId - "+fundId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	
		
	}
	
	public HashMap<String,String> allSchemeCodesAndFundIds()  throws MoneyBuddyException {
		
		logger.debug("QuerySecondaryFundDetails class - allSchemeCodesAndFundIds method - start");
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

    	HashMap<String,String> schemeCodesAndFundIds = new HashMap<String,String>();
    	
		try {

			hibernateSession.beginTransaction();

			Query query = hibernateSession.createQuery("select isin,fundId from SecondaryFundDetails ");
			List<Object[]> secondaryFundDetailsList = query.list();
			String isin = "";
			String fundId = "";
			for ( int i = 0; i < secondaryFundDetailsList.size() ;i++ ) {

				isin = secondaryFundDetailsList.get(i)[0].toString();
				fundId = secondaryFundDetailsList.get(i)[1].toString();
	
				schemeCodesAndFundIds.put(isin, fundId);
			}

			hibernateSession.getTransaction().commit();
    		
			logger.debug("QuerySecondaryFundDetails class - allSchemeCodesAndFundIds method - returning schemeCodesAndFundIds HashMap ");
    		
			logger.debug("QuerySecondaryFundDetails class - allSchemeCodesAndFundIds method - end");
			
			return schemeCodesAndFundIds;
			
		}
		catch ( HibernateException e ) {
			logger.error("QuerySecondaryFundDetails class - allSchemeCodesAndFundIds method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QuerySecondaryFundDetails class - allSchemeCodesAndFundIds method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public List<String> allSchemeCodes()  throws MoneyBuddyException {
		
		logger.debug("QuerySecondaryFundDetails class - allSchemeCodes method - start");
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {

			
			hibernateSession.beginTransaction();

			Query query = hibernateSession.createQuery("select distinct(schemeCode) from SecondaryFundDetails ");

			List<String> schemeCodes = query.list();

			hibernateSession.getTransaction().commit();
    		
			logger.debug("QuerySecondaryFundDetails class - allSchemeCodes method - returning allSchemeCodes list ");
    		
			logger.debug("QuerySecondaryFundDetails class - allSchemeCodes method - end");
			
			return schemeCodes;
			
		}
		catch ( HibernateException e ) {
			logger.error("QuerySecondaryFundDetails class - allSchemeCodes method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QuerySecondaryFundDetails class - allSchemeCodes method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public String getFundId(String schemeCode)  throws MoneyBuddyException {
		
		logger.debug("QuerySecondaryFundDetails class - getFundId method - start");
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {
			String fundId = null;
			
			hibernateSession.beginTransaction();

			Object result  = hibernateSession.createQuery("select fundId from SecondaryFundDetails where schemeCode = '"+schemeCode+"'").uniqueResult();

			if (result != null) {
				
				fundId = result.toString();
				
				
			}

			hibernateSession.getTransaction().commit();
    		
			logger.debug("QuerySecondaryFundDetails class - getFundId method - returning fundId : "+fundId+" for schemeCode : "+schemeCode);
    		
			logger.debug("QuerySecondaryFundDetails class - getFundId method - end");
			
			return fundId;
			
		}
		catch ( HibernateException e ) {
			logger.error("QuerySecondaryFundDetails class - getFundId method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QuerySecondaryFundDetails class - getFundId method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public String getRta(String fundId)  throws MoneyBuddyException {
		
		logger.debug("QuerySecondaryFundDetails class - getRta method - start");
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {
			String rta = null;
			
			hibernateSession.beginTransaction();
    		
    		Query query = hibernateSession.createQuery("select rta from SecondaryFundDetails where fundId = :fundId ");
    		query.setParameter("fundId", fundId);
    		
    		rta = query.uniqueResult().toString();
    		
    		System.out.println(" rta for fundId : "+fundId+" is : "+rta);
    		
    		hibernateSession.getTransaction().commit();
    		
    		logger.debug("QuerySecondaryFundDetails class - getRta method - returning rta : "+rta+" for fundId : "+fundId);
    		
			logger.debug("QuerySecondaryFundDetails class - getRta method - end");
			
			return rta;
			
		}
		catch ( HibernateException e ) {
			logger.error("QuerySecondaryFundDetails class - getRta method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QuerySecondaryFundDetails class - getRta method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public String getSchemeCode(String fundId)  throws MoneyBuddyException {
		
		logger.debug("QuerySecondaryFundDetails class - getSchemeCode method - start");
    	Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try {
			String schemeCode = null;
			
			hibernateSession.beginTransaction();
    		
    		Query query = hibernateSession.createQuery("select schemeCode from SecondaryFundDetails where fundId = :fundId ");
    		query.setParameter("fundId", fundId);
    		
    		schemeCode = query.uniqueResult().toString();
    		
    		System.out.println(" schemeCode for fundId : "+fundId+" is : "+schemeCode);
    		
    		hibernateSession.getTransaction().commit();
    		
    		logger.debug("QuerySecondaryFundDetails class - getSchemeCode method - returning schemeCode : "+schemeCode+" for fundId : "+fundId);
    		
			logger.debug("QuerySecondaryFundDetails class - getSchemeCode method - end");
			
			return schemeCode;
			
		}
		catch ( HibernateException e ) {
			logger.error("QuerySecondaryFundDetails class - getSchemeCode method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QuerySecondaryFundDetails class - getSchemeCode method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
}

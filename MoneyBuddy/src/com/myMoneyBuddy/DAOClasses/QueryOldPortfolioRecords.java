/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.OldPortfolioRecords;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.OldPortfolioDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class QueryOldPortfolioRecords {

	Logger logger = LogManager.getLogger(QueryOldPortfolioRecords.class);
	
	public String fetchIsin(String customerId, String schemeName) throws MoneyBuddyException {
		
		logger.debug("QueryOldPortfolioRecords class - fetchIsin method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try
		{
			System.out.println("fetchIsin : customerId :"+customerId+":");
			System.out.println("fetchIsin : schemeName :"+schemeName+":");
			hibernateSession.beginTransaction();
			String selIsin = hibernateSession.createQuery("select distinct(isin) from OldPortfolioRecords "
					+ " where schemeName = '"+schemeName+"' ").uniqueResult().toString();
			hibernateSession.getTransaction().commit();
			

			logger.debug("QueryOldPortfolioRecords class - fetchIsin method - customerId - "+customerId+" - end");

			return selIsin;
		}
		catch ( HibernateException e ) {
			logger.error("QueryOldPortfolioRecords class - fetchIsin method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryOldPortfolioRecords class - fetchIsin method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public boolean existSameRow(String customerId, String schemeName, String folioNumber) throws MoneyBuddyException {
		
		logger.debug("QueryOldPortfolioRecords class - existSameRow method - customerId - "+customerId+" - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try
		{

			hibernateSession.beginTransaction();
			
			Object result = hibernateSession.createQuery("select count(*) from OldPortfolioRecords "
					+ " where customerId='"+customerId+"' and schemeName='"+schemeName+"' and folioNumber='"+folioNumber+"' ").uniqueResult();
			
			hibernateSession.getTransaction().commit();
			
			if ( "0".equals(result.toString()) )  {
				return false;
			}
			

			return true;
		}
		catch ( HibernateException e ) {
			logger.error("QueryOldPortfolioRecords class - existSameRow method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryOldPortfolioRecords class - existSameRow method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public List<String> fetchAllIsin() throws MoneyBuddyException {
		
		logger.debug("QueryOldPortfolioRecords class - fetchAllIsin method - start");
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try
		{
			List<String> allIsin = new ArrayList<String>();
			
			hibernateSession.beginTransaction();	   
   			
			Query schemeCodesData = hibernateSession.createQuery("select distinct(isin) from OldPortfolioRecords ");
			
			hibernateSession.getTransaction().commit();
			
			allIsin = schemeCodesData.list();
			

			logger.debug("QueryOldPortfolioRecords class - fetchAllIsin method - end");

			return allIsin;
		}
		catch ( HibernateException e ) {
			logger.error("QueryOldPortfolioRecords class - fetchAllIsin method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryOldPortfolioRecords class - fetchAllIsin method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public String getTotalOldRecords(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryOldPortfolioRecords class - getTotalOldRecords method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		Object result;
		String totalOldRecords ;

		try
		{
			
			hibernateSession.beginTransaction();
			
			totalOldRecords = hibernateSession.createQuery("select count(*) from OldPortfolioRecords where customerId='"+customerId+"' ").uniqueResult().toString();
			
			hibernateSession.getTransaction().commit();


			System.out.println(" Total Non MoneyBuddy Records are : "+totalOldRecords);
				
			logger.debug("QueryOldPortfolioRecords class - getTotalOldRecords method - customerId - "+customerId+" - return totalOldRecords - "+totalOldRecords);
			logger.debug("QueryOldPortfolioRecords class - getTotalOldRecords method - customerId - "+customerId+" - end");
			
			return totalOldRecords;
		}
		catch ( HibernateException e ) {
			logger.error("QueryOldPortfolioRecords class - getTotalOldRecords method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryOldPortfolioRecords class - getTotalOldRecords method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

	public List<OldPortfolioDataModel> getOldRecordsData(String customerId) throws MoneyBuddyException {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		double totInvestedAmount = 0.0;
		double totCurrentAmount = 0.0;
	       
		try
		{
			logger.debug("QueryOldPortfolioRecords class - getOldRecordsData method - customerId - "+customerId+" - end");
		
			List<OldPortfolioDataModel> oldPortfolioDataModel = new LinkedList<OldPortfolioDataModel>();
			
			hibernateSession.beginTransaction();

			Query query = hibernateSession.createQuery("from OldPortfolioRecords where customerId = :customerId ");
			query.setParameter("customerId",customerId);
			
			List<OldPortfolioRecords> oldRecordsList = query.list();
			
			hibernateSession.getTransaction().commit();
			
			for(OldPortfolioRecords oldRecord : oldRecordsList){
				
				oldPortfolioDataModel.add(new OldPortfolioDataModel(customerId, oldRecord.getSchemeName(), oldRecord.getFolioNumber(), 
						String.format("%.2f",Double.parseDouble(oldRecord.getInvestedValue())), String.format("%.2f",Double.parseDouble(oldRecord.getUnits())),
						String.format("%.2f",Double.parseDouble(oldRecord.getCurrentValue())), String.format("%.2f",Double.parseDouble(oldRecord.getProfit()))));
				
				totInvestedAmount += Double.parseDouble(oldRecord.getInvestedValue());
				totCurrentAmount += Double.parseDouble(oldRecord.getCurrentValue());
				
			}
			
			oldPortfolioDataModel.add(new OldPortfolioDataModel("", "Total", "", String.format("%.2f",totInvestedAmount),"",String.format("%.2f",totCurrentAmount),"" ));
	         
			logger.debug("QueryOldPortfolioRecords class - getOldRecordsData method - customerId - "+customerId+" - return oldPortfolioDataModel containing "+oldPortfolioDataModel.size()+" records");
			logger.debug("QueryOldPortfolioRecords class - getOldRecordsData method - customerId - "+customerId+" - end");
			 
			return oldPortfolioDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryOldPortfolioRecords class - getOldRecordsData method - customerId - "+customerId+" - Caught NumberFormatException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryOldPortfolioRecords class - getOldRecordsData method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryOldPortfolioRecords class - getOldRecordsData method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	

}

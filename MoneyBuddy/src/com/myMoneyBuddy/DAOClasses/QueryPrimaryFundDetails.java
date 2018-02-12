/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.PrimaryFundDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;



public class QueryPrimaryFundDetails {
	
	Logger logger = Logger.getLogger(QueryPrimaryFundDetails.class);
	
	
	public List<FundDetailsDataModel> getFundDetailsData() throws MoneyBuddyException {
		
		Session session  = null;
	       
		try
		{
			logger.debug("QueryPrimaryFundDetails class : getFundDetailsData method : start");
			
			session = HibernateUtil.getSessionAnnotationFactory().openSession();
		
			session.beginTransaction();

			List<FundDetailsDataModel> fundDetailsDataModel = new LinkedList<FundDetailsDataModel>();

			Query query = session.createQuery("from PrimaryFundDetails");

			
			List<PrimaryFundDetails> primaryFundDetailsList = query.list();

			for (PrimaryFundDetails fundDetailsListElement : primaryFundDetailsList)  {
				
			
				fundDetailsDataModel.add(new FundDetailsDataModel(fundDetailsListElement.getFundId(),fundDetailsListElement.getFundName(),fundDetailsListElement.getSector(),
						fundDetailsListElement.getSubSector(),fundDetailsListElement.getFundStartDate(),fundDetailsListElement.getRating(),fundDetailsListElement.getRisk(),
						fundDetailsListElement.getReturnsOneYear(),fundDetailsListElement.getReturnsThreeYears(),fundDetailsListElement.getReturnsFiveYears(),
						fundDetailsListElement.getReturnsSinceInception(),fundDetailsListElement.getMinSipAmount(),fundDetailsListElement.getMinLumsumAmount(),
						fundDetailsListElement.getMinSipDuration(),fundDetailsListElement.getFundCategory(),fundDetailsListElement.getPdfFilePath()));
			}

			//session.getTransaction().commit();

			logger.debug("QueryPrimaryFundDetails class : getFundDetailsData method : end");
			
			return fundDetailsDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryPrimaryFundDetails class : getFundDetailsData method : Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class : getFundDetailsData method : Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class : getFundDetailsData method : Caught Exception ");
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
	
	public FundDetailsDataModel getSelectedFundDetailsData(String fundId) throws MoneyBuddyException {
		
		Session session  = null;
	       
		try
		{
			logger.debug("QueryPrimaryFundDetails class : getSelectedFundDetailsData method : start");
			
			session = HibernateUtil.getSessionAnnotationFactory().openSession();
		
			session.beginTransaction();

			FundDetailsDataModel selectedFundDetailsDataModel = new FundDetailsDataModel();

			Query query = session.createQuery("from PrimaryFundDetails where fundId = :fundId");
			query.setParameter("fundId", fundId);
			
			List<PrimaryFundDetails> primaryFundDetailsList = query.list();
			
			if (primaryFundDetailsList != null)  {
				
				selectedFundDetailsDataModel= new FundDetailsDataModel(primaryFundDetailsList.get(0).getFundId(),primaryFundDetailsList.get(0).getFundName(),primaryFundDetailsList.get(0).getSector(),
						primaryFundDetailsList.get(0).getSubSector(),primaryFundDetailsList.get(0).getFundStartDate(),primaryFundDetailsList.get(0).getRating(),primaryFundDetailsList.get(0).getRisk(),
						primaryFundDetailsList.get(0).getReturnsOneYear(),primaryFundDetailsList.get(0).getReturnsThreeYears(),primaryFundDetailsList.get(0).getReturnsFiveYears(),
						primaryFundDetailsList.get(0).getReturnsSinceInception(),primaryFundDetailsList.get(0).getMinSipAmount(),primaryFundDetailsList.get(0).getMinLumsumAmount(),
						primaryFundDetailsList.get(0).getMinSipDuration(),primaryFundDetailsList.get(0).getFundCategory(),primaryFundDetailsList.get(0).getPdfFilePath());
			}

			//session.getTransaction().commit();

			logger.debug("QueryPrimaryFundDetails class : getSelectedFundDetailsData method : end");
			
			return selectedFundDetailsDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryPrimaryFundDetails class : getSelectedFundDetailsData method : Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class : getSelectedFundDetailsData method : Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class : getSelectedFundDetailsData method : Caught Exception ");
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
	
	public boolean checkBufferDays(String sipStartDate, Set<String> fundIds) throws MoneyBuddyException {
		
		Session hibernateSession  = null;
	       
		try
		{
			logger.debug("QueryPrimaryFundDetails class : checkBufferDays method : start");

			List<String> abc = new ArrayList<String>();
			abc.add("1");
			abc.add("2");
			abc.add("3");
			
			hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
			hibernateSession.beginTransaction();

			Query query = hibernateSession.createQuery("select max(sipBufferDays) from PrimaryFundDetails where fundId in :fundIds ");
			query.setParameterList("fundIds", abc);
			
			String maxSipBufferDays = query.uniqueResult().toString();
			
			System.out.println("maxSipBufferDays : "+maxSipBufferDays);
			
			long MILLIS_IN_BUFFER_DAYS = Integer.parseInt(maxSipBufferDays) * 24 * 60 * 60 * 1000L;
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date startDate = dateFormat.parse(sipStartDate);
			
			Date date = new Date();
			String frmtdDate = dateFormat.format(date);
			Date todayDate = dateFormat.parse(frmtdDate);
			
			boolean changeSipDate = Math.abs(startDate.getTime() - todayDate.getTime()) < MILLIS_IN_BUFFER_DAYS;
			
			hibernateSession.getTransaction().commit();

			logger.debug("QueryPrimaryFundDetails class : checkBufferDays method : end");
			
			return changeSipDate;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryPrimaryFundDetails class : checkBufferDays method : Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class : checkBufferDays method : Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class : checkBufferDays method : Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			hibernateSession.close();

		}

	}
	
}

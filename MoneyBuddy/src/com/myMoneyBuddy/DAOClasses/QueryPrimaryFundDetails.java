/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.PrimaryFundDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class QueryPrimaryFundDetails {
	
	Logger logger = Logger.getLogger(QueryPrimaryFundDetails.class);
	
	public PrimaryFundDetails getPrimaryFundDetail(String fundId) throws MoneyBuddyException {
		
		logger.debug("QueryPrimaryFundDetails class - getPrimaryFundDetail method - fundId - "+fundId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		hibernateSession.clear();
		
		PrimaryFundDetails primaryFundDetail = new PrimaryFundDetails();
		try
		{
			System.out.println("fundId is : "+fundId);
			hibernateSession.beginTransaction();
			primaryFundDetail = (PrimaryFundDetails) hibernateSession.get(PrimaryFundDetails.class, fundId);
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryPrimaryFundDetails class - getPrimaryFundDetail method - fundId - "+fundId+" - return primaryFundDetail");
			logger.debug("QueryPrimaryFundDetails class - getPrimaryFundDetail method - fundId - "+fundId+" - end");
			
			return primaryFundDetail;
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class - getPrimaryFundDetail method - fundId - "+fundId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class - getPrimaryFundDetail method - fundId - "+fundId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public List<FundDetailsDataModel> getFundDetailsData() throws MoneyBuddyException {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	       
		try
		{
			logger.debug("QueryPrimaryFundDetails class - getFundDetailsData method - start");
		
			hibernateSession.beginTransaction();

			List<FundDetailsDataModel> fundDetailsDataModel = new LinkedList<FundDetailsDataModel>();

			Query query = hibernateSession.createQuery("from PrimaryFundDetails");

			
			List<PrimaryFundDetails> primaryFundDetailsList = query.list();

			for (PrimaryFundDetails fundDetailsListElement : primaryFundDetailsList)  {
				
			
				fundDetailsDataModel.add(new FundDetailsDataModel(fundDetailsListElement.getFundId(),fundDetailsListElement.getFundName(),fundDetailsListElement.getSector(),
						fundDetailsListElement.getSubSector(),fundDetailsListElement.getFundStartDate(),fundDetailsListElement.getRating(),fundDetailsListElement.getRisk(),
						fundDetailsListElement.getReturnsOneYear(),fundDetailsListElement.getReturnsThreeYears(),fundDetailsListElement.getReturnsFiveYears(),
						fundDetailsListElement.getReturnsSinceInception(),fundDetailsListElement.getMinSipAmount(),fundDetailsListElement.getMinLumsumAmount(),
						fundDetailsListElement.getMinSipDuration(),fundDetailsListElement.getFundCategory(),fundDetailsListElement.getPdfFilePath()));
			}

			hibernateSession.getTransaction().commit();

			logger.debug("QueryPrimaryFundDetails class - getFundDetailsData method - return fundDetailsDataModel of - "+fundDetailsDataModel.size()+" records");
			logger.debug("QueryPrimaryFundDetails class - getFundDetailsData method - end");
			
			return fundDetailsDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryPrimaryFundDetails class - getFundDetailsData method - Caught NumberFormatException ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class - getFundDetailsData method - Caught HibernateException ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class - getFundDetailsData method - Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public FundDetailsDataModel getSelectedFundDetailsData(String fundId) throws MoneyBuddyException {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	       
		try
		{
			logger.debug("QueryPrimaryFundDetails class - getSelectedFundDetailsData method - fundId - "+fundId+" - start");
		
			hibernateSession.beginTransaction();

			FundDetailsDataModel selectedFundDetailsDataModel = new FundDetailsDataModel();

			System.out.println("fund id is : "+fundId);
			Query query = hibernateSession.createQuery("from PrimaryFundDetails where fundId = :fundId");
			query.setParameter("fundId", fundId);
			
			List<PrimaryFundDetails> primaryFundDetailsList = query.list();
			
			if (primaryFundDetailsList != null)  {
				System.out.println("primaryFundDetailsList is not null !!!! ");
				selectedFundDetailsDataModel= new FundDetailsDataModel(primaryFundDetailsList.get(0).getFundId(),primaryFundDetailsList.get(0).getFundName(),primaryFundDetailsList.get(0).getSector(),
						primaryFundDetailsList.get(0).getSubSector(),primaryFundDetailsList.get(0).getFundStartDate(),primaryFundDetailsList.get(0).getRating(),primaryFundDetailsList.get(0).getRisk(),
						primaryFundDetailsList.get(0).getReturnsOneYear(),primaryFundDetailsList.get(0).getReturnsThreeYears(),primaryFundDetailsList.get(0).getReturnsFiveYears(),
						primaryFundDetailsList.get(0).getReturnsSinceInception(),primaryFundDetailsList.get(0).getMinSipAmount(),primaryFundDetailsList.get(0).getMinLumsumAmount(),
						primaryFundDetailsList.get(0).getMinSipDuration(),primaryFundDetailsList.get(0).getFundCategory(),primaryFundDetailsList.get(0).getPdfFilePath());
			}
			else {
				System.out.println("primaryFundDetailsList is null !!!! ");
			}

			hibernateSession.getTransaction().commit();

			logger.debug("QueryPrimaryFundDetails class - getSelectedFundDetailsData method - fundId - "+fundId+" - return selectedFundDetailsDataModel");
			logger.debug("QueryPrimaryFundDetails class - getSelectedFundDetailsData method - fundId - "+fundId+" - end");
			
			return selectedFundDetailsDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryPrimaryFundDetails class - getSelectedFundDetailsData method - fundId - "+fundId+" - Caught NumberFormatException ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class - getSelectedFundDetailsData method - fundId - "+fundId+" - Caught HibernateException ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class - getSelectedFundDetailsData method - fundId - "+fundId+" - Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public boolean checkBufferDays(String sipStartDate, List<String> fundIds) throws MoneyBuddyException {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	       
		try
		{
			logger.debug("QueryPrimaryFundDetails class - checkBufferDays method - start");
		
			hibernateSession.beginTransaction();

			Query query = hibernateSession.createQuery("select max(sipBufferDays) from PrimaryFundDetails where fundId in :fundIds ");
			query.setParameterList("fundIds", fundIds);
			
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

			logger.debug("QueryPrimaryFundDetails class - checkBufferDays method - return changeSipDate - "+changeSipDate);
			logger.debug("QueryPrimaryFundDetails class - checkBufferDays method - end");
			
			return changeSipDate;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryPrimaryFundDetails class - checkBufferDays method - Caught NumberFormatException ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class - checkBufferDays method - Caught HibernateException ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class - checkBufferDays method - Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public double getInterestRateOfOneFund(String fundId) throws MoneyBuddyException{

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try
		{
			logger.debug("QueryPrimaryFundDetails class - getInterestRateOfOneFund method - fundId - "+fundId+" - start");

			double interestRate = 0.0;
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select interestRate from PrimaryFundDetails where fundId = :fundId ");
			query.setParameter("fundId",fundId);
			System.out.println("query.list().size() : "+query.list().size());
			if (query.list().size() != 0) {
				interestRate = Double.parseDouble(query.uniqueResult().toString());
			}

			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryPrimaryFundDetails class - getInterestRateOfOneFund method - fundId - "+fundId+" - return interestRate - "+interestRate);
			logger.debug("QueryPrimaryFundDetails class - getInterestRateOfOneFund method - fundId - "+fundId+" - end");
			
			return interestRate;
		}
		catch ( NumberFormatException e)  {
			logger.error("QueryPrimaryFundDetails class - getInterestRateOfOneFund method - fundId - "+fundId+" - Caught NumberFormatException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class - getInterestRateOfOneFund method - fundId - "+fundId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class - getInterestRateOfOneFund method - fundId - "+fundId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
}

/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.PrimaryFundDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.FundDetailsDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class QueryPrimaryFundDetails {
	
	Logger logger = LogManager.getLogger(QueryPrimaryFundDetails.class);
	
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

			String startDate;
			for (PrimaryFundDetails fundDetailsListElement : primaryFundDetailsList)  {
				
				startDate=fundDetailsListElement.getStartDate();
				startDate = startDate.substring(8) +"-"+ startDate.substring(5,7)+ "-"+startDate.substring(0,4);
				
				fundDetailsDataModel.add(new FundDetailsDataModel(fundDetailsListElement.getFundId(),fundDetailsListElement.getSchemeName(),fundDetailsListElement.getSchemeType(),
						fundDetailsListElement.getCategory(),startDate,fundDetailsListElement.getRating(),fundDetailsListElement.getRisk(),
						fundDetailsListElement.getReturnsOneYear(),fundDetailsListElement.getReturnsThreeYears(),fundDetailsListElement.getReturnsFiveYears(),
						fundDetailsListElement.getReturnsSinceInception(),fundDetailsListElement.getMinSipAmount(),fundDetailsListElement.getMinPurchaseAmount(),fundDetailsListElement.getUpfrontMultiplier(),
						fundDetailsListElement.getMinStpAmount(),fundDetailsListElement.getMinSipDuration(),fundDetailsListElement.getPdfFilePath(),fundDetailsListElement.getSipFlag(),
						fundDetailsListElement.getStpWithdrawalFlag(),fundDetailsListElement.getStpPurchaseFlag(),fundDetailsListElement.getSwpFlag(),fundDetailsListElement.getSwitchFlag()));
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
	
	public List<FundDetailsDataModel> getPopularFundDetailsData() throws MoneyBuddyException {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	       
		try
		{
			logger.debug("QueryPrimaryFundDetails class - getPopularFundDetailsData method - start");
		
			hibernateSession.beginTransaction();

			List<FundDetailsDataModel> fundDetailsDataModel = new LinkedList<FundDetailsDataModel>();

			Query query = hibernateSession.createQuery("from PrimaryFundDetails where mostPopularFund = 'Y' ");

			
			List<PrimaryFundDetails> primaryFundDetailsList = query.list();

			String startDate;
			for (PrimaryFundDetails fundDetailsListElement : primaryFundDetailsList)  {
				
				startDate = fundDetailsListElement.getStartDate();
				startDate = startDate.substring(8) +"-"+ startDate.substring(5,7)+ "-"+startDate.substring(0,4);
				fundDetailsDataModel.add(new FundDetailsDataModel(fundDetailsListElement.getFundId(),fundDetailsListElement.getSchemeName(),fundDetailsListElement.getSchemeType(),
						fundDetailsListElement.getCategory(),startDate,fundDetailsListElement.getRating(),fundDetailsListElement.getRisk(),
						fundDetailsListElement.getReturnsOneYear(),fundDetailsListElement.getReturnsThreeYears(),fundDetailsListElement.getReturnsFiveYears(),
						fundDetailsListElement.getReturnsSinceInception(),fundDetailsListElement.getMinSipAmount(),fundDetailsListElement.getMinPurchaseAmount(),fundDetailsListElement.getUpfrontMultiplier(),
						fundDetailsListElement.getMinStpAmount(),fundDetailsListElement.getMinSipDuration(),fundDetailsListElement.getPdfFilePath(),fundDetailsListElement.getSipFlag(),
						fundDetailsListElement.getStpWithdrawalFlag(),fundDetailsListElement.getStpPurchaseFlag(),fundDetailsListElement.getSwpFlag(),fundDetailsListElement.getSwitchFlag()));
			}

			hibernateSession.getTransaction().commit();

			logger.debug("QueryPrimaryFundDetails class - getPopularFundDetailsData method - return fundDetailsDataModel of - "+fundDetailsDataModel.size()+" records");
			logger.debug("QueryPrimaryFundDetails class - getPopularFundDetailsData method - end");
			
			return fundDetailsDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryPrimaryFundDetails class - getPopularFundDetailsData method - Caught NumberFormatException ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class - getPopularFundDetailsData method - Caught HibernateException ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class - getPopularFundDetailsData method - Caught Exception ");
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
				selectedFundDetailsDataModel= new FundDetailsDataModel(primaryFundDetailsList.get(0).getFundId(),primaryFundDetailsList.get(0).getSchemeName(),primaryFundDetailsList.get(0).getSchemeType(),
						primaryFundDetailsList.get(0).getCategory(),primaryFundDetailsList.get(0).getStartDate(),primaryFundDetailsList.get(0).getRating(),primaryFundDetailsList.get(0).getRisk(),
						primaryFundDetailsList.get(0).getReturnsOneYear(),primaryFundDetailsList.get(0).getReturnsThreeYears(),primaryFundDetailsList.get(0).getReturnsFiveYears(),
						primaryFundDetailsList.get(0).getReturnsSinceInception(),primaryFundDetailsList.get(0).getMinSipAmount(),primaryFundDetailsList.get(0).getMinPurchaseAmount(),primaryFundDetailsList.get(0).getUpfrontMultiplier(),
						primaryFundDetailsList.get(0).getMinStpAmount(),primaryFundDetailsList.get(0).getMinSipDuration(),primaryFundDetailsList.get(0).getPdfFilePath(),primaryFundDetailsList.get(0).getSipFlag(),
						primaryFundDetailsList.get(0).getStpWithdrawalFlag(),primaryFundDetailsList.get(0).getStpPurchaseFlag(),primaryFundDetailsList.get(0).getSwpFlag(),primaryFundDetailsList.get(0).getSwitchFlag());
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
	
	/*public boolean checkBufferDays(String sipStartDate, List<String> fundIds) throws MoneyBuddyException {
		
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

	}*/
	/*
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
	*/
	public String getSchemeName(String fundId) throws MoneyBuddyException{

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try
		{
			String schemeName = null;
			logger.debug("QueryPrimaryFundDetails class - getSchemeName method - fundId - "+fundId+" - start");

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select schemeName from PrimaryFundDetails where fundId = :fundId ");
			query.setParameter("fundId",fundId);
			
			if (query.list().size() != 0) {
				schemeName = query.uniqueResult().toString();
			}

			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryPrimaryFundDetails class - getSchemeName method - fundId - "+fundId+" - return schemeName - "+schemeName);
			logger.debug("QueryPrimaryFundDetails class - getSchemeName method - fundId - "+fundId+" - end");
			
			return schemeName;
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class - getSchemeName method - fundId - "+fundId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class - getSchemeName method - fundId - "+fundId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public String getFundId(String schemeName) throws MoneyBuddyException{

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try
		{
			String fundId = null;
			logger.debug("QueryPrimaryFundDetails class - getSchemeName method - fundId - "+fundId+" - start");

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select fundId from PrimaryFundDetails where schemeName = :schemeName ");
			query.setParameter("schemeName",schemeName);
			
			if (query.list().size() != 0) {
				fundId = query.uniqueResult().toString();
			}

			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryPrimaryFundDetails class - getSchemeName method - schemeName - "+schemeName+" - return fundId - "+fundId);
			logger.debug("QueryPrimaryFundDetails class - getSchemeName method - schemeName - "+schemeName+" - end");
			
			return fundId;
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class - getSchemeName method - schemeName - "+schemeName+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class - getSchemeName method - schemeName - "+schemeName+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public String getMinRedAmount(String fundId) throws MoneyBuddyException{

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try
		{
			String minRedAmount = null;
			logger.debug("QueryPrimaryFundDetails class - getMinRedAmount method - fundId - "+fundId+" - start");

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select minRedAmount from PrimaryFundDetails where fundId = :fundId ");
			query.setParameter("fundId",fundId);
			
			if (query.list().size() != 0) {
				minRedAmount = query.uniqueResult().toString();
			}

			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryPrimaryFundDetails class - getMinRedAmount method - fundId - "+fundId+" - return minRedAmount - "+minRedAmount);
			logger.debug("QueryPrimaryFundDetails class - getMinRedAmount method - fundId - "+fundId+" - end");
			
			return minRedAmount;
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class - getMinRedAmount method - fundId - "+fundId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class - getMinRedAmount method - fundId - "+fundId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public String getMinStpAmount(String fundId) throws MoneyBuddyException{

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try
		{
			String minStpAmount = null;
			logger.debug("QueryPrimaryFundDetails class - getMinStpAmount method - fundId - "+fundId+" - start");

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select minStpAmount from PrimaryFundDetails where fundId = :fundId ");
			query.setParameter("fundId",fundId);
			
			if (query.list().size() != 0) {
				minStpAmount = query.uniqueResult().toString();
			}

			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryPrimaryFundDetails class - getMinStpAmount method - fundId - "+fundId+" - return minStpAmount - "+minStpAmount);
			logger.debug("QueryPrimaryFundDetails class - getMinStpAmount method - fundId - "+fundId+" - end");
			
			return minStpAmount;
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class - getMinStpAmount method - fundId - "+fundId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class - getMinStpAmount method - fundId - "+fundId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public String getMinSwitchAmount(String fundId) throws MoneyBuddyException{

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try
		{
			String minSwitchAmount = null;
			logger.debug("QueryPrimaryFundDetails class - getMinSwitchAmount method - fundId - "+fundId+" - start");

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select minSwitchAmount from PrimaryFundDetails where fundId = :fundId ");
			query.setParameter("fundId",fundId);
			
			if (query.list().size() != 0) {
				minSwitchAmount = query.uniqueResult().toString();
			}

			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryPrimaryFundDetails class - getMinSwitchAmount method - fundId - "+fundId+" - return minSwitchAmount - "+minSwitchAmount);
			logger.debug("QueryPrimaryFundDetails class - getMinSwitchAmount method - fundId - "+fundId+" - end");
			
			return minSwitchAmount;
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class - getMinSwitchAmount method - fundId - "+fundId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class - getMinSwitchAmount method - fundId - "+fundId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public String getPdfFilePath(String fundId) throws MoneyBuddyException{

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try
		{
			String pdfFilePath = null;
			logger.debug("QueryPrimaryFundDetails class - getPdfFilePath method - fundId - "+fundId+" - start");

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select pdfFilePath from PrimaryFundDetails where fundId = :fundId ");
			query.setParameter("fundId",fundId);
			
			if (query.list().size() != 0) {
				pdfFilePath = query.uniqueResult().toString();
			}

			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryPrimaryFundDetails class - getPdfFilePath method - fundId - "+fundId+" - return pdfFilePath - "+pdfFilePath);
			logger.debug("QueryPrimaryFundDetails class - getPdfFilePath method - fundId - "+fundId+" - end");
			
			return pdfFilePath;
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class - getPdfFilePath method - fundId - "+fundId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class - getPdfFilePath method - fundId - "+fundId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	

	public String getAvailableStpFundsList(String fundId) throws MoneyBuddyException{

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try
		{
			HashMap<String,String> availableStpFundsList = new HashMap<String,String>();
			logger.debug("QueryPrimaryFundDetails class - getAvailableStpFundIds method - fundId - "+fundId+" - start");

			System.out.println("QueryPrimaryFundDetails class - getAvailableStpFundIds method - fundId - "+fundId+" - start");
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select s.fundId, p.schemeName from PrimaryFundDetails p, SecondaryFundDetails s "
					+ " where p.fundId=s.fundId and not s.fundId = :fundId and p.stpPurchaseFlag='Y' and "
					+ " s.amcCode = ( select amcCode from SecondaryFundDetails where fundId = :fundId)");
			
			query.setParameter("fundId",fundId);
			
			List<Object[]> availableFundList = query.list();
			
			String stpPuchaseFunds = "";
			
			if (availableFundList.size() == 0)
				stpPuchaseFunds = ":";
			else {
				for ( int i = 0; i < availableFundList.size() ;i++ ) {
	
					stpPuchaseFunds += availableFundList.get(i)[1].toString()+":";
				}
			}
			stpPuchaseFunds = stpPuchaseFunds.substring(0,stpPuchaseFunds.length()-1);
			
			hibernateSession.getTransaction().commit();
			
			System.out.println(" RETURNING stpPuchaseFunds :"+stpPuchaseFunds+":");

			logger.debug("QueryPrimaryFundDetails class - getAvailableStpFundIds method - fundId - "+fundId+" - end");
			
			return stpPuchaseFunds;
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class - getAvailableStpFundIds method - fundId - "+fundId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class - getAvailableStpFundIds method - fundId - "+fundId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public String getAvailableSwitchFundsList(String fundId) throws MoneyBuddyException{

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try
		{
			HashMap<String,String> availableSwitchFundsList = new HashMap<String,String>();
			logger.debug("QueryPrimaryFundDetails class - getAvailableSwitchFundIds method - fundId - "+fundId+" - start");

			System.out.println("QueryPrimaryFundDetails class - getAvailableSwitchFundIds method - fundId - "+fundId+" - start");
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select s.fundId, p.schemeName from PrimaryFundDetails p, SecondaryFundDetails s "
					+ " where p.fundId=s.fundId and not s.fundId = :fundId and p.switchPurchaseFlag='Y' and "
					+ " s.amcCode = ( select amcCode from SecondaryFundDetails where fundId = :fundId)");
			
			query.setParameter("fundId",fundId);
			
			List<Object[]> availableFundList = query.list();
			
			String switchPuchaseFunds = "";
			
			if (availableFundList.size() == 0)
				switchPuchaseFunds = ":";
			else {
				for ( int i = 0; i < availableFundList.size() ;i++ ) {
	
					switchPuchaseFunds += availableFundList.get(i)[1].toString()+":";
				}
			}
			switchPuchaseFunds = switchPuchaseFunds.substring(0,switchPuchaseFunds.length()-1);
			
			hibernateSession.getTransaction().commit();
			
			System.out.println(" RETURNING switchPuchaseFunds :"+switchPuchaseFunds+":");

			logger.debug("QueryPrimaryFundDetails class - getAvailableSwitchFundIds method - fundId - "+fundId+" - end");
			
			return switchPuchaseFunds;
		}
		catch ( HibernateException e ) {
			logger.error("QueryPrimaryFundDetails class - getAvailableSwitchFundIds method - fundId - "+fundId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryPrimaryFundDetails class - getAvailableSwitchFundIds method - fundId - "+fundId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
}

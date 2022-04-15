package com.myMoneyBuddy.DAOClasses;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.ModelClasses.TaxRecordsDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class CalculateTaxRecords {
	
	Logger logger = LogManager.getLogger(CalculateTaxRecords.class);
	
	public List<TaxRecordsDataModel> getTaxDetails(String customerId, String fundId, String folioNum, String schemeType, 
					    String startDate, String endDate)  {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
			
			
			System.out.println(" fundID : "+fundId+" and folioNum : "+folioNum+" and schemeType : "+schemeType);
			
			List<TaxRecordsDataModel> taxRecordsDataList = new LinkedList<TaxRecordsDataModel>();
			
			/*hibernateSession.beginTransaction();
			SQLQuery query = hibernateSession.createSQLQuery("SELECT TRANSACTION_DETAIL_ID FROM ebdb.TRANSACTION_DETAILS "
					+ "where BUY_SELL='SELL' and TRANSACTION_STATUS='8' and CUSTOMER_ID = :customerId "
					+ " and FUND_ID= :fundId and TRANSACTION_FOLIO_NUM= :folioNum and TRANSACTION_DATE >= curdate() - INTERVAL "+years+" YEAR ");
			SQLQuery query = hibernateSession.createSQLQuery("SELECT TRANSACTION_DETAIL_ID FROM ebdb.TRANSACTION_DETAILS "
					+ "where BUY_SELL='SELL' and TRANSACTION_STATUS='8' and CUSTOMER_ID = :customerId "
					+ " and FUND_ID= :fundId and TRANSACTION_FOLIO_NUM= :folioNum and TRANSACTION_DATE >= :startDate ");
			
			query.setParameter("customerId", customerId);
			query.setParameter("fundId", fundId);
			query.setParameter("folioNum", folioNum);
			query.setParameter("startDate", startDate);
			List<Integer> result = query.list();
			
			List<String> newList = new ArrayList<String>(result.size());
			for (Integer myInt : result) { 
			  newList.add(String.valueOf(myInt)); 
			}
			
			hibernateSession.getTransaction().commit();*/
			
			hibernateSession.beginTransaction();
			/*query = hibernateSession.createSQLQuery("SELECT sum(QUANTITY) FROM ebdb.TRANSACTION_DETAILS where "
					+ " BUY_SELL='SELL' and TRANSACTION_STATUS='8' and  CUSTOMER_ID= :customerId "
					+ " and FUND_ID= :fundId and TRANSACTION_FOLIO_NUM= :folioNum and TRANSACTION_DATE < curdate() - INTERVAL "+years+" YEAR ");*/
			Query query = hibernateSession.createSQLQuery("SELECT sum(QUANTITY) FROM ebdb.TRANSACTION_DETAILS where "
					+ " BUY_SELL='SELL' and TRANSACTION_STATUS='8' and  CUSTOMER_ID= :customerId "
					+ " and FUND_ID= :fundId and TRANSACTION_FOLIO_NUM= :folioNum and TRANSACTION_DATE < :startDate ");
			query.setParameter("customerId", customerId);
			query.setParameter("fundId", fundId);
			query.setParameter("folioNum", folioNum);
			query.setParameter("startDate", startDate);
			Object resultSum = query.uniqueResult();
						
			Double sumOfRedemption = 0.0;
			if (resultSum != null)
				sumOfRedemption = Double.parseDouble(query.uniqueResult().toString());

			hibernateSession.getTransaction().commit();

			
			hibernateSession.beginTransaction();
			
			Query taxData = hibernateSession.createQuery("select  quantity,unitPrice, transactionDate,fundId,transactionFolioNum,buySell "
					+ " from TransactionDetails where transactionStatus='8' and customerId= :customerId and quantity is not null and unitPrice is not null "
					+ " and buySell = 'SELL' and fundId = :fundId and transactionFolioNum = :transactionFolioNum "
					+ " and TRANSACTION_DATE between cast('"+startDate+"' as date) and cast('"+endDate+"' as date)  "
					+ " and fundId in (select fundId from PrimaryFundDetails where schemeType = :schemeType ) order by transactionDate asc ");
			
			taxData.setParameter("customerId",customerId);
			taxData.setParameter("fundId",fundId);
			taxData.setParameter("transactionFolioNum",folioNum);
			taxData.setParameter("schemeType",schemeType);
			/*taxData.setParameterList("result",  newList);*/
			
			hibernateSession.getTransaction().commit();
			
			
			int i =1;
			//Iterator taxDataIt=taxData.iterate();
			
			for (Iterator taxDataIt=taxData.iterate(); taxDataIt.hasNext();)  {
		
				Object[] taxDataRow = (Object[]) taxDataIt.next();
				
			    String sDate=taxDataRow[2].toString(); 
			    sDate = sDate.substring(0,10);
			    System.out.println();  
					taxRecordsDataList.add(new TaxRecordsDataModel(i,sDate,Double.parseDouble(taxDataRow[1].toString()),
							Double.parseDouble(taxDataRow[0].toString()),"",0.0,0.0,"NA","NA"));
					i++;
					
				
			}
			
				if (taxRecordsDataList.size() != 0 )  {
				
				DecimalFormat df = new DecimalFormat("###.###");
				
				
				hibernateSession.beginTransaction();
				
				taxData = hibernateSession.createQuery("select  quantity,unitPrice, transactionDate,fundId,transactionFolioNum,buySell "
						+ " from TransactionDetails where transactionStatus='8' and customerId= :customerId and quantity is not null and unitPrice is not null "
						+ " and buySell = 'BUY' and fundId = :fundId and transactionFolioNum = :transactionFolioNum  "
						+ " and fundId in (select fundId from PrimaryFundDetails where schemeType = :schemeType ) order by transactionDate asc ");
				
				taxData.setParameter("customerId",customerId);
				taxData.setParameter("fundId",fundId);
				taxData.setParameter("transactionFolioNum",folioNum);
				taxData.setParameter("schemeType",schemeType);
				
				hibernateSession.getTransaction().commit();
				
				
				int rowNum=0;
				
				Double remainingUnits = 0.0;
				Double currentRedUnits = 0.0;
				Double redemptionPrice =0.0;
				boolean processComplete = false;
				
				SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			      Date d2 = sdformat.parse(endDate);
			      
				for (Iterator taxDataIt=taxData.iterate(); taxDataIt.hasNext();)  {
					
					Object[] taxDataRow = (Object[]) taxDataIt.next();
					
					
					
					if ( !processComplete)  {
					
					if ( sumOfRedemption != 0.0)   {
						if ( sumOfRedemption <= Double.parseDouble(taxDataRow[0].toString())){
							remainingUnits = Double.parseDouble(taxDataRow[0].toString()) - sumOfRedemption;
							sumOfRedemption = 0.0;
						}
						else {
							sumOfRedemption = sumOfRedemption - Double.parseDouble(taxDataRow[0].toString());
						}
						
					}
					if (sumOfRedemption == 0.0){
						
						Double pnl = 0.0;
					
						TaxRecordsDataModel t1 = taxRecordsDataList.get(rowNum);
						if ( currentRedUnits == 0.0 )  
							currentRedUnits = t1.getRedemptionUnits();
						if (remainingUnits == 0.0)
							remainingUnits = Double.parseDouble(taxDataRow[0].toString());
						
						while ( remainingUnits != 0)  {
							System.out.println("currentRedUnits : "+currentRedUnits+" and remainingUnits : "+remainingUnits);
							if ( currentRedUnits <=  remainingUnits )  {
								
								String sDate1 = taxDataRow[2].toString(); 
								sDate1 = sDate1.substring(0,10);
							      Date d1 = sdformat.parse(sDate1);
							      boolean pnlTerm = findPnlTerm(d1, d2,schemeType);
								
								t1.setPurchaseDate(sDate1);
								t1.setPurchasePrice(Double.parseDouble(taxDataRow[1].toString()));
								t1.setPurchaseUnits(currentRedUnits);
															
								if (!(t1.getRedemptionPrice() == null))
									redemptionPrice=t1.getRedemptionPrice();
								pnl = (redemptionPrice-Double.parseDouble(taxDataRow[1].toString()))*currentRedUnits;
								if (pnlTerm)
									t1.setPnlLongTerm(df.format(pnl));
								else 
									t1.setPnlShortTerm(df.format(pnl));
								
								taxRecordsDataList.set(rowNum, t1);
								
								remainingUnits = Double.parseDouble(df.format(remainingUnits - currentRedUnits));
								
								if ( taxRecordsDataList.size() != (rowNum+1) ) {
									rowNum++;
									t1 = taxRecordsDataList.get(rowNum);
									currentRedUnits = t1.getRedemptionUnits();
								}
								else {
									processComplete = true;
									remainingUnits = 0.0;
								}
							}
							else {
								
								String sDate1 = taxDataRow[2].toString(); 
								sDate1 = sDate1.substring(0,10);
							      Date d1 = sdformat.parse(sDate1);
							      boolean pnlTerm = findPnlTerm(d1, d2,schemeType);
							      
								t1.setPurchaseDate(sDate1);
								t1.setPurchasePrice(Double.parseDouble(taxDataRow[1].toString()));
								t1.setPurchaseUnits(remainingUnits);	
								
								if (!(t1.getRedemptionPrice() == null))
									redemptionPrice=t1.getRedemptionPrice();
								
								pnl = (redemptionPrice-Double.parseDouble(taxDataRow[1].toString()))*remainingUnits;
								if (pnlTerm)
									t1.setPnlLongTerm(df.format(pnl));
								else
									t1.setPnlShortTerm(df.format(pnl));
	
								taxRecordsDataList.set(rowNum, t1);
								
								currentRedUnits = Double.parseDouble(df.format(currentRedUnits - remainingUnits));
								remainingUnits = 0.0;
								
								if ( taxRecordsDataList.size() != (rowNum+1) ) {
									
									taxRecordsDataList.add(new TaxRecordsDataModel());
									for ( int k = taxRecordsDataList.size(); k > (rowNum+1);k--)  {
										
										TaxRecordsDataModel newTaxRecord = taxRecordsDataList.get(k-2);
										taxRecordsDataList.set(k-1, new TaxRecordsDataModel(newTaxRecord));
										taxRecordsDataList.get(k-1).setSerialNum(k);
									}
									
									TaxRecordsDataModel newTaxRecord = taxRecordsDataList.get(rowNum+1);
									newTaxRecord.setRedemptionDate("");
									newTaxRecord.setRedemptionPrice(null);
									newTaxRecord.setRedemptionUnits(null);
									newTaxRecord.setPurchaseDate("");
									newTaxRecord.setPurchasePrice(null);
									newTaxRecord.setPurchaseUnits(null);
									newTaxRecord.setPnlLongTerm("NA");
									newTaxRecord.setPnlShortTerm("NA");
									taxRecordsDataList.set(rowNum+1, new TaxRecordsDataModel( newTaxRecord));
									
								}
								else {
									taxRecordsDataList.add(new TaxRecordsDataModel());
									TaxRecordsDataModel nextTaxRecord = taxRecordsDataList.get(rowNum+1);
									nextTaxRecord.setSerialNum(rowNum+2);
	
									nextTaxRecord.setPnlLongTerm("NA");
									nextTaxRecord.setPnlShortTerm("NA");
									taxRecordsDataList.set(rowNum+1,nextTaxRecord);
									TaxRecordsDataModel taxRecord = taxRecordsDataList.get(rowNum);
									taxRecord.setSerialNum(rowNum+1);
									taxRecordsDataList.set(rowNum,taxRecord);
								}
								
								rowNum++;
							}
						}
					
					}
				}
				}
				
			}
			
			return taxRecordsDataList;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
		
	}

	public int getRedemptionTransactionCount(String customerId, String fundId, String folioNum, String startDate, String endDate, String schemeType)   {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("select  count(*) from TransactionDetails where transactionStatus='8' "
					+ " and customerId= :customerId and quantity is not null and unitPrice is not null "
					+ " and buySell = 'SELL' and fundId = :fundId and transactionFolioNum = :transactionFolioNum "
					+ " and TRANSACTION_DATE between cast('"+startDate+"' as date) and cast('"+endDate+"' as date) "
					+ " and fundId in (select fundId from PrimaryFundDetails where schemeType = :schemeType ) ");
			
			query.setParameter("customerId",customerId);
			query.setParameter("fundId",fundId);
			query.setParameter("transactionFolioNum",folioNum);
			query.setParameter("schemeType",schemeType);
			
			hibernateSession.getTransaction().commit();
			
			int count = Integer.parseInt(query.uniqueResult().toString());
			
			return count;
			
		
		} catch (Exception e) {
		e.printStackTrace();
		return 0;
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	
	public List<String>  getRedemptionFundIds( String customerId, String schemeType )   {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
			
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("select distinct fundId from TransactionDetails where customerId = :customerId " + 
					" and transactionFolioNum is not null and transactionStatus ='8' " + 
					" and fundId in (select fundId from PrimaryFundDetails where schemeType = :schemeType ) "
					+ " order by fundId ").setParameter("customerId", customerId).setParameter("schemeType", schemeType);
			
			List fundIdList = query.list();
			
			hibernateSession.getTransaction().commit();
						
			fundIdList.forEach((fundId) -> System.out.println(" fund id : "+fundId ));
			
			List<String> fundList = Arrays.asList(new String[] { "60" });
			
			return fundIdList;
			//return fundList;
			
			
		
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
		
	}
	
	public List<String>  getInvestorCustomerIds(String startDate, String endDate)   {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
			
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("select distinct(customerId) from TransactionDetails where buySell='SELL' and transactionStatus ='8' " + 
					"and TRANSACTION_DATE between cast('"+startDate+"' as date) and cast('"+endDate+"' as date) ");
			
			List customerIdList = query.list();
			
			hibernateSession.getTransaction().commit();
				
			System.out.println(" customerIdList size : "+customerIdList.size());
			customerIdList.forEach((customerId) -> System.out.println(" customerId : "+customerId ));
						
			return customerIdList;		
			
		
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
		
	}
	
	public List<String>  getAllInvestorCustomerIds()   {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
			
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("select distinct(customerId) from Customers  ");
			
			List customerIdList = query.list();
			
			hibernateSession.getTransaction().commit();
				
			System.out.println(" customerIdList size : "+customerIdList.size());
			customerIdList.forEach((customerId) -> System.out.println(" customerId : "+customerId ));
						
			return customerIdList;		
			
		
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
		
	}
	
	public List<String>  getRedemptionFolioNums( String customerId, String fundId )   {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
			
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("select distinct transactionFolioNum from TransactionDetails where customerId = :customerId " + 
					" and transactionFolioNum is not null  and transactionStatus ='8' " + 
					" and fundId = :fundId "
					+ " order by transactionFolioNum ").setParameter("customerId", customerId).setParameter("fundId", fundId);
			
			List folioNumList = query.list();
			
			hibernateSession.getTransaction().commit();
						
			folioNumList.forEach((folioNum) -> System.out.println(" folio Num : "+folioNum ));
			
			
			List<String> folioList = Arrays.asList(new String[] { "91062658524" });
			
			return folioNumList;
			
			//return folioList;
			
			
		
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
		
	}
	
	public String getCustomerName(String customerId) {
		
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			hibernateSession.beginTransaction();
			Customers customer = (Customers)hibernateSession.get(Customers.class,customerId);
			String customerName = customer.getCustomerName();
			hibernateSession.getTransaction().commit();
			
			
			return customerName;
		}
		catch (Exception e ) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public String getFundName(String fundId){

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try
		{
			String schemeName = null;

			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select schemeName from PrimaryFundDetails where fundId = :fundId ");
			query.setParameter("fundId",fundId);
			
			if (query.list().size() != 0) {
				schemeName = query.uniqueResult().toString();
			}

			hibernateSession.getTransaction().commit();
			
			return schemeName;
		}
		catch ( HibernateException e ) {
			e.printStackTrace();
			return null;
		}
		catch (Exception e ) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	
	boolean findPnlTerm ( Date d1, Date d2, String schemeType  )  {
		
		
	      
	      long duration = d2.getTime() - d1.getTime();
	      long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
	      
	      int remainingDays = d2.getYear()% 4;
	      int numOfDaysOfYear = 0;
	      
	      if ("EQUITY".equalsIgnoreCase(schemeType))  {
	      
		      if (remainingDays == 0 )  
		    	  numOfDaysOfYear = 366;
		      else 
		    	  numOfDaysOfYear = 365;
		      
		      }
	      else {
	    	  if ( remainingDays != 0 )
	    		  remainingDays = (d2.getYear()-1)% 4;
	    	  if ( remainingDays != 0 )
	    		  remainingDays = (d2.getYear()-2)% 4;
	    	  
	    	  if (remainingDays == 0 )  
		    	  numOfDaysOfYear = 1096;
		      else 
		    	  numOfDaysOfYear = 1095;
	    	  
	      }
	      
	      if (diffInDays > numOfDaysOfYear) {
	    	  
	         return true;
	      } else {
	         return false;
	      } 
	      
	}

}

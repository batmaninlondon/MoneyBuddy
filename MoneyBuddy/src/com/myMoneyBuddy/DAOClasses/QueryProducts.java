/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.InvestmentDetailsDataModel;
import com.myMoneyBuddy.ModelClasses.PendingOrderDataModel;
import com.myMoneyBuddy.ModelClasses.PortfolioDataModel;
import com.myMoneyBuddy.ModelClasses.SipDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.Utils.CommonUtil;

import java.nio.file.SecureDirectoryStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class QueryProducts {
	
	Logger logger = Logger.getLogger(QueryProducts.class);

	public final double tol = 0.001;  

	public String getTotalUpfrontTransactions(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryProducts class - getTotalUpfrontTransactions method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		Object result;
		String totalUpfrontInvestments ;

		try
		{
			
			hibernateSession.beginTransaction();
			
			totalUpfrontInvestments = hibernateSession.createQuery("select count(distinct(productId)) from TransactionDetails   where transactionType='UPFRONT' and customerId='"+customerId+"' ").uniqueResult().toString();
			
			hibernateSession.getTransaction().commit();

				
			logger.debug("QueryProducts class - getTotalUpfrontTransactions method - customerId - "+customerId+" - return totalUpfrontInvestments - "+totalUpfrontInvestments);
			logger.debug("QueryProducts class - getTotalUpfrontTransactions method - customerId - "+customerId+" - end");
			
			return totalUpfrontInvestments;
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class - getTotalUpfrontTransactions method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class - getTotalUpfrontTransactions method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public String getTotalSipTransactions(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryProducts class - getTotalSipTransactions method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		Object result;
		String totalSips ;

		try
		{
			
			hibernateSession.beginTransaction();
			
			totalSips = hibernateSession.createQuery("select count(distinct(productId)) from TransactionDetails   where transactionType='SIP' and customerId='"+customerId+"' ").uniqueResult().toString();
			
			hibernateSession.getTransaction().commit();


				
			logger.debug("QueryProducts class - getTotalSipTransactions method - customerId - "+customerId+" - return totalSips - "+totalSips);
			logger.debug("QueryProducts class - getTotalSipTransactions method - customerId - "+customerId+" - end");
			
			return totalSips;
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class - getTotalSipTransactions method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class - getTotalSipTransactions method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public String getTotalPendingTransactions(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryProducts class - getTotalPendingTransactions method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		Object result;
		String totalPendingTransactions ;

		try
		{
			
			hibernateSession.beginTransaction();
			
			totalPendingTransactions = hibernateSession.createQuery("select count(*) from TransactionDetails   where transactionStatus='5' and customerId='"+customerId+"' ").uniqueResult().toString();
			
			hibernateSession.getTransaction().commit();


			System.out.println(" Total Pending orders are : "+totalPendingTransactions);
				
			logger.debug("QueryProducts class - getTotalPendingTransactions method - customerId - "+customerId+" - return totalPendingTransactions - "+totalPendingTransactions);
			logger.debug("QueryProducts class - getTotalPendingTransactions method - customerId - "+customerId+" - end");
			
			return totalPendingTransactions;
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class - getTotalPendingTransactions method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class - getTotalPendingTransactions method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	
	public HashMap<String,Double> getProductAmountList(HashMap<String,Double> productRatioList,Double amount,String folioNum) throws MoneyBuddyException
	{

		try
		{
			logger.debug("QueryProducts class - getProductAmountList method - start");
		
			System.out.println("amount passed to getProductAmountList is : "+amount);
			HashMap<String,Double> hashMap = new HashMap<String,Double>();
			
			Iterator it=productRatioList.entrySet().iterator();
			
			while ( it.hasNext())  {
				Map.Entry pair = (Map.Entry)it.next();		
				hashMap.put(pair.getKey().toString()+":"+folioNum,((amount*Double.parseDouble(pair.getValue().toString()))/100));
				System.out.println("product id : "+pair.getKey().toString()+" and amount : "+((amount*Double.parseDouble(pair.getValue().toString()))/100)+" stored in ProductAmountList");

			}

			logger.debug("QueryProducts class - getProductAmountList method - end");
			
			return hashMap;
		}
		catch (NumberFormatException e ) {
			logger.error("QueryProducts class - getProductAmountList method - Caught NumberFormatException ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class - getProductAmountList method - Caught HibernateException ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class - getProductAmountList method - Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}

	}    

	public List<PortfolioDataModel> getPortfolioData(String customerId) throws MoneyBuddyException {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		double soldUnit = 0.0;
		
		double totalXirr = 0.0;
		List<Double> totalAmounts = new ArrayList<Double>();
	    List<Date> totalDates = new ArrayList<Date>();
	       
		try
		{
			logger.debug("QueryProducts class - getPortfolioData method - customerId - "+customerId+" - start");
		
			Date todayDate = Calendar.getInstance().getTime();
			SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
			
			hibernateSession.beginTransaction();

			List<PortfolioDataModel> portfolioDataModel = new LinkedList<PortfolioDataModel>();
			
            Query buyRecordsQuery, buySellRecordsQuery;
          
			Query query = hibernateSession.createQuery("select distinct(x.fundId), x.schemeCode from SecondaryFundDetails x, TransactionDetails y where x.fundId = y.productId and y.customerId = :customerId and y.transactionStatus = '8' ");
			
			query.setParameter("customerId",customerId);
	           
			for(Iterator itFunds=query.iterate(); itFunds.hasNext();)	{
				
				Object[] rowFunds = (Object[]) itFunds.next();
			     
				
				// TRY TO MERGE FOUR QUERIES IN ONE - START

				query = hibernateSession.createQuery("select t.transactionFolioNum,  p.schemeName,p.schemeType, n.navValue, min(t.transactionDate ),t.transactionDetailId "
						+ " from PrimaryFundDetails p, NavHistory n, TransactionDetails t "
						+ " where p.fundId = :productId and p.fundId=t.productId and t.customerId= :customerId and t.transactionStatus='8' "
						+ "and n.navDate = (select max(navDate) from NavHistory where n.fundId = :productId) group by t.transactionFolioNum ");
				
				/*query = hibernateSession.createQuery("select t.transactionFolioNum,  p.schemeName,p.schemeType, n.navValue, min(t.transactionDate ),t.transactionDetailId "
						+ " from PrimaryFundDetails p, NavHistory n, TransactionDetails t "
						+ " where p.fundId = :productId and p.fundId=t.productId and t.customerId= :customerId and t.transactionStatus='8' "
						+ "and n.navDate = (select max(navDate) from NavHistory where n.fundId = :productId) group by t.transactionFolioNum ");*/
				
				
				 
				query.setParameter("customerId",customerId);
				query.setParameter("productId", rowFunds[0].toString());
				
				for(Iterator queryIt=query.iterate(); queryIt.hasNext();){

					Object[] queryRow = (Object[]) queryIt.next();			
										
					double investedAmount = 0.0;
					double availableUnits = 0.0;
					double currentAmount = 0.0;
					double xirr = 0.0;
					
					 List<Double> amounts = new ArrayList<Double>();
				     List<Date> dates = new ArrayList<Date>();
	  
				     String oldstring;
				     
				     String schemeName = null;
				     String schemeType = null;
				     String currentNavValue = null;
				     String transactionStartDate = null;
				     DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
				     Date date;
				    	 
				    	schemeName = queryRow[1].toString();
				     	schemeType = queryRow[2].toString();
				     	currentNavValue = queryRow[3].toString();
				     	transactionStartDate = queryRow[4].toString();
				     	//System.out.println("transactionStartDate : " + transactionStartDate);
	     
				     	date = (Date)formatter.parse(transactionStartDate);
					     transactionStartDate = newFormat.format(date);
					     //System.out.println("transactionStartDate : "+transactionStartDate);

				     // TRY TO MERGE FOUR QUERIES IN ONE - END
				     				         
				     buySellRecordsQuery = hibernateSession.createQuery("select transactionDetailId, transactionAmount, quantity, unitPrice, transactionDate, buySell "
				     		+ " from TransactionDetails where productId='"+rowFunds[0]+"' and customerId='"+customerId+"' and transactionFolioNum ='"+queryRow[0].toString()+"' and unitPrice is not null ");
				       
				     java.util.List buySellList = buySellRecordsQuery.list();
				     
				     for (Iterator buySellIt=buySellList.iterator(); buySellIt.hasNext();)  {
				    	   
				    	 Object[] buySellRecordRow = (Object[]) buySellIt.next();
					       
				    	 if ("SELL".equals(buySellRecordRow[5].toString()))  {
					    	 soldUnit += Double.parseDouble(buySellRecordRow[2].toString());
					    	 //System.out.println("Product transactionDetail for SEll - id : "+sellRecordRow[0]+" amount: "+sellRecordRow[1]+" unit: "+sellRecordRow[2]+" unitPrice: "+sellRecordRow[3] +" : transactionDate : "+sellRecordRow[4]);
						       
					    	 oldstring = buySellRecordRow[4].toString().substring(0, 10);
		
					    	 date = (Date)formatter.parse(oldstring);
					    	 String transactionDate = newFormat.format(date);
					    	 //System.out.println("transactionDate : "+transactionDate);
					       	
					    	 dates.add(strToDate(transactionDate));
					    	 amounts.add(Double.parseDouble(buySellRecordRow[1].toString())*-1);
					           
					    	 totalDates.add(strToDate(transactionDate));
					    	 totalAmounts.add(Double.parseDouble(buySellRecordRow[1].toString())*-1);
					           
					    	 //System.out.println("Added : date : "+strToDate(transactionDate)+" : amount : "+(Double.parseDouble(sellRecordRow[1].toString())*-1));
					     
				    	 }
				     }
				       
				     //System.out.println("Total sold units : "+soldUnit);
				   /*  System.out.println(" called query 3 for BUY records !! ");  
				     buyRecordsQuery = hibernateSession.createQuery("select transactionDetailId, transactionAmount, quantity, unitPrice, transactionDate from TransactionDetails where productId='"+rowFunds[0]+"' and customerId='"+customerId+"' and transactionFolioNum ='"+queryRow[0].toString()+"' and buySell='BUY' and unitPrice is not null ");
				       
				     */
				     
				     for (Iterator buySellIt=buySellList.iterator(); buySellIt.hasNext();)  {
				    	   
				    	 Object[] buySellRecordRow = (Object[]) buySellIt.next();
					       
				    	// System.out.println("Product transactionDetail for BUY - id : "+buyRecordRow[0]+" amount: "+buyRecordRow[1]+" unit: "+buyRecordRow[2]+" unitPrice: "+buyRecordRow[3]+" : transactionDate : "+buyRecordRow[4]);
				    	 if ("BUY".equals(buySellRecordRow[5].toString()))  {
					       
				    	 if (soldUnit != 0 )   {
						    	   
				    		 if (Double.parseDouble(buySellRecordRow[2].toString()) > soldUnit)  {
				    			 availableUnits += (Double.parseDouble(buySellRecordRow[2].toString()) - soldUnit);
				    			 //System.out.println(" availableUnits : "+String.format("%.4f", availableUnits));
				    			 investedAmount += (Double.parseDouble(buySellRecordRow[2].toString()) - soldUnit)* (Double.parseDouble(buySellRecordRow[3].toString()));
				    			 //System.out.println(" investedAmount : "+String.format("%.2f",investedAmount));
				    		   
				    			 soldUnit = 0;
						    		   
				    		 }
				    		 else {
				    			 soldUnit -= Double.parseDouble(buySellRecordRow[2].toString());
						    		   
				    		 }
				    	 }
						       
				    	 else {
				    		 availableUnits +=  Double.valueOf(buySellRecordRow[2].toString());
	
				    		 //System.out.println(" availableUnits : "+String.format("%.2f", availableUnits));
				    		 investedAmount += (Double.parseDouble(buySellRecordRow[1].toString()));
				    		 //System.out.println(" investedAmount : "+String.format("%.2f",investedAmount));
				    	 }
						       
				    	 oldstring = buySellRecordRow[4].toString().substring(0, 10);
	 
				    	 date = (Date)formatter.parse(oldstring);
						       	
				    	 String transactionDate = newFormat.format(date);
				    	 //System.out.println("transactionDate : "+transactionDate);
						       	
				    	 dates.add(strToDate(transactionDate));
				    	 
				    	 /*System.out.println("AMOUNT ADDED FOR XIRR : "+Double.parseDouble(buyRecordRow[1].toString()));
				    	 System.out.println("transactionDate : "+transactionDate);
				    	 System.out.println("DATE ADDED FOR XIRR : "+strToDate(transactionDate));*/
				    	 amounts.add(Double.parseDouble(buySellRecordRow[1].toString()));
					           
				    	 
				         
				         
				    	 totalDates.add(strToDate(transactionDate));
				    	 totalAmounts.add(Double.parseDouble(buySellRecordRow[1].toString()));
				    	 
				    	/* System.out.println("AMOUNT ADDED FOR TOTAL XIRR : "+Double.parseDouble(buyRecordRow[1].toString()));
				    	 System.out.println("DATE ADDED FOR TOTAL XIRR : "+strToDate(transactionDate));
					     
					     
				    	 System.out.println("Added : date : "+strToDate(transactionDate)+" : amount : "+(Double.parseDouble(buyRecordRow[1].toString())));*/
				       
				     
				    	 }
				     }
				       
				     currentAmount = availableUnits* Double.parseDouble(currentNavValue);
				     //rateOfGrowth = ((currentAmount - investedAmount)/investedAmount)*100;
			       
				     amounts.add(currentAmount*-1);
				     dates.add(strToDate(newFormat.format(todayDate)));
			         
				     xirr = Newtons_method(0.1, amounts, dates);
				     xirr = xirr*100;
				     
				     /*System.out.println("Total availableUnits : "+ String.format("%.4f", availableUnits));
				     System.out.println("Total invested Amount : "+ String.format("%.4f", investedAmount));
				     System.out.println("Current Amount : "+ String.format("%.4f", currentAmount));
				     System.out.println("XIRR : "+ String.format("%.2f", xirr));*/
				      
				       
				     portfolioDataModel.add(new PortfolioDataModel(rowFunds[0].toString(),schemeName,queryRow[0].toString(),String.format("%.4f", availableUnits),String.format("%.2f",investedAmount),String.format("%.2f",currentAmount),String.format("%.2f",(currentAmount-investedAmount)),String.format("%.2f",xirr),transactionStartDate,schemeType));
				
				
				}
			}
			
			
			
			Double totalInvestedAmount = 0.0;
			Double totalCurrentAmount = 0.0;
			for ( PortfolioDataModel portfolioDataModelElement : portfolioDataModel )  {
					
					
				totalInvestedAmount = totalInvestedAmount + Double.parseDouble(portfolioDataModelElement.getInvestedAmount());
				totalCurrentAmount = totalCurrentAmount + Double.parseDouble(portfolioDataModelElement.getCurrentAmount());
			}
				
			Double TotalrateOfGrowth = ((totalCurrentAmount - totalInvestedAmount)/totalInvestedAmount)*100;

			totalAmounts.add(totalCurrentAmount*-1);
			totalDates.add(strToDate(newFormat.format(todayDate)));
		     
			totalXirr = Newtons_method(0.1, totalAmounts, totalDates);
			totalXirr = totalXirr*100;
			
			System.out.println("TOTAL XIRR : "+ String.format("%.2f", totalXirr));
			
			portfolioDataModel.add(new PortfolioDataModel("","Total","","",String.format("%.2f",totalInvestedAmount),String.format("%.2f",totalCurrentAmount),String.format("%.2f",(totalCurrentAmount-totalInvestedAmount)),String.format("%.2f",totalXirr),"",""));

			logger.debug("QueryProducts class - getPortfolioData method - customerId - "+customerId+" - return portfolioDataModel of "+portfolioDataModel.size()+ " record");
			logger.debug("QueryProducts class - getPortfolioData method - customerId - "+customerId+" - end");
				
			return portfolioDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryProducts class - getPortfolioData method - customerId - "+customerId+" - Caught NumberFormatException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class - getPortfolioData method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class - getPortfolioData method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

	public List<PendingOrderDataModel> getPendingOrderData(String customerId) throws MoneyBuddyException {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		double investedAmount = 0.0;
	       
		try
		{
			logger.debug("QueryProducts class - getPendingOrderData method - customerId - "+customerId+" - end");
		
			hibernateSession.beginTransaction();

			List<PendingOrderDataModel> pendingOrderDataModel = new LinkedList<PendingOrderDataModel>();
			
            Query buyRecordsQuery, sellRecordsQuery;
			Query query = hibernateSession.createQuery("select t.productId, t.transactionDetailId, p.schemeName , t.transactionAmount, t.transactionDate, t.transactionType "
										+ "from TransactionDetails t , PrimaryFundDetails p where t.customerId = :customerId and t.transactionStatus='5' and t.productId = p.fundId");
			
			query.setParameter("customerId",customerId);
	           
			 for(Iterator it=query.iterate(); it.hasNext();){		      
				 Object[] row = (Object[]) it.next();
				 
				 if ("UPFRONT".equals(row[5].toString()))
					 pendingOrderDataModel.add(new PendingOrderDataModel(row[0].toString(),row[1].toString(),row[2].toString(),row[3].toString(),"0","Payment Awiated",row[4].toString().substring(0,10),row[5].toString()));
				 else 
					 pendingOrderDataModel.add(new PendingOrderDataModel(row[0].toString(),row[1].toString(),row[2].toString(),"0",row[3].toString(),"Payment Awiated",row[4].toString().substring(0,10),row[5].toString()));
			 }

			 hibernateSession.getTransaction().commit();
			 
			/* for ( int i =0;i<pendingOrderDataModel.size();i++)  {
					
					System.out.println("pendingOrderDataModel.get("+i+").getTransactionId()"+pendingOrderDataModel.get(i).getTransactionId());
					
				}*/

			 logger.debug("QueryProducts class - getPendingOrderData method - customerId - "+customerId+" - return pendingOrderDataModel containing "+pendingOrderDataModel.size()+" records");
			 logger.debug("QueryProducts class - getPendingOrderData method - customerId - "+customerId+" - end");
			 
			return pendingOrderDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryProducts class - getPendingOrderData method - customerId - "+customerId+" - Caught NumberFormatException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class - getPendingOrderData method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class - getPendingOrderData method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}
	
	public List<SipDataModel> getSipData(String customerId) throws MoneyBuddyException {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	       
		try
		{
			logger.debug("QueryProducts class - getSipData method - customerId - "+customerId+" - start");
		
			hibernateSession.beginTransaction();

			List<SipDataModel> sipDataModel = new LinkedList<SipDataModel>();

			//Query query = hibernateSession.createQuery("from SipDetails where customerId = :customerId and sipEndDate  > curdate()");
			
			Query sipData = hibernateSession.createQuery("select t.transactionDetailId, p.fundId, p.schemeName, p.schemeType,"
					+ "t.transactionAmount,t.transactionFolioNum, s.sipDate,s.sipStartDate "
					+ "from TransactionDetails t, PrimaryFundDetails p, SipDetails s "
					+ "where t.customerId= :customerId and t.productId = p.fundId and t.transactionType='SIP' "
					+ "and t.transactionDetailId=s.transactionDetailId and s.customerId=t.customerId and s.sipEndDate > curdate()");

			sipData.setParameter("customerId",customerId);
			
			/*List<SipDetails> sipDetailsList = query.list();*/
			
			hibernateSession.getTransaction().commit();
			
			/*List<Object[]> rows = null;*/
			//String sipDate = null;
			
			/*Calendar cal = Calendar.getInstance();
			int currentDate = cal.get(Calendar.DAY_OF_MONTH);
			int currentMonth = cal.get(Calendar.MONTH);
			int currentYear = cal.get(Calendar.YEAR);
			String nextSipMonth = null;
			String nextSipYear = null;
			String nextSipDate = null;*/
			/*for (SipDetails sipDetailsListElement : sipDetailsList)  {*/
			
			  for (Iterator sipDataIt=sipData.iterate(); sipDataIt.hasNext();)  {
				  
				 
				
				  Object[] sipDataRow = (Object[]) sipDataIt.next();
				  
				  System.out.println("sipStartDate : "+sipDataRow[7].toString()+" sip fund id : "+sipDataRow[1].toString()+" fur customerId : "+customerId);
				  
				  
				//sipDate = sipDataRow[6].toString();
				
				/*CommonUtil commonUtil = new CommonUtil();
				if (Integer.parseInt(sipDate) < currentDate)  {
					if (currentMonth == 11)  {
						nextSipMonth = "01";
						nextSipYear = Integer.toString(currentYear + 1);
						nextSipDate = nextSipYear+"-"+nextSipMonth+"-"+sipDate;
					}
					else {
						nextSipMonth = commonUtil.theMonth(cal.get(Calendar.MONTH)+1);
						nextSipYear = Integer.toString(currentYear);
						nextSipDate = nextSipYear+"-"+nextSipMonth+"-"+sipDate;
					}
				}
				else {
					nextSipMonth = commonUtil.theMonth(cal.get(Calendar.MONTH));
					nextSipYear = Integer.toString(currentYear);
					nextSipDate = nextSipYear+"-"+nextSipMonth+"-"+sipDate;
					
				}*/
				

				/*hibernateSession.beginTransaction();
				query = hibernateSession.createQuery("select f.fundId,f.schemeName,f.schemeType,t.transactionAmount,t.transactionFolioNum from TransactionDetails t, PrimaryFundDetails f where t.transactionDetailId= :transactionDetailId and t.productId = f.fundId ");
				query.setParameter("transactionDetailId", sipDetailsListElement.getTransactionDetailId());
							
				rows = query.list();
				hibernateSession.getTransaction().commit();*/
				
				String folioNum = null;
				if (null != sipDataRow[5])  
					folioNum = sipDataRow[5].toString();
				else 
					folioNum="";
				
				
				sipDataModel.add(new SipDataModel(sipDataRow[7].toString(),sipDataRow[1].toString(),sipDataRow[2].toString(),folioNum,sipDataRow[3].toString(),
									sipDataRow[4].toString(),sipDataRow[6].toString()));
			}
			
			logger.debug("QueryProducts class - getSipData method - customerId - "+customerId+" - return sipDataModel containing "+sipDataModel.size()+" records");
			logger.debug("QueryProducts class - getSipData method - customerId - "+customerId+" - end");
			
			return sipDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryProducts class - getSipData method - customerId - "+customerId+" - Caught NumberFormatException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class - getSipData method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class - getSipData method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

	public List<InvestmentDetailsDataModel> getAllFundsInvestmentDetailsData(String customerId) throws MoneyBuddyException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try
		{
			logger.debug("QueryProducts class - getAllFundsInvestmentDetailsData method - customerId - "+customerId+" - start ");
			
			System.out.println("getInvestmentDetailsData : customerId : "+customerId);
		
			hibernateSession.beginTransaction();

			/*Query query = hibernateSession.createQuery("select distinct(productId) from TransactionDetails  where customerId = :customerId ");*/
			
			Query allFundsData = hibernateSession.createQuery("select distinct p.schemeName, t.transactionDetailId, t.transactionType, t.buySell,"
					+ " t.buySellType, t.transactionAmount, t.quantity, t.unitPrice, t.transactionDate, t.transactionFolioNum "
					+ " from TransactionDetails t, PrimaryFundDetails p "
					+ "  where t.productId=p.fundId and t.customerId = :customerId and t.unitPrice is not null");
			
			allFundsData.setParameter("customerId",customerId);
			/*
			List<String> productIdList = query.list();*/
			hibernateSession.getTransaction().commit();
			
			int i = 0;

			List<InvestmentDetailsDataModel> allFundsInvestmentDetailsDataModel = new LinkedList<InvestmentDetailsDataModel>();
			
			for (Iterator allFundsDataIt=allFundsData.iterate(); allFundsDataIt.hasNext();)  {
		
				Object[] allFundsDataRow = (Object[]) allFundsDataIt.next();
			
						
			/*for (String productId : productIdList)  {*/
				/*System.out.println("getAllFundsInvestmentDetailsData : productId : "+productId);*/
				
				/*hibernateSession.beginTransaction();
				query = hibernateSession.createQuery("select schemeName from PrimaryFundDetails where fundId = :fundId");
				String schemeName = query.setParameter("fundId",productId).uniqueResult().toString();*/
				
				
				/*query = hibernateSession.createQuery("select transactionDate,quantity,unitPrice,transactionType,buySell,transactionDetailId,transactionAmount,buySellType,transactionFolioNum"
								+ " from TransactionDetails where productId='"+productId+"' and customerId='"+customerId+"' and unitPrice is not null");
				       */
				String quantity;
				/*for (Iterator it=query.iterate(); it.hasNext();)  {*/
				    i++;
				    
				    
					//TransactionDetails transactionDetailsRow = (TransactionDetails) allFundsDataRow[1];
					
					if ( ("SELL").equals(allFundsDataRow[3].toString()) ) {
						quantity = "-"+allFundsDataRow[6].toString();
					}
					else {
						quantity = allFundsDataRow[6].toString();
					}

					
					//String pattern = "HH:mm:ss";
					
					Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(allFundsDataRow[8].toString().substring(0,10));  
					
					
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
					String date = simpleDateFormat.format(date1);
					
					String investmentType = allFundsDataRow[2].toString();
					String buySell = allFundsDataRow[3].toString();
					String buySellType = allFundsDataRow[4].toString();
					String transactionType = null;
					
					if ("UPFRONT".equals(investmentType) && "BUY".equals(buySell) &&  "FRESH".equals(buySellType))  
						transactionType = "New Investment";
					else if ("UPFRONT".equals(investmentType) && "BUY".equals(buySell) &&  "ADDITIONAL".equals(buySellType))
						transactionType = "Additional Investments";
					else if ("UPFRONT".equals(investmentType) && "SELL".equals(buySell) &&  "PARTIAL".equals(buySellType))
						transactionType = "Partial Redemption";
					else if ("UPFRONT".equals(investmentType) && "SELL".equals(buySell) &&  "FULL".equals(buySellType))
						transactionType = "Full Redemption";
					else if ("SIP".equals(investmentType) && "BUY".equals(buySell) )
						transactionType = "SIP Investment";
					else if ("STP".equals(investmentType) && "BUY".equals(buySell) )
						transactionType = "STP Investment";
					else if ("STP".equals(investmentType) && "SELL".equals(buySell) )
						transactionType = "STP Redemption";
					
					String folioNum = null;
					
					if (null != allFundsDataRow[9])
						folioNum = allFundsDataRow[9].toString();
					else 
						folioNum=""; 
						
					allFundsInvestmentDetailsDataModel.add(new InvestmentDetailsDataModel(allFundsDataRow[1].toString(),allFundsDataRow[0].toString(),folioNum,
							date,allFundsDataRow[5].toString(),quantity,allFundsDataRow[7].toString(),transactionType ));
					
				/*}*/
				/*hibernateSession.getTransaction().commit();*/
				
				
			/*}*/
			}
			
			System.out.println(" Total number of fetched record is : "+i);

			System.out.println("getInvestmentDetailsData : investmentDetailsDataModel.size() : "+allFundsInvestmentDetailsDataModel.size());
			
			logger.debug("QueryProducts class - getAllFundsInvestmentDetailsData method - customerId - "+customerId+" - returns allFundsInvestmentDetailsDataModel containing "+allFundsInvestmentDetailsDataModel.size()+" records");
			logger.debug("QueryProducts class - getAllFundsInvestmentDetailsData method - customerId - "+customerId+" - end");
			
			return allFundsInvestmentDetailsDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryProducts class - getAllFundsInvestmentDetailsData method - customerId - "+customerId+" - Caught NumberFormatException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class - getAllFundsInvestmentDetailsData method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class - getAllFundsInvestmentDetailsData method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}

	}

	public List<InvestmentDetailsDataModel> getInvestmentDetailsData(String customerId, String schemeName) throws MoneyBuddyException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	
	try
	{
		logger.debug("QueryProducts class - getInvestmentDetailsData method - customerId - "+customerId+" - end");
		
		System.out.println("getInvestmentDetailsData : customerId : "+customerId);
		System.out.println("getInvestmentDetailsData : schemeName : "+schemeName);
	
		hibernateSession.beginTransaction();

		List<InvestmentDetailsDataModel> investmentDetailsDataModel = new LinkedList<InvestmentDetailsDataModel>();
		
		Object result = hibernateSession.createQuery("select fundId from PrimaryFundDetails  where schemeName='"+schemeName+"'").uniqueResult();

		String productId = null;
		if (result != null)
			productId = result.toString();
		System.out.println("getInvestmentDetailsData : productId : "+productId);
		Query query = hibernateSession.createQuery("select transactionDate,quantity,unitPrice,transactionType,buySell,transactionDetailId,transactionAmount,buySellType,transactionFolioNum"
				+ " from TransactionDetails where productId='"+productId+"' and customerId='"+customerId+"' and unitPrice is not null");
		       
		String quantity;
		for (Iterator it=query.iterate(); it.hasNext();)  {
		    
			Object[] transactionDetailsRow = (Object[]) it.next();
			if ( transactionDetailsRow[4].toString().equals("SELL") ) {
				quantity = "-"+transactionDetailsRow[1].toString();
			}
			else {
				quantity = transactionDetailsRow[1].toString();
			}

			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(transactionDetailsRow[0].toString().substring(0,10));  
			
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
			String date = simpleDateFormat.format(date1);
			
			String investmentType = transactionDetailsRow[3].toString();
			String buySell = transactionDetailsRow[4].toString();
			String buySellType = transactionDetailsRow[7].toString();
			String transactionType = null;
			
			if ("UPFRONT".equals(investmentType) && "BUY".equals(buySell) &&  "FRESH".equals(buySellType))  
				transactionType = "New Investment";
			else if ("UPFRONT".equals(investmentType) && "BUY".equals(buySell) &&  "ADDITIONAL".equals(buySellType))
				transactionType = "Additional Investments";
			else if ("UPFRONT".equals(investmentType) && "SELL".equals(buySell) &&  "PARTIAL".equals(buySellType))
				transactionType = "Partial Redemption";
			else if ("UPFRONT".equals(investmentType) && "SELL".equals(buySell) &&  "FULL".equals(buySellType))
				transactionType = "Full Redemption";
			else if ("SIP".equals(investmentType) && "BUY".equals(buySell) )
				transactionType = "SIP Investment";
			else if ("STP".equals(investmentType) && "BUY".equals(buySell) )
				transactionType = "STP Investment";
			else if ("STP".equals(investmentType) && "SELL".equals(buySell) )
				transactionType = "STP Redemption";
				
			
			investmentDetailsDataModel.add(new InvestmentDetailsDataModel(transactionDetailsRow[5].toString(),schemeName,transactionDetailsRow[8].toString(),date,transactionDetailsRow[6].toString(),quantity,transactionDetailsRow[2].toString(),transactionType ));
			
		}


		hibernateSession.getTransaction().commit();

		System.out.println("getInvestmentDetailsData : investmentDetailsDataModel.size() : "+investmentDetailsDataModel.size());
		
		logger.debug("QueryProducts class - getInvestmentDetailsData method - customerId - "+customerId+" - retuns investmentDetailsDataModel containing "+investmentDetailsDataModel.size()+" records" );
		logger.debug("QueryProducts class - getInvestmentDetailsData method - customerId - "+customerId+" - end");
		
		return investmentDetailsDataModel;
	}
	catch (NumberFormatException e)
	{
		logger.error("QueryProducts class - getInvestmentDetailsData method - customerId - "+customerId+" - Caught NumberFormatException");
		e.printStackTrace();
		throw new MoneyBuddyException(e.getMessage(),e);
	}
	catch ( HibernateException e ) {
		logger.error("QueryProducts class - getInvestmentDetailsData method - customerId - "+customerId+" - Caught HibernateException");
		e.printStackTrace();
		throw new MoneyBuddyException(e.getMessage(),e);
	}
	catch (Exception e ) {
		logger.error("QueryProducts class - getInvestmentDetailsData method - customerId - "+customerId+" - Caught Exception");
		e.printStackTrace();
		throw new MoneyBuddyException(e.getMessage(),e);
	}
	finally {
		if(hibernateSession !=null )
				hibernateSession.close();
	}

}

	public String getProductName( String fundId) throws MoneyBuddyException  {
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
			logger.debug("QueryProducts class - getProductName method - fundId - "+fundId+" - start");
			
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select schemeName from PrimaryFundDetails where fundId = :fundId");
    	
			query.setParameter("fundId", fundId);
			String schemeName = query.uniqueResult().toString();
			hibernateSession.getTransaction().commit();
			
			
			logger.debug("QueryProducts class - getProductName method - fundId - "+fundId+" - returns schemeName - "+schemeName);
			logger.debug("QueryProducts class - getProductName method - fundId - "+fundId+" - end");
			
			return schemeName;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryProducts class - getProductName method - fundId - "+fundId+" - Caught NumberFormatException ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class - getProductName method - fundId - "+fundId+" - Caught HibernateException ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class - getProductName method - fundId - "+fundId+" - Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}


	public double dateDiff(Date d1, Date d2){
	    long day = 24*60*60*1000;
	
	    return (d1.getTime() - d2.getTime())/day;
	}
	
	public double f_xirr(double p, Date dt, Date dt0, double x) {        
	    return p * Math.pow((1.0 + x), (dateDiff(dt0,dt) / 365.0));
	}
	
	public double df_xirr(double p, Date dt, Date dt0, double x) {        
	    return (1.0 / 365.0) * dateDiff(dt0,dt) * p * Math.pow((x + 1.0), ((dateDiff(dt0,dt) / 365.0) - 1.0));
	}
	
	public double total_f_xirr(List<Double> payments, List<Date> dates, double x) {
	    double resf = 0.0;
	
	    for (int i = 0; i < payments.size(); i++) {
	        resf = resf + f_xirr(payments.get(i), dates.get(i), dates.get(0), x);
	    }
	
	    return resf;
	}
	
	public double total_df_xirr(List<Double> payments, List<Date> dates, double x) {
	    double resf = 0.0;
	
	    for (int i = 0; i < payments.size(); i++) {
	        resf = resf + df_xirr(payments.get(i), dates.get(i), dates.get(0), x);
	    }
	
	    return resf;
	}
	
	public double Newtons_method(double guess, List<Double> payments, List<Date> dates) {
	    double x0 = guess;
	    double x1 = 0.0;
	    double err = 1e+100;
	
	    while (err > tol) {
	        x1 = x0 - total_f_xirr(payments, dates, x0) / total_df_xirr(payments, dates, x0);
	        err = Math.abs(x1 - x0);
	        x0 = x1;
	    }
	
	    return x0;
	}	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Date strToDate(String str){
	    try {
	        return sdf.parse(str);
	    } catch (ParseException ex) {
	        return null;
	    }
	}
	

}

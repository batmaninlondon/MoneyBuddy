/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.InvestmentDetailsDataModel;
import com.myMoneyBuddy.ModelClasses.PendingOrderDataModel;
import com.myMoneyBuddy.ModelClasses.PortfolioDataModel;
import com.myMoneyBuddy.ModelClasses.SipDataModel;
import com.myMoneyBuddy.ModelClasses.StpDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class QueryProducts {
	
	Logger logger = LogManager.getLogger(QueryProducts.class);

	public final double tol = 0.001;  

	public String getTotalUpfrontTransactions(String customerId) throws MoneyBuddyException {
		
		logger.debug("QueryProducts class - getTotalUpfrontTransactions method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		Object result;
		String totalUpfrontInvestments ;

		try
		{
			
			hibernateSession.beginTransaction();
			
			totalUpfrontInvestments = hibernateSession.createQuery("select count(distinct(fundId)) from TransactionDetails   where transactionType='UPFRONT' and customerId='"+customerId+"' ").uniqueResult().toString();
			
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
			
			totalSips = hibernateSession.createQuery("select count(distinct(fundId)) from TransactionDetails   where transactionType='SIP' and customerId='"+customerId+"' ").uniqueResult().toString();
			
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
			
			totalPendingTransactions = hibernateSession.createQuery("select count(*) from TransactionDetails   where transactionStatus in ('7') and customerId='"+customerId+"' ").uniqueResult().toString();
			
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
		/*double soldUnit = 0.0;
		
		 if (soldUnit != 0 )   {
    		 System.out.println("Inside the loop of IF - sold unit ARE NOT zero ");
		    	   
		 }
		 else {
			 System.out.println("Inside the loop of ELSE - sold unit ARE  zero ");
		 }*/
		
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
			
            Query  buySellRecordsQuery;
          
			Query query = hibernateSession.createQuery("select x.fundId, y.transactionFolioNum, x.schemeCode "
					+ " from SecondaryFundDetails x, TransactionDetails y " + 
					" where x.fundId = y.fundId and y.customerId = :customerId and y.transactionStatus = '8' group by x.fundId, y.transactionFolioNum ");
			
			query.setParameter("customerId",customerId);
	          
			Double totalInvestedAmount = 0.0;
			Double totalCurrentAmount = 0.0;
			
			String stpWithdrawalFlag = "Y";
			for(Iterator itFunds=query.iterate(); itFunds.hasNext();)	{
				double soldUnit = 0.0;
				/*
				 if (soldUnit != 0 )   {
		    		 System.out.println("Inside the loop of IF - sold unit ARE NOT zero ");
				    	   
				 }
				 else {
					 System.out.println("Inside the loop of ELSE - sold unit ARE  zero ");
				 }*/
				
				Object[] rowFunds = (Object[]) itFunds.next();

				/*query = hibernateSession.createQuery("select t.transactionFolioNum,  p.schemeName,p.schemeType, "
						+ "(select navValue from NavHistory where fundId = :fundId order by navHistoryId desc limit 1),"
						+ " min(t.transactionDate ),t.transactionDetailId,"
						+ " p.stpWithdrawalFlag "
						+ " from PrimaryFundDetails p, TransactionDetails t  "
						+ " where p.fundId = :fundId and p.fundId=t.fundId and t.customerId= :customerId and t.transactionStatus='8' "
						+ " group by t.transactionFolioNum ");
				
				query.setParameter("customerId",customerId);
				query.setParameter("fundId", rowFunds[0].toString());
				
				for(Iterator queryIt=query.iterate(); queryIt.hasNext();){*/

					/*Object[] queryRow = (Object[]) queryIt.next();	*/		
										
					double investedAmount = 0.0;
					double availableUnits = 0.0;
					double currentAmount = 0.0;
					double xirr = 0.0;
					
					 List<Double> amounts = new ArrayList<Double>();
				     List<Date> dates = new ArrayList<Date>();
	  
				     String oldstring;
				     
				     String schemeName = null;
				     String schemeType = null;
				    // String currentNavValue = null;
				     //String transactionStartDate = null;
				     DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
				     Date date;
				    	 
			    	
			     	/*transactionStartDate = queryRow[4].toString();
     
			     	date = (Date)formatter.parse(transactionStartDate);
			     	transactionStartDate = newFormat.format(date);*/
				     	
				     query = hibernateSession.createQuery("select navValue from NavHistory where fundId = :fundId order by navHistoryId desc ");
						query.setParameter("fundId",rowFunds[0].toString());
						query.setMaxResults(1);
						String currentNavValue = query.uniqueResult().toString();
				     
						System.out.println("currentNavValue : "+currentNavValue+" for fund is : "+rowFunds[0].toString());
						
			     	buySellRecordsQuery = hibernateSession.createQuery("select t.transactionDetailId, t.transactionAmount, t.quantity, t.unitPrice,"
			     			+ " t.updateDate, t.buySell , t.transactionFolioNum,  p.schemeName,p.schemeType, p.stpWithdrawalFlag " + 
			     			" from TransactionDetails t, PrimaryFundDetails p " + 
			     			" where p.fundId=t.fundId and p.fundId= :fundId and t.customerId= :customerId and t.transactionFolioNum = :transactionFolioNum " + 
			     			" and t.unitPrice is not null and t.transactionStatus='8'" );
				      
			     	buySellRecordsQuery.setParameter("customerId",customerId);
			     	buySellRecordsQuery.setParameter("fundId",rowFunds[0].toString());
			     	buySellRecordsQuery.setParameter("transactionFolioNum", rowFunds[1].toString());
			     	
			     	java.util.List buySellList = buySellRecordsQuery.list();
				     
			     	for (Iterator buySellIt=buySellList.iterator(); buySellIt.hasNext();)  {
				     	
			     		
			     		
				    	 Object[] buySellRecordRow = (Object[]) buySellIt.next();
				    	 
				    	 schemeName = buySellRecordRow[7].toString();
				     	schemeType = buySellRecordRow[8].toString();
				     	//currentNavValue = buySellRecordRow[10].toString();
				     	stpWithdrawalFlag = buySellRecordRow[9].toString();
				     	
				    	 if ("SELL".equals(buySellRecordRow[5].toString()))  {
				    		 System.out.println("Inside the loop of SELL for fund id : "+rowFunds[0].toString()+" for buy");
					    	 soldUnit += Double.parseDouble(buySellRecordRow[2].toString());
					    	 oldstring = buySellRecordRow[4].toString().substring(0, 10);
		
					    	 date = (Date)formatter.parse(oldstring);
					    	 String updateDate = newFormat.format(date);
					    	 
					    	 dates.add(strToDate(updateDate));
					    	 amounts.add(Double.parseDouble(buySellRecordRow[1].toString())*-1);
					           
					    	 totalDates.add(strToDate(updateDate));
					    	 totalAmounts.add(Double.parseDouble(buySellRecordRow[1].toString())*-1);
					         
				    	 }
			     	}
				     
			     	for (Iterator buySellIt=buySellList.iterator(); buySellIt.hasNext();)  {
				    	   
				    	 Object[] buySellRecordRow = (Object[]) buySellIt.next();
					       
				    	if ("BUY".equals(buySellRecordRow[5].toString()))  {
					       
				    		 System.out.println("Inside the loop of BUY for fund id : "+rowFunds[0].toString()+" for buy");
				    		
					    	 if (soldUnit != 0 )   {
					    		 System.out.println("Inside the loop of BUY sold unit ARE NOT zero : for fund id : "+rowFunds[0].toString()+" for buy");
							    	   
					    		 if (Double.parseDouble(buySellRecordRow[2].toString()) > soldUnit)  {
					    			 availableUnits += (Double.parseDouble(buySellRecordRow[2].toString()) - soldUnit);
					    			 investedAmount += (Double.parseDouble(buySellRecordRow[2].toString()) - soldUnit)* (Double.parseDouble(buySellRecordRow[3].toString()));
					    			 soldUnit = 0;	
					    			 System.out.println("availableUnits : "+availableUnits+" are for fund id : "+rowFunds[0].toString()+" for sell");
						    		 System.out.println("investedAmount : "+investedAmount+" are for fund id : "+rowFunds[0].toString()+" for sell");
					    		 }
					    		 else {
					    			 soldUnit -= Double.parseDouble(buySellRecordRow[2].toString());	   
					    		 }
					    	 }
						       
					    	 else {
					    		 System.out.println("Inside the loop of BUY sold unit ARE  zero : for fund id : "+rowFunds[0].toString()+" for buy");
					    		 availableUnits +=  Double.valueOf(buySellRecordRow[2].toString());
					    		 investedAmount += (Double.parseDouble(buySellRecordRow[1].toString()));
					    		 System.out.println("availableUnits : "+availableUnits+" are for fund id : "+rowFunds[0].toString()+" for buy");
					    		 System.out.println("investedAmount : "+investedAmount+" are for fund id : "+rowFunds[0].toString()+" for buy");
					    	 }
						       
					    	 oldstring = buySellRecordRow[4].toString().substring(0, 10);
		 
					    	 date = (Date)formatter.parse(oldstring);
							       	
					    	 String updateDate = newFormat.format(date);
							       	
					    	 dates.add(strToDate(updateDate));
					    	 amounts.add(Double.parseDouble(buySellRecordRow[1].toString()));
						      
					    	 totalDates.add(strToDate(updateDate));
					    	 totalAmounts.add(Double.parseDouble(buySellRecordRow[1].toString()));
					    	 
				    	}
			     	}
				       
			     	System.out.println(" fund id is : "+rowFunds[0].toString());
				     currentAmount = availableUnits* Double.parseDouble(currentNavValue);
				     
				     amounts.add(Math.round((currentAmount*-1) * 100.0) / 100.0);
				     /*amounts.add(currentAmount*-1);*/
				     dates.add(strToDate(newFormat.format(todayDate)));
			         
				     for ( Double amount : amounts)  {
				    	 System.out.println(amount);
				     }
				     for ( Date d : dates)  {
				    	 System.out.println(d);
				     }
				     
				     xirr = Newtons_method(0.1, amounts, dates);
				     xirr = xirr*100;
				     
					String frmtXirr ;
						/*System.out.println("TOTAL XIRR : "+ String.format("%.2f", totalXirr));
						
						String totXirr = String.format("%.2f", totalXirr);*/
						if (( (new Double(Double.NaN)).equals(xirr )) || xirr <= 0.0 )  {
							
							frmtXirr = "NA"; 
						}
						else {
							
							if (String.valueOf(xirr).toLowerCase().contains("e")) {
						       
								frmtXirr = Double.toString(xirr).replace("e", "0");
								frmtXirr = Double.toString(xirr).replace("E", "0");
						    } else
						    	frmtXirr =  String.valueOf(xirr);
							
							
							frmtXirr = String.format("%.2f", Double.parseDouble(frmtXirr));
						}
				     
				     String stpAllowed = "Y";
				     if ("Y".equals(stpWithdrawalFlag))   {
				    	 
				    	 QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
				    	 String availableFundsList = queryPrimaryFundDetails.getAvailableStpFundsList(rowFunds[0].toString());
				    	 
				    	 //System.out.println("availableFundsList :"+availableFundsList+": for fund id : "+rowFunds[0].toString());
				    	 if ("".equals(availableFundsList))  {
				    		 stpAllowed = "N";
				    	 }
				    	 
				    	 if ( "Y".equals(stpAllowed))   {
				    		 String minStpAmount = queryPrimaryFundDetails.getMinStpAmount(rowFunds[0].toString());
				    		 
				    		 if (Double.parseDouble(minStpAmount) > currentAmount)   {
				    			 stpAllowed = "N";
				    		 }
				    	 }
				    	 
				     }
				     else {
				    	 stpAllowed = "N";
				     }
				     
				     System.out.println("availableUnits : "+availableUnits+" and currentAmount : "+currentAmount+" for fund id : "+rowFunds[0].toString());
				     final double THRESHOLD = .0001;
				     final double zeroVal = 0.0;
				     if ( Math.abs(availableUnits - zeroVal) >= THRESHOLD)  {
				    	 System.out.println("availableUnits and zeroVal are not equal using threshold");
					     portfolioDataModel.add(new PortfolioDataModel(rowFunds[0].toString(),schemeName,rowFunds[1].toString(),
					    		  String.format("%.4f", availableUnits),String.format("%.2f",investedAmount),String.format("%.2f",currentAmount),
					    		  String.format("%.2f",(currentAmount-investedAmount)),frmtXirr,schemeType,
					    		  stpAllowed));
					     totalInvestedAmount +=  investedAmount;
					     totalCurrentAmount +=  currentAmount;
				     }
	
				/*}*/
			}

			
			totalInvestedAmount = Double.parseDouble(String.format("%.4f", totalInvestedAmount));
			totalCurrentAmount = Double.parseDouble(String.format("%.4f", totalCurrentAmount));
			/*for ( PortfolioDataModel portfolioDataModelElement : portfolioDataModel )  {
					
					
				totalInvestedAmount = totalInvestedAmount + Double.parseDouble(portfolioDataModelElement.getInvestedAmount());
				totalCurrentAmount = totalCurrentAmount + Double.parseDouble(portfolioDataModelElement.getCurrentAmount());
			}*/
				
			//Double TotalrateOfGrowth = ((totalCurrentAmount - totalInvestedAmount)/totalInvestedAmount)*100;

			totalAmounts.add(totalCurrentAmount*-1);
			totalDates.add(strToDate(newFormat.format(todayDate)));
		     
			totalXirr = Newtons_method(0.1, totalAmounts, totalDates);
			totalXirr = totalXirr*100;
			
			//System.out.println("TOTAL XIRR 1 : "+ totalXirr);
			String totXirr ;
			/*System.out.println("TOTAL XIRR : "+ String.format("%.2f", totalXirr));
			
			String totXirr = String.format("%.2f", totalXirr);*/
			if (( (new Double(Double.NaN)).equals(totalXirr )) || totalXirr <= 0.0 )  {
				
				totXirr = "NA"; 
			}
			else {
				
				if (String.valueOf(totalXirr).toLowerCase().contains("e")) {
			       
					totXirr = Double.toString(totalXirr).replace("e", "0");
					totXirr = Double.toString(totalXirr).replace("E", "0");
			    } else
			    	totXirr =  String.valueOf(totalXirr);
				
				
				totXirr = String.format("%.2f", Double.parseDouble(totXirr));
			}
			
			
			portfolioDataModel.add(new PortfolioDataModel("","Total","","",String.format("%.2f",totalInvestedAmount),String.format("%.2f",totalCurrentAmount),String.format("%.2f",(totalCurrentAmount-totalInvestedAmount)),totXirr,"","N"));

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
	
	public String getTotalCurrentAmount(String customerId) throws MoneyBuddyException {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		double soldUnit = 0.0;
	       
		try
		{
			logger.debug("QueryProducts class - getPortfolioData method - customerId - "+customerId+" - start");
			
			hibernateSession.beginTransaction();
			
			//List<String>  investedAmountList = new LinkedList<String>();
			List<String>  currentAmountList = new LinkedList<String>();
			
            Query buySellRecordsQuery;
          
			Query query = hibernateSession.createQuery("select distinct(x.fundId), x.schemeCode from SecondaryFundDetails x, TransactionDetails y where x.fundId = y.fundId and y.customerId = :customerId and y.transactionStatus = '8' ");
			
			query.setParameter("customerId",customerId);
	           
			for(Iterator itFunds=query.iterate(); itFunds.hasNext();)	{
				
				Object[] rowFunds = (Object[]) itFunds.next();

				query = hibernateSession.createQuery("select t.transactionFolioNum,  p.schemeName,p.schemeType, n.navValue, min(t.transactionDate ),t.transactionDetailId,"
						+ " p.stpWithdrawalFlag "
						+ " from PrimaryFundDetails p, NavHistory n, TransactionDetails t , SecondaryFundDetails s "
						+ " where p.fundId = :fundId and p.fundId=t.fundId and s.fundId=p.fundId and t.customerId= :customerId and t.transactionStatus='8' "
						+ " and t.transactionDate < (curdate()-1) "
						+ "and n.navDate = (select max(navDate) from NavHistory where n.fundId = :fundId) group by t.transactionFolioNum ");
				
				query.setParameter("customerId",customerId);
				query.setParameter("fundId", rowFunds[0].toString());
				
				for(Iterator queryIt=query.iterate(); queryIt.hasNext();){

					Object[] queryRow = (Object[]) queryIt.next();			
										
					//double investedAmount = 0.0;
					double availableUnits = 0.0;
					double currentAmount = 0.0;
				     String currentNavValue = null;
				     
			     	currentNavValue = queryRow[3].toString();
				     				         
			     	buySellRecordsQuery = hibernateSession.createQuery("select transactionDetailId, transactionAmount, quantity, unitPrice, transactionDate, buySell "
				     		+ " from TransactionDetails where fundId='"+rowFunds[0]+"' and customerId='"+customerId+"' and transactionFolioNum ='"+queryRow[0].toString()+"' and unitPrice is not null ");
				       
			     	java.util.List buySellList = buySellRecordsQuery.list();
				     
			     	for (Iterator buySellIt=buySellList.iterator(); buySellIt.hasNext();)  {
				    	   
				    	 Object[] buySellRecordRow = (Object[]) buySellIt.next();
					       
				    	 if ("SELL".equals(buySellRecordRow[5].toString()))  {
					    	 soldUnit += Double.parseDouble(buySellRecordRow[2].toString());
				    	 }
			     	}
				     
			     	for (Iterator buySellIt=buySellList.iterator(); buySellIt.hasNext();)  {
				    	   
				    	 Object[] buySellRecordRow = (Object[]) buySellIt.next();
					       
				    	if ("BUY".equals(buySellRecordRow[5].toString()))  {
					       
					    	 if (soldUnit != 0 )   {
							    	   
					    		 if (Double.parseDouble(buySellRecordRow[2].toString()) > soldUnit)  {
					    			 availableUnits += (Double.parseDouble(buySellRecordRow[2].toString()) - soldUnit);
					    			 //investedAmount += (Double.parseDouble(buySellRecordRow[2].toString()) - soldUnit)* (Double.parseDouble(buySellRecordRow[3].toString()));
					    			 soldUnit = 0;	   
					    		 }
					    		 else {
					    			 soldUnit -= Double.parseDouble(buySellRecordRow[2].toString());	   
					    		 }
					    	 }
						       
					    	 else {
					    		 availableUnits +=  Double.valueOf(buySellRecordRow[2].toString());
					    		 //investedAmount += (Double.parseDouble(buySellRecordRow[1].toString()));
					    	 }
					    	 
				    	}
			     	}
				       
				     currentAmount = availableUnits* Double.parseDouble(currentNavValue);
				     
				     //investedAmountList.add(String.format("%.2f",investedAmount));
				     currentAmountList.add(String.format("%.2f",currentAmount));
	
				}
			}

			
			//Double totalInvestedAmount = 0.0;
			Double totalCurrentAmount = 0.0;
			/*for ( String investedAmountListElement : investedAmountList )  {
					
					
				totalInvestedAmount = totalInvestedAmount + Double.parseDouble(investedAmountListElement);
			}*/
			for ( String currentAmountListElement : currentAmountList )  {
				
				totalCurrentAmount = totalCurrentAmount + Double.parseDouble(currentAmountListElement);
			}

			logger.debug("QueryProducts class - getPortfolioData method - customerId - "+customerId+" - return totalInvestedAmount");
			logger.debug("QueryProducts class - getPortfolioData method - customerId - "+customerId+" - end");
				
			//return String.format("%.2f",totalInvestedAmount);
			
			return String.format("%.2f",totalCurrentAmount);
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
			Query query = hibernateSession.createQuery("select t.fundId, t.transactionDetailId, p.schemeName , t.transactionAmount, t.transactionDate, t.transactionType "
										+ "from TransactionDetails t , PrimaryFundDetails p where t.customerId = :customerId and t.transactionStatus in ('5','7') and t.fundId = p.fundId");
			
			query.setParameter("customerId",customerId);
	           
			 for(Iterator it=query.iterate(); it.hasNext();){		      
				 Object[] row = (Object[]) it.next();

				 pendingOrderDataModel.add(new PendingOrderDataModel(row[0].toString(),row[1].toString(),row[2].toString(),row[3].toString(),"Under process",row[4].toString().substring(0,10),row[5].toString()));
				 
				}

			 hibernateSession.getTransaction().commit();
			 
			 System.out.println("SAVITA WADHWANI : pendingOrderDataModel.size() : "+pendingOrderDataModel.size());
			 
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
		
			System.out.println(" Called getSipData ...........................................................................................");
			hibernateSession.beginTransaction();

			List<SipDataModel> sipDataModel = new LinkedList<SipDataModel>();

			//Query query = hibernateSession.createQuery("from SipDetails where customerId = :customerId and sipEndDate  > curdate()");
			
			Query sipData = hibernateSession.createQuery("select t.transactionDetailId, p.fundId, p.schemeName, p.schemeType,"
					+ "t.transactionAmount,t.transactionFolioNum, s.sipDate,s.sipStartDate "
					+ "from TransactionDetails t, PrimaryFundDetails p, SipDetails s "
					+ "where t.customerId= :customerId and t.fundId = p.fundId and t.transactionType='SIP' "
					+ "and t.transactionDetailId=s.transactionDetailId and s.customerId=t.customerId "
					+ " and s.sipCompletionStatus = 'N' and s.sipEndDate > curdate()");

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
	
	
	public List<StpDataModel> getStpData(String customerId) throws MoneyBuddyException {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
	       
		try
		{
			logger.debug("QueryProducts class - getStpData method - customerId - "+customerId+" - start");
		
			hibernateSession.beginTransaction();

			List<StpDataModel> stpDataModel = new LinkedList<StpDataModel>();

			//Query query = hibernateSession.createQuery("from SipDetails where customerId = :customerId and sipEndDate  > curdate()");
			
			Query stpData = hibernateSession.createQuery("select t.transactionDetailId, s.purchaseFundId, " + 
					"(select schemeName from PrimaryFundDetails where fundId=s.withdrawalFundId ), " + 
					"(select schemeName from PrimaryFundDetails where fundId=s.purchaseFundId ) , " + 
					"t.transactionAmount,t.transactionFolioNum, s.stpDate,s.stpStartDate " + 
					"from TransactionDetails t,  StpDetails s " + 
					"where t.customerId= :customerId and t.transactionType='STP' " + 
					"and t.transactionDetailId=s.transactionDetailId and s.customerId=t.customerId and s.stpEndDate > curdate()");

			stpData.setParameter("customerId",customerId);
			
			/*List<SipDetails> sipDetailsList = query.list();*/
			
			hibernateSession.getTransaction().commit();
			
			  for (Iterator stpDataIt=stpData.iterate(); stpDataIt.hasNext();)  {
				
				Object[] stpDataRow = (Object[]) stpDataIt.next();
				String folioNum = null;
				if (null != stpDataRow[5])  
					folioNum = stpDataRow[5].toString();
				else 
					folioNum="";
				
				System.out.println("Withdrawal fund name : "+stpDataRow[2].toString());
				System.out.println("Purchase fund name : "+stpDataRow[3].toString());
				
				stpDataModel.add(new StpDataModel(stpDataRow[7].toString(),stpDataRow[1].toString(),stpDataRow[2].toString(),stpDataRow[3].toString(),
							 folioNum,stpDataRow[4].toString(),stpDataRow[6].toString()));
			}
			  
			
			logger.debug("QueryProducts class - getStpData method - customerId - "+customerId+" - return stpDataModel containing "+stpDataModel.size()+" records");
			logger.debug("QueryProducts class - getStpData method - customerId - "+customerId+" - end");
			
			return stpDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryProducts class - getStpData method - customerId - "+customerId+" - Caught NumberFormatException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class - getStpData method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class - getStpData method - customerId - "+customerId+" - Caught Exception");
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
			
			Query allFundsData = hibernateSession.createQuery("select distinct p.schemeName, t.transactionDetailId, t.transactionType, t.buySell,"
					+ " t.buySellType, t.transactionAmount, t.quantity, t.unitPrice, t.transactionDate, t.transactionFolioNum, t.transactionStatus "
					+ " from TransactionDetails t, PrimaryFundDetails p "
					+ "  where t.fundId=p.fundId and t.customerId = :customerId and  t.transactionStatus in ('5','6','8')   order by t.transactionDate desc");
			
			allFundsData.setParameter("customerId",customerId);
			hibernateSession.getTransaction().commit();
			
			int i = 0;

			List<InvestmentDetailsDataModel> allFundsInvestmentDetailsDataModel = new LinkedList<InvestmentDetailsDataModel>();
			
			for (Iterator allFundsDataIt=allFundsData.iterate(); allFundsDataIt.hasNext();)  {
		
				
				Object[] allFundsDataRow = (Object[]) allFundsDataIt.next();
			
				String quantity = "";
				String amount = "0.0";
				    i++;
				    if (allFundsDataRow[6] != null)  
						if ( ("SELL").equals(allFundsDataRow[3].toString()) ) 
							quantity = "-"+allFundsDataRow[6].toString();
						
						else 
							quantity = allFundsDataRow[6].toString();
					
				    if (allFundsDataRow[5] != null)  
				    	amount = allFundsDataRow[5].toString();
					Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(allFundsDataRow[8].toString().substring(0,10));  
					
					
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
					String date = simpleDateFormat.format(date1);
					
					System.out.println("DATE : "+date);
					
					String investmentType = allFundsDataRow[2].toString();
					String buySell = allFundsDataRow[3].toString();
					String buySellType = allFundsDataRow[4].toString();
					String transactionType = null;
					String transactionStatus = allFundsDataRow[10].toString();
					
					if ("6".equals(transactionStatus))
						transactionType = "Payment not received";
					else if ("UPFRONT".equalsIgnoreCase(investmentType) && "BUY".equals(buySell) &&  "FRESH".equals(buySellType))  
						transactionType = "New Investment";
					else if ("UPFRONT".equalsIgnoreCase(investmentType) && "BUY".equals(buySell) &&  "ADDITIONAL".equals(buySellType))
						transactionType = "Additional Investments";
					else if ("UPFRONT".equalsIgnoreCase(investmentType) && "SELL".equals(buySell) &&  "PARTIAL".equals(buySellType))
						transactionType = "Partial Redemption";
					else if ("UPFRONT".equalsIgnoreCase(investmentType) && "SELL".equals(buySell) &&  "FULL".equals(buySellType))
						transactionType = "Full Redemption";
					else if ("REDEMPTION".equals(investmentType) && "SELL".equals(buySell) &&  "FULL".equals(buySellType))
						transactionType = "Full Redemption";
					else if ("REDEMPTION".equals(investmentType) && "SELL".equals(buySell) &&  "PARTIAL".equals(buySellType))
						transactionType = "Partial Redemption";
					else if ("SIP".equals(investmentType) && "BUY".equals(buySell) )
						transactionType = "SIP Investment";
					else if ("SIP".equals(investmentType) && "SELL".equals(buySell) )
						transactionType = "SIP Investment";
					else if ("STP".equals(investmentType) && "BUY".equals(buySell) )
						transactionType = "STP Investment";
					else if ("STP".equals(investmentType) && "SELL".equals(buySell) )
						transactionType = "STP Redemption";
					else if ("SWITCH".equals(investmentType) && "BUY".equals(buySell) )
						transactionType = "SWITCH Investment";
					else if ("SWITCH".equals(investmentType) && "SELL".equals(buySell) )
						transactionType = "SWITCH Redemption";
					else if ("SIPMissed".equals(investmentType) && "SIPMissed".equals(buySell) )
						transactionType = "SIP Missed";
					
					String folioNum = null;
					
					if (null != allFundsDataRow[9])
						folioNum = allFundsDataRow[9].toString();
					else 
						folioNum=""; 
					
					String units = "";
					System.out.println("Scheme NAME : "+allFundsDataRow[0].toString()+" and allFundsDataRow[7] :"+allFundsDataRow[7]+":");
					if (allFundsDataRow[7] != null)  {
						units = allFundsDataRow[7].toString();
						System.out.println(" Inside if block for Scheme NAME : "+allFundsDataRow[0].toString());
					}
					
					allFundsInvestmentDetailsDataModel.add(new InvestmentDetailsDataModel(allFundsDataRow[1].toString(),allFundsDataRow[0].toString(),folioNum,
							date,amount,quantity,units,transactionType ));
					
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

		String fundId = null;
		if (result != null)
			fundId = result.toString();
		System.out.println("getInvestmentDetailsData : fundId : "+fundId);
		Query query = hibernateSession.createQuery("select transactionDate,quantity,unitPrice,transactionType,buySell,transactionDetailId,transactionAmount,buySellType,transactionFolioNum"
				+ " from TransactionDetails where fundId='"+fundId+"' and customerId='"+customerId+"' and unitPrice is not null");
		       
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
			
			if ("UPFRONT".equalsIgnoreCase(investmentType) && "BUY".equals(buySell) &&  "FRESH".equals(buySellType))  
				transactionType = "New Investment";
			else if ("UPFRONT".equalsIgnoreCase(investmentType) && "BUY".equals(buySell) &&  "ADDITIONAL".equals(buySellType))
				transactionType = "Additional Investments";
			else if ("UPFRONT".equalsIgnoreCase(investmentType) && "SELL".equals(buySell) &&  "PARTIAL".equals(buySellType))
				transactionType = "Partial Redemption";
			else if ("UPFRONT".equalsIgnoreCase(investmentType) && "SELL".equals(buySell) &&  "FULL".equals(buySellType))
				transactionType = "Full Redemption";
			else if ("REDEMPTION".equals(investmentType) && "SELL".equals(buySell) &&  "FULL".equals(buySellType))
				transactionType = "Full Redemption";
			else if ("REDEMPTION".equals(investmentType) && "SELL".equals(buySell) &&  "PARTIAL".equals(buySellType))
				transactionType = "Partial Redemption";
			else if ("SIP".equals(investmentType) && "BUY".equals(buySell) )
				transactionType = "SIP Investment";
			else if ("SIP".equals(investmentType) && "SELL".equals(buySell) )
				transactionType = "SIP Investment";
			else if ("STP".equals(investmentType) && "BUY".equals(buySell) )
				transactionType = "STP Investment";
			else if ("STP".equals(investmentType) && "SELL".equals(buySell) )
				transactionType = "STP Redemption";
			else if ("SWITCH".equals(investmentType) && "BUY".equals(buySell) )
				transactionType = "SWITCH Investment";
			else if ("SWITCH".equals(investmentType) && "SELL".equals(buySell) )
				transactionType = "SWITCH Redemption";
			else if ("SIPMissed".equals(investmentType) && "SIPMissed".equals(buySell) )
				transactionType = "SIP Missed";
				
			
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

	public String getSchemeName( String fundId) throws MoneyBuddyException  {
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
			logger.debug("QueryProducts class - getSchemeName method - fundId - "+fundId+" - start");
			
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select schemeName from PrimaryFundDetails where fundId = :fundId");
    	
			query.setParameter("fundId", fundId);
			String schemeName = query.uniqueResult().toString();
			hibernateSession.getTransaction().commit();
			
			
			logger.debug("QueryProducts class - getSchemeName method - fundId - "+fundId+" - returns schemeName - "+schemeName);
			logger.debug("QueryProducts class - getSchemeName method - fundId - "+fundId+" - end");
			
			return schemeName;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryProducts class - getSchemeName method - fundId - "+fundId+" - Caught NumberFormatException ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class - getSchemeName method - fundId - "+fundId+" - Caught HibernateException ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class - getSchemeName method - fundId - "+fundId+" - Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}

	public double getCurrentAmtForFund(String customerId, String fundId, String folioNum) throws MoneyBuddyException   {
		
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
								
			double availableUnits = 0.0;
			double currentAmount = 0.0;
			double soldUnit = 0.0;
			
		     String stpWithdrawalFlag = null;
		     
		     try {
		     Query query = hibernateSession.createQuery("select navValue from NavHistory where fundId = :fundId order by navHistoryId desc ");
				query.setParameter("fundId",fundId);
				query.setMaxResults(1);
				String currentNavValue = query.uniqueResult().toString();
		     
				System.out.println("currentNavValue : "+currentNavValue);
				
	     	Query buySellRecordsQuery = hibernateSession.createQuery("select quantity , buySell " + 
	     			" from TransactionDetails  " + 
	     			" where fundId= :fundId and customerId= :customerId and transactionFolioNum = :transactionFolioNum " + 
	     			" and unitPrice is not null and transactionStatus='8'" );
		      
	     	buySellRecordsQuery.setParameter("customerId",customerId);
	     	buySellRecordsQuery.setParameter("fundId",fundId);
	     	buySellRecordsQuery.setParameter("transactionFolioNum", folioNum);
	     	
	     	java.util.List buySellList = buySellRecordsQuery.list();
		     
	     	for (Iterator buySellIt=buySellList.iterator(); buySellIt.hasNext();)  {
		     	
		    	 Object[] buySellRecordRow = (Object[]) buySellIt.next();
		     	
		    	 if ("SELL".equals(buySellRecordRow[1].toString()))  {
			    	 soldUnit += Double.parseDouble(buySellRecordRow[0].toString());
			         
		    	 }
	     	}
		     
	     	for (Iterator buySellIt=buySellList.iterator(); buySellIt.hasNext();)  {
		    	   
		    	 Object[] buySellRecordRow = (Object[]) buySellIt.next();
			       
		    	if ("BUY".equals(buySellRecordRow[1].toString()))  {
			       
			    	 if (soldUnit != 0 )   {
					    	   
			    		 if (Double.parseDouble(buySellRecordRow[0].toString()) > soldUnit)  {
			    			 availableUnits += (Double.parseDouble(buySellRecordRow[0].toString()) - soldUnit);
			    			 soldUnit = 0;	   
			    		 }
			    		 else {
			    			 soldUnit -= Double.parseDouble(buySellRecordRow[0].toString());	   
			    		 }
			    	 }
				       
			    	 else {
			    		 availableUnits +=  Double.valueOf(buySellRecordRow[0].toString());
			    	 }
			    	 
		    	}
	     	}
		       
		     currentAmount = availableUnits* Double.parseDouble(currentNavValue);
		     
		     return currentAmount;
		     
			     /*String stpAllowed = "Y";
			     if ("Y".equals(stpWithdrawalFlag))   {
			    	 
			    	 QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
			    	 String availableFundsList = queryPrimaryFundDetails.getAvailableStpFundsList(fundId);
			    	 
			    	 if ("".equals(availableFundsList))  {
			    		 stpAllowed = "N";
			    	 }
			    	 
			    	 if ( "Y".equals(stpAllowed))   {
			    		 String minStpAmount = queryPrimaryFundDetails.getMinStpAmount(fundId);
			    		 
			    		 if (Double.parseDouble(minStpAmount) > currentAmount)   {
			    			 stpAllowed = "N";
			    		 }
			    	 }
			    	 
			     }
			     else {
			    	 stpAllowed = "N";
			     }*/
		     
		     }
				catch (NumberFormatException e)
				{
					logger.error("QueryProducts class - getSchemeName method - fundId - "+fundId+" - Caught NumberFormatException ");
					e.printStackTrace();
					throw new MoneyBuddyException(e.getMessage(),e);
				}
				catch ( HibernateException e ) {
					logger.error("QueryProducts class - getSchemeName method - fundId - "+fundId+" - Caught HibernateException ");
					e.printStackTrace();
					throw new MoneyBuddyException(e.getMessage(),e);
				}
				catch (Exception e ) {
					logger.error("QueryProducts class - getSchemeName method - fundId - "+fundId+" - Caught Exception ");
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

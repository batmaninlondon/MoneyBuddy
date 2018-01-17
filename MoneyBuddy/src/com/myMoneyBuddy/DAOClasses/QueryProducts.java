/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerPortfolio;
import com.myMoneyBuddy.EntityClasses.NavHistory;
import com.myMoneyBuddy.EntityClasses.ProductDetails;
import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
/*import com.myMoneyBuddy.EntityClasses.PriceHistory;*/
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.DashboardDataModel;
import com.myMoneyBuddy.ModelClasses.InvestmentDetailsDataModel;
import com.myMoneyBuddy.ModelClasses.PortfolioDataModel;
import com.myMoneyBuddy.ModelClasses.SipDataModel;
import com.myMoneyBuddy.Utils.HibernateUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
import org.hibernate.ScrollMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



public class QueryProducts {
	
	Logger logger = Logger.getLogger(QueryProducts.class);

	public final double tol = 0.001;  
	
	public double getInterestRates(String planName, String riskCategory) throws MoneyBuddyException{

		Session session = null;
		
		try
		{
		logger.debug("QueryProducts class : getInterestRates method : start");

		session = HibernateUtil.getSessionAnnotationFactory().openSession();

		double avgInterestRate = 0.0;

			session.beginTransaction();
			Query query = session.createQuery("from ProductDetails where riskCategory = :riskCategory and planName = :planName");
			query.setParameter("riskCategory",riskCategory);
			query.setParameter("planName",planName);
			List<ProductDetails> productDetailsList = query.list();

			for(ProductDetails productDetail : productDetailsList){
				avgInterestRate = avgInterestRate+(Double.parseDouble(productDetail.getPercentage()) * Double.parseDouble(productDetail.getInterestRate()));
			}
			//session.getTransaction().commit();
			avgInterestRate = avgInterestRate/100;
			
			logger.debug("QueryProducts class : getInterestRates method : end");
			return avgInterestRate;
		}
		catch ( NumberFormatException e)  {
			logger.debug("QueryProducts class : getInterestRates method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.debug("QueryProducts class : getInterestRates method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryProducts class : getInterestRates method : Caught Exception");
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

    
	public HashMap<String,Double> getProductList(String riskCategory,String planName) throws MoneyBuddyException{

		Session session = null;
		Double minLumsumAmount = 0.0;
		Double minSipAmount = 0.0;
		int minSipDuration = 0;
		
		try
		{		
		logger.debug("QueryProducts class : getProductList method : start");
		
		session = HibernateUtil.getSessionAnnotationFactory().openSession();

			session.beginTransaction();
			
			System.out.println(" riskCategory : "+riskCategory);
			System.out.println("planName : "+planName);
			Query query = session.createQuery("from ProductDetails where riskCategory = :riskCategory and planName =:planName");
			query.setParameter("riskCategory",riskCategory);
			query.setParameter("planName",planName);
			List<ProductDetails> productDetailList = query.list();
			HashMap<String,Double> hashMap = new HashMap<String,Double>();

			for(ProductDetails productDetail : productDetailList){
				System.out.println(" productName : "+productDetail.getProductDescription());
				System.out.println("Percentage : "+productDetail.getPercentage());
				hashMap.put(productDetail.getProductId(),Double.parseDouble(productDetail.getPercentage()));
				
				query = session.createQuery("select minLumsumAmount from FundDetails where fundId = :fundId");
		    	
		    	query.setParameter("fundId", productDetail.getProductId());
		    	minLumsumAmount += Double.parseDouble(query.uniqueResult().toString()); 
		    	
		    	query = session.createQuery("select minSipAmount from FundDetails where fundId = :fundId");
		    	
		    	query.setParameter("fundId", productDetail.getProductId());
		    	minSipAmount += Double.parseDouble(query.uniqueResult().toString()); 	

		    	
		    	query = session.createQuery("select minSipDuration from FundDetails where fundId = :fundId");
		    	
		    	query.setParameter("fundId", productDetail.getProductId());
		    	if (minSipDuration < Integer.parseInt(query.uniqueResult().toString()))
		    		minSipDuration = Integer.parseInt(query.uniqueResult().toString()); 
		    	
			}
			
			hashMap.put("minLumsumAmount", minLumsumAmount);
			hashMap.put("minSipAmount", minSipAmount);
			hashMap.put("minSipDuration", (double)minSipDuration);
			//session.getTransaction().commit();


			
			logger.debug("QueryProducts class : getProductList method : end");
			return hashMap;
		}
		catch ( NumberFormatException e ) {
			logger.debug("QueryProducts class : getProductList method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.debug("QueryProducts class : getProductList method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryProducts class : getProductList method : Caught Exception");
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
    
	public HashMap<String,Double> getProductAmountList(String riskCategory,String planName,Double upfrontInvestment) throws MoneyBuddyException
	{
		Session session = null;
		try
		{
		logger.debug("QueryProducts class : getProductAmountList method : start");
		
		session = HibernateUtil.getSessionAnnotationFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("select productId,percentage from ProductDetails where riskCategory = :riskCategory and planName =:planName");
			query.setParameter("riskCategory",riskCategory);
			query.setParameter("planName",planName);
			
			HashMap<String,Double> hashMap = new HashMap<String,Double>();

			for (Iterator it=query.iterate(); it.hasNext();)  {
			    
				Object[] productDetailRow = (Object[]) it.next();
				
				System.out.println("Product Id : "+productDetailRow[0].toString());
				System.out.println("Percentage : "+productDetailRow[1].toString());
				
				hashMap.put(productDetailRow[0].toString(),((upfrontInvestment*Double.parseDouble(productDetailRow[1].toString()))/100));

			}

			//session.getTransaction().commit();

			
			logger.debug("QueryProducts class : getProductAmountList method : end");
			return hashMap;
		}
		catch (NumberFormatException e ) {
			logger.debug("QueryProducts class : getProductAmountList method : Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.debug("QueryProducts class : getProductAmountList method : Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("QueryProducts class : getProductAmountList method : Caught Exception ");
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
    
	/*public List<DashboardDataModel> getDashboardData(String customerId, String investmentTypeName) throws MoneyBuddyException {*/
	
	public List<DashboardDataModel> getDashboardData(String customerId) throws MoneyBuddyException {

		Session session  = null;
		try
		{
			logger.debug("QueryProducts class : getDashboardData method : start");
		
			session = HibernateUtil.getSessionAnnotationFactory().openSession();
		
			session.beginTransaction();
			Query query = session.createQuery("from CustomerPortfolio where customerId = :customerId");
			/*Query query = sessionCustomerPortfolio.createQuery("from CustomerPortfolio where customerId = :customerId and investmentTypeName=:investmentTypeName");*/
			query.setParameter("customerId",customerId);
			/*query.setParameter("investmentTypeName",investmentTypeName);*/

			List<CustomerPortfolio> customerPortfolioList = query.list();
			List<DashboardDataModel> dashboardDataModel = new LinkedList<DashboardDataModel>();

			//session.getTransaction().commit();
			for(CustomerPortfolio customerPortfolio : customerPortfolioList){

				//session.beginTransaction();
														
				query = session.createQuery("from ProductDetails where productId = :productId");
				query.setParameter("productId",customerPortfolio.getProductId());
				List<ProductDetails> productDetailsList = query.list();

				//session.getTransaction().commit();

/*				sessionPriceHistory.beginTransaction();
				query = sessionPriceHistory.createQuery("from PriceHistory where productId = :productId  and date=curdate()");
				query.setParameter("productId",customerPortfolio.getProductId());


				List<PriceHistory> priceHistoryList = query.list();

				sessionPriceHistory.getTransaction().commit();*/
				
				//session.beginTransaction();
				query = session.createQuery("from TransactionDetails where transactionDetailId = :TransactionDetailId");
				query.setParameter("TransactionDetailId",customerPortfolio.getTransactionDetailId());


				List<TransactionDetails> TransactionDetailsList = query.list();

				//session.getTransaction().commit();

				double availableToSell = Double.parseDouble(customerPortfolio.getTotalQuantity());

				if ( Double.parseDouble(customerPortfolio.getPendingOrders()) < 0 )   {
					availableToSell = availableToSell + Double.parseDouble(customerPortfolio.getPendingOrders());

				}

				/*String buyingPrice = Double.toString(Integer.parseInt(TransactionDetailsList.get(0).getQuantity()) * Double.parseDouble(TransactionDetailsList.get(0).getUnitPrice())); 
				String marketValue = Double.toString(Integer.parseInt(TransactionDetailsList.get(0).getQuantity()) * Double.parseDouble(priceHistoryList.get(0).getPrice()));
				String gain = Double.toString( Double.parseDouble(marketValue) - Double.parseDouble (buyingPrice) );*/
				
				/*dashboardDataModel.add(new DashboardDataModel(productDetailsList.get(0).getProductName(), 
						customerPortfolio.getProductId(), customerPortfolio.getTotalQuantity(), 
						customerPortfolio.getPendingOrders(), Integer.toString(availableToSell),
						priceHistoryList.get(0).getPrice(),buyingPrice,marketValue,gain, 
						TransactionDetailsList.get(0).getBseOrderId(),TransactionDetailsList.get(0).getReverseFeed(),customerPortfolio.getTransactionDate(),TransactionDetailsList.get(0).getTransactionAmount()));
				*/
				/*dashboardDataModel.add(new DashboardDataModel(productDetailsList.get(0).getProductName(), 
						customerPortfolio.getProductId(), customerPortfolio.getTotalQuantity(), 
						customerPortfolio.getPendingOrders(), Integer.toString(availableToSell),
						priceHistoryList.get(0).getPrice(),buyingPrice,marketValue,gain,customerPortfolio.getInvestmentTypeName(), 
						TransactionDetailsList.get(0).getBseOrderId(),TransactionDetailsList.get(0).getReverseFeed(),customerPortfolio.getTransactionDate(),TransactionDetailsList.get(0).getTransactionAmount()));*/
				dashboardDataModel.add(new DashboardDataModel(productDetailsList.get(0).getProductName(), 
						customerPortfolio.getProductId(), customerPortfolio.getTotalQuantity(), 
						customerPortfolio.getPendingOrders(), String.format("%.4f",availableToSell),
						TransactionDetailsList.get(0).getBseOrderId(),TransactionDetailsList.get(0).getReverseFeed(),customerPortfolio.getTransactionDate(),TransactionDetailsList.get(0).getTransactionAmount()));
				

			}

			//sessionCustomerPortfolio.getTransaction().commit();

			logger.debug("QueryProducts class : getDashboardData method : end");
			return dashboardDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryProducts class : getDashboardData method : Caught Exception for customer id : "+customerId);
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class : getDashboardData method : Caught Exception for customer id : "+customerId);
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class : getDashboardData method : Caught Exception for customer id : "+customerId);
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

	
	
	public List<PortfolioDataModel> getPortfolioData(String customerId) throws MoneyBuddyException {
		
		Session session  = null;
		double soldUnit = 0.0;
		double investedAmount = 0.0;
		double availableUnits = 0.0;
		double currentAmount = 0.0;
		double rateOfGrowth = 0.0;
		//HashMap xirrHashMap = new HashMap<String,Double>();
		//HashMap totalXirrHashMap = new HashMap<Double,String>();
		double xirr = 0.0;
		double totalXirr = 0.0;
		List<Double> totalAmounts = new ArrayList<Double>();
	    List<Date> totalDates = new ArrayList<Date>();
	       
		try
		{
			logger.debug("QueryProducts class : getPortfolioData method : start");
			
			session = HibernateUtil.getSessionAnnotationFactory().openSession();
		
			session.beginTransaction();

			List<PortfolioDataModel> portfolioDataModel = new LinkedList<PortfolioDataModel>();
			
            Query buyRecordsQuery, sellRecordsQuery;
			Query query = session.createQuery("select distinct(x.productName), x.productId from ProductDetails x, TransactionDetails y where x.productId = y.productId and y.customerId = :customerId");
			
			query.setParameter("customerId",customerId);
			
			//List<String> productsList = query.list();
			
			String totalCurrentNavValue = null; 
			
			totalDates.add(strToDate("11/12/2017"));
	           totalAmounts.add(Double.parseDouble("2000000")*-1);
	           
			 for(Iterator it=query.iterate(); it.hasNext();){
				 List<Double> amounts = new ArrayList<Double>();
			       List<Date> dates = new ArrayList<Date>();
			       
			       
		           
		           
		           
			       String oldstring;
			       
			       Object[] row = (Object[]) it.next();
			       
			       System.out.println("Product Name: " + row[0]);
			       
			       System.out.println("Product ID: " + row[1]);
			       Object result;
			       
			       result = session.createQuery("select max(navDate) from NavHistory where schemeCode = '"+row[0]+"'").uniqueResult();
			       String currentNavDate = null; 
			       
			       if (result != null )
			    	   currentNavDate = result.toString();
			       
			       System.out.println("Product Latest NAV Date : " + currentNavDate);
			       
			       result = session.createQuery("select navValue from NavHistory where schemeCode = '"+row[0]+"' and navDate = (select max(navDate) from NavHistory  where schemeCode = '"+row[0]+"') ").uniqueResult();
			       String currentNavValue = null; 
			       
			       if (result != null )
			    	   currentNavValue = result.toString();
			       
			       System.out.println("Product Latest NAV Value : " + currentNavValue);
			       
			       
			       dates.add(strToDate("11/12/2017"));
		           amounts.add(Double.parseDouble(currentNavValue)*-1);
		           
		           
			       
			       result = session.createQuery("select min(transactionDate) from TransactionDetails where productId='"+row[1]+"' and customerId='"+customerId+"'").uniqueResult();
			       
			       String transactionStartDate = null;
			       if (result != null )
			    	   transactionStartDate = result.toString();
			       
			       System.out.println("transactionStartDate : " + transactionStartDate);
			       
			       
			       
			       
			       sellRecordsQuery = session.createQuery("select transactionDetailId, transactionAmount, quantity, unitPrice, transactionDate from TransactionDetails where productId='"+row[1]+"' and customerId='"+customerId+"' and buySell='SELL'  and unitPrice is not null ");
			       
			       for (Iterator sellIt=sellRecordsQuery.iterate(); sellIt.hasNext();)  {
			    	   
			    	   Object[] sellRecordRow = (Object[]) sellIt.next();
				       
			    	   soldUnit += Double.parseDouble(sellRecordRow[2].toString());
				       System.out.println("Product transactionDetail for SEll - id : "+sellRecordRow[0]+" amount: "+sellRecordRow[1]+" unit: "+sellRecordRow[2]+" unitPrice: "+sellRecordRow[3] +" : transactionDate : "+sellRecordRow[4]);
				       //xirrHashMap.put(sellRecordRow[4].toString(), (Double.parseDouble(sellRecordRow[1].toString())*-1));
				       
				       oldstring = sellRecordRow[4].toString().substring(0, 10);
			           //LocalDateTime datetime = LocalDateTime.parse(oldstring, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			           
			           
				       	DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD"); 
				       	Date date = (Date)formatter.parse(oldstring);
				       	SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
				       	String transactionDate = newFormat.format(date);
				       	System.out.println("transactionDate : "+transactionDate);
			       	
			           dates.add(strToDate(transactionDate));
			           amounts.add(Double.parseDouble(sellRecordRow[1].toString())*-1);
			           
			           totalDates.add(strToDate(transactionDate));
			           totalAmounts.add(Double.parseDouble(sellRecordRow[1].toString())*-1);
			           
			           System.out.println("Added : date : "+strToDate(transactionDate)+" : amount : "+(Double.parseDouble(sellRecordRow[1].toString())*-1));
			       }
			       
			       System.out.println("Total sold units : "+soldUnit);
			       
			       buyRecordsQuery = session.createQuery("select transactionDetailId, transactionAmount, quantity, unitPrice, transactionDate from TransactionDetails where productId='"+row[1]+"' and customerId='"+customerId+"' and buySell='BUY' and unitPrice is not null ");
			       
			       for (Iterator buyIt=buyRecordsQuery.iterate(); buyIt.hasNext();)  {
			    	   
			    	   Object[] buyRecordRow = (Object[]) buyIt.next();
				       
				       System.out.println("Product transactionDetail for BUY - id : "+buyRecordRow[0]+" amount: "+buyRecordRow[1]+" unit: "+buyRecordRow[2]+" unitPrice: "+buyRecordRow[3]+" : transactionDate : "+buyRecordRow[4]);

				       
					       if (soldUnit != 0 )   {
					    	   
					    	   if (Double.parseDouble(buyRecordRow[2].toString()) > soldUnit)  {
					    		   availableUnits += (Double.parseDouble(buyRecordRow[2].toString()) - soldUnit);
					    		   System.out.println(" availableUnits : "+String.format("%.4f", availableUnits));
					    		   investedAmount += (Double.parseDouble(buyRecordRow[2].toString()) - soldUnit)* (Double.parseDouble(buyRecordRow[3].toString()));
					    		   System.out.println(" investedAmount : "+String.format("%.2f",investedAmount));
					    		   
					    		   soldUnit = 0;
					    		   
					    	   }
					    	   else {
					    		   soldUnit -= Double.parseDouble(buyRecordRow[2].toString());
					    		   
					    	   }
					       }
					       
					       else {
					    	   availableUnits +=  Double.valueOf(buyRecordRow[2].toString());
	
					    	   System.out.println(" availableUnits : "+String.format("%.2f", availableUnits));
					    	   investedAmount += (Double.parseDouble(buyRecordRow[2].toString()))* (Double.parseDouble(buyRecordRow[3].toString()));
					    	   System.out.println(" investedAmount : "+String.format("%.2f",investedAmount));
					       }
					       //xirrHashMap.put(buyRecordRow[4].toString(),Double.parseDouble(buyRecordRow[1].toString()));  
					       
					       oldstring = buyRecordRow[4].toString().substring(0, 10);
				           //LocalDateTime datetime = LocalDateTime.parse(oldstring, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				           
				           DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD"); 
					       	Date date = (Date)formatter.parse(oldstring);
					       	SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
					       	
					       	String transactionDate = newFormat.format(date);
					       	System.out.println("transactionDate : "+transactionDate);
					       	
				           dates.add(strToDate(transactionDate));
				           amounts.add(Double.parseDouble(buyRecordRow[1].toString()));
				           
				           totalDates.add(strToDate(transactionDate));
				           totalAmounts.add(Double.parseDouble(buyRecordRow[1].toString()));
				           
				           System.out.println("Added : date : "+strToDate(transactionDate)+" : amount : "+(Double.parseDouble(buyRecordRow[1].toString())));
			       
			       }
			       
			       currentAmount = availableUnits* Double.parseDouble(currentNavValue);
			       rateOfGrowth = ((currentAmount - investedAmount)/investedAmount)*100;
			       
			      /* List<Double> amounts = new ArrayList<Double>();
			       List<Date> dates = new ArrayList<Date>();
			       Iterator xirrIterator = xirrHashMap.entrySet().iterator();
			       int i = 0;
			       String oldstring;
			       while (xirrIterator.hasNext()) {
			           Map.Entry pair = (Map.Entry)xirrIterator.next();
			           System.out.println(pair.getKey() + " = " + pair.getValue());
			           
			           oldstring = pair.getKey().toString();
			           LocalDateTime datetime = LocalDateTime.parse(oldstring, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.S"));
			           
			           dates.add(Date.from(datetime.atZone(ZoneId.systemDefault()).toInstant()));
			           amounts.add(Double.parseDouble(pair.getValue().toString()));
			           
			           totalDates.add(Date.from(datetime.atZone(ZoneId.systemDefault()).toInstant()));
			           totalAmounts.add(Double.parseDouble(pair.getValue().toString()));
			           
			           xirrIterator.remove(); // avoids a ConcurrentModificationException
			       }*/
			       
			       xirr = Newtons_method(0.1, amounts, dates);
			       System.out.println("Total availableUnits : "+ String.format("%.4f", availableUnits));
			       System.out.println("Total invested Amount : "+ String.format("%.4f", investedAmount));
			       System.out.println("Current Amount : "+ String.format("%.4f", currentAmount));
			       System.out.println("XIRR : "+ String.format("%.4f", xirr));
			      
			       
			       portfolioDataModel.add(new PortfolioDataModel(row[0].toString(),String.format("%.4f", availableUnits),String.format("%.2f",investedAmount),String.format("%.2f",currentAmount),String.format("%.2f",xirr),transactionStartDate));
			 }
			 
			 totalXirr = Newtons_method(0.1, totalAmounts, totalDates);
			 
			 Double TotalInvestedAmount = 0.0;
				Double TotalCurrentAmount = 0.0;
				for ( PortfolioDataModel portfolioDataModelElement : portfolioDataModel )  {
					
					
					TotalInvestedAmount = TotalInvestedAmount + Double.parseDouble(portfolioDataModelElement.getInvestedAmount());
					TotalCurrentAmount = TotalCurrentAmount + Double.parseDouble(portfolioDataModelElement.getCurrentAmount());
				}
				
				Double TotalrateOfGrowth = ((TotalCurrentAmount - TotalInvestedAmount)/TotalInvestedAmount)*100;
			
				/*query = session.createQuery("select min(transactionDate) from TransactionDetails where customerId='"+customerId+"'");

				String allTransactionStartDate = query.uniqueResult().toString();*/
				portfolioDataModel.add(new PortfolioDataModel("Total","",String.format("%.2f",TotalInvestedAmount),String.format("%.2f",TotalCurrentAmount),String.format("%.2f",totalXirr),""));

			//session.getTransaction().commit();

			logger.debug("QueryProducts class : getPortfolioData method : end");
			return portfolioDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryProducts class : getPortfolioData method : Caught Exception for customer id : "+customerId);
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class : getPortfolioData method : Caught Exception for customer id : "+customerId);
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class : getPortfolioData method : Caught Exception for customer id : "+customerId);
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
	
	
public List<SipDataModel> getSipData(String customerId) throws MoneyBuddyException {
		
		Session session  = null;
		double soldUnit = 0.0;
		double investedAmount = 0.0;
		double availableUnits = 0.0;
		double currentAmount = 0.0;
		double rateOfGrowth = 0.0;
		//HashMap xirrHashMap = new HashMap<String,Double>();
		//HashMap totalXirrHashMap = new HashMap<Double,String>();
		double xirr = 0.0;
		double totalXirr = 0.0;
		List<Double> totalAmounts = new ArrayList<Double>();
	    List<Date> totalDates = new ArrayList<Date>();
	       
		try
		{
			logger.debug("QueryProducts class : getPortfolioData method : start");
			
			session = HibernateUtil.getSessionAnnotationFactory().openSession();
		
			session.beginTransaction();

			List<SipDataModel> sipDataModel = new LinkedList<SipDataModel>();
			
            Query buyRecordsQuery, sellRecordsQuery;
			Query query = session.createQuery("from SipDetails where customerId = :customerId and sipEndDate  > curdate()");
			
			query.setParameter("customerId",customerId);
			
			List<SipDetails> sipDetailsList = query.list();
			
			List<Object[]> rows = null;
			String sipDate = null;
			
			Calendar cal = Calendar.getInstance();
			int currentDate = cal.get(Calendar.DAY_OF_MONTH);
			int currentMonth = cal.get(Calendar.MONTH);
			int currentYear = cal.get(Calendar.YEAR);
			String nextSipMonth = null;
			String nextSipYear = null;
			String nextSipDate = null;
			for (SipDetails sipDetailsListElement : sipDetailsList)  {
				
				sipDate = sipDetailsListElement.getSipDate();
				
				if (Integer.parseInt(sipDate) < currentDate)  {
					if (currentMonth == 11)  {
						nextSipMonth = "01";
						nextSipYear = Integer.toString(currentYear + 1);
						nextSipDate = nextSipYear+"-"+nextSipMonth+"-"+sipDate;
					}
					else {
						nextSipMonth = theMonth(cal.get(Calendar.MONTH)+1);
						nextSipYear = Integer.toString(currentYear);
						nextSipDate = nextSipYear+"-"+nextSipMonth+"-"+sipDate;
					}
				}
				else {
					nextSipMonth = theMonth(cal.get(Calendar.MONTH));
					nextSipYear = Integer.toString(currentYear);
					nextSipDate = nextSipYear+"-"+nextSipMonth+"-"+sipDate;
					
				}
				

	            
				query = session.createQuery("select p.productName,t.transactionAmount from TransactionDetails t, ProductDetails p where t.transactionDetailId= :transactionDetailId and t.productId = p.productId ");
				query.setParameter("transactionDetailId", sipDetailsListElement.getTransactionDetailId());
							
				rows = query.list();
				
				sipDataModel.add(new SipDataModel(sipDetailsListElement.getSipStartDate(),rows.get(0)[0].toString(),
									rows.get(0)[1].toString(),nextSipDate));
			}

			//session.getTransaction().commit();

			logger.debug("QueryProducts class : getPortfolioData method : end");
			
			return sipDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryProducts class : getPortfolioData method : Caught Exception for customer id : "+customerId);
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class : getPortfolioData method : Caught Exception for customer id : "+customerId);
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class : getPortfolioData method : Caught Exception for customer id : "+customerId);
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
	
	
public List<InvestmentDetailsDataModel> getAllFundsInvestmentDetailsData(String customerId) throws MoneyBuddyException {

		Session session  = null;
		
		try
		{
			logger.debug("QueryProducts class : getInvestmentDetailsData method : start");
			
			System.out.println("getInvestmentDetailsData : customerId : "+customerId);
			session = HibernateUtil.getSessionAnnotationFactory().openSession();
		
			session.beginTransaction();

			Query query = session.createQuery("select distinct(productId) from TransactionDetails  where customerId = :customerId ");
			query.setParameter("customerId",customerId);
			
			List<String> productIdList = query.list();
			
			List<InvestmentDetailsDataModel> allFundsInvestmentDetailsDataModel = new LinkedList<InvestmentDetailsDataModel>();
			
			for (String productId : productIdList)  {
				System.out.println("getInvestmentDetailsData : productId : "+productId);
				query = session.createQuery("select productName from ProductDetails where productId = :productId");
				String productName = query.setParameter("productId",productId).uniqueResult().toString();
				
				
				query = session.createQuery("select transactionDate,quantity,unitPrice,transactionType,buySell from TransactionDetails where productId='"+productId+"' and customerId='"+customerId+"' and unitPrice is not null");
				       
				String quantity;
				for (Iterator it=query.iterate(); it.hasNext();)  {
				    
					Object[] transactionDetailsRow = (Object[]) it.next();
					if ( transactionDetailsRow[4].toString().equals("SELL") ) {
						quantity = "-"+transactionDetailsRow[1].toString();
					}
					else {
						quantity = transactionDetailsRow[1].toString();
					}

					allFundsInvestmentDetailsDataModel.add(new InvestmentDetailsDataModel(productName,transactionDetailsRow[0].toString(),quantity,transactionDetailsRow[2].toString(),transactionDetailsRow[3].toString(),transactionDetailsRow[4].toString()));
					
				}
			}
			/*Object result = session.createQuery("select productId from ProductDetails  where productName='"+productName+"'").uniqueResult();

			String productId = null;
			if (result != null)
				productId = result.toString();*/
			


			//session.getTransaction().commit();

			System.out.println("getInvestmentDetailsData : investmentDetailsDataModel.size() : "+allFundsInvestmentDetailsDataModel.size());
			
			logger.debug("QueryProducts class : getInvestmentDetailsData method : end");
			return allFundsInvestmentDetailsDataModel;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryProducts class : getInvestmentDetailsData method : Caught Exception for customer id : "+customerId);
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class : getInvestmentDetailsData method : Caught Exception for customer id : "+customerId);
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class : getInvestmentDetailsData method : Caught Exception for customer id : "+customerId);
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

public List<InvestmentDetailsDataModel> getInvestmentDetailsData(String customerId, String productName) throws MoneyBuddyException {

	Session session  = null;
	
	try
	{
		logger.debug("QueryProducts class : getInvestmentDetailsData method : start");
		
		System.out.println("getInvestmentDetailsData : customerId : "+customerId);
		System.out.println("getInvestmentDetailsData : productName : "+productName);
		session = HibernateUtil.getSessionAnnotationFactory().openSession();
	
		session.beginTransaction();

		List<InvestmentDetailsDataModel> investmentDetailsDataModel = new LinkedList<InvestmentDetailsDataModel>();
		
		Object result = session.createQuery("select productId from ProductDetails  where productName='"+productName+"'").uniqueResult();

		String productId = null;
		if (result != null)
			productId = result.toString();
		System.out.println("getInvestmentDetailsData : productId : "+productId);
		Query query = session.createQuery("select transactionDate,quantity,unitPrice,transactionType,buySell from TransactionDetails where productId='"+productId+"' and customerId='"+customerId+"' and unitPrice is not null");
		       
		String quantity;
		for (Iterator it=query.iterate(); it.hasNext();)  {
		    
			Object[] transactionDetailsRow = (Object[]) it.next();
			if ( transactionDetailsRow[4].toString().equals("SELL") ) {
				quantity = "-"+transactionDetailsRow[1].toString();
			}
			else {
				quantity = transactionDetailsRow[1].toString();
			}

			investmentDetailsDataModel.add(new InvestmentDetailsDataModel(productName,transactionDetailsRow[0].toString(),quantity,transactionDetailsRow[2].toString(),transactionDetailsRow[3].toString(),transactionDetailsRow[4].toString()));
			
		}


		//session.getTransaction().commit();

		System.out.println("getInvestmentDetailsData : investmentDetailsDataModel.size() : "+investmentDetailsDataModel.size());
		
		logger.debug("QueryProducts class : getInvestmentDetailsData method : end");
		return investmentDetailsDataModel;
	}
	catch (NumberFormatException e)
	{
		logger.error("QueryProducts class : getInvestmentDetailsData method : Caught Exception for customer id : "+customerId);
		e.printStackTrace();
		throw new MoneyBuddyException(e.getMessage(),e);
	}
	catch ( HibernateException e ) {
		logger.error("QueryProducts class : getInvestmentDetailsData method : Caught Exception for customer id : "+customerId);
		e.printStackTrace();
		throw new MoneyBuddyException(e.getMessage(),e);
	}
	catch (Exception e ) {
		logger.error("QueryProducts class : getInvestmentDetailsData method : Caught Exception for customer id : "+customerId);
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

	public String getProductName( String productId) throws MoneyBuddyException  {
		Session hibernateSession = null;
		try {
			logger.debug("QueryProducts class : getProductName method : end");
			
			hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
			
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select productDescription from ProductDetails where productId = :productId");
    	
			query.setParameter("productId", productId);
			String productDescription = query.uniqueResult().toString();
			logger.debug("QueryProducts class : getProductName method : end");
			
			return productDescription;
		}
		catch (NumberFormatException e)
		{
			logger.error("QueryProducts class : getProductName method : Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch ( HibernateException e ) {
			logger.error("QueryProducts class : getProductName method : Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryProducts class : getProductName method : Caught Exception ");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
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
	
	public static String theMonth(int month){
	    String[] monthNames = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	    return monthNames[month];
	}
}

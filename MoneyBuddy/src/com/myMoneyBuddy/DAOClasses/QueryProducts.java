/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerPortfolio;
import com.myMoneyBuddy.EntityClasses.NavHistory;
import com.myMoneyBuddy.EntityClasses.ProductDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
/*import com.myMoneyBuddy.EntityClasses.PriceHistory;*/
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

import net.sf.ehcache.hibernate.HibernateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



public class QueryProducts {
	
	Logger logger = Logger.getLogger(QueryProducts.class);

	public double getInterestRates(String planName, String riskCategory) throws MoneyBuddyException{

		SessionFactory factory = null;
		Session session = null;
		
		try
		{
		logger.debug("QueryProducts class : getInterestRates method : start");

		factory = new AnnotationConfiguration()
										.configure()
										.addAnnotatedClass(ProductDetails.class)
										.buildSessionFactory();
		session = factory.openSession();

		double avgInterestRate = 0.0;

			session.beginTransaction();
			Query query = session.createQuery("from ProductDetails where riskCategory = :riskCategory and planName = :planName");
			query.setParameter("riskCategory",riskCategory);
			query.setParameter("planName",planName);
			List<ProductDetails> productDetailsList = query.list();

			for(ProductDetails productDetail : productDetailsList){
				avgInterestRate = avgInterestRate+(Double.parseDouble(productDetail.getPercentage()) * Double.parseDouble(productDetail.getInterestRate()));
			}
			session.getTransaction().commit();
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
			if(factory!=null)
				factory.close();
		}

	}

    
	public HashMap<String,Double> getProductList(String riskCategory,String planName) throws MoneyBuddyException{

		SessionFactory factory  = null;
		Session session = null;
		
		try
		{		
		logger.debug("QueryProducts class : getProductList method : start");
		
		factory = new AnnotationConfiguration()
										.configure()
										.addAnnotatedClass(ProductDetails.class)
										.buildSessionFactory();
		session = factory.openSession();

			session.beginTransaction();
			
			System.out.println(" riskCategory : "+riskCategory);
			System.out.println("planName : "+planName);
			Query query = session.createQuery("from ProductDetails where riskCategory = :riskCategory and planName =:planName");
			query.setParameter("riskCategory",riskCategory);
			query.setParameter("planName",planName);
			List<ProductDetails> productDetailList = query.list();
			HashMap<String,Double> hashMap = new HashMap<String,Double>();

			for(ProductDetails productDetail : productDetailList){
				System.out.println(" productName : "+productDetail.getProductType()+"-"+productDetail.getProductName());
				System.out.println("Percentage : "+productDetail.getPercentage());
				hashMap.put(productDetail.getProductType()+"-"+productDetail.getProductName(),Double.parseDouble(productDetail.getPercentage()));
			}
			session.getTransaction().commit();


			
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
			if(factory!=null)
				factory.close();

		}

	}
    
	public HashMap<String,Double> getProductAmountList(String riskCategory,String planName,Double upfrontInvestment) throws MoneyBuddyException
	{
		SessionFactory factory = null;
		Session session = null;
		try
		{
		logger.debug("QueryProducts class : getProductAmountList method : start");
		
		factory = new AnnotationConfiguration()
										.configure()
										.addAnnotatedClass(ProductDetails.class)
										.buildSessionFactory();
		session = factory.openSession();
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

			session.getTransaction().commit();

			
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
			if(factory!=null)
				factory.close();

		}

	}
    
	/*public List<DashboardDataModel> getDashboardData(String customerId, String investmentTypeName) throws MoneyBuddyException {*/
	
	public List<DashboardDataModel> getDashboardData(String customerId) throws MoneyBuddyException {
		
		SessionFactory factory = null;
/*		SessionFactory factoryProductDetails = null;
		//SessionFactory factoryPriceHistory = null;
		SessionFactory factoryTransactionDetails = null;*/
		Session session  = null;
/*		Session sessionProductDetails  = null;
		//Session sessionPriceHistory  = null;
		Session sessionTransactionDetails  = null;*/
		try
		{
			logger.debug("QueryProducts class : getDashboardData method : start");
		
		factory = new AnnotationConfiguration()
														.configure()
														.addAnnotatedClass(CustomerPortfolio.class).addAnnotatedClass(ProductDetails.class)
														.addAnnotatedClass(TransactionDetails.class)
														.buildSessionFactory();
		session = factory.openSession();

/*		factoryProductDetails = new AnnotationConfiguration()
														.configure()
														.addAnnotatedClass(ProductDetails.class)
														.buildSessionFactory();
		sessionProductDetails = factoryProductDetails.openSession();

		factoryPriceHistory = new AnnotationConfiguration()
													.configure()
													.addAnnotatedClass(PriceHistory.class)
													.buildSessionFactory();
		sessionPriceHistory = factoryPriceHistory.openSession();
		
		factoryTransactionDetails = new AnnotationConfiguration()
				.configure()
				.addAnnotatedClass(TransactionDetails.class)
				.buildSessionFactory();
		sessionTransactionDetails = factoryTransactionDetails.openSession();*/

		
			session.beginTransaction();
			Query query = session.createQuery("from CustomerPortfolio where customerId = :customerId");
			/*Query query = sessionCustomerPortfolio.createQuery("from CustomerPortfolio where customerId = :customerId and investmentTypeName=:investmentTypeName");*/
			query.setParameter("customerId",customerId);
			/*query.setParameter("investmentTypeName",investmentTypeName);*/

			List<CustomerPortfolio> customerPortfolioList = query.list();
			List<DashboardDataModel> dashboardDataModel = new LinkedList<DashboardDataModel>();

			session.getTransaction().commit();
			for(CustomerPortfolio customerPortfolio : customerPortfolioList){

				session.beginTransaction();
														
				query = session.createQuery("from ProductDetails where productId = :productId");
				query.setParameter("productId",customerPortfolio.getProductId());
				List<ProductDetails> productDetailsList = query.list();

				session.getTransaction().commit();

/*				sessionPriceHistory.beginTransaction();
				query = sessionPriceHistory.createQuery("from PriceHistory where productId = :productId  and date=curdate()");
				query.setParameter("productId",customerPortfolio.getProductId());


				List<PriceHistory> priceHistoryList = query.list();

				sessionPriceHistory.getTransaction().commit();*/
				
				session.beginTransaction();
				query = session.createQuery("from TransactionDetails where transactionDetailId = :TransactionDetailId");
				query.setParameter("TransactionDetailId",customerPortfolio.getTransactionDetailId());


				List<TransactionDetails> TransactionDetailsList = query.list();

				session.getTransaction().commit();

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
						customerPortfolio.getPendingOrders(), Double.toString(availableToSell),
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
			if(factory!=null)
				factory.close();


		}

	}

	
	
	public List<PortfolioDataModel> getPortfolioData(String customerId) throws MoneyBuddyException {
		
		SessionFactory factory = null;
		Session session  = null;
		double soldUnit = 0.0;
		double investedAmount = 0.0;
		double availableUnits = 0.0;
		double currentAmount = 0.0;
		double rateOfGrowth = 0.0;
		
		try
		{
			logger.debug("QueryProducts class : getPortfolioData method : start");
			
			factory = new AnnotationConfiguration()
					.configure()
					.addAnnotatedClass(ProductDetails.class).addAnnotatedClass(TransactionDetails.class).addAnnotatedClass(NavHistory.class)
					.buildSessionFactory();
			session = factory.openSession();
		
			session.beginTransaction();

			List<PortfolioDataModel> portfolioDataModel = new LinkedList<PortfolioDataModel>();
			
            Query buyRecordsQuery, sellRecordsQuery;
			Query query = session.createQuery("select distinct(x.productName), x.productId from ProductDetails x, TransactionDetails y where x.productId = y.productId and y.customerId = :customerId");
			
			query.setParameter("customerId",customerId);
			
			//List<String> productsList = query.list();
			
			 for(Iterator it=query.iterate(); it.hasNext();){
				 
			       Object[] row = (Object[]) it.next();
			       
			       System.out.println("Product Name: " + row[0]);
			       
			       System.out.println("Product ID: " + row[1]);	
			       
			       String currentNavValue = session.createQuery("select navValue from NavHistory where schemeCode = '"+row[0]+"' and navDate = (select max(navDate) from NavHistory) ").uniqueResult().toString();
			       
			       System.out.println("Product Latest NAV Value : " + currentNavValue);
			       
			       String transactionStartDate = session.createQuery("select min(transactionDate) from TransactionDetails where productId='"+row[1]+"' and customerId='"+customerId+"'").uniqueResult().toString();
			       
			       System.out.println("transactionStartDate : " + transactionStartDate);
			       
			       
			       
			       
			       sellRecordsQuery = session.createQuery("select transactionDetailId, transactionAmount, quantity, unitPrice from TransactionDetails where productId='"+row[1]+"' and customerId='"+customerId+"' and buySell='SELL' ");
			       
			       for (Iterator sellIt=sellRecordsQuery.iterate(); sellIt.hasNext();)  {
			    	   
			    	   Object[] sellRecordRow = (Object[]) sellIt.next();
				       
			    	   soldUnit += Double.parseDouble(sellRecordRow[2].toString());
				       System.out.println("Product transactionDetail for SEll - id : "+sellRecordRow[0]+" amount: "+sellRecordRow[1]+" unit: "+sellRecordRow[2]+" unitPrice: "+sellRecordRow[3]);
			    	   
			       }
			       
			       System.out.println("Total sold units : "+soldUnit);
			       
			       buyRecordsQuery = session.createQuery("select transactionDetailId, transactionAmount, quantity, unitPrice from TransactionDetails where productId='"+row[1]+"' and customerId='"+customerId+"' and buySell='BUY' ");
			       
			       for (Iterator buyIt=buyRecordsQuery.iterate(); buyIt.hasNext();)  {
			    	   
			    	   Object[] buyRecordRow = (Object[]) buyIt.next();
				       
				       System.out.println("Product transactionDetail for BUY - id : "+buyRecordRow[0]+" amount: "+buyRecordRow[1]+" unit: "+buyRecordRow[2]+" unitPrice: "+buyRecordRow[3]);
			    	   
				       if (soldUnit != 0 )   {
				    	   
				    	   if (Double.parseDouble(buyRecordRow[2].toString()) > soldUnit)  {
				    		   availableUnits += (Double.parseDouble(buyRecordRow[2].toString()) - soldUnit);
				    		   investedAmount += (Double.parseDouble(buyRecordRow[2].toString()) - soldUnit)* (Double.parseDouble(buyRecordRow[3].toString()));
				    		   soldUnit = 0;
				    		   
				    	   }
				    	   else {
				    		   
				    		   soldUnit -= Double.parseDouble(buyRecordRow[2].toString());
				    		   
				    	   }
				       }
				       
				       else {
				    	   availableUnits += Double.parseDouble(buyRecordRow[2].toString());
				    	   investedAmount += (Double.parseDouble(buyRecordRow[2].toString()))* (Double.parseDouble(buyRecordRow[3].toString()));
				       }
				            
			       }
			       
			       currentAmount = availableUnits* Double.parseDouble(currentNavValue);
			       rateOfGrowth = ((currentAmount - investedAmount)/investedAmount)*100;
			       
			       System.out.println("Total availableUnits : "+availableUnits);
			       System.out.println("Total invested Amount : "+investedAmount);
			       System.out.println("Current Amount : "+currentAmount);
			       System.out.println("Rate of Growth : "+rateOfGrowth);
			      
			       
			       portfolioDataModel.add(new PortfolioDataModel(row[0].toString(),Double.toString(availableUnits),Double.toString(investedAmount),Double.toString(currentAmount),Double.toString(rateOfGrowth),transactionStartDate));
			 }


			session.getTransaction().commit();

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
			if(factory!=null)
				factory.close();

		}

	}
	
	
public List<InvestmentDetailsDataModel> getInvestmentDetailsData(String customerId, String productName) throws MoneyBuddyException {
		
		SessionFactory factory = null;
		Session session  = null;
		
		try
		{
			logger.debug("QueryProducts class : getInvestmentDetailsData method : start");
			
			factory = new AnnotationConfiguration()
					.configure()
					.addAnnotatedClass(ProductDetails.class).addAnnotatedClass(TransactionDetails.class)
					.buildSessionFactory();
			session = factory.openSession();
		
			session.beginTransaction();

			List<InvestmentDetailsDataModel> investmentDetailsDataModel = new LinkedList<InvestmentDetailsDataModel>();
			
			String productId = session.createQuery("select productId from ProductDetails  where productName='"+productName+"'").uniqueResult().toString();

			Query query = session.createQuery("SELECT transactionDate,quantity,unitPrice,transactionType,buySell from TransactionDetails where productId='"+productId+"' and customerId='"+customerId+"'");
			       
			String quantity;
			for (Iterator it=query.iterate(); it.hasNext();)  {
			    
				Object[] transactionDetailsRow = (Object[]) it.next();
				if ( transactionDetailsRow[4].toString().equals("SELL") ) {
					quantity = "-"+transactionDetailsRow[1].toString();
				}
				else {
					quantity = transactionDetailsRow[1].toString();
				}

				investmentDetailsDataModel.add(new InvestmentDetailsDataModel(transactionDetailsRow[0].toString(),quantity,transactionDetailsRow[2].toString(),transactionDetailsRow[3].toString()));
				
			}


			session.getTransaction().commit();

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
			if(factory!=null)
				factory.close();

		}

	}
	
}

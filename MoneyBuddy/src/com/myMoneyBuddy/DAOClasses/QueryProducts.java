/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.CustomerPortfolio;
import com.myMoneyBuddy.EntityClasses.ProductDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
/*import com.myMoneyBuddy.EntityClasses.PriceHistory;*/
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

import java.util.HashMap;
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
			
			Query query = session.createQuery("from ProductDetails where riskCategory = :riskCategory and planName =:planName");
			query.setParameter("riskCategory",riskCategory);
			query.setParameter("planName",planName);
			List<ProductDetails> productDetailList = query.list();
			HashMap<String,Double> hashMap = new HashMap<String,Double>();

			for(ProductDetails productDetail : productDetailList){
				hashMap.put(productDetail.getProductType()+"-"+productDetail.getProductName(),Double.parseDouble(productDetail.getPercentage()));
			}
			session.getTransaction().commit();

			int i =0 ;

			for (String key : hashMap.keySet()) {
				i++;
			}
			
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
			Query query = session.createQuery("from ProductDetails where riskCategory = :riskCategory and planName =:planName");
			query.setParameter("riskCategory",riskCategory);
			query.setParameter("planName",planName);
			List<ProductDetails> productDetailList = query.list();
			HashMap<String,Double> hashMap = new HashMap<String,Double>();

			for(ProductDetails productDetail : productDetailList){
				hashMap.put(productDetail.getProductId(),((upfrontInvestment*Double.parseDouble(productDetail.getPercentage()))/100));
			}
			session.getTransaction().commit();

			int i =0 ;

			for (String key : hashMap.keySet()) {
				i++;
			}
			
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
		
		SessionFactory factoryCustomerPortfolio = null;
		SessionFactory factoryProductDetails = null;
		//SessionFactory factoryPriceHistory = null;
		SessionFactory factoryTransactionDetails = null;
		Session sessionCustomerPortfolio  = null;
		Session sessionProductDetails  = null;
		//Session sessionPriceHistory  = null;
		Session sessionTransactionDetails  = null;
		try
		{
			logger.debug("QueryProducts class : getDashboardData method : start");
		
		factoryCustomerPortfolio = new AnnotationConfiguration()
														.configure()
														.addAnnotatedClass(CustomerPortfolio.class)
														.buildSessionFactory();
		sessionCustomerPortfolio = factoryCustomerPortfolio.openSession();

		factoryProductDetails = new AnnotationConfiguration()
														.configure()
														.addAnnotatedClass(ProductDetails.class)
														.buildSessionFactory();
		sessionProductDetails = factoryProductDetails.openSession();

/*		factoryPriceHistory = new AnnotationConfiguration()
													.configure()
													.addAnnotatedClass(PriceHistory.class)
													.buildSessionFactory();
		sessionPriceHistory = factoryPriceHistory.openSession();*/
		
		factoryTransactionDetails = new AnnotationConfiguration()
				.configure()
				.addAnnotatedClass(TransactionDetails.class)
				.buildSessionFactory();
		sessionTransactionDetails = factoryTransactionDetails.openSession();

		
			sessionCustomerPortfolio.beginTransaction();
			Query query = sessionCustomerPortfolio.createQuery("from CustomerPortfolio where customerId = :customerId");
			/*Query query = sessionCustomerPortfolio.createQuery("from CustomerPortfolio where customerId = :customerId and investmentTypeName=:investmentTypeName");*/
			query.setParameter("customerId",customerId);
			/*query.setParameter("investmentTypeName",investmentTypeName);*/

			List<CustomerPortfolio> customerPortfolioList = query.list();
			List<DashboardDataModel> dashboardDataModel = new LinkedList<DashboardDataModel>();

			for(CustomerPortfolio customerPortfolio : customerPortfolioList){

				sessionProductDetails.beginTransaction();
														
				query = sessionProductDetails.createQuery("from ProductDetails where productId = :productId");
				query.setParameter("productId",customerPortfolio.getProductId());
				List<ProductDetails> productDetailsList = query.list();

				sessionProductDetails.getTransaction().commit();

/*				sessionPriceHistory.beginTransaction();
				query = sessionPriceHistory.createQuery("from PriceHistory where productId = :productId  and date=curdate()");
				query.setParameter("productId",customerPortfolio.getProductId());


				List<PriceHistory> priceHistoryList = query.list();

				sessionPriceHistory.getTransaction().commit();*/
				
				sessionTransactionDetails.beginTransaction();
				query = sessionTransactionDetails.createQuery("from TransactionDetails where transactionDetailId = :TransactionDetailId");
				query.setParameter("TransactionDetailId",customerPortfolio.getTransactionDetailId());


				List<TransactionDetails> TransactionDetailsList = query.list();

				sessionTransactionDetails.getTransaction().commit();

				int availableToSell = Integer.parseInt(customerPortfolio.getTotalQuantity());

				if ( Integer.parseInt(customerPortfolio.getPendingOrders()) < 0 )   {
					availableToSell = availableToSell + Integer.parseInt(customerPortfolio.getPendingOrders());

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
						customerPortfolio.getPendingOrders(), Integer.toString(availableToSell),
						TransactionDetailsList.get(0).getBseOrderId(),TransactionDetailsList.get(0).getReverseFeed(),customerPortfolio.getTransactionDate(),TransactionDetailsList.get(0).getTransactionAmount()));
				

			}

			sessionCustomerPortfolio.getTransaction().commit();

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
			if(factoryCustomerPortfolio!=null)
				factoryCustomerPortfolio.close();
			
			if(factoryProductDetails!=null)
				factoryProductDetails.close();
		
/*			if(factoryPriceHistory!=null)
				factoryPriceHistory.close();*/

		}

	}

}

/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.OrderDataModel;
import com.myMoneyBuddy.ModelClasses.PendingNavOrders;
import com.myMoneyBuddy.Utils.HibernateUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class QueryTransactionDetails {

	Logger logger = Logger.getLogger(QueryTransactionDetails.class);

	public String getFolioNumsList(String customerId, String productId) throws MoneyBuddyException {
		
		logger.debug("QueryTransactionDetails class - getFolioNumsList method - customerId - "+customerId+" and productId - "+productId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		String folioNums = "";

		try
		{
			System.out.println("customerId is : "+customerId+" and productId is : "+productId);
			hibernateSession.beginTransaction();
    		
    		Query query = hibernateSession.createQuery("select distinct(folioNum) from FolioDetails "
    				+ " where customerId = :customerId and  amcCode = (select amcCode from  SecondaryFundDetails where fundId = :fundId) ");
    		query.setParameter("customerId", customerId);
    		query.setParameter("fundId", productId);
    		List<String> folioNumList = query.list();
    		
    		System.out.println("folioNumList size : ........... "+folioNumList.size());
    		
    		if ( folioNumList.size() == 0 ) {
    			folioNums = "NEW";
    		}
    		else {
    			folioNums = "NEW:";
    			for ( int i =0; i< folioNumList.size()-1; i++ )  {
    				if (folioNumList.get(i) != null)
    					folioNums += folioNumList.get(i)+":";
    			}
    			folioNums += folioNumList.get(folioNumList.size()-1);
    		}
    		
    		hibernateSession.getTransaction().commit();
			
			logger.debug("QueryTransactionDetails class - getFolioNumsList method - customerId - "+customerId+" and productId - "+productId+" - return FolioNums List");
			logger.debug("QueryTransactionDetails class - getFolioNumsList method - customerId - "+customerId+" and productId - "+productId+" - end");
			
			return folioNums;
		}
		catch ( HibernateException e ) {
			logger.error("QueryTransactionDetails class - getFolioNumsList method - customerId - "+customerId+" and productId - "+productId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryTransactionDetails class - getFolioNumsList method - customerId - "+customerId+" and productId - "+productId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	
	public TransactionDetails getTransactionDetails(String transactionDetailId) throws MoneyBuddyException {
		
		logger.debug("QueryTransactionDetails class - getTransactionDetails method - transactionDetailId - "+transactionDetailId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		hibernateSession.clear();
		
		TransactionDetails transactionDetails = new TransactionDetails();
	
	
		try
		{
			System.out.println("transactionDetailId is : "+transactionDetailId);
			hibernateSession.beginTransaction();
			transactionDetails = (TransactionDetails) hibernateSession.get(TransactionDetails.class, transactionDetailId);
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryTransactionDetails class - getTransactionDetails method - transactionDetailId - "+transactionDetailId+" - return TransactionDetails record");
			logger.debug("QueryTransactionDetails class - getTransactionDetails method - transactionDetailId - "+transactionDetailId+" - end");
			
			return transactionDetails;
		}
		catch ( HibernateException e ) {
			logger.error("QueryTransactionDetails class - getTransactionDetails method - transactionDetailId - "+transactionDetailId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryTransactionDetails class - getTransactionDetails method - transactionDetailId - "+transactionDetailId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public List<PendingNavOrders> getPendingNavsOrders() throws MoneyBuddyException {
		
		 
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		List<PendingNavOrders> pendingNavOrders = new LinkedList<PendingNavOrders>();
	
		try
		{
			logger.debug("QueryTransactionDetails class - getPendingNavsOrders method - start");
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select t.bseOrderId,s.rta,p.schemeType,t.updateDate,t.transactionFolioNum"
					+ " from TransactionDetails t, SecondaryFundDetails s, PrimaryFundDetails p "
					+ "where t.transactionStatus='7' and t.productId=p.fundId and t.productId=s.fundId");
			
			List<Object[]> transactionDetailsList = query.list();
			String bseOrderId = "";
			String rta = "";
			String schemeType = "";
			String updateDate = "";
			String folioNum = "";
			for ( int i = 0; i < transactionDetailsList.size() ;i++ ) {
				
				if (null == transactionDetailsList.get(i)[0])
					bseOrderId = "";
				else
					bseOrderId = transactionDetailsList.get(i)[0].toString();
				if (null == transactionDetailsList.get(i)[1])
					rta = "";
				else
					rta = transactionDetailsList.get(i)[1].toString();
				if (null == transactionDetailsList.get(i)[2])
					schemeType = "";
				else
					schemeType = transactionDetailsList.get(i)[2].toString();
				if (null == transactionDetailsList.get(i)[3])
					updateDate = "";
				else
					updateDate = transactionDetailsList.get(i)[3].toString();
				if (null == transactionDetailsList.get(i)[4])
					folioNum = "";
				else
					folioNum = transactionDetailsList.get(i)[4].toString();
				
					
				pendingNavOrders.add( new PendingNavOrders(bseOrderId,rta,schemeType,updateDate, folioNum));
			}
			
			/*Iterator it = pendingNavOrders.entrySet().iterator();
			 
			while ( it.hasNext() )  {
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println("key : "+pair.getKey()+" and value : "+pair.getValue());
				
			}*/
			hibernateSession.getTransaction().commit();
			
			
			logger.debug("QueryTransactionDetails class - getPendingNavsOrders method - return pendingNavOrders containg bseOrderId and folioNum records for transactionStatus 7 ");
			logger.debug("QueryTransactionDetails class - getPendingNavsOrders method - end");
			
			return pendingNavOrders;
		}
		catch ( HibernateException e ) {
			logger.error("QueryTransactionDetails class - getPendingNavsOrders method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryTransactionDetails class - getPendingNavsOrders method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}

	public boolean haveInvestments(String customerId)  throws MoneyBuddyException  {
		
		logger.debug("QueryTransactionDetails class - haveInvestments method - customerId - "+customerId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			System.out.println("customerId is : "+customerId);
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("select count(*) from TransactionDetails   where customerId = :customerId ");
			query.setParameter("customerId", customerId);
			
			String count = query.uniqueResult().toString();
			
			hibernateSession.getTransaction().commit();
			
			logger.debug("QueryTransactionDetails class - haveInvestments method - customerId - "+customerId+" - end");
			
			if (Integer.parseInt(count) == 0 )  
				return false;
			else 
				return true;
		}
		catch ( HibernateException e ) {
			logger.error("QueryTransactionDetails class - haveInvestments method - customerId - "+customerId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryTransactionDetails class - haveInvestments method - customerId - "+customerId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
}

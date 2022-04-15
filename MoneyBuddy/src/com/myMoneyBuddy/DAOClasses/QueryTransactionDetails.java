/**
 *
 * @author Savita Wadhwani
 */
package com.myMoneyBuddy.DAOClasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;
import com.myMoneyBuddy.ModelClasses.PendingNavOrders;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class QueryTransactionDetails {

	Logger logger = LogManager.getLogger(QueryTransactionDetails.class);

	public String getFolioNumsList(String customerId, String fundId) throws MoneyBuddyException {
		
		logger.debug("QueryTransactionDetails class - getFolioNumsList method - customerId - "+customerId+" and fundId - "+fundId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		String folioNums = "";

		try
		{
			System.out.println("customerId is : "+customerId+" and fundId is : "+fundId);
			hibernateSession.beginTransaction();
    		
    		Query query = hibernateSession.createQuery("select distinct(folioNum) from FolioDetails "
    				+ " where customerId = :customerId and  amcCode = (select amcCode from  SecondaryFundDetails where fundId = :fundId)"
    				+ " order by folioDetailsId desc ");
    		query.setParameter("customerId", customerId);
    		query.setParameter("fundId", fundId);
    		List<String> folioNumList = query.list();
    		
    		System.out.println("folioNumList size : ........... "+folioNumList.size());
    		
    		if ( folioNumList.size() == 0 ) {
    			folioNums = "New";
    		}
    		else {
    			
    			for ( int i =0; i< folioNumList.size()-1; i++ )  {
    				if (folioNumList.get(i) != null)
    					folioNums += folioNumList.get(i)+":";
    			}
    			folioNums += folioNumList.get(folioNumList.size()-1);
    			folioNums += ":New";
    		}
    		
    		hibernateSession.getTransaction().commit();
			
			logger.debug("QueryTransactionDetails class - getFolioNumsList method - customerId - "+customerId+" and fundId - "+fundId+" - return FolioNums List");
			logger.debug("QueryTransactionDetails class - getFolioNumsList method - customerId - "+customerId+" and fundId - "+fundId+" - end");
			
			return folioNums;
		}
		catch ( HibernateException e ) {
			logger.error("QueryTransactionDetails class - getFolioNumsList method - customerId - "+customerId+" and fundId - "+fundId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryTransactionDetails class - getFolioNumsList method - customerId - "+customerId+" and fundId - "+fundId+" - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}
	
	public TransactionDetails getTransactionDetailsFromBseOrderId(String bseOrderId) throws MoneyBuddyException {
		
		logger.debug("QueryTransactionDetails class - getFolioNumsList method - bseOrderId - "+bseOrderId+" - start");
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();

		try
		{
			TransactionDetails transactionDetails;
			try {
				hibernateSession.beginTransaction();
				Query query = hibernateSession.createQuery("from TransactionDetails where bseOrderId = :bseOrderId");
			
				query.setParameter("bseOrderId",bseOrderId);
				transactionDetails = (TransactionDetails) query.uniqueResult();
	
				hibernateSession.getTransaction().commit();
			}
			catch (NonUniqueResultException e)  {
				return null;
			}
			catch (NoResultException e) {
		        return null;
		    }
			
			logger.debug("QueryTransactionDetails class - getFolioNumsList method - bseOrderId - "+bseOrderId+" - return TransactionDetails object");
			logger.debug("QueryTransactionDetails class - getFolioNumsList method - bseOrderId - "+bseOrderId+" - end");
			
			return transactionDetails;
		}
		
		catch ( HibernateException e ) {
			logger.error("QueryTransactionDetails class - getFolioNumsList method - bseOrderId - "+bseOrderId+" - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryTransactionDetails class - getFolioNumsList method - bseOrderId - "+bseOrderId+" - Caught Exception");
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
	
	
	public List<String> getPendingBseOrdIdAndRegNum() throws MoneyBuddyException {
		
		 
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		List<String> bseOrdIdAndRegNumList = new LinkedList<String>();
	
		try
		{
			logger.debug("QueryTransactionDetails class - getPendingBseOrdIdAndRegNum method - start");
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select bseOrderId from TransactionDetails where transactionStatus='7' and transactionType='UPFRONT' ");
			
			List<String> bseOrderIdLlist = query.list();
			
			
			for ( int i = 0; i < bseOrderIdLlist.size() ;i++ ) {
				
				String bseOrderId = "";
				if (!(null == bseOrderIdLlist.get(i)))  {
					bseOrderId = bseOrderIdLlist.get(i).toString();
					System.out.println(" Added new bseOrderId : "+bseOrderId+" to the bseOrdIdAndRegNumList");
					bseOrdIdAndRegNumList.add(bseOrderId);
				}
				
			}
			
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select bseRegistrationNumber from TransactionDetails where transactionStatus='7' and transactionType='SIP' ");
			
			List<String> bseRegNumList = query.list();
			
			
			for ( int i = 0; i < bseRegNumList.size() ;i++ ) {
				
				String bseRegNum = "";
				if (!(null == bseRegNumList.get(i)))  {
					bseRegNum = bseRegNumList.get(i).toString();
					System.out.println(" Added new bseRegNum : "+bseRegNum+" to the bseOrdIdAndRegNumList");
					bseOrdIdAndRegNumList.add(bseRegNum);
				}
				
			}
			
			hibernateSession.getTransaction().commit();
			
			
			logger.debug("QueryTransactionDetails class - getPendingBseOrdIdAndRegNum method - return pendingNavOrders containg bseOrderId and folioNum records for transactionStatus 7 ");
			logger.debug("QueryTransactionDetails class - getPendingBseOrdIdAndRegNum method - end");
			
			return bseOrdIdAndRegNumList;
		}
		catch ( HibernateException e ) {
			logger.error("QueryTransactionDetails class - getPendingBseOrdIdAndRegNum method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryTransactionDetails class - getPendingBseOrdIdAndRegNum method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}

	
	public List<String> getAllBseOrdIdAndRegNum() throws MoneyBuddyException {
		
		 
		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		List<String> allBseOrdIdAndRegNumList = new LinkedList<String>();
	
		try
		{
			logger.debug("QueryTransactionDetails class - getAllBseOrdIdAndRegNum method - start");
			hibernateSession.beginTransaction();
			Query query = hibernateSession.createQuery("select bseOrderId from TransactionDetails where transactionType='UPFRONT' ");
			
			List<String> bseOrderIdLlist = query.list();
			
			
			for ( int i = 0; i < bseOrderIdLlist.size() ;i++ ) {
				
				String bseOrderId = "";
				if (!(null == bseOrderIdLlist.get(i)))  {
					bseOrderId = bseOrderIdLlist.get(i).toString();
					allBseOrdIdAndRegNumList.add(bseOrderId);
				}
				
			}
			
			hibernateSession.getTransaction().commit();
			
			hibernateSession.beginTransaction();
			query = hibernateSession.createQuery("select bseRegistrationNumber from TransactionDetails where transactionType='SIP' ");
			
			List<String> bseRegNumList = query.list();
			
			
			for ( int i = 0; i < bseRegNumList.size() ;i++ ) {
				
				String bseRegNum = "";
				if (!(null == bseRegNumList.get(i)))  {
					bseRegNum = bseRegNumList.get(i).toString();
					allBseOrdIdAndRegNumList.add(bseRegNum);
				}
				
			}
			
			hibernateSession.getTransaction().commit();
			
			
			logger.debug("QueryTransactionDetails class - getAllBseOrdIdAndRegNum method - return pendingNavOrders containg bseOrderId and folioNum records for transactionStatus 7 ");
			logger.debug("QueryTransactionDetails class - getAllBseOrdIdAndRegNum method - end");
			
			return allBseOrdIdAndRegNumList;
		}
		catch ( HibernateException e ) {
			logger.error("QueryTransactionDetails class - getAllBseOrdIdAndRegNum method - Caught HibernateException");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("QueryTransactionDetails class - getAllBseOrdIdAndRegNum method - Caught Exception");
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
			Query query = hibernateSession.createQuery("select t.bseOrderId,s.rta,p.schemeType,t.transactionDate,t.transactionFolioNum,"
					+ "t.transactionType,t.bseRegistrationNumber,t.customerId,t.buySell"
					+ " from TransactionDetails t, SecondaryFundDetails s, PrimaryFundDetails p "
					+ "where t.transactionStatus='7' and t.fundId=p.fundId and t.fundId=s.fundId");
			
			List<Object[]> transactionDetailsList = query.list();
			String bseOrderId = "";
			String rta = "";
			String schemeType = "";
			String transactionDate = "";
			String frmtTransactionDate = "";
			String folioNum = "";
			String bseRegNum;
			String tranType="";
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
					transactionDate = "";
				else  {
					transactionDate = transactionDetailsList.get(i)[3].toString();
					SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
					Date   date       = dateFormat1.parse ( transactionDate );    
					//Date date = new Date();
					frmtTransactionDate = dateFormat2.format( date );
					
				}
				
				if (null == transactionDetailsList.get(i)[4])
					folioNum = "";
				else
					folioNum = transactionDetailsList.get(i)[4].toString();
				if (null == transactionDetailsList.get(i)[6])
					bseRegNum = "";
				else
					bseRegNum = transactionDetailsList.get(i)[6].toString();
				
				System.out.println("bseRegNum : "+bseRegNum+" and transactionDetailsList.get(i)[4] : "+transactionDetailsList.get(i)[4]);	
				
				if ("STP".equals(transactionDetailsList.get(i)[5].toString()))
				{
					tranType = transactionDetailsList.get(i)[5].toString()+"-"+transactionDetailsList.get(i)[8].toString();
				}
				else if ("SWITCH".equals(transactionDetailsList.get(i)[5].toString()))
				{
					String buySellType ="";
					if ( "BUY".equalsIgnoreCase(transactionDetailsList.get(i)[8].toString()))  {
						buySellType = "IN";
					}
					else 
						buySellType = "OUT";
					tranType = transactionDetailsList.get(i)[5].toString()+"-"+buySellType;
				}
				else {
					tranType = transactionDetailsList.get(i)[5].toString();
				}
				
				pendingNavOrders.add( new PendingNavOrders(transactionDetailsList.get(i)[7].toString(),bseOrderId,bseRegNum,
						tranType,rta,schemeType,transactionDate,
						frmtTransactionDate, folioNum));
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
			System.out.println("customerId is :"+customerId+":");
			hibernateSession.beginTransaction();
			
			Query query = hibernateSession.createQuery("select count(*) from TransactionDetails   where customerId = :customerId ");
			query.setParameter("customerId", customerId);
			
			String count = query.uniqueResult().toString();
			
			hibernateSession.getTransaction().commit();
			
			
			System.out.println("count is :"+count+":");
			
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

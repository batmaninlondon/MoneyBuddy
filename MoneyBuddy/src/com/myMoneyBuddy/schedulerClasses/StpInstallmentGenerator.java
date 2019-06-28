package com.myMoneyBuddy.schedulerClasses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.EntityClasses.StpDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class StpInstallmentGenerator implements org.quartz.Job{


	Logger logger = Logger.getLogger(StpInstallmentGenerator.class);
	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
			
			System.out.println("StpInstallmentGenerator CLASS EXECUTION -------  START");
			
			hibernateSession.beginTransaction();
			
			Calendar cal = Calendar.getInstance();
			String todayDate = Integer.toString(cal.get(Calendar.DATE));
			
			System.out.println("todayDate : "+todayDate);
			
			Query query = hibernateSession.createQuery("from StpDetails where stpDate = :stpDate and stpCompletionStatus = :stpCompletionStatus ");

			query.setParameter("stpDate", todayDate);
			query.setParameter("stpCompletionStatus", "N");
			
			List<StpDetails> stpDetailsList = query.list();
			hibernateSession.getTransaction().commit();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String modifiedDate = dateFormat.format(date);
			
	        Date currentDate = dateFormat.parse(modifiedDate);
	        Date stpEndDate;

	        System.out.println("currentDate : " +currentDate);
			
			for (StpDetails stpDetail : stpDetailsList)  {
 
				stpEndDate = dateFormat.parse(stpDetail.getStpEndDate());
				System.out.println("stpEndDate : " + stpEndDate);
		        
		        if (currentDate.compareTo(stpEndDate) > 0) {
		        	hibernateSession.beginTransaction();
		        	query = hibernateSession.createQuery("update StpDetails set stpCompletionStatus='Y' where customerId= :customerId and transactionDetailId = :transactionDetailId ");
		        	query.setParameter("customerId", stpDetail.getCustomerId());
		        	query.setParameter("transactionDetailId", stpDetail.getTransactionDetailId());
		        	
		        	int updateResult = query.executeUpdate();
					System.out.println(updateResult + " rows updated in StpDetails table ");
					
					hibernateSession.getTransaction().commit();
	
		        } 
		        else {
		        	//System.out.println("Trigger will be coming here soon .. ");
		        	
		        	hibernateSession.beginTransaction();
					
					query = hibernateSession.createQuery(" from TransactionDetails where transactionDetailId = :transactionDetailId ");
					query.setParameter("transactionDetailId", stpDetail.getTransactionDetailId());
					
					TransactionDetails transactionDetails = (TransactionDetails) query.uniqueResult();
					
					hibernateSession.getTransaction().commit();
					
					hibernateSession.beginTransaction();
					
					query = hibernateSession.createQuery("select max(transactionId) from TransactionDetails");
					
					String nextTransactionId = Integer.toString(Integer.parseInt(query.uniqueResult().toString())+1);
					
					
					hibernateSession.getTransaction().commit();
					
					SimpleDateFormat dateFrmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String frmtdDateForDB = dateFrmt.format(date);
					
					
					hibernateSession.beginTransaction();
					
		        	TransactionDetails tempTransactionDetail  = new TransactionDetails(nextTransactionId, null,stpDetail.getBseRegNum(),
		        			null, stpDetail.getCustomerId(),"STP" ,"WITHDRAWAL","SELL", "ADDITIONAL", stpDetail.getStpAmount(),
							"7", "AUTO WITHDRAWAL OF FUND ID : "+stpDetail.getWithdrawalFundId()+" FOR BSE Reg Num : "+stpDetail.getBseRegNum(),
							"0","N",stpDetail.getWithdrawalFundId(),null,null,frmtdDateForDB, frmtdDateForDB,"N",
							transactionDetails.getTransactionFolioNum(),null,"N"); 		

					hibernateSession.save(tempTransactionDetail);
					hibernateSession.getTransaction().commit();
					
					hibernateSession.beginTransaction();
					
					query = hibernateSession.createQuery("select max(transactionId) from TransactionDetails");
					
					nextTransactionId = Integer.toString(Integer.parseInt(query.uniqueResult().toString())+1);
					
					hibernateSession.getTransaction().commit();
					
					hibernateSession.beginTransaction();
					
		        	tempTransactionDetail  = new TransactionDetails(nextTransactionId, null,stpDetail.getBseRegNum(),
		        			null, stpDetail.getCustomerId(),"STP" ,"PURCHASE","BUY", "ADDITIONAL", stpDetail.getStpAmount(),
							"7", "AUTO PURCHASE OF FUND ID : "+stpDetail.getPurchaseFundId()+" FOR BSE Reg Num : "+stpDetail.getBseRegNum(),
							"0","N",stpDetail.getPurchaseFundId(),null,null,frmtdDateForDB, frmtdDateForDB,"N",
							transactionDetails.getTransactionFolioNum(),null,"N"); 		

					hibernateSession.save(tempTransactionDetail);
					hibernateSession.getTransaction().commit();
					
					logger.debug("StpInstallmentGenerator class - execute method - customerId - "+stpDetail.getCustomerId()+" - and transactionType - STP - inserted 2 new rows in TransactionDetails table ");

					
		        }

			}

			System.out.println("StpInstallmentGenerator CLASS EXECUTION -------  END");
			
	 
		}
		catch (Exception e) {	

			e.printStackTrace();

		} 
		finally {
			if(hibernateSession !=null )
					hibernateSession.close();
		}
	}

}

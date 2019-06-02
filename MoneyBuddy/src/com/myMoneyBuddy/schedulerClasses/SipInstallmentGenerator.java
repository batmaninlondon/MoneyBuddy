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

import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class SipInstallmentGenerator implements org.quartz.Job{


	Logger logger = Logger.getLogger(SipInstallmentGenerator.class);
	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
			
			hibernateSession.beginTransaction();
			
			Calendar cal = Calendar.getInstance();
			String todayDate = Integer.toString(cal.get(Calendar.DATE));
			
			System.out.println("todayDate : "+todayDate);
			
			Query query = hibernateSession.createQuery("from SipDetails where sipDate = :sipDate and sipCompletionStatus = :sipCompletionStatus and sipFormSubmission = :sipFormSubmission ");

			query.setParameter("sipDate", todayDate);
			query.setParameter("sipCompletionStatus", "N");
			query.setParameter("sipFormSubmission", "Y");
			
			List<SipDetails> sipDetailsList = query.list();
			hibernateSession.getTransaction().commit();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String modifiedDate = dateFormat.format(date);
			
	        Date currentDate = dateFormat.parse(modifiedDate);
	        Date sipEndDate;

	        System.out.println("currentDate : " +currentDate);
			
			for (SipDetails sipDetail : sipDetailsList)  {
 
				sipEndDate = dateFormat.parse(sipDetail.getSipEndDate());
				System.out.println("sipEndDate : " + sipEndDate);
		        
		        if (currentDate.compareTo(sipEndDate) > 0) {
		        	hibernateSession.beginTransaction();
		        	query = hibernateSession.createQuery("update SipDetails set sipCompletionStatus='Y' where customerId= :customerId and transactionDetailId = :transactionDetailId ");
		        	query.setParameter("customerId", sipDetail.getCustomerId());
		        	query.setParameter("transactionDetailId", sipDetail.getTransactionDetailId());
		        	
		        	int updateResult = query.executeUpdate();
					System.out.println(updateResult + " rows updated in SipDetails table ");
					
					hibernateSession.getTransaction().commit();
	
		        } 
		        else {
		        	//System.out.println("Trigger will be coming here soon .. ");
		        	
		        	hibernateSession.beginTransaction();
					
					query = hibernateSession.createQuery(" from TransactionDetails where transactionDetailId = :transactionDetailId ");
					query.setParameter("transactionDetailId", sipDetail.getTransactionDetailId());
					
					TransactionDetails transactionDetails = (TransactionDetails) query.uniqueResult();
					
					hibernateSession.getTransaction().commit();
					
					hibernateSession.beginTransaction();
					
					query = hibernateSession.createQuery("select max(transactionId) from TransactionDetails");
					
					String nextTransactionId = Integer.toString(Integer.parseInt(query.uniqueResult().toString())+1);
					
					
					hibernateSession.getTransaction().commit();
					
					SimpleDateFormat dateFrmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String frmtdDateForDB = dateFrmt.format(date);
					
					
					System.out.println(" inserting a row for transaction Id : "+sipDetail.getTransactionDetailId());
					hibernateSession.beginTransaction();
					
		        	TransactionDetails tempTransactionDetail  = new TransactionDetails(nextTransactionId, null,transactionDetails.getBseRegistrationNumber(),
		        			null, sipDetail.getCustomerId(),"SIP" ,"AUTODEBIT","BUY", "ADDITIONAL", transactionDetails.getTransactionAmount(),
							"7", "AUTO DEBIT FOR BSE Reg Num : "+transactionDetails.getBseRegistrationNumber(),"0","N",transactionDetails.getProductId(), 
							null,null,frmtdDateForDB, frmtdDateForDB,"N",
							transactionDetails.getTransactionFolioNum(),null,"N"); 		

					hibernateSession.save(tempTransactionDetail);

					logger.debug("SipInstallmentGenerator class - execute method - customerId - "+sipDetail.getCustomerId()+" - and transactionType - SIP - inserted new row in TransactionDetails table with transactionId - "+nextTransactionId);

					hibernateSession.getTransaction().commit();
		        }

			}

			
			
	 
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

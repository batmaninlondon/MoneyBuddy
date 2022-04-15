package com.myMoneyBuddy.schedulerClasses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class SipInstallmentGenerator implements org.quartz.Job{


	Logger logger = LogManager.getLogger(SipInstallmentGenerator.class);
	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
			
			System.out.println("SipInstallmentGenerator CLASS EXECUTION -------  START");
			
			hibernateSession.beginTransaction();
			
			Calendar cal = Calendar.getInstance();
			//String todayDate = Integer.toString(cal.get(Calendar.DATE));
			String todayDate="1";
			
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
			
			
			System.out.println("sipDetailsList size : "+sipDetailsList.size());
			System.out.println("modifiedDate : "+modifiedDate);
	        Date currentDate = dateFormat.parse(modifiedDate);
	        Date sipEndDate;
	        Date sipStartDate;
	        
	        System.out.println("currentDate : " +currentDate);
	        
	        String folioNum = null;
			
			for (SipDetails sipDetail : sipDetailsList)  {
				
				folioNum = null;
 
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
		        	
		        	sipStartDate = dateFormat.parse(sipDetail.getSipStartDate());
					System.out.println("sipStartDate : " + sipStartDate);
		        	
					if (currentDate.compareTo(sipStartDate) >= 0) {
						
			        	hibernateSession.beginTransaction();
						
						query = hibernateSession.createQuery(" from TransactionDetails where transactionDetailId = :transactionDetailId ");
						query.setParameter("transactionDetailId", sipDetail.getTransactionDetailId());
						
						TransactionDetails transactionDetails = (TransactionDetails) query.uniqueResult();
						
						hibernateSession.getTransaction().commit();
						
						hibernateSession.beginTransaction();
						
						String nextTransactionId = "1";
						 
						String sql = "select "
								+ "max(CONVERT(SUBSTRING(TRANSACTION_ID,"+(transactionDetails.getTransactionId().length()+2)+"),UNSIGNED INTEGER)) AS num "
								+ "from TRANSACTION_DETAILS "
								+ "where TRANSACTION_ID like '"+transactionDetails.getTransactionId()+"-%' ";
						
						SQLQuery sqlQuery = hibernateSession.createSQLQuery(sql);
					
						Object result = sqlQuery.uniqueResult();
						
						int transactionIdSplit = 0;
						if (result != null)
							transactionIdSplit = Integer.parseInt(sqlQuery.uniqueResult().toString());
						
						String transactionId;
						
						hibernateSession.getTransaction().commit();
						
						if (transactionIdSplit == 0) {
							transactionId = transactionDetails.getTransactionId();
						}
						else 
							transactionId = transactionDetails.getTransactionId()+'-'+transactionIdSplit;
						
						
						hibernateSession.beginTransaction();
						
						
						query = hibernateSession.createQuery("select max(transactionDate) from TransactionDetails where  transactionId = :transactionId ");
						query.setParameter("transactionId", transactionId);
											
						String transactionDate = query.uniqueResult().toString().substring(0,10);
						
						hibernateSession.getTransaction().commit();
						
						SimpleDateFormat dateFrmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String frmtdDateForDB = dateFrmt.format(date);
						
						if ( frmtdDateForDB.substring(0,10).equals(transactionDate))   {
							nextTransactionId = transactionDetails.getTransactionId()+"-"+
											(transactionIdSplit+1);
						}
						else {
							if ( transactionId.split("-").length == 1 )
								nextTransactionId = transactionId+"-1";
							else 
								//nextTransactionId = transactionId.split("-")[0]+"-"+(Integer.parseInt(transactionId.split("-")[1])+1);
								nextTransactionId = transactionDetails.getTransactionId()+"-"+
														(transactionIdSplit+1);
						}
												
						hibernateSession.beginTransaction();
												
						query = hibernateSession.createQuery("select distinct (transactionFolioNum) from TransactionDetails "
																+ "where transactionType ='SIP' and transactionId like '"+transactionDetails.getTransactionId()+"%' and fundId = :fundId and bseRegistrationNumber = :bseRegistrationNumber ");
						
						query.setParameter("fundId", transactionDetails.getFundId());
						query.setParameter("bseRegistrationNumber", transactionDetails.getBseRegistrationNumber());
						
						List<String >  folioNumList = query.list();
						
						for ( String fol : folioNumList)   {
							if ( null != fol)   {
								folioNum = fol;
								
							}
						}
						
						hibernateSession.getTransaction().commit();
						
						System.out.println(" inserting a row for transaction Id : "+sipDetail.getTransactionDetailId());
						hibernateSession.beginTransaction();
						
			        	TransactionDetails tempTransactionDetail  = new TransactionDetails(nextTransactionId, null,transactionDetails.getBseRegistrationNumber(),
			        			null, sipDetail.getCustomerId(),"SIP","NA","NA" ,"AUTODEBIT","BUY", "ADDITIONAL", transactionDetails.getTransactionAmount(),transactionDetails.getTransactionUnit(),
								"7", "AUTO DEBIT FOR BSE Reg Num : "+transactionDetails.getBseRegistrationNumber(),"0","N",transactionDetails.getFundId(), 
								null,null,frmtdDateForDB, frmtdDateForDB,"N",
								folioNum,null,"N"); 		
	
						hibernateSession.save(tempTransactionDetail);
	
						logger.debug("SipInstallmentGenerator class - execute method - customerId - "+sipDetail.getCustomerId()+" - and transactionType - SIP - inserted new row in TransactionDetails table with transactionId - "+nextTransactionId);
	
						hibernateSession.getTransaction().commit();
					}
		        }

			}

			System.out.println("SipInstallmentGenerator CLASS EXECUTION -------  END");
			
	 
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

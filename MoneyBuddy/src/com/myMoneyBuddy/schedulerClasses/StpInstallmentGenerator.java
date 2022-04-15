package com.myMoneyBuddy.schedulerClasses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.EntityClasses.StpDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class StpInstallmentGenerator implements org.quartz.Job{


	Logger logger = LogManager.getLogger(StpInstallmentGenerator.class);
	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
			
			System.out.println("StpInstallmentGenerator CLASS EXECUTION -------  START");
			
			hibernateSession.beginTransaction();
			
			Calendar cal = Calendar.getInstance();
			String todayDate = Integer.toString(cal.get(Calendar.DATE));
			//String todayDate = "10";
			
			System.out.println("todayDate : "+todayDate);
			
			Query query = hibernateSession.createQuery("from StpDetails where stpDate = :stpDate and stpCompletionStatus  in ('N','MAIL_SENT') ");

			query.setParameter("stpDate", todayDate);
			
			List<StpDetails> stpDetailsList = query.list();
			hibernateSession.getTransaction().commit();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String modifiedDate = dateFormat.format(date);
			
	        Date currentDate = dateFormat.parse(modifiedDate);
	        Date stpEndDate;
	        Date stpStartDate;

	        System.out.println("currentDate : " +currentDate);
			
	        String folioNum = null;
	        
			for (StpDetails stpDetail : stpDetailsList)  {
 
				folioNum = null;
				
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
		        	
		        	stpStartDate = dateFormat.parse(stpDetail.getStpStartDate());
					System.out.println("sipStartDate : " + stpStartDate);
					
					
					if (currentDate.compareTo(stpStartDate) >= 0) {
						
			        	hibernateSession.beginTransaction();
						
						query = hibernateSession.createQuery(" from TransactionDetails where transactionDetailId = :transactionDetailId ");
						query.setParameter("transactionDetailId", stpDetail.getTransactionDetailId());
						
						TransactionDetails transactionDetails = (TransactionDetails) query.uniqueResult();
						
						hibernateSession.getTransaction().commit();
						
						QueryProducts queryProducts = new QueryProducts();
						double curAmount = queryProducts.getCurrentAmtForFund(stpDetail.getCustomerId(), stpDetail.getWithdrawalFundId(), transactionDetails.getTransactionFolioNum());
						
						if ("MAIL_SENT".equals(stpDetail.getStpCompletionStatus()))   {
							if ( curAmount == 0.0 )   {
								// Cancel This STP
								// Send Mail to the user stating that the STP has been cancelled 
								
								hibernateSession.beginTransaction();
					        	query = hibernateSession.createQuery("update StpDetails set stpCompletionStatus='CANCELLED' where customerId= :customerId and transactionDetailId = :transactionDetailId ");
					        	query.setParameter("customerId", stpDetail.getCustomerId());
					        	query.setParameter("transactionDetailId", stpDetail.getTransactionDetailId());
					        	
					        	int updateResult = query.executeUpdate();
								System.out.println(updateResult + " rows updated in StpDetails table ");
								
								hibernateSession.getTransaction().commit();
								
							}
						}
						else {
											
							hibernateSession.beginTransaction();
				        	query = hibernateSession.createQuery("update StpDetails set stpCompletionStatus='N' where customerId= :customerId and transactionDetailId = :transactionDetailId ");
				        	query.setParameter("customerId", stpDetail.getCustomerId());
				        	query.setParameter("transactionDetailId", stpDetail.getTransactionDetailId());
				        	
				        	int updateResult = query.executeUpdate();
							System.out.println(updateResult + " rows updated in StpDetails table ");
							
							hibernateSession.getTransaction().commit();
						
				        	/*if ( curAmount <= Double.parseDouble(stpDetail.getStpAmount()))   {
				        		hibernateSession.beginTransaction();
					        	query = hibernateSession.createQuery("update StpDetails set stpCompletionStatus='MAIL_SENT' where customerId= :customerId and transactionDetailId = :transactionDetailId ");
					        	query.setParameter("customerId", stpDetail.getCustomerId());
					        	query.setParameter("transactionDetailId", stpDetail.getTransactionDetailId());
					        	
					        	updateResult = query.executeUpdate();
								System.out.println(updateResult + " rows updated in StpDetails table ");
								
								hibernateSession.getTransaction().commit();
				        		
				        		// Send a mail to the user , stating the withdrawal fund balance is low..
				        	}*/
				        	
							
							hibernateSession.beginTransaction();
							
							String nextTransactionId = "1";
							
							query = hibernateSession.createQuery("select max(transactionId) from TransactionDetails where transactionId like '"+transactionDetails.getTransactionId()+"%' ");
										
							String transactionId = query.uniqueResult().toString();
							
							hibernateSession.getTransaction().commit();
							
							hibernateSession.beginTransaction();
							
							
							query = hibernateSession.createQuery("select max(transactionDate) from TransactionDetails where  transactionId = :transactionId ");
							query.setParameter("transactionId", transactionId);
												
							String transactionDate = query.uniqueResult().toString().substring(0,10);
							
							hibernateSession.getTransaction().commit();
							
							SimpleDateFormat dateFrmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String frmtdDateForDB = dateFrmt.format(date);
							
							if ( frmtdDateForDB.substring(0,10).equals(transactionDate))   {
								nextTransactionId = transactionId;
							}
							else {
								if ( transactionId.split("-").length == 1 )
									nextTransactionId = transactionId+"-1";
								else 
									nextTransactionId = transactionId.split("-")[0]+"-"+(Integer.parseInt(transactionId.split("-")[1])+1);
									
							}
							
		
							
							hibernateSession.beginTransaction();
							
							query = hibernateSession.createQuery("select distinct (transactionFolioNum) from TransactionDetails "
																	+ "where transactionType ='STP' and transactionId like '"+transactionDetails.getTransactionId()+"%' and fundId = :fundId ");
							
							query.setParameter("fundId", transactionDetails.getFundId());
							
							List<String >  folioNumList = query.list();
							
							for ( String fol : folioNumList)   {
								if ( null != fol)   {
									folioNum = fol;
									
								}
							}
							
							hibernateSession.getTransaction().commit();
							
							System.out.println(" inserting a row for transaction Id : "+stpDetail.getTransactionDetailId());
							
							
							
							
							hibernateSession.beginTransaction();
							
				        	TransactionDetails tempTransactionDetail  = new TransactionDetails(nextTransactionId, null,stpDetail.getBseRegNum(),
				        			null, stpDetail.getCustomerId(),"STP",transactionDetails.getSelOption(), transactionDetails.getSelType() ,
				        			"NEW","SELL", "ADDITIONAL", stpDetail.getStpAmount(),"NA",
									"7", "AUTO WITHDRAWAL OF FUND ID : "+stpDetail.getWithdrawalFundId()+" FOR BSE Reg Num : "+stpDetail.getBseRegNum(),
									"0","N",stpDetail.getWithdrawalFundId(),null,null,frmtdDateForDB, frmtdDateForDB,"N",
									folioNum,null,"N"); 		
		
							hibernateSession.save(tempTransactionDetail);
							hibernateSession.getTransaction().commit();
							
							/*hibernateSession.beginTransaction();
												
							query = hibernateSession.createQuery("select transactionId from TransactionDetails where transactionId not like '%-%' "
									+ " order by transactionDetailId desc ");
							
							query.setMaxResults(1);
							
							nextTransactionId = Integer.toString(Integer.parseInt(query.uniqueResult().toString())+1);
							
							hibernateSession.getTransaction().commit();*/
							
							hibernateSession.beginTransaction();
							
				        	tempTransactionDetail  = new TransactionDetails(nextTransactionId, null,stpDetail.getBseRegNum(),
				        			null, stpDetail.getCustomerId(),"STP", transactionDetails.getSelOption(), transactionDetails.getSelType() ,
				        			"NEW","BUY", "ADDITIONAL", stpDetail.getStpAmount(),"NA",
									"7", "AUTO PURCHASE OF FUND ID : "+stpDetail.getPurchaseFundId()+" FOR BSE Reg Num : "+stpDetail.getBseRegNum(),
									"0","N",stpDetail.getPurchaseFundId(),null,null,frmtdDateForDB, frmtdDateForDB,"N",
									folioNum,null,"N"); 		
		
							hibernateSession.save(tempTransactionDetail);
							hibernateSession.getTransaction().commit();
							
							logger.debug("StpInstallmentGenerator class - execute method - customerId - "+stpDetail.getCustomerId()+" - and transactionType - STP - inserted 2 new rows in TransactionDetails table ");
						}
					}
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

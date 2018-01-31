package com.myMoneyBuddy.schedulerClasses;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class SipInstallmentGenerator implements org.quartz.Job{



	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		Session session = null;
		
		try {
			session = HibernateUtil.getSessionAnnotationFactory().openSession();
			
			session.beginTransaction();
			
			Calendar cal = Calendar.getInstance();
			String todayDate = Integer.toString(cal.get(Calendar.DATE));
			
			System.out.println("todayDate : "+todayDate);
			
			Query query = session.createQuery("from SipDetails where sipDate = :sipDate and sipCompletionStatus = :sipCompletionStatus and sipFormSubmission = :sipFormSubmission ");

			query.setParameter("sipDate", todayDate);
			query.setParameter("sipCompletionStatus", "N");
			query.setParameter("sipFormSubmission", "Y");
			
			List<SipDetails> sipDetailsList = query.list();
			//session.getTransaction().commit();
			
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
		        	//session.beginTransaction();
		        	query = session.createQuery("update SipDetails set sipCompletionStatus='Y' where customerId= :customerId and transactionDetailId = :transactionDetailId ");
		        	query.setParameter("customerId", sipDetail.getCustomerId());
		        	query.setParameter("transactionDetailId", sipDetail.getTransactionDetailId());
		        	
		        	int updateResult = query.executeUpdate();
					System.out.println(updateResult + " rows updated in SipDetails table ");
					
		        	session.getTransaction().commit();
	
		        } 
		        else {
		        	System.out.println("Trigger will be coming here soon .. ");
		        	// TODO : We have to trigger an SIP transaction here ... waiting for the clarity on how to do this ..
		        }

			}

			
			
	 
		}
		catch (Exception e) {	

			e.printStackTrace();

		} 
		finally {
			/*if(factory!=null)
			factory.close();*/
			//HibernateUtil.getSessionAnnotationFactory().close();
			session.close();
		}
	}

}

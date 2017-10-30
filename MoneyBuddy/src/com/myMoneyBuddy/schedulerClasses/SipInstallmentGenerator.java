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
import org.hibernate.cfg.AnnotationConfiguration;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFWriter;
import com.myMoneyBuddy.DAOClasses.Trading;
import com.myMoneyBuddy.EntityClasses.CustomerPortfolio;
import com.myMoneyBuddy.EntityClasses.Customers;
import com.myMoneyBuddy.EntityClasses.DbfDataDetails;
import com.myMoneyBuddy.EntityClasses.PaymentDetails;
import com.myMoneyBuddy.EntityClasses.ProductDetails;
import com.myMoneyBuddy.EntityClasses.SipDetails;
import com.myMoneyBuddy.EntityClasses.TransactionDetails;
import com.myMoneyBuddy.EntityClasses.Transactions;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

public class SipInstallmentGenerator implements org.quartz.Job{



	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		SessionFactory factory = null;
		Session session = null;
		
		try {
			factory = new AnnotationConfiguration()
					.configure()
					.addAnnotatedClass(SipDetails.class)
					.buildSessionFactory();
			session = factory.openSession();
			
			session.beginTransaction();
			
			Calendar cal = Calendar.getInstance();
			String todayDate = Integer.toString(cal.get(Calendar.DATE));
			
			System.out.println("todayDate : "+todayDate);
			
			Query query = session.createQuery("from SipDetails where sipDate = :sipDate and sipCompletionStatus = :sipCompletionStatus and sipFormSubmission = :sipFormSubmission ");

			query.setParameter("sipDate", todayDate);
			query.setParameter("sipCompletionStatus", "No");
			query.setParameter("sipFormSubmission", "Yes");
			
			List<SipDetails> sipDetailsList = query.list();
			session.getTransaction().commit();
			
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
		        	session.beginTransaction();
		        	query = session.createQuery("update SipDetails set sipCompletionStatus='Yes' where customerId= :customerId and transactionId = :transactionId ");
		        	query.setParameter("customerId", sipDetail.getCustomerId());
		        	query.setParameter("transactionId", sipDetail.getTransactionId());
		        	
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
	}

}

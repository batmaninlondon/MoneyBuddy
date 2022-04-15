package com.myMoneyBuddy.schedulerClasses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.myMoneyBuddy.DAOClasses.GenerateKycForm;
import com.myMoneyBuddy.Utils.HibernateUtil;
import com.myMoneyBuddy.Utils.SendMail;

public class SipAutoDebitMails implements org.quartz.Job{


	Logger logger = LogManager.getLogger(SipAutoDebitMails.class);
	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
			
			System.out.println("SipAutoDebitMails CLASS EXECUTION -------  START");
			
			hibernateSession.beginTransaction();
			
			Calendar cal = Calendar.getInstance();
			
			// This line is responsible for sending mails 1 day prior to actual debit date .. Can update the 1 to any number to chnage the gap of days
			cal.add(Calendar.DAY_OF_YEAR, 1);
			String tomorrowDate = Integer.toString(cal.get(Calendar.DATE));		    

			System.out.println("tomorrowDate : "+tomorrowDate);
			
			Query query = hibernateSession.createQuery("select distinct (t.transactionId),c.emailId, c.customerName, s.sipStartDate "
										+ " from SipDetails s, TransactionDetails t, Customers c "
										+ " where s.sipDate = :sipDate and  s.sipCompletionStatus = :sipCompletionStatus and s.sipFormSubmission = :sipFormSubmission "
										+ " and t.transactionDetailId=s.transactionDetailId and c.customerId = t.customerId ");

			query.setParameter("sipDate", tomorrowDate);
			query.setParameter("sipCompletionStatus", "N");
			query.setParameter("sipFormSubmission", "Y");
			
			/*List<String> transactionIdList = query.list();*/
			List<Object[]> transactionIdList = query.list();
			hibernateSession.getTransaction().commit();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = cal.getTime();
			String modifiedDate = dateFormat.format(date);
			
			
			System.out.println("transactionIdList size : "+transactionIdList.size());
			System.out.println("modifiedDate : "+modifiedDate);
	        Date currentDate = dateFormat.parse(modifiedDate);
	        
	        System.out.println("currentDate : " +currentDate);
	        
	        Properties configProperties = new Properties();
			String configPropFilePath = "../../../config/config.properties";

			configProperties.load(GenerateKycForm.class.getResourceAsStream(configPropFilePath));
			String mailLink = null;
			String subject = null;
			
			SendMail sendMail = new SendMail();
			mailLink = configProperties.getProperty("MAIL_SIP_AUTO_MAIL_LINK");
			System.out.println("mailLink is : "+mailLink);
			subject = configProperties.getProperty("MAIL_SIP_AUTO_MAIL_SUBJECT");
			
	        for ( int i = 0; i < transactionIdList.size() ;i++ ) {
	        	
	        	String sipStartDate = transactionIdList.get(i)[3].toString();
	        	
	        	if (modifiedDate.compareTo(sipStartDate) >= 0) {
				
					Double totalAmount = 0.0;
					String dataTable = "";
					String htmlTableStart = "<table style=\"border-collapse:collapse; text-align:center;width:100%\" >";
					String htmlTableEnd = "</table>";
					String htmlHeaderRowStart = "<tr style =\"background-color:#13b1cd; color:#ffffff;\">";
					String htmlHeaderRowEnd = "</tr>";
					String htmlTrStart = "<tr style =\"color:#555555;\">";
					String htmlTrEnd = "</tr>";
					String htmlTdStart = "<td style=\" border-color:#13b1cd; border-style:solid; border-width:thin; padding: 5px;\">";
					String htmlTdEnd = "</td>";
	
					dataTable += htmlTableStart;
					dataTable += htmlHeaderRowStart;
					dataTable += htmlTdStart + "Fund Name " + htmlTdEnd;
					dataTable += htmlTdStart + "Amount " + htmlTdEnd;
					dataTable += htmlTdStart + "Debit Date " + htmlTdEnd;
					dataTable += htmlHeaderRowEnd;
								
					
					hibernateSession.beginTransaction();
	
					query = hibernateSession.createQuery("select  p.schemeName, t.transactionAmount  "
									+ "from SipDetails s, TransactionDetails t, PrimaryFundDetails p "
									+ "where s.sipDate = :sipDate and  s.sipCompletionStatus = :sipCompletionStatus and s.sipFormSubmission = :sipFormSubmission "
									+ "and t.fundId=p.fundId and t.transactionDetailId=s.transactionDetailId  and t.transactionId = :transactionId");
					
					query.setParameter("sipDate", tomorrowDate);
					query.setParameter("sipCompletionStatus", "N");
					query.setParameter("sipFormSubmission", "Y");
					query.setParameter("transactionId", transactionIdList.get(i)[0].toString());
					
					List<Object[]> fundDetailsList = query.list();
					hibernateSession.getTransaction().commit();
					
					for ( int j = 0; j < fundDetailsList.size() ;j++ ) {
	
						dataTable += htmlTrStart;
						dataTable += htmlTdStart + fundDetailsList.get(j)[0].toString() + htmlTdEnd;
						dataTable += htmlTdStart + fundDetailsList.get(j)[1].toString() + htmlTdEnd;
						dataTable += htmlTdStart + modifiedDate + htmlTdEnd;
						dataTable += htmlTrEnd; 
						totalAmount += Double.parseDouble(fundDetailsList.get(j)[1].toString());
					}
					
					dataTable += htmlTrStart;
					dataTable += htmlTdStart + "<b>" + "Total" + "</b>" + htmlTdEnd;
					dataTable += htmlTdStart + "<b>" + totalAmount + "</b>" + htmlTdEnd;
					dataTable += htmlTdStart + "" + htmlTdEnd;
					dataTable += htmlTrEnd; 
	    		         		 
					dataTable += htmlTableEnd;
					
					sendMail.MailSending(transactionIdList.get(i)[1].toString(),subject,"SipAutoMail","SipAutoMail.txt",
							  mailLink,"",transactionIdList.get(i)[2].toString(),dataTable);

	        	}
			}

			System.out.println("SipAutoDebitMails CLASS EXECUTION -------  END");
			
	 
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

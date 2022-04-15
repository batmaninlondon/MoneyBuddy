package com.myMoneyBuddy.schedulerClasses;

import java.text.NumberFormat;
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

public class StpAutoDebitMails implements org.quartz.Job{


	Logger logger = LogManager.getLogger(StpAutoDebitMails.class);
	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		
		try {
			
			System.out.println("StpAutoDebitMails CLASS EXECUTION -------  START");
			
			hibernateSession.beginTransaction();
			
			Calendar cal = Calendar.getInstance();
			
			// This line is responsible for sending mails 1 day prior to actual debit date .. Can update the 1 to any number to chnage the gap of days
			cal.add(Calendar.DAY_OF_YEAR, 6);
			String tomorrowDate = Integer.toString(cal.get(Calendar.DATE));		    

			System.out.println("tomorrowDate : "+tomorrowDate);
			
			Query query = hibernateSession.createQuery("select distinct (t.transactionId),c.emailId, c.customerName, s.stpStartDate, "
										+ " s.withdrawalFundId,s.purchaseFundId "
										+ " from StpDetails s, TransactionDetails t, Customers c "
										+ " where s.stpDate = :stpDate and  s.stpCompletionStatus  in ('N','MAIL_SENT')  "
										+ " and t.transactionDetailId=s.transactionDetailId and c.customerId = t.customerId ");

			query.setParameter("stpDate", tomorrowDate);
			
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
			mailLink = configProperties.getProperty("MAIL_STP_AUTO_MAIL_LINK");
			System.out.println("mailLink is : "+mailLink);
			subject = configProperties.getProperty("MAIL_STP_AUTO_MAIL_SUBJECT");
			
	        for ( int i = 0; i < transactionIdList.size() ;i++ ) {
	        	
	        	String stpStartDate = transactionIdList.get(i)[3].toString();
	        	
	        	if (modifiedDate.compareTo(stpStartDate) >= 0) {
				
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
					/*dataTable += htmlTdStart + "Purchase Fund Name " + htmlTdEnd;*/
					dataTable += htmlTdStart + "Details " + htmlTdEnd;
					/*dataTable += htmlTdStart + "Debit Date " + htmlTdEnd;*/
					dataTable += htmlHeaderRowEnd;
								
					
					hibernateSession.beginTransaction();
	
					query = hibernateSession.createQuery("select t.transactionAmount ,"
									+ " ( select schemeName from PrimaryFundDetails where fundId = :withdrawalFundId ) ,  "
									+ " ( select schemeName from PrimaryFundDetails where fundId = :purchaseFundId ) "
									+ "from StpDetails s, TransactionDetails t "
									+ "where s.stpDate = :stpDate and  s.stpCompletionStatus  in ('N','MAIL_SENT') "
									+ " and t.transactionDetailId=s.transactionDetailId  and t.transactionId = :transactionId");
					
					query.setParameter("withdrawalFundId", transactionIdList.get(i)[4].toString());
					query.setParameter("purchaseFundId", transactionIdList.get(i)[5].toString());
					query.setParameter("stpDate", tomorrowDate);
					query.setParameter("transactionId", transactionIdList.get(i)[0].toString());
					
					List<Object[]> fundDetailsList = query.list();
					hibernateSession.getTransaction().commit();
					
					NumberFormat myFormat = NumberFormat.getIntegerInstance();
			        myFormat.setGroupingUsed(true);
			        
					for ( int j = 0; j < fundDetailsList.size() ;j++ ) {
	
						if (!"Total".equalsIgnoreCase(fundDetailsList.get(j)[1].toString()))  {
														
						dataTable += htmlTrStart;
						dataTable += htmlTdStart 
								+ fundDetailsList.get(j)[1].toString() +"<p class=\"text-center\"><b>&#9660;</b></p>"+fundDetailsList.get(j)[2].toString()
								+ htmlTdEnd;
						//dataTable += htmlTdStart + stpCart.getPurchaseFundSchemeName() + htmlTdEnd;
						dataTable += htmlTdStart 
									+ "Amount: Rs." + 	myFormat.format((int) Double.parseDouble(fundDetailsList.get(j)[0].toString()))
									+ "<br/>Debit Date: " + modifiedDate 
									+ htmlTdEnd;
						dataTable += htmlTrEnd; 
						
						}
						
						/*dataTable += htmlTrStart;
						dataTable += htmlTdStart + fundDetailsList.get(j)[1].toString() + htmlTdEnd;
						dataTable += htmlTdStart + fundDetailsList.get(j)[2].toString() + htmlTdEnd;
						dataTable += htmlTdStart + fundDetailsList.get(j)[0].toString() + htmlTdEnd;
						dataTable += htmlTdStart + modifiedDate + htmlTdEnd;
						dataTable += htmlTrEnd; 
						totalAmount += Double.parseDouble(fundDetailsList.get(j)[0].toString());*/
					}
					
					/*dataTable += htmlTrStart;
					dataTable += htmlTdStart + "" + htmlTdEnd;
					dataTable += htmlTdStart + "Total" + htmlTdEnd;
					dataTable += htmlTdStart + totalAmount + htmlTdEnd;
					dataTable += htmlTdStart + "" + htmlTdEnd;
					dataTable += htmlTrEnd; */
	    		         		 
					dataTable += htmlTableEnd;
					
					sendMail.MailSending(transactionIdList.get(i)[1].toString(),subject,"StpAutoMail","StpAutoMail.txt",
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

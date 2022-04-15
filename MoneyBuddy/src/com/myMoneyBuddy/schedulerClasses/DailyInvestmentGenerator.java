package com.myMoneyBuddy.schedulerClasses;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.EntityClasses.DailyInvestments;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class DailyInvestmentGenerator implements org.quartz.Job{


	Logger logger = LogManager.getLogger(DailyInvestmentGenerator.class);
	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		DailyInvestments tempDailyInvestments;
		
		try {
			
			System.out.println("DailyInvestmentGenerator CLASS EXECUTION -------  START");
			
			hibernateSession.beginTransaction();	   
			   
			Calendar cal = Calendar.getInstance();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			cal.add(Calendar.DATE, -1);
			String yesterdayDate = dateFormat.format(cal.getTime());
			
			System.out.println("yesterdayDate : "+yesterdayDate);
			
			Query query = hibernateSession.createQuery("select distinct(customerId) from Customers");
			
			List<String> customersList = query.list();
			hibernateSession.getTransaction().commit();
			
			QueryProducts queryProducts = new QueryProducts();
			
			String totalCurrentAmount = "";
			for (String customer : customersList)  {
 
				System.out.println("Customer Id is : "+customer);
				totalCurrentAmount = queryProducts.getTotalCurrentAmount(customer);
				
				hibernateSession.beginTransaction();
				
				tempDailyInvestments  = new DailyInvestments(customer,totalCurrentAmount,yesterdayDate); 		

				hibernateSession.save(tempDailyInvestments);

				hibernateSession.getTransaction().commit();

			}

			System.out.println("DailyInvestmentGenerator CLASS EXECUTION -------  END");
			
	 
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

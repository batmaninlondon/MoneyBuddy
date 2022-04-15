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
import com.myMoneyBuddy.EntityClasses.CustomersAqb;
import com.myMoneyBuddy.Utils.HibernateUtil;

public class AqbCalculator implements org.quartz.Job{


	Logger logger = LogManager.getLogger(AqbCalculator.class);
	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		Session hibernateSession = HibernateUtil.getSessionAnnotationFactory().openSession();
		CustomersAqb tempCustomersAqb;
		
		try {
			
			System.out.println("AqbCalculator CLASS EXECUTION -------  START");
			
			hibernateSession.beginTransaction();	   
			   
			Calendar cal = Calendar.getInstance();
			DateFormat dateFormat = new SimpleDateFormat("MM");
			cal.add(Calendar.DATE, -1);
			String yesterdayMonth = dateFormat.format(cal.getTime());
			dateFormat = new SimpleDateFormat("yyyy");
			String yesterdayYear = dateFormat.format(cal.getTime());
			
			System.out.println("yesterdayMonth : "+yesterdayMonth);
			
			Query query = hibernateSession.createQuery("select distinct(customerId) from Customers");
			
			List<String> customersList = query.list();
			hibernateSession.getTransaction().commit();
			
			QueryProducts queryProducts = new QueryProducts();
			
			int numOfTotalDays = 0;
			String startDate = "";
			String endDate="";
			String quarterOfYear = "";
			
			switch (yesterdayMonth)   {
			
				case "03":
					numOfTotalDays = 90;
					startDate=yesterdayYear+"-01-01";
					endDate = yesterdayYear+"-03-31";
					quarterOfYear="1-"+yesterdayYear;
					break;
				case "06":
					numOfTotalDays = 91;
					startDate=yesterdayYear+"-04-01";
					endDate = yesterdayYear+"-06-30";
					quarterOfYear="2-"+yesterdayYear;
					break;
				case "09":
					numOfTotalDays = 92;
					startDate=yesterdayYear+"-07-01";
					endDate = yesterdayYear+"-09-30";
					quarterOfYear="3-"+yesterdayYear;
					break;
				case "12":
					numOfTotalDays = 92;
					startDate=yesterdayYear+"-10-01";
					endDate = yesterdayYear+"-12-31";
					quarterOfYear="4-"+yesterdayYear;
					break;
					
			}
			
			Double totalQuaterlyInvestment = 0.0;
			Double aqb = 0.0;
			Double quaterlyFee = 0.0;
			for (String customer : customersList)  {
				
				aqb = 0.0;
				quaterlyFee = 0.0;
				
				hibernateSession.beginTransaction();
				
				query = hibernateSession.createQuery("select sum(endOfDayInvestment) from DailyInvestments  "
						+ "where customerId='"+customer+"' and investmentDate > '"+startDate+"' and investmentDate < '"+endDate+"'");
				
				Object result = query.uniqueResult();
				hibernateSession.getTransaction().commit();
				
				if (result != null) {
					totalQuaterlyInvestment = Double.parseDouble(result.toString());
					aqb = totalQuaterlyInvestment/numOfTotalDays;
					quaterlyFee = (aqb*0.25)/100;
					
				}
				
				hibernateSession.beginTransaction();
				
				tempCustomersAqb  = new CustomersAqb(customer,String.format("%.2f",aqb),String.format("%.2f",quaterlyFee),quarterOfYear); 		

				hibernateSession.save(tempCustomersAqb);

				hibernateSession.getTransaction().commit();

			}

			System.out.println("AqbCalculator CLASS EXECUTION -------  END");
			
	 
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

package com.myMoneyBuddy.schedulerClasses;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import com.myMoneyBuddy.DAOClasses.Trading;

public class PaymentStatusCheck implements org.quartz.Job{

	Logger logger = Logger.getLogger(PaymentStatusCheck.class);

	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		try {
			
			System.out.println("PaymentStatusCheck CLASS EXECUTION -------  START");
			
			Trading trading = new Trading();
			trading.checkPaymentStatus();
			
			System.out.println("PaymentStatusCheck CLASS EXECUTION -------  END");

		} 
	 
   	catch (Exception e) {	

			e.printStackTrace();

		} 


	}

}

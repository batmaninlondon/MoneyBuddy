package com.myMoneyBuddy.schedulerClasses;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.myMoneyBuddy.DAOClasses.Trading;

public class PaymentLinkGenerator implements org.quartz.Job{

	Logger logger = Logger.getLogger(PaymentLinkGenerator.class);

	public void execute(JobExecutionContext cntxt) throws JobExecutionException {

		try {
			
			logger.debug("PaymentLinkGenerator class - execute method - start");
			System.out.println("PaymentLinkGenerator CLASS EXECUTION -------  START");
			
			Trading trading = new Trading();
			
			trading.paymentLink();
			
			System.out.println("PaymentLinkGenerator CLASS EXECUTION -------  END");
			logger.debug("PaymentLinkGenerator class - execute method - end");
		} 
	 
   	catch (Exception e) {	

			e.printStackTrace();

		} 


	}

}

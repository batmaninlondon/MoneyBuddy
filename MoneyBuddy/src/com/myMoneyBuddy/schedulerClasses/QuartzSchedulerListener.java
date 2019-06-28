package com.myMoneyBuddy.schedulerClasses;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * This class is used for executing quartz job 
 * using CronTrigger(Quartz 2.1.5).
 * @author codesjava
 */
public class QuartzSchedulerListener implements ServletContextListener {
 
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed is called.");
	}
 
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		try
		
		{
			
			// Scheduler to generate the automatic order for SIP
			
			JobDetail sipInstallmentGeneratorJob = JobBuilder.newJob(SipInstallmentGenerator.class)
					.withIdentity("SipInstallmentGeneratorJob", "Group").build();
			
			// This Trigger will work at 9 am (London time) everyday
			
			Trigger sipInstallmentGeneratorTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("SipInstallmentGeneratorTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 00 09 * * ?")) 
					.build();
			
			// Scheduler to generate the automatic order for STP
			
			JobDetail stpInstallmentGeneratorJob = JobBuilder.newJob(StpInstallmentGenerator.class)
					.withIdentity("StpInstallmentGeneratorJob", "Group").build();
			
			// This Trigger will work at 9:15 am (London time) everyday
			
			Trigger stpInstallmentGeneratorTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("StpInstallmentGeneratorTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 15 09 * * ?")) 
					.build();
			
			
			// Scheduler for payment staus check to display the order in Admin, for which the payment has been received
			
			JobDetail paymentStatusCheckJob = JobBuilder.newJob(PaymentStatusCheck.class)
					.withIdentity("PaymentStatusCheckJob", "Group").build();
			
			// This Trigger will work at 9:30 am (London time) everyday
			
			Trigger paymentStatusCheckTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("PaymentStatusCheckTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 30 09 * * ?")) 
					.build();
			
			// Scheduler for daily aqb calculation
			
			JobDetail dailyInvestmentGeneratorJob = JobBuilder.newJob(DailyInvestmentGenerator.class)
					.withIdentity("ReadSpreadSheetJob", "Group").build();
						
			// This Trigger will work at 10 am (London time) everyday
						
			Trigger dailyInvestmentGeneratorTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("DailyInvestmentGeneratorTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 00 10 * * ?")) 
					.build();
						
			// Scheduler for calculating all customers aqb for quarter 1 ( Jan-Mar)
			
			JobDetail aqbCalculatorFirstQuarterJob = JobBuilder.newJob(AqbCalculator.class)
					.withIdentity("AqbCalculatorFirstQuarterJob", "Group").build();
			
			// This Trigger will work at 11 am (London time) on every 1st Apr
			
			Trigger aqbCalculatorFirstQuarterTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("AqbCalculatorFirstQuarterTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 00 11 1 4 ?")) 
					.build();
			
			// Scheduler for calculating all customers aqb for quarter 2 ( Apr-June)
			
			JobDetail aqbCalculatorSecondQuarterJob = JobBuilder.newJob(AqbCalculator.class)
					.withIdentity("AqbCalculatorSecondQuarterJob", "Group").build();
			
			// This Trigger will work at 11 am (London time) on every 1st July
			
			Trigger aqbCalculatorSecondQuarterTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("AqbCalculatorSecondQuarterTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 00 11 1 7 ?")) 
					.build();
			
			// Scheduler for calculating all customers aqb for quarter 3 ( July-Sep)
			
			JobDetail aqbCalculatorThirdQuarterJob = JobBuilder.newJob(AqbCalculator.class)
					.withIdentity("AqbCalculatorThirdQuarterJob", "Group").build();
			
			// This Trigger will work at 11 am (London time) on every 1st Oct
			
			Trigger aqbCalculatorThirdQuarterTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("AqbCalculatorThirdQuarterTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 00 11 1 4 ?")) 
					.build();
			
			// Scheduler for calculating all customers aqb for quarter 4 ( Oct-Dec)
			
			JobDetail aqbCalculatorFourthQuarterJob = JobBuilder.newJob(AqbCalculator.class)
					.withIdentity("AqbCalculatorFourthQuarterJob", "Group").build();
			
			// This Trigger will work at 11 am (London time) on every 1st Jan
			
			Trigger aqbCalculatorFourthQuarterTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("AqbCalculatorFourthQuarterTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 00 11 1 4 ?")) 
					.build();
			
			//Execute the job.
    		Scheduler scheduler = 
    			new StdSchedulerFactory().getScheduler();
        	scheduler.start();
        	
        	// Execute sip installment job to generate the automatic order for SIP
        	scheduler.scheduleJob(sipInstallmentGeneratorJob, sipInstallmentGeneratorTrigger);
        	
        	// Execute stp installment job to generate the automatic order for STP
        	scheduler.scheduleJob(stpInstallmentGeneratorJob, stpInstallmentGeneratorTrigger);
        	
        	// Execute payment staus check to display the order in Admin, for which the payment has been received
        	scheduler.scheduleJob(paymentStatusCheckJob, paymentStatusCheckTrigger);
        	
        	// Execute daily aqb calculation
        	scheduler.scheduleJob(dailyInvestmentGeneratorJob, dailyInvestmentGeneratorTrigger);
        	
        	// Execute Scheduler for calculating all customers aqb for quarter 1 ( Jan-Mar)
        	scheduler.scheduleJob(aqbCalculatorFirstQuarterJob, aqbCalculatorFirstQuarterTrigger);
        	
        	// Execute Scheduler for calculating all customers aqb for quarter 2 ( Apr-June)
        	scheduler.scheduleJob(aqbCalculatorSecondQuarterJob, aqbCalculatorSecondQuarterTrigger);
        	
        	// Execute Scheduler for calculating all customers aqb for quarter 3 ( July-Sep)
        	scheduler.scheduleJob(aqbCalculatorThirdQuarterJob, aqbCalculatorThirdQuarterTrigger);
        	
        	// Execute Scheduler for calculating all customers aqb for quarter 4 ( Oct-Dec)
        	scheduler.scheduleJob(aqbCalculatorFourthQuarterJob, aqbCalculatorFourthQuarterTrigger);
        	
    	}
		catch(Exception e){
    		e.printStackTrace();
    	}    		
	}
}



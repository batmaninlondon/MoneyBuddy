package com.myMoneyBuddy.schedulerClasses;


import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.myMoneyBuddy.schedulerClasses.ReadSpreadSheet;

public class MoneyBuddyScheduler {

	private static Scheduler scheduler;

	static
	{
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
		} catch (SchedulerException e) {
			System.out.println("Exception in static block of QuartzTesting class, Exiting the program " +e);
			System.exit(-1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
		
			scheduler.start();
			
			JobDetail readSpreadSheetJob = JobBuilder.newJob(ReadSpreadSheet.class)
					.withIdentity("ReadSpreadSheetJob", "Group").build();
			
			// This Trigger will work at 9 pm (21 hours) everyday
			
			Trigger readSpreadSheetTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("ReadSpreadSheetTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 09 12 * * ?")) 
					.build();
			
	
			scheduler.scheduleJob(readSpreadSheetJob, readSpreadSheetTrigger);
			
			
			JobDetail paymentStatusCheckJob = JobBuilder.newJob(PaymentStatusCheck.class)
					.withIdentity("PaymentStatusCheckJob", "Group").build();
			
			// This Trigger will work at 3 pm (15 hours) everyday
			
			Trigger paymentStatusCheckTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("PaymentStatusCheckTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 10 12 * * ?")) 
					.build();
			
	
			scheduler.scheduleJob(paymentStatusCheckJob, paymentStatusCheckTrigger);
			
			
			/*JobDetail sipInstallmentGeneratorJob = JobBuilder.newJob(SipInstallmentGenerator.class)
					.withIdentity("SipInstallmentGeneratorJob", "Group").build();
			
			// This Trigger will work at 3 pm (15 hours) everyday
			
			Trigger sipInstallmentGeneratorTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("SipInstallmentGeneratorTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 25 13 * * ?")) 
					.build();
			
	
			scheduler.scheduleJob(sipInstallmentGeneratorJob, sipInstallmentGeneratorTrigger);*/
			
		} catch (SchedulerException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

	}
}


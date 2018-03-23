package com.myMoneyBuddy.schedulerClasses;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class DbfFileGenerateScheduler {

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
			
			JobDetail dbfFileGeneratorJob = JobBuilder.newJob(DbfFileGenerator.class)
					.withIdentity("DbfFileGeneratorJob", "Group").build();
			
			// This Trigger will work at 3 pm (15 hours) everyday
			
			Trigger dbfFileGeneratorTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("DbfFileGeneratorTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0 15 * * ?")) 
					.build();
			
			JobDetail sipInstallmentGeneratorJob = JobBuilder.newJob(SipInstallmentGenerator.class)
					.withIdentity("SipInstallmentGeneratorJob", "Group").build();
			
			// This Trigger will work at 10 am (10 hours) everyday
			
			Trigger sipInstallmentGeneratorTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("SipInstallmentGeneratorTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0 10 * * ?"))
					.build();
			
			JobDetail karvyCustomerDbfFileGeneratorJob = JobBuilder.newJob(KarvyCustomerDbfFileGenerator.class)
					.withIdentity("KarvyCustomerDbfFileGeneratorJob", "Group").build();
			
			// This Trigger will work at 10 am (10 hours) everyday
			
			Trigger karvyCustomerDbfFileGeneratorTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("KarvyCustomerDbfFileGeneratorTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 54 22 * * ?"))
					.build();
			
			JobDetail karvyTransactionDbfFileGeneratorJob = JobBuilder.newJob(KarvyTransactionDbfFileGenerator.class)
					.withIdentity("KarvyTransactionDbfFileGeneratorJob", "Group").build();
			
			// This Trigger will work at 10 am (10 hours) everyday
			
			Trigger karvyTransactionDbfFileGeneratorTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("KarvyTransactionDbfFileGeneratorTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 54 22 * * ?"))
					.build();
			
			JobDetail camsTransactionDbfFileGeneratorJob = JobBuilder.newJob(CamsTransactionDbfFileGenerator.class)
					.withIdentity("CamsTransactionDbfFileGeneratorJob", "Group").build();
			
			// This Trigger will work at 10 am (10 hours) everyday
			
			Trigger camsTransactionDbfFileGeneratorTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("CamsTransactionDbfFileGeneratorTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 14 0 * * ?"))
					.build();
			
			JobDetail transactionNavValuesUpdaterJob = JobBuilder.newJob(TransactionNavValuesUpdater.class)
					.withIdentity("TransactionNavValuesUpdater", "Group").build();
			
			// This Trigger will work at 10 am (10 hours) everyday
			
			Trigger transactionNavValuesUpdaterTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("TransactionNavValuesUpdaterTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 24 11 * * ?"))
					.build();
	
			scheduler.scheduleJob(dbfFileGeneratorJob, dbfFileGeneratorTrigger);
			scheduler.scheduleJob(sipInstallmentGeneratorJob, sipInstallmentGeneratorTrigger);
			scheduler.scheduleJob(karvyCustomerDbfFileGeneratorJob, karvyCustomerDbfFileGeneratorTrigger);
			scheduler.scheduleJob(karvyTransactionDbfFileGeneratorJob, karvyTransactionDbfFileGeneratorTrigger);
			scheduler.scheduleJob(camsTransactionDbfFileGeneratorJob, camsTransactionDbfFileGeneratorTrigger);
			scheduler.scheduleJob(transactionNavValuesUpdaterJob, transactionNavValuesUpdaterTrigger);
			
		} catch (SchedulerException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

	}
}

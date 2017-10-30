package com.myMoneyBuddy.schedulerClasses;


import java.text.ParseException;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

public class DbfFileGenerateScheduler {

	//private static SchedulerFactory schedFact = new StdSchedulerFactory();

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
	
			scheduler.scheduleJob(dbfFileGeneratorJob, dbfFileGeneratorTrigger);
			scheduler.scheduleJob(sipInstallmentGeneratorJob, sipInstallmentGeneratorTrigger);
			
		} catch (SchedulerException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

	}
}

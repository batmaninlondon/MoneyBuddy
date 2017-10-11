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
			
			JobDetail job = JobBuilder.newJob(DbfFileGenerator.class)
					.withIdentity("DbfFileGeneratorJob", "Group").build();
			
			Trigger trigger = TriggerBuilder
					.newTrigger()
					.withIdentity("DbfFileGeneratorTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0 15 * * ?"))
					.build();
	
			scheduler.scheduleJob(job, trigger);
			
		} catch (SchedulerException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

	}
}

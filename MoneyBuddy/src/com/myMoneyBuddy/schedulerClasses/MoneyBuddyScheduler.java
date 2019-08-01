package com.myMoneyBuddy.schedulerClasses;


import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

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
			
			JobDetail computeOldPortfolioJob = JobBuilder.newJob(ComputeOldPortfolio.class)
					.withIdentity("ComputeOldPortfolioJob", "Group").build();
			
			// This Trigger will work at 9 pm (21 hours) everyday
			
			Trigger computeOldPortfolioTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("ComputeOldPortfolioTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 43 15 * * ?")) 
					.build();
			
	
			scheduler.scheduleJob(computeOldPortfolioJob, computeOldPortfolioTrigger);
			
			
			/*JobDetail dailyInvestmentGeneratorJob = JobBuilder.newJob(DailyInvestmentGenerator.class)
					.withIdentity("ReadSpreadSheetJob", "Group").build();
			
			// This Trigger will work at 9 pm (21 hours) everyday
			
			Trigger dailyInvestmentGeneratorTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("DailyInvestmentGeneratorTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 54 12 * * ?")) 
					.build();
			
			scheduler.scheduleJob(dailyInvestmentGeneratorJob, dailyInvestmentGeneratorTrigger);*/
			
			/*JobDetail aqbCalculatorJob = JobBuilder.newJob(AqbCalculator.class)
					.withIdentity("AqbCalculatorJob", "Group").build();
			
			// This Trigger will work at 9 pm (21 hours) everyday
			
			Trigger aqbCalculatorTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("AqbCalculatorTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 56 13 28 6 ?")) 
					.build();
			
			scheduler.scheduleJob(aqbCalculatorJob, aqbCalculatorTrigger);*/
			
						
			/*JobDetail paymentStatusCheckJob = JobBuilder.newJob(PaymentStatusCheck.class)
					.withIdentity("PaymentStatusCheckJob", "Group").build();
			
			// This Trigger will work at 3 pm (15 hours) everyday
			
			Trigger paymentStatusCheckTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("PaymentStatusCheckTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 13 12 * * ?")) 
					.build();
			
	
			scheduler.scheduleJob(paymentStatusCheckJob, paymentStatusCheckTrigger);*/
			
			
			/*JobDetail sipInstallmentGeneratorJob = JobBuilder.newJob(SipInstallmentGenerator.class)
					.withIdentity("SipInstallmentGeneratorJob", "Group").build();
			
			// This Trigger will work at 3 pm (15 hours) everyday
			
			Trigger sipInstallmentGeneratorTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("SipInstallmentGeneratorTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 25 13 * * ?")) 
					.build();
			
	
			scheduler.scheduleJob(sipInstallmentGeneratorJob, sipInstallmentGeneratorTrigger);*/
			
			
			/*JobDetail stpInstallmentGeneratorJob = JobBuilder.newJob(StpInstallmentGenerator.class)
					.withIdentity("StpInstallmentGeneratorJob", "Group").build();
			
			// This Trigger will work at 3 pm (15 hours) everyday
			
			Trigger stpInstallmentGeneratorTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("StpInstallmentGeneratorTrigger", "Group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 32 13 * * ?")) 
					.build();
			
	
			scheduler.scheduleJob(stpInstallmentGeneratorJob, stpInstallmentGeneratorTrigger);*/
			
		} catch (SchedulerException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

	}
}


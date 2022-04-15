/**
 *
 * @author ADMIN
 */

package com.myMoneyBuddy.GAT;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.myMoneyBuddy.DAOClasses.QueryPrimaryFundDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

public class PredictedValueCalculation {
	
	Logger logger = LogManager.getLogger(PredictedValueCalculation.class);
	
	public HashMap<Integer,Double> predictedSipOfOneFundList(double sip, String fundId) throws MoneyBuddyException {

		try {
			logger.debug("PredictedValueCalculation class - predictedSipOfOneFundList method - start");
			
			HashMap<Integer,Double> predictedValueList = new HashMap<Integer,Double>();
			double sipInvestmentReturn = 0.0;

			double predictedValue;
			QueryPrimaryFundDetails queryPrimaryFundDetails = new QueryPrimaryFundDetails();
			double interestRate;

			/*interestRate = queryPrimaryFundDetails.getInterestRateOfOneFund(fundId);*/
			interestRate = 10.0;
			
			System.out.println("interestRate before deviding 100 : "+interestRate);
			interestRate = interestRate /100;
			
			System.out.println("interestRate after deviding 100 : "+interestRate);
			
			double monthlyInterestRate =  Math.pow((1+interestRate), (1.0/12)); 
			monthlyInterestRate = monthlyInterestRate-1.0;
			
			System.out.println("monthlyInterestRate before rounding off : "+monthlyInterestRate);
			monthlyInterestRate = Math.round( monthlyInterestRate * 100.0 ) / 100.0;
			System.out.println("monthlyInterestRate after rounding off : "+monthlyInterestRate);
			
			int years=1;
			double duration = (years*12);
			duration = 	Math.pow((1+monthlyInterestRate),(duration-1));
			duration = duration/monthlyInterestRate;

			duration = Math.round( duration * 100.0 ) / 100.0;
			System.out.println("duration after rounding off : "+duration);
			
			sipInvestmentReturn = sip *  (1+monthlyInterestRate)  *  duration;
			
			predictedValue = sipInvestmentReturn ;
			System.out.println("predictedValue of 1 year before rounding off : "+predictedValue);
			predictedValue = Math.round( predictedValue * 100.0 ) / 100.0;
			System.out.println("predictedValue of 1 year after rounding off : "+predictedValue);

			predictedValueList.put(1,predictedValue);
			
			years=3;
			
			duration = (years*12);
			duration = 	Math.pow((1+monthlyInterestRate),(duration-1));
			duration = duration/monthlyInterestRate;

			duration = Math.round( duration * 100.0 ) / 100.0;
			System.out.println("duration after rounding off : "+duration);
			
			sipInvestmentReturn = sip *  (1+monthlyInterestRate)  *  duration;
			predictedValue = sipInvestmentReturn ;
			predictedValue = Math.round( predictedValue * 100.0 ) / 100.0;

			predictedValueList.put(3,predictedValue);
			
			years=5;
			
			duration = (years*12);
			duration = 	Math.pow((1+monthlyInterestRate),(duration-1));
			duration = duration/monthlyInterestRate;

			duration = Math.round( duration * 100.0 ) / 100.0;
			System.out.println("duration after rounding off : "+duration);
			
			sipInvestmentReturn = sip *  (1+monthlyInterestRate)  *  duration;
			predictedValue = sipInvestmentReturn ;
			predictedValue = Math.round( predictedValue * 100.0 ) / 100.0;

			predictedValueList.put(5,predictedValue);
			
			logger.debug("PredictedValueCalculation class - predictedSipOfOneFundList method - end");
			
			return predictedValueList;
		} catch (NumberFormatException e) {
			logger.error("PredictedValueCalculation class - predictedSipAmount method - Caught NumberFormatException");
			e.printStackTrace();

    	    throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.error("PredictedValueCalculation class - predictedSipAmount method - Caught Exception");
			e.printStackTrace();

    	    throw new MoneyBuddyException(e.getMessage(),e);
		}
	
	}

}

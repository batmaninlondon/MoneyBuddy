/**
 *
 * @author ADMIN
 */

package com.myMoneyBuddy.GAT;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.event.PreDeleteEventListener;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
import com.myMoneyBuddy.EntityClasses.ProductDetails;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

public class PredictedValueCalculation implements SessionAware {
	
	Logger logger = Logger.getLogger(PredictedValueCalculation.class);
	private Map<String, Object> sessionMap;

	public double predictedAmount(double upfrontInvestment, String riskCategory, double years,String planName) throws MoneyBuddyException {

			try {
				logger.debug("PredictedValueCalculation class : predictedAmount method : start");
				
				double upfrontInvestmentReturn = 0.0;
				
				double predictedValue;
				QueryProducts queryProduct = new QueryProducts();
				double interestRate;

				interestRate = queryProduct.getInterestRates(planName,riskCategory);

				upfrontInvestmentReturn = upfrontInvestment * Math.pow( (1.0 + (interestRate/100)), years );
				
				predictedValue = upfrontInvestmentReturn ;
				predictedValue = Math.round( predictedValue * 100.0 ) / 100.0;

				logger.debug("PredictedValueCalculation class : predictedAmount method : end");
				
				return predictedValue;
			} catch (NumberFormatException e) {
				logger.debug("PredictedValueCalculation class : predictedAmount method : Caught Exception");
				e.printStackTrace();
				throw new MoneyBuddyException(e.getMessage(),e);
			}
			catch (Exception e ) {
				logger.debug("PredictedValueCalculation class : predictedAmount method : Caught Exception");
				e.printStackTrace();
				throw new MoneyBuddyException(e.getMessage(),e);
			}
		
	}
	
	public HashMap<Integer,Double> predictedSipAmountList(double sip, String riskCategory,String planName) throws MoneyBuddyException {

		try {
			logger.debug("PredictedValueCalculation class : predictedSipAmount method : start");
			
			HashMap<Integer,Double> predictedValueList = new HashMap<Integer,Double>();
			double sipInvestmentReturn = 0.0;

			double predictedValue;
			QueryProducts queryProduct = new QueryProducts();
			double interestRate;

			interestRate = queryProduct.getInterestRates(planName,riskCategory);
			System.out.println("interestRate before deviding 100 : "+interestRate);
			interestRate = interestRate /100;
			
			System.out.println("interestRate after deviding 100 : "+interestRate);
			
			double monthlyInterestRate =  Math.pow((1+interestRate), (1.0/12)); 
			monthlyInterestRate = monthlyInterestRate-1.0;
			
			System.out.println("monthlyInterestRate before rounding off : "+monthlyInterestRate);
			monthlyInterestRate = Math.round( monthlyInterestRate * 100.0 ) / 100.0;
			System.out.println("monthlyInterestRate after rounding off : "+monthlyInterestRate);
			//sipInvestmentReturn = sip *  (1+monthlyInterestRate)  *  ((Math.pow((1+monthlyInterestRate),(years*12 - 1)))/monthlyInterestRate);
			
			int years=1;
			double duration = (years*12);
			//System.out.println("duration 1 : "+duration);
			duration = 	Math.pow((1+monthlyInterestRate),(duration-1));
			//duration = duration -1;
			//System.out.println("duration 2 : "+duration);
			duration = duration/monthlyInterestRate;

			//System.out.println("duration before rounding off : "+duration);
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
			//System.out.println("duration 1 : "+duration);
			duration = 	Math.pow((1+monthlyInterestRate),(duration-1));
			//duration = duration -1;
			//System.out.println("duration 2 : "+duration);
			duration = duration/monthlyInterestRate;

			//System.out.println("duration before rounding off : "+duration);
			duration = Math.round( duration * 100.0 ) / 100.0;
			System.out.println("duration after rounding off : "+duration);
			
			sipInvestmentReturn = sip *  (1+monthlyInterestRate)  *  duration;
			predictedValue = sipInvestmentReturn ;
			predictedValue = Math.round( predictedValue * 100.0 ) / 100.0;

			predictedValueList.put(3,predictedValue);
			
			years=5;
			
			duration = (years*12);
			//System.out.println("duration 1 : "+duration);
			duration = 	Math.pow((1+monthlyInterestRate),(duration-1));
			//duration = duration -1;
			//System.out.println("duration 2 : "+duration);
			duration = duration/monthlyInterestRate;

			//System.out.println("duration before rounding off : "+duration);
			duration = Math.round( duration * 100.0 ) / 100.0;
			System.out.println("duration after rounding off : "+duration);
			
			sipInvestmentReturn = sip *  (1+monthlyInterestRate)  *  duration;
			predictedValue = sipInvestmentReturn ;
			predictedValue = Math.round( predictedValue * 100.0 ) / 100.0;

			predictedValueList.put(5,predictedValue);
			
			logger.debug("PredictedValueCalculation class : predictedSipAmount method : end");
			
			return predictedValueList;
		} catch (NumberFormatException e) {
			logger.debug("PredictedValueCalculation class : predictedSipAmount method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("PredictedValueCalculation class : predictedSipAmount method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
	
	}
	
	
	public HashMap<Integer,Double> predictedSipOfOneFundList(double sip, String fundId) throws MoneyBuddyException {

		try {
			logger.debug("PredictedValueCalculation class : predictedSipAmount method : start");
			
			HashMap<Integer,Double> predictedValueList = new HashMap<Integer,Double>();
			double sipInvestmentReturn = 0.0;

			double predictedValue;
			QueryProducts queryProduct = new QueryProducts();
			double interestRate;

			interestRate = queryProduct.getInterestRateOfOneFund(fundId);
			System.out.println("interestRate before deviding 100 : "+interestRate);
			interestRate = interestRate /100;
			
			System.out.println("interestRate after deviding 100 : "+interestRate);
			
			double monthlyInterestRate =  Math.pow((1+interestRate), (1.0/12)); 
			monthlyInterestRate = monthlyInterestRate-1.0;
			
			System.out.println("monthlyInterestRate before rounding off : "+monthlyInterestRate);
			monthlyInterestRate = Math.round( monthlyInterestRate * 100.0 ) / 100.0;
			System.out.println("monthlyInterestRate after rounding off : "+monthlyInterestRate);
			//sipInvestmentReturn = sip *  (1+monthlyInterestRate)  *  ((Math.pow((1+monthlyInterestRate),(years*12 - 1)))/monthlyInterestRate);
			
			int years=1;
			double duration = (years*12);
			//System.out.println("duration 1 : "+duration);
			duration = 	Math.pow((1+monthlyInterestRate),(duration-1));
			//duration = duration -1;
			//System.out.println("duration 2 : "+duration);
			duration = duration/monthlyInterestRate;

			//System.out.println("duration before rounding off : "+duration);
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
			//System.out.println("duration 1 : "+duration);
			duration = 	Math.pow((1+monthlyInterestRate),(duration-1));
			//duration = duration -1;
			//System.out.println("duration 2 : "+duration);
			duration = duration/monthlyInterestRate;

			//System.out.println("duration before rounding off : "+duration);
			duration = Math.round( duration * 100.0 ) / 100.0;
			System.out.println("duration after rounding off : "+duration);
			
			sipInvestmentReturn = sip *  (1+monthlyInterestRate)  *  duration;
			predictedValue = sipInvestmentReturn ;
			predictedValue = Math.round( predictedValue * 100.0 ) / 100.0;

			predictedValueList.put(3,predictedValue);
			
			years=5;
			
			duration = (years*12);
			//System.out.println("duration 1 : "+duration);
			duration = 	Math.pow((1+monthlyInterestRate),(duration-1));
			//duration = duration -1;
			//System.out.println("duration 2 : "+duration);
			duration = duration/monthlyInterestRate;

			//System.out.println("duration before rounding off : "+duration);
			duration = Math.round( duration * 100.0 ) / 100.0;
			System.out.println("duration after rounding off : "+duration);
			
			sipInvestmentReturn = sip *  (1+monthlyInterestRate)  *  duration;
			predictedValue = sipInvestmentReturn ;
			predictedValue = Math.round( predictedValue * 100.0 ) / 100.0;

			predictedValueList.put(5,predictedValue);
			
			logger.debug("PredictedValueCalculation class : predictedSipAmount method : end");
			
			return predictedValueList;
		} catch (NumberFormatException e) {
			logger.debug("PredictedValueCalculation class : predictedSipAmount method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("PredictedValueCalculation class : predictedSipAmount method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
	
	}
	
	/*public HashMap<Integer,Double>  predictedAmountList( double sip,String riskCategory,String planName) throws MoneyBuddyException {

		try {
			logger.debug("PredictedValueCalculation class : predictedAmountList method : start");
			
			double sipReturn = 0.0;
			int years = 1;
			HashMap<Integer,Double> predictedValueList = new HashMap<Integer,Double>();

			sipReturn = sip*12*years;
			predictedValueList.put(1, sipReturn);
			
			years =3;
			sipReturn = sip*12*years;
			predictedValueList.put(3, sipReturn);
			
			years =5;
			sipReturn = sip*12*years;
			predictedValueList.put(5, sipReturn);

			logger.debug("PredictedValueCalculation class : predictedAmountList method : end");
			
			return predictedValueList;
		} catch (NumberFormatException e) {
			logger.debug("PredictedValueCalculation class : predictedAmountList method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
		catch (Exception e ) {
			logger.debug("PredictedValueCalculation class : predictedAmountList method : Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
	
}*/
	
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
    public Map<String, Object> getSession() {
		return sessionMap;
	}

}

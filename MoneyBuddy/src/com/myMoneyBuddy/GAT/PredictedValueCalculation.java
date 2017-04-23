/**
 *
 * @author ADMIN
 */

package com.myMoneyBuddy.GAT;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.event.PreDeleteEventListener;

import com.myMoneyBuddy.DAOClasses.QueryProducts;
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
	
	public HashMap<Integer,Double>  predictedAmountList( double sip,String riskCategory,String planName) throws MoneyBuddyException {

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
	
}
	
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
    public Map<String, Object> getSession() {
		return sessionMap;
	}

}

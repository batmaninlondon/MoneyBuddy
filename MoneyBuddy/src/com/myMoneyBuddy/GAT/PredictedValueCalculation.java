/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.GAT;

import com.myMoneyBuddy.queryClasses.QueryFund;

/**
 *
 * @author ADMIN
 */
public class PredictedValueCalculation {
    public static void main(String args[])  {
        System.out.println(" Hi there 1 ");

        double amount = predictedAmount(1000.00,500,"3",7,"wealthPlan");
        System.out.println(" amount : "+amount);
    }

    public static double predictedAmount(double upfrontInvestment, double sip,String riskCategory, double years,String plan) {

        System.out.println(" Hi there 1 ");
        double upfrontInvestmentReturn = 0.0;
        double sipReturn = 0.0;
        double predictedValue;
        QueryFund queryFund = new QueryFund();
        double interestRate;
        if ("wealthPlan".equals(plan)) {
            interestRate = queryFund.getWealthPlanInterestRates(riskCategory);
        }
        else {
            interestRate = queryFund.getSaveTaxPlanInterestRates(riskCategory);
        }
        System.out.println(" Calculated intrest rate is : "+interestRate);
        upfrontInvestmentReturn = upfrontInvestment * Math.pow( (1.0 + (interestRate/100)), years );
        sipReturn = sip*12*years;
        predictedValue = upfrontInvestmentReturn + sipReturn;
        System.out.println(" upfrontInvestmentReturn after "+years+" years : "+upfrontInvestmentReturn);
        System.out.println(" sipReturn after "+years+" years : "+sipReturn);
        System.out.println(" predictedValue after "+years+" years : "+predictedValue);
        predictedValue = Math.round( predictedValue * 100.0 ) / 100.0;
        return predictedValue;
    }

}

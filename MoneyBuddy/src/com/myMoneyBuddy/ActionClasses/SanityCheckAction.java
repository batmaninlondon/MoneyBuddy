/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.GAT.PredictedValueCalculation;
import com.opensymphony.xwork2.ActionSupport;
import java.awt.Choice;

/**
 *
 * @author ADMIN
 */
public class SanityCheckAction extends ActionSupport {

    private String answer1 ;
    private String answer2 ;
    private String answer3 ;
    private String answer4 ;
    private String answer5 ;
    private String answer6 ;
    private String answer7 ;
    private String riskCategory ;
    private String upfrontInvestment ;
    private String sip ;
    private String years ;
    private String predictedValue;
    private String plan;

    private String suggestedRiskCategory;
    double predictedSuggestedValue = 0.0;
    
    @Override
    public String execute() {
        System.out.println(" hi there from SanitycheckAction 1 ");
        System.out.println("answer1 : "+getAnswer1());
        System.out.println("answer2 : "+getAnswer2());
        System.out.println("answer3 : "+getAnswer3());
        System.out.println("answer4 : "+getAnswer4());
        System.out.println("answer5 : "+getAnswer5());
        System.out.println("answer6 : "+getAnswer6());
        System.out.println("answer7 : "+getAnswer7());
        System.out.println("riskCategory : "+getRiskCategory());
        System.out.println("predictedValue : "+getPredictedValue());
        

        suggestedRiskCategory = getAnswer1();

        if (getRiskCategory().equals(getSuggestedRiskCategory()))   {
            return "CorrectChoice";
        }
 
        PredictedValueCalculation calculatedSuggestedValue = new PredictedValueCalculation();
        if ("wealthPlan".equals(getPlan()))  {
            predictedSuggestedValue = calculatedSuggestedValue.predictedAmount(Double.parseDouble(getUpfrontInvestment()), Double.parseDouble(getSip()) ,getSuggestedRiskCategory(), Double.parseDouble(getYears()),getPlan());
        }
        else {
            predictedSuggestedValue = calculatedSuggestedValue.predictedAmount(Double.parseDouble(getUpfrontInvestment()), Double.parseDouble(getSip()) ,getSuggestedRiskCategory(), Double.parseDouble(getYears()),getPlan());
        }
        

        System.out.println(" Calculated predictedSuggestedValue is : "+predictedSuggestedValue);

        System.out.println("suggestedRiskCategory : "+getSuggestedRiskCategory());

            return SUCCESS;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public String getAnswer6() {
        return answer6;
    }

    public void setAnswer6(String answer6) {
        this.answer6 = answer6;
    }

    public String getAnswer7() {
        return answer7;
    }

    public void setAnswer7(String answer7) {
        this.answer7 = answer7;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    public String getSip() {
        return sip;
    }

    public void setSip(String sip) {
        this.sip = sip;
    }

    public String getUpfrontInvestment() {
        return upfrontInvestment;
    }

    public void setUpfrontInvestment(String upfrontInvestment) {
        this.upfrontInvestment = upfrontInvestment;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public double getPredictedSuggestedValue() {
        return predictedSuggestedValue;
    }

    public void setPredictedSuggestedValue(double predictedSuggestedValue) {
        this.predictedSuggestedValue = predictedSuggestedValue;
    }

    public String getPredictedValue() {
        return predictedValue;
    }

    public void setPredictedValue(String predictedValue) {
        this.predictedValue = predictedValue;
    }



    public String getSuggestedRiskCategory() {
        return suggestedRiskCategory;
    }

    public void setSuggestedRiskCategory(String suggestedRiskCategory) {
        this.suggestedRiskCategory = suggestedRiskCategory;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    
}

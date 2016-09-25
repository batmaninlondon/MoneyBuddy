/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.GAT.PredictedValueCalculation;
import com.myMoneyBuddy.queryClasses.QueryUser;
import com.myMoneyBuddy.queryClasses.UpdateCurrentLoginTimestamp;
import com.myMoneyBuddy.queryClasses.UpdateLastLoginTimestamp;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator.Failure;
import java.text.DecimalFormat;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
/**
 *
 * @author Savita Wadhwani
 */
public class EstimateAction extends ActionSupport{

    private String upfrontInvestment;
    private String sip;
    private String years;
    private String riskCategory;
    private String plan;

    String predictedValue;
    String regexDecimal = "(\\d+(?:\\.\\d+)?)";
    Pattern patternDecimal = Pattern.compile(regexDecimal);

    public void validate() {
        if ( StringUtils.isEmpty(getUpfrontInvestment()) )
            addFieldError("upfrontInvestment","value of upfrontInvestment can't be blank");
        else if(!patternDecimal.matcher(upfrontInvestment).matches())
            addFieldError("upfrontInvestment","Please enter a valid amount.");
        System.out.println(" Calling EstimateAction validate() .");
    }
    public String execute() {

        System.out.println(" Calling EstimateAction execute() ");
        System.out.println(" Value of upfrontInvestment is : "+getUpfrontInvestment());
        System.out.println(" Value of sip is : "+getSip());
        System.out.println(" Value of years is : "+getYears());
        System.out.println(" Value of risk category is : "+getRiskCategory());
        System.out.println(" Value of plan is : "+getPlan());

        
        PredictedValueCalculation calculatedValue = new PredictedValueCalculation();
        predictedValue = Double.toString(calculatedValue.predictedAmount(Double.parseDouble(getUpfrontInvestment()), Double.parseDouble(getSip()) ,getRiskCategory(), Double.parseDouble(getYears()),getPlan()));
        
        System.out.println(" Calculated predictedValue is : "+predictedValue);

        upfrontInvestment = Double.toString(Math.round( Double.parseDouble(upfrontInvestment) * 100.0 ) / 100.0);
        sip = Double.toString(Math.round( Double.parseDouble(sip) * 100.0 ) / 100.0);
        
        return SUCCESS;


    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }


    public String getPredictedValue() {
        return predictedValue;
        
    }

    public void setPredictedValue(String predictedValue) {
        this.predictedValue = predictedValue;
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

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }



}

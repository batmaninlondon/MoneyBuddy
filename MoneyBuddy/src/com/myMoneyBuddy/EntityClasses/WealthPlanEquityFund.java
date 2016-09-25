/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.EntityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Savita Wadhwani
 */
@Entity
@Table (name="WEALTH_PLAN_EQUITY_FUND")
public class WealthPlanEquityFund {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="ID")
    private String id;

    @Column(name="RISK_CATEGORY")
    private String riskCategory;

    @Column(name="EQUITY_FUND_NAME")
    private String equityFundName;

    @Column(name="EQUITY_FUND_INTEREST_RATE")
    private String equityFundInterestRate;

    @Column(name="EQUITY_FUND_PERCENTAGE")
    private String equityFundPercentage;

    public WealthPlanEquityFund() {

    }

    public WealthPlanEquityFund(String riskCategory, String equityFundName,String equityFundInterestRate,String equityFundPercentage)  {

        this.riskCategory = riskCategory;
        this.equityFundName = equityFundName;
        this.equityFundInterestRate = equityFundInterestRate;
        this.equityFundPercentage = equityFundPercentage;
    }

    public String getEquityFundInterestRate() {
        return equityFundInterestRate;
    }

    public void setEquityFundInterestRate(String equityFundInterestRate) {
        this.equityFundInterestRate = equityFundInterestRate;
    }

    public String getEquityFundName() {
        return equityFundName;
    }

    public void setEquityFundName(String equityFundName) {
        this.equityFundName = equityFundName;
    }

    public String getEquityFundPercentage() {
        return equityFundPercentage;
    }

    public void setEquityFundPercentage(String equityFundPercentage) {
        this.equityFundPercentage = equityFundPercentage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }





    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final WealthPlanEquityFund other = (WealthPlanEquityFund) obj;
        if ((this.riskCategory == null) ? (other.riskCategory != null) : !this.riskCategory.equals(other.riskCategory)) {
            return false;
        }
        if ((this.equityFundName == null) ? (other.equityFundName != null) : !this.equityFundName.equals(other.equityFundName)) {
            return false;
        }
        if ((this.equityFundInterestRate == null) ? (other.equityFundInterestRate != null) : !this.equityFundInterestRate.equals(other.equityFundInterestRate)) {
            return false;
        }
        if ((this.equityFundPercentage == null) ? (other.equityFundPercentage != null) : !this.equityFundPercentage.equals(other.equityFundPercentage)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.riskCategory != null ? this.riskCategory.hashCode() : 0);
        hash = 83 * hash + (this.equityFundName != null ? this.equityFundName.hashCode() : 0);
        hash = 83 * hash + (this.equityFundInterestRate != null ? this.equityFundInterestRate.hashCode() : 0);
        hash = 83 * hash + (this.equityFundPercentage != null ? this.equityFundPercentage.hashCode() : 0);
        return hash;
    }

}
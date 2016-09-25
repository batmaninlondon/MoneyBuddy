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
@Table (name="WEALTH_PLAN_CASH_FUND")
public class WealthPlanCashFund {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="ID")
    private String id;

    @Column(name="RISK_CATEGORY")
    private String riskCategory;

    @Column(name="CASH_FUND_NAME")
    private String cashFundName;

    @Column(name="CASH_FUND_INTEREST_RATE")
    private String cashFundInterestRate;

    @Column(name="CASH_FUND_PERCENTAGE")
    private String cashFundPercentage;

    public WealthPlanCashFund() {

    }

    public WealthPlanCashFund(String riskCategory, String cashFundName,String cashFundInterestRate,String cashPercentage)  {

        this.riskCategory = riskCategory;
        this.cashFundName = cashFundName;
        this.cashFundInterestRate = cashFundInterestRate;
        this.cashFundPercentage = cashFundPercentage;
    }

    public String getCashFundInterestRate() {
        return cashFundInterestRate;
    }

    public void setCashFundInterestRate(String cashFundInterestRate) {
        this.cashFundInterestRate = cashFundInterestRate;
    }

    public String getCashFundName() {
        return cashFundName;
    }

    public void setCashFundName(String cashFundName) {
        this.cashFundName = cashFundName;
    }

    public String getCashFundPercentage() {
        return cashFundPercentage;
    }

    public void setCashFundPercentage(String cashPercentage) {
        this.cashFundPercentage = cashFundPercentage;
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

        final WealthPlanCashFund other = (WealthPlanCashFund) obj;
        if ((this.riskCategory == null) ? (other.riskCategory != null) : !this.riskCategory.equals(other.riskCategory)) {
            return false;
        }
        if ((this.cashFundName == null) ? (other.cashFundName != null) : !this.cashFundName.equals(other.cashFundName)) {
            return false;
        }
        if ((this.cashFundInterestRate == null) ? (other.cashFundInterestRate != null) : !this.cashFundInterestRate.equals(other.cashFundInterestRate)) {
            return false;
        }
        if ((this.cashFundPercentage == null) ? (other.cashFundPercentage != null) : !this.cashFundPercentage.equals(other.cashFundPercentage)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.riskCategory != null ? this.riskCategory.hashCode() : 0);
        hash = 83 * hash + (this.cashFundName != null ? this.cashFundName.hashCode() : 0);
        hash = 83 * hash + (this.cashFundInterestRate != null ? this.cashFundInterestRate.hashCode() : 0);
        hash = 83 * hash + (this.cashFundPercentage != null ? this.cashFundPercentage.hashCode() : 0);
        return hash;
    }

}
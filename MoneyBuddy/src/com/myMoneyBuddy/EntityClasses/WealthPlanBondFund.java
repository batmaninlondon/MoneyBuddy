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
@Table (name="WEALTH_PLAN_BOND_FUND")
public class WealthPlanBondFund {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="ID")
    private String id;

    @Column(name="RISK_CATEGORY")
    private String riskCategory;

    @Column(name="BOND_FUND_NAME")
    private String bondFundName;

    @Column(name="BOND_FUND_INTEREST_RATE")
    private String bondFundInterestRate;

    @Column(name="BOND_FUND_PERCENTAGE")
    private String bondFundPercentage;

    public WealthPlanBondFund() {

    }

    public WealthPlanBondFund(String riskCategory, String bondFundName,String bondFundInterestRate,String bondFundPercentage)  {

        this.riskCategory = riskCategory;
        this.bondFundName = bondFundName;
        this.bondFundInterestRate = bondFundInterestRate;
        this.bondFundPercentage = bondFundPercentage;
    }

    public String getBondFundInterestRate() {
        return bondFundInterestRate;
    }

    public void setBondFundInterestRate(String bondFundInterestRate) {
        this.bondFundInterestRate = bondFundInterestRate;
    }

    public String getBondFundName() {
        return bondFundName;
    }

    public void setBondFundName(String bondFundName) {
        this.bondFundName = bondFundName;
    }

    public String getBondFundPercentage() {
        return bondFundPercentage;
    }

    public void setBondFundPercentage(String bondFundPercentage) {
        this.bondFundPercentage = bondFundPercentage;
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

        final WealthPlanBondFund other = (WealthPlanBondFund) obj;
        if ((this.riskCategory == null) ? (other.riskCategory != null) : !this.riskCategory.equals(other.riskCategory)) {
            return false;
        }
        if ((this.bondFundName == null) ? (other.bondFundName != null) : !this.bondFundName.equals(other.bondFundName)) {
            return false;
        }
        if ((this.bondFundInterestRate == null) ? (other.bondFundInterestRate != null) : !this.bondFundInterestRate.equals(other.bondFundInterestRate)) {
            return false;
        }
        if ((this.bondFundPercentage == null) ? (other.bondFundPercentage != null) : !this.bondFundPercentage.equals(other.bondFundPercentage)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.riskCategory != null ? this.riskCategory.hashCode() : 0);
        hash = 83 * hash + (this.bondFundName != null ? this.bondFundName.hashCode() : 0);
        hash = 83 * hash + (this.bondFundInterestRate != null ? this.bondFundInterestRate.hashCode() : 0);
        hash = 83 * hash + (this.bondFundPercentage != null ? this.bondFundPercentage.hashCode() : 0);
        return hash;
    }

}
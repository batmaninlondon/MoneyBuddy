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
@Table (name="PRODUCT_DETAILS")
public class ProductDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="PRODUCT_ID")
    private String productId;

    @Column(name="RISK_CATEGORY")
    private String riskCategory;

    @Column(name="PLAN_NAME")
    private String planName;
    
    @Column(name="PRODUCT_TYPE")
    private String productType;
    
    @Column(name="PRODUCT_NAME")
    private String productName;
    
    @Column(name="PRODUCT_DESCRIPTION")
    private String productDescription;

    @Column(name="INTEREST_RATE")
    private String interestRate;

    @Column(name="PERCENTAGE")
    private String percentage;

    public ProductDetails() {

    }

    public ProductDetails(String riskCategory, String planName,
			String productType, String productName, String productDescription,
			String interestRate, String percentage) {
		super();
		this.riskCategory = riskCategory;
		this.planName = planName;
		this.productType = productType;
		this.productName = productName;
		this.productDescription = productDescription;
		this.interestRate = interestRate;
		this.percentage = percentage;
	}


	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getRiskCategory() {
		return riskCategory;
	}

	public void setRiskCategory(String riskCategory) {
		this.riskCategory = riskCategory;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final ProductDetails other = (ProductDetails) obj;
        if ((this.productId == null) ? (other.productId != null) : !this.productId.equals(other.productId)) {
            return false;
        }
        if ((this.riskCategory == null) ? (other.riskCategory != null) : !this.riskCategory.equals(other.riskCategory)) {
            return false;
        }
        if ((this.planName == null) ? (other.planName != null) : !this.planName.equals(other.planName)) {
            return false;
        }
        if ((this.productType == null) ? (other.productType != null) : !this.productType.equals(other.productType)) {
            return false;
        }
        if ((this.productName == null) ? (other.productName != null) : !this.productName.equals(other.productName)) {
            return false;
        }
        if ((this.interestRate == null) ? (other.interestRate != null) : !this.interestRate.equals(other.interestRate)) {
            return false;
        }
        if ((this.productDescription == null) ? (other.productDescription != null) : !this.productDescription.equals(other.productDescription)) {
            return false;
        }
        if ((this.percentage == null) ? (other.percentage != null) : !this.percentage.equals(other.percentage)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.productId != null ? this.productId.hashCode() : 0);
        hash = 83 * hash + (this.riskCategory != null ? this.riskCategory.hashCode() : 0);
        hash = 83 * hash + (this.planName != null ? this.planName.hashCode() : 0);
        hash = 83 * hash + (this.productType != null ? this.productType.hashCode() : 0);
        hash = 83 * hash + (this.productName != null ? this.productName.hashCode() : 0);
        hash = 83 * hash + (this.interestRate != null ? this.interestRate.hashCode() : 0);
        hash = 83 * hash + (this.productDescription != null ? this.productDescription.hashCode() : 0);
        hash = 83 * hash + (this.percentage != null ? this.percentage.hashCode() : 0);
        return hash;
    }

}
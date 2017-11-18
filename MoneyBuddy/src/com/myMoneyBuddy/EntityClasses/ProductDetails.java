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
    
    @Column(name="AMC_CODE")
    private String amcCode;
    
    @Column(name="RTA")
    private String rta;
    
    @Column(name="KARVY_SCHEME_CODE")
    private String karvySchemeCode;
    
    @Column(name="CAMS_SCHEME_CODE")
    private String camsSchemeCode;

    public ProductDetails() {

    }

    public ProductDetails(String riskCategory, String planName,
			String productType, String productName, String productDescription,
			String interestRate, String percentage, String amcCode, String rta, 
			String karvySchemeCode, String camsSchemeCode) {
		super();
		this.riskCategory = riskCategory;
		this.planName = planName;
		this.productType = productType;
		this.productName = productName;
		this.productDescription = productDescription;
		this.interestRate = interestRate;
		this.percentage = percentage;
		this.amcCode = amcCode;
		this.rta = rta;
		this.karvySchemeCode = karvySchemeCode;
		this.camsSchemeCode = camsSchemeCode;
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

	public String getAmcCode() {
		return amcCode;
	}

	public void setAmcCode(String amcCode) {
		this.amcCode = amcCode;
	}

	public String getRta() {
		return rta;
	}

	public void setRta(String rta) {
		this.rta = rta;
	}

	public String getKarvySchemeCode() {
		return karvySchemeCode;
	}

	public void setKarvySchemeCode(String karvySchemeCode) {
		this.karvySchemeCode = karvySchemeCode;
	}

	public String getCamsSchemeCode() {
		return camsSchemeCode;
	}

	public void setCamsSchemeCode(String camsSchemeCode) {
		this.camsSchemeCode = camsSchemeCode;
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
        if ((this.amcCode == null) ? (other.amcCode != null) : !this.amcCode.equals(other.amcCode)) {
            return false;
        }
        if ((this.rta == null) ? (other.rta != null) : !this.rta.equals(other.rta)) {
            return false;
        }
        if ((this.karvySchemeCode == null) ? (other.karvySchemeCode != null) : !this.karvySchemeCode.equals(other.karvySchemeCode)) {
            return false;
        }
        if ((this.camsSchemeCode == null) ? (other.camsSchemeCode != null) : !this.camsSchemeCode.equals(other.camsSchemeCode)) {
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
        hash = 83 * hash + (this.amcCode != null ? this.amcCode.hashCode() : 0);
        hash = 83 * hash + (this.rta != null ? this.rta.hashCode() : 0);
        hash = 83 * hash + (this.karvySchemeCode != null ? this.karvySchemeCode.hashCode() : 0);
        hash = 83 * hash + (this.camsSchemeCode != null ? this.camsSchemeCode.hashCode() : 0);
        return hash;
    }

}
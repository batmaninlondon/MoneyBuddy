/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.EntityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="FOLIO_DETAILS")
public class FolioDetails {


	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="FOLIO_DETAILS_ID")
    private String folioDetailsId;
	
    @Column (name="FOLIO_NUM")
    private String folioNum;

    @Column(name="CUSTOMER_ID")
    private String customerId;
    
    @Column(name="PAN_CARD")
    private String panCard;
    
    @Column(name="FUND_ID")
    private String fundId;
    
    @Column(name="AMC_CODE")
    private String amcCode;
    
    @Column(name="GENERATED_BY")
    private String generatedBy;

    public FolioDetails() {

    }

    public FolioDetails(String folioNum, String customerId, String panCard, String fundId, String amcCode, String generatedBy) {
		super();
		this.folioNum = folioNum;
		this.customerId = customerId;
		this.panCard = panCard;
		this.fundId = fundId;
		this.amcCode = amcCode;
		this.generatedBy = generatedBy;
	}

	public String getFolioNum() {
		return folioNum;
	}

	public void setFolioNum(String folioNum) {
		this.folioNum = folioNum;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFolioDetailsId() {
		return folioDetailsId;
	}

	public void setFolioDetailsId(String folioDetailsId) {
		this.folioDetailsId = folioDetailsId;
	}

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getAmcCode() {
		return amcCode;
	}

	public void setAmcCode(String amcCode) {
		this.amcCode = amcCode;
	}

	public String getGeneratedBy() {
		return generatedBy;
	}

	public void setGeneratedBy(String generatedBy) {
		this.generatedBy = generatedBy;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FolioDetails other = (FolioDetails) obj;
        if ((this.folioDetailsId == null) ? (other.folioDetailsId != null) : !this.folioDetailsId.equals(other.folioDetailsId)) {
            return false;
        }
        if ((this.folioNum == null) ? (other.folioNum != null) : !this.folioNum.equals(other.folioNum)) {
            return false;
        }
        if ((this.customerId == null) ? (other.customerId != null) : !this.customerId.equals(other.customerId)) {
            return false;
        }
        if ((this.fundId == null) ? (other.fundId != null) : !this.fundId.equals(other.fundId)) {
            return false;
        }
        if ((this.panCard == null) ? (other.panCard != null) : !this.panCard.equals(other.panCard)) {
            return false;
        }
        if ((this.amcCode == null) ? (other.amcCode != null) : !this.amcCode.equals(other.amcCode)) {
            return false;
        }
        if ((this.generatedBy == null) ? (other.generatedBy != null) : !this.generatedBy.equals(other.generatedBy)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.folioDetailsId != null ? this.folioDetailsId.hashCode() : 0);
        hash = 83 * hash + (this.folioNum != null ? this.folioNum.hashCode() : 0);
        hash = 83 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 83 * hash + (this.fundId != null ? this.fundId.hashCode() : 0);
        hash = 83 * hash + (this.panCard != null ? this.panCard.hashCode() : 0);
        hash = 83 * hash + (this.amcCode != null ? this.amcCode.hashCode() : 0);
        hash = 83 * hash + (this.generatedBy != null ? this.generatedBy.hashCode() : 0);
        return hash;
    }



}
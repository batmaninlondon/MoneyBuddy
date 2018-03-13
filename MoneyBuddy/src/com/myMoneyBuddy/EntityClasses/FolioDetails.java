/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.EntityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Savita Wadhwani
 */
@Entity
@Table (name="FOLIO_DETAILS")
public class FolioDetails {


    @Id
    @Column (name="FOLIO_NUM")
    private String folioNum;

    @Column(name="CUSTOMER_ID")
    private String customerId;
    
    @Column(name="AMC_CODE")
    private String amcCode;
    
    @Column(name="PAN_CARD")
    private String panCard;

    public FolioDetails() {

    }

    public FolioDetails(String folioNum, String customerId, String amcCode, String panCard) {
		super();
		this.folioNum = folioNum;
		this.customerId = customerId;
		this.amcCode = amcCode;
		this.panCard = panCard;
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

	public String getAmcCode() {
		return amcCode;
	}

	public void setAmcCode(String amcCode) {
		this.amcCode = amcCode;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
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
        if ((this.folioNum == null) ? (other.folioNum != null) : !this.folioNum.equals(other.folioNum)) {
            return false;
        }
        if ((this.customerId == null) ? (other.customerId != null) : !this.customerId.equals(other.customerId)) {
            return false;
        }
        if ((this.amcCode == null) ? (other.amcCode != null) : !this.amcCode.equals(other.amcCode)) {
            return false;
        }
        if ((this.panCard == null) ? (other.panCard != null) : !this.panCard.equals(other.panCard)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.folioNum != null ? this.folioNum.hashCode() : 0);
        hash = 83 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 83 * hash + (this.amcCode != null ? this.amcCode.hashCode() : 0);
        hash = 83 * hash + (this.panCard != null ? this.panCard.hashCode() : 0);
        return hash;
    }



}
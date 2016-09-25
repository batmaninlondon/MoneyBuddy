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
@Table (name="KYC_STATUS")
public class KycStatus {


    @Id
    @Column (name="PAN_CARD")
    private String panCard;

    @Column(name="STATUS")
    private String status;

    public KycStatus() {

    }

    public KycStatus(String panCard, String status)  {

        this.panCard = panCard;
        this.status = status;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KycStatus other = (KycStatus) obj;
        if ((this.panCard == null) ? (other.panCard != null) : !this.panCard.equals(other.panCard)) {
            return false;
        }
        if ((this.status == null) ? (other.status != null) : !this.status.equals(other.status)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.panCard != null ? this.panCard.hashCode() : 0);
        hash = 83 * hash + (this.status != null ? this.status.hashCode() : 0);
        return hash;
    }



}
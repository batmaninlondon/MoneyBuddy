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
@Table (name="TRANSACTIONS")
public class Transactions {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="TRANSACTION_ID")
    private String transactionId;

    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Column(name="TRANSACTION_AMOUNT")
    private String transactionAmount;

    @Column(name="TRANSACTION_TYPE")
    private String transactionType;

    @Column(name="TRANSACTION_STATUS")
    private String transactionStatus;
    
    @Column(name="TRANSACTION_DATE")
    private String transactionDate;
    
    @Column(name="UPDATE_DATE")
    private String updateDate;

    public Transactions() {

    }

    public Transactions(String customerId, String transactionAmount,
			String transactionType, String transactionStatus,
			String transactionDate, String updateDate) {
		super();
		this.customerId = customerId;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.transactionStatus = transactionStatus;
		this.transactionDate = transactionDate;
		this.updateDate = updateDate;
	}


	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Transactions other = (Transactions) obj;
        if ((this.transactionId == null) ? (other.transactionId != null) : !this.transactionId.equals(other.transactionId)) {
            return false;
        }
        if ((this.customerId == null) ? (other.customerId != null) : !this.customerId.equals(other.customerId)) {
            return false;
        }
        if ((this.transactionAmount == null) ? (other.transactionAmount != null) : !this.transactionAmount.equals(other.transactionAmount)) {
            return false;
        }
        if ((this.transactionType == null) ? (other.transactionType != null) : !this.transactionType.equals(other.transactionType)) {
            return false;
        }
        if ((this.transactionStatus == null) ? (other.transactionStatus != null) : !this.transactionStatus.equals(other.transactionStatus)) {
            return false;
        }
        if ((this.transactionDate == null) ? (other.transactionDate != null) : !this.transactionDate.equals(other.transactionDate)) {
            return false;
        }
        if ((this.updateDate == null) ? (other.updateDate != null) : !this.updateDate.equals(other.updateDate)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.transactionId != null ? this.transactionId.hashCode() : 0);
        hash = 83 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 83 * hash + (this.transactionAmount != null ? this.transactionAmount.hashCode() : 0);
        hash = 83 * hash + (this.transactionType != null ? this.transactionType.hashCode() : 0);
        hash = 83 * hash + (this.transactionStatus != null ? this.transactionStatus.hashCode() : 0);
        hash = 83 * hash + (this.transactionDate != null ? this.transactionDate.hashCode() : 0);
        hash = 83 * hash + (this.updateDate != null ? this.updateDate.hashCode() : 0);
        return hash;
    }

}
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
 * @author ADMIN
 */
@Entity
@Table (name ="DBF_DATA_DETAILS")
public class DbfDataDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="DBF_DATA_ID")
    private String dbfDataId;
    
    @Column(name="TRANSACTION_DETAIL_ID")
    private String transactionDetailId;
    
    @Column (name="CUSTOMER_ID")
    private String customerId;

    @Column (name="DBF_DATA_DATE")
    private String dbfDataDate;

    @Column(name="TRANSACTION_DETAIL_DATE")
    private String transactionDetailDate;

    @Column(name="UPLOADED_STATUS")
    private String uploadStatus;


    public DbfDataDetails() {
        
    }


	public DbfDataDetails(String transactionDetailId, String customerId, String dbfDataDate,
			String transactionDetailDate, String uploadStatus) {
		super();
		this.transactionDetailId = transactionDetailId;
		this.customerId = customerId;
		this.dbfDataDate = dbfDataDate;
		this.transactionDetailDate = transactionDetailDate;
		this.uploadStatus = uploadStatus;
	}


	public String getDbfDataId() {
		return dbfDataId;
	}


	public void setDbfDataId(String dbfDataId) {
		this.dbfDataId = dbfDataId;
	}


	public String getTransactionDetailId() {
		return transactionDetailId;
	}


	public void setTransactionDetailId(String transactionDetailId) {
		this.transactionDetailId = transactionDetailId;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getDbfDataDate() {
		return dbfDataDate;
	}


	public void setDbfDataDate(String dbfDataDate) {
		this.dbfDataDate = dbfDataDate;
	}


	public String getTransactionDetailDate() {
		return transactionDetailDate;
	}


	public void setTransactionDetailDate(String transactionDetailDate) {
		this.transactionDetailDate = transactionDetailDate;
	}


	public String getUploadStatus() {
		return uploadStatus;
	}


	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}


	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }	
		
        final DbfDataDetails other = (DbfDataDetails) obj;
        if ((this.dbfDataId == null) ? (other.dbfDataId != null) : !this.dbfDataId.equals(other.dbfDataId)) {
            return false;
        }
        if ((this.transactionDetailId == null) ? (other.transactionDetailId != null) : !this.transactionDetailId.equals(other.transactionDetailId)) {
            return false;
        }
        if ((this.customerId == null) ? (other.customerId != null) : !this.customerId.equals(other.customerId)) {
            return false;
        }
        if ((this.dbfDataDate == null) ? (other.dbfDataDate != null) : !this.dbfDataDate.equals(other.dbfDataDate)) {
            return false;
        }
        if ((this.transactionDetailDate == null) ? (other.transactionDetailDate != null) : !this.transactionDetailDate.equals(other.transactionDetailDate)) {
            return false;
        }
        if ((this.uploadStatus == null) ? (other.uploadStatus != null) : !this.uploadStatus.equals(other.uploadStatus)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.dbfDataId != null ? this.dbfDataId.hashCode() : 0);
        hash = 79 * hash + (this.transactionDetailId != null ? this.transactionDetailId.hashCode() : 0);
        hash = 79 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 79 * hash + (this.dbfDataDate != null ? this.dbfDataDate.hashCode() : 0);
        hash = 79 * hash + (this.transactionDetailDate != null ? this.transactionDetailDate.hashCode() : 0);
        hash = 79 * hash + (this.uploadStatus != null ? this.uploadStatus.hashCode() : 0);
        return hash;
    }



}

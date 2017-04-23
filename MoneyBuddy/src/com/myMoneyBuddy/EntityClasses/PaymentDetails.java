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
@Table (name="PAYMENT_DETAILS")
public class PaymentDetails {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PAYMENT_REF_NUM")
    private String paymentRefNum;
    
    @Column (name="TRANSACTION_ID")
    private String transactionId;
    
    @Column(name="PAYMENT_GATEWAY_COMMENT")
    private String paymentGatewayComment;
    
    @Column(name="TRANSACTION_DATE")
    private String transactionDate;
    
    @Column(name="UPDATE_DATE")
    private String updateDate;

    public PaymentDetails() {

    }

    public PaymentDetails(String transactionId, 
			String paymentGatewayComment, String transactionDate,
			String updateDate) {
		super();
		this.transactionId = transactionId;
		this.paymentGatewayComment = paymentGatewayComment;
		this.transactionDate = transactionDate;
		this.updateDate = updateDate;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getPaymentRefNum() {
		return paymentRefNum;
	}

	public void setPaymentRefNum(String paymentRefNum) {
		this.paymentRefNum = paymentRefNum;
	}

	public String getPaymentGatewayComment() {
		return paymentGatewayComment;
	}

	public void setPaymentGatewayComment(String paymentGatewayComment) {
		this.paymentGatewayComment = paymentGatewayComment;
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
        final PaymentDetails other = (PaymentDetails) obj;
        if ((this.transactionId == null) ? (other.transactionId != null) : !this.transactionId.equals(other.transactionId)) {
            return false;
        }
        if ((this.paymentRefNum == null) ? (other.paymentRefNum != null) : !this.paymentRefNum.equals(other.paymentRefNum)) {
            return false;
        }
        if ((this.paymentGatewayComment == null) ? (other.paymentGatewayComment != null) : !this.paymentGatewayComment.equals(other.paymentGatewayComment)) {
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
        hash = 83 * hash + (this.paymentRefNum != null ? this.paymentRefNum.hashCode() : 0);
        hash = 83 * hash + (this.paymentGatewayComment != null ? this.paymentGatewayComment.hashCode() : 0);
        hash = 83 * hash + (this.transactionDate != null ? this.transactionDate.hashCode() : 0);
        hash = 83 * hash + (this.updateDate != null ? this.updateDate.hashCode() : 0);
        return hash;
    }



}
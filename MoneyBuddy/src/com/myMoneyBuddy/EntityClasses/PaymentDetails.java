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
    @Column(name="PAYMENT_DETAILS_ID")
    private String paymentDetailsId;
    
    @Column (name="TRANSACTION_DETAIL_ID")
    private String transactionDetailId;
    
    @Column (name="BSE_ORDER_ID")
    private String bseOrderID;
    
    @Column(name="PAYMENT_GATEWAY_COMMENT")
    private String paymentGatewayComment;
    
    @Column(name="TRANSACTION_DATE")
    private String transactionDate;
    
    @Column(name="UPDATE_DATE")
    private String updateDate;

    public PaymentDetails() {

    }

    

	public PaymentDetails(String transactionDetailId, String bseOrderID,
			String paymentGatewayComment, String transactionDate, String updateDate) {
		super();
		this.transactionDetailId = transactionDetailId;
		this.bseOrderID = bseOrderID;
		this.paymentGatewayComment = paymentGatewayComment;
		this.transactionDate = transactionDate;
		this.updateDate = updateDate;
	}

	public String getPaymentDetailsId() {
		return paymentDetailsId;
	}



	public void setPaymentDetailsId(String paymentDetailsId) {
		this.paymentDetailsId = paymentDetailsId;
	}



	public String getTransactionDetailId() {
		return transactionDetailId;
	}

	public void setTransactionDetailId(String transactionDetailId) {
		this.transactionDetailId = transactionDetailId;
	}

	public String getBseOrderID() {
		return bseOrderID;
	}

	public void setBseOrderID(String bseOrderID) {
		this.bseOrderID = bseOrderID;
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
        if ((this.paymentDetailsId == null) ? (other.paymentDetailsId != null) : !this.paymentDetailsId.equals(other.paymentDetailsId)) {
            return false;
        }
        if ((this.transactionDetailId == null) ? (other.transactionDetailId != null) : !this.transactionDetailId.equals(other.transactionDetailId)) {
            return false;
        }
        if ((this.bseOrderID == null) ? (other.bseOrderID != null) : !this.bseOrderID.equals(other.bseOrderID)) {
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
        hash = 83 * hash + (this.paymentDetailsId != null ? this.paymentDetailsId.hashCode() : 0);
        hash = 83 * hash + (this.transactionDetailId != null ? this.transactionDetailId.hashCode() : 0);
        hash = 83 * hash + (this.bseOrderID != null ? this.bseOrderID.hashCode() : 0);
        hash = 83 * hash + (this.paymentGatewayComment != null ? this.paymentGatewayComment.hashCode() : 0);
        hash = 83 * hash + (this.transactionDate != null ? this.transactionDate.hashCode() : 0);
        hash = 83 * hash + (this.updateDate != null ? this.updateDate.hashCode() : 0);
        return hash;
    }



}
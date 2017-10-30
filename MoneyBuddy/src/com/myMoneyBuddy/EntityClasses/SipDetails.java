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
@Table (name ="SIP_DETAILS")
public class SipDetails {

    @Id
    @Column (name="TRANSACTION_ID")
    private String transactionId;
    
    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Column (name="SIP_DATE")
    private String sipDate;

    @Column (name="SIP_END_DATE")
    private String sipEndDate;

    @Column(name="SIP_COMPLETION_STATUS")
    private String sipCompletionStatus;

    @Column(name="SIP_FORM_SUBMISSION ")
    private String sipFormSubmission;

    
    public SipDetails() {
        
    }

	public SipDetails(String customerId, String transactionId, String sipDate, String sipEndDate, String sipCompletionStatus,
			String sipFormSubmission) {
		super();
		this.customerId = customerId;
		this.transactionId = transactionId;
		this.sipDate = sipDate;
		this.sipEndDate = sipEndDate;
		this.sipCompletionStatus = sipCompletionStatus;
		this.sipFormSubmission = sipFormSubmission;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getSipDate() {
		return sipDate;
	}

	public void setSipDate(String sipDate) {
		this.sipDate = sipDate;
	}

	public String getSipEndDate() {
		return sipEndDate;
	}

	public void setSipEndDate(String sipEndDate) {
		this.sipEndDate = sipEndDate;
	}

	public String getSipCompletionStatus() {
		return sipCompletionStatus;
	}

	public void setSipCompletionStatus(String sipCompletionStatus) {
		this.sipCompletionStatus = sipCompletionStatus;
	}

	public String getSipFormSubmission() {
		return sipFormSubmission;
	}

	public void setSipFormSubmission(String sipFormSubmission) {
		this.sipFormSubmission = sipFormSubmission;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SipDetails other = (SipDetails) obj;
        if ((this.customerId == null) ? (other.customerId != null) : !this.customerId.equals(other.customerId)) {
            return false;
        }
        if ((this.transactionId == null) ? (other.transactionId != null) : !this.transactionId.equals(other.transactionId)) {
            return false;
        }
        if ((this.sipDate == null) ? (other.sipDate != null) : !this.sipDate.equals(other.sipDate)) {
            return false;
        }
        if ((this.sipEndDate == null) ? (other.sipEndDate != null) : !this.sipEndDate.equals(other.sipEndDate)) {
            return false;
        }
        if ((this.sipCompletionStatus == null) ? (other.sipCompletionStatus != null) : !this.sipCompletionStatus.equals(other.sipCompletionStatus)) {
            return false;
        }
        if ((this.sipFormSubmission == null) ? (other.sipFormSubmission != null) : !this.sipFormSubmission.equals(other.sipFormSubmission)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 79 * hash + (this.transactionId != null ? this.transactionId.hashCode() : 0);
        hash = 79 * hash + (this.sipDate != null ? this.sipDate.hashCode() : 0);
        hash = 79 * hash + (this.sipEndDate != null ? this.sipEndDate.hashCode() : 0);
        hash = 79 * hash + (this.sipCompletionStatus != null ? this.sipCompletionStatus.hashCode() : 0);
        hash = 79 * hash + (this.sipFormSubmission != null ? this.sipFormSubmission.hashCode() : 0);
        
        return hash;
    }



}

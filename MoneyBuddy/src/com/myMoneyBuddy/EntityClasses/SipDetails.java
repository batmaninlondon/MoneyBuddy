/**
 *
 * @author ADMIN
 */

package com.myMoneyBuddy.EntityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="SIP_DETAILS")
public class SipDetails {

    @Id
    @Column (name="TRANSACTION_DETAIL_ID")
    private String transactionDetailId;
    
    @Column(name="CUSTOMER_ID")
    private String customerId;
    
    @Column(name="BSE_REG_NUM")
    private String bseRegNum;
    
    @Column(name="SIP_AMOUNT")
    private String sipAmount;

    @Column (name="SIP_DATE")
    private String sipDate;

    @Column (name="SIP_START_DATE")
    private String sipStartDate;
    
    @Column (name="SIP_END_DATE")
    private String sipEndDate;
    
    @Column (name="SIP_DURATION")
    private String sipDuration;

    @Column(name="SIP_COMPLETION_STATUS")
    private String sipCompletionStatus;

    @Column(name="SIP_FORM_SUBMISSION ")
    private String sipFormSubmission;

    
    public SipDetails() {
        
    }

	public SipDetails(String customerId, String bseRegNum, String transactionDetailId, String sipAmount, String sipDate, String sipStartDate,  String sipEndDate, String sipDuration, 
				String sipCompletionStatus, String sipFormSubmission) {
		super();
		this.customerId = customerId;
		this.bseRegNum = bseRegNum;
		this.transactionDetailId = transactionDetailId;
		this.sipAmount = sipAmount;
		this.sipStartDate = sipStartDate;
		this.sipDate = sipDate;
		this.sipEndDate = sipEndDate;
		this.sipDuration = sipDuration;
		this.sipCompletionStatus = sipCompletionStatus;
		this.sipFormSubmission = sipFormSubmission;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getBseRegNum() {
		return bseRegNum;
	}

	public void setBseRegNum(String bseRegNum) {
		this.bseRegNum = bseRegNum;
	}

	public String getSipAmount() {
		return sipAmount;
	}

	public void setSipAmount(String sipAmount) {
		this.sipAmount = sipAmount;
	}

	public String getTransactionDetailId() {
		return transactionDetailId;
	}

	public void setTransactionDetailId(String transactionDetailId) {
		this.transactionDetailId = transactionDetailId;
	}

	public String getSipDate() {
		return sipDate;
	}

	public void setSipDate(String sipDate) {
		this.sipDate = sipDate;
	}

	public String getSipStartDate() {
		return sipStartDate;
	}

	public void setSipStartDate(String sipStartDate) {
		this.sipStartDate = sipStartDate;
	}

	public String getSipEndDate() {
		return sipEndDate;
	}

	public void setSipEndDate(String sipEndDate) {
		this.sipEndDate = sipEndDate;
	}

	public String getSipDuration() {
		return sipDuration;
	}

	public void setSipDuration(String sipDuration) {
		this.sipDuration = sipDuration;
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
        if ((this.bseRegNum == null) ? (other.bseRegNum != null) : !this.bseRegNum.equals(other.bseRegNum)) {
            return false;
        }
        if ((this.transactionDetailId == null) ? (other.transactionDetailId != null) : !this.transactionDetailId.equals(other.transactionDetailId)) {
            return false;
        }
        if ((this.sipAmount == null) ? (other.sipAmount != null) : !this.sipAmount.equals(other.sipAmount)) {
            return false;
        }
        if ((this.sipDate == null) ? (other.sipDate != null) : !this.sipDate.equals(other.sipDate)) {
            return false;
        }
        if ((this.sipStartDate == null) ? (other.sipStartDate != null) : !this.sipStartDate.equals(other.sipStartDate)) {
            return false;
        }
        if ((this.sipEndDate == null) ? (other.sipEndDate != null) : !this.sipEndDate.equals(other.sipEndDate)) {
            return false;
        }
        if ((this.sipDuration == null) ? (other.sipDuration != null) : !this.sipDuration.equals(other.sipDuration)) {
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
        hash = 79 * hash + (this.bseRegNum != null ? this.bseRegNum.hashCode() : 0);
        hash = 79 * hash + (this.transactionDetailId != null ? this.transactionDetailId.hashCode() : 0);
        hash = 79 * hash + (this.sipAmount != null ? this.sipAmount.hashCode() : 0);
        hash = 79 * hash + (this.sipDate != null ? this.sipDate.hashCode() : 0);
        hash = 79 * hash + (this.sipStartDate != null ? this.sipStartDate.hashCode() : 0);
        hash = 79 * hash + (this.sipEndDate != null ? this.sipEndDate.hashCode() : 0);
        hash = 79 * hash + (this.sipDuration != null ? this.sipDuration.hashCode() : 0);
        hash = 79 * hash + (this.sipCompletionStatus != null ? this.sipCompletionStatus.hashCode() : 0);
        hash = 79 * hash + (this.sipFormSubmission != null ? this.sipFormSubmission.hashCode() : 0);
        
        return hash;
    }



}

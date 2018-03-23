/**
 *
 * @author ADMIN
 */

package com.myMoneyBuddy.EntityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="SUBSCRIBERS")
public class Subscriber {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="SUBSCRIBERS_ID")
    private String subscriberId;
    
    @Column (name="EMAIL_ID")
    private String emailId;
    
    @Column(name="MOBILE_NUMBER")
    private String mobileNumber;
    
    @Column(name="SUBSCRIBER_TYPE")
    private String subscriberType;
    
    @Column(name="ENTRY_DATE")
    private String entryDate;

    public Subscriber() {
        
    }

	public Subscriber(String emailId, String subscriberType, String entryDate) {
		super();
		this.emailId = emailId;
		this.subscriberType = subscriberType;
		this.entryDate = entryDate;
	}


	public String getSubscriberId() {
		return subscriberId;
	}


	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getSubscriberType() {
		return subscriberType;
	}


	public void setSubscriberType(String subscriberType) {
		this.subscriberType = subscriberType;
	}


	public String getEntryDate() {
		return entryDate;
	}


	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}


	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }	

        final Subscriber other = (Subscriber) obj;
        if ((this.subscriberId == null) ? (other.subscriberId != null) : !this.subscriberId.equals(other.subscriberId)) {
            return false;
        }
        if ((this.emailId == null) ? (other.emailId != null) : !this.emailId.equals(other.emailId)) {
            return false;
        }
        if ((this.mobileNumber == null) ? (other.mobileNumber != null) : !this.mobileNumber.equals(other.mobileNumber)) {
            return false;
        }
        if ((this.subscriberType == null) ? (other.subscriberType != null) : !this.subscriberType.equals(other.subscriberType)) {
            return false;
        }
        if ((this.entryDate == null) ? (other.entryDate != null) : !this.entryDate.equals(other.entryDate)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.subscriberId != null ? this.subscriberId.hashCode() : 0);
        hash = 79 * hash + (this.emailId != null ? this.emailId.hashCode() : 0);
        hash = 79 * hash + (this.mobileNumber != null ? this.mobileNumber.hashCode() : 0);
        hash = 79 * hash + (this.subscriberType != null ? this.subscriberType.hashCode() : 0);
        hash = 79 * hash + (this.entryDate != null ? this.entryDate.hashCode() : 0);
        return hash;
    }



}

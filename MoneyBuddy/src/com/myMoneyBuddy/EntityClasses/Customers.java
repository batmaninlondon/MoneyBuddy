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
@Table (name ="CUSTOMERS")
public class Customers {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CUSTOMER_ID")
    private String customerId;
    
    @Column (name="CUSTOMER_NAME")
    private String customerName;

    @Column(name="EMAIL_ID")
    private String emailId;

    @Column(name="MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="VERIFICATION_STATUS")
    private String verificationStatus;

    @Column(name="PAN_CARD")
    private String panCard;
    
    @Column(name="KYC_STATUS")
    private String kycStatus;
    
    @Column(name="FOLIO_NUMBER")
    private String folioNumber;
    
    @Column(name="KARVY_FILE_GENERATED")
    private String karvyFileGenerated;
    
    @Column(name="CAMS_FILE_GENERATED")
    private String camsFileGenerated;
    
    @Column(name="SUBSCRIBER_TYPE")
    private String subscriberType;
    
    @Column(name="CUS_DETAILS_UPLOADED")
    private String cusDetailsUploaded;
    
    @Column(name="ADD_CUS_DETAILS_UPLOADED")
    private String addCusDetailsUploaded;

    public Customers() {
        
    }

	public Customers(String emailId, String customerName, String mobileNumber, String password, String verificationStatus, 
			String panCard, String kycStatus, String folioNumber, String karvyFileGenerated, 
			String camsFileGenerated, String subscriberType, String cusDetailsUploaded, String addCusDetailsUploaded) {
		super();
		this.emailId = emailId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.verificationStatus = verificationStatus;
		this.panCard = panCard;
		this.kycStatus = kycStatus;
		this.folioNumber = folioNumber;
		this.karvyFileGenerated = karvyFileGenerated;
		this.camsFileGenerated = camsFileGenerated;
		this.subscriberType = subscriberType;
		this.cusDetailsUploaded = cusDetailsUploaded;
		this.addCusDetailsUploaded = addCusDetailsUploaded;
	}



	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getKycStatus() {
		return kycStatus;
	}

	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}

	public String getFolioNumber() {
		return folioNumber;
	}

	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}

	public String getKarvyFileGenerated() {
		return karvyFileGenerated;
	}

	public void setKarvyFileGenerated(String karvyFileGenerated) {
		this.karvyFileGenerated = karvyFileGenerated;
	}

	public String getCamsFileGenerated() {
		return camsFileGenerated;
	}

	public void setCamsFileGenerated(String camsFileGenerated) {
		this.camsFileGenerated = camsFileGenerated;
	}

	public String getSubscriberType() {
		return subscriberType;
	}

	public void setSubscriberType(String subscriberType) {
		this.subscriberType = subscriberType;
	}

	public String getCusDetailsUploaded() {
		return cusDetailsUploaded;
	}

	public void setCusDetailsUploaded(String cusDetailsUploaded) {
		this.cusDetailsUploaded = cusDetailsUploaded;
	}

	public String getAddCusDetailsUploaded() {
		return addCusDetailsUploaded;
	}

	public void setAddCusDetailsUploaded(String addCusDetailsUploaded) {
		this.addCusDetailsUploaded = addCusDetailsUploaded;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customers other = (Customers) obj;
        if ((this.customerId == null) ? (other.customerId != null) : !this.customerId.equals(other.customerId)) {
            return false;
        }
        if ((this.emailId == null) ? (other.emailId != null) : !this.emailId.equals(other.emailId)) {
            return false;
        }
        if ((this.customerName == null) ? (other.customerName != null) : !this.customerName.equals(other.customerName)) {
            return false;
        }
        if ((this.mobileNumber == null) ? (other.mobileNumber != null) : !this.mobileNumber.equals(other.mobileNumber)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if ((this.verificationStatus == null) ? (other.verificationStatus != null) : !this.verificationStatus.equals(other.verificationStatus)) {
            return false;
        }
        if ((this.panCard == null) ? (other.panCard != null) : !this.panCard.equals(other.panCard)) {
            return false;
        }
        if ((this.kycStatus == null) ? (other.kycStatus != null) : !this.kycStatus.equals(other.kycStatus)) {
            return false;
        }
        if ((this.folioNumber == null) ? (other.folioNumber != null) : !this.folioNumber.equals(other.folioNumber)) {
            return false;
        }
        if ((this.karvyFileGenerated == null) ? (other.karvyFileGenerated != null) : !this.karvyFileGenerated.equals(other.karvyFileGenerated)) {
            return false;
        }
        if ((this.camsFileGenerated == null) ? (other.camsFileGenerated != null) : !this.camsFileGenerated.equals(other.camsFileGenerated)) {
            return false;
        }
        if ((this.subscriberType == null) ? (other.subscriberType != null) : !this.subscriberType.equals(other.subscriberType)) {
            return false;
        }
        if ((this.cusDetailsUploaded == null) ? (other.cusDetailsUploaded != null) : !this.cusDetailsUploaded.equals(other.cusDetailsUploaded)) {
            return false;
        }
        if ((this.addCusDetailsUploaded == null) ? (other.addCusDetailsUploaded != null) : !this.addCusDetailsUploaded.equals(other.addCusDetailsUploaded)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 79 * hash + (this.emailId != null ? this.emailId.hashCode() : 0);
        hash = 79 * hash + (this.customerName != null ? this.customerName.hashCode() : 0);
        hash = 79 * hash + (this.mobileNumber != null ? this.mobileNumber.hashCode() : 0);
        hash = 79 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = 79 * hash + (this.verificationStatus != null ? this.verificationStatus.hashCode() : 0);
        hash = 79 * hash + (this.panCard != null ? this.panCard.hashCode() : 0);
        hash = 79 * hash + (this.kycStatus != null ? this.kycStatus.hashCode() : 0);
        hash = 79 * hash + (this.folioNumber != null ? this.folioNumber.hashCode() : 0);
        hash = 79 * hash + (this.karvyFileGenerated != null ? this.karvyFileGenerated.hashCode() : 0);
        hash = 79 * hash + (this.camsFileGenerated != null ? this.camsFileGenerated.hashCode() : 0);
        hash = 79 * hash + (this.subscriberType != null ? this.subscriberType.hashCode() : 0);
        hash = 79 * hash + (this.cusDetailsUploaded != null ? this.cusDetailsUploaded.hashCode() : 0);
        hash = 79 * hash + (this.addCusDetailsUploaded != null ? this.addCusDetailsUploaded.hashCode() : 0);
        return hash;
    }



}

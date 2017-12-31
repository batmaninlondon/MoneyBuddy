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
    
    @Column(name="EMAIL_ID")
    private String emailId;
    
    @Column (name="CUSTOMER_NAME")
    private String customerName;

    @Column(name="MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="VERIFICATION_STATUS")
    private String verificationStatus;
    
    @Column(name="GENDER")
    private String gender;
    
    @Column(name="OCCUPATION")
    private String occupation;
    
    @Column (name="DATE_OF_BIRTH")
    private String dateOfBirth;
 
    @Column(name="ADDRESS_LINE_1")
    private String addressLineOne;
    
    @Column(name="ADDRESS_LINE_2")
    private String addressLineTwo;
    
    @Column(name="ADDRESS_LINE_3")
    private String addressLineThree;
    
    @Column(name="RESIDENTIAL_CITY")
    private String residentialCity;
    
    @Column(name="RESIDENTIAL_STATE")
    private String residentialState;
    
    @Column(name="RESIDENTIAL_PIN")
    private String residentialPin;
    
    @Column(name="RESIDENTIAL_COUNTRY")
    private String residentialCountry;
    
    @Column(name="TAX_STATUS")
    private String taxStatus;
    
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

    public Customers() {
        
    }

	public Customers(String emailId, String customerName, String mobileNumber, String password,
			String verificationStatus, String gender, String occupation, String dateOfBirth, String addressLineOne,
			String addressLineTwo, String addressLineThree, String residentialCity, String residentialState,
			String residentialPin, String residentialCountry, String taxStatus, String panCard, String kycStatus,
			String folioNumber, String karvyFileGenerated, String camsFileGenerated, String subscriberType) {
		super();
		this.emailId = emailId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.verificationStatus = verificationStatus;
		this.gender = gender;
		this.occupation = occupation;
		this.dateOfBirth = dateOfBirth;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.addressLineThree = addressLineThree;
		this.residentialCity = residentialCity;
		this.residentialState = residentialState;
		this.residentialPin = residentialPin;
		this.residentialCountry = residentialCountry;
		this.taxStatus = taxStatus;
		this.panCard = panCard;
		this.kycStatus = kycStatus;
		this.folioNumber = folioNumber;
		this.karvyFileGenerated = karvyFileGenerated;
		this.camsFileGenerated = camsFileGenerated;
		this.subscriberType = subscriberType;
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
	
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getAddressLineThree() {
		return addressLineThree;
	}

	public void setAddressLineThree(String addressLineThree) {
		this.addressLineThree = addressLineThree;
	}

	public String getResidentialCity() {
		return residentialCity;
	}

	public void setResidentialCity(String residentialCity) {
		this.residentialCity = residentialCity;
	}

	public String getResidentialState() {
		return residentialState;
	}

	public void setResidentialState(String residentialState) {
		this.residentialState = residentialState;
	}

	public String getResidentialPin() {
		return residentialPin;
	}

	public void setResidentialPin(String residentialPin) {
		this.residentialPin = residentialPin;
	}

	public String getResidentialCountry() {
		return residentialCountry;
	}

	public void setResidentialCountry(String residentialCountry) {
		this.residentialCountry = residentialCountry;
	}

	public String getTaxStatus() {
		return taxStatus;
	}

	public void setTaxStatus(String taxStatus) {
		this.taxStatus = taxStatus;
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
        if ((this.gender == null) ? (other.gender != null) : !this.gender.equals(other.gender)) {
            return false;
        }
        if ((this.occupation == null) ? (other.occupation != null) : !this.occupation.equals(other.occupation)) {
            return false;
        }
        if ((this.dateOfBirth == null) ? (other.dateOfBirth != null) : !this.dateOfBirth.equals(other.dateOfBirth)) {
            return false;
        }
        if ((this.addressLineOne == null) ? (other.addressLineOne != null) : !this.addressLineOne.equals(other.addressLineOne)) {
            return false;
        }
        if ((this.addressLineTwo == null) ? (other.addressLineTwo != null) : !this.addressLineTwo.equals(other.addressLineTwo)) {
            return false;
        }
        if ((this.addressLineThree == null) ? (other.addressLineThree != null) : !this.addressLineThree.equals(other.addressLineThree)) {
            return false;
        }
        if ((this.residentialCity == null) ? (other.residentialCity != null) : !this.residentialCity.equals(other.residentialCity)) {
            return false;
        }
        if ((this.residentialState == null) ? (other.residentialState != null) : !this.residentialState.equals(other.residentialState)) {
            return false;
        }
        if ((this.residentialPin == null) ? (other.residentialPin != null) : !this.residentialPin.equals(other.residentialPin)) {
            return false;
        }
        if ((this.residentialCountry == null) ? (other.residentialCountry != null) : !this.residentialCountry.equals(other.residentialCountry)) {
            return false;
        }
        if ((this.taxStatus == null) ? (other.taxStatus != null) : !this.taxStatus.equals(other.taxStatus)) {
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
        hash = 79 * hash + (this.gender != null ? this.gender.hashCode() : 0);
        hash = 79 * hash + (this.occupation != null ? this.occupation.hashCode() : 0);
        hash = 79 * hash + (this.dateOfBirth != null ? this.dateOfBirth.hashCode() : 0);
        hash = 79 * hash + (this.addressLineOne != null ? this.addressLineOne.hashCode() : 0);
        hash = 79 * hash + (this.addressLineTwo != null ? this.addressLineTwo.hashCode() : 0);
        hash = 79 * hash + (this.addressLineThree != null ? this.addressLineThree.hashCode() : 0);
        hash = 79 * hash + (this.residentialCity != null ? this.residentialCity.hashCode() : 0);
        hash = 79 * hash + (this.residentialState != null ? this.residentialState.hashCode() : 0);
        hash = 79 * hash + (this.residentialPin != null ? this.residentialPin.hashCode() : 0);
        hash = 79 * hash + (this.residentialCountry != null ? this.residentialCountry.hashCode() : 0);
        hash = 79 * hash + (this.taxStatus != null ? this.taxStatus.hashCode() : 0);
        hash = 79 * hash + (this.panCard != null ? this.panCard.hashCode() : 0);
        hash = 79 * hash + (this.kycStatus != null ? this.kycStatus.hashCode() : 0);
        hash = 79 * hash + (this.folioNumber != null ? this.folioNumber.hashCode() : 0);
        hash = 79 * hash + (this.karvyFileGenerated != null ? this.karvyFileGenerated.hashCode() : 0);
        hash = 79 * hash + (this.camsFileGenerated != null ? this.camsFileGenerated.hashCode() : 0);
        hash = 79 * hash + (this.subscriberType != null ? this.subscriberType.hashCode() : 0);
        return hash;
    }



}

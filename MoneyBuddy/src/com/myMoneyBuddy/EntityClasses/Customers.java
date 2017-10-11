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
    
    @Column (name="FIRST_NAME")
    private String firstName;

    @Column (name="LAST_NAME")
    private String lastName;

    @Column(name="MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="VERIFICATION_STATUS")
    private String verificationStatus;
    
    @Column(name="FATHER_NAME")
    private String fatherName;
    
    @Column(name="MOTHER_NAME")
    private String motherName;
    
    @Column(name="DATE_OF_BIRTH")
    private String dateOfBirth;
    
    @Column(name="PAN_CARD")
    private String panCard;
    
    @Column(name="KYC_STATUS")
    private String kycStatus;

    public Customers() {
        
    }

    public Customers(String emailId, String firstName, String lastName, String mobileNumber, String password,
			String verificationStatus, String fatherName, String motherName, String dateOfBirth, String panCard, String kycStatus) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.verificationStatus = verificationStatus;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.dateOfBirth = dateOfBirth;
		this.panCard = panCard;
		this.kycStatus = kycStatus;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName)) {
            return false;
        }
        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName)) {
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
        if ((this.fatherName == null) ? (other.fatherName != null) : !this.fatherName.equals(other.fatherName)) {
            return false;
        }
        if ((this.motherName == null) ? (other.motherName != null) : !this.motherName.equals(other.motherName)) {
            return false;
        }
        if ((this.dateOfBirth == null) ? (other.dateOfBirth != null) : !this.dateOfBirth.equals(other.dateOfBirth)) {
            return false;
        }
        if ((this.panCard == null) ? (other.panCard != null) : !this.panCard.equals(other.panCard)) {
            return false;
        }
        if ((this.kycStatus == null) ? (other.kycStatus != null) : !this.kycStatus.equals(other.kycStatus)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 79 * hash + (this.emailId != null ? this.emailId.hashCode() : 0);
        hash = 79 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 79 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 79 * hash + (this.mobileNumber != null ? this.mobileNumber.hashCode() : 0);
        hash = 79 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = 79 * hash + (this.verificationStatus != null ? this.verificationStatus.hashCode() : 0);
        hash = 79 * hash + (this.fatherName != null ? this.fatherName.hashCode() : 0);
        hash = 79 * hash + (this.motherName != null ? this.motherName.hashCode() : 0);
        hash = 79 * hash + (this.dateOfBirth != null ? this.dateOfBirth.hashCode() : 0);
        hash = 79 * hash + (this.panCard != null ? this.panCard.hashCode() : 0);
        hash = 79 * hash + (this.kycStatus != null ? this.kycStatus.hashCode() : 0);
        return hash;
    }



}

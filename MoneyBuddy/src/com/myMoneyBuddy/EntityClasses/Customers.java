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
    
    @Column(name="GENDER")
    private String gender;
    
    @Column(name="OCCUPATION")
    private String occupation;
    
    @Column(name="GROSS_ANNUAL_INCOME")
    private String grossAnnualIncome;
    
    @Column(name="POLITICALLY_EXPOSED")
    private String politicallyExposed;
    
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

    public Customers() {
        
    }

    public Customers( String firstName, String lastName, String emailId, String mobileNumber, String password,
			String verificationStatus, String gender, String occupation, String grossAnnualIncome, String politicallyExposed, String panCard, String kycStatus,
			String folioNumber, String karvyFileGenerated, String camsFileGenerated) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.verificationStatus = verificationStatus;
		this.gender = gender;
		this.occupation = occupation;
		this.grossAnnualIncome = grossAnnualIncome;
		this.politicallyExposed = politicallyExposed;
		this.panCard = panCard;
		this.kycStatus = kycStatus;
		this.folioNumber = folioNumber;
		this.karvyFileGenerated = karvyFileGenerated;
		this.camsFileGenerated = camsFileGenerated;
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

	public String getGrossAnnualIncome() {
		return grossAnnualIncome;
	}

	public void setGrossAnnualIncome(String grossAnnualIncome) {
		this.grossAnnualIncome = grossAnnualIncome;
	}

	public String getPoliticallyExposed() {
		return politicallyExposed;
	}

	public void setPoliticallyExposed(String politicallyExposed) {
		this.politicallyExposed = politicallyExposed;
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
        if ((this.gender == null) ? (other.gender != null) : !this.gender.equals(other.gender)) {
            return false;
        }
        if ((this.occupation == null) ? (other.occupation != null) : !this.occupation.equals(other.occupation)) {
            return false;
        }
        if ((this.grossAnnualIncome == null) ? (other.grossAnnualIncome != null) : !this.grossAnnualIncome.equals(other.grossAnnualIncome)) {
            return false;
        }
        if ((this.politicallyExposed == null) ? (other.politicallyExposed != null) : !this.politicallyExposed.equals(other.politicallyExposed)) {
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
        hash = 79 * hash + (this.gender != null ? this.gender.hashCode() : 0);
        hash = 79 * hash + (this.occupation != null ? this.occupation.hashCode() : 0);
        hash = 79 * hash + (this.grossAnnualIncome != null ? this.grossAnnualIncome.hashCode() : 0);
        hash = 79 * hash + (this.politicallyExposed != null ? this.politicallyExposed.hashCode() : 0);
        hash = 79 * hash + (this.panCard != null ? this.panCard.hashCode() : 0);
        hash = 79 * hash + (this.kycStatus != null ? this.kycStatus.hashCode() : 0);
        hash = 79 * hash + (this.folioNumber != null ? this.folioNumber.hashCode() : 0);
        hash = 79 * hash + (this.karvyFileGenerated != null ? this.karvyFileGenerated.hashCode() : 0);
        hash = 79 * hash + (this.camsFileGenerated != null ? this.camsFileGenerated.hashCode() : 0);
        return hash;
    }



}

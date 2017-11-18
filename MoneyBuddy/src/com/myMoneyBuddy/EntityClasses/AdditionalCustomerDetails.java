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
@Table (name ="ADDITIONAL_CUSTOMER_DETAILS")
public class AdditionalCustomerDetails {

    @Id
    @Column(name="CUSTOMER_ID")
    private String customerId;
    
    @Column (name="FATHER_NAME")
    private String fatherName;

    @Column (name="DATE_OF_BIRTH")
    private String dateOfBirth;

    @Column(name="MARITAL_STATUS")
    private String maritalStatus;

    @Column(name="NATIONALITY")
    private String nationality;

    @Column(name="STATUS")
    private String status;
    
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
    
    public AdditionalCustomerDetails() {
        
    }

	public AdditionalCustomerDetails(String customerId, String fatherName, String dateOfBirth, String maritalStatus,
			String nationality, String status, String addressLineOne, String addressLineTwo, String addressLineThree, String residentialCity,
			String residentialState, String residentialPin, String residentialCountry, String taxStatus) {
		super();
		this.customerId = customerId;
		this.fatherName = fatherName;
		this.dateOfBirth = dateOfBirth;
		this.maritalStatus = maritalStatus;
		this.nationality = nationality;
		this.status = status;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.addressLineThree = addressLineThree;
		this.residentialCity = residentialCity;
		this.residentialState = residentialState;
		this.residentialPin = residentialPin;
		this.residentialCountry = residentialCountry;
		this.taxStatus = taxStatus;
	}

	
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AdditionalCustomerDetails other = (AdditionalCustomerDetails) obj;
        if ((this.customerId == null) ? (other.customerId != null) : !this.customerId.equals(other.customerId)) {
            return false;
        }
        if ((this.fatherName == null) ? (other.fatherName != null) : !this.fatherName.equals(other.fatherName)) {
            return false;
        }
        if ((this.dateOfBirth == null) ? (other.dateOfBirth != null) : !this.dateOfBirth.equals(other.dateOfBirth)) {
            return false;
        }
        if ((this.maritalStatus == null) ? (other.maritalStatus != null) : !this.maritalStatus.equals(other.maritalStatus)) {
            return false;
        }
        if ((this.nationality == null) ? (other.nationality != null) : !this.nationality.equals(other.nationality)) {
            return false;
        }
        if ((this.status == null) ? (other.status != null) : !this.status.equals(other.status)) {
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
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 79 * hash + (this.fatherName != null ? this.fatherName.hashCode() : 0);
        hash = 79 * hash + (this.dateOfBirth != null ? this.dateOfBirth.hashCode() : 0);
        hash = 79 * hash + (this.maritalStatus != null ? this.maritalStatus.hashCode() : 0);
        hash = 79 * hash + (this.nationality != null ? this.nationality.hashCode() : 0);
        hash = 79 * hash + (this.status != null ? this.status.hashCode() : 0);
        hash = 79 * hash + (this.addressLineOne != null ? this.addressLineOne.hashCode() : 0);
        hash = 79 * hash + (this.addressLineTwo != null ? this.addressLineTwo.hashCode() : 0);
        hash = 79 * hash + (this.addressLineThree != null ? this.addressLineThree.hashCode() : 0);
        hash = 79 * hash + (this.residentialCity != null ? this.residentialCity.hashCode() : 0);
        hash = 79 * hash + (this.residentialState != null ? this.residentialState.hashCode() : 0);
        hash = 79 * hash + (this.residentialPin != null ? this.residentialPin.hashCode() : 0);
        hash = 79 * hash + (this.residentialCountry != null ? this.residentialCountry.hashCode() : 0);
        hash = 79 * hash + (this.taxStatus != null ? this.taxStatus.hashCode() : 0);
        return hash;
    }



}

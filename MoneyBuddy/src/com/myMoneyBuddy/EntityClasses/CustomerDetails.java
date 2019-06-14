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
@Table (name ="CUSTOMER_DETAILS")
public class CustomerDetails {

    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CUSTOMER_ID")
    private String customerId;

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
    
    @Column(name="NOMINEE_NAME")
    private String nomineeName;
    
    @Column(name="NOMINEE_RELATIONSHIP")
    private String nomineeRelationship;

    public CustomerDetails() {
        
    }

	public CustomerDetails(String customerId, String gender, String occupation, String dateOfBirth, String addressLineOne,
			String addressLineTwo, String addressLineThree, String residentialCity, String residentialState,
			String residentialPin, String residentialCountry, String taxStatus,String nomineeName, String nomineeRelationship) {
		super();
		this.customerId = customerId;
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
		this.nomineeName = nomineeName;
		this.nomineeRelationship = nomineeRelationship;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public String getNomineeRelationship() {
		return nomineeRelationship;
	}

	public void setNomineeRelationship(String nomineeRelationship) {
		this.nomineeRelationship = nomineeRelationship;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CustomerDetails other = (CustomerDetails) obj;
        if ((this.customerId == null) ? (other.customerId != null) : !this.customerId.equals(other.customerId)) {
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
        if ((this.nomineeName == null) ? (other.nomineeName != null) : !this.nomineeName.equals(other.nomineeName)) {
            return false;
        }
        if ((this.nomineeRelationship == null) ? (other.nomineeRelationship != null) : !this.nomineeRelationship.equals(other.nomineeRelationship)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
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
        hash = 79 * hash + (this.nomineeName != null ? this.nomineeName.hashCode() : 0);
        hash = 79 * hash + (this.nomineeRelationship != null ? this.nomineeRelationship.hashCode() : 0);
        return hash;
    }



}

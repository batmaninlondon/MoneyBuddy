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
    
    @Column(name="PLACE_OF_BIRTH")
    private String placeOfBirth;
    
    @Column(name="COUNTRY_OF_BIRTH")
    private String countryOfBirth;
    
    @Column(name="TAX_RESIDENCY")
    private String taxResidency;
    
    @Column(name="INCOME_SLAB")
    private String incomeSlab;
    
    @Column(name="POLITICALLY_EXPOSED")
    private String politicallyExposed;

    public CustomerDetails() {
        
    }

	public CustomerDetails(String customerId, String gender, String occupation, String dateOfBirth, String addressLineOne,
			String addressLineTwo, String addressLineThree, String residentialCity, String residentialState,
			String residentialPin, String residentialCountry, String taxStatus,String nomineeName, String nomineeRelationship,
			String placeOfBirth, String countryOfBirth, String taxResidency, String incomeSlab, String politicallyExposed) {
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
		this.placeOfBirth = placeOfBirth;
		this.countryOfBirth = countryOfBirth;
		this.taxResidency = taxResidency;
		this.incomeSlab = incomeSlab;
		this.politicallyExposed = politicallyExposed;
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

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	public String getTaxResidency() {
		return taxResidency;
	}

	public void setTaxResidency(String taxResidency) {
		this.taxResidency = taxResidency;
	}

	public String getIncomeSlab() {
		return incomeSlab;
	}

	public void setIncomeSlab(String incomeSlab) {
		this.incomeSlab = incomeSlab;
	}

	public String getPoliticallyExposed() {
		return politicallyExposed;
	}

	public void setPoliticallyExposed(String politicallyExposed) {
		this.politicallyExposed = politicallyExposed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressLineOne == null) ? 0 : addressLineOne.hashCode());
		result = prime * result + ((addressLineThree == null) ? 0 : addressLineThree.hashCode());
		result = prime * result + ((addressLineTwo == null) ? 0 : addressLineTwo.hashCode());
		result = prime * result + ((countryOfBirth == null) ? 0 : countryOfBirth.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((incomeSlab == null) ? 0 : incomeSlab.hashCode());
		result = prime * result + ((nomineeName == null) ? 0 : nomineeName.hashCode());
		result = prime * result + ((nomineeRelationship == null) ? 0 : nomineeRelationship.hashCode());
		result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
		result = prime * result + ((placeOfBirth == null) ? 0 : placeOfBirth.hashCode());
		result = prime * result + ((politicallyExposed == null) ? 0 : politicallyExposed.hashCode());
		result = prime * result + ((residentialCity == null) ? 0 : residentialCity.hashCode());
		result = prime * result + ((residentialCountry == null) ? 0 : residentialCountry.hashCode());
		result = prime * result + ((residentialPin == null) ? 0 : residentialPin.hashCode());
		result = prime * result + ((residentialState == null) ? 0 : residentialState.hashCode());
		result = prime * result + ((taxResidency == null) ? 0 : taxResidency.hashCode());
		result = prime * result + ((taxStatus == null) ? 0 : taxStatus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CustomerDetails other = (CustomerDetails) obj;
		if (addressLineOne == null) {
			if (other.addressLineOne != null) {
				return false;
			}
		} else if (!addressLineOne.equals(other.addressLineOne)) {
			return false;
		}
		if (addressLineThree == null) {
			if (other.addressLineThree != null) {
				return false;
			}
		} else if (!addressLineThree.equals(other.addressLineThree)) {
			return false;
		}
		if (addressLineTwo == null) {
			if (other.addressLineTwo != null) {
				return false;
			}
		} else if (!addressLineTwo.equals(other.addressLineTwo)) {
			return false;
		}
		if (countryOfBirth == null) {
			if (other.countryOfBirth != null) {
				return false;
			}
		} else if (!countryOfBirth.equals(other.countryOfBirth)) {
			return false;
		}
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null) {
				return false;
			}
		} else if (!dateOfBirth.equals(other.dateOfBirth)) {
			return false;
		}
		if (gender == null) {
			if (other.gender != null) {
				return false;
			}
		} else if (!gender.equals(other.gender)) {
			return false;
		}
		if (incomeSlab == null) {
			if (other.incomeSlab != null) {
				return false;
			}
		} else if (!incomeSlab.equals(other.incomeSlab)) {
			return false;
		}
		if (nomineeName == null) {
			if (other.nomineeName != null) {
				return false;
			}
		} else if (!nomineeName.equals(other.nomineeName)) {
			return false;
		}
		if (nomineeRelationship == null) {
			if (other.nomineeRelationship != null) {
				return false;
			}
		} else if (!nomineeRelationship.equals(other.nomineeRelationship)) {
			return false;
		}
		if (occupation == null) {
			if (other.occupation != null) {
				return false;
			}
		} else if (!occupation.equals(other.occupation)) {
			return false;
		}
		if (placeOfBirth == null) {
			if (other.placeOfBirth != null) {
				return false;
			}
		} else if (!placeOfBirth.equals(other.placeOfBirth)) {
			return false;
		}
		if (politicallyExposed == null) {
			if (other.politicallyExposed != null) {
				return false;
			}
		} else if (!politicallyExposed.equals(other.politicallyExposed)) {
			return false;
		}
		if (residentialCity == null) {
			if (other.residentialCity != null) {
				return false;
			}
		} else if (!residentialCity.equals(other.residentialCity)) {
			return false;
		}
		if (residentialCountry == null) {
			if (other.residentialCountry != null) {
				return false;
			}
		} else if (!residentialCountry.equals(other.residentialCountry)) {
			return false;
		}
		if (residentialPin == null) {
			if (other.residentialPin != null) {
				return false;
			}
		} else if (!residentialPin.equals(other.residentialPin)) {
			return false;
		}
		if (residentialState == null) {
			if (other.residentialState != null) {
				return false;
			}
		} else if (!residentialState.equals(other.residentialState)) {
			return false;
		}
		if (taxResidency == null) {
			if (other.taxResidency != null) {
				return false;
			}
		} else if (!taxResidency.equals(other.taxResidency)) {
			return false;
		}
		if (taxStatus == null) {
			if (other.taxStatus != null) {
				return false;
			}
		} else if (!taxStatus.equals(other.taxStatus)) {
			return false;
		}
		return true;
	}



}

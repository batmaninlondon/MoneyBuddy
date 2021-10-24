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
@Table (name ="NRI_CUSTOMER_DETAILS")
public class NriCustomerDetails {

    @Id
    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Column(name="MOBILE_NUMBER")
    private String mobileNumber;
 
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
    
    @Column(name="TAX_IDENTIFICATION_NUMBER")
    private String taxIdentificationNumber;

    public NriCustomerDetails() {
        
    }

	public NriCustomerDetails(String customerId, String mobileNumber, String addressLineOne, String addressLineTwo,
			String addressLineThree, String residentialCity, String residentialState, String residentialPin,
			String residentialCountry, String taxIdentificationNumber) {
		super();
		this.customerId = customerId;
		this.mobileNumber = mobileNumber;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.addressLineThree = addressLineThree;
		this.residentialCity = residentialCity;
		this.residentialState = residentialState;
		this.residentialPin = residentialPin;
		this.residentialCountry = residentialCountry;
		this.taxIdentificationNumber = taxIdentificationNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public String getTaxIdentificationNumber() {
		return taxIdentificationNumber;
	}

	public void setTaxIdentificationNumber(String taxIdentificationNumber) {
		this.taxIdentificationNumber = taxIdentificationNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressLineOne == null) ? 0 : addressLineOne.hashCode());
		result = prime * result + ((addressLineThree == null) ? 0 : addressLineThree.hashCode());
		result = prime * result + ((addressLineTwo == null) ? 0 : addressLineTwo.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((residentialCity == null) ? 0 : residentialCity.hashCode());
		result = prime * result + ((residentialCountry == null) ? 0 : residentialCountry.hashCode());
		result = prime * result + ((residentialPin == null) ? 0 : residentialPin.hashCode());
		result = prime * result + ((residentialState == null) ? 0 : residentialState.hashCode());
		result = prime * result + ((taxIdentificationNumber == null) ? 0 : taxIdentificationNumber.hashCode());
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
		NriCustomerDetails other = (NriCustomerDetails) obj;
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
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		if (mobileNumber == null) {
			if (other.mobileNumber != null) {
				return false;
			}
		} else if (!mobileNumber.equals(other.mobileNumber)) {
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
		if (taxIdentificationNumber == null) {
			if (other.taxIdentificationNumber != null) {
				return false;
			}
		} else if (!taxIdentificationNumber.equals(other.taxIdentificationNumber)) {
			return false;
		}
		return true;
	}

}

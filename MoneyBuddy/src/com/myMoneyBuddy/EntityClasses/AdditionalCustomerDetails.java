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
@Table (name ="ADDITIONAL_CUSTOMER_DETAILS")
public class AdditionalCustomerDetails {

    @Id
    @Column(name="CUSTOMER_ID")
    private String customerId;
    
    @Column (name="FATHER_NAME")
    private String fatherName;

    @Column(name="MARITAL_STATUS")
    private String maritalStatus;

    @Column(name="NATIONALITY")
    private String nationality;

    @Column(name="STATUS")
    private String status;
    
    @Column(name="GROSS_ANNUAL_INCOME")
    private String grossAnnualIncome;
    
    @Column(name="POLITICALLY_EXPOSED")
    private String politicallyExposed;
    
    public AdditionalCustomerDetails() {
        
    }

	public AdditionalCustomerDetails(String customerId, String fatherName, String maritalStatus, String nationality,
			String status, String grossAnnualIncome, String politicallyExposed) {
		super();
		this.customerId = customerId;
		this.fatherName = fatherName;
		this.maritalStatus = maritalStatus;
		this.nationality = nationality;
		this.status = status;
		this.grossAnnualIncome = grossAnnualIncome;
		this.politicallyExposed = politicallyExposed;
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
        if ((this.maritalStatus == null) ? (other.maritalStatus != null) : !this.maritalStatus.equals(other.maritalStatus)) {
            return false;
        }
        if ((this.nationality == null) ? (other.nationality != null) : !this.nationality.equals(other.nationality)) {
            return false;
        }
        if ((this.status == null) ? (other.status != null) : !this.status.equals(other.status)) {
            return false;
        }
        if ((this.grossAnnualIncome == null) ? (other.grossAnnualIncome != null) : !this.grossAnnualIncome.equals(other.grossAnnualIncome)) {
            return false;
        }
        if ((this.politicallyExposed == null) ? (other.politicallyExposed != null) : !this.politicallyExposed.equals(other.politicallyExposed)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 79 * hash + (this.fatherName != null ? this.fatherName.hashCode() : 0);
        hash = 79 * hash + (this.maritalStatus != null ? this.maritalStatus.hashCode() : 0);
        hash = 79 * hash + (this.nationality != null ? this.nationality.hashCode() : 0);
        hash = 79 * hash + (this.status != null ? this.status.hashCode() : 0);
        hash = 79 * hash + (this.grossAnnualIncome != null ? this.grossAnnualIncome.hashCode() : 0);
        hash = 79 * hash + (this.politicallyExposed != null ? this.politicallyExposed.hashCode() : 0);
        return hash;
    }



}

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
@Table (name ="BANK_DETAILS")
public class BankDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="BANK_DETAILS_ID")
    private String bankDetailsId;
    
    @Column (name="CUSTOMER_ID")
    private String customerId;
    
    @Column(name="BANK_NAME")
    private String bankName;
    
    @Column(name="ACCOUNT_TYPE")
    private String accountType;
    
    @Column (name="ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name="IFSC_CODE")
    private String ifscCode;

    @Column(name="UPDATE_DATE")
    private String updateDate;


    public BankDetails() {
        
    }

	public BankDetails(String customerId, String bankName,  String accountType, String accountNumber, String ifscCode, String updateDate) {
		super();
		this.customerId = customerId;
		this.bankName = bankName;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.updateDate = updateDate;
	}

	public String getBankDetailsId() {
		return bankDetailsId;
	}


	public void setBankDetailsId(String bankDetailsId) {
		this.bankDetailsId = bankDetailsId;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getIfscCode() {
		return ifscCode;
	}


	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}


	public String getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}


	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }	

        final BankDetails other = (BankDetails) obj;
        if ((this.bankDetailsId == null) ? (other.bankDetailsId != null) : !this.bankDetailsId.equals(other.bankDetailsId)) {
            return false;
        }
        if ((this.customerId == null) ? (other.customerId != null) : !this.customerId.equals(other.customerId)) {
            return false;
        }
        if ((this.bankName == null) ? (other.bankName != null) : !this.bankName.equals(other.bankName)) {
            return false;
        }
        if ((this.accountType == null) ? (other.accountType != null) : !this.accountType.equals(other.accountType)) {
            return false;
        }
        if ((this.accountNumber == null) ? (other.accountNumber != null) : !this.accountNumber.equals(other.accountNumber)) {
            return false;
        }
        if ((this.ifscCode == null) ? (other.ifscCode != null) : !this.ifscCode.equals(other.ifscCode)) {
            return false;
        }
        if ((this.updateDate == null) ? (other.updateDate != null) : !this.updateDate.equals(other.updateDate)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.bankDetailsId != null ? this.bankDetailsId.hashCode() : 0);
        hash = 79 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 79 * hash + (this.bankName != null ? this.bankName.hashCode() : 0);
        hash = 79 * hash + (this.accountType != null ? this.accountType.hashCode() : 0);
        hash = 79 * hash + (this.accountNumber != null ? this.accountNumber.hashCode() : 0);
        hash = 79 * hash + (this.ifscCode != null ? this.ifscCode.hashCode() : 0);
        hash = 79 * hash + (this.updateDate != null ? this.updateDate.hashCode() : 0);
        return hash;
    }



}

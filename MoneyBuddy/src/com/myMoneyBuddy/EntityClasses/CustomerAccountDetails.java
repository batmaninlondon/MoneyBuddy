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
@Table (name ="CUSTOMER_ACCOUNT_DETAILS")
public class CustomerAccountDetails {

    @Id
    @Column(name="TRANSACTION_ID")
    private String transactionId;;
    
    @Column(name="CUSTOMER_ID")
    private String customerId;;
    
    @Column (name="BANK_NAME")
    private String bankName;;

    @Column (name="ACCOUNT_NUMBER")
    private String accountNumber;;

    @Column(name="ACCOUNT_PASSWORD")
    private String accountPassword;

    @Column(name="CVV_NUMBER")
    private String cvvNumber;
    
    
    @Column(name="TRANSACTION_DATE")
    private String transactionDate;
    
    @Column(name="UPDATE_DATE")
    private String updateDate;


    public CustomerAccountDetails() {
        
    }



	public CustomerAccountDetails(String transactionId, String customerId,
			String bankName, String accountNumber, String accountPassword,
			String cvvNumber, String transactionDate, String updateDate) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.accountPassword = accountPassword;
		this.cvvNumber = cvvNumber;
		this.transactionDate = transactionDate;
		this.updateDate = updateDate;
	}



	public String getTransactionDate() {
		return transactionDate;
	}



	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}



	public String getUpdateDate() {
		return updateDate;
	}



	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}



	public String getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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



	public String getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public String getAccountPassword() {
		return accountPassword;
	}



	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}



	public String getCvvNumber() {
		return cvvNumber;
	}



	public void setCvvNumber(String cvvNumber) {
		this.cvvNumber = cvvNumber;
	}



	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CustomerAccountDetails other = (CustomerAccountDetails) obj;
        if ((this.transactionId == null) ? (other.transactionId != null) : !this.transactionId.equals(other.transactionId)) {
            return false;
        }
        if ((this.customerId == null) ? (other.customerId != null) : !this.customerId.equals(other.customerId)) {
            return false;
        }
        if ((this.bankName == null) ? (other.bankName != null) : !this.bankName.equals(other.bankName)) {
            return false;
        }
        if ((this.accountNumber == null) ? (other.accountNumber != null) : !this.accountNumber.equals(other.accountNumber)) {
            return false;
        }
        if ((this.accountPassword == null) ? (other.accountPassword != null) : !this.accountPassword.equals(other.accountPassword)) {
            return false;
        }
        if ((this.cvvNumber == null) ? (other.cvvNumber != null) : !this.cvvNumber.equals(other.cvvNumber)) {
            return false;
        }
        if ((this.transactionDate == null) ? (other.transactionDate != null) : !this.transactionDate.equals(other.transactionDate)) {
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
        hash = 79 * hash + (this.transactionId != null ? this.transactionId.hashCode() : 0);
        hash = 79 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 79 * hash + (this.bankName != null ? this.bankName.hashCode() : 0);
        hash = 79 * hash + (this.accountNumber != null ? this.accountNumber.hashCode() : 0);
        hash = 79 * hash + (this.accountPassword != null ? this.accountPassword.hashCode() : 0);
        hash = 79 * hash + (this.cvvNumber != null ? this.cvvNumber.hashCode() : 0);
        hash = 79 * hash + (this.transactionDate != null ? this.transactionDate.hashCode() : 0);
        hash = 79 * hash + (this.updateDate != null ? this.updateDate.hashCode() : 0);
        return hash;
    }



}

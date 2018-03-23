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
@Table (name ="CUSTOMER_PASSWORDS_HISTORY")
public class CustomerPasswordsHistory {

    @Id
    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Column(name="PASSWORD")
    private String password;

    @Column (name="OLD_PASSWORD")
    private String old_password;


    public CustomerPasswordsHistory() {
    
    }
    public CustomerPasswordsHistory(String customerId, String password,String old_password) {
        this.customerId = customerId;
        this.password=password;
        this.old_password = old_password;
    }


    public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CustomerPasswordsHistory other = (CustomerPasswordsHistory) obj;
        if ((this.customerId == null) ? (other.customerId != null) : !this.customerId.equals(other.customerId)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if ((this.old_password == null) ? (other.old_password != null) : !this.old_password.equals(other.old_password)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 73 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = 73 * hash + (this.old_password != null ? this.old_password.hashCode() : 0);
        return hash;
    }


}
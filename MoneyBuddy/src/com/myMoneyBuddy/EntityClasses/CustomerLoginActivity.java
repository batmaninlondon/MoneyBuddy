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
@Table(name="CUSTOMER_LOGIN_ACTIVITY")
public class CustomerLoginActivity {

    @Id
    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Column (name="LAST_LOGIN_TIMESTAMP")
    private String lastLoginTimestamp;

    @Column (name="CURRENT_LOGIN_TIMESTAMP")
    private String currentLoginTimestamp;

    public CustomerLoginActivity() {

    }

    public CustomerLoginActivity(String customerId,String lastLoginTimestamp, String currentLoginTimestamp) {
        this.customerId=customerId;
        this.lastLoginTimestamp=lastLoginTimestamp;
        this.currentLoginTimestamp=currentLoginTimestamp;
    }

    public String getCurrentLoginTimestamp() {
        return currentLoginTimestamp;
    }

    public void setCurrentLoginTimestamp(String currentLoginTimestamp) {
        this.currentLoginTimestamp = currentLoginTimestamp;
    }

    public String getLastLoginTimestamp() {
        return lastLoginTimestamp;
    }

    public void setLastLoginTimestamp(String lastLoginTimestamp) {
        this.lastLoginTimestamp = lastLoginTimestamp;
    }

    public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CustomerLoginActivity other = (CustomerLoginActivity) obj;
        if ((this.customerId == null) ? (other.customerId != null) : !this.customerId.equals(other.customerId)) {
            return false;
        }
        if ((this.lastLoginTimestamp == null) ? (other.lastLoginTimestamp != null) : !this.lastLoginTimestamp.equals(other.lastLoginTimestamp)) {
            return false;
        }
        if ((this.currentLoginTimestamp == null) ? (other.currentLoginTimestamp != null) : !this.currentLoginTimestamp.equals(other.currentLoginTimestamp)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 67 * hash + (this.lastLoginTimestamp != null ? this.lastLoginTimestamp.hashCode() : 0);
        hash = 67 * hash + (this.currentLoginTimestamp != null ? this.currentLoginTimestamp.hashCode() : 0);
        return hash;
    }


}

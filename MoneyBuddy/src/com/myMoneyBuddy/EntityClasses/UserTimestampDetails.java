/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.EntityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */

@Entity
@Table(name="USER_TIMESTAMP_DETAILS")
public class UserTimestampDetails {

    @Id
    @Column(name="EMAIL")
    private String email;

    @Column (name="LAST_LOGIN_TIMESTAMP")
    private String lastLoginTimestamp;

    @Column (name="CURRENT_LOGIN_TIMESTAMP")
    private String currentLoginTimestamp;

    public UserTimestampDetails() {

    }

    public UserTimestampDetails(String email,String lastLoginTimestamp, String currentLoginTimestamp) {
        this.email=email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserTimestampDetails other = (UserTimestampDetails) obj;
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
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
        hash = 67 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 67 * hash + (this.lastLoginTimestamp != null ? this.lastLoginTimestamp.hashCode() : 0);
        hash = 67 * hash + (this.currentLoginTimestamp != null ? this.currentLoginTimestamp.hashCode() : 0);
        return hash;
    }


}

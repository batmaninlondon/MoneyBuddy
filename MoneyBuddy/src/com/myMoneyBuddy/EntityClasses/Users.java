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
@Table (name ="USERS")
public class Users {

    @Id
    @Column(name="EMAIL")
    private String email;
    
    @Column (name="FIRSTNAME")
    private String firstName;

    @Column (name="LASTNAME")
    private String lastName;

    @Column(name="MOBILE")
    private String mobile;

    @Column(name="HASH")
    private String hash;

    @Column(name="VERIFIED")
    private String verified;

    public Users() {
        
    }

    public Users(String firstName,String lastName, String email, String mobile, String hash, String verified) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.hash = hash;
        this.verified = verified;
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName)) {
            return false;
        }
        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName)) {
            return false;
        }
        if ((this.mobile == null) ? (other.mobile != null) : !this.mobile.equals(other.mobile)) {
            return false;
        }
        if ((this.hash == null) ? (other.hash != null) : !this.hash.equals(other.hash)) {
            return false;
        }
        if ((this.verified == null) ? (other.verified != null) : !this.verified.equals(other.verified)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 79 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 79 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 79 * hash + (this.mobile != null ? this.mobile.hashCode() : 0);
        hash = 79 * hash + (this.hash != null ? this.hash.hashCode() : 0);
        hash = 79 * hash + (this.verified != null ? this.verified.hashCode() : 0);
        return hash;
    }



}

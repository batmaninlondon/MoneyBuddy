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
@Table (name ="USER_PASSWORDS")
public class UserPasswords {

    @Id
    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;

    @Column (name="OLD_PASSWORD")
    private String old_password;


    public UserPasswords() {
    
    }
    public UserPasswords(String email, String password,String old_password) {
        this.email = email;
        this.password=password;
        this.old_password = old_password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        final UserPasswords other = (UserPasswords) obj;
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
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
        hash = 73 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 73 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = 73 * hash + (this.old_password != null ? this.old_password.hashCode() : 0);
        return hash;
    }


}
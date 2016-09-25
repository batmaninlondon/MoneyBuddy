/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.queryClasses.QueryUser;
import com.myMoneyBuddy.queryClasses.UpdateOldPassword;
import com.myMoneyBuddy.queryClasses.UpdateUserPassword;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
/**
 *
 * @author Savita Wadhwani
 */

public class ResetPasswordAction extends ActionSupport{
    private String email;
    private String hash;
    private String newPassword;
    private String confirmPassword;

    HttpServletRequest request;
    //public final String MAIL_ForgotPassword_SITE_LINK = "http://localhost:8080/MoneyBuddy/forgottenPassword.jsp";

    QueryUser user = new QueryUser();

    @Override
    public void validate()  {
         if(StringUtils.isEmpty(getNewPassword())  )
            addFieldError("newPassword","Password can't be blank!");

         else if(StringUtils.isEmpty(getConfirmPassword())  )
            addFieldError("confirmPassword","Password can't be blank!");
         else if(!getNewPassword().equals(getConfirmPassword())  )
            addFieldError("confirmPassword","The Password do not match.");
    }

    @Override
        public String execute() {
        
            System.out.println(" Inside ResetPasswordAction: Value of hash : "+getHash());
            System.out.println(" Inside ResetPasswordAction: Value of email : "+getEmail());
            //Set the current password as the old password
            UpdateOldPassword updateOldPassword = new UpdateOldPassword();
            updateOldPassword.updateOldPassword(getEmail());

            //Update the password for the user
            UpdateUserPassword updateUserPassword = new UpdateUserPassword();
            updateUserPassword.UpdatePassword(getEmail(), getNewPassword());
            return SUCCESS;
    }

    	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return this.request;
	}
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}

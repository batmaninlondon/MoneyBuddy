package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.queryClasses.QueryUser;
import com.myMoneyBuddy.queryClasses.UpdateCurrentLoginTimestamp;
import com.myMoneyBuddy.queryClasses.UpdateLastLoginTimestamp;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator.Failure;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Savita Wadhwani
 */
public class LoginAction extends ActionSupport{

    private String email;
    private String password;
    QueryUser user = new QueryUser();

    public void validate() {
        if(StringUtils.isEmpty(getEmail()) )
            addFieldError("email","Email Id can't be blank!");
        
        else if (!user.existsUser(getEmail()))
            addFieldError("email"," Email does not exists.");

        else if ( StringUtils.isEmpty(getPassword()))
            addFieldError("password","Password can't be blank");
        else if(!user.getPasswordForUser(getEmail()).equals(getPassword())) {
            addFieldError("email"," Email Id and password doesn't match.");
        }
    }
    public String execute() {

        System.out.println(" Inside login action extimate()");

            if (user.getVerifiedStatusForUser(getEmail()).equalsIgnoreCase("NO"))  {
                return ERROR;
            }

            // Updating Last login timestamp
            UpdateLastLoginTimestamp lastLogin = new UpdateLastLoginTimestamp();
            lastLogin.UpdateLastLoginTimestamp(getEmail());

            // Update Current login timestamp
            UpdateCurrentLoginTimestamp currentLogin = new UpdateCurrentLoginTimestamp();
            currentLogin.UpdateCurrentLoginTimestamp(getEmail());

            return SUCCESS;


    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

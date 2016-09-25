/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.mailerClasses.DesEncrypter;
import com.myMoneyBuddy.mailerClasses.sendMail;
import com.myMoneyBuddy.queryClasses.QueryUser;
import com.myMoneyBuddy.queryClasses.UpdateCurrentLoginTimestamp;
import com.myMoneyBuddy.queryClasses.insertUser;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Savita Wadhwani
 */
public class RegisterAction extends ActionSupport{

    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String email;
    private String mobile;
    public final String MAIL_ForgotPassword_SITE_LINK = "http://localhost:8080/MoneyBuddy/userVerification.jsp";
    QueryUser user = new QueryUser();
    insertUser newUser = new insertUser();
    

    String regexEmail = "^(.+)@(.+)$";
    String regexMobile = "\\d+";
    Pattern patternEmail = Pattern.compile(regexEmail);
    Pattern patternMobile = Pattern.compile(regexMobile);

    public void validate() {
        if ( StringUtils.isEmpty(getFirstName()) )
            addFieldError("firstName","first name can't be blank");
        else if (StringUtils.isEmpty(getLastName()))
            addFieldError("lastName"," last name can't be blank.");
        else if ( StringUtils.isEmpty(getPassword())) 
            addFieldError("password","Password can't be blank");
        else if ( StringUtils.isEmpty(getConfirmPassword()))
            addFieldError("confirmPassword","Confirm Password can't be blank");
        else if (!getPassword().equals(getConfirmPassword()))
            addFieldError("confirmPassword","Confirm password doesn't match with the above password");
        else  if (StringUtils.isEmpty(getEmail()) )
            addFieldError("email","Email can't be blank");
        else if (!patternEmail.matcher(email).matches())
            addFieldError("email","Please enter a valid emil address");
        else if (user.existsUser(getEmail()))
            addFieldError("emailId"," User already exists. Please choose a different email Id");
        else if( StringUtils.isEmpty(getMobile()))
            addFieldError("mobile","Mobile No. can't be blank");
        else if (getMobile().length()!=10)
            addFieldError("mobile","Please enter a valid mobile number");
        else if (!patternMobile.matcher(mobile).matches())
            addFieldError("mobile","Please enter a valid mobile number");

    }
    public String execute() {
        DesEncrypter desEncrypter = new DesEncrypter(getEmail());
        String hash = desEncrypter.encrypt(getPassword());
        String subject="[MoneyBuddy] Please verify your email address.";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String frmtdDate = dateFormat.format(date);

        
        newUser.insertUser(getFirstName(), getLastName(), getPassword(), getEmail(), getMobile(),hash,"NO");
        sendMail sendMail = new sendMail();
        System.out.println(" Calling send email function from register user.");
        //email.sendEmail("savita.wadhwani@gmail.com", "Test mail", "Hi there from java code.");
        System.out.println(" email id is : "+getEmail());
                   String link = MAIL_ForgotPassword_SITE_LINK+"?hash="+hash;
           //link = link+"?hash="+hash;
           StringBuilder bodyText = new StringBuilder();
            bodyText.append("<div>")
                 .append("  Dear User<br/><br/>")
                 .append("  Thank you for registration. Your mail ("+getEmail()+") is under verification<br/>")
                 .append("  Please click <a href=\""+link+"\">here</a> or open below link in browser<br/>")
                 .append("  <a href=\""+link+"\">"+link+"</a>")
                 .append("  <br/><br/>")
                 .append("  Thanks,<br/>")
                 .append("  SodhanaLibrary Team")
                 .append("</div>");

        sendMail.MailSending(getEmail(),hash,link,bodyText,subject);
        System.out.println(" send email function completed from register user.");
        return SUCCESS;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.mailerClasses.sendMail;
import com.myMoneyBuddy.queryClasses.QueryUser;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
/**
 *
 * @author Savita Wadhwani
 */
public class ForgotPasswordAction extends ActionSupport{
    private String email;

    public final String MAIL_ResetPassword_SITE_LINK = "http://localhost:8080/MoneyBuddy/resetPassword.jsp";

    QueryUser user = new QueryUser();

    @Override
    public void validate()  {
                if(StringUtils.isEmpty(getEmail()) )
            addFieldError("userId","User Id can't be blank!");

        else if (!user.existsUser(getEmail()))
            addFieldError("userId"," User does not exists.");
    }

    @Override
        public String execute() {

            String subject="Reset your MoneyBuddy password.";
            System.out.println(" Inside execute.");
            sendMail sendmail = new sendMail();
            System.out.println(" Email id passed to execute is : "+email);
            String hash = user.getHashForUser(getEmail());
            System.out.println(" Hash code for this email is : "+hash);
           String link = MAIL_ResetPassword_SITE_LINK+"?email="+email+"&hash="+hash;
           StringBuilder bodyText = new StringBuilder();
            bodyText.append("<div>")
                 .append(" <br/><br/> <h1>Dear User</h1><br/><br/>")
                 .append("  <p>Here's the link you requested to reset your MoneyBuddy password.</p><br/><br/><br/>")
                 .append(" <h3> Please click <a href=\""+link+"\">here</a> or open below link in browser</h3><br/><br/>")
                 .append("  <a href=\""+link+"\">"+link+"</a>")
                 .append("  <br/><br/><br/><p>If you didn't request a password reset, please ignore this message and your password will stay the same.</p><br/><br/> <br/>")
                 .append("  <h3>Thanks,</h3><br/><br/>")
                 .append("  <h3>MoneyBuddy Team</h3>")
                 .append("</div>");
            System.out.println(" Sending mail from  execute.");
             sendmail.MailSending(getEmail(), hash, link, bodyText,subject);
             System.out.println(" Mail sent from execute execute.");
            return SUCCESS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

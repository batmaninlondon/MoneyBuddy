/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.queryClasses;

/**
 *
 * @author Savita Wadhwani
 */


import com.myMoneyBuddy.EntityClasses.UserPasswords;
import com.myMoneyBuddy.EntityClasses.UserTimestampDetails;
import com.myMoneyBuddy.EntityClasses.Users;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class insertUser {

    public void insertUser (String firstName,String lastName,String password, String email, String mobile,String hash,String verified){

    SessionFactory factoryUsers = new AnnotationConfiguration()
                                    .configure()
                                    .addAnnotatedClass(Users.class)
                                    .buildSessionFactory();
            //addAnnotationClass(Company.class).buildSessionFactory();
    Session sessionUsers = factoryUsers.openSession();

    SessionFactory factoryUserPasswords = new AnnotationConfiguration()
                                    .configure()
                                    .addAnnotatedClass(UserPasswords.class)
                                    .buildSessionFactory();
            //addAnnotationClass(Company.class).buildSessionFactory();
    Session sessionUserPasswords = factoryUserPasswords.openSession();

    SessionFactory factoryUserTimestamp = new AnnotationConfiguration()
                                    .configure()
                                    .addAnnotatedClass(UserTimestampDetails.class)
                                    .buildSessionFactory();
            //addAnnotationClass(Company.class).buildSessionFactory();
    Session sessionUserTimestamp = factoryUserTimestamp.openSession();

    try {
        System.out.println(" Hi There from insertUser1 1");

        Users tempUser = new Users(firstName,lastName,email,mobile,hash,verified);
        System.out.println(" Hi There from insertUser1 2");
        sessionUsers.beginTransaction();
        sessionUsers.save(tempUser);
        sessionUsers.getTransaction().commit();

        
        UserPasswords tempUserPasswords = new UserPasswords(email,password,null);
        System.out.println(" Hi There from insertUser1 3");
        sessionUserPasswords.beginTransaction();
        System.out.println(" Hi There from insertUser1 4");
        sessionUserPasswords.save(tempUserPasswords);
        
        sessionUserPasswords.getTransaction().commit();
        System.out.println(" Hi There from insertUser1 5");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String frmtdDate = dateFormat.format(date);

        UserTimestampDetails tempUserTimeDetails = new UserTimestampDetails(email,null,frmtdDate);
        System.out.println(" Hi There from insertUser1 6");
        sessionUserTimestamp.beginTransaction();
        sessionUserTimestamp.save(tempUserTimeDetails);
        sessionUserTimestamp.getTransaction().commit();

        System.out.println(" Hi There from insertUser1 7");
        
    }
    finally {
        factoryUsers.close();
        factoryUserPasswords.close();
    }

    }


}


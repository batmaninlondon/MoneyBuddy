/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.queryClasses;

/**
 *
 * @author Savita Wadhwani
 */


import com.myMoneyBuddy.EntityClasses.Users;
import java.net.URL;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class UpdateUserVerification {

    public void UserVerification (String hash){

    //String hash = url.getQuery();

    //session.getTransaction().begin();



    SessionFactory factory = new AnnotationConfiguration()
                                    .configure()
                                    .addAnnotatedClass(Users.class)
                                    .buildSessionFactory();
            //addAnnotationClass(Company.class).buildSessionFactory();
    Session session = factory.openSession();

    try {
        System.out.println("hello from java : value of hash : "+hash);
        System.out.println(" Hi There from CreateCompanyDemo 1");

        //Users tempUser = new Users(userId,password,email,mobile);
        //System.out.println(" Hi There from CreateCompanyDemo 2");
        session.beginTransaction();
System.out.println(" Hi There from CreateCompanyDemo 2");
        Query query = session.createQuery("update Users set verified = :status" + " where hash = :hash");
System.out.println(" Hi There from CreateCompanyDemo 3");
        query.setParameter("status", "YES");
        System.out.println(" Hi There from CreateCompanyDemo 4");
        query.setParameter("hash", hash);
        System.out.println(" Hi There from CreateCompanyDemo 5");
        int result = query.executeUpdate();
        System.out.println(" Hi There from CreateCompanyDemo 6");


        //System.out.println(" Hi There from CreateCompanyDemo 3");
        //session.save(tempUser);
        //System.out.println(" Hi There from CreateCompanyDemo 4");
        session.getTransaction().commit();
        //System.out.println(" Hi There from CreateCompanyDemo 5");
    }
    finally {
        factory.close();
    }

    }


}


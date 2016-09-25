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
import com.myMoneyBuddy.EntityClasses.Users;
import java.net.URL;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class UpdateUserPassword {

    public void UpdatePassword (String email,String newPassword){

    //String hash = url.getQuery();

    //session.getTransaction().begin();



    SessionFactory factory = new AnnotationConfiguration()
                                    .configure()
                                    .addAnnotatedClass(UserPasswords.class)
                                    .buildSessionFactory();
            //addAnnotationClass(Company.class).buildSessionFactory();
    Session session = factory.openSession();

    try {

        session.beginTransaction();
        Query query = session.createQuery("update UserPasswords set password = :newPassword" + " where email = :email");

        query.setParameter("newPassword", newPassword);
        
        query.setParameter("email", email);
        
        int result = query.executeUpdate();
        session.getTransaction().commit();

    }
    finally {
        factory.close();
    }

    }


}


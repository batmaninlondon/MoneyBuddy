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
import javax.servlet.SessionTrackingMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class UpdateOldPassword {

    public void updateOldPassword (String email){

    SessionFactory factory = new AnnotationConfiguration()
                                    .configure()
                                    .addAnnotatedClass(UserPasswords.class)
                                    .buildSessionFactory();

    Session session = factory.openSession();

    try {

        session.beginTransaction();
        Query query = session.createQuery("update UserPasswords set old_password = password" + " where email = :email");

        query.setParameter("email", email);

        int result = query.executeUpdate();
        session.getTransaction().commit();

    }
    finally {
        factory.close();

    }

    }


}


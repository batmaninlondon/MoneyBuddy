/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.queryClasses;

/**
 *
 * @author Savita Wadhwani
 */


import com.myMoneyBuddy.EntityClasses.UserTimestampDetails;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class UpdateLastLoginTimestamp {

    public void UpdateLastLoginTimestamp (String email){

    //String hash = url.getQuery();

    //session.getTransaction().begin();



    SessionFactory factory = new AnnotationConfiguration()
                                    .configure()
                                    .addAnnotatedClass(UserTimestampDetails.class)
                                    .buildSessionFactory();
            //addAnnotationClass(Company.class).buildSessionFactory();
    Session session = factory.openSession();

    try {

        session.beginTransaction();

        UserTimestampDetails userTimestampDetails = (UserTimestampDetails)session.get(UserTimestampDetails.class,email);
        String  currentTime = userTimestampDetails.getCurrentLoginTimestamp();

        Query query = session.createQuery("update UserTimestampDetails set lastLoginTimestamp = :lastLoginTimestamp" + " where email = :email");

        query.setParameter("lastLoginTimestamp", currentTime);
        
        query.setParameter("email", email);
        
        int result = query.executeUpdate();
        session.getTransaction().commit();

    }
    finally {
        factory.close();
    }

    }


}


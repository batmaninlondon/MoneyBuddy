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


public class UpdateCurrentLoginTimestamp {

    public void UpdateCurrentLoginTimestamp (String email){

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
        //Query query = session.createQuery("update UserTimestampDetails set currentLoginTimestamp = :currentLoginTimestamp" + " where email = :email");

        Query query = session.createQuery("update UserTimestampDetails set currentLoginTimestamp = :currentLoginTimestamp" + " where email = :email");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String frmtdDate = dateFormat.format(date);
        System.out.println(" value of date : "+frmtdDate);

        query.setParameter("currentLoginTimestamp", frmtdDate);
        
        query.setParameter("email", email);
        
        int result = query.executeUpdate();
        session.getTransaction().commit();

    }
    finally {
        factory.close();
    }

    }


}


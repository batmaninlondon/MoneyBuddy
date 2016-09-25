package com.myMoneyBuddy.queryClasses;

/**
 *
 * @author Savita Wadhwani
 */

import com.myMoneyBuddy.EntityClasses.KycStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class QueryKycStatus {

    public String getStatusForPanCard(String panCard) {
                SessionFactory factory = new AnnotationConfiguration()
                                        .configure()
                                        .addAnnotatedClass(KycStatus.class)
                                        .buildSessionFactory();
        Session session = factory.openSession();

        try
        {
            session.beginTransaction();
            //Query query = session.createQuery("from Users where userId=:id");
            //query.setParameter("id","userId");
            //List<Users> user = query.list();
            KycStatus kyc = (KycStatus)session.get(KycStatus.class,panCard);
            String status = kyc.getStatus();
            System.out.println(" Status : "+ status);
            //System.out.println(" Company Name 2 : "+ theCompany.get(1).getName());
            
            session.getTransaction().commit();
            return status;
        }
        finally {
            factory.close();
        }
        
    }

    public boolean existsPanCard(String panCard) {
                SessionFactory factory = new AnnotationConfiguration()
                                        .configure()
                                        .addAnnotatedClass(KycStatus.class)
                                        .buildSessionFactory();
        Session session = factory.openSession();

        try
        {
            session.beginTransaction();
            System.out.println("PAN Card : "+panCard);
            KycStatus kyc = (KycStatus)session.get(KycStatus.class,panCard);
            if (kyc == null ) {
                System.out.println(" Pan Card does not exists.");
                return false;
            }

            session.getTransaction().commit();
            return true;
        }
        catch ( Exception e) {
            System.out.println("Caught Exception!!");
            return false;
        }
        finally {
            factory.close();
        }

    }
}

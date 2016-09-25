package com.myMoneyBuddy.queryClasses;

/**
 *
 * @author Savita Wadhwani
 */

import com.myMoneyBuddy.EntityClasses.UserPasswords;
import com.myMoneyBuddy.EntityClasses.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class QueryUser {

    public static void main(String args[]) {


    }

    public String getPasswordForUser(String email) {
                SessionFactory factory = new AnnotationConfiguration()
                                        .configure()
                                        .addAnnotatedClass(UserPasswords.class)
                                        .buildSessionFactory();
        Session session = factory.openSession();

        try
        {
            session.beginTransaction();
            //Query query = session.createQuery("from Users where userId=:id");
            //query.setParameter("id","userId");
            //List<Users> user = query.list();
            UserPasswords user = (UserPasswords)session.get(UserPasswords.class,email);
            String password = user.getPassword();
            System.out.println(" Password : "+ password);
            //System.out.println(" Company Name 2 : "+ theCompany.get(1).getName());
            
            session.getTransaction().commit();
            return password;
        }
        finally {
            factory.close();
        }
        
    }

        public String getHashForUser(String email) {
                SessionFactory factory = new AnnotationConfiguration()
                                        .configure()
                                        .addAnnotatedClass(Users.class)
                                        .buildSessionFactory();
        Session session = factory.openSession();

        try
        {
            session.beginTransaction();
            //Query query = session.createQuery("from Users where userId=:id");
            //query.setParameter("id","userId");
            //List<Users> user = query.list();
            Users user = (Users)session.get(Users.class,email);
            String hash = user.getHash();
            System.out.println(" Hash : "+ hash);
            //System.out.println(" Company Name 2 : "+ theCompany.get(1).getName());

            session.getTransaction().commit();
            return hash;
        }
        finally {
            factory.close();
        }

    }

        public String getVerifiedStatusForUser(String email) {
                SessionFactory factory = new AnnotationConfiguration()
                                        .configure()
                                        .addAnnotatedClass(Users.class)
                                        .buildSessionFactory();
        Session session = factory.openSession();

        try
        {
            session.beginTransaction();
            //Query query = session.createQuery("from Users where userId=:id");
            //query.setParameter("id","userId");
            //List<Users> user = query.list();
            Users user = (Users)session.get(Users.class,email);
            String verified = user.getVerified();
            System.out.println(" Varified Status : "+ verified);
            //System.out.println(" Company Name 2 : "+ theCompany.get(1).getName());

            session.getTransaction().commit();
            return verified;
        }
        finally {
            factory.close();
        }

    }

        public boolean existsUser(String email) {
                SessionFactory factory = new AnnotationConfiguration()
                                        .configure()
                                        .addAnnotatedClass(Users.class)
                                        .buildSessionFactory();
        Session session = factory.openSession();

        try
        {
            session.beginTransaction();
            System.out.println("Email id is : "+email);
            Users user = (Users)session.get(Users.class,email);
            if (user == null ) {
                System.out.println(" user does not exists.");
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

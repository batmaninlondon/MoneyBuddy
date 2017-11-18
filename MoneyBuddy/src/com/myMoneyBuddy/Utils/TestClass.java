package com.myMoneyBuddy.Utils;


import org.hibernate.Session;

import com.myMoneyBuddy.Utils.HibernateUtil;

public class TestClass {

	public static void main(String[] args) {
		
		//Get Session
		Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		//session.save(emp);
		//Commit transaction
		session.getTransaction().commit();
		//System.out.println("Employee ID="+emp.getId());
		
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionAnnotationFactory().close();
	}

}
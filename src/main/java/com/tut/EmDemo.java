package com.tut;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student student1=new Student();
		student1.setId(14134);
		student1.setName("Ankit Tiwari");
		student1.setCity("LKO");
		
		Student student2=new Student();
		student1.setId(1413);
		student1.setName("Ravi Tiwari");
		student1.setCity("DELHI");
		
		Certificate certificate=new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration("2 months");
		
		Certificate certificate1=new Certificate();
		certificate1.setCourse("Hibernate");
		certificate1.setDuration("2.5 months");
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		//objects save:
		s.save(student1);
		s.save(student2);
		
		tx.commit();
		s.close();
		factory.close();
		
	}
}

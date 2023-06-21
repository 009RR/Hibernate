package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		// get, load
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory= cfg.buildSessionFactory();
		Session session = factory.openSession();
		//Student student = session.get(Student.class, 104);
		
		  Student student = session.load(Student.class, 104);
		  System.out.println(student.getName());
		
		  Student student1 = session.load(Student.class, 104);

		  //Student student1 = session.load(Student.class, 108);
		  //System.out.println(student1);
		
		
		/*
		 * Address ad= session.get(Address.class, 1); System.out.println(ad);
		 * System.out.println(ad.getStreet()+" "+ad.getCity());
		 * 
		 * Address ad1= session.get(Address.class, 1); System.out.println(ad1);
		 * System.out.println(ad1.getStreet()+" "+ad1.getCity());
		 */
		
		//get-student:104
		session.close();
		factory.close();
	}

}

package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	private static Date date;

	public static void main(String[] args) throws IOException {
		System.out.println("Project started");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		// creating student
		Student st = new Student();
		st.setId(104);
		st.setName("Durgesh Tiwari");
		st.setCity("Lauknow");
		// creating object of address class
		Address ad = new Address();
		ad.setStreet("street1");
		ad.setCity("Delhi");
		ad.setOpen(true);
		Date utilDate = new Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		ad.setAddedDate(sqlDate);
		ad.setX(1234.234);
		// reading image
		FileInputStream fis = new FileInputStream("src/main/java/RR.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(st);
		session.save(ad);
		
		tx.commit();
		session.close();
		System.out.println("Done...");

	}
}

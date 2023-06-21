package com.pegination;

import org.hibernate.query.Query;

import com.tut.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLPegination {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Query query=s.createQuery("from Student");
		
		//implementing pegination using hibernate
		
		query.setFirstResult(0);
		query.setMaxResults(5);
		
		List<Student> list = query.list();		
		for(Student st:list) {
			System.out.println(st.getName()+":"+st.getId());
		}
		
		s.close();	
		
		factory.close();
		
	}

}

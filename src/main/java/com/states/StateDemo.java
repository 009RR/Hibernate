package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {
public static void main(String[] args) {
	//practical of Hibernate Object States
	//Transient
	//persistant state
	//detached
	//remove
	
	System.out.println("Example :");
	SessionFactory f=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	
	//Creating student object:
	Student student=new Student();
	student.setId(1414);
	student.setName("Peter");
	student.setCity("ABC");
	student.setCerti(new Certificate("Java Hibernate course","2 months"));
	
	//student:Transient state
	
	
	Session s=f.openSession();
	Transaction tx=s.beginTransaction();
	s.save(student);
	//student:Persistent - session,database
	student.setName("John");
	tx.commit();
	
	s.close();
	
	f.close();
	
	//student: Detached:
	student.setName("Sachin");
	System.out.println(student);
	
}
}

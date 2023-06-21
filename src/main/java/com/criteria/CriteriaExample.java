package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Student;

public class CriteriaExample {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		Criteria c=s.createCriteria(Student.class);
		
		//c.add(Restrictions.eq("certi.course", "springboot"));
		//c.add(Restrictions.gt("id", 12));
		c.add(Restrictions.like("certi.course", "Java"));
		
		List<Student> students=c.list();
		for(Student s1:students) {
			System.out.println(s1);
		}
		
		
		
		s.close();
	}
}

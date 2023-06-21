package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLExample {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s=factory.openSession();
		
		//HQL
		//Syntax
		String query="from Student as s where s.city=:x and s.name=:n";
		
		Query q = s.createQuery(query);
		
		q.setParameter("x","Pune");
		q.setParameter("n", "Rajesh");
		
		//single -(Unique)
		//multiple-list
		//q.uniqueResult();
		List<Student> list = q.list();
		for(Student student:list) {
			System.out.println(student.getName()+":"+student.getCity());
		}
		
		System.out.println("---------------------------------------------");
		
		Transaction tx=s.beginTransaction();
		/*//delete
		 * Query q2 = s.createQuery("delete from Student s where s.city=:c");
		 * q2.setParameter("c","Chennai"); int r = q2.executeUpdate();
		 * System.out.println("deleted:"); System.out.println(r); tx.commit();
		 */
		
		/*//update
		 * Query q2 = s.createQuery("update Student set city=:c where name=:n");
		 * q2.setParameter("n", "Rajesh Raut"); q2.setParameter("c","Nashik"); int r =
		 * q2.executeUpdate(); System.out.println(r+"objects updated");
		 */
		
		//how to execute join query
		Query q5 = s.createQuery("SELECT q.question, q.questionId, a.answer FROM Question AS q INNER JOIN q.answers AS a");
		
		List<Object[]> list3=q5.getResultList();
		
		for(Object[] arr:list3) {
			System.out.println(Arrays.toString(arr));
		}
		
		tx.commit();
		
		s.close();
		
		factory.close();

	}

}

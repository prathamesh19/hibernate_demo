package com.prathamesh.hibernate.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestStudent {

	public static void main(String[] args) {
		Student st1=new Student(101,"abc");
		Student st2=new Student(102,"pqr");
		Student st3=new Student(103,"xyz");
		Configuration configure=new Configuration();
		SessionFactory sessionfactory=configure.configure().buildSessionFactory();
		Session session=sessionfactory.openSession();		
		Transaction tr = session.beginTransaction();
		session.save(st1);
		session.save(st2);
		session.save(st3);
		session.flush();
		tr.commit();
		Student dbstudent=session.get(Student.class, 101);
		System.out.println(dbstudent);

	}

}

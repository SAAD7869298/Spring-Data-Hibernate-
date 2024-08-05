package com.hibernate_project.Spring_Data_Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_project.Spring_Data_Hibernate.model.Course;
import com.hibernate_project.Spring_Data_Hibernate.model.Student;
import com.hibernate_project.Spring_Data_Hibernate.model.StudentDetail;
import com.hibernate_project.Spring_Data_Hibernate.model.Teacher;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(Course.class).addAnnotatedClass(StudentDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// Start a transaction
			session.beginTransaction();

			// session.save(student);

			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			// Close the session
			session.close();
		}
	}
}

package com.hibernate_project.Spring_Data_Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hibernate_project.Spring_Data_Hibernate.config.AppConfig;
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
//
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(Course.class).addAnnotatedClass(StudentDetail.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		////////////////
		// load the spring configuration file
		AnnotationConfigApplicationContext context_config = new AnnotationConfigApplicationContext(AppConfig.class);

		Student student = context_config.getBean(Student.class);
		StudentDetail studentDetail = context_config.getBean(StudentDetail.class);
		Course course = context_config.getBean("course", Course.class);
		Course course2 = context_config.getBean("course2", Course.class);
		Teacher teacher = context_config.getBean(Teacher.class);
		teacher.getCourses().add(course);
		teacher.getCourses().add(course2);

		try {
			// Start a transaction
			session.beginTransaction();

			///////////////////////////

			// save student in DB use session
			session.save(student);

			// save studentDetail in DB use session
			session.save(studentDetail);

			// save course1 in DB use session
			session.save(course);

			// save course2 in DB use session
			session.save(course2);

			// save teacher in DB use session
			session.save(teacher);

			// save queres
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			// Close the session
			session.close();
			context_config.close();
		}

	}
}

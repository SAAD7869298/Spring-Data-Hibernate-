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
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(Course.class).addAnnotatedClass(StudentDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// Start a transaction
			session.beginTransaction();
			// create student to add in DB
			Student student = new Student("mohamed", "saad", "11/8/2000", "male", "m.saad.com");

			// create studentDetail to add in DB
			StudentDetail studentDetail = new StudentDetail("cairo", "0125489745258");
			// relationship between student and studentDetail
			student.setStudentDetail(studentDetail);

			// create course1 to add in DB
			Course course1 = new Course("java1", "java spring1");

			// create course2 to add in DB
			Course course2 = new Course("java2", "java spring2");

			// relationship between student and course1
			student.getCourses().add(course1);
			// relationship between student and course2
			student.getCourses().add(course2);

			// create teacher to add in DB
			Teacher teacher = new Teacher("ahmed", "saad", "ahmed.saad.com");

			// relationship between teacher and course1
			teacher.getCourses().add(course1);
			// relationship between teacher and course2
			teacher.getCourses().add(course2);

			// relationship between course1 and teacher
			course1.setTeacher(teacher);

			// relationship between course2 and teacher
			course2.setTeacher(teacher);

			///////////////////////////

			// save student in DB use session
			session.save(student);

			// save studentDetail in DB use session
			session.save(studentDetail);

			// save course1 in DB use session
			session.save(course1);

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
		}
	}
}

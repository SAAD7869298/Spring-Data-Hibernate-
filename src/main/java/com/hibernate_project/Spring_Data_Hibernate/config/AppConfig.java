package com.hibernate_project.Spring_Data_Hibernate.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.hibernate_project.Spring_Data_Hibernate.model.Course;
import com.hibernate_project.Spring_Data_Hibernate.model.Student;
import com.hibernate_project.Spring_Data_Hibernate.model.StudentDetail;
import com.hibernate_project.Spring_Data_Hibernate.model.Teacher;
import com.hibernate_project.Spring_Data_Hibernate.model.addddd;

@Configuration
//@ComponentScan(basePackages = "com.hibernate_project.Spring_Data_Hibernate")
public class AppConfig {
	

	@Bean
	public Student student() {
		Student student = new Student("mohamed", "saad", "11/8/2000", "male", "m.saad.com");
		student.setStudentDetail(studentDetail());
		student.getCourses().add(course());
		student.getCourses().add(course2());
		return student;
	}

	@Bean
	public StudentDetail studentDetail() {
		return new StudentDetail("cairo", "0125489745258");
	}

	@Bean
	public Course course() {
		Course course = new Course("java1", "java spring1");
		course.setTeacher(teacher());
		//course.setStudents((List<Student>) student());
		return course;
	}
	
	@Bean
	public Course course2() {
		Course course = new Course("java2", "java spring2");
		course.setTeacher(teacher());
		return course;
	}

	@Bean
	public Teacher teacher() {
		Teacher teacher = new Teacher("ahmed", "saad", "ahmed.saad.com");
//		teacher.getCourses().add(course());
//		teacher.getCourses().add(course2());
		return teacher;
	}
	
}

package com.hibernate_project.Spring_Data_Hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	private String courseName;
	private String description;

	/*
	 * relationship Course and Student (M:M) in tabel Enrollments
	 * 
	 */
	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<Student>();

	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

	public Course() {
	}

	public Course(String courseName, String description) {
		this.courseName = courseName;
		this.description = description;
	}

	public int getCourseId() {
		return courseId;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

package com.hibernate_project.Spring_Data_Hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "StudentDetail")
public class StudentDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentDetailId;
	private String address;
	private String phoneNumber;
	
	@OneToOne(mappedBy = "studentDetail", cascade = CascadeType.ALL)
	private Student student;

	

	public StudentDetail() {
	}

	public StudentDetail(String address, String phoneNumber) {
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	public int getStudentDetailId() {
		return studentDetailId;
	}

	public void setStudentDetailId(int studentDetailId) {
		this.studentDetailId = studentDetailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}

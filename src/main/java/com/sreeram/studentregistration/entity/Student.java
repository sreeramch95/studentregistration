package com.sreeram.studentregistration.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	private int studentId;

	private String firstName;

	private String lastName;

	private List<Address> addressList = new ArrayList<>();

	public Student() {
	}

	public Student(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;

	}

	@Id
	@Column(name = "studentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "student_address", joinColumns = { @JoinColumn(name = "studentId") }, inverseJoinColumns = {
			@JoinColumn(name = "addressId") })
	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public String toString() {

		return "student [First Name=" + firstName + ", Last name=" + lastName + "]";

	}

}

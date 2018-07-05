package com.sreeram.studentregistration.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	private int addressId;

	private String primaryAddress;

	private String shippingAddress;

	private List<Student> studentList = new ArrayList<>();

	public Address() {

	}

	public Address(String primaryAddress, String shippingAddress) {

		this.primaryAddress = primaryAddress;
		this.shippingAddress = shippingAddress;

	}

	@Id
	@Column(name = "addressId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Column(name = "primaryAddress")
	public String getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(String primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	@Column(name = "shippingAddress")
	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "addressList")
	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public String toString() {

		return "address [ PrimaryAddress=" + primaryAddress + ", Shipping Address=" + shippingAddress + "]";

	}
}

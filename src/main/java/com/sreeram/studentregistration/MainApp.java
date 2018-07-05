package com.sreeram.studentregistration;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.sreeram.studentregistration.entity.Address;
import com.sreeram.studentregistration.entity.Student;
import com.sreeram.studentregistration.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Student student = new Student();
		student.setFirstName("Sree");
		student.setLastName("Chenn");

		Address address1 = new Address("tenali", "Ithanagar");
		Address address2 = new Address("Chesterfield", "Lacross lane");

		List<Address> addresses = new ArrayList<>();
		addresses.add(address1);
		addresses.add(address2);

		student.setAddressList(addresses);

		session.save(student);

		session.getTransaction().commit();
		System.out.println("Done");
	}

}

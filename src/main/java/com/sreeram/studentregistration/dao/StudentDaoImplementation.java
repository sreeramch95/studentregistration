package com.sreeram.studentregistration.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sreeram.studentregistration.entity.Student;

@Repository
@Transactional
public class StudentDaoImplementation implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int save(Student student) {

		return (Integer) sessionFactory.getCurrentSession().save(student);

	}

	@Override
	public Student get(int studentId) {

		return (Student) sessionFactory.getCurrentSession().get(Student.class, studentId);

	}

	@Override
	public List<Student> theStudents() {

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);
		criteriaQuery.select(root);
		Query<Student> query = session.createQuery(criteriaQuery);
		return query.getResultList();

	}

	@Override
	public void update(int studentId, Student student) {

		Session session = sessionFactory.getCurrentSession();
		Student student2 = session.byId(Student.class).load(studentId);
		student2.setFirstName(student.getFirstName());
		student2.setLastName(student.getLastName());
		session.flush();

	}

	@Override
	public void delete(int studentId) {

		Session session = sessionFactory.getCurrentSession();
		Student student = session.byId(Student.class).load(studentId);
		session.delete(student);

	}

}

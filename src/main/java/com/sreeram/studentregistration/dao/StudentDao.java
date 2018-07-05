package com.sreeram.studentregistration.dao;

import java.util.List;

import com.sreeram.studentregistration.entity.Student;

public interface StudentDao {

	int save(Student student);

	Student get(int studentId);

	List<Student> theStudents();

	void update(int studentId, Student student);

	void delete(int studentId);

}

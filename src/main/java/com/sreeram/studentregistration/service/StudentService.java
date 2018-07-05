package com.sreeram.studentregistration.service;

import java.util.List;

import com.sreeram.studentregistration.dto.StudentDTO;
import com.sreeram.studentregistration.entity.Student;

public interface StudentService {

	int save(Student student);

	Student get(int studentId);

	List<StudentDTO> theStudents();

	void update(int studentId, Student student);

	void delete(int studentId);

}

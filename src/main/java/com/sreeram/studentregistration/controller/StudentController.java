package com.sreeram.studentregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sreeram.studentregistration.dto.StudentDTO;
import com.sreeram.studentregistration.entity.Student;
import com.sreeram.studentregistration.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/student")
	public ResponseEntity<?> save(@RequestBody Student student) {
		int studentId = studentService.save(student);
		return ResponseEntity.ok().body("New student has been saved with ID:" + studentId);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> get(@PathVariable("id") int studentId) {
		Student student = studentService.get(studentId);
		return ResponseEntity.ok().body(student);
	}

	@GetMapping("/student")
	public ResponseEntity<List<StudentDTO>> theStudents() {
		List<StudentDTO> students = studentService.theStudents();
		return ResponseEntity.ok().body(students);
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int studentId, @RequestBody Student student) {
		studentService.update(studentId, student);
		return ResponseEntity.ok().body("Student has been updated successfully.");
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int studentId) {
		studentService.delete(studentId);
		return ResponseEntity.ok().body("Student has been deleted successfully.");
	}
}

package com.sreeram.studentregistration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sreeram.studentregistration.dao.StudentDao;
import com.sreeram.studentregistration.dto.AddressDTO;
import com.sreeram.studentregistration.dto.StudentDTO;
import com.sreeram.studentregistration.entity.Address;
import com.sreeram.studentregistration.entity.Student;

@Service
@Transactional(readOnly = true)
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Transactional
	@Override
	public int save(Student student) {

		return studentDao.save(student);

	}

	@Override
	public Student get(int studentId) {

		return studentDao.get(studentId);

	}

	@Override
	public List<StudentDTO> theStudents() {
		
		List<StudentDTO> studentDTOList = new ArrayList<>(); 
		List<Student> students = studentDao.theStudents();
		for (Student s : students) {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setFirstName(s.getFirstName());
			studentDTO.setLastName(s.getLastName());
			List<Address> addressList=  s.getAddressList();
			List<AddressDTO> addressDTOList = new ArrayList<>();
			for(Address a : addressList) {
				AddressDTO addressDTO = new AddressDTO();
				addressDTO.setPrimaryAddress(a.getPrimaryAddress());
				addressDTO.setShippingAddress(a.getShippingAddress());
				addressDTOList.add(addressDTO);
			}
			studentDTO.setAddresses(addressDTOList);
			studentDTOList.add(studentDTO);
		}
		return studentDTOList;

	}

	@Transactional
	@Override
	public void update(int studentId, Student student) {

		studentDao.update(studentId, student);

	}

	@Transactional
	@Override
	public void delete(int studentId) {

		studentDao.delete(studentId);

	}

}

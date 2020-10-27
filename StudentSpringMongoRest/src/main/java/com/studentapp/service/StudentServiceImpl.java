package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.studentapp.dao.StudentRepository;
import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;
@Service
@Repository
public class StudentServiceImpl implements StudentService {

	
	
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public boolean deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);
		return true;
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		Student newStudent = studentRepository.save(student);
		return newStudent;
	}



	@Override
	public List<Student> getStudentByCity(String city) {
		// TODO Auto-generated method stub
		List<Student> bookList = studentRepository.findByAddressCity(city);
		return bookList;
	}

	@Override
	public List<Student> getStudentByDepartment(String department) {
		// TODO Auto-generated method stub
		List<Student> bookList = studentRepository.findByDepartment(department);
		return bookList;
	}

	@Override
	public List<Student> findByAge(int age) {
		// TODO Auto-generated method stub
		List<Student> bookList = studentRepository.findByAge(age);
		return bookList;
	}

	@Override
	public Student getStudentById(int studentId) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return studentRepository.findById(studentId).orElseThrow(()-> new StudentNotFoundException("Id not available"));
	}

}

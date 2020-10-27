package com.studentapp.service;

import java.util.List;

import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;

public interface StudentService {
	
	boolean deleteStudent(int studentId);
	Student addStudent(Student student);
	Student getStudentById(int studentId) throws StudentNotFoundException;
	
	List<Student> getStudentByCity(String city);
	List<Student> getStudentByDepartment(String department);
	
	List<Student> findByAge(int age);
	

}

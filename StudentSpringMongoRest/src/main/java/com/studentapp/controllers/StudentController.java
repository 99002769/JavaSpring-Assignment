package com.studentapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.exception.StudentNotFoundException;
//import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;
import com.studentapp.service.StudentService;

@RestController
@RequestMapping("/student-api")
public class StudentController {

	
	@Autowired
	StudentService studentService;
	public StudentController() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	@PostMapping("/students")
	Student addStudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	
	@DeleteMapping("/students/delete-one/{studentId}")
	boolean deleteStudent(@PathVariable("studentId")Integer studentId) {
		return studentService.deleteStudent(studentId);
	}
	
	@GetMapping("/students/get-one/{studentId}")
	Student getStudentById(@PathVariable("studentId")Integer studentId) throws StudentNotFoundException
	{
		return studentService.getStudentById(studentId);
	}
	
	@GetMapping("/students/city/{city}")
	List<Student> getStudentByCity(@PathVariable("city")String city) {
		return studentService.getStudentByCity(city);
	}
	
	@GetMapping("/students/department/{department}")
	List<Student> getStudentByDepartment(@PathVariable("department")String department) {
		return studentService.getStudentByDepartment(department);
	}
	
	@GetMapping("/students/age/{age}")
	List<Student> findByAge(@PathVariable("age")int age) {
		return studentService.findByAge(age);
	}
	

}

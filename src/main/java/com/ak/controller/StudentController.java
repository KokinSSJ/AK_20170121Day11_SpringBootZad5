package com.ak.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ak.entity.Student;
import com.ak.service.StudentService;

@RestController
@RequestMapping("/student")

public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Student> getAllStudents(){
		System.out.println("wchodzi");
		System.out.println("wchodzi2");
		return studentService.getAllStudents();
	}
	
	//http://127.0.0.1/students?id=1
	//read
	@RequestMapping(method=RequestMethod.GET, value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudentById(@PathVariable Long id){
		return studentService.getStudentById(id);
	}
	
	//delete
	@RequestMapping(method=RequestMethod.DELETE, value ="/{id}")
	public void deleteStudentById(@PathVariable Long id){
		studentService.deletStudentById(id);
	}
	
	//add, create
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addStudent(@RequestBody Student student){
		studentService.addStudent(student);
	}
	
	//update
	@RequestMapping(method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
		
	}
	

}

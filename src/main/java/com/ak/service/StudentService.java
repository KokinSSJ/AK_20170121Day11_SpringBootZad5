package com.ak.service;

import java.util.Collection;

import com.ak.entity.Student;

public interface StudentService {
	
	//takie samo jak w StudentDao!!
	Collection <Student> getAllStudents();
	Student getStudentById(Long id);
	void deletStudentById(Long id);
	void addStudent(Student student);
	void updateStudent(Student student);
	

}

package com.ak.DAO;

import java.util.Collection;
import com.ak.entity.Student;


public interface StudentDao {
	
	Collection <Student> getAllStudents();
	Student getStudentById(Long id);
	void deletStudentById(Long id);
	void addStudent(Student student);
	void updateStudent(Student student);

}

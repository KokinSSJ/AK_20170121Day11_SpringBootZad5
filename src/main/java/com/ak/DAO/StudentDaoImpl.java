package com.ak.DAO;

import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ak.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	private Map<Long, Student> studentMap = new HashMap<>();
	
	public StudentDaoImpl() {
		studentMap.put(1L, new Student("Jan", "Kowalski",1L,  "Ang"));
		studentMap.put(2L,  new Student("Dom", "Bo", 2L, "JAVA"));	
	}
	
	

	public Map<Long, Student> getStudentMap() {
		return studentMap;
	}



	public void setStudentMap(Map<Long, Student> studentMap) {
		this.studentMap = studentMap;
	}



	@Override
	public Student getStudentById(Long id) {
		
		return studentMap.get(id);
	}

	@Override
	public void deletStudentById(Long id) {
		studentMap.remove(id);
		
	}

	@Override
	public void addStudent(Student student) {
		studentMap.put(student.getId(), student);
		
	}

	@Override
	public void updateStudent(Student student) {
		studentMap.replace(student.getId(), student);	
	}


	@Override
	public Collection<Student> getAllStudents(){
		return studentMap.values();
	}



	

}

package com.ak.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ak.DAO.StudentDao;
import com.ak.entity.Student;


@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	//  w tej klasie w funkcjach mozna dodawac jakies specjalne funkcje, np. zapisanie do pliku o pobraniu, usuwanie, obróbka danych z DAO
	
	
	
	@Override
	public Collection<Student> getAllStudents() {
		//tutaj mozna dac dodatkowa logike biznesowa ->
		return studentDao.getAllStudents();
	}


	@Override
	public Student getStudentById(Long id) {
		//tutaj mozna dac dodatkowa logike biznesowa ->
		return studentDao.getStudentById(id);
	}

	@Override
	public void deletStudentById(Long id) {
		studentDao.deletStudentById(id);
		
	}

	@Override
	public void addStudent(Student student) {
		studentDao.addStudent(student);
		
	}

	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
		
	}
	
	

}

package com.cg.app.student.service;

import java.util.List;
import java.util.Optional;

import com.cg.app.student.entity.Student;

public interface StudentInterface {

	List<Student> getStudents();

	void insert(Student student);

	Optional<Student> getStudents(int id);

	void deleteStudent(int id);

	//String getStudents(String name);

	//Optional<Student> getStudents(int id);

	
	
	
}

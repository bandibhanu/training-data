package com.cg.app.student.service;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.student.entity.Student;
import com.cg.app.student.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentInterface{
	@Autowired 
	StudentRepo repository;

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void insert(Student student) {
		repository.save(student);
		
	}

	@Override
	public Optional<Student> getStudents(int id) {
		// TODO Auto-generated method stub
		 return repository.findById(id);
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

//	@Override
//	public String getStudents(String name) {
//		// TODO Auto-generated method stub
//		return null;//repository.(name);
//	}

//	@Override
//	public Optional<Student> getStudents(int id) {
//		
//		 return repository.findById(id);
//	}	
}

package com.cg.app.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.student.entity.Student;
import com.cg.app.student.service.StudentInterface;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentInterface service;

	@GetMapping
	private List<Student> getAllStudents() {
		return service.getStudents();
	}
	@PostMapping
	private void insertStudent(@RequestBody Student student)
	{
		service.insert(student);
	}
	
	@GetMapping("/{id}")	
	private Optional<Student> getById(@PathVariable int id){
		
			return service.getStudents(id);
		
    
	}
	@DeleteMapping("/{id}")
	private void deleteStudent(@PathVariable int id)
	{
		service.deleteStudent(id);
	}
//	@GetMapping("/{name}")
//	private String getByName(@PathVariable String name){
//		return service.getStudents(name);
//	}

                                                   
}


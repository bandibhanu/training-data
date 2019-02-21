package com.cg.app.student.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.app.student.entity.Student;

public interface StudentRepo extends MongoRepository<Student, Integer>
{

	
}

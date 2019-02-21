package com.cg.app.student.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
	
	 @Id
	 private Integer id;
	 private String name;
	 private Integer fees;
	 
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(Integer fees) {
		this.fees = fees;
	}
	public Student(Integer id, String name, Integer fees) {
		super();
		this.id = id;
		this.name = name;
		this.fees = fees;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
}

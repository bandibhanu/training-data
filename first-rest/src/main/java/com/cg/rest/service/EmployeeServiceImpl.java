package com.cg.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rest.entity.Employee;
import com.cg.rest.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
public EmployeeRepository repository;

@Override
public void addNewEmployee(Employee employee) {
	
	repository.save(employee);
}

@Override
public java.util.List<Employee> getAllEmployees() {

	return repository.findAll();
}
}

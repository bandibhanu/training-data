package com.cg.rest.service;

import com.cg.rest.entity.Employee;



public interface EmployeeService {

	void addNewEmployee(Employee employee);

	java.util.List<Employee> getAllEmployees();

}
package com.example.employee.service;

import java.util.List;

import com.example.employee.pojo.Employee;

public interface EmployeeService {
	public Employee getEmployeeById(int id);
	public List<Employee> viewAll();
	public void delete(int id);
	public void update(int id, Employee employee);
	public void addNewEmployee(Employee employee);
}
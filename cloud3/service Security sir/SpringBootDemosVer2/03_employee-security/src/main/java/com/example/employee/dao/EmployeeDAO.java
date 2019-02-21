package com.example.employee.dao;

import java.util.List;

import com.example.employee.pojo.Employee;

public interface EmployeeDAO {
	public List<Employee> viewAll();
	public Employee getEmp(int id);
	public void delete(int id);
	public void update(int id, Employee employee);
}
package com.example.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dao.EmployeeDAOImpl;
import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.pojo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	 private EmployeeDAOImpl employeeDAO;
	
	public List<Employee> viewAll() {
		return employeeDAO.viewAll();
	}

	public Employee getEmp(int id) {
		try {
			return employeeDAO.getEmp(id);
		}catch(EmployeeNotFoundException exception) {
			throw exception;
		}
	}

	public void delete(int id) {
		employeeDAO.delete(id);
	}

	public void update(int id, Employee employee) {
		employeeDAO.update(id, employee);
	}

	public void addNewEmployee(Employee employee) {
		employeeDAO.add(employee);
	}
}

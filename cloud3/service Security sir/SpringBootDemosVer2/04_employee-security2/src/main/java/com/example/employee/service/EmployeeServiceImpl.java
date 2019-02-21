package com.example.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dao.EmployeeRepository;
import com.example.employee.pojo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	// private EmployeeDAOImpl employeeDAO;
	private EmployeeRepository employeeDAO;

	public List<Employee> viewAll() {
		// return employeeDAO.viewAll();
		return employeeDAO.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		//return employeeDAO.getEmp(id);
		return employeeDAO.findById(id).get();
	}

	public void delete(int id) {
		//employeeDAO.delete(id);
		employeeDAO.deleteById(id);
	}

	public void update(int id, Employee employee) {
		//employeeDAO.update(id, employee);
		employeeDAO.save(employee);
	}

	public void addNewEmployee(Employee employee) {
		employeeDAO.save(employee);
	}
}

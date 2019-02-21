package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.pojo.Employee;
import com.example.employee.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public void add( @RequestBody Employee employee) {
		employeeService.addNewEmployee(employee);;
	}
	
	@RequestMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmp() {
		List<Employee> employees = employeeService.viewAll();
		ResponseEntity<List<Employee>> response = new ResponseEntity<List<Employee>>(employees, HttpStatus.NOT_FOUND);
		return response;
	}

	@RequestMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmp(@PathVariable("id") int id) {
		Employee employee = null;
		try {
			employee = employeeService.getEmp(id);
		}catch(EmployeeNotFoundException exception) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@RequestMapping(value="/employee", method=RequestMethod.POST)
	public void addNewEmployee(@RequestBody Employee employee) {
		employeeService.addNewEmployee(employee);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		employeeService.delete(id);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") int id, @RequestBody Employee employee) {
		employeeService.update(id, employee);
	}
	
	
}

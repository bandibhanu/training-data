package com.example.employee.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.pojo.Employee;
import com.example.employee.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@RequestMapping("/employee/{id}")
	public Resource<Employee> retrieveStudent(@PathVariable int id) {
		Employee employee = employeeService.getEmployeeById(id);

		Resource<Employee> resource = new Resource<Employee>(employee);

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllEmp());
		System.out.println(linkTo);
		resource.add(linkTo.withRel("all-Employees"));

		return resource;
	}

	@RequestMapping("/employee/{start}/{count}")
	public Resources<List<Employee>> getEmployeesByPage(@PathVariable("start") int start,
			@PathVariable("count") int count) {
		List<Employee> tempemployees = employeeService.viewAll();
		List<Employee> employees = new ArrayList<>();

		start = start == 0 ? 1 : start;

		System.out.println("Start = " + start);
		System.out.println("Count = " + count);

		for (int i = 0; i < count; i++) {
			System.out.println("Retrieving Employee ");
			employees.add(tempemployees.get(start + i));
		}

		System.out.println("returning " + employees);

		Link nextLink = linkTo(methodOn(this.getClass()).getEmployeesByPage(start + count, count)).withRel("next");
		Link prevLink = linkTo(
				methodOn(this.getClass()).getEmployeesByPage(start - count < 0 ? 0 : start - count, count))
						.withRel("previous");

		Resources resources;

		if (start == 1) {
			resources = new Resources(employees, nextLink);
		} else {
			resources = new Resources(employees, nextLink, prevLink);
		}

		return resources;
	}

	@RequestMapping("/employee")
	public List<Employee> getAllEmp() {
		return employeeService.viewAll();
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
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

package com.example.employee.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import org.springframework.stereotype.Repository;

import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.pojo.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private Employee employee = null;
	private List<Employee> employeeList = new ArrayList<Employee>(
			Arrays.asList(new Employee(1, "shubham", "saxena"), new Employee(2, "Satyen", "Singh")));

	public List<Employee> viewAll() {
		if (employeeList.size() == 0) {
			throw new EmployeeNotFoundException("Employee Not Found");
		} else
			return employeeList;
	}

	public Employee getEmp(int id) {
		try {
			employee = employeeList.stream().filter(t -> t.getId() == id).findFirst().get();
		} catch (NoSuchElementException execption) {
			throw new EmployeeNotFoundException("Employee Not Found");
		}
		return employee;

	}

	public void delete(int id) {
		Predicate<Employee> empPredicate = null;
		try {
			empPredicate = p -> p.getId() == id;
			employeeList.removeIf(empPredicate);
		} catch (NoSuchElementException execption) {
			throw new EmployeeNotFoundException("Employee Not Found");
		}
		
	}

	public void update(int id, Employee employee) {
		boolean check = false;
		for (int i = 0; i < employeeList.size(); i++) {
			Employee employ = employeeList.get(i);
			if (employ.getId() == id) {
				employeeList.set(i, employee);
				check = true;
				return;
			}
		}
		if (!check) {
			throw new EmployeeNotFoundException("Employee Not Found");
		}
	}

	@Override
	public void add(Employee employee) {
		employeeList.add(employee);

	}
}
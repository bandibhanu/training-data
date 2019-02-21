package com.example.employee.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Repository;

import com.example.employee.pojo.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private List<Employee> employeeList = new ArrayList<Employee>(
			Arrays.asList(new Employee(1, "shubham", "saxena"), new Employee(2, "Satyen", "Singh")));

	public List<Employee> viewAll() {
		return employeeList;
	}

	public Employee getEmp(int id) {
		return employeeList.stream().filter(t -> t.getId() == id).findFirst().get();
	}

	public void delete(int id) {
		Predicate<Employee> emp = p -> p.getId() == id;
		employeeList.removeIf(emp);
	}

	public void update(int id, Employee employee) {
		for (int i = 0; i < employeeList.size(); i++) {
			Employee employ = employeeList.get(i);
			if (employ.getId() == id) {
				employeeList.set(i, employee);
				return;
			}
		}
	}
}
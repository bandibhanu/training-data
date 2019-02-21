package com.example.employee.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.pojo.Employee;

@Repository
@Primary
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

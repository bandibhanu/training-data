package com.example.employee.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Employee Not Found")
public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
}

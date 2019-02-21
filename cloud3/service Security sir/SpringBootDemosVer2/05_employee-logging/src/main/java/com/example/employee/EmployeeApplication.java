package com.example.employee;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.employee.pojo.Employee;
import com.example.employee.service.EmployeeService;

@SpringBootApplication
public class EmployeeApplication {

	private static Logger logger = LogManager.getLogger(EmployeeApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadInitialData(EmployeeService service) {
		logger.debug("This is debug message");
		logger.info("This is info message");
		logger.warn("This is warning message");
		logger.error("This is Error message");
		logger.fatal("This is Fatal message");
		
		return (args) -> {
			service.addNewEmployee(new Employee(1, "Satyen", "Singh"));
			service.addNewEmployee(new Employee(2, "Vikram", "Singh"));
			service.addNewEmployee(new Employee(3, "Vikram", "Hegde"));
			service.addNewEmployee(new Employee(4, "Pooja", "Singh"));
			service.addNewEmployee(new Employee(5, "Dinesh", "Singh"));
			service.addNewEmployee(new Employee(6, "Rohit", "Khanna"));
			service.addNewEmployee(new Employee(7, "Vibhuti", "Vartak"));
			service.addNewEmployee(new Employee(8, "Jayshree", "Vartak"));
			service.addNewEmployee(new Employee(9, "Nilu", "Singh"));
			service.addNewEmployee(new Employee(10, "Onkar", "Deshpande"));
			service.addNewEmployee(new Employee(11, "Christable", "Menezis"));
			System.out.println("Sample Data Populated to Database");
		};
	}
}

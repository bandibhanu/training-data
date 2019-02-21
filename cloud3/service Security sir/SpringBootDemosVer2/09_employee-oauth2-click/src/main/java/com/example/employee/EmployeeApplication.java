package com.example.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.employee.pojo.Employee;
import com.example.employee.service.EmployeeService;

@SpringBootApplication
@EnableOAuth2Sso
public class EmployeeApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/webjars/**", "/error**").permitAll()
				.anyRequest().authenticated();
	}

	@Bean
	public CommandLineRunner loadInitialData(EmployeeService service) {
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

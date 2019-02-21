package com.example.employee.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testGetEmployeeById() throws Exception {
		//arrange

		//act
		ResponseEntity<Resource> responseEntity= testRestTemplate.getForEntity("/employee/1", Resource.class);

		//assert
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void testGetEmployeeByIdThatDoesNotExist() throws Exception {
		//arrange

		//act
		ResponseEntity<Resource> responseEntity= testRestTemplate.getForEntity("/employee/101", Resource.class);
		
		//assert
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
}
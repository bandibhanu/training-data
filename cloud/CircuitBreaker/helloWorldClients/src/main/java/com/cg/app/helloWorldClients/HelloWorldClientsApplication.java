package com.cg.app.helloWorldClients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker

@SpringBootApplication
public class HelloWorldClientsApplication {

	/*
	 * @Autowired private HelloService bookService;
	 * 
	 * @Bean public RestTemplate rest(RestTemplateBuilder builder) { return
	 * builder.build(); }
	 * 
	 * @RequestMapping("/to-read") public String toRead() { return
	 * bookService.readingList(); }
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldClientsApplication.class, args);
	}
	@Bean
	public RestTemplate initialize()
	{
		return new RestTemplate();
	}

}


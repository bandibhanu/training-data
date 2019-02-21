package com.cg.app.helloworldEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HelloworldEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldEurekaApplication.class, args);
	}

}


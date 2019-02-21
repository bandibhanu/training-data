package com.cg.app.BankEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class BankEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankEurekaServerApplication.class, args);
	}

}


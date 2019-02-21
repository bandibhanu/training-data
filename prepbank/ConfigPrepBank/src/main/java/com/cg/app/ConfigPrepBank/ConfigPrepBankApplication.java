package com.cg.app.ConfigPrepBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class ConfigPrepBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigPrepBankApplication.class, args);
	}

}


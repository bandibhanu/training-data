package com.cg.app.Account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.cg.app.Account.entity.SavingsAccount;
import com.cg.app.Account.repository.AccountRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
	@Bean
	public CommandLineRunner LoadInitialDate(AccountRepository repo) {
		return (evt)->{
		repo.save(new SavingsAccount(101,"bhanu",(double) 100000,true));
		repo.save(new SavingsAccount(102,"bhanu",(double) 100000,true));
		repo.save(new SavingsAccount(103,"bhanu",(double) 100000,true));
		};
	}
	
}


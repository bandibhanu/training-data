package com.cg.app.Account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.cg.app.Account.repository.AccountRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
//	@Bean
//	public commandLineRunner LoadInitialDate(AccountRepository repo) {
//		return (evt)->{
//			repo.save(new SavingsAccount(101,"bhanu",100000,true));
//		}
//	}
	
}


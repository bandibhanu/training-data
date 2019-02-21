package com.cg.app.Account.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.Account.entity.Account;
import com.cg.app.Account.service.AccountService;

@RestController
@RequestMapping("/Accounts")
public class AccountController {

	@Autowired
	AccountService service;

	@PostMapping
	private void addAccount(@RequestBody Account account) {
		service.addAccount(account);
	}

	@GetMapping
	private List<Account> getAccount() {
		return service.getAccount();
	}

	@GetMapping("{accountNumber}")
	private ResponseEntity<Account> getAccountById(@PathVariable int  accountNumber) {
		Optional<Account> optional=service.getAccountbyId(accountNumber);
		Account account = optional.get();
		if(account==null){
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		else{
			return new ResponseEntity<>(account,HttpStatus.OK);
		}
	}
	
	@GetMapping("{accountNumber}/balance")
	private ResponseEntity<Double> getAccountBalanceById(@PathVariable int  accountNumber) {
		double accountBalance=service.getAccountBalancebyId(accountNumber); 
		return  new ResponseEntity<>(accountBalance, HttpStatus.OK);
	}

	@DeleteMapping("/{accountNumber}")
	private void deleteAccount(@PathVariable Integer accountNumber) {
		service.deleteAccount(accountNumber);
	}
	
	@PutMapping("/{accountNumber}")
	private ResponseEntity<Account> updateAccountBalance(@PathVariable int accountNumber,@RequestParam ("currentBalance") Double currentBalance)
	{
		Optional<Account> optional=service.getAccountbyId(accountNumber);
		Account accounts=optional.get();
		if(accounts==null){
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		accounts.setCurrentBalance(currentBalance);
		service.updateBalance(accounts);
		return new ResponseEntity<>(accounts,HttpStatus.OK);
	}
	

}

package com.cg.app.Transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.app.Transaction.entity.CurrentDataSet;
import com.cg.app.Transaction.entity.Transaction;
import com.cg.app.Transaction.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	public TransactionService service;	

	@Autowired
	public RestTemplate resttemplate;

	@PostMapping("/deposit")
	private ResponseEntity<Transaction> Deposite(@RequestBody Transaction transaction) {
		System.out.println("getting the current balance of the account number");
		ResponseEntity<Double> entity = resttemplate.getForEntity("http://Account/Accounts/"+transaction.getAccountNumber()+"/balance",Double.class);
		Double currentBalance = entity.getBody();
		Double updatedBalance = service.deposite(transaction.getAccountNumber(), currentBalance,transaction.getAmount());
		resttemplate.put("http://Account/Accounts/"+ transaction.getAccountNumber()+"?currentBalance="+updatedBalance,null);
		return new  ResponseEntity<Transaction> (HttpStatus.CREATED);
		

	}

	@PostMapping("/withdrawForm")
	private ResponseEntity<Transaction> withdrew(@RequestBody Transaction transaction){
		ResponseEntity<Double> entity = resttemplate.getForEntity("http://Account/Accounts/"+transaction.getAccountNumber()+"/balance", Double.class);
		Double currentBalance = entity.getBody();
		Double updatedBalance=service.withdrew(transaction.getAccountNumber(),currentBalance,transaction.getAmount());
		
		resttemplate.put("http://Account/Accounts/"+transaction.getAccountNumber()+"?currentBalance="+updatedBalance,null);
		return new ResponseEntity<Transaction>(HttpStatus.CREATED);
		
	}
	@GetMapping
	public ResponseEntity<CurrentDataSet> listOfTransactions(){
		CurrentDataSet currentDataSet =new CurrentDataSet();
		List<Transaction> transactions = service.listOfTransactions();
		currentDataSet.setTransaction(transactions);
		return new ResponseEntity<>(currentDataSet, HttpStatus.OK);
	}

}

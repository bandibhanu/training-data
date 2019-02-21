package com.cg.app.Transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.Transaction.Repository.TransactionRepository;
import com.cg.app.Transaction.entity.Transaction;
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	public TransactionRepository repository;

	@Override
	public Double deposite(Integer accountNumber, Double currentBalance, Double amount) {
		Transaction transaction = new Transaction();
		transaction.setAccountNumber(accountNumber);
		transaction.setAmount(amount);
		currentBalance = currentBalance+amount;
		transaction.setCurrentBalance(currentBalance);
		Double updatedCurrentBalance = repository.save(transaction).getCurrentBalance();
		return updatedCurrentBalance;
	}
	@Override
	public Double withdrew(Integer accountNumber, Double currentBalance, Double amount) {
		Transaction transaction=new Transaction();
		transaction.setAccountNumber(accountNumber);
		transaction.setAmount(amount);
	currentBalance=currentBalance-amount;		
		transaction.setCurrentBalance(currentBalance);
		Double  updatedCurrentBalance =repository.save(transaction).getCurrentBalance();
		return  updatedCurrentBalance;
}
//	@Override
//	public void fundTransfer()
//	{
//		
//	}
	@Override
	public List<Transaction> listOfTransactions() {
		
		return repository.findAll();
	}
}

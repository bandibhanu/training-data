package com.cg.app.Transaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.app.Transaction.entity.Transaction;

@Service
public interface TransactionService {

	Double deposite(Integer accountNumber, Double currentBalance, Double amount);

	Double withdrew(Integer accountNumber, Double currentBalance, Double amount);

	List<Transaction> listOfTransactions();

	//Double withdrew(Integer accountNumber, Double currentBalance, Double amount);

}

package com.cg.app.Account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.Account.entity.Account;
import com.cg.app.Account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired 
	AccountRepository repository;

	public void addAccount(Account account) {
		
		repository.save(account);
		
	}

	@Override
	public List<Account> getAccount() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<Account> getAccountbyId(int accountNumber) {
	
		return repository.findById(accountNumber);
	}

	@Override
	public void deleteAccount(int accountNumber) {
		
		repository.deleteById(accountNumber);
	}

//	@Override
//	public void update(Account account) {
//		
//		repository.save(account);
//		
//	}

	@Override
	public double getAccountBalancebyId(int accountNumber) {
		Optional<Account> accountBalance = repository.findById(accountNumber);
		return accountBalance.get().getCurrentBalance();
	}

	@Override
	public void updateBalance(Account accounts) {
		// TODO Auto-generated method stub
		repository.save(accounts);
	}

	
		
	}

	
	


package com.cg.app.Account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.app.Account.entity.Account;

@Service

public interface AccountService 
{

	void addAccount(Account account);

	List<Account> getAccount();

	Optional<Account> getAccountbyId(int accountNumber);

	void deleteAccount(int accountNumber);

//	void update(Account account);

	double getAccountBalancebyId(int accountNumber);

	void updateBalance(Account accounts);
	

	
}
package com.moneymoney.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.moneymoney.web.entity.CurrentDataSet;
import com.moneymoney.web.entity.Transaction;

@RefreshScope
@Controller
public class BankAppController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String depositForm() {
		return "index";
	}
	@RequestMapping("/depositForm")
	public String depositform() {
		return "DepositForm";
	}
	

	@RequestMapping("/deposit")
	public String deposit(@ModelAttribute Transaction transaction,Model model) {
		//System.out.println("Deposit form");
		restTemplate.postForEntity("http://zuulServer/Transaction/transactions/deposit", transaction, null);
		transaction.getAccountNumber();
		model.addAttribute("message","Success!");
		return "DepositForm";
	}
	@RequestMapping("/withdraw")
	public String withdrawForm() {
		return "withdrew";
	}
	@RequestMapping("/withdrewForm")
	public String withdrew(@ModelAttribute Transaction transaction,Model model) {
		restTemplate.postForEntity("http://zuulServer/Transaction/transactions/withdrawForm",transaction,null);
		transaction.getAccountNumber();
		model.addAttribute("message","Success!");
		return "withdrew";
		
	}
	@RequestMapping("/fundtransfer")
	public String fundtransferform() {
		return "fundtransferForm";
	}
	@RequestMapping("/fundtransferpage")
	public String fundTransfer(@RequestParam("sendersaccountNumber") int sendersaccountNumber,@RequestParam("receiversaccountNumber") int receiversaccountNumber,@ModelAttribute Transaction transaction,Model model) {
		
	transaction.setAccountNumber(sendersaccountNumber);
		restTemplate.postForEntity("http://zuulServer/Transaction/transactions/withdrawForm",transaction,null);
		transaction.setAccountNumber(receiversaccountNumber);
		restTemplate.postForEntity("http://zuulServer/Transaction/transactions/deposit", transaction, null);
		model.addAttribute("message","Success!");
		return "fundtransferForm";
		
		
	}
	@RequestMapping("/getstatements")
	public String from() {
		return "getStatementsForm";
	}
	
	@RequestMapping("/getStatements")
	public ModelAndView getStatement(@RequestParam("offset") int offset, @RequestParam("size") int size) {
		int currentSize = size==0?5:size;
		int currentOffset = offset==0?1:offset;
		Link previous = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(BankAppController.class).getStatement(currentOffset-currentSize, currentSize)).withRel("previous");
		Link next = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(BankAppController.class).getStatement(currentOffset+currentSize, currentSize)).withRel("next");
		CurrentDataSet currentDataSet = restTemplate.getForObject("http://zuulServer/Transaction/transactions", CurrentDataSet.class);
		List<Transaction> transactionList = currentDataSet.getTransaction();
		List<Transaction> transactions = new ArrayList<Transaction>();
		for(int value=currentOffset-1; value<currentOffset+currentSize-1; value++) {
			if((transactionList.size() <= value && value > 0) || currentOffset < 1)
				break;
			Transaction transaction = transactionList.get(value);
			transactions.add(transaction);		
		}
		currentDataSet.setPriviousLink(previous);
		currentDataSet.setNextLink(next);
		currentDataSet.setTransaction(transactions);
		return new ModelAndView("DepositForm", "currentDataSet", currentDataSet);
	
		
		
	}

	
}
	

package com.moneymoney.web.entity;

import java.util.List;

import org.springframework.hateoas.Link;

public class CurrentDataSet {
	
	 private List<Transaction> transaction;
	 
	 private Link priviousLink;
	 private Link nextLink;
	public CurrentDataSet(List<Transaction> transaction, Link priviousLink, Link nextLink) {
		super();
		this.transaction = transaction;
		this.priviousLink = priviousLink;
		this.nextLink = nextLink;
	}
	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	public Link getPriviousLink() {
		return priviousLink;
	}
	public void setPriviousLink(Link priviousLink) {
		this.priviousLink = priviousLink;
	}
	public Link getNextLink() {
		return nextLink;
	}
	public void setNextLink(Link nextLink) {
		this.nextLink = nextLink;
	}
	public CurrentDataSet() {
		super();
		// TODO Auto-generated constructor stub
	}
	 

}

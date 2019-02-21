package com.cg.app.Transaction.sender;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.app.Transaction.entity.Transaction;

@Component
public class Sender {

	@Autowired
	private RabbitMessagingTemplate rabbit;
	
	public void send(Transaction transaction)
	{
		rabbit.convertAndSend("messaging", transaction);
	}
}

package com.cg.app.Account.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.app.Account.controller.AccountController;
import com.cg.app.Transaction.entity.Transaction;

@Component
public class Receiver {

	@Autowired
	private AccountController control;
	
	@RabbitListener(queues = "messaging")
	public void receiver(Transaction transaction) throws ListenerExecutionFailedException
	{
		control.updateBalance(transaction);
	}
}

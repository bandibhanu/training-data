package com.cg.app.HelloWorldService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hellowords")
public class HelloWorldWebService 
{

@GetMapping
public String helloWorld() {
	return "HELLO";
}
	
}

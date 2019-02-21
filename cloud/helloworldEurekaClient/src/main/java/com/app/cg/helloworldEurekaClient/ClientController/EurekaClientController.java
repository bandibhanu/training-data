package com.app.cg.helloworldEurekaClient.ClientController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EurekaClientController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
		
	}
	/*
	 * @GetMapping("/bhanu") public String bhanu() { return "hi bhanu"; }
	 */
	
}
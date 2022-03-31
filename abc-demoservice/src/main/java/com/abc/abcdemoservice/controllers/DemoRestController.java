package com.abc.abcdemoservice.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abc.abcdemoservice.model.Customer;
import com.abc.abcdemoservice.services.DemoService;

@RestController
public class DemoRestController {

	Logger logger = LoggerFactory.getLogger(DemoRestController.class);
	
	@Value("${test.message}")
	private String testMessage;
	
	@Autowired
	private DemoService demoService;
	
	@GetMapping(path = "/ping")
	public String ping() {
		String message = "Hi from abc-demoservice ";
		try {
			InetAddress ip = InetAddress.getLocalHost();
			message += " From host: " + ip;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	
	@GetMapping(path = "/profile")
	public String profile() {
		return testMessage;
	}
	
	@GetMapping(path = "getCustomer/{id}")
	public Customer getCustomer(@PathVariable String id){
		logger.info("Received requeset for getCustomer/"+id+".");
		return demoService.getCustomers(id);
	}
	
}

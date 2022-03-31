package com.abc.abcdemoservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.abcdemoservice.controllers.DemoRestController;
import com.abc.abcdemoservice.model.Customer;
import com.abc.abcdemoservice.proxy.CustomerServiceFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DemoService {

	Logger logger = LoggerFactory.getLogger(DemoService.class);
	
	@Autowired
	private CustomerServiceFeignClient customerServiceFeignClient;
	
	
	@HystrixCommand(fallbackMethod = "defaultCustomer")
	public Customer getCustomers(String id){
	 logger.info("Received requeset for getCustomer/"+id+".");	
	 Customer customer = customerServiceFeignClient.getCustomer(Long.parseLong(id));
	 logger.info("Response : "+customer);	
	 return customer;	
	}
	
	
	private Customer defaultCustomer(String username) {
		logger.error("defaultCustomer - ABC-CUSTOMERSERVICE IS DOWN, We will back shortly!");
		System.out.println("ABC-CUSTOMERSERVICE IS DOWN, We will back shortly!");
        return new Customer();
    }
}

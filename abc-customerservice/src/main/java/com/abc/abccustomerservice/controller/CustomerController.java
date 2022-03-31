package com.abc.abccustomerservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.abccustomerservice.entity.Customer;
import com.abc.abccustomerservice.service.CustomerService;

@RestController
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Value("${message}")
	private String message;
	
	@Autowired
	private CustomerService customerService;

	// Get Customer by Id
	@GetMapping("/getCustomer/{id}")
	public Customer getCustomer(@PathVariable("id") Long id) {
		return customerService.getCustomer(id);
	}

	@GetMapping("/getCustomers")
	public List<Customer> getCustomers() {
		logger.info("Request received for getCustomers()");
		return customerService.getCustomers();
	}
	
	@GetMapping("/listPageable")
	Page<Customer> employeesPageable(Pageable pageable) {
		return customerService.customerPageable(pageable);

	}

	// Add new Customer
	@PostMapping("/addCustomer")
	public String addcustomer(@RequestBody Customer customer) {
		logger.info("Request received for addcustomer()");
		return customerService.addCustomer(customer);
	}

	// Update Customer details
	@PutMapping("/updateCustomer")
	public String updateCustomer(@RequestBody Customer customer) {
		logger.info("Request received for updateCustomer()");
		return customerService.updateCustomer(customer);
	}
	
	@GetMapping("/profile")
	public String getProfile() {
		return message;
	}
}
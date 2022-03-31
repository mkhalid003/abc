package com.abc.abcdemoservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.abc.abcdemoservice.model.Customer;


@Async
@FeignClient("${abc.customer.service}")
public interface CustomerServiceFeignClient {

	@GetMapping("/getCustomer/{id}")
	public Customer getCustomer(@PathVariable("id") Long id);
	
	@GetMapping("/listPageable")
	Page<Customer> employeesPageable(Pageable pageable);

	// Add new Customer
	@PostMapping("/addCustomer")
	public String addcustomer(@RequestBody Customer customer);

	// Update Customer details
	@PutMapping("/updateCustomer")
	public String updateCustomer(@RequestBody Customer customer);
}

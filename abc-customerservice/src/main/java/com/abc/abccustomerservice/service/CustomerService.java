package com.abc.abccustomerservice.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.abc.abccustomerservice.entity.Customer;
import com.abc.abccustomerservice.exception.CustomerAlreadyExistsException;
import com.abc.abccustomerservice.exception.NoSuchCustomerExistsException;
import com.abc.abccustomerservice.repository.CustomerRepository;

@Service
public class CustomerService {
	
	
	Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository customerRespository;

	// Method to get customer by Id.Throws
	// NoSuchElementException for invalid Id
	public Customer getCustomer(Long id) {
		return customerRespository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("NO CUSTOMER PRESENT WITH ID = " + id));
	}

	// Method to add new customer details to database.Throws
	// CustomerAlreadyExistsException when customer detail
	// already exist
	public String addCustomer(Customer customer) {
		logger.debug("Starting addCustomer() with customer details :"+customer);
		Customer existingCustomer = customerRespository.findById(customer.getId()).orElse(null);
		if (existingCustomer == null) {
			customerRespository.save(customer);
			logger.info("Customer added succesfully.");
			return "Customer added successfully";
		} else
			logger.error("Customer already exixts.");
			throw new CustomerAlreadyExistsException("Customer already exixts!!");
	}

	// Method to update customer details to database.Throws
	// NoSuchCustomerExistsException when customer doesn't
	// already exist in database
	public String updateCustomer(Customer customer) {
		logger.debug("Starting updateCustomer() with customer details :"+customer);
		Customer existingCustomer = customerRespository.findById(customer.getId()).orElse(null);
		if (existingCustomer == null) {
			logger.error("No Such Customer exists.");
			throw new NoSuchCustomerExistsException("No Such Customer exists!!");
		}
		else {
			existingCustomer.setName(customer.getName());
			existingCustomer.setAddress(customer.getAddress());
			customerRespository.save(existingCustomer);
			logger.info("Record updated Successfully.");
			return "Record updated Successfully";
		}
	}

	public Page<Customer> customerPageable(Pageable pageable) {
		return customerRespository.findAll(pageable);

	}

	public List<Customer> getCustomers() {
		return customerRespository.findAll();
	}

}
package com.abc.abcdemoservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.abcdemoservice.model.Employee;
import com.abc.abcdemoservice.services.EmployeeService;

@RestController("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/save")
	public String saveEmployee(@RequestBody Employee emp) {
		return employeeService.save(emp);
	}
	
	@GetMapping("/get")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	/**
	@GetMapping("/get/{id}")
	public List<Employee> getEmployee(@PathVariable String id){
		
		return null;
	}
	*/

}

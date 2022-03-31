package com.abc.abcdemoservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.abcdemoservice.entities.EmployeeEntity;
import com.abc.abcdemoservice.model.Employee;
import com.abc.abcdemoservice.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public String save(Employee emp) {

		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmployeeID(emp.getId());
		employeeEntity.setAge(emp.getAge());
		employeeEntity.setName(emp.getName());

		EmployeeEntity empStatus = employeeRepository.save(employeeEntity);
		if(empStatus != null) {
			return "Employee ID: "+empStatus.getId()+" created.";
		}else {
			return null;
		}
	}

	
	public List<Employee> getEmployees(){
		
		List<Employee> employees = new ArrayList<>();
		Iterable<EmployeeEntity> employeeEntities = employeeRepository.findAll();
		for (EmployeeEntity employeeEntity : employeeEntities) {
			
			Employee emp = new Employee();
			emp.setName(employeeEntity.getName());
			emp.setAge(employeeEntity.getAge());
			emp.setId(employeeEntity.getEmployeeID());
			
			employees.add(emp);
		}
		
		return employees;
		
	}
}

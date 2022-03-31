package com.abc.abccustomerbatchservice.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@Data
public class Customer {
   
	
	private String firstName;
    private String lastName;
    private List<Order> orders;
	
    @Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", orders=" + orders + "]";
	} 
    
    
}
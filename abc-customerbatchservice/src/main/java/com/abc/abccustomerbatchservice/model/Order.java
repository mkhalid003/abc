package com.abc.abccustomerbatchservice.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Order { 
	
	String id; 
	Date Date; 
	BigDecimal amount; 
	String description; 
	Boolean completed;
	@Override
	public String toString() {
		return "Order [id=" + id + ", Date=" + Date + ", amount=" + amount + ", description=" + description
				+ ", completed=" + completed + "]";
	} 
	
	
}
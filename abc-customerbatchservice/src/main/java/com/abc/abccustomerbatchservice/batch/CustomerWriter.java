package com.abc.abccustomerbatchservice.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abc.abccustomerbatchservice.entity.CustomerEntity;
import com.abc.abccustomerbatchservice.entity.OrderEntity;
import com.abc.abccustomerbatchservice.repository.CustomerRepository;
import com.abc.abccustomerbatchservice.repository.OrderRepository;

@Component
public class CustomerWriter implements ItemWriter<Object> {	

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public void write(List<? extends Object> items) throws Exception {
		System.out.println("CustomerWriter processing...");
		for (Object object : items) {
			 
			if(object instanceof CustomerEntity) {
				CustomerEntity customerEntity = (CustomerEntity) object;
				customerRepository.save(customerEntity);
			}
			
			if(object instanceof OrderEntity) {
				OrderEntity orderEntity = (OrderEntity) object;
				orderRepository.save(orderEntity);
			}
		}
	}
}

package com.abc.abccustomerbatchservice.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.abc.abccustomerbatchservice.entity.CustomerEntity;
import com.abc.abccustomerbatchservice.entity.OrderEntity;
import com.abc.abccustomerbatchservice.model.Customer;
import com.abc.abccustomerbatchservice.model.Order;

@Component
public class CustomerProcessor implements ItemProcessor<Object, Object> {

	@Override
	public Object process(Object item) throws Exception {
		System.out.println(item);
		System.out.println("CustomerProcessor processing...");
		if(item instanceof Customer) {
			Customer customer = (Customer) item;
			CustomerEntity customerEntity = new CustomerEntity();
			customerEntity.setFirstName(customer.getFirstName());
			customerEntity.setLastName(customer.getLastName());
			return customerEntity;
		}
		
		if(item instanceof Order) {
			Order order = (Order) item;
			OrderEntity orderEntity = new OrderEntity();
			orderEntity.setId(order.getId());
			orderEntity.setAmount(order.getAmount());
			orderEntity.setCompleted(order.getCompleted());
			orderEntity.setDate(order.getDate());
			orderEntity.setDescription(order.getDescription());
			return orderEntity;
		}
		return item;
	}
}

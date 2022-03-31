package com.abc.abccustomerbatchservice.batch;


import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import com.abc.abccustomerbatchservice.model.Customer;

@Component
public class CustomerReader {
	
	
	
	@Bean
	public ItemReader<Customer> readCustomerXML(){
		StaxEventItemReader<Customer> eventItemReader = new StaxEventItemReader<>();
		eventItemReader.setResource(new ClassPathResource("/customer.xml"));
		eventItemReader.setFragmentRootElementName("customer");
		
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setClassesToBeBound(Customer.class);
		eventItemReader.setUnmarshaller(jaxb2Marshaller);
		return eventItemReader;
	}
	
	
	/**
	@Bean
	public BeanIOFlatFileItemReader<Customer> readEPEFile() throws Exception {
		System.out.println("CustomerReader processing...");
		BeanIOFlatFileItemReader<Customer> reader = new BeanIOFlatFileItemReader<>();
        reader.setStreamFactory(StreamFactory.newInstance());
        reader.setResource(new ClassPathResource("customer-orders.csv"));
        reader.setStreamMapping(new ClassPathResource("order-mapping.xml"));
        reader.setStreamName("EPE File");
        reader.afterPropertiesSet();
        reader.getLineNumber();
        reader.open(new ExecutionContext());   
		return reader;
	}
	**/
}

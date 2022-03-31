package com.abc.abccustomerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AbcCustomerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcCustomerserviceApplication.class, args);
	}


}

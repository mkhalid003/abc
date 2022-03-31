package com.abc.abcdemoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.abc.abcdemoservice.entities.UserModel;
import com.abc.abcdemoservice.repositories.UserRespository;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class AbcDemoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcDemoserviceApplication.class, args);
	}
	
	@Autowired
	UserRespository userRespository;
	
	
	@Bean
    CommandLineRunner initDatabase(UserRespository userRespository) {
		return args -> {
			userRespository.save(new UserModel("Khalid Khan"));
			userRespository.save(new UserModel("Khalid Pathan"));
			userRespository.save(new UserModel("Muhammad Khalid"));
        };
        
    }

}

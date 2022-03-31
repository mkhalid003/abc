package com.abc.abceurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AbcEurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcEurekaserverApplication.class, args);
	}

}

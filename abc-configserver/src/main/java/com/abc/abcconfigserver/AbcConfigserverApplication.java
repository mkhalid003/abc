package com.abc.abcconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AbcConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcConfigserverApplication.class, args);
	}

}

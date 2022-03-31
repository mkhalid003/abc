package com.abc.abczipkinserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AbcZipkinserver2Application {

	public static void main(String[] args) {
		SpringApplication.run(AbcZipkinserver2Application.class, args);
	}
	
	/**

	Logger logger = LoggerFactory.getLogger(AbcZipkinserver2Application.class);

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() { 
		return new RestTemplate(); 
	} 

	@RequestMapping("/")
	public String home() {
		logger.info( "you called home");
		return "Hello World";
	}
	
	@RequestMapping("/callhome")
	public String callHome() {
		logger.info("calling home");
		return restTemplate.getForObject("http://localhost:7081", String.class);
	}

	*/
}

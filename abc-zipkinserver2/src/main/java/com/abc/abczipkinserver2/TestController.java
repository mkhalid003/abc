package com.abc.abczipkinserver2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {
	
	Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	ZipKinServer1FeignClient zipKinServer1FeignClient;
	
	@GetMapping("/")
	public String home() {
		logger.info( "you called home");
		return "Zipkin Server -2 Home";
	}
	
	@GetMapping("/callhome")
	public String callHome() {
		logger.info("calling home");
		//RestTemplate restTemplate = new RestTemplate();
		//String str = restTemplate.getForObject("http://localhost:7081/", String.class);
		//System.out.println("http://localhost:7081/===>"+str);
		
		String str = zipKinServer1FeignClient.home();
		logger.info("called home : "+str);
		return str;
	}
}

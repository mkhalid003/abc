package com.abc.abcdemoservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@Autowired
	RedisTemplate<String, String> redisTemplate;

	@GetMapping(path = "/ping")
	public String ping() {
		return "Hi From abc-demoservice";
	}

	@GetMapping("/getVisitorCount")
	public String getVisitorCount() {

		if (redisTemplate.hasKey("count")) {
			String count = (String) redisTemplate.opsForHash().get("count", "HashVisitorCountMap");
			int visitIncrementer = Integer.parseInt(count);
			visitIncrementer++;
			redisTemplate.opsForHash().put("count", "HashVisitorCountMap", Integer.toString(visitIncrementer));
			return "Number of Visits : "+visitIncrementer;
		} else {
			redisTemplate.opsForHash().put("count", "HashVisitorCountMap", "1");
			return "Number of Visits : 1";
		}
	}
}

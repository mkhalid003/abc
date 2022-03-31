package com.abc.abczipkinserver2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;


@Async
@FeignClient(name = "sxz", url = "http://localhost:7081/")
public interface ZipKinServer1FeignClient {

	@RequestMapping("/") 
	public String home();
}

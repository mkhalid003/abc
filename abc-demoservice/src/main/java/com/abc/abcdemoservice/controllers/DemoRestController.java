package com.abc.abcdemoservice.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@GetMapping(path = "/ping")
	public String ping() {
		String message = "Hi from abc-demoservice ";
        try {
            InetAddress ip = InetAddress.getLocalHost();
            message += " From host: " + ip;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return message;
	}
}

package com.sterlite.demo.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd.
 * @creationdate 20-Aug-2020
 */
@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}

}

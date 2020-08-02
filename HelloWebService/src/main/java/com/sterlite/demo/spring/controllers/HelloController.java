package com.sterlite.demo.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}

}

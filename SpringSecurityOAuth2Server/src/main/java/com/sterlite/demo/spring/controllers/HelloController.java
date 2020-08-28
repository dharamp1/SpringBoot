package com.sterlite.demo.spring.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd.
 * @creationdate 20-Aug-2020
 */
@RestController
@RequestMapping("/rest/hello")
public class HelloController {
	
	@GetMapping
	public String hello(Principal principal) {
		return "Hello " + principal.getName();
	}
	
	
	@GetMapping("/principal")
	public Principal user(Principal principal) {
		return principal;
	}
	 
	
	
}

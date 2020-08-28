package com.sterlite.demo.spring.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd.
 * @creationdate 19-Aug-2020
 */
@Controller
public class LoginController {
	
	@GetMapping("/hi")
	public String hi() {
		return "redirect:/hellopage";
	}
	
	@GetMapping("/hellopage")
	public String hello123(ModelMap map) {
		List<String> cities = Arrays.asList("Pune","Mumbai","Nasik");
		map.addAttribute("message", "Welcome");
		map.addAttribute("cities", cities);
		return "hello123";
	}
	
	@GetMapping("/login")
	public String login() {
		return "signin";
	}
}

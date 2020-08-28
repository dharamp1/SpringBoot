package com.sterlite.demo.spring.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd.
 * @creationdate 20-Aug-2020
 */
@Controller
public class UiController {

	@GetMapping("/")
	public String home(Model model,Principal principal) {
		return "index";
	}
	
	@GetMapping("/secure")
	public String secure(Model model,Principal principal) {
		return "secure";
	}
	
}

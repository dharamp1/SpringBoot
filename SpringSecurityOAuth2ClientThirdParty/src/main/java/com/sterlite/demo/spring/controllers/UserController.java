package com.sterlite.demo.spring.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        System.out.println("Attribute: "+principal.getAttribute("name"));
        System.out.println("Name: "+principal.getName());
        System.out.println("Principal: "+principal);
        System.out.println("Principal User Name: "+principal.getAttribute("login"));
        return Collections.singletonMap("name", principal.getAttribute("given_name"));
    }

}

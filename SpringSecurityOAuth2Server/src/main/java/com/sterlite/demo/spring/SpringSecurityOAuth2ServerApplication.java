package com.sterlite.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd.
 * @creationdate 20-Aug-2020
 */
@SpringBootApplication
public class SpringSecurityOAuth2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOAuth2ServerApplication.class, args);
	}

}

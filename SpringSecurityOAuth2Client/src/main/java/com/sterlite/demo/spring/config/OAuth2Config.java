package com.sterlite.demo.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd.
 * @creationdate 20-Aug-2020
 */
@Configuration
public class OAuth2Config extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.antMatcher("/**")
		.authorizeRequests()
		.antMatchers("/","/login**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.oauth2Login();
		
	}
}

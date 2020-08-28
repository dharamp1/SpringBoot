package com.sterlite.demo.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd.
 * @creationdate 20-Aug-2020
 */
@Configuration
@EnableResourceServer //OAuth2 Resource Server
@Order(1)
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${user.username}")
	private String username;
	
	@Value("${user.password}")
	private String password;
	
	// Configuring Credentials using InMemoryAuthentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		
		auth
		.inMemoryAuthentication()
		.withUser(username)
		.password(passwordEncoder().encode(password))
		.roles("USER");
	}
	
	// Configuring Authorization for resources
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.requestMatchers() // Allows specifying which HttpServletRequest instances this HttpSecurity will be invoked on. This method allows for easily invoking the HttpSecurity for multiple different RequestMatcher instances.  
		.antMatchers("/login","/oauth/authorize")// Maps a List of org.springframework.security.web.util.matcher.AntPathRequestMatcherinstances that do not care which HttpMethod is used.
		.and()
		.authorizeRequests() //Allows restricting access based upon the HttpServletRequest using RequestMatcher implementations 
		.anyRequest() // Maps any request
		.authenticated() //Specify that URLs are allowed by any authenticated user.
		.and()
		.formLogin() // Specifies to support form based authentication. If FormLoginConfigurer.loginPage(String) is not specified a default login pagewill be generated. 
		.permitAll(); // Grant access to urls
	}
	
	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return
	 * PasswordEncoderFactories.createDelegatingPasswordEncoder(); }
	 */
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

package com.sterlite.demo.spring.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		 * auth.inMemoryAuthentication()
		 * .passwordEncoder(NoOpPasswordEncoder.getInstance())
		 * .withUser("dharam").password("welcome").authorities("ROLE_USER") .and()
		 * .withUser("admin").password("admin123").roles("USER","ADMIN");
		 */
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser("dharam").password(encoder.encode("welcome")).authorities("ROLE_USER")
		.and()
		.withUser("admin").password(encoder.encode("admin123")).roles("USER","ADMIN");
	}
	
}

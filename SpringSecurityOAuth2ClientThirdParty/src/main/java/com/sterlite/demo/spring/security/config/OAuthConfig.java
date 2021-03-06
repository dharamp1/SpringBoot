package com.sterlite.demo.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
@Configuration
public class OAuthConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		 http
         .authorizeRequests(a -> a
             .antMatchers("/", "/error", "/webjars/**").permitAll()
             .anyRequest().authenticated()
         )
         .logout(l -> l
             .logoutSuccessUrl("/").permitAll()
         )
         .csrf(c -> c
             .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
         )
         .exceptionHandling(e -> e
             .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
         )
         .oauth2Login();
	}
	
}

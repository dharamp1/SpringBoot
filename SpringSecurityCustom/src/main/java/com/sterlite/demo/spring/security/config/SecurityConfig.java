package com.sterlite.demo.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd.
 * @creationdate 19-Aug-2020
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService)	
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
		//.passwordEncoder(new BCryptPasswordEncoder());
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Default Spring Security Configuration using http basic
		/*http.authorizeRequests()
				.anyRequest().authenticated() //every request requires the user to be authenticated
			.and()
			.formLogin() //form based authentication is supported
			.and()
			.httpBasic();//HTTP Basic Authentication is supported
		*/
		
		http.authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/resources/**").permitAll()//allows anyone to access a URL that begins with /resources/. Since this is where our css, javascript, and images are stored all our static resources are viewable by anyone
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login")//when authentication is required, redirect the browser to /login
					// when authentication attempt fails, redirect the browser to /login?error
					// when we successfully logout, redirect the browser to /login?logout
				.permitAll() // allows any access to any url associated to formLogin()
			.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))  
				.permitAll();
		
		
		/*
		http.authorizeRequests()
        .antMatchers("/login")
            .permitAll()
        .antMatchers("/**")
            .hasAnyRole("ADMIN", "USER")
        .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/home")
            .failureUrl("/login?error=true")
            .permitAll()
        .and()
            .logout()
            .logoutSuccessUrl("/login?logout=true")
            .invalidateHttpSession(true)
            .permitAll()
        .and()
            .csrf()
            .disable();
		 */
	}
	
	
}

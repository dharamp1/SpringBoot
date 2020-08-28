package com.sterlite.demo.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd.
 * @creationdate 18-Aug-2020
 */
@SpringBootApplication
public class SpringSecurityJdbcApplication {

	@Autowired
	Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJdbcApplication.class, args);
	}
	
	/*
	 * @Bean public DataSource getDataSource() { DriverManagerDataSource dataSource
	 * new DriverManagerDataSource();
	 * dataSource.setDriverClassName(env.getProperty(
	 * "spring.datasource.driver-class-name"));
	 * dataSource.setUrl(env.getProperty("spring.datasource.url"));
	 * dataSource.setUsername(env.getProperty("spring.datasource.username"));
	 * dataSource.setPassword(env.getProperty("spring.datasource.password")); return
	 * dataSource; }
	 */

}

package com.sterlite.demo.spring;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import com.sterlite.demo.spring.services.IProductService;

import net.bytebuddy.dynamic.loading.ClassLoadingStrategy.Configurable;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@SpringBootApplication
public class ProductWebServiceApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductWebServiceApplication.class);
	
	@Autowired
	Environment env;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ProductWebServiceApplication.class, args);
		IProductService service = ctx.getBean("productService", IProductService.class);
		service.findAll().forEach((p)->LOGGER.info(p.toString()));
	}
	
	/*
	 * @Bean DataSource oracleDDSource() { DataSourceBuilder oracleDS =
	 * DataSourceBuilder.create(); oracleDS.driverClassName(env.getProperty(
	 * "spring.datasource.driver-class-name"));
	 * oracleDS.url(env.getProperty("spring.datasource.url"));
	 * oracleDS.username(env.getProperty("spring.datasource.username"));
	 * oracleDS.password(env.getProperty("spring.datasource.password"));
	 * LOGGER.info("DB Connection is made " + oracleDS); return oracleDS.build(); }
	 */
	
	/*
	 * @Bean ResourceBundleViewResolver viewResolver1() { ResourceBundleViewResolver
	 * viewResolver = new ResourceBundleViewResolver();
	 * viewResolver.setBasename("views"); viewResolver.setOrder(1); return
	 * viewResolver; }
	 */
	
	
	/*
	 * @Bean InternalResourceViewResolver viewResolver2() {
	 * InternalResourceViewResolver viewResolver = new
	 * InternalResourceViewResolver(); viewResolver.setPrefix("/");
	 * viewResolver.setSuffix(".jsp"); viewResolver.setOrder(2); return
	 * viewResolver;
	 * 
	 * }
	 */

}

package com.sterlite.demo.spring.core;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sterlite.demo.spring.core.entities.Product;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@SpringBootApplication
public class SimpleBeanApplication implements CommandLineRunner{
	
	@Autowired
	ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(SimpleBeanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Stream.of(args).forEach(System.out::println);
		
		
		// TODO Auto-generated method stub
		Product product = context.getBean("product",Product.class);
		System.out.println(product);
	}
	
	 

}

package com.sterlite.demo.spring.data.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import com.sterlite.demo.spring.data.jdbc.entities.Product;
import com.sterlite.demo.spring.data.jdbc.events.EventConfig;
import com.sterlite.demo.spring.data.jdbc.services.IProductService;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@SpringBootApplication
@EnableJdbcRepositories
@Import(EventConfig.class)
public class SpringDataJdbcDemoApplication implements CommandLineRunner {
	
	@Autowired
	IProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcDemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		// get no of rows
		System.out.println("No. of products: " + productService.countProducts());
		
		// get all records in the database
		List<Product> products = productService.findAll();
		products.forEach(System.out::println);
		
		// insert new record in the database
		Product product = new Product("Washing Machine", "Whirlpool", 42000.00f);
		productService.add(product);
		
		// get record by primary key
		Product dbProduct = productService.findById(1001);
		System.out.println("Product returned from database: "+dbProduct);
		
		// update record by primary key
		/*
		 * Product dbProduct1 = productService.findById(1001); if(dbProduct1!=null) {
		 * System.out.println("Old Price: " + dbProduct1.getPrice());
		 * dbProduct1.setPrice(dbProduct1.getPrice() + 100.00f);
		 * System.out.println("New Price: " + dbProduct1.getPrice());
		 * productService.update(dbProduct1); System.out.println("***UPDATED****"); }
		 */
		
		/*
		 * dbProduct1 = productService.findById(1001);
		 * System.out.println("Product returned from database: "+dbProduct1);
		 */
		
		// delete record by primary key
		/*
		 * Product dbProduct2 = productService.findById(1002); if(dbProduct2!=null) {
		 * productService.delete(dbProduct2); System.out.println("***DELETED****"); }
		 */
		// checking deleted record
		//System.out.println("Product found: " + productService.findById(1002));
		
		List<Product> productsByPriceRange = productService.findByPriceRange(40000.00f,50000.00f);
		productsByPriceRange.forEach(System.out::println);
		
		
	}
	
	
	

}

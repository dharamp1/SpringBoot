package com.sterlite.demo.spring.controllers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sterlite.demo.spring.entities.Product;
import com.sterlite.demo.spring.exceptions.ProductNotFoundException;
import com.sterlite.demo.spring.services.IProductService;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	IProductService service;
	
	@CrossOrigin
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProducts(){
		LOGGER.info("Sending all products");
		return service.findAll();
	}
	
	@GetMapping("/{pid}")
	public Product getProduct(@PathVariable("pid")  BigInteger id) throws ProductNotFoundException {
		return service.findById(id);
	}
	
	@PostMapping
	public void addProduct(@RequestBody  Product product) {
		LOGGER.info(product.toString());
		service.add(product); 
	}
	
	@PutMapping
	public void updateProduct(@RequestBody Product product) {
		service.update(product);
	}
	
	@DeleteMapping
	public void removeProduct(@RequestBody  Product product) {
		LOGGER.info(product.toString());
		service.delete(product); 
	}
	
	@PutMapping("/{id}/{price}")
	public ResponseEntity<String> updateProduct(@PathVariable  BigInteger id, @PathVariable BigDecimal price) {
		LOGGER.info("Request Parameters: id=" + id + "\tprice="+price);
		try {
			Product product = service.findById(id);
			product.setPrice(product.getPrice().add(price));
			service.update(product);
			return new ResponseEntity<String>("Congrats! Product with id " + id + " is successfully updated!",HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>("Sorry! Product with id " + id + " not found",HttpStatus.OK);
		}
		
	}
}

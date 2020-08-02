package com.sterlite.demo.spring.core.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@Component
public class Product {
	
	@Value("1001")
	private int id;
	@Value("Laptop")
	private String name;
	@Value("HP")
	private String brand;
	@Value("56000.00")
	private float price;
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
	
	

}

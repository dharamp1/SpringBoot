package com.sterlite.demo.spring.data.jdbc.services;

import java.util.List;

import com.sterlite.demo.spring.data.jdbc.entities.Product;
import com.sterlite.demo.spring.data.jdbc.exceptions.ProductNotFoundException;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
public interface IProductService {
	
	Product findById(long id) throws ProductNotFoundException;
	List<Product> findAll();
	void add(Product product);
	void update(Product product);
	void delete(Product product);
	long countProducts();
	
	List<Product> findByPriceRange(float minPrice,float maxPrice);

}

package com.sterlite.demo.spring.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.sterlite.demo.spring.entities.Product;
import com.sterlite.demo.spring.exceptions.ProductNotFoundException;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
public interface IProductService {
	Product findById(BigInteger id) throws ProductNotFoundException;
	List<Product> findAll();
	void add(Product product);
	void update(Product product);
	void delete(Product product);
	long countProducts();
	
	List<Product> findByPriceRange(BigDecimal minPrice,BigDecimal maxPrice);
}

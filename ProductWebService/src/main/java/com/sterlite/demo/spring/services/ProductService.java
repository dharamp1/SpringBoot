package com.sterlite.demo.spring.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sterlite.demo.spring.entities.Product;
import com.sterlite.demo.spring.exceptions.ProductNotFoundException;
import com.sterlite.demo.spring.repositories.ProductRepository;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@Service
public class ProductService implements IProductService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	ProductRepository productRepo;

	@Override
	public Product findById(BigInteger id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return productRepo.findById(id).orElseThrow(()->new ProductNotFoundException("Sorry! Product not found"));
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		productRepo.save(product);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		if(productRepo.existsById(product.getId()))
			productRepo.saveAndFlush(product);
		else
			LOGGER.info("Product could not found");
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		if(productRepo.existsById(product.getId()))
			productRepo.delete(product);
		else
			LOGGER.info("Product could not found");
	}

	@Override
	public long countProducts() {
		// TODO Auto-generated method stub
		return productRepo.count();
	}

	@Override
	public List<Product> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
		// TODO Auto-generated method stub
		//return productRepo.findByPriceBetween(minPrice, maxPrice);
		return null;
	}

}

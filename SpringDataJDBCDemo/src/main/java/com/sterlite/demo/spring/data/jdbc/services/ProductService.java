package com.sterlite.demo.spring.data.jdbc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sterlite.demo.spring.data.jdbc.dao.ProductRepository;
import com.sterlite.demo.spring.data.jdbc.entities.Product;
import com.sterlite.demo.spring.data.jdbc.exceptions.ProductNotFoundException;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@Service
public class ProductService implements IProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product findById(long id) throws ProductNotFoundException{
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product is not found"));
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(product->products.add(product));
		return products;
	}

	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		if(productRepository.existsById(product.getId()))
			productRepository.save(product);
		else
			System.out.println("Product could not be updated");
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		if(productRepository.existsById(product.getId()))
			productRepository.delete(product);
		else
			System.out.println("Product could not be delete");
	}
	
	@Override
	public long countProducts() {
		// TODO Auto-generated method stub
		return productRepository.count();
	}
	
	@Override
	public List<Product> findByPriceRange(float minPrice, float maxPrice) {
		// TODO Auto-generated method stub
		return productRepository.findByPriceBetween(minPrice, maxPrice);
	}
}

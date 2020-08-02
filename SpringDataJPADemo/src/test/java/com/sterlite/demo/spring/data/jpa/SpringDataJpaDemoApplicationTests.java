package com.sterlite.demo.spring.data.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sterlite.demo.spring.data.jpa.dao.ProductRepository;
import com.sterlite.demo.spring.data.jpa.entities.Product;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@SpringBootTest
class SpringDataJpaDemoApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void findById() {
		
		Product product = new Product("Washing Machine", "Samsung", 47000.00f);
		productRepository.save(product);
		
		Optional<Product> optional = productRepository.findById(product.getId());
		//assertThat(optional.get().getName()).isEqualTo("Washing Machine");	
	}
	
	@Test
	void findByPriceRange() {
		assertThat(productRepository.findByPriceBetween(40000.00f, 50000.00f)).hasSize(3);
	}
	
	@Test
	void findByBrandFirstLetter() {
		
		List<String> productNames = productRepository.findByBrandFirstLetter("S");
		for(String name:productNames)
			assertThat(name).startsWith("R"); 
	}
	
	@Test
	void updateNameById() {
		Optional<Product> proOptional = productRepository.findById(1006L);
		
		productRepository.updateNameById(proOptional.get().getId(), "Washing Machine Nxt Super");
		
		assertThat(productRepository.findById(1006L).get().getName()).isEqualTo("Washing Machine Nxt Super");
		
	}

}

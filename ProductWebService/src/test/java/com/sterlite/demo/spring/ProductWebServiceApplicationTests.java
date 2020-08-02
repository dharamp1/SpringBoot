package com.sterlite.demo.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sterlite.demo.spring.entities.Product;
import com.sterlite.demo.spring.repositories.ProductRepository;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@SpringBootTest
class ProductWebServiceApplicationTests {
	
	@Autowired
	ProductRepository repo;

	@Test
	void insertRecord() {
		
		Product product = new Product("abc", "xyz", new BigDecimal(4000.00));
		Product dbProduct = repo.save(product);
		assertThat(dbProduct.getId()).isEqualTo(product.getId());
	}

}

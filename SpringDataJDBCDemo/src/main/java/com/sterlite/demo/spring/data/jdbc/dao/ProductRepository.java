package com.sterlite.demo.spring.data.jdbc.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sterlite.demo.spring.data.jdbc.entities.Product;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	
	List<Product> findByPriceBetween(float minPrice,float maxPrice);
	
	List<Product> findByName(String name);
	
	@Query("select name from product where brand like :br || '%'  ")
	List<String> findByBrandFirstLetter(@Param("br")  String brand);
	
	@Modifying
	@Query("update product set name = :nm where id = :id")
	void updateNameById( @Param("id") long id, @Param("nm") String name);

}

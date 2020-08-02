package com.sterlite.demo.spring.data.jpa.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sterlite.demo.spring.data.jpa.entities.Product;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	  List<Product> findByPriceBetween(float minPrice,float maxPrice);
	  
	  List<Product> findByName(String name);
	  
	  List<Product> findByNameAndBrand(String name,String brand);
	  
	  @Query("select p.name from Product p where p.brand like :br || '%'  ")
	  List<String> findByBrandFirstLetter(@Param("br") String brand);
	  
	  @Modifying
	  @Query("update Product p set p.name = ?2 where p.id = ?1") void
	  updateNameById(long id, String name);
	 

}

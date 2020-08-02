package com.sterlite.demo.spring.entities;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import net.bytebuddy.implementation.auxiliary.AuxiliaryType.SignatureRelevant;

/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@Entity
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue
	//@Column(precision = 4)
	private BigInteger id;
	
	//@Column(length = 30)
	private String name;
	@Column(length = 30)
	private String brand;
	
	@Column(precision = 12,scale = 2)
	private BigDecimal price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Product(BigInteger id, String name, String brand, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	

	public Product(String name, String brand, BigDecimal price) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	

	public BigInteger getId() {
		return id;
	}



	public void setId(BigInteger id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
}

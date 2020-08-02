package com.sterlite.demo.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.sterlite.demo.spring.entities.Product;
import com.sterlite.demo.spring.services.IProductService;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@Controller
public class ProductViewController {
	
	@Autowired
	private IProductService service;
	
	@GetMapping("/allproducts")
	public String viewProducts() {
		return "productsinfo";
	}

	@GetMapping("/productreport")
	public String viewProductsPdf(ModelMap map){
		List<Product> products = service.findAll();
		map.addAttribute("products", products);
		return "productdetails";
	}
}

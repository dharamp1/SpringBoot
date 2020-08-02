package com.sterlite.demo.spring.data.jpa;


import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sterlite.demo.spring.data.jpa.entities.Product;
import com.sterlite.demo.spring.data.jpa.services.ProductService;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@SpringBootApplication
@EnableJpaRepositories
public class SpringDataJpaDemoApplication implements CommandLineRunner {
	
	@Autowired
	ProductService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String answer = "";
		
		do {
			System.out.println("****MENU****");
			System.out.println("INSERT");
			System.out.println("UPDATE");
			System.out.println("DELETE");
			System.out.println("FIND_BY_ID");
			System.out.println("FIND_ALL");
			System.out.println("EXIT");
			System.out.println("Enter Your Choice:");
			String choice = sc.next();
			switch (choice.trim()) {
			case "INSERT":
				System.out.println("Enter data of product to be added: ");
				System.out.println("Enter product name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter brand: ");
				String brand = sc.nextLine();
				System.out.println("Enter price: ");
				float price = sc.nextFloat();
				service.add(new Product(name, brand, price));
				break;
			
			case "UPDATE":
				System.out.println("Enter id of product to be updated: ");
				long id = sc.nextLong();
				Product product = service.findById(id);
				float oldPrice = product.getPrice();
				System.out.println("old Price: "+oldPrice);
				System.out.println("Enter new : ");
				float newPrice = sc.nextFloat();
				product.setPrice(newPrice);
				service.update(product);
				break;
				
			case "DELETE":
				System.out.println("Enter id of product to be delete: ");
				id = sc.nextLong();
				product = service.findById(id);
				service.delete(product);
				break;		
				
			case "FIND_BY_ID":
				System.out.println("Enter id of product to be searched for: ");
				id = sc.nextLong();
				System.out.println(service.findById(id));
				break;	
				
			case "FIND_ALL":
				service.findAll().forEach(System.out::println);
				break;	
			
			case "EXIT":
				System.exit(0);
				break;	
				
			default: System.out.println("Please enter correct choice:");
		}
		System.out.println("Do you want to continue?(y/Y)");
		answer = sc.next();
		}while (answer.equals("y")||answer.equals("Y"));
		
		sc.close();
		
	}

}

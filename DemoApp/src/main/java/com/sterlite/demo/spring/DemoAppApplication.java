package com.sterlite.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sterlite.demo.spring.performers.Performer;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@SpringBootApplication
public class DemoAppApplication implements ApplicationRunner{
	
	@Autowired
	ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
		System.out.println("Hello World!");
	}

	/*@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		for(String arg: args)
			System.out.println(arg);
		
		Performer performer = context.getBean("instrumentalist", Performer.class);
		performer.perform();
	}*/
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		for(String arg:args.getSourceArgs()) {
			System.out.println(arg);
		}
		
		for(String arg:args.getOptionNames())
			System.out.println(arg);
	}	

}

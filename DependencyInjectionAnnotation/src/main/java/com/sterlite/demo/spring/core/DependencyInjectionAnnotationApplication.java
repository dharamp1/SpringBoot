package com.sterlite.demo.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava.Range;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.ApplicationContext;

import com.sterlite.demo.spring.core.performers.Instrumentalist;
import com.sterlite.demo.spring.core.performers.Performer;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@ConditionalOnJava(value=JavaVersion.EIGHT,range = Range.EQUAL_OR_NEWER)
@SpringBootApplication
public class DependencyInjectionAnnotationApplication implements ApplicationRunner {
	
	@Autowired
	ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(DependencyInjectionAnnotationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		for(String s: args.getSourceArgs())
			System.out.println(s);
		
		args.getOptionNames().forEach(System.out::println);
		
		Performer p = context.getBean("Mahesh Kumar", Performer.class);
		p.perform();
	}

}

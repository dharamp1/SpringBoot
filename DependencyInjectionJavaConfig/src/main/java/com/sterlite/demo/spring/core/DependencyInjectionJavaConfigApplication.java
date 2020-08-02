package com.sterlite.demo.spring.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.sterlite.demo.spring.config.PerformerConfig;
import com.sterlite.demo.spring.core.instruments.Guitar;
import com.sterlite.demo.spring.core.instruments.Instrument;
import com.sterlite.demo.spring.core.performers.Instrumentalist;
import com.sterlite.demo.spring.core.performers.Performer;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@SpringBootApplication
@Import({PerformerConfig.class})
public class DependencyInjectionJavaConfigApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DependencyInjectionJavaConfigApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionJavaConfigApplication.class, args);
		
		LOGGER.info("Contains bean definition guitar: " + context.containsBeanDefinition("guitar"));
		LOGGER.info("Contains bean definition mohanKumar: " + context.containsBeanDefinition("mohanKumar"));
		LOGGER.info("Contains bean definition radhikaPatil: " + context.containsBeanDefinition("radhikaPatil"));
		
		Performer performer1 = context.getBean("mohanKumar", Performer.class);
		performer1.perform();
		
		Performer performer2 = context.getBean("somePerformer", Performer.class);
		performer2.perform();
		
		
	}
	
	@Bean
	Instrument myGuitar() {
		return new Guitar();
	}
	
	@Bean
	Performer somePerformer(Guitar guitar) {
		Instrumentalist instrumentalist = new Instrumentalist(guitar);
		instrumentalist.setSong("Aaj kal...");
		return instrumentalist;
	}
	
}

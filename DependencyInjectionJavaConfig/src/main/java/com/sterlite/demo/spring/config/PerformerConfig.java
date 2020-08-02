package com.sterlite.demo.spring.config;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sterlite.demo.spring.core.instruments.Guitar;
import com.sterlite.demo.spring.core.instruments.Instrument;
import com.sterlite.demo.spring.core.performers.Instrumentalist;
import com.sterlite.demo.spring.core.performers.Performer;

@Configuration
public class PerformerConfig {

	@Bean
	public Instrument guitar() {
		
		return new Guitar();
	}
	
	@Bean
	public Performer mohanKumar(Guitar guitar) {
		Instrumentalist instrumentalist = new Instrumentalist("Samaa He Suhana Suhana..",guitar);
		return instrumentalist;
	}
	
	@Bean
	public Performer radhikaPatil(Guitar guitar) {
		Instrumentalist instrumentalist = new Instrumentalist();
		instrumentalist.setSong("Nile Nile Ambar Pe..");
		instrumentalist.setInstrument(guitar);
		return instrumentalist;
	}
}

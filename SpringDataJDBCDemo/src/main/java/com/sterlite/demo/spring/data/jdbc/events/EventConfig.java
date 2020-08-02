package com.sterlite.demo.spring.data.jdbc.events;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.AbstractRelationalEventListener;
import org.springframework.data.relational.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.relational.core.mapping.event.AfterSaveEvent;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;

import com.sterlite.demo.spring.data.jdbc.entities.Product;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@Configuration
public class EventConfig {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EventConfig.class);
	
	@Bean
	ApplicationListener<BeforeSaveEvent<Object>> logSaveEntities(){
		ApplicationListener<BeforeSaveEvent<Object>> listener = event-> { 
			//LocalDateTime dateTime = new Date(event.getTimestamp()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			ZonedDateTime dateTime = new Date(event.getTimestamp()).toInstant().atZone(ZoneId.systemDefault());
			LOGGER.info("On "+   dateTime + "  Saved Entity: " + event.getEntity()); };
			
			
		return listener;
	}
	
	@Bean
	ProductEventListener productEventListener() {
		return new ProductEventListener();
	}
	
	private static class ProductEventListener extends AbstractRelationalEventListener<Product>{
		
		@Override
		protected void onAfterDelete(AfterDeleteEvent<Product> event) {
			// TODO Auto-generated method stub
			
			ZonedDateTime dateTime = new Date(event.getTimestamp()).toInstant().atZone(ZoneId.systemDefault());
			
			LOGGER.info("Deleted Entity : " + event.getEntity() + " on " + dateTime);
		} 
		
		
		@Override
		protected void onAfterSave(AfterSaveEvent<Product> event) {
			// TODO Auto-generated method stub
			LocalDateTime dateTime = new Date(event.getTimestamp()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss");
			
			
			LOGGER.info("Updated Entity : " + event.getEntity() + " on " + formatter.format(dateTime));
		}
		
	}

}

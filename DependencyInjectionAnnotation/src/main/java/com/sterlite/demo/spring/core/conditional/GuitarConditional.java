package com.sterlite.demo.spring.core.conditional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
public class GuitarConditional implements Condition {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GuitarConditional.class);
	
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		
		try {
			LOGGER.info("Inside GuitarConditional");
			context.getClassLoader().loadClass("com.sterlite.demo.spring.core.instruments.Guitar");
			LOGGER.info("Loaded class Guitar");
			if(metadata.isAnnotated("org.springframework.stereotype.Component")) {
				LOGGER.info("Guitar is Component");
				return true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}

package com.sterlite.demo.spring.core.instruments;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@Component
public class Guitar implements Instrument {
	
	@Value("guitar")
	private String name;
	
	public String getName() {
		return name;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Guitar is playing");
	}

}

package com.sterlite.demo.spring.instruments;

import org.springframework.stereotype.Component;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@Component
public class Guitar implements Instrument {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "guitar";
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Guitar is playing");
	}

}

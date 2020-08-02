package com.sterlite.demo.spring.performers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.sterlite.demo.spring.instruments.Guitar;
import com.sterlite.demo.spring.instruments.Instrument;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@Component
public class Instrumentalist implements Performer {
	
	@Value("Dil Deke Dekho..")
	private String song;
	
	@Autowired
	@Qualifier("piano")
	private Instrument instrument;
	
	

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("Instrumentalist is playing a song.." + song);
		instrument.play();
	}

}

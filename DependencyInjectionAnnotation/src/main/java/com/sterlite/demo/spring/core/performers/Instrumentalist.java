package com.sterlite.demo.spring.core.performers;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import com.sterlite.demo.spring.core.conditional.GuitarConditional;
import com.sterlite.demo.spring.core.instruments.Guitar;
import com.sterlite.demo.spring.core.instruments.Instrument;


//@Conditional(GuitarConditional.class)
//@ConditionalOnClass(Guitar.class)
@ConditionalOnBean(name = "guitar")
@Component("Mahesh Kumar")
public class Instrumentalist implements Performer {
	
	@Value("Dil Deke Dekho")
	private String song;
	
	@Autowired
	private Instrument instrument;
	
	@PostConstruct
	public void prepared() {
		System.out.println("Got instrument: " + instrument.getName());
		System.out.println("And song: " + song);
		System.out.println("Now prepared to perform");
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("Instrumentalist is playing a song " + song);
		instrument.play();
	}

}

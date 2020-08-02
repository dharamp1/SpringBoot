package com.sterlite.demo.spring.core.performers;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sterlite.demo.spring.core.instruments.Instrument;


public class Instrumentalist implements Performer {
	
	private String song;
	
	private Instrument instrument;
	
	public Instrumentalist() {
		// TODO Auto-generated constructor stub
	}
	
	public Instrumentalist(Instrument instrument) {
		super();
		this.instrument = instrument;
	}

	public Instrumentalist(String song, Instrument instrument) {
		super();
		this.song = song;
		this.instrument = instrument;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("Instrumentalist is playing a song " + song);
		instrument.play();
	}

}

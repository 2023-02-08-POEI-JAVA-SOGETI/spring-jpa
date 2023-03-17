package com.bigcorp.booking.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bigcorp.booking.model.MonService;

@Component
public class MonControleurWeb {
	@Autowired
	private MonService monService;

	public void sayHello() {
		System.out.println("Hellooooooooooooooooooo");
	}

	public MonService getMonService() {
		return monService;
	}

	public void setMonService(MonService monService) {
		this.monService = monService;
	}
	
}

package com.bigcorp.booking.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bigcorp.booking.service.MonService;

@Component

public class MonControleurWeb {

	@Autowired
    private MonService monService;

	public MonService getMonService() {
		return monService;
	}

	public void setMonService(MonService monService) {
		this.monService = monService;
	}
	
	

}

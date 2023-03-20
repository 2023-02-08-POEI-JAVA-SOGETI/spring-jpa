package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

@Component
public class MonControlerWeb {
	@Autowired
	private MonService monService;

	public MonService getMonService() {
		return this.monService;
	}

	public void setMonService(MonService monService) {
		this.monService = monService;
	}
	
	
}

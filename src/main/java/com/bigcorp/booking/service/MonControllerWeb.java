package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MonControllerWeb {
	
	@Autowired
	private MonService monService;
	
	public MonService getMonService() {
		return monService;
	}
}

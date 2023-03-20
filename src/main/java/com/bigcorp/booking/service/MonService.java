package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class MonService {

	@Autowired
    private MonSpringDao monSpringDao;	
		
	public MonSpringDao getMonSpringDao() {		
		return monSpringDao;
	}

	public void setMonDao(MonSpringDao monDao) {
		this.monSpringDao = monDao;
	}
	
	
}

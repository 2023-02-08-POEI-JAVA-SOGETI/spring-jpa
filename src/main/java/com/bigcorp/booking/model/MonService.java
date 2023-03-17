package com.bigcorp.booking.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bigcorp.booking.dao.MonDao;

@Component
public class MonService {
	@Autowired
	private MonDao monDao;
	
	public MonService() {
		System.out.println("Mon Service");
	}

	public MonDao getMonDao() {
		return monDao;
	}

	public void setMonDao(MonDao monDao) {
		this.monDao = monDao;
	}
	
}

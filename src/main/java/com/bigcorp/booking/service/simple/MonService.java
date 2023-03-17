package com.bigcorp.booking.service.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonService {
	
	@Autowired
	private MonDao monDao;

	public MonDao getMonDao() {
		return this.monDao;
	}

	public void setMonDao(MonDao monDao) {
		this.monDao = monDao;
	}

	

}

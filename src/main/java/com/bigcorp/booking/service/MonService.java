package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonService {
	
	@Autowired
	private MonDao monDao;
	
	public MonDao getMonDao() {
		return monDao;
	}
	
	public void affiche() {
		System.out.println("Voici la classe MonService");
	}
}

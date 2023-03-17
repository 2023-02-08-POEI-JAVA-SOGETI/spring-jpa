package com.bigcorp.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MonDao {

	@Autowired
	private MonControllerWeb monControllerWeb;

	public void affiche() {
		System.out.println("Voici la classe MonDao");
	}
}

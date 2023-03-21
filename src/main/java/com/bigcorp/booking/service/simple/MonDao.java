package com.bigcorp.booking.service.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MonDao {

	@Autowired
	private MonControllerWeb monControllerWeb;

	public void affiche() {
		System.out.println("Voici la classe MonDao");
	}

	public MonControllerWeb getMonControllerWeb() {
		return monControllerWeb;
	}

	public void setMonControllerWeb(MonControllerWeb monControllerWeb) {
		this.monControllerWeb = monControllerWeb;
	}
}

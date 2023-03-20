package com.bigcorp.booking.service.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClasseC {
	
	@Autowired
	private ClasseA classeA;

	public void affiche() {
		System.out.println("Salut de la classe C");
	}
	
}
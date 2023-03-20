package com.bigcorp.booking.service.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClasseB {
	
	@Autowired
	private ClasseC classeC;

	public ClasseC getClasseC() {
		return classeC;
	}

	public void setClasseC(ClasseC classeC) {
		this.classeC = classeC;
	}

	public void affiche() {
		System.out.println("coucou");
	}

}
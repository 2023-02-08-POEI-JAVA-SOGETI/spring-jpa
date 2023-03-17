package com.bigcorp.booking.service.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClasseA {

	@Autowired
	private ClasseB classeB;

	public ClasseB getClasseB() {
		return classeB;
	}

}
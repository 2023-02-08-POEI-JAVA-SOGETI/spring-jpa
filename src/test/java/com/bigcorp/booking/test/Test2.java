package com.bigcorp.booking.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.service.simple.MonControleurWeb;
import com.bigcorp.booking.service.simple.MonDao;
import com.bigcorp.booking.spring.SpringSimpleConfiguration;

@SpringJUnitConfig(SpringSimpleConfiguration.class)
public class Test2 {
	@Autowired
	private MonDao monControleur;

	@Test
	public void testQuiMarche() {
		Assertions.assertNotNull(monControleur);
	}
}

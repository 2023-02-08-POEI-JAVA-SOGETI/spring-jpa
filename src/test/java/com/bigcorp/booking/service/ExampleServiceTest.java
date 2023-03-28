package com.bigcorp.booking.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class ExampleServiceTest {
	
	@Autowired
	private ExampleService exampleService;

	@Test
	public void testFindByNom() {
		exampleService.findByNom("test");
	}

}

package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.service.ExampleService;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class ExampleSpringDaoTest {

	@Autowired
	private ExampleService exampleService;

	@Test
	public void testSave() {
		Example example = new Example();
		exampleService.save(example);
		Assertions.assertNotNull(example);
		Assertions.assertNotNull(example.getId());
	}

}

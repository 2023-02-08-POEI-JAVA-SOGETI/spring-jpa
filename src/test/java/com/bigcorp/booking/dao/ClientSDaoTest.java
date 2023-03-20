package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.service.ClientService;
import com.bigcorp.booking.spring.SpringConfiguration;

import tp_spring_jpa_pablo.model.Client;

@SpringJUnitConfig(SpringConfiguration.class)
public class ClientSDaoTest {

	@Autowired
	private ClientService clientService;

	@Test
	public void testSave() {
		Client client = new Client();
		clientService.save(client);
		Assertions.assertNotNull(client);
		Assertions.assertNotNull(client.getId());
	}
	  

}

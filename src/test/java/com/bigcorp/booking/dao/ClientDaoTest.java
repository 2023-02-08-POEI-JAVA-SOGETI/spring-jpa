package com.bigcorp.booking.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.service.ClientService;
import com.bigcorp.booking.spring.SpringConfiguration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SpringJUnitConfig(SpringConfiguration.class)
public class ClientDaoTest {
	
	@Autowired
	private ClientService clientService;
		
		@Test
		@DisplayName("Testing if service correctly saves a client")
		public void testSave() {
			Client client = new Client(345, "Georges", "Brassens", "georges@mail.com", "Avenue de l'opéra");
			clientService.save(client);
			Assertions.assertNotNull(client);
			Assertions.assertNotNull(client.getId());
				
		}
}
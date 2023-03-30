package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Clients;
import com.bigcorp.booking.service.ClientsService;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)

class ClientsTest {

	@Autowired
	private ClientsService clientService;

	@Test
	public void testSaveGet() {
	 Clients client = new Clients();
	 client.setNom("client-test");
	 Clients clientSauvegarde = this.clientService.save(client);
	 Assertions.assertNotNull(clientSauvegarde);
	 Assertions.assertNotNull(clientSauvegarde.getId());
	 Clients clientRecupere = this.clientService.findById(clientSauvegarde.getId());
	 Assertions.assertNotNull(clientRecupere);
	}
	
	
	 
	}

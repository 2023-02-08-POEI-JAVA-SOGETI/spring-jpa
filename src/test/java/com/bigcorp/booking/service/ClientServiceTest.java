package com.bigcorp.booking.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class ClientServiceTest {
	
	@Autowired
	private ClientService clientService;

	@Test
	public void testSaveGet() {
		Client client = new Client();
		client.setNom("Jean-Spring");
		Client clientSauvegarde = this.clientService.save(client);
		
		Assertions.assertNotNull(clientSauvegarde);
		Assertions.assertNotNull(clientSauvegarde.getId());
		
		Client clientRecupere = this.clientService.findById(clientSauvegarde.getId());
		Assertions.assertNotNull(clientRecupere);
	}

	@Test
	public void testDelete() {
		Client client = new Client();
		Client clientSauvegarde = this.clientService.save(client);
		this.clientService.delete(clientSauvegarde.getId());
		
		Client clientRecupere = this.clientService.findById(clientSauvegarde.getId());
		Assertions.assertNull(clientRecupere);
	}

}

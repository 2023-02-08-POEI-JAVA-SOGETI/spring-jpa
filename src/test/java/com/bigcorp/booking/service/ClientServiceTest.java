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
	public void saveClientTest() {
		Client client = new Client();
		client.setNom("alexalex");
		client.setNum(5236);
		client.setPrenom("alex");
		client.setEmail("alex@alex.com");
		client.setAdresse("chez Alex à Alexville");
		clientService.save(client);
		
		Assertions.assertNotNull(client);
		Assertions.assertNotNull(client.getId());
	}
	
	@Test
	public void testFindByName() {
		Client clientSecond = new Client("akiraakira", "akira", 12456, "akira@akira.com", "akirastreet akiraville");
		Client akira = clientService.save(clientSecond);
		Assertions.assertNotNull(akira);
		clientService.findByNom("akiraakira");
	}
	
	@Test
	public void testFindById() {
		Client clientTroisieme = new Client("georgesgeorges", "georges", 4899, "georges@georges.com", "georgesStreet georgesCity");
		clientService.save(clientTroisieme);
		Client client1 = clientService.findById(4);
		Assertions.assertEquals(client1.getPrenom(), "georges");
	}
	
	@Test
	public void delete() {		
		Client clientSuppr = new Client("edeneden", "eden", 8562, "eden@eden.com", "edenStreet edenCity");
		Client eden = clientService.save(clientSuppr);
		Assertions.assertNotNull(eden);
		clientService.delete(1);
		Assertions.assertNull(clientService.findById(1));
	}
}

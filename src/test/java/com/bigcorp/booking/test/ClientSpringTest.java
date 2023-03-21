package com.bigcorp.booking.test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.service.ClientService;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class ClientSpringTest {

	@Autowired
	public ClientService clientService;
	
	@Test
	public void testSave() {
		Client client = new Client();
		client.setNom("Janet");
		client.setPrenom("doe");
		client.setAdresse("1rue lorem ipsum");
		client.setEmail("janetdoe@gmail.com");
		client.setNumero(4013);
		
		@SuppressWarnings("unused")
		Client savedClient = clientService.save(client);
		
		List<Client> clients = (List<Client>) clientService.findAll();
		for (Client c : clients)
		Assertions.assertEquals(c.getNom(),"Janet");
		
	}
}

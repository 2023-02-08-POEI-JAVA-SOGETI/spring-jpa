package com.bigcorp.booking.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.service.ClientService;
import com.bigcorp.booking.spring.SpringConfiguration;

import tp_spring_jpa_pablo.model.Client;

@SpringJUnitConfig(SpringConfiguration.class)
public class ClientSpringDaoTest {

	@Autowired
	private ClientService clientService;

	@Test
	public void testSave() {
		Client client = new Client();
		clientService.save(client);
		Assertions.assertNotNull(client);
		Assertions.assertNotNull(client.getId());
	}
	
	//This test creates a new client, saves it to the database, and then retrieves it using the findById method. 
	//It then verifies that the retrieved client has the same ID as the original client.	
	@Test
	public void testFindById() {
	    Client client = new Client();
	    clientService.save(client);

	    Client foundClient = clientService.findById(client.getId());
	    Assertions.assertEquals(client.getId(), foundClient.getId());
	}
	
	//This test creates a new client, saves it to the database, deletes it using the deleteById method, 
	//and then attempts to retrieve it using the findById method. It then verifies that the deleted client 
	//is no longer in the database.	
	@Test
	public void testDeleteById() {
	    Client client = new Client();
	    clientService.save(client);

	    clientService.deleteById(client.getId());

	    Client deletedClient = clientService.findById(client.getId());
	    Assertions.assertNull(deletedClient);
	}
	
	@Test
	public void testFindByNom() {
	    Client client1 = new Client();
	    client1.setNom("John");
	    clientService.save(client1);

	    Client client2 = new Client();
	    client2.setNom("Jane");
	    clientService.save(client2);

	    Iterable<Client> foundClients = clientService.findByNom("John");

	    List<Client> clientList = new ArrayList<>();
	    foundClients.forEach(clientList::add);

	    Assertions.assertEquals(1, clientList.size());
	    Assertions.assertEquals(client1.getId(), clientList.get(0).getId());
	}


	
}

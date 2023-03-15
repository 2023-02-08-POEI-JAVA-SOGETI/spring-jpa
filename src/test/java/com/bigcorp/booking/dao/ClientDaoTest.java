package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Client;

public class ClientDaoTest {

	@Test
	public void testSave() {
				
		Client client = new Client();
		ClientDao clientDao = new ClientDao();

		String nom = "maxmax";
		String prenom = "max";
		Integer num = 321;
		String email = "max@max.com";
		String adresse = "chez max 01234 maxville";
		
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setNum(num);
		client.setEmail(email);
		client.setAdresse(adresse);
		
		Client savedClient = clientDao.merge(client);
		Assertions.assertNotNull(savedClient.getId());
		
		Client clientBdd = clientDao.findById(Client.class, savedClient.getId());
		Assertions.assertEquals(prenom, clientBdd.getPrenom());
	}
	
	@Test
	public void testPersist() {
				
		Client client = new Client();
		ClientDao clientDao = new ClientDao();

		String nom = "loulou";
		String prenom = "lou";
		Integer num = 654;
		String email = "lou@lou.com";
		String adresse = "chez lou 01234 louville";
		
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setNum(num);
		client.setEmail(email);
		client.setAdresse(adresse);
		
		clientDao.persist(client);
		Assertions.assertNotNull(client.getId());
	}

}

package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Client;

public class ClientDaoTest {

	@Test
	public void testSave() {
		String nom = "Cook";
		String prenom = "Tim";

		ClientDao clientDao = new ClientDao();
		Client client = new Client();

		client.setNom(nom);
		client.setPrenom(prenom);

		Client savedClient = clientDao.merge(client);

		Assertions.assertNotNull(savedClient.getId());

		Client clientRecord = clientDao.findById(savedClient.getId());

		Assertions.assertEquals(nom, clientRecord.getNom());
		Assertions.assertEquals(prenom, clientRecord.getPrenom());
	}

	@Test
	public void testSaveTwo() {

		String nom = "Bezos";
		ClientDao clientDao = new ClientDao();
		Client client = new Client();

		client.setNom(nom);
		client.setEmail("jeffbezos@amazon.com");

		Client savedClient = clientDao.merge(client);

		Assertions.assertNotNull(savedClient.getId());
	}
}

package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.service.ClientService;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class ClientSpringDaoTest {

	@Autowired
	private ClientService clientService;

	@Test

	public void testsauvegarde() {
		Client client = new Client();
		client.setNom("Jaguar");

		client.setNumero(1234);
		clientService.sauvegarde(client);
		Assertions.assertNotNull(client.getId());
	}

	@Test
	public void testfindByNom() {
		Client client = new Client();
		client.setNom("Jeep");

		client.setNumero(1235);
		clientService.sauvegarde(client);

		List<Client> clientDelaBase = clientService.findByNom(client.getNom());

		Assertions.assertFalse(clientDelaBase.isEmpty());
	}

	@Test
	public void testget() {
		Client client = new Client();
		client.setNom("range rover");

		client.setNumero(1237);
		clientService.sauvegarde(client);

		Client clientDeLaBase = clientService.get(client.getId());
		Assertions.assertNotNull(clientDeLaBase);
	}

	@Test
	public void testsupprimmer() {
		Client client = new Client();
		client.setNom("Jm Motor");
		client.setNumero(0000);
		clientService.sauvegarde(client);

		Assertions.assertNotNull(client);
		clientService.supprimer(client.getId());
		Client clientDeLaBase = clientService.get(client.getId());
		Assertions.assertNull(clientDeLaBase);

	}

}

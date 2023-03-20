package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Client;

public class ClientDaoTest extends AbstractDao<Client> {

	@Test
	public void testSave() {
		ClientDao clientDao = new ClientDao();
		Client client = new Client();
		client.setNom("NGOM");
		Client savedClient = clientDao.merge(client);
		Assertions.assertNotNull(savedClient.getId());

	}
}
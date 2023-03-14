package com.bigcorp.booking.dao;

import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Client;

public class ClientDaoTest {
	
	@Test
	public void testSave() {
	
		Random random = new Random();
		ClientDao clientDao = new ClientDao();
		Client client1 = new Client();
		client1.setNumero(random.nextInt(10000));
		client1.setNom("vittaz");
		client1.setPrenom("lucas");
		client1.setEmail("lucasvittaz.pro@gmail.com");
		client1.setAdresse("58 av des mimosas");
		
		Client savedclient1 = clientDao.merge(client1);
		Assertions.assertNotNull(savedclient1.getId());
		Client exampleDeLaBaseDeDonnees1 = clientDao.findById(Client.class, savedclient1.getId());
		Assertions.assertEquals(client1.getNom(), exampleDeLaBaseDeDonnees1.getNom());
		
	}
}
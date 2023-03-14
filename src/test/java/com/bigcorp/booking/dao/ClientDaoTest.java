package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Client;

public class ClientDaoTest {
	  
    @Test
    public void testSave() {
    	
		ClientDao dao = new ClientDao();
		Client client = new Client();
		String nomClient = "va";
		String prenomClient = "sam";
		String mail = "sam.va@lycos.fr";
		String adresse = "6 rue des églantines, 88900 La mothe beuvron";
		int numeroUnique = 13;
		client.setNom(nomClient);
		client.setAdresse(adresse);
		client.setEmail(mail);
		client.setPrenom(prenomClient);
		client.setNumero(numeroUnique);
		Client clientSauvegarde = dao.merge(client);
		
		Assertions.assertNotNull(clientSauvegarde.getId());
		
		Client clientLu = dao.findById(Client.class,clientSauvegarde.getId());
		
		Assertions.assertEquals(nomClient, clientLu.getNom());
		Assertions.assertEquals(prenomClient, clientLu.getPrenom());
		Assertions.assertEquals(mail, clientLu.getEmail());
		Assertions.assertEquals(adresse, clientLu.getAdresse());
		Assertions.assertEquals(numeroUnique, clientLu.getNumero());
		
    }
    
    public void testPersist() {
		ClientDao clientDao = new ClientDao();
		Client client = new Client();
		int numeroUnique = 13;
		
		client.setNumero(numeroUnique);
		
		clientDao.persist(client);
		
		
		Assertions.assertNotNull(client.getId());
    }
	  
   
}
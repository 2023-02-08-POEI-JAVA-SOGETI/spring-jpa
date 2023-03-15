package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Client;

import junit.framework.Assert;

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
    
    @Test
    public void testGetParNom() {
		ClientDao clientDao = new ClientDao();
    	Client client1 = new Client();
    	String nomDurand = "leNomDurandDuTestGetParNom";
		client1.setNom(nomDurand);
		clientDao.merge(client1);
    	
    	Client client2 = new Client();
    	client2.setNom(nomDurand);
    	clientDao.merge(client2);
    	
    	List<Client> clients = clientDao.getParNom(nomDurand);
    	Assert.assertEquals(2, clients.size());
    	
    }
    
    @Test
    public void testGetParNomLikeInsensibleALaCasse() {
		ClientDao clientDao = new ClientDao();
    	Client client1 = new Client();
		client1.setNom("héoui, encoreUnNomRigolo, tiens");
		clientDao.merge(client1);
    	
    	Client client2 = new Client();
    	client2.setNom("encoreUnNomRigolo");
    	clientDao.merge(client2);
    	
    	Client client3 = new Client();
    	client3.setNom("unnomrigolo");
    	clientDao.merge(client3);
    	
    	List<Client> clients = clientDao.getParNomLikeInsensibleALaCasse("UnNomRigolo");
    	Assert.assertEquals(3, clients.size());
    	
    }
    
    @Test
    public void testGetParNomLikeSensibleALaCasse() {
    	ClientDao clientDao = new ClientDao();
    	Client client1 = new Client();
		client1.setNom("héoui, encoreUnNomMarrant, tiens");
		clientDao.merge(client1);
    	
    	Client client2 = new Client();
    	client2.setNom("encoreUnNomMarrant");
    	clientDao.merge(client2);
    	
    	Client client3 = new Client();
    	client3.setNom("encoreUnNommarrant");
    	clientDao.merge(client3);
    	
    	List<Client> clients = clientDao.getParNomLikeSensibleALaCasse("UnNomMarrant");
    	Assert.assertEquals(2, clients.size());
    	
    }
	  
   
}
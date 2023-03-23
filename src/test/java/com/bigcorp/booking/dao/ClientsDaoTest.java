package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Clients;

import junit.framework.Assert;

public class ClientsDaoTest {
	  
//    @Test
//    public void testSave() {
//    	
//		ClientsDao dao = new ClientsDao();
//		Clients client = new Clients();
//		String nomClient = "va";
//		String prenomClient = "sam";
//		String mail = "sam.va@lycos.fr";
//		String adresse = "6 rue des églantines, 88900 La mothe beuvron";
//		int numeroUnique = 13;
//		client.setNom(nomClient);
//		client.setAdresse(adresse);
//		client.setEmail(mail);
//		client.setPrenom(prenomClient);
//		client.setNumero(numeroUnique);
//		Clients clientSauvegarde = dao.merge(client);
//		
//		Assertions.assertNotNull(clientSauvegarde.getId());
//		
//		Clients clientLu = dao.findById(Clients.class,clientSauvegarde.getId());
//		
//		Assertions.assertEquals(nomClient, clientLu.getNom());
//		Assertions.assertEquals(prenomClient, clientLu.getPrenom());
//		Assertions.assertEquals(mail, clientLu.getEmail());
//		Assertions.assertEquals(adresse, clientLu.getAdresse());
//		Assertions.assertEquals(numeroUnique, clientLu.getNumero());
//		
//    }
    
    public void testPersist() {
		ClientsDao clientDao = new ClientsDao();
		Clients client = new Clients();
		int numeroUnique = 13;
		
		client.setNumero(numeroUnique);
		
		clientDao.persist(client);
		
		
		Assertions.assertNotNull(client.getId());
    }
    
    @Test
    public void testGetParNom() {
		ClientsDao clientDao = new ClientsDao();
    	Clients client1 = new Clients();
    	String nomDurand = "leNomDurandDuTestGetParNom";
		client1.setNom(nomDurand);
		clientDao.merge(client1);
    	
    	Clients client2 = new Clients();
    	client2.setNom(nomDurand);
    	clientDao.merge(client2);
    	
    	List<Clients> clients = clientDao.getParNom(nomDurand);
    	Assert.assertEquals(2, clients.size());
    	
    }
    
    @Test
    public void testGetParNomLikeInsensibleALaCasse() {
		ClientsDao clientDao = new ClientsDao();
    	Clients client1 = new Clients();
		client1.setNom("héoui, encoreUnNomRigolo, tiens");
		clientDao.merge(client1);
    	
    	Clients client2 = new Clients();
    	client2.setNom("encoreUnNomRigolo");
    	clientDao.merge(client2);
    	
    	Clients client3 = new Clients();
    	client3.setNom("unnomrigolo");
    	clientDao.merge(client3);
    	
    	List<Clients> clients = clientDao.getParNomLikeInsensibleALaCasse("UnNomRigolo");
    	Assert.assertEquals(3, clients.size());
    	
    }
    
    @Test
    public void testGetParNomLikeSensibleALaCasse() {
    	ClientsDao clientDao = new ClientsDao();
    	Clients client1 = new Clients();
		client1.setNom("héoui, encoreUnNomMarrant, tiens");
		clientDao.merge(client1);
    	
    	Clients client2 = new Clients();
    	client2.setNom("encoreUnNomMarrant");
    	clientDao.merge(client2);
    	
    	Clients client3 = new Clients();
    	client3.setNom("encoreUnNommarrant");
    	clientDao.merge(client3);
    	
    	List<Clients> clients = clientDao.getParNomLikeSensibleALaCasse("UnNomMarrant");
    	Assert.assertEquals(2, clients.size());
    	
    }
	  
   
}

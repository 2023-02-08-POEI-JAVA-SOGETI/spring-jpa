package com.bigcorp.booking.springTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


import java.util.List;

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
		Client client1 = new Client();
		client1.setNumero(100);
        client1.setNom("janette");
        client1.setPrenom("doe");
        client1.setEmail("janette.doe@gmail.com");
        client1.setAdresse("lorem");
        
        Client result = clientService.save(client1);
        assertEquals(client1, result);
    }

    @Test
    public void testDelete() {
    	Client client1 = new Client();
		client1.setNumero(100);
        client1.setNom("janette");
        client1.setPrenom("doe");
        client1.setEmail("janette.doe@gmail.com");
        client1.setAdresse("lorem");
        
        clientService.save(client1);
        clientService.delete(1);
        assertNull(clientService.findById(1));
    }

    public void testFindById() {
        Client client1 = new Client();
        client1.setNumero(100);
        client1.setNom("janette");
        client1.setPrenom("doe");
        client1.setEmail("janette.doe@gmail.com");
        client1.setAdresse("lorem");

        clientService.save(client1);
        Client result = clientService.findById(1);
        assertEquals(client1, result);
    }

//    @Test
//    public void testFindByName() {
//        Client client1 = new Client();
//        client1.setNumero(1021210);
//        client1.setNom("robert");
//        client1.setPrenom("doe");
//        client1.setEmail("janette.doe@gmail.com");
//        client1.setAdresse("lorem");
//
//        Client savedClient = clientService.save(client1);
//        List<Client> retrievedClients = clientService.findByName(savedClient.getNom());
//
//        for (Client c : retrievedClients) {
//            assertEquals(savedClient.getNom(), c.getNom());
//        }
//    }

    @Test
    public void testFindAll() {
    	Client client1 = new Client();
		client1.setNumero(100);
        client1.setNom("janette");
        client1.setPrenom("doe");
        client1.setEmail("janette.doe@gmail.com");
        client1.setAdresse("lorem");
        
        clientService.save(client1);
        
        Client client2 = new Client();
		client2.setNumero(666);
		client2.setNom("john");
		client2.setPrenom("doe");
		client2.setEmail("john.doe@gmail.com");
		client2.setAdresse("lorem");

        clientService.save(client2);
       
        List<Client> result = clientService.findAll();
        assertEquals(2, result.size());
    }

}

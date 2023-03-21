package com.bigcorp.booking.dao;

import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.service.ClientService;
import com.bigcorp.booking.spring.SpringConfiguration;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(SpringConfiguration.class)
public class ClientSpringDaoTest {

    @Autowired
    private ClientService clientService;

    @Test
    @DisplayName("Saves a client correctly")
    void testSave() {
        Client client = new Client(null, "Brando", "Dio", "dio@brando.com", "JOJOLands");

        clientService.save(client);

        Assertions.assertNotNull(client);
        Assertions.assertNotNull(client.getId());
    }
    
    @Test
    @DisplayName("Finds a client by name")
    void testGetByName() {
    	List<Client> clients  = clientService.getByName("Brando");
    	
    	Assertions.assertEquals(1, clients.size());
    }
}
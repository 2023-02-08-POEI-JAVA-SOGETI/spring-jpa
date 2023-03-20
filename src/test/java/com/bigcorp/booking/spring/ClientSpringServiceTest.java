package com.bigcorp.booking.spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.service.spring.ClientSpringService;


@SpringJUnitConfig(SpringConfiguration.class)
public class ClientSpringServiceTest {
	
	@Autowired
	private ClientSpringService clientService;

	@Test
	public void test() {
		Client client1 = new Client();
		Client client2 = new Client();
		client1.setNom("Test");
		client1.setNumero(123);
		client2.setNom("Test");
		client2.setNumero(456);
		clientService.save(client2);
		clientService.save(client1);
		List<Client> resultTest = clientService.findContainingName("Test");
		Assertions.assertEquals(2, resultTest.size());
	}

}

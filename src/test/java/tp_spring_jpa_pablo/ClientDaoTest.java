package tp_spring_jpa_pablo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tp_spring_jpa_pablo.dao.ClientDao;
import tp_spring_jpa_pablo.model.Client;

public class ClientDaoTest {
	@Test
	public void testSave() {
		ClientDao clientDao = new ClientDao();
		Client client = new Client();
		Client savedClient = clientDao.merge(client);
		Assertions.assertNotNull(savedClient.getId());
	}

	@Test
	public void testGetParNom() {
		ClientDao clientDao = new ClientDao();
		Client client1 = new Client();
		String nomDurand = "Durand";
		client1.setNom(nomDurand);
		clientDao.merge(client1);

		Client client2 = new Client();
		client2.setNom(nomDurand);
		clientDao.merge(client2);
		
		List<Client> clients = clientDao.getParNom(nomDurand);
    	Assertions.assertEquals(2, clients.size());
	}	

}

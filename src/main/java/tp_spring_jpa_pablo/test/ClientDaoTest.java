package tp_spring_jpa_pablo.test;

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

}

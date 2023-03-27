package tp_spring_jpa_pablo;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import tp_spring_jpa_pablo.dao.ClientDao;
import tp_spring_jpa_pablo.dao.UtilisateurDao;
import tp_spring_jpa_pablo.model.Client;
import tp_spring_jpa_pablo.model.Utilisateur;

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
		client2.setNom("Jaime");
		clientDao.merge(client2);

		List<Client> clients = clientDao.getParNom(nomDurand);
		Assert.assertEquals(1, clients.size());
	}	

}

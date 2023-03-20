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

	@Test
	public void testSaveManyToMany() {
		ClientDao clientDao = new ClientDao();
		UtilisateurDao utilisateurDao = new UtilisateurDao();

		// Create three clients
		Client client1 = new Client();
		client1.setNom("Client 1");
		Client savedClient1 = clientDao.merge(client1);

		Client client2 = new Client();
		client2.setNom("Client 2");
		Client savedClient2 = clientDao.merge(client2);

		Client client3 = new Client();
		client3.setNom("Client 3");
		Client savedClient3 = clientDao.merge(client3);

		// Create six utilisateurs
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setNom("Utilisateur 1");
		Utilisateur savedUtilisateur1 = utilisateurDao.merge(utilisateur1);

		Utilisateur utilisateur2 = new Utilisateur();
		utilisateur2.setNom("Utilisateur 2");
		Utilisateur savedUtilisateur2 = utilisateurDao.merge(utilisateur2);

		Utilisateur utilisateur3 = new Utilisateur();
		utilisateur3.setNom("Utilisateur 3");
		Utilisateur savedUtilisateur3 = utilisateurDao.merge(utilisateur3);

		Utilisateur utilisateur4 = new Utilisateur();
		utilisateur4.setNom("Utilisateur 4");
		Utilisateur savedUtilisateur4 = utilisateurDao.merge(utilisateur4);

		Utilisateur utilisateur5 = new Utilisateur();
		utilisateur5.setNom("Utilisateur 5");
		Utilisateur savedUtilisateur5 = utilisateurDao.merge(utilisateur5);

		Utilisateur utilisateur6 = new Utilisateur();
		utilisateur6.setNom("Utilisateur 6");
		Utilisateur savedUtilisateur6 = utilisateurDao.merge(utilisateur6);

		// Associate the utilisateurs with the clients
		Set<Utilisateur> utilisateurs1 = new HashSet<>(Arrays.asList(savedUtilisateur1, savedUtilisateur2, savedUtilisateur3));
		Set<Utilisateur> utilisateurs2 = new HashSet<>(Arrays.asList(savedUtilisateur2, savedUtilisateur4, savedUtilisateur5));
		Set<Utilisateur> utilisateurs3 = new HashSet<>(Arrays.asList(savedUtilisateur1, savedUtilisateur6));

		savedClient1.setUtilisateurs(utilisateurs1);
		savedClient2.setUtilisateurs(utilisateurs2);
		savedClient3.setUtilisateurs(utilisateurs3);

		Set<Client> clients1 = new HashSet<>(Arrays.asList(savedClient1, savedClient3));
		Set<Client> clients2 = new HashSet<>(Arrays.asList(savedClient1, savedClient2));
		Set<Client> clients3 = new HashSet<>(Arrays.asList(savedClient1));
		Set<Client> clients4 = new HashSet<>(Arrays.asList(savedClient2));
		Set<Client> clients5 = new HashSet<>(Arrays.asList(savedClient3));		

		savedUtilisateur1.setClients(clients1);
		savedUtilisateur2.setClients(clients2);
		savedUtilisateur3.setClients(clients3);
		savedUtilisateur4.setClients(clients4);
		savedUtilisateur5.setClients(clients4);
		savedUtilisateur6.setClients(clients5);

		
		// Associate utilisateurs with clients		
		savedClient1.getUtilisateurs().add(savedUtilisateur1);
		savedClient1.getUtilisateurs().add(savedUtilisateur2);

		savedClient2.getUtilisateurs().add(savedUtilisateur1);
		savedClient2.getUtilisateurs().add(savedUtilisateur3);
		savedClient2.getUtilisateurs().add(savedUtilisateur4);

		savedClient3.getUtilisateurs().add(savedUtilisateur5);
		savedClient3.getUtilisateurs().add(savedUtilisateur6);

		// Save the clients with associated utilisateurs
		clientDao.merge(savedClient1);
		clientDao.merge(savedClient2);
		clientDao.merge(savedClient3);

		// Load clients from the database and assert their data
		List<Client> loadedClients = clientDao.findAll();

		Assertions.assertEquals(3, loadedClients.size());
		Assertions.assertEquals(3, loadedClients.get(0).getUtilisateurs().size());
		Assertions.assertEquals(3, loadedClients.get(1).getUtilisateurs().size());
		Assertions.assertEquals(2, loadedClients.get(2).getUtilisateurs().size());

	}

}

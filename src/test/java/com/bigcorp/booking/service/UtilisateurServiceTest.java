package com.bigcorp.booking.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Utilisateur;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class UtilisateurServiceTest {

	@Autowired
	private UtilisateurService utilisateurService;

	@Test
	public void saveUtilisateurTest() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("alexalex");
		utilisateur.setPrenom("alex");
		utilisateur.setNum(523);
		utilisateur.setEmail("alex@alex.com");
		utilisateur.setLogin("alex");
		utilisateur.setPassword("alex");
		utilisateurService.save(utilisateur);
		
		Assertions.assertNotNull(utilisateur);
		Assertions.assertNotNull(utilisateur.getId());
	}
	
	@Test
	public void testFindByName() {
		Utilisateur utilisateurSecond = new Utilisateur("akiraakira", "akira", 12456, "akira@akira.com", "akira", "akira");
		Utilisateur akira = utilisateurService.save(utilisateurSecond);
		Assertions.assertNotNull(akira);
		utilisateurService.findByNom("akiraakira");
	}
	
	@Test
	public void testFindById() {
		Utilisateur utilisateurTroisieme = new Utilisateur("georgesgeorges", "georges", 4899, "georges@georges.com", "georges", "georges");
		utilisateurService.save(utilisateurTroisieme);
		Utilisateur utilisateur1 = utilisateurService.findById(3);
		Assertions.assertEquals(utilisateur1.getPrenom(), "georges");
	}
	
	@Test
	public void delete() {		
		Utilisateur utilisateurSuppr = new Utilisateur("edeneden", "eden", 8562, "eden@eden.com", "eden", "eden");
		Utilisateur eden = utilisateurService.save(utilisateurSuppr);
		Assertions.assertNotNull(eden);
		utilisateurService.delete(1);
		Assertions.assertNull(utilisateurService.findById(1));
	}
}

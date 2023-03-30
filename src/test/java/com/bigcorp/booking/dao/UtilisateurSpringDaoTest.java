package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Utilisateur;
import com.bigcorp.booking.service.UtilisateurService;
import com.bigcorp.booking.spring.SpringConfiguration;


@SpringJUnitConfig(SpringConfiguration.class)
public class UtilisateurSpringDaoTest {

	@Autowired
	private UtilisateurService utilisateurService;

	@Test
	@DisplayName("service saves a user correctly")
	void testSave() {
		Utilisateur utilisateur = new Utilisateur(456, "Joestar", "Johnny", "johnny@joestar.com", "jojo",
				"oraoraoraora");

		utilisateur = utilisateurService.save(utilisateur);

		Assertions.assertNotNull(utilisateur);
		Assertions.assertNotNull(utilisateur.getId());
	}

	@Test
	@DisplayName("service deletes a user correctly")
	void testDelete() {
		Utilisateur utilisateur = utilisateurService.getById(1);

		utilisateurService.delete(utilisateur.getId());

		Assertions.assertNull(utilisateurService.getById(1));
	}

	@Test
	@DisplayName("service finds a user by its id correctly")
	void testFindById() {
		Utilisateur utilisateur = utilisateurService.getById(1);

		Assertions.assertNotNull(utilisateur);
	}
}

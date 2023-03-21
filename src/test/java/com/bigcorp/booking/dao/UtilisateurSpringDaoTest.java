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
	private UtilisateurService UtilisateurService;

	@Test
	@DisplayName("Testing if service correctly saves a Utilisateur")
	void testSave() {
		Utilisateur Utilisateur = new Utilisateur(456, "Joestar", "Johnny", "johnny@joestar.com", "jojo", "oraoraoraora");

		UtilisateurService.save(Utilisateur);

		Assertions.assertNotNull(Utilisateur);
		Assertions.assertNotNull(Utilisateur.getId());
	}
}

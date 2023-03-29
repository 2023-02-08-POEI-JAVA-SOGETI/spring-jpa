package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.service.UtilisateurService;
import com.bigcorp.booking.spring.SpringConfiguration;

import tp_spring_jpa_pablo.model.Utilisateur;

@SpringJUnitConfig(SpringConfiguration.class)
public class UtilisateurSpringDaoTest {

	@Autowired
	private UtilisateurService utilisateurService;

	@Test
	public void testSave() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateurService.save(utilisateur);
		Assertions.assertNotNull(utilisateur);
		Assertions.assertNotNull(utilisateur.getId());
	}	  

}

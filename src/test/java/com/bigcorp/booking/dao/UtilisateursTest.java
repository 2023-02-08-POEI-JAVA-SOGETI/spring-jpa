package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Clients;
import com.bigcorp.booking.model.Utilisateurs;
import com.bigcorp.booking.service.ClientsService;
import com.bigcorp.booking.service.UtilisateursService;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)

public class UtilisateursTest {
	@Autowired  
	private UtilisateursService utilisateurService;

	@Test
	public void testSaveGet() {
	 Utilisateurs utilisateur = new Utilisateurs();
	 utilisateur.setNom("utilisateur-test");
	 Utilisateurs utilisateurSauvegarde = this.utilisateurService.save(utilisateur);
	 Assertions.assertNotNull(utilisateurSauvegarde);
	 Assertions.assertNotNull(utilisateurSauvegarde.getId());
	 Utilisateurs utilisateurRecupere = this.utilisateurService.findById(utilisateurSauvegarde.getId());
	 Assertions.assertNotNull(utilisateurRecupere);
	}
	
}
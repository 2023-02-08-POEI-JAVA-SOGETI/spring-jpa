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
	public void testSaveGet() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("Jean-Spring");
		Utilisateur utilisateurSauvegarde = this.utilisateurService.save(utilisateur);
		
		Assertions.assertNotNull(utilisateurSauvegarde);
		Assertions.assertNotNull(utilisateurSauvegarde.getId());
		
		Utilisateur utilisateurRecupere = this.utilisateurService.findById(utilisateurSauvegarde.getId());
		Assertions.assertNotNull(utilisateurRecupere);
	}

	@Test
	public void testDelete() {
		Utilisateur utilisateur = new Utilisateur();
		Utilisateur utilisateurSauvegarde = this.utilisateurService.save(utilisateur);
		this.utilisateurService.delete(utilisateurSauvegarde.getId());
		
		Utilisateur utilisateurRecupere = this.utilisateurService.findById(utilisateurSauvegarde.getId());
		Assertions.assertNull(utilisateurRecupere);
	}

}

package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Utilisateur;
import com.bigcorp.booking.model.Utilisateur;
import com.bigcorp.booking.service.UtilisateurService;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class UtilisateurSpringDaoTest {

	@Autowired
	private UtilisateurService utilisateurService;

	@Test

	public void testsauvegarde() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("Jaguar");
		
		utilisateur.setNumero(1234);
		utilisateurService.sauvegarde(utilisateur);
		Assertions.assertNotNull(utilisateur.getId());
	}

	@Test
	public void testfindByNom() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("Jeep");
		
		utilisateur.setNumero(1235);
		utilisateurService.sauvegarde(utilisateur);
		
		List<Utilisateur> articleDelaBase = utilisateurService.findByNom(utilisateur.getNom());
		
		Assertions.assertFalse(articleDelaBase.isEmpty());
	}
	
	

	@Test
	public void testget() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("range rover");
		
		utilisateur.setNumero(1237);
		utilisateurService.sauvegarde(utilisateur);
		
		
		Utilisateur utilisateurDeLaBase = utilisateurService.get(utilisateur.getId());
		Assertions.assertNotNull(utilisateurDeLaBase);
	}

	@Test
	public void testsupprimmer() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("Chevrolet");
		
		utilisateur.setNumero(1239);
		utilisateurService.sauvegarde(utilisateur);
		
		Assertions.assertNotNull(utilisateur);
		utilisateurService.supprimer(utilisateur.getId());
		Utilisateur utilisateurDeLaBase = utilisateurService.get(utilisateur.getId());
		Assertions.assertNull(utilisateurDeLaBase);
		
	}

}

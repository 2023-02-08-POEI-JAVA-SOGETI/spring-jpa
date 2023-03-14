package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Utilisateur;

public class UtilisateurDaoTest {

	@Test
	public void testSave() {
				
		Utilisateur utilisateur = new Utilisateur();
		UtilisateurDao utilisateurDao = new UtilisateurDao();

		String nom = "maxmax";
		String prenom = "max";
		Integer num = 789;
		String email = "max@max.com";
		String login = "max";
		String password = "max";
		
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setNum(num);
		utilisateur.setEmail(email);
		utilisateur.setLogin(login);
		utilisateur.setPassword(password);
		
		Utilisateur savedUtilisateur = utilisateurDao.merge(utilisateur);
		Assertions.assertNotNull(savedUtilisateur.getId());
		
		Utilisateur utilisateurBdd = utilisateurDao.findById(Utilisateur.class, savedUtilisateur.getId());
		Assertions.assertEquals(prenom, utilisateurBdd.getPrenom());
	}
	
	@Test
	public void testPersist() {
				
		Utilisateur utilisateur = new Utilisateur();
		UtilisateurDao utilisateurDao = new UtilisateurDao();

		String nom = "loulou";
		String prenom = "lou";
		Integer num = 753;
		String email = "lou@lou.com";
		String login = "lou";
		String password = "lou";
		
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setNum(num);
		utilisateur.setEmail(email);
		utilisateur.setLogin(login);
		utilisateur.setPassword(password);
		
		utilisateurDao.persist(utilisateur);
		Assertions.assertNotNull(utilisateur.getId());
	}
}

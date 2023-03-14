package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Utilisateur;

public class UtilisateurDaoTest {

	@Test
	public void testSave() {
		String nom = "Siri";
		UtilisateurDao UtilisateurDao = new UtilisateurDao();
		Utilisateur Utilisateur = new Utilisateur();

		Utilisateur.setNom(nom);

		Utilisateur savedUtilisateur = UtilisateurDao.merge(Utilisateur);

		Assertions.assertNotNull(savedUtilisateur.getId());

		Utilisateur UtilisateurRecord = UtilisateurDao.findById(savedUtilisateur.getId());
		
		Assertions.assertEquals(nom, UtilisateurRecord.getNom());
	}
	
	@Test
	public void testSaveTwo() {
		
		String nom = "Cortana";
		UtilisateurDao UtilisateurDao = new UtilisateurDao();
		Utilisateur Utilisateur = new Utilisateur();
		
		Utilisateur.setNom(nom);
		Utilisateur.setEmail("cortana@microsoft.com");
		
		Utilisateur savedUtilisateur = UtilisateurDao.merge(Utilisateur);
		
		Assertions.assertNotNull(savedUtilisateur.getId());
	}
}

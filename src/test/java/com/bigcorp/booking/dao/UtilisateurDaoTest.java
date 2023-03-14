package com.bigcorp.booking.dao;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Utilisateur;

public class UtilisateurDaoTest {
	
	@Test
	public void testSave() {
		
		Random random = new Random();
		UtilisateurDao utilisateurDao = new UtilisateurDao();
		
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setNumero_employee(random.nextInt(10000));
		utilisateur1.setNom("vittaz");
		utilisateur1.setPrenom("lucas");
		utilisateur1.setEmail("lucasvittaz.pro@gmail.com");
		utilisateur1.setLogin("root");
		utilisateur1.setMot_de_passe("root");
		
		
		Utilisateur savedUtilisateur1 = utilisateurDao.merge(utilisateur1);
		Assertions.assertNotNull(savedUtilisateur1.getId());
		Utilisateur exampleDeLaBaseDeDonnees1 = utilisateurDao.findById(Utilisateur.class, savedUtilisateur1.getId());
		Assertions.assertEquals(utilisateur1.getNom(), exampleDeLaBaseDeDonnees1.getNom());
	}
}
	
	
	

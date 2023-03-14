package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDaoTest {
	
	@Test
	public void testSave() {
		
		String nom = "Evergreen";
		String adresse = "Hong Kong";
		String email = "contact@evergreen-shipping.com";
		Integer numero_fournisseur = 1;
		
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur evergreen = new Fournisseur();
//		evergreen.setNom(nom);
//		evergreen.setNumero_fournisseur(numero_fournisseur);
//		evergreen.setEmail(email);
//		evergreen.setAdresse(adresse);
		
		evergreen.setNom("Evergreen");
		evergreen.setNumero_fournisseur(1);
		evergreen.setEmail("contact@evergreen-shipping.com");
		evergreen.setAdresse("Hong Kong");
		
    	
		Fournisseur savedFournisseur = fournisseurDao.merge(evergreen);
		
		Assertions.assertNotNull(savedFournisseur.getId());
		
		Fournisseur exampleDeLaBaseDeDonnees = fournisseurDao.findById(savedFournisseur.getId());
		
//		Assertions.assertEquals(nom, exampleDeLaBaseDeDonnees.getNom());
//		Assertions.assertEquals(adresse, exampleDeLaBaseDeDonnees.getAdresse());
//		Assertions.assertEquals(email, exampleDeLaBaseDeDonnees.getEmail());
//		Assertions.assertEquals(numero_fournisseur, exampleDeLaBaseDeDonnees.getNumero_fournisseur());	
		
		Assertions.assertEquals(evergreen.getNom(), exampleDeLaBaseDeDonnees.getNom());
		Assertions.assertEquals(evergreen.getAdresse(), exampleDeLaBaseDeDonnees.getAdresse());
		Assertions.assertEquals(evergreen.getEmail(), exampleDeLaBaseDeDonnees.getEmail());
		Assertions.assertEquals(evergreen.getNumero_fournisseur(), exampleDeLaBaseDeDonnees.getNumero_fournisseur());	
	}
	
}

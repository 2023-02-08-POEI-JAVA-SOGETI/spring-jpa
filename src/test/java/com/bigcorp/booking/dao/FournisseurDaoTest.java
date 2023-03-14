package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDaoTest {

	@Test
	public void testSave() {
		String nom = "Foxconn Technology";
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();

		fournisseur.setNom(nom);

		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);

		Assertions.assertNotNull(savedFournisseur.getId());

		Fournisseur fournisseurRecord = fournisseurDao.findById(savedFournisseur.getId());
		
		Assertions.assertEquals(nom, fournisseurRecord.getNom());
	}
	
	@Test
	public void testSaveTwo() {
		
		String nom = "Inditex";
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();
		
		fournisseur.setNom(nom);
		fournisseur.setEmail("contact@inditex.com");
		
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		
		Assertions.assertNotNull(savedFournisseur.getId());
	}
}

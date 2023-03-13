package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDaoTest {
	@Test
	public void testSave() {
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur evergreen = new Fournisseur(1, "evergreen", "contact@evergreen-shipping.com", "Hong Kong - China" );
		
		Fournisseur savedFournisseur = fournisseurDao.merge(evergreen);
		Fournisseur exampleFournisseurBdd = fournisseurDao.findById(savedFournisseur.getId());
		
		Assertions.assertEquals(evergreen, exampleFournisseurBdd);
	}
	
}

package com.bigcorp.booking.exercice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FournisseurDaoTest {
	
	
	@Test
	public void mergeTest()
	{
		final String NOM = "TEST nom";
		final Integer NUM = 03030303;
		final String EMAIL = "TEST email";
		final String ADRESSE = "TEST adresse";
		
		Fournisseur fournisseur = new Fournisseur(NOM,
												NUM,
												EMAIL,
												ADRESSE
														);
		
		FournisseurDao dao = new FournisseurDao();
		
		Fournisseur testFournisseur = dao.merge(fournisseur);
		
		Assertions.assertNotNull(testFournisseur.getId());
		
		Assertions.assertEquals(NOM, testFournisseur.getNom());
		Assertions.assertEquals(NUM, testFournisseur.getNum());
		Assertions.assertEquals(EMAIL, testFournisseur.getEmail());
		Assertions.assertEquals(ADRESSE, testFournisseur.getAdresse());
		
		
	}

}

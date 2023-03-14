package com.bigcorp.booking.exercice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FournisseurDaoTest {
	
	
	static FournisseurDao dao;
	
	@BeforeAll
	public static void initDao()
	{
		 dao = new FournisseurDao();
	}
	
	
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
		
		
		
		Fournisseur testFournisseur = dao.merge(fournisseur);
		
		Assertions.assertNotNull(testFournisseur.getId());
		
		Assertions.assertEquals(NOM, testFournisseur.getNom());
		Assertions.assertEquals(NUM, testFournisseur.getNum());
		Assertions.assertEquals(EMAIL, testFournisseur.getEmail());
		Assertions.assertEquals(ADRESSE, testFournisseur.getAdresse());
		
		
	}
	
	@Test
	public void findByIdTest()
	{
		Fournisseur fournisseurTest = new Fournisseur();
		fournisseurTest.setNom("TEST");
		dao.merge(fournisseurTest);
		
		Fournisseur resultTest = dao.findbyId(1);
		
		Assertions.assertEquals("TEST", resultTest.getNom());
		
	}

}

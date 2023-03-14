package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDaoTest {
	  
    @Test
    public void testSave() {
    	
    	String nom = "charlie";
    	int num = 456;
    	String email = "charlie@charlie.com";
    	String adresse = "1 rue de la Gare 69001 Lyon";
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom(nom);
		fournisseur.setNum(num);
		fournisseur.setEmail(email);
		fournisseur.setAdresse(adresse);
    	
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		
		Assertions.assertNotNull(savedFournisseur.getId());
		
		Fournisseur fournisseurDeLaBaseDeDonnees = fournisseurDao.findById(savedFournisseur.getId());
		
		Assertions.assertEquals(nom, fournisseurDeLaBaseDeDonnees.getNom());
		
    }
	  
    @Test
    public void testSave2() {
    	
    	String nom = "sacha";
    	int num = 123;
    	String email = "sacha@sacha.com";
    	String adresse = "1 rue de la Gare 35000 Rennes";
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur fournisseur = new Fournisseur();
    	fournisseur.setNom(nom);
		fournisseur.setNum(num);
		fournisseur.setEmail(email);
		fournisseur.setAdresse(adresse);
    	
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		
		Assertions.assertNotNull(savedFournisseur.getId());
		
		Fournisseur savedFournisseurId = fournisseurDao.findById(1);
		Assertions.assertNotNull(savedFournisseurId.getId());
    }
}
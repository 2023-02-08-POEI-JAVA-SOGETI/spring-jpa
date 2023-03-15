package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDaoEnAbstractTest {
	  
    @Test
    public void testSave() {
    	
    	String nom = "Jack";
    	int num = 1000;
    	String email = "jack@mail.com";
    	String adresse = "3 rue du moulin";
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
	  
}
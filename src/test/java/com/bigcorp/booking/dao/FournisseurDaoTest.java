package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDaoTest {
	  
    @Test
    public void testSave() {
    	
    	String nom = "Jean-Jacques";
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom(nom);
    	
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		
		Assertions.assertNotNull(savedFournisseur.getId());
		
		Fournisseur fournisseurDeLaBaseDeDonnees = fournisseurDao.findById(savedFournisseur.getId());
		
		Assertions.assertEquals(nom, fournisseurDeLaBaseDeDonnees.getNom());
		
    }
	  
    @Test
    public void testSave2() {
    	
    	String nom = "Sacha";
    	int num = 123;
    	String email = "sacha@sacha.com";
    	String adresse = "1 rue de la Gare 35000 Rennes";
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNum(num);
		fournisseur.setEmail(email);
		fournisseur.setAdresse(adresse);
		fournisseur.setNom(nom);
    	
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		
		Assertions.assertNotNull(savedFournisseur.getId());
		
		
    }
}
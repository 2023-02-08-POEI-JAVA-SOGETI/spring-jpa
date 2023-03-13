package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDaoTest {
	  
    @Test
    public void testSave() {
    	
    	String nom = "Jean-Jacques";
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur f = new Fournisseur(1, 1, nom, "Fournisseur JJ", "mon adresse");
    	f.setNom(nom);
    	
		Fournisseur savedFournisseur = fournisseurDao.merge(f);
		
		Assertions.assertNotNull(savedFournisseur.getId());
		
		Fournisseur exampleDeLaBaseDeDonnees = fournisseurDao.findById(savedFournisseur.getId());
		
		Assertions.assertEquals(nom, exampleDeLaBaseDeDonnees.getNom());
		
    }
	  
    @Test
    public void testSave2() {
    	
    	String nom = "Jean-Paul";
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur f = new Fournisseur(2, 2, nom, "Fournisseur JP", "mon adresse de JP");
		f.setAdresse("ma nouvelle adresse");

		Fournisseur savedFournisseur = fournisseurDao.merge(f);
		
		Assertions.assertNotNull(savedFournisseur.getId());
		
		
    }
}
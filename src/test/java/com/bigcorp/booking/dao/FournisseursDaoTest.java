package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import com.bigcorp.booking.model.Fournisseurs;

public class FournisseursDaoTest {
	  
    @Test
    public void testSave() {
    	
    	String nom = "Jean-Jacques";
    	FournisseursDao fournisseursDao = new FournisseursDao();
    	Fournisseurs fournisseur = new Fournisseurs();
		fournisseur.setNom(nom);
    	
		Fournisseurs savedFournisseur = fournisseursDao.merge(fournisseur);
		
		Assertions.assertNotNull(savedFournisseur.getId());
		
		Fournisseurs formationjava = fournisseursDao.findById(savedFournisseur.getId());
		
		Assertions.assertEquals(nom, formationjava.getNom());		
    }
	  
    @Test
    public void testSave2() {
    	
    	String nom = "Jean-Paul";
    	String adresse = "Marie";
    	FournisseursDao fournisseursDao = new FournisseursDao();
    	Fournisseurs fournisseurs = new Fournisseurs();
		fournisseurs.setNom(nom);
		fournisseurs.setAdresse(adresse);
    	
		Fournisseurs savedExample = fournisseursDao.merge(fournisseurs);
		
		Assertions.assertNotNull(savedExample.getId());
		
		
    }
}
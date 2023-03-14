package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import com.bigcorp.booking.model.Fournisseurs;

public class FournisseursDaoTest {
	 @Test
	    public void testSave() {
	    	
	    	String nom = "Jean-Jacques";
	    	FournisseursDao fournisseursDao = new FournisseursDao();
	    	Fournisseurs fournisseurs = new Fournisseurs();
			fournisseurs.setNom(nom);
	    	
			Fournisseurs savedFournisseurs = fournisseursDao.merge(fournisseurs);
			
			Assertions.assertNotNull(savedFournisseurs.getiD());
			
			Fournisseurs exampleDeLaBaseDeDonnees = fournisseursDao.findById(savedFournisseurs.getiD());
			
			Assertions.assertEquals(nom, exampleDeLaBaseDeDonnees.getNom());
			
	    }
		  
	    @Test
	    public void testSave2() {
	    	
	    	String nom = "Jean-Paul";
	    	FournisseursDao fournisseursDao = new FournisseursDao();
	    	Fournisseurs fournisseurs = new Fournisseurs();
	    	fournisseurs.setNom(nom);
			
	    	
			Fournisseurs savedFournisseurs = fournisseursDao.merge(fournisseurs);
			
			Assertions.assertNotNull(savedFournisseurs.getiD());
			
			
	    }
}

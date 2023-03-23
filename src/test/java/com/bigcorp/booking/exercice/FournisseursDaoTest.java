package com.bigcorp.booking.exercice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FournisseursDaoTest {
	  
    @Test
    public void testSave() {
    	
    	String nom = "Jean-Jacques";
       	FournisseursDao fournisseurDao = new FournisseursDao();
       	Fournisseurs fournisseur = new Fournisseurs();
    	fournisseur.setNom(nom);

    	
		Fournisseurs savedFournisseur = fournisseurDao.merge(fournisseur);
		
		Assertions.assertNotNull(savedFournisseur.getiD());
		
		Fournisseurs fournisseurDeLaBaseDeDonnees = fournisseurDao.findById(savedFournisseur.getiD());
		
		Assertions.assertEquals(nom, fournisseurDeLaBaseDeDonnees.getNom());
		
    }
	  
    @Test
    public void testSave2() {
    	
    	String nom = "Jean-Paul";
    	FournisseursDao fournisseurDao = new FournisseursDao();
    	Fournisseurs fournisseur = new Fournisseurs();
		fournisseur.setNom(nom);
		fournisseur.setTaille(3.14f);
    	
		Fournisseurs savedFournisseur = fournisseurDao.merge(fournisseur);
		
		Assertions.assertNotNull(savedFournisseur.getiD());
		
		
    }
}
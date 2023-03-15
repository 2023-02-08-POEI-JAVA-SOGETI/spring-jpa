package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import com.bigcorp.booking.model.Fournisseurs;



public class FournisseursDaoTest {
	 /*@Test
	    public void testSave() {
	    	
	    	String nom = "Jean-Jacques";
	    	FournisseursDao fournisseursDao = new FournisseursDao();
	    	Fournisseurs fournisseurs = new Fournisseurs();
			fournisseurs.setNom(nom);
	    	
			Fournisseurs savedFournisseurs = fournisseursDao.merge(fournisseurs);
			
			Assertions.assertNotNull(savedFournisseurs.getiD());
			
			Fournisseurs exampleDeLaBaseDeDonnees = fournisseursDao.findById(Fournisseurs.class, savedFournisseurs.getiD());
			
			Assertions.assertEquals(nom, exampleDeLaBaseDeDonnees.getNom());
			
	    }*/
		  
	   /* @Test
	    public void testSave2() {
	    	
	    	String nom = "Jean-Paul";
	    	FournisseursDao fournisseursDao = new FournisseursDao();
	    	Fournisseurs fournisseurs = new Fournisseurs();
	    	fournisseurs.setNom(nom);
			
	    	
			Fournisseurs savedFournisseurs = fournisseursDao.merge(fournisseurs);
			
			Assertions.assertNotNull(savedFournisseurs.getiD());
			
			
	    }*/
	    
	    @Test
	    public void testGetParNom() {
			FournisseursDao clientDao = new FournisseursDao();
	    	Fournisseurs client1 = new Fournisseurs();
	    	String nomDurand = "leNomDurandDuTestGetParNom";
			client1.setNom(nomDurand);
			clientDao.merge(client1);
	    	
	    	Fournisseurs client2 = new Fournisseurs();
	    	client2.setNom(nomDurand);
	    	clientDao.merge(client2);
	    	
	    	List<Fournisseurs> clients = clientDao.getParNom(nomDurand);
	    	Assertions.assertEquals(2, clients.size());
	    	
	    }
}

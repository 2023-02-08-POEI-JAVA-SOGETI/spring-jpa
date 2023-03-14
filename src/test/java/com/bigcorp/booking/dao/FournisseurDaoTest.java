package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDaoTest {
	  
    @Test
    public void testSave() {
    	
    	String nom = "Jean-Jacques";
    	String email = "Email de Jean-Jacques";
    	String adresse = "Adresse de Jean-Jacques";
    	Integer numero = 1;
    	
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur f = new Fournisseur(numero, nom, email, adresse);
    	
		Fournisseur savedFournisseur = fournisseurDao.merge(f);
		
		Assertions.assertNotNull(savedFournisseur.getId());
		
		Fournisseur exampleDeLaBaseDeDonnees = fournisseurDao.findById(savedFournisseur.getId());
		Assertions.assertEquals(nom, exampleDeLaBaseDeDonnees.getNom());
		
    }
	  
    @Test
    public void testSave2() {
    	
    	String nom = "Jean-Paul";
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur f = new Fournisseur();
    	f.setNom(nom);
		f.setAdresse("ma nouvelle adresse");
		f.setEmail("jp email");
		f.setNumero(99);

		Fournisseur savedFournisseur = fournisseurDao.merge(f);
		
		Assertions.assertNotNull(savedFournisseur.getId());
		
		
    }
}
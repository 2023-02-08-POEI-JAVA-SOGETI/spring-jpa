package com.bigcorp.booking.dao;

import java.util.List;

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
    
    @Test
    public void testSave3() {
    	
    	String nom = "FournisseurTest";
    	FournisseurDao fournisseurDao = new FournisseurDao();
  
    	Fournisseur f = new Fournisseur(100, nom, "email", "adresse");
    	fournisseurDao.merge(f);
    	
    	List<Fournisseur> listFournisseur = fournisseurDao.getParNom(nom);
    	
    	Assertions.assertEquals(1, listFournisseur.size());
    }    
    
    @Test
    public void testSave4() {
    	
    	String nom = "FournisseurBiduleTest";
    	FournisseurDao fournisseurDao = new FournisseurDao();
  
    	Fournisseur f = new Fournisseur(100, nom, "email", "adresse");
    	fournisseurDao.merge(f);
    	
    	List<Fournisseur> listFournisseur = fournisseurDao.getParSousChaineNom("bidule");
    	
    	Assertions.assertEquals(1, listFournisseur.size());
    }    
    
    @Test
    public void testSave5() {
    	
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	List<Fournisseur> listFournisseur = fournisseurDao.getParSousChaineNom("Bidule");
    	
    	Assertions.assertEquals(1, listFournisseur.size());
    }
}
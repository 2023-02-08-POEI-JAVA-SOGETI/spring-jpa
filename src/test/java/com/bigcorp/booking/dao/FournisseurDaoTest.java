package com.bigcorp.booking.dao;

import java.util.List;

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
    	FournisseurDaoBase fournisseurDao = new FournisseurDaoBase();
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
    	FournisseurDaoBase fournisseurDao = new FournisseurDaoBase();
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
    
    @Test
    public void testGetByName() {
    	//Test de fonction getByName
		FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur fourni = new Fournisseur();
    	String nom = "lou";
		fourni.setNom(nom);
		fournisseurDao.merge(fourni);
    	
		Fournisseur fourni2 = new Fournisseur();
    	fourni2.setNom(nom);
    	fournisseurDao.merge(fourni2);
    	
    	List<Fournisseur> fournisseurs = fournisseurDao.getByName(nom);
    	Assertions.assertEquals(2, fournisseurs.size());
    	
    	//Test de fonction geyByPartOfNameNotCaseSensitive
    	Fournisseur fourniA = new Fournisseur();
    	String name = "Alex";
		fourniA.setNom(name);
		fournisseurDao.merge(fourniA);
    	
		Fournisseur fourniB = new Fournisseur();
    	fourniB.setNom("alexandrie");
    	fournisseurDao.merge(fourniB);
    	
    	
    	List<Fournisseur> autresFournisseurs = fournisseurDao.getByPartOfNameNotCaseSensitive(name);
    	Assertions.assertEquals(2, autresFournisseurs.size());

    }
}
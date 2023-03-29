package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDaoTest extends AbstractDao<Fournisseur>{
	  
   @Test
   
   
    public void testSave() {
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur fournisseur = new Fournisseur();
    	fournisseur.setNom("NGOM Automobile");
    	fournisseur.setAdresse("5 rue du ciel");
    	fournisseur.setEmail("test@mail.fr");
    	fournisseur.setId(002);
    	fournisseur.setNumero(07);
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		Assertions.assertNotNull(savedFournisseur.getId());
		
    } 
	 
   /*@Test
    public void testGetParNom() {
		FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur fournisseur1 = new Fournisseur();
    	String nomNGOM = "leNomNGOMDuTestGetParNom";
		fournisseur1.setNom(nomNGOM);
		fournisseurDao.merge(fournisseur1);
    	
		Fournisseur fournisseur2 = new Fournisseur();
    	
    	fournisseurDao.merge(fournisseur2);
    	
		List<Fournisseur> fournisseurs = fournisseurDao.getParNom(nomNGOM);
    	
		Assertions.assertEquals(2, fournisseurs.size());
    }*/
    
}
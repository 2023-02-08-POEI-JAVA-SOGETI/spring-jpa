package com.bigcorp.booking.dao;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.bigcorp.booking.model.Livre;
import com.bigcorp.booking.model.Livre;

import junit.framework.Assert;

public class LivreDaoTest {

	
	@Test 
	public void testSave() {
		
		// Caractéristiques
		LivresDao livreDao = new LivresDao();
		Livre livre = new Livre();
		String titre = "20 000 lieues sous les mers";
		String auteur = "Jules Verne";
		String description = "Roman maritime";
		int anneeEdition = 1870;		
		int id = 1;
		
		// Setters 
		livre.setTitre(titre);
		livre.setAuteur(auteur);
		livre.setDescription(description);
		livre.setAnneeEdition(anneeEdition);
		livre.setId(id);
		
		Livre savedLivre = livreDao.merge(livre);
		Assertions.assertNotNull(savedLivre.getId());
		
		Livre livre1 = livreDao.findById(Livre.class,savedLivre.getId());
		
		Assertions.assertEquals(titre, livre1.getTitre());
		Assertions.assertEquals(auteur, livre1.getAuteur());
		Assertions.assertEquals(description, livre1.getDescription());
		Assertions.assertEquals(anneeEdition, livre1.getAnneeEdition());
		Assertions.assertEquals(id, livre1.getId());
		
    }
    
	
    public void testPersist() {
		LivresDao livreDao = new LivresDao();
		Livre livre2 = new Livre();
		int id = 13;
		livre2.setId(id);
		livreDao.persist(livre2);
		Assertions.assertNotNull(livre2.getId());
    }

    
    
    
    @Test
    public void testGetParTitreLikeInsensibleALaCasse() {
		LivresDao livreDao = new LivresDao();
    	Livre livre3 = new Livre();
		livre3.setTitre("les Misérables");
		livreDao.merge(livre3);
    	
    	Livre livre4 = new Livre();
    	livre4.setTitre("charlie et la Chocolaterie");
    	livreDao.merge(livre4);
    	
    	Livre livre5 = new Livre();
    	livre5.setTitre("Jane Eyre");
    	livreDao.merge(livre5);
    	
    	List<Livre> clients = livreDao.getParTitreLikeInsensibleALaCasse("Jane Eyre");
    	Assert.assertEquals(3, clients.size());
    	
    }	  
   
}
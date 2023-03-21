package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.TypeArticle;
 
public class TestFournisseurDaoGetByName {

@Test
    public void testGetParNom() {
		FournisseurDaoEnAbstract fournisseurDao = new FournisseurDaoEnAbstract();
    	Fournisseur fournisseur1 = new Fournisseur();
    	String nomDurand = "leNomDurandDuTestGetParNom";
		fournisseur1.setNom(nomDurand);
		fournisseurDao.merge(fournisseur1);
    	
    	Fournisseur fournisseur2 = new Fournisseur();
    	fournisseur2.setNom(nomDurand);
    	fournisseurDao.merge(fournisseur2);
    	
    	List<Fournisseur> fournisseurs = fournisseurDao.getParNom(nomDurand);
    	Assertions.assertEquals(2, fournisseurs.size());
    	
    }

}
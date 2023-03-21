package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDaoEnAbstractTest {
	  
    @Test
    public void testSave() {
    	
    	String nom = "Jack";
    	int num = 1000;
    	String email = "jack@mail.com";
    	String adresse = "3 rue du moulin";
    	FournisseurDaoAvecJPA fournisseurDao = new FournisseurDaoAvecJPA();
    	Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom(nom);
		fournisseur.setNumero(num);
		fournisseur.setEmail(email);
		fournisseur.setAdresse(adresse);
    	
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
		
		Assertions.assertNotNull(savedFournisseur.getId());
		
		Fournisseur fournisseurDeLaBaseDeDonnees = fournisseurDao.findById(savedFournisseur.getId());
		
		Assertions.assertEquals(nom, fournisseurDeLaBaseDeDonnees.getNom());
		
		/* Test de la méthode findByName */
		
		
    }
    
    @Test
    public void testMergeAvecArticle() {

    	//Création du fournisseur
    	Fournisseur fournisseur1 = new Fournisseur();
		fournisseur1.setNom("Michel");
		
		//Création de l'article
		Article article = new Article();
		article.setNom("Pizza Margherita");
		
		//Sauvegarde du fournisseur
		FournisseurDaoEnAbstract fournisseurDao = new FournisseurDaoEnAbstract();
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur1);
		
		//Liaison des deux entités
		article.setFournisseur(savedFournisseur);
		
		//Sauvegarde de l'article
		ArticleDaoEnAbstract articleDao = new ArticleDaoEnAbstract();
		Article savedArticle = articleDao.merge(article);
		
		
		Assertions.assertNotNull(savedArticle.getId());
    	
    }
	  
}
package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.TypeArticle;

public class ArticleDaoEnAbstractTest {
	  
    @Test
    public void testSave() {
    	
    	int numArticle = 100;
    	TypeArticle type = TypeArticle.NEUF;
    	String nom  = "NVDIA GTX 3060";
    	String description = "Une superbe carte graphique";
    	ArticleDaoEnAbstract articleDao = new ArticleDaoEnAbstract();
    	Article article = new Article();
		article.setNumero(numArticle);
		article.setTypeArticle(type);
		article.setNom(nom);
		article.setDescription(description);
    	
		Article savedArticle = articleDao.merge(article);
		
		Assertions.assertNotNull(savedArticle.getId());
		
		Article articleDeLaBaseDeDonnees = articleDao.findById(savedArticle.getId());
		
		Assertions.assertEquals(nom, articleDeLaBaseDeDonnees.getNom());
		
    }
    
    // Test sauvegarde d'un article lié à un fournisseur et récupération d'un fournisseur et de tous ses articles associés.
    @Test
    public void testSaveArticleAssociatedWithFounrisseur() {
    	
    	// Création objet fournisseur & persistence en BDD
    	FournisseurDaoEnAbstract fournisseurDao = new FournisseurDaoEnAbstract();
    	Fournisseur fournisseur = new Fournisseur();
    	fournisseur.setNom("LDLC");
    	Fournisseur fournisseurSauvegarde = fournisseurDao.merge(fournisseur);
    	
    	// Création objet article
    	int numArticle = 200;
    	TypeArticle type = TypeArticle.OCCASION;
    	String nom  = "Laptop Gaming";
    	String description = "Une offre en or";
    	ArticleDaoEnAbstract articleDao = new ArticleDaoEnAbstract();
    	Article article = new Article();
    	article.setNumero(numArticle);
		article.setTypeArticle(type);
		article.setNom(nom);
		article.setDescription(description);
		
		// Rattachement du fournisseur à l'article
		article.setFournisseur(fournisseurSauvegarde);
		
		// Peristence de l'article en BDD
		Article articleSauvegarde = articleDao.merge(article);
		
		// Vérifie que l'article sauvegardé n'est pas null
		Assertions.assertNotNull(articleSauvegarde.getId());
		 
		// Récupération du fournisseur et de ses articles associés
		List<Fournisseur> fournisseurRecupereParNom = fournisseurDao.getParNomAvecArticleles("LDLC");
		fournisseurRecupereParNom.get(0).getArticles().iterator().next().getId();
		
		// Verifie que les articles récupérés correspondent bien à ceux dans la table Article

		
		
    }
    
    
	  
}
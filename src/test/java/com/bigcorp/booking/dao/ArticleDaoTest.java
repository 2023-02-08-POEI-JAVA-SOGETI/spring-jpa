package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Etat;
import com.bigcorp.booking.model.Fournisseur;

public class ArticleDaoTest {
	  
    @Test
    public void testSave() {
    	
    	Integer num_article = 1;
    	String nom = "pelle";
    	String description = "ca creuse";
    	
    	ArticleDao articleDao = new ArticleDao();
    	Article a = new Article(num_article, Etat.INUTILISABLE.name(), nom, description);
    	
    	Article savedArticle = articleDao.merge(a);
		
		Assertions.assertNotNull(savedArticle.getId());
		
		Article exempleBdd = articleDao.findById(Article.class, savedArticle.getId());
		Assertions.assertEquals(nom, exempleBdd.getNom());
		
    }
    
    //Test du many to one fournisseur
    @Test
    public void testSave2() {
    	
    	Integer num_article = 1;
    	String nom = "brouette";
    	String description = "c'est bien pratique une brouette";
    	
    	ArticleDao articleDao = new ArticleDao();
    	Article a = new Article(num_article, Etat.NEUF.name(), nom, description);
	
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur f = new Fournisseur(10, "black & d'equerre", "a@a.com", "adresse b&d");


    	Fournisseur savedFournisseur = fournisseurDao.merge(f);

    	// affectation du fournisseur dans l'article
    	a.setFournisseur(savedFournisseur);
    	
    	Article savedArticle = articleDao.merge(a);
    	
		Article exempleBdd = articleDao.findById(Article.class, savedArticle.getId());
		Assertions.assertEquals(f.getNom(), exempleBdd.getFournisseur().getNom());
		
    }
}
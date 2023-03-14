package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.EtatArticle;

public class ArticleDaoTest {
	@Test
    public void testSave() {
    	
    	String nom = "Elden Ring";
    	
    	EtatArticle etat = EtatArticle.NEUF;
    	ArticleDao articleDao = new ArticleDao();
    	Article article = new Article();
		article.setNom(nom);
		article.setEtat(etat);
		
    	
		Article savedArticle = articleDao.merge(article);
		
		Assertions.assertNotNull(savedArticle.getiD());
		
		Article exampleDeLaBaseDeDonnees = articleDao.findById(Article.class, savedArticle.getiD());
		
		Assertions.assertEquals(nom, exampleDeLaBaseDeDonnees.getNom());
		
    }
	  
    @Test
    public void testSave2() {
    	
    	String nom = "Rocket League";
    	ArticleDao articleDao = new ArticleDao();
    	Article article = new Article();
    	article.setNom(nom);
		
    	
		Article savedArticle = articleDao.merge(article);
		
		Assertions.assertNotNull(savedArticle.getiD());
		
		
    }
}

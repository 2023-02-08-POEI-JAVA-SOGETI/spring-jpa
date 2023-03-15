package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
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
		article.setNumArticle(numArticle);
		article.setType(type);
		article.setNom(nom);
		article.setDescription(description);
    	
		Article savedArticle = articleDao.merge(article);
		
		Assertions.assertNotNull(savedArticle.getId());
		
		Article articleDeLaBaseDeDonnees = articleDao.findById(savedArticle.getId());
		
		Assertions.assertEquals(nom, articleDeLaBaseDeDonnees.getNom());
		
    }
	  
}
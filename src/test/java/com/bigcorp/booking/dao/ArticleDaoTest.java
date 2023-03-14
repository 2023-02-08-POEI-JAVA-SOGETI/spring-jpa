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
    	Article a = new Article(num_article, Etat.etat.INUTILISABLE.name(), nom, description);
    	
    	Article savedArticle = articleDao.merge(a);
		
		Assertions.assertNotNull(savedArticle.getId());
		
		Article exempleBdd = articleDao.findById(Article.class, savedArticle.getId());
		Assertions.assertEquals(nom, exempleBdd.getNom());
		
    }
}
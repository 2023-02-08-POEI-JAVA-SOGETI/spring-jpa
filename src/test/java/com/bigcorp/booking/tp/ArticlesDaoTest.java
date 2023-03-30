package com.bigcorp.booking.tp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArticlesDaoTest {
	  
    @Test
    public void testSave() {
    	
    	String nom = "Rideaux";
       	ArticlesDao articleDao = new ArticlesDao();
       	Articles article = new Articles();
    	article.setNom(nom);
    	
		Articles savedArticle = articleDao.merge(article);
		
		Assertions.assertNotNull(savedArticle.getiD());
		
		Articles articleDeLaBaseDeDonnees = articleDao.findById(savedArticle.getiD());
		
		Assertions.assertEquals(nom, articleDeLaBaseDeDonnees.getNom());
		
    }
	  
    @Test
    public void testSave2() {
    	
    	String nom = "Armoire";
    	ArticlesDao articleDao = new ArticlesDao();
    	Articles article = new Articles();
		article.setNom(nom);
    	
		Articles savedArticle = articleDao.merge(article);
		
		Assertions.assertNotNull(savedArticle.getiD());
		
		
    }
}
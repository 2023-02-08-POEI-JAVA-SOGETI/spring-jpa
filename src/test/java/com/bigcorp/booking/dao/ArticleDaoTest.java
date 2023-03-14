package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.TypeArticle;

public class ArticleDaoTest {
	  
    @Test
    public void testSave() {
    	
    	String nom = "webcam";
    	Integer numArticle = 456;
    	String description = "Description de webcam";
    	
    	ArticleDao articleDao = new ArticleDao();
    	Article article = new Article();
    	
    	article.setNom(nom);
    	article.setNumArticle(numArticle);
    	article.setDescription(description);
    	article.setType(TypeArticle.NEUF);
    	
		Article savedArticle = articleDao.merge(article);
		
		Assertions.assertNotNull(savedArticle.getId());
		
		Article articleDeLaBaseDeDonnees = articleDao.findById(Article.class, savedArticle.getId());
		
		Assertions.assertEquals(nom, articleDeLaBaseDeDonnees.getNom());
		Assertions.assertEquals(TypeArticle.NEUF, articleDeLaBaseDeDonnees.getType());
		
    }
	  
//    @Test
//    public void testSave2() {
//    	
//    	String nom = "sacha";
//    	int num = 123;
//    	String email = "sacha@sacha.com";
//    	String adresse = "1 rue de la Gare 35000 Rennes";
//    	FournisseurDao fournisseurDao = new FournisseurDao();
//    	Fournisseur fournisseur = new Fournisseur();
//    	fournisseur.setNom(nom);
//		fournisseur.setNum(num);
//		fournisseur.setEmail(email);
//		fournisseur.setAdresse(adresse);
//    	
//		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
//		
//		Assertions.assertNotNull(savedFournisseur.getId());
//		
//		Fournisseur savedFournisseurId = fournisseurDao.findById(1);
//		Assertions.assertNotNull(savedFournisseurId.getId());
//    }
}
package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;
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
//    	ArticleDao articleDao = new ArticleDao();
//    	Article article = new Article();
//    	article.setNom(nom);
//		article.setNum(num);
//		article.setEmail(email);
//		article.setAdresse(adresse);
//    	
//		Article savedArticle = articleDao.merge(article);
//		
//		Assertions.assertNotNull(savedArticle.getId());
//		
//		Article savedArticleId = articleDao.findById(1);
//		Assertions.assertNotNull(savedArticleId.getId());
//    }
    
    @Test
    public void testGetParNom() {
		ArticleDao articleDao = new ArticleDao();
    	Article article = new Article();
    	String nom = "chargeur";
		article.setNom(nom);
		articleDao.merge(article);
    	
		Article article2 = new Article();
    	article2.setNom(nom);
    	articleDao.merge(article2);
    	
    	List<Article> articles = articleDao.getParNom(nom);
    	Assertions.assertEquals(2, articles.size());
    	
    }
    @Test
    public void testMergeFournisseur() {
    	ArticleDao articleDao= new ArticleDao();
    	
    	//Création de l'article
    	Article article1 = new Article();
    	article1.setNom("super clavier");
    	
    	//Création du fournisseur
    	Fournisseur fournisseur = new Fournisseur();
    	fournisseur.setNom("Fournisseur de supers claviers");
    	
    	//Sauvegarde fournisseur
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur savedFourni = fournisseurDao.merge(fournisseur); 
    	
    	//Liaison des deux entités
    	article1.setFournisseur(savedFourni);
    	
    	//Sauvegarde de l'article
    	Article savedArticle = articleDao.merge(article1);
    	
    	Assertions.assertEquals(savedFourni.getId(), article1.getFournisseur().getId());
    	
    	
    	
    	
    	
    	
    	
    }
}
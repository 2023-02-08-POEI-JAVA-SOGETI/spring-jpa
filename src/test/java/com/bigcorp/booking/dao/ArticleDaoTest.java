package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.EtatArticle;
import com.bigcorp.booking.model.Fournisseurs;
import com.bigcorp.booking.model.Article;

public class ArticleDaoTest {
	/*@Test
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
		
		
    }*/
	/*@Test
    public void testGetParNom() {
		ArticleDao clientDao = new ArticleDao();
    	Article client1 = new Article();
    	String nomDurand = "CeciEstUnTest";
		client1.setNom(nomDurand);
		clientDao.merge(client1);
    	
    	Article client2 = new Article();
    	client2.setNom(nomDurand);
    	clientDao.merge(client2);
    	
    	List<Article> clients = clientDao.getParNom("%test%");
    	Assertions.assertEquals(2, clients.size());
    	
    }*/
    
    @Test
    public void testMergeAvecFournisseur() {
    	ArticleDao articleDao = new ArticleDao();
    	Article article1 = new Article();
    	article1.setNom("DS3");
    	Article article2 = new Article();
    	article2.setNom("DS2");
    	Fournisseurs fournisseur = new Fournisseurs();
    	fournisseur.setNom("Emile");
    	fournisseur.getArticles().add(article2);
    	fournisseur.getArticles().add(article1);
    	FournisseursDao fournisseurDAO = new FournisseursDao();
    	Fournisseurs savedFournisseur = fournisseurDAO.merge(fournisseur);
    	
    	article1.setFournisseur(savedFournisseur);
    	article2.setFournisseur(savedFournisseur);
    	Article savedArticle1 = articleDao.merge(article1);
    	Article savedArticle2 = articleDao.merge(article2);
    	
    	List<Fournisseurs> fournisseurFinal = fournisseurDAO.getFournisseurEtArticlesAssocies("Emile");
    	Assertions.assertNotNull(fournisseurFinal);
    	Assertions.assertFalse(fournisseurFinal.isEmpty());
    	int numberOfArticles = fournisseurFinal.get(0).getArticles().size();
    	Assertions.assertEquals(2, numberOfArticles);
    
    	/*Assertions.assertNotNull(savedArticle1.getiD());
    	Assertions.assertNotNull(savedArticle2.getiD());*/
    	
    	
    }
}

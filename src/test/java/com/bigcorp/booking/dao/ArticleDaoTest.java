package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.EtatArticle;
import com.bigcorp.booking.model.Fournisseur;

public class ArticleDaoTest {
	  
    @Test
    public void testMerge() {
    	
		ArticleDao articleDao = new ArticleDao();
		Article article = new Article();
		String nomArticle = "mon article";
		EtatArticle etatArticle = EtatArticle.OCCASION;
		String fc = "f";
		
		article.setEtatArticle(etatArticle);
		article.setNom(nomArticle);
		article.setFc(fc);
		//Faire de même pour les autres attributs...
		Article articleSauvegarde = articleDao.merge(article);
		
		Assertions.assertNotNull(articleSauvegarde.getId());
		
		Article articleLu = articleDao.findById(Article.class, articleSauvegarde.getId());
		
		Assertions.assertEquals(nomArticle, articleLu.getNom());
		Assertions.assertEquals(etatArticle, articleLu.getEtatArticle());
		Assertions.assertEquals(fc, articleLu.getFc());
		//Faire de même pour les autres attributs...
		
		
    }
    
    public void testPersist() {
		ArticleDao articleDao = new ArticleDao();
		Article article = new Article();
		String nomArticle = "Un autre article";
		EtatArticle etatArticle = EtatArticle.OCCASION;
		
		article.setEtatArticle(etatArticle);
		article.setNom(nomArticle);
		articleDao.persist(article);
		
		Assertions.assertNotNull(article.getId());
    }
	  
    @Test
    public void testMergeAvecFournisseur() {
    	
    	//Sauvegarde fournisseur
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur fournisseur = new Fournisseur();
    	fournisseur.setNom("Chez Rosalie");
    	Fournisseur fournisseurSauvegarde = fournisseurDao.merge(fournisseur);
    	
    	//Sauvegarde article
		ArticleDao articleDao = new ArticleDao();
		Article article = new Article();
		
		//Rattachement
		article.setFournisseur(fournisseurSauvegarde);
		
		Article articleSauvegarde = articleDao.merge(article);
		
		Assertions.assertNotNull(articleSauvegarde.getId());
		
    }
	  
    @Test
    public void testGetParNomAvecFournisseur(){//Sauvegarde fournisseur
    	FournisseurDao fournisseurDao = new FournisseurDao();
    	Fournisseur fournisseur = new Fournisseur();
		String nomFournisseur = "Gentil fournisseur";
		fournisseur.setNom(nomFournisseur);
    	Fournisseur fournisseurSauvegarde = fournisseurDao.merge(fournisseur);
    	
    	//Sauvegarde article
		ArticleDao articleDao = new ArticleDao();
		Article nouvelArticle = new Article();
		String nomArticle = "Bel article, bel ouvrage !";
		nouvelArticle.setNom(nomArticle);

		//Rattachement
		nouvelArticle.setFournisseur(fournisseurSauvegarde);
		
		Article articleSauvegarde = articleDao.merge(nouvelArticle);
		
		List<Article> articles = articleDao.getParNomAvecFournisseur(nomArticle);
    	for(Article articleLu : articles) {
    		Assertions.assertEquals(nomFournisseur, articleLu.getFournisseur().getNom());
    	}
    	
    }
	
}
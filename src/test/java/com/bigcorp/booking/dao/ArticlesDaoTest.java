package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Articles;
import com.bigcorp.booking.model.EtatArticles;
import com.bigcorp.booking.model.Fournisseurs;

public class ArticlesDaoTest {
	  
    @Test
    public void testMerge() {
    	
		ArticlesDao articleDao = new ArticlesDao();
		Articles article = new Articles();
		String nomArticle = "mon article";
		EtatArticles etatArticle = EtatArticles.OCCASION;
		String fc = "f";
		
		article.setEtatArticle(etatArticle);
		article.setNom(nomArticle);
//		article.setFc(fc);
		//Faire de même pour les autres attributs...
		Articles articleSauvegarde = articleDao.merge(article);
		
		Assertions.assertNotNull(articleSauvegarde.getId());
		
		Articles articleLu = articleDao.findById(Articles.class, articleSauvegarde.getId());
		
		Assertions.assertEquals(nomArticle, articleLu.getNom());
		Assertions.assertEquals(etatArticle, articleLu.getEtatArticle());
//		Assertions.assertEquals(fc, articleLu.getFc());
		//Faire de même pour les autres attributs...
		
		
    }
    
    public void testPersist() {
		ArticlesDao articleDao = new ArticlesDao();
		Articles article = new Articles();
		String nomArticle = "Un autre article";
		EtatArticles etatArticle = EtatArticles.OCCASION;
		
		article.setEtatArticle(etatArticle);
		article.setNom(nomArticle);
		articleDao.persist(article);
		
		Assertions.assertNotNull(article.getId());
    }
	  
    @Test
    public void testMergeAvecFournisseur() {
    	
    	//Sauvegarde fournisseur
    	FournisseursDao fournisseurDao = new FournisseursDao();
    	Fournisseurs fournisseur = new Fournisseurs();
    	fournisseur.setNom("Chez Rosalie");
    	Fournisseurs fournisseurSauvegarde = fournisseurDao.merge(fournisseur);
    	
    	//Sauvegarde article
		ArticlesDao articleDao = new ArticlesDao();
		Articles article = new Articles();
		
		//Rattachement
		article.setFournisseur(fournisseurSauvegarde);
		
		Articles articleSauvegarde = articleDao.merge(article);
		
		Assertions.assertNotNull(articleSauvegarde.getId());
		
    }
	  
    @Test
    public void testGetParNomAvecFournisseur(){//Sauvegarde fournisseur
    	FournisseursDao fournisseurDao = new FournisseursDao();
    	Fournisseurs fournisseur = new Fournisseurs();
		String nomFournisseur = "Gentil fournisseur";
		fournisseur.setNom(nomFournisseur);
    	Fournisseurs fournisseurSauvegarde = fournisseurDao.merge(fournisseur);
    	
    	//Sauvegarde article
		ArticlesDao articleDao = new ArticlesDao();
		Articles nouvelArticle = new Articles();
		String nomArticle = "Bel article, bel ouvrage !";
		nouvelArticle.setNom(nomArticle);

		//Rattachement
		nouvelArticle.setFournisseur(fournisseurSauvegarde);
		
		Articles articleSauvegarde = articleDao.merge(nouvelArticle);
		
		List<Articles> articles = articleDao.getParNomAvecFournisseur(nomArticle);
    	for(Articles articleLu : articles) {
    		Assertions.assertEquals(nomFournisseur, articleLu.getFournisseur().getNom());
    	}
    	
    }
	
}
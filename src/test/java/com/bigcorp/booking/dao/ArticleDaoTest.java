package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;

public class ArticleDaoTest {

//	@Test
//	public void testSave() {
//		String nom = "iPhone 15 Pro Max";
//		ArticleDao articleDao = new ArticleDao();
//		Article article = new Article();
//
//		article.setNom(nom);
//
//		Article savedArticle = articleDao.merge(article);
//
//		Assertions.assertNotNull(savedArticle.getId());
//
//		Article articleRecord = articleDao.findById(savedArticle.getId());
//
//		Assertions.assertEquals(nom, articleRecord.getNom());
//	}
//
//	@Test
//	public void testSaveTwo() {
//
//		String nom = "iPad Pro";
//		ArticleDao articleDao = new ArticleDao();
//		Article article = new Article();
//
//		article.setNom(nom);
//		article.setDescription("New iPad Pro - 1TB storage capacity");
//
//		Article savedArticle = articleDao.merge(article);
//
//		Assertions.assertNotNull(savedArticle.getId());
//	}

	@Test
	public void testClassRelationship() {

		String nom = "Apple VR Headset";
		ArticleDao articleDao = new ArticleDao();
		Article article = new Article();
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();
		
		fournisseur.setNom("Apple Inc.");
		
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);

		article.setNom(nom);
		article.setFournisseur(savedFournisseur);
		article.setDescription("New iPad Pro - 1TB storage capacity");
		articleDao.merge(article);
		
		Assertions.assertEquals(savedFournisseur.getId(), article.getFournisseur().getId());
	}
}

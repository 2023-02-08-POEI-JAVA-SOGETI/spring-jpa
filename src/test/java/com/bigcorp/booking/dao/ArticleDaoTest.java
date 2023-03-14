package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;

public class ArticleDaoTest {

	@Test
	public void testSave() {
		String nom = "iPhone 15 Pro Max";
		ArticleDao articleDao = new ArticleDao();
		Article article = new Article();

		article.setNom(nom);

		Article savedArticle = articleDao.merge(article);

		Assertions.assertNotNull(savedArticle.getId());

		Article articleRecord = articleDao.findById(savedArticle.getId());
		
		Assertions.assertEquals(nom, articleRecord.getNom());
	}
	
	@Test
	public void testSaveTwo() {
		
		String nom = "iPad Pro";
		ArticleDao articleDao = new ArticleDao();
		Article article = new Article();
		
		article.setNom(nom);
		article.setDescription("New iPad Pro - 1TB storage capacity");
		
		Article savedArticle = articleDao.merge(article);
		
		Assertions.assertNotNull(savedArticle.getId());
	}
}

package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.service.ArticleService;
import com.bigcorp.booking.service.FournisseurService;
import com.bigcorp.booking.spring.SpringConfiguration;

import tp_spring_jpa_pablo.model.Article;
import tp_spring_jpa_pablo.model.Fournisseur;

@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleSpringDaoTest {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private FournisseurService fournisseurService;

	@Test
	public void testSave() {
		Article article = new Article();
		articleService.save(article);
		Assertions.assertNotNull(article);
		Assertions.assertNotNull(article.getId());
	}
	  
	@Test
	public void testDeleteByFournisseurId() {
	    // Create a Fournisseur with id 1
	    Fournisseur fournisseur = new Fournisseur();
	    fournisseur.setId(1);

	    // Create two Articles, one with the same Fournisseur id
	    Article article1 = new Article();
	    article1.setFournisseur(fournisseur);

	    Article article2 = new Article();
	    article2.setFournisseur(fournisseur);

	    // Save the Fournisseur and Articles
	    fournisseurService.save(fournisseur);
	    articleService.save(article1);
	    articleService.save(article2);

	    // Delete Articles with Fournisseur id 1
	    articleService.deleteByFournisseurId(1);

	    // Retrieve all Articles
	    Iterable<Article> remainingArticles = articleService.findAll();
	    
	    // Check that only the Articles with Fournisseur id 1 have been deleted
	    for (Article article : remainingArticles) {
	        if (article.getFournisseur() != null) {
	            Assertions.assertNotEquals(1, article.getFournisseur().getId());
	        }
	    }
	    
	    // Check that only the Articles with Fournisseur id 1 have been deleted
	    for (Article article : remainingArticles) {
	        Assertions.assertNull(article.getFournisseur());
	    }
	}

	
}

package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.Article.EtatArticle;
import com.bigcorp.booking.service.ArticleService;
import com.bigcorp.booking.service.FournisseurService;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleSpringDaoTest {
	    @Autowired
	    private ArticleService articleService;
	    
	    @Autowired
	    private FournisseurService fournisseurService;
	    
//	    @Test
//	    @DisplayName("Testing if service correctly saves an Article")
//	    void testSave() {
//
//			Article article = new Article(456,"F", "Star Platinum", "Stand", EtatArticle.OCCASION);
//	        
//	        articleService.save(article);
//
//	        Assertions.assertNotNull(article);
//	        Assertions.assertNotNull(article.getId());
//	    }
	    
	    @Test
	    @DisplayName("associates an article with a fournisseur")
	    public void testAssociation() {
			Fournisseur fournisseur = new Fournisseur(456, "David Production", "contact@davidproduction.co.jp", "Tokyo, Japan");
			
			fournisseurService.save(fournisseur);
			
			Article article = new Article(456,"F", "Star Platinum", "Stand", EtatArticle.OCCASION);
			
			articleService.save(article);
			
			articleService.associateWithFournisseur(1, 1);
			
	        Assertions.assertNotNull(article);
	        Assertions.assertEquals("David Production", articleService.getById(1).getFournisseur().getNom());
	    }
	}

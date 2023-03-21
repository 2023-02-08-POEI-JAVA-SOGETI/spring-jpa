package com.bigcorp.booking.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.dao.spring.ArticlesSpringDao;

import com.bigcorp.booking.dao.spring.FournisseursSpringDao;

import com.bigcorp.booking.model.Articles;
import com.bigcorp.booking.model.Fournisseurs;
import com.bigcorp.booking.service.ArticlesService;
import com.bigcorp.booking.spring.SpringConfiguration;


@SpringJUnitConfig(SpringConfiguration.class)

class ArticlesTest {

	@Autowired
	private ArticlesService articleService;
	
//	private Articles article;
	
//	 @BeforeEach
//	public void setUp() {
//        article = new Articles();
//        article.setNom("Article-Test");
//        article.setDescription("Ceci est un article de test.");
//        article.setNumero(478);
//    }

	@Test
	public void testSaveGet() {
	 Articles article = new Articles();
	 article.setNom("Article-Test");
	 Articles articleSauvegarde = this.articleService.save(article);
	 Assertions.assertNotNull(articleSauvegarde);
	 Assertions.assertNotNull(articleSauvegarde.getId());
	 Articles articleRecupere = this.articleService.findById(articleSauvegarde.getId());
	 Assertions.assertNotNull(articleRecupere);
	}
	
//	@Test
//    public void testUpdate() {
//        Articles articleSauvegarde = articleService.save(article);
//        articleSauvegarde.setNumero(325);
//        Articles articleMisAJour = articleService.update(articleSauvegarde);
//        Assertions.assertEquals(articleSauvegarde.getId(), articleMisAJour.getId());
//    }
	
//	@Test
//	public void delete() {
//	Articles articleSauvegarde = articleService.save(article);	
//	Assertions.assertNotNull(articleSauvegarde);
//	Assertions.assertNotNull(articleSauvegarde.getId());
//
//	this.articleService.delete(articleSauvegarde.getId());
//
//	Articles articleRecupere = this.articleService.findById(articleSauvegarde.getId());
//	Assertions.assertNull(articleRecupere);
//	
//	}
	
	}

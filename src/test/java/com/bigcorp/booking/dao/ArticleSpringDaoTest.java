package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.service.ArticleService;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleSpringDaoTest {

	@Autowired
	private ArticleService articleService;

	@Test

	public void testsauvegarde() {
		Article article = new Article();
		article.setNom("Jaguar");
		
		article.setNumero(1234);
		articleService.sauvegarde(article);
		Assertions.assertNotNull(article.getId());
	}

	@Test
	public void testfindByNom() {
		Article article = new Article();
		article.setNom("Jeep");
		
		article.setNumero(1235);
		articleService.sauvegarde(article);
		
		List<Article> articleDelaBase = articleService.findByNom(article.getNom());
		
		Assertions.assertFalse(articleDelaBase.isEmpty());
	}
	
	

	@Test
	public void testget() {
		Article article = new Article();
		article.setNom("range rover");
		
		article.setNumero(1237);
		articleService.sauvegarde(article);
		
		
		Article articleDeLaBase = articleService.get(article.getId());
		Assertions.assertNotNull(articleDeLaBase);
	}

	@Test
	public void testsupprimmer() {
		Article article = new Article();
		article.setNom("Chevrolet");
		
		article.setNumero(1239);
		articleService.sauvegarde(article);
		
		Assertions.assertNotNull(article);
		articleService.supprimer(article.getId());
		Article articleDeLaBase = articleService.get(article.getId());
		Assertions.assertNull(articleDeLaBase);
		
	}

}

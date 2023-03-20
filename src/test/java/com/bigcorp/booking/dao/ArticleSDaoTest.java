package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.service.ArticleService;
import com.bigcorp.booking.spring.SpringConfiguration;

import tp_spring_jpa_pablo.model.Article;

@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleSDaoTest {

	@Autowired
	private ArticleService articleService;

	@Test
	public void testSave() {
		Article article = new Article();
		articleService.save(article);
		Assertions.assertNotNull(article);
		Assertions.assertNotNull(article.getId());
	}
	  

}

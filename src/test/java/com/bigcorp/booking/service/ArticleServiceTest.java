package com.bigcorp.booking.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.TypeArticle;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleServiceTest {

	@Autowired
	private ArticleService articleService;

	@Test
	public void saveArticleTest() {
		Article article = new Article();
		article.setNom("micro");
		article.setNumArticle(36);
		article.setDescription("description du micro");
		article.setType(TypeArticle.NEUF);
		articleService.save(article);
		
		Assertions.assertNotNull(article);
		Assertions.assertNotNull(article.getId());
	}
	
	@Test
	public void testFindByName() {
		Article articleSecond = new Article();
		
		articleSecond.setNom("micro mieux");
		articleSecond.setNumArticle(37);
		articleSecond.setDescription("description du micro mieux");
		articleSecond.setType(TypeArticle.NEUF);
		articleService.save(articleSecond);
		
		Article microMieux = articleService.save(articleSecond);
		Assertions.assertNotNull(microMieux);
		articleService.findByNom("micro mieux");
	}
	
	@Test
	public void testFindById() {
		Article articleTroisieme = new Article();
		
		articleTroisieme.setNom("micro plus mieux");
		articleTroisieme.setNumArticle(38);
		articleTroisieme.setDescription("description du micro plus mieux");
		articleTroisieme.setType(TypeArticle.NEUF);
		
		articleService.save(articleTroisieme);
		Article article1 = articleService.findById(4);
		Assertions.assertEquals(article1.getNom(), "micro plus mieux");
	}
	
	@Test
	public void delete() {		
		Article articleSuppr = new Article();
		
		articleSuppr.setNom("micro le best");
		articleSuppr.setNumArticle(39);
		articleSuppr.setDescription("description du micro le best");
		articleSuppr.setType(TypeArticle.NEUF);
		
		Article bestMicro = articleService.save(articleSuppr);
		Assertions.assertNotNull(bestMicro);
		articleService.delete(1);
		Assertions.assertNull(articleService.findById(1));
	}
}

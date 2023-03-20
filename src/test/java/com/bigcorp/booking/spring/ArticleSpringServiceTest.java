package com.bigcorp.booking.spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.service.spring.ArticleSpringService;


@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleSpringServiceTest {
	
	@Autowired
	private ArticleSpringService articleService;

	@Test
	public void test() {
		Article article1 = new Article();
		Article article2 = new Article();
		article1.setNom("Test");
		article1.setNumeroUnique(123);
		article2.setNom("Test");
		article2.setNumeroUnique(456);
		articleService.save(article2);
		articleService.save(article1);
		List<Article> resultTest = articleService.findContainingName("Test");
		Assertions.assertEquals(2, resultTest.size());
	}

}

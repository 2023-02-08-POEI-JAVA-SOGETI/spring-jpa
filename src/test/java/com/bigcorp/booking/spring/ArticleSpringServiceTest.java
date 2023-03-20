package com.bigcorp.booking.spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseurs;
import com.bigcorp.booking.service.spring.ArticleSpringService;
import com.bigcorp.booking.service.spring.FournisseurSpringService;


@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleSpringServiceTest {
	
	@Autowired
	private ArticleSpringService articleService;
	@Autowired
	private FournisseurSpringService fournisseurService;

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
	@Test
	public void test2() {
		Article article1 = new Article();
		
		
		Fournisseurs fourn2 = new Fournisseurs();
		article1.setNom("Dark Souls");
		article1.setNumeroUnique(785);
		fourn2.setNom("Revo");
		fourn2.setNumeroUnique(78663);
		articleService.save(article1);
		fournisseurService.save(fourn2);
		articleService.saveWithFournisseur(article1.getiD(), fourn2.getiD());
		Article nouvelArticle = articleService.findById(article1.getiD());
		Assertions.assertEquals(nouvelArticle.getFournisseur().getiD(), fourn2.getiD());
	}

}

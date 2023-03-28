package com.bigcorp.booking.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.EtatArticle;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.exception.FournisseurException;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleServiceTest {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private FournisseurService fournisseurService;

	@Test
	public void testSaveGet() {
		Article article = new Article();
		article.setNom("Jean-Spring");
		Article articleSauvegarde = this.articleService.save(article);

		Assertions.assertNotNull(articleSauvegarde);
		Assertions.assertNotNull(articleSauvegarde.getId());

		Article articleRecupere = this.articleService.findById(articleSauvegarde.getId());
		Assertions.assertNotNull(articleRecupere);
	}

	@Test
	public void testDelete() {
		Article article = new Article();
		Article articleSauvegarde = this.articleService.save(article);
		this.articleService.delete(articleSauvegarde.getId());

		Article articleRecupere = this.articleService.findById(articleSauvegarde.getId());
		Assertions.assertNull(articleRecupere);
	}

	@Test
	public void testSaveGetByEtat() {
		Article article = new Article();
		article.setNom("Jean-Spring");
		EtatArticle etatArticle = EtatArticle.NEUF;
		article.setEtatArticle(etatArticle);
		Article articleSauvegarde = this.articleService.save(article);

		Assertions.assertNotNull(articleSauvegarde);
		Assertions.assertNotNull(articleSauvegarde.getId());

		List<Article> articles = this.articleService.findByEtat(etatArticle);
		Assertions.assertFalse(articles.isEmpty());
	}

	@Test
	public void testAttache() throws FournisseurException {
		Article article = new Article();
		Article articleSauvegarde = this.articleService.save(article);

		Fournisseur fournisseur = new Fournisseur();
		fournisseurService.save(fournisseur);
		
		
	}

}

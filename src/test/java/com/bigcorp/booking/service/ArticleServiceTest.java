package com.bigcorp.booking.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.TypeArticle;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
//@Transactional
public class ArticleServiceTest {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private FournisseurService fournisseurService;
	
	@Test
	public void saveArticleTest() {
		Article article = new Article();
		article.setNom("micro");
		article.setNumArticle(36);
		article.setDescription("description du micro");
		article.setType(TypeArticle.NEUF);
		articleService.save(article);
		
		Assertions.assertNotNull(article);
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
		
		Article articleEnreg = articleService.save(articleTroisieme);
		Assertions.assertEquals(articleEnreg.getNom(), "micro plus mieux");
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
	
	@Test
	public void persisteArticleAvecFournisseur() {		
		Article article = new Article();
		Fournisseur fourni = new Fournisseur();
		
 		article.setNom("micro le best");
		article.setNumArticle(39);
		article.setDescription("description du micro le best");
		article.setType(TypeArticle.NEUF);
		fourni.setNom("Nom Fournisseur de l'article");
		
		articleService.save(article);
		fournisseurService.save(fourni);
		
		articleService.persistArticleWithFournisseur(article.getId(), fourni.getId());
		Article articleWithF = articleService.findById(article.getId());
		Assertions.assertEquals(articleWithF.getFournisseur().getId(), fourni.getId());
	}
	
	@Test
	public void getAllArticles() {
		List<Article> listArticlesBase = (List<Article>) articleService.findAll();
		listArticlesBase.clear();
		Article article = new Article();
		Article article2 = new Article();
		
 		article.setNom("article1");
		article.setNumArticle(991);
		article.setDescription("description article1");
		article.setType(TypeArticle.NEUF);
		
		article2.setNom("article2");
		article2.setNumArticle(992);
		article2.setDescription("description article2");
		article2.setType(TypeArticle.NEUF);
		
		articleService.save(article);
		articleService.save(article2);
		
		List<Article> listArticles = (List<Article>) articleService.findAll();
		Assertions.assertTrue(listArticles.size() >= 2);
		listArticles.clear();
	}
}

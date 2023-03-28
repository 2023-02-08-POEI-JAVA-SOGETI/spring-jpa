package com.bigcorp.booking.spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.exercice.model.many_to_one.Article;
import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;
import com.bigcorp.booking.exercice.model.many_to_one.Type;
import com.bigcorp.booking.spring.service.ArticleService;
import com.bigcorp.booking.spring.service.FournisseurService;

@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleDaoSpringTest {
	
	@Autowired
	private ArticleService service;
	
	@Autowired
	private FournisseurService fourService;
	
	@Test
	public void createArticleTest()
	{
		final Integer NUM = 569512;
		final Type TYPE = Type.VENTE;
		final String NOM= "SPRING Artcile";
		final String DESCRIPTION = "This is a Spring Article";
		Article article = new Article(NUM,
									TYPE,
									NOM,
									DESCRIPTION
												);
		
		Article testArticle = service.createArticle(article);
		Assertions.assertNotNull(testArticle.getId());
		Assertions.assertEquals("SPRING Artcile", testArticle.getNom());
		
	}
	
	
	
	
	@Test
	public void getArticleByIdTest()
	{
		createArticleTest();
		Article article = service.getArticleById(1);
		Assertions.assertNotNull(article.getNom());
	}
	
	
	public void getArticleByType()
	{
		List<Article> articles = service.getArticlesByType("ACHAT");
		Assertions.assertTrue(!articles.isEmpty());
	}
	
	
	@Test
	public void createArticleWithFournisseurTest() throws Exception
	{
		Fournisseur fournisseur1 = new Fournisseur();
		fournisseur1.setNom("Nom du fournisseur");
		fourService.createFournisseur(fournisseur1);
		
		Article article1 = new Article();
		article1.setNom("Nom de l'article");
		service.createArticle(article1);

		Assertions.assertTrue(!fournisseur1.equals(null));
		Assertions.assertTrue(!article1.equals(null));
		
		
		service.associatedArticleWithFournisseur(article1.getId(), fournisseur1.getId());
		
		Article articleTest = service.getArticleById(article1.getId());
		
		Assertions.assertEquals(fournisseur1.getId(),articleTest.getFournisseur().getId());
		
		
		
	}
	
	
	
	
	public void deleteArticleByIdTest()
	{
		
	}
	
	
	
	public void getArticleByTypeTest()
	{
		
	}
	
	
	
	
	// DTO
	
	
	
	public void getArticleByIdWithDTO()
	{
		
	}
	
	public void createArticleWithDTO()
	{
		
	}
	
}

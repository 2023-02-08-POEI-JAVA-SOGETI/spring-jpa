package com.bigcorp.booking.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.exercice.model.many_to_one.Article;
import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;
import com.bigcorp.booking.spring.service.FournisseurService;

@SpringJUnitConfig(SpringConfiguration.class)
public class FournisseurDaoSpringTest {
	
	@Autowired
	private FournisseurService service;
	
//	@Autowired
//	private ArticleService artService;
	
	@Test
	public void createFournisseurTest()
	{
		final String NOM = "TEST Spring Fournisseur";
		final Integer NUM = 03030303;
		final String EMAIL = "TEST Spring email";
		final String ADRESSE = "TEST Spring adresse";
		
		Fournisseur fournisseur = new Fournisseur(NOM,
												NUM,
												EMAIL,
												ADRESSE
														);
		
		Article articleForFournisseurList = new Article();
		
		Fournisseur testFournisseur = service.createFournisseur(fournisseur);
		
		testFournisseur.getArticles().add(articleForFournisseurList);
		
//		artService.createArticle(articleForFournisseurList);
		
		Assertions.assertNotNull(testFournisseur.getId());
		Assertions.assertEquals("TEST Spring Fournisseur", testFournisseur.getNom());
		
//		Assertions.assertTrue(!testFournisseur.getArticles().isEmpty());
		
	}
	
	
	@Test
	public void getFournisseurByIdTest()
	{
		createFournisseurTest();
		Fournisseur fournisseur = service.getFournisseurById(1);
		Assertions.assertNotNull(fournisseur.getNom());
	}

}

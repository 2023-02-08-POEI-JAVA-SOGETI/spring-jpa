package com.bigcorp.booking.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.exercice.model.many_to_one.Article;
import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;
import com.bigcorp.booking.mvc.rest.FournisseurDto;
import com.bigcorp.booking.spring.service.ArticleService;
import com.bigcorp.booking.spring.service.FournisseurService;

@SpringJUnitConfig(SpringConfiguration.class)
public class FournisseurDaoSpringTest {
	
	@Autowired
	private FournisseurService service;
	
	@Autowired
	private ArticleService artService;
	
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
		
		
		Assertions.assertNotNull(testFournisseur.getId());
		Assertions.assertEquals("TEST Spring Fournisseur", testFournisseur.getNom());
		
		
	}
	
	
	@Test
	public void getFournisseurByIdTest()
	{
		createFournisseurTest();
		Fournisseur fournisseur = service.getFournisseurById(1);
		Assertions.assertNotNull(fournisseur.getNom());
	}
	
	
	@Test
	public void getFournisseurWithArticlesTest() throws Exception
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
		
		Fournisseur fournisseurTest = service.createFournisseur(fournisseur);
		
		Article article = new Article();
		Article articleTest = artService.createArticle(article);
		artService.associatedArticleWithFournisseur(articleTest.getId(), fournisseurTest.getId());
		
		Fournisseur fournisseurTest2 = service.getFournisseurWithArticles(fournisseurTest.getId());
		
		Assertions.assertTrue(fournisseurTest.getId()!= null);
		Assertions.assertTrue(articleTest.getId()!= null);
		Assertions.assertTrue(fournisseurTest2.getId()!= null);
		Assertions.assertFalse(fournisseurTest2.getArticles().isEmpty());
	}
	
	@Test
	public void updateFournisseurTest()
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
		
		Fournisseur fournisseurTest = service.createFournisseur(fournisseur);
		
		service.updateFournisseur(fournisseurTest);
		
		Assertions.assertEquals("TEST Spring email", fournisseurTest.getEmail());
		
	}
	
	
	
	
	
	
	// DTO
	
	
	@Test
	public void createFournisseurWithDtoTest()
	{
		FournisseurDto dto = new FournisseurDto();
		dto.setNom("nom");
		FournisseurDto dtoTest = service.createFournisseurWithDto(dto);
		Assertions.assertEquals("nom", dtoTest.getNom());
		
	}
	
	
	@Test
	public void getFournisseurByIdWithDTOTest()
	{
		Fournisseur f = new Fournisseur();
		f.setNom("nom");
		Fournisseur f2 = service.createFournisseur(f);
		
		FournisseurDto dto = service.getFournisseurByIdWithDTO(f2.getId());
		
		Assertions.assertEquals("nom", dto.getNom());
	}
	
	
	@Test
	public void updateFournisseurWithDTOTest()
	{
		FournisseurDto dto = new FournisseurDto();
		dto.setNom("nom");
		
		FournisseurDto dtoTest = service.createFournisseurWithDto(dto);
		
		FournisseurDto dtoTestAfterUpdate = service.updateFournisseurWithDTO(dtoTest);
		
		Assertions.assertEquals("nom", dtoTestAfterUpdate.getNom());
		
	}
	
	

}

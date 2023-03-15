package com.bigcorp.booking.exercice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.exercice.dao.ArticleDao;
import com.bigcorp.booking.exercice.dao.FournisseurDao;
import com.bigcorp.booking.exercice.model.Article;
import com.bigcorp.booking.exercice.model.Fournisseur;
import com.bigcorp.booking.exercice.model.Type;

public class ArticleDaoTest {
	
static ArticleDao dao;
	
	@BeforeAll
	public static void initDao()
	{
		 dao = new ArticleDao();
	}
	
	
	@Test
	public void mergeTest()
	{
		final Integer NUM = 03030303;
		final Type TYPE = Type.ACHAT;
		final String NOM= "TEST email";
		final String DESCRIPTION = "TEST adresse";
		
		Article article = new Article(NUM,
											TYPE,
											NOM,
											DESCRIPTION
														);
		
		
		
		Article testArticle = dao.merge(article);
		
		Assertions.assertNotNull(testArticle.getId());
		
		Assertions.assertEquals(NOM, testArticle.getNom());
		Assertions.assertEquals(NUM, testArticle.getNumArticle());
		Assertions.assertEquals(TYPE, testArticle.getType());
		Assertions.assertEquals(DESCRIPTION, testArticle.getDescription());
		
		
	}
	
//	@Test
//	public void findByIdTest()
//	{
//		Fournisseur fournisseurTest = new Fournisseur();
//		fournisseurTest.setNom("TEST");
//		dao.merge(fournisseurTest);
//		
//		Fournisseur resultTest = dao.findById(Fournisseur.class, 1);
//		
//		Assertions.assertEquals("TEST", resultTest.getNom());
//		
//	}

}

package com.bigcorp.booking.exercice;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.exercice.entityManager_jpql.many_to_one.ArticleDao;
import com.bigcorp.booking.exercice.entityManager_jpql.many_to_one.FournisseurDao;
import com.bigcorp.booking.exercice.model.many_to_one.Article;
import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;
import com.bigcorp.booking.exercice.model.many_to_one.Type;

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
	
	@Test
	public void findByIdTest()
	{
		Article articleTest = new Article();
		articleTest.setNom("TEST");
		dao.merge(articleTest);
		
		Article resultTest = dao.findById(Article.class, 1);
		
		Assertions.assertEquals("TEST", resultTest.getNom());
		
	}
	
	
	 @Test
	    public void testGetParNom() {
		 ArticleDao articleDao = new ArticleDao();
			Article article1 = new Article();
	    	String nomDurand = "leNomDurandDuTestGetParNom";
	    	article1.setNom(nomDurand);
	    	articleDao.merge(article1);
	    	
			Article article2 = new Article();
			article2.setNom(nomDurand);
	    	articleDao.merge(article2);
	    	
	    	List<Article> clients = articleDao.findByName(nomDurand);
	    	Assertions.assertEquals(2, clients.size());
	    	
	    }
	 
	 @Test
	    public void testGetParNomStartWith() {
		 ArticleDao articleDao = new ArticleDao();
			Article article1 = new Article();
	    	String nom= "Zzzz";
	    	article1.setNom(nom);
	    	articleDao.merge(article1);
	    	
	    	
	    	List<Article> articles = articleDao.findByNameStartWith("z");
	    	Assertions.assertTrue(!articles.isEmpty());
	    	
	    }
	 
	 
	 @Test
	 public void testManyToOneRelation()
	 {
		 FournisseurDao fourDao = new FournisseurDao();
		 Fournisseur fournisseur = new Fournisseur();
		 fournisseur.setNom("Test de ma relation avec Article");
		 fournisseur = fourDao.merge(fournisseur);
		 
		 ArticleDao articleDao = new ArticleDao();
		 Article article = new Article();
		 article.setFournisseur(fournisseur);
		 articleDao.merge(article);
		 
		 Assertions.assertEquals(fournisseur.getId(), article.getFournisseur().getId());
		 
	 }

}

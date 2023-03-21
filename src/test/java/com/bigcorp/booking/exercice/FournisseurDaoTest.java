package com.bigcorp.booking.exercice;




import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.exercice.entityManager_jpql.many_to_one.ArticleDao;
import com.bigcorp.booking.exercice.entityManager_jpql.many_to_one.FournisseurDao;
import com.bigcorp.booking.exercice.model.many_to_one.Article;
import com.bigcorp.booking.exercice.model.many_to_one.Fournisseur;

public class FournisseurDaoTest {
	
	
	static FournisseurDao dao;
	
	@BeforeAll
	public static void initDao()
	{
		 dao = new FournisseurDao();
	}
	
	
	@Test
	public void mergeTest()
	{
		final String NOM = "TEST nom";
		final Integer NUM = 03030303;
		final String EMAIL = "TEST email";
		final String ADRESSE = "TEST adresse";
		
		Fournisseur fournisseur = new Fournisseur(NOM,
												NUM,
												EMAIL,
												ADRESSE
														);
		
		
		
		Fournisseur testFournisseur = dao.merge(fournisseur);
		
		Assertions.assertNotNull(testFournisseur.getId());
		
		Assertions.assertEquals(NOM, testFournisseur.getNom());
		Assertions.assertEquals(NUM, testFournisseur.getNum());
		Assertions.assertEquals(EMAIL, testFournisseur.getEmail());
		Assertions.assertEquals(ADRESSE, testFournisseur.getAdresse());
		
		
	}
	
	@Test
	public void findByIdTest()
	{
		Fournisseur fournisseurTest = new Fournisseur();
		fournisseurTest.setNom("TEST");
		dao.merge(fournisseurTest);
		
		Fournisseur resultTest = dao.findById(Fournisseur.class, 1);
		
		Assertions.assertEquals("TEST", resultTest.getNom());
		
	}
	
	
	@Test
	public void findByNameTest()
	{
		Fournisseur fournisseurTest = new Fournisseur();
		fournisseurTest.setNom("TEST2");
		dao.merge(fournisseurTest);
		
		List<Fournisseur> resultTest = dao.findByName("TEST2");
		
		Assertions.assertTrue(!resultTest.isEmpty());
		
	}
	
	
	@Test
	public void findByNameWithListOfArticlesTest()
	{
		Fournisseur fournisseur = new Fournisseur();
		String nom = "Mon fournisseur de test";
		fournisseur.setNom(nom);
		
		Fournisseur mergeFournisseur =
				dao.merge(fournisseur);
		
		
		ArticleDao artDao = new ArticleDao();
		
		Article article1 = new Article();
		article1.setNom("Nom de l'article 1");
		article1.associateWith(mergeFournisseur);
		artDao.merge(article1);
		
		Article article2 = new Article();
		article2.setNom("Nom de l'article 2");
		article2.associateWith(mergeFournisseur);
		artDao.merge(article2);
		
		
		List<Fournisseur> listFournisseurATester = dao.findByNameWithListOfArticles(nom);
		Assertions.assertFalse(listFournisseurATester.isEmpty());
		
		Fournisseur aTester = listFournisseurATester.iterator().next();
		
		
		Assertions.assertEquals(2, aTester.getArticles().size());
		
		
	}

}

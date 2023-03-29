package com.bigcorp.booking.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Etat;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.ArticleService;
import com.bigcorp.booking.service.FournisseurService;
import com.bigcorp.booking.spring.SpringConfiguration;


@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleServiceTest {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private FournisseurService fournisseurService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceTest.class);

	@Test
	public void testSaveArticle() {
		Article a = new Article(1, "etat", "nom", "description");
		Article saved = articleService.save(a);

		Assertions.assertNotNull(saved.getId());
		LOGGER.info("testSaveArticle : " + saved.getId() + " - " + saved.getNom());
	}
	
	@Test
	public void testFindArticle() {
		Article a = new Article(2, "etat", "nom", "description");
		Article saved = articleService.save(a);
		
		Article saved2 = articleService.findById(saved.getId());
		Assertions.assertNotNull(saved2.getId());
		LOGGER.info("testFindArticle : " + saved2.getId());
	}
	
	@Test
	public void testSaveFournisseur() {
		Fournisseur f = new Fournisseur();
		Fournisseur saved = fournisseurService.save(f);
		
		Assertions.assertNotNull(saved.getId());
		LOGGER.info("testSaveFournisseur : " + saved.getId());
	}		
	
	@Test
	public void testDeleteArticle() {
		Article a = new Article(2, "etat", "article a supprimer", "description");
		Article saved = articleService.save(a);
		
		articleService.deleteById(saved.getId());
		
		Article test = articleService.findById(saved.getId());
		Assertions.assertNull(test);
		LOGGER.info("testDeleteArticle : article supprimé : " + saved.getId());
	}
	
	@Test
	public void testArticleFindByFournisseur() {
		Fournisseur f = new Fournisseur(10, "black & d'equerre", "a@a.com", "adresse b&d");
		Fournisseur savedFournisseur = fournisseurService.save(f);

    	Article a1 = new Article(1, Etat.INUTILISABLE.name(), "pelle", "une pelle ca creuse");
    	Article a2= new Article(2, Etat.NEUF.name(), "pioche", "toute neuve");
    	Article a3 = new Article(3, Etat.OCCASION.name(), "marteau piqueur", "pour casser des trucs");
		
    	a1.setFournisseur(savedFournisseur);
    	a2.setFournisseur(savedFournisseur);
    	a3.setFournisseur(savedFournisseur);
    	
    	Article savedArticleA1 = articleService.save(a1);
    	Article savedArticleA2 = articleService.save(a2);
    	Article savedArticleA3 = articleService.save(a3);
		LOGGER.info("testArticleFindByFournisseur : articles sauvegardés");
    	
    	List<Article> listArticleSaved = articleService.findByFournisseurId(savedFournisseur.getId());
    	
		Assertions.assertEquals(3, listArticleSaved.size());
	}
	
	@Test
	public void testSaveArticleAndFournisseur() {

		Fournisseur f = new Fournisseur(10, "Samsung", "a@a.com", "adresse");
		Fournisseur savedFournisseur = fournisseurService.save(f);
		
    	Article a = new Article(1, Etat.INUTILISABLE.name(), "telephone revolutionnaire", "qui appelle");
    	Article savedArticleA = articleService.save(a);

		LOGGER.info("saveArticleAndFournisseur : idArticle=" + savedArticleA.getId() + " - idFournisseur=" + savedFournisseur.getId());
    	Article updatedArticle = articleService.saveArticleAndFournisseur(savedArticleA.getId(), savedFournisseur.getId());

		Assertions.assertEquals(savedFournisseur.getId(), updatedArticle.getFournisseur().getId());
	}
	
	@Test
	public void testSaveArticleAndFournisseurException() {
		LOGGER.info("testSaveArticleAndFournisseurException");
		Assertions.assertThrows(NullPointerException.class, () -> articleService.saveArticleAndFournisseur(999, 100));
	}
	
	@Test
	public void testSaveArticleAndFournisseurError() {
		// Création du lien entre article et fournisseur
		Fournisseur f = new Fournisseur(12, "Lenovo", "a@a.com", "adresse");
		Fournisseur savedFournisseur = fournisseurService.save(f);
		
    	Article a = new Article(1, Etat.INUTILISABLE.name(), "Yoga 7", "qui appelle");
    	Article savedArticleA = articleService.save(a);
    	
    	articleService.saveArticleAndFournisseur(savedArticleA.getId(), savedFournisseur.getId());
    	Article updatedArticle = articleService.saveArticleAndFournisseur(savedArticleA.getId(), 3000);
		LOGGER.info("testSaveArticleAndFournisseurError : " + updatedArticle.getId());
		
		Assertions.assertNull(updatedArticle.getFournisseur());
	}
	
	@Test
	public void testFindAll() {
		Article a1 = new Article(2, "etat", "raquette", "Belle raquette de tennis");
		Article a2 = new Article(2, "etat", "club", "club de golf");
		
		articleService.save(a1);
		articleService.save(a2);
		LOGGER.info("testFindAll");
		
		List<Article> list = articleService.findAll();
		Assertions.assertEquals(2, list.size());
	}
}

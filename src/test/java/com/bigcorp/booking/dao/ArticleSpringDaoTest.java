package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Etat;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.ArticleService;
import com.bigcorp.booking.service.FournisseurService;
import com.bigcorp.booking.spring.SpringConfiguration;


@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleSpringDaoTest {

	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private FournisseurService fournisseurService;
	
	@Test
	public void testSaveArticle() {
		Article a = new Article(1, "etat", "nom", "description");
		Article saved = articleService.save(a);
		
		Assertions.assertNotNull(saved.getId());
	}
	
	@Test
	public void testFindArticle() {
		Article a = new Article(2, "etat", "nom", "description");
		Article saved = articleService.save(a);
		
		Article saved2 = articleService.findById(saved.getId());
		Assertions.assertNotNull(saved2.getId());
	}
	
	@Test
	public void testSaveFournisseur() {
		Fournisseur f = new Fournisseur();
		Fournisseur saved = fournisseurService.save(f);
		
		Assertions.assertNotNull(saved.getId());
	}		
	
	@Test
	public void testDeleteArticle() {
		Article a = new Article(2, "etat", "article a supprimer", "description");
		Article saved = articleService.save(a);
		
		articleService.deleteById(saved.getId());
		
		Article test = articleService.findById(saved.getId());
		Assertions.assertNull(test);
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
    	
    	List<Article> listArticleSaved = articleService.findByFournisseurId(savedFournisseur.getId());
    	
		Assertions.assertEquals(3, listArticleSaved.size());
	}
	
	@Test
	public void testSaveArticleAndFournisseur() {

		Fournisseur f = new Fournisseur(10, "Samsung", "a@a.com", "adresse");
		Fournisseur savedFournisseur = fournisseurService.save(f);
		
    	Article a = new Article(1, Etat.INUTILISABLE.name(), "telephone revolutionnaire", "qui appelle");
    	Article savedArticleA = articleService.save(a);
    	
    	Article updatedArticle = articleService.saveArticleAndFournisseur(savedArticleA.getId(), savedFournisseur.getId());

		Assertions.assertEquals(savedFournisseur.getId(), updatedArticle.getFournisseur().getId());
	}
	
//	@Test
	public void testSaveArticleAndFournisseurException() {
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
    	
		Assertions.assertNull(updatedArticle.getFournisseur());
	}
}

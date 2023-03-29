package com.bigcorp.booking.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class ArticleServiceTest {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private FournisseurService fournisseurService;

	
	@Test
	public void testSaveAndFindById() {
		// Création et sauvegarde fournisseur
		Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("Fournitout");
        fournisseur.setAdresse("3 rue du Moulin");
        fournisseur.setNumero(545454);
        fournisseur.setEmail("contact@fournitout.com");
        fournisseurService.save(fournisseur);
        
        // Création et sauvegarde article
        Article article = new Article();
        article.setNom("Perceuse");
        article.setFournisseur(fournisseur);
        
        // Verif que l'id sauvegardé n'est pas null
        Article savedArticle = articleService.save(article);
        assertNotNull(savedArticle.getId());
       
	}

	@Test
	public void testDelete() {
		// Création et sauvegarde fournisseur
		Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("Fournitout");
        fournisseur.setAdresse("3 rue du Moulin");
        fournisseur.setNumero(10);
        fournisseur.setEmail("contact@fournitout.com");
        fournisseurService.save(fournisseur);
        
        // Création et sauvegarde article
        Article article = new Article();
        article.setNom("Scie à métaux");
        article.setFournisseur(fournisseur);
        Article savedArticle = articleService.save(article);
        
        // Verif que l'id sauvegardé n'est pas null
        assertNotNull(savedArticle.getId());
        Integer articleId = savedArticle.getId();
        
        // Verif que l'article n'existe plus
        articleService.delete(articleId);
        Article deletedArticle = articleService.findById(articleId);
        assertNull(deletedArticle);
	}

	@Test
	public void testFindAll() {
		// Création et sauvegarde fournisseur
		Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("Fournitout");
        fournisseur.setAdresse("3 rue du Moulin");
        fournisseur.setNumero(10);
        fournisseur.setEmail("contact@fournitout.com");
        fournisseurService.save(fournisseur);
        
     // Création et sauvegarde articles
        Article article1 = new Article();
        article1.setNom("Scie à bois");
        article1.setFournisseur(fournisseur);

        Article article2 = new Article();
        article2.setNom("Pelle");
        article2.setFournisseur(fournisseur);

        articleService.save(article1);
        articleService.save(article2);
        
        // Verif que le result set n'est pas vide
        Iterable<Article> articles = articleService.findAll();
        assertNotNull(articles);
        
        // Verif que le result set contient 2 éléments
        List<Article> articleList = (List<Article>) articles;
        assertEquals(2, articleList.size());
	}

}
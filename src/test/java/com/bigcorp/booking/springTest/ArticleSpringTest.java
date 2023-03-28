package com.bigcorp.booking.springTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Random;

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
public class ArticleSpringTest {
	
	@Autowired
	public ArticleService articleService;
	
	@Autowired
	public FournisseurService fournisseurService;
	
	@Test
    public void testSaveAndFindById() {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("COSCO");
        fournisseur.setAdresse("SHANGHAI.");
        fournisseur.setNumero_fournisseur(545454);
        fournisseur.setEmail("chinashippinglines@cosco.cn");
        fournisseurService.save(fournisseur);

        Article article = new Article();
        article.setNom("item");
        article.setFournisseur(fournisseur);

        Article savedArticle = articleService.save(article);
        assertNotNull(savedArticle.getId());

        Article foundArticle = articleService.findById(savedArticle.getId());
        assertEquals(savedArticle.getId(), foundArticle.getId());
    }

    @Test
    public void testDelete() {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("COSCO");
        fournisseur.setAdresse("SHANGHAI.");
        fournisseur.setNumero_fournisseur(12121212);
        fournisseur.setEmail("chinashippinglines@cosco.cn");
        fournisseurService.save(fournisseur);

        Article article = new Article();
        article.setNom("BigArticle");
        article.setFournisseur(fournisseur);

        Article savedArticle = articleService.save(article);
        assertNotNull(savedArticle.getId());

        Integer articleId = savedArticle.getId();

        articleService.delete(articleId);

        Article deletedArticle = articleService.findById(articleId);
        assertNull(deletedArticle);
    }

    @Test
    public void testFindAll() {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("COSCO");
        fournisseur.setAdresse("SHANGHAI.");
        fournisseur.setNumero_fournisseur(12);
        fournisseur.setEmail("chinashippinglines@cosco.cn");
        fournisseurService.save(fournisseur);

        Article article1 = new Article();
        article1.setNom("item");
        
        article1.setFournisseur(fournisseur);

        Article article2 = new Article();
        article2.setNom("item2");
      
        article2.setFournisseur(fournisseur);

        articleService.save(article1);
        articleService.save(article2);

        Iterable<Article> articles = articleService.findAll();
        assertNotNull(articles);

        List<Article> articleList = (List<Article>) articles;
        assertEquals(2, articleList.size());
    }
	
	@Test
	public void linkArticleToFournisseur() {
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNumero_fournisseur(new Random().nextInt(1000));
		fournisseur.setNom("CMA CGM");
		fournisseur.setAdresse("23 quai pablo picasso");
		fournisseur.setEmail("contact@cma-cgm.com");
		
		@SuppressWarnings("unused")
		Fournisseur savedFournisseur = fournisseurService.save(fournisseur);
		
		Article article = new Article();
		article.setNumero_article(new Random().nextInt(1000));
		article.setNom("Conteneur 20'");
		article.setDescription("petit conteneur");
		article.setEtat(Etat.INUTILISABLE);
		article.setFournisseur(fournisseur);
		
		Article savedArticle = articleService.save(article);
		Assertions.assertNotNull(savedArticle.getFournisseur());
	}
}

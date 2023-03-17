package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Etat;
import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.model.Fournisseur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Random;

public class FournisseurDaoTest {
	
	@Test
	public void testSave() {
				
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur evergreen = new Fournisseur();

		
		evergreen.setNom("Evergreen");
		evergreen.setNumero_fournisseur(1);
		evergreen.setEmail("contact@evergreen-shipping.com");
		evergreen.setAdresse("Hong Kong");
		
    	
		Fournisseur savedFournisseur = fournisseurDao.merge(evergreen);
		
		Assertions.assertNotNull(savedFournisseur.getId());
		
		Fournisseur exampleDeLaBaseDeDonnees = fournisseurDao.findById(savedFournisseur.getId());
		
		
		Assertions.assertEquals(evergreen.getNom(), exampleDeLaBaseDeDonnees.getNom());
		Assertions.assertEquals(evergreen.getAdresse(), exampleDeLaBaseDeDonnees.getAdresse());
		Assertions.assertEquals(evergreen.getEmail(), exampleDeLaBaseDeDonnees.getEmail());
		Assertions.assertEquals(evergreen.getNumero_fournisseur(), exampleDeLaBaseDeDonnees.getNumero_fournisseur());	
	}
	
	@Test
	public void test2() {
		FournisseurDao fournisseurDao = new FournisseurDao();
		
		Fournisseur evergreen = new Fournisseur();
		evergreen.setNom("Evergreen");
		evergreen.setNumero_fournisseur(1);
		evergreen.setEmail("contact@evergreen-shipping.com");
		evergreen.setAdresse("Hong Kong");
		
		Fournisseur evergreen2 = new Fournisseur();
		evergreen2.setNom("Evergreen");
		evergreen2.setNumero_fournisseur(1);
		evergreen2.setEmail("contact@evergreen-shipping.com");
		evergreen2.setAdresse("Hong Kong");
		fournisseurDao.merge(evergreen2);
		
		List<Fournisseur> fournisseurs = fournisseurDao.getByName("ever");
		Assertions.assertEquals(3, fournisseurs.size());
	}
	
	@Test
	public void testOnetoMany() {
		FournisseurDao fournisseurDao = new FournisseurDao();
		ArticleDao articleDao = new ArticleDao();

		Fournisseur evergreen = new Fournisseur();
        evergreen.setNom("Evergreen");
        evergreen.setNumero_fournisseur(new Random().nextInt());
        evergreen.setEmail("contact@evergreen-shipping.com");
        evergreen.setAdresse("Hong Kong");
        Fournisseur savedFournisseur = fournisseurDao.merge(evergreen);

        Article article = new Article();
        article.setNom("conteneur 20'");
        article.setNumero_article(new Random().nextInt());
        article.setDescription("petit conteneur");
        article.setEtat(Etat.NEUF);
        article.setFournisseur(savedFournisseur);
        
        article.setFournisseur(savedFournisseur);
        Article savedArticle = articleDao.merge(article);

        List<Fournisseur> fournisseurs = fournisseurDao.getFournisseurNomAvecArticleNom("Evergreen");
    	Assertions.assertEquals(savedFournisseur.getId(), savedArticle.getFournisseur().getId());
            
	}
	
}

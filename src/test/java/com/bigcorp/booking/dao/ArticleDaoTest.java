package com.bigcorp.booking.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Etat;
import com.bigcorp.booking.model.Fournisseur;



public class ArticleDaoTest {
	
	@Test
	public void testSave() {
		Random random = new Random();
		ArticleDao articleDao = new ArticleDao();
		
		Article conteneur40 = new Article();
		conteneur40.setNom("conteneur 40 pieds");
		conteneur40.setNumero_article(random.nextInt(10000));
		conteneur40.setDescription("un grand conteneur");
		conteneur40.setEtat(Etat.NEUF);
		
		Article conteneur20 = new Article();
		conteneur20.setNom("conteneur 20 pieds");
		conteneur20.setNumero_article(random.nextInt(10000));
		conteneur20.setDescription("un petit conteneur");
		conteneur20.setEtat(Etat.OCCASION);
		
		Article savedArticle1 = articleDao.merge(conteneur40);
		Article savedArticle2 = articleDao.merge(conteneur20);
	
		
		Assertions.assertNotNull(savedArticle1.getId());
		Assertions.assertNotNull(savedArticle2.getId());
		
		Article exampleDeLaBaseDeDonnees1 = articleDao.findById(Article.class, savedArticle1.getId());
		Article exampleDeLaBaseDeDonnees2 = articleDao.findById(Article.class, savedArticle2.getId());
		
		
		Assertions.assertEquals(conteneur40.getNom(), exampleDeLaBaseDeDonnees1.getNom());
		Assertions.assertEquals(conteneur40.getNumero_article(), exampleDeLaBaseDeDonnees1.getNumero_article());
		Assertions.assertEquals(conteneur40.getDescription(), exampleDeLaBaseDeDonnees1.getDescription());
		Assertions.assertEquals(conteneur40.getEtat(), exampleDeLaBaseDeDonnees1.getEtat());
		
		Assertions.assertEquals(conteneur20.getNom(), exampleDeLaBaseDeDonnees2.getNom());
		Assertions.assertEquals(conteneur20.getNumero_article(), exampleDeLaBaseDeDonnees2.getNumero_article());
		Assertions.assertEquals(conteneur20.getDescription(), exampleDeLaBaseDeDonnees2.getDescription());
		Assertions.assertEquals(conteneur20.getEtat(), exampleDeLaBaseDeDonnees2.getEtat());
	}
	
	
}

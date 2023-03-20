package com.bigcorp.booking.test;

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
public class FournisseurSpringTest {

		@Autowired
		public ArticleService articleService;
		
		@Autowired
		public FournisseurService fournisseurService;
		
		@Test 
		public void testSave() {
					
			Fournisseur fournisseur = new Fournisseur();
			fournisseur.setNumero_fournisseur(new Random().nextInt(1000));
			fournisseur.setNom("CMA CGM");
			fournisseur.setAdresse("23 quai pablo picasso");
			fournisseur.setEmail("contact@cma-cgm.com");
			
			Fournisseur savedFournisseur = fournisseurService.save(fournisseur);
			
			Article article = new Article();
			article.setNumero_article(new Random().nextInt(1000));
			article.setNom("Conteneur 20'");
			article.setDescription("petit conteneur");
			article.setEtat(Etat.INUTILISABLE);
			article.setFournisseur(fournisseur);
			
			Article savedArticle = articleService.save(article);
			
			Assertions.assertEquals(savedFournisseur.getNom(), fournisseurService.findByName("CMA CGM").getNom());
		}
}


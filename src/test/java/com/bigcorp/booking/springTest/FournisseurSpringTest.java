package com.bigcorp.booking.springTest;

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
public class FournisseurSpringTest {

		@Autowired
		public ArticleService articleService;
		
		@Autowired
		public FournisseurService fournisseurService;
		
		@Test
		public void testSave() {
			Fournisseur fournisseur = new Fournisseur();
			fournisseur.setNumero_fournisseur(new Random().nextInt(1000));
			fournisseur.setNom("Maersk");
			fournisseur.setAdresse("Copenhagen, Denmark");
			fournisseur.setEmail("info@maersk.com");

			Fournisseur savedFournisseur = fournisseurService.save(fournisseur);

			Assertions.assertNotNull(savedFournisseur.getId());
			Assertions.assertEquals(savedFournisseur.getNom(), "Maersk");
		}

		@Test
		public void testDelete() {
			Fournisseur testFournisseur = new Fournisseur();
			testFournisseur.setNumero_fournisseur(new Random().nextInt(1000));
			testFournisseur.setNom("CMA CGM");
			testFournisseur.setAdresse("23 quai pablo picasso");
			testFournisseur.setEmail("contact@cma-cgm.com");
			fournisseurService.save(testFournisseur);

			fournisseurService.delete(testFournisseur.getId());

			Fournisseur deletedFournisseur = fournisseurService.findById(testFournisseur.getId());

			Assertions.assertNull(deletedFournisseur);
		}

		@Test
		public void testFindById() {
			Fournisseur testFournisseur = new Fournisseur();
			testFournisseur.setNumero_fournisseur(new Random().nextInt(1000));
			testFournisseur.setNom("CMA CGM");
			testFournisseur.setAdresse("23 quai pablo picasso");
			testFournisseur.setEmail("contact@cma-cgm.com");
			fournisseurService.save(testFournisseur);

			Fournisseur foundFournisseur = fournisseurService.findById(testFournisseur.getId());

			Assertions.assertNotNull(foundFournisseur);
			Assertions.assertEquals(foundFournisseur.getNom(), "CMA CGM");
		}

		@Test
		public void testFindAll() {
			Fournisseur fournisseur = new Fournisseur();
			fournisseur.setNumero_fournisseur(new Random().nextInt(1000));
			fournisseur.setNom("Maersk");
			fournisseur.setAdresse("Copenhagen, Denmark");
			fournisseur.setEmail("info@maersk.com");

			Fournisseur savedFournisseur = fournisseurService.save(fournisseur);
			
			List<Fournisseur> allFournisseurs = (List<Fournisseur>) fournisseurService.findAll();

			Assertions.assertFalse(allFournisseurs.isEmpty());
		}

		@Test
		public void testFindByName() {
		    Fournisseur fournisseur = new Fournisseur();
		    fournisseur.setNumero_fournisseur(new Random().nextInt(1000));
		    fournisseur.setNom("Maersk");
		    fournisseur.setAdresse("Copenhagen, Denmark");
		    fournisseur.setEmail("info@maersk.com");

		    Fournisseur savedFournisseur = fournisseurService.save(fournisseur);

		    List<Fournisseur> foundFournisseurs = fournisseurService.findByName("Maersk");

		    Assertions.assertFalse(foundFournisseurs.isEmpty());
		    Assertions.assertEquals(foundFournisseurs.get(0).getAdresse(), "Copenhagen, Denmark");
		}

//		@Test
//		public void testFindByIdWithArticles() {
//			Fournisseur testFournisseur = new Fournisseur();
//			testFournisseur.setNumero_fournisseur(new Random().nextInt(1000));
//			testFournisseur.setNom("CMA CGM");
//			testFournisseur.setAdresse("23 quai pablo picasso");
//			testFournisseur.setEmail("contact@cma-cgm.com");
//			fournisseurService.save(testFournisseur);
//			
//			Fournisseur foundFournisseur = fournisseurService.findByIdWithArticles(testFournisseur.getId());
//
//			Assertions.assertNotNull(foundFournisseur);
//			Assertions.assertFalse(foundFournisseur.getArticles().isEmpty());
//		}

	}

package com.bigcorp.booking.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.spring.SpringConfiguration;


@SpringJUnitConfig(SpringConfiguration.class)
public class FournisseurServiceTest {
	
	@Autowired
	private FournisseurService fournisseurService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurServiceTest.class);

	@Test
	public void testSaveFournisseur() {
		Fournisseur f = new Fournisseur(30, "sony", "sony@sony.com", "adresse fournisseur");
		Fournisseur saved = fournisseurService.save(f);

		Assertions.assertNotNull(saved.getId());
		LOGGER.info("testSaveFournisseur : " + saved.getId() + " - " + saved.getNom());
	}

	@Test
	public void testFindById() {
		Fournisseur f = new Fournisseur(31, "aliexpress", "ali@express.com", "adresse fournisseur");
		Fournisseur saved = fournisseurService.save(f);

		Fournisseur fournisseurFromDb = fournisseurService.findById(saved.getId());
		Assertions.assertNotNull(fournisseurFromDb.getId());
		LOGGER.info("testFindById : " + fournisseurFromDb.getId() + " - " + fournisseurFromDb.getNom());
	}

	@Test
	public void testFindAll() {
		Fournisseur f1 = new Fournisseur(32, "spring", "spring@java.com", "adresse fournisseur");
		Fournisseur saved1 = fournisseurService.save(f1);
		Fournisseur f2 = new Fournisseur(33, "H2", "h2@db.com", "adresse fournisseur");
		Fournisseur saved2 = fournisseurService.save(f2);

		List<Fournisseur> listFournisseurs = fournisseurService.findAll();
		LOGGER.info("testFindAll : récupération de la liste de fournisseurs");
		Assertions.assertEquals(2, listFournisseurs.size());
	}

	@Test
	public void testDeleteById() {
		Fournisseur f = new Fournisseur(34, "trashFournisseur", "trash@bin.com", "adresse fournisseur");
		Fournisseur saved = fournisseurService.save(f);

		LOGGER.info("testDeleteById : suppression du fournisseur " + saved.getId());
		fournisseurService.deleteById(saved.getId());
		Fournisseur deleted = fournisseurService.findById(saved.getId());
		Assertions.assertNull(deleted);
	}
}

package com.bigcorp.booking.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class FournisseurServiceTest {

	@Autowired
	private FournisseurService fournisseurService;
	
	@Test
	public void saveFournisseurTest() {
		Fournisseur fournisseur = new Fournisseur("Fournisseur d'écrans", 46, "fournisseur@ecrans.com", "EcransStreet EcranVille");
		fournisseurService.save(fournisseur);
		
		Assertions.assertNotNull(fournisseur);
	}
	
	@Test
	public void testFindByName() {
		Fournisseur fournisSecond = new Fournisseur("Fournisseur de cartes graphiques", 816, "fournisseur@cartesgraphiques.com", "CartesGraphiquesStreet Graphiqueville");
		Fournisseur graphique = fournisseurService.save(fournisSecond);
		Assertions.assertNotNull(graphique);
		fournisseurService.findByNom("Fournisseur de cartes graphiques");
	}
	
	@Test
	public void testFindById() {
		Fournisseur fournisTroisieme = new Fournisseur("Fournisseurs micros", 499, "fournisseur@micros.com", "microsStreet microsCity");
		fournisseurService.save(fournisTroisieme);
		Fournisseur fourni = fournisseurService.findById(3);
		Assertions.assertEquals(fourni.getNom(), "Fournisseurs micros");
	}
	
	@Test
	public void delete() {		
		Fournisseur fourniSuppr = new Fournisseur("Fournisseur de rêves", 862, "fournisseur@reves.com", "revesStreet revesCity");
		Fournisseur dreams = fournisseurService.save(fourniSuppr);
		Assertions.assertNotNull(dreams);
		fournisseurService.delete(1);
		Assertions.assertNull(fournisseurService.findById(1));
	}
}

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
	public void testSaveGet() {
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom("Jean-Spring");
		Fournisseur fournisseurSauvegarde = this.fournisseurService.save(fournisseur);
		
		Assertions.assertNotNull(fournisseurSauvegarde);
		Assertions.assertNotNull(fournisseurSauvegarde.getId());
		
		Fournisseur fournisseurRecupere = this.fournisseurService.findById(fournisseurSauvegarde.getId());
		Assertions.assertNotNull(fournisseurRecupere);
	}

	@Test
	public void testDelete() {
		Fournisseur fournisseur = new Fournisseur();
		Fournisseur fournisseurSauvegarde = this.fournisseurService.save(fournisseur);
		this.fournisseurService.delete(fournisseurSauvegarde.getId());
		
		Fournisseur fournisseurRecupere = this.fournisseurService.findById(fournisseurSauvegarde.getId());
		Assertions.assertNull(fournisseurRecupere);
	}

}

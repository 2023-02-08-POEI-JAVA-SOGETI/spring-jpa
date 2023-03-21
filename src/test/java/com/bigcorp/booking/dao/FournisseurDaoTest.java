package com.bigcorp.booking.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.FournisseurService;
import com.bigcorp.booking.spring.SpringConfiguration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SpringJUnitConfig(SpringConfiguration.class)
public class FournisseurDaoTest {
	
	@Autowired
	private FournisseurService fournisseurService;
		
		@Test
		@DisplayName("Testing if service correctly saves a fournisseur")
		public void testSave() {
			Fournisseur fournisseur = new Fournisseur();
			fournisseurService.save(fournisseur);
			Assertions.assertNotNull(fournisseur);
			Assertions.assertNotNull(fournisseur.getId());
				
		}
}
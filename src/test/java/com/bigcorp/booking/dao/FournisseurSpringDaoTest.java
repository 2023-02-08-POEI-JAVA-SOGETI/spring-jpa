package com.bigcorp.booking.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.service.ClientService;
import com.bigcorp.booking.service.FournisseurService;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class FournisseurSpringDaoTest {
	
	@Autowired
	private FournisseurService fournisseurService;
	
	@Test
	@DisplayName("Testing if service correctly saves a Fournisseur")
	void testSave() {
		Fournisseur fournisseur = new Fournisseur(456, "David Production", "contact@davidproduction.co.jp", "Tokyo, Japan");

		fournisseurService.save(fournisseur);

		Assertions.assertNotNull(fournisseur);
		Assertions.assertNotNull(fournisseur.getId());
	}
	
	@Test
	@DisplayName("Testing if service correctly saves a Fournisseur with Client list")
	void testSaveWithFetchedClients() {		
		Fournisseur fournisseur = new Fournisseur(456, "David Production", "contact@davidproduction.co.jp", "Tokyo, Japan");
		
		
		fournisseurService.save(fournisseur);

		Assertions.assertNotNull(fournisseur);
		Assertions.assertNotNull(fournisseur.getId());
	}
}

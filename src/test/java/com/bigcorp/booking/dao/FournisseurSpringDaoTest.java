package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.service.FournisseurService;
import com.bigcorp.booking.spring.SpringConfiguration;

import tp_spring_jpa_pablo.model.Fournisseur;

@SpringJUnitConfig(SpringConfiguration.class)
public class FournisseurSpringDaoTest {

	@Autowired
	private FournisseurService fournisseurService;

	@Test
	public void testSave() {
		Fournisseur fournisseur = new Fournisseur();
		fournisseurService.save(fournisseur);
		Assertions.assertNotNull(fournisseur);
		Assertions.assertNotNull(fournisseur.getId());
	}
	  

}

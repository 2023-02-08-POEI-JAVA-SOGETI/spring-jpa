package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.FournisseurService;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class FournisseurSpringDaoTest {

	@Autowired
	private FournisseurService fournisseurService;

	@Test

	public void testsauvegarde() {
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom("Jaguar");
		
		fournisseur.setNumero(1234);
		//fournisseurService.sauvegarde(fournisseur);
		Assertions.assertNotNull(fournisseur.getId());
	}

	@Test
	public void testfindByNom() {
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom("Jeep");
		
		fournisseur.setNumero(1235);
		//fournisseurService.sauvegarde(fournisseur);
		
		List<Fournisseur> articleDelaBase = fournisseurService.findByNom(fournisseur.getNom());
		
		Assertions.assertFalse(articleDelaBase.isEmpty());
	}
	
	

	@Test
	public void testget() {
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom("range rover");
		
		fournisseur.setNumero(1237);
		//fournisseurService.sauvegarde(fournisseur);
		
		
		Fournisseur fournisseurDeLaBase = fournisseurService.get(fournisseur.getId());
		Assertions.assertNotNull(fournisseurDeLaBase);
	}

	@Test
	public void testsupprimmer() {
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom("Chevrolet");
		
		fournisseur.setNumero(1239);
		//fournisseurService.sauvegarde(fournisseur);
		
		Assertions.assertNotNull(fournisseur);
		fournisseurService.supprimer(fournisseur.getId());
		Fournisseur fournisseurDeLaBase = fournisseurService.get(fournisseur.getId());
		Assertions.assertNull(fournisseurDeLaBase);
		
	}

}

package com.bigcorp.booking.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Fournisseur;
import com.bigcorp.booking.service.exception.FournisseurException;
import com.bigcorp.booking.spring.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class FournisseurServiceTest {
	
	@Autowired
	private FournisseurService fournisseurService;

	@Test
	public void testSaveGet() throws FournisseurException {
		// Je prépare mes données
		// J'enregistre en base un nouveau fournisseur
		// je récupère son id
		Fournisseur fournisseur = new Fournisseur();
		Fournisseur fournisseurSauvegarde = this.fournisseurService.save(fournisseur);
		
		//Je lance une méthode à tester
		// je récupère en base le fournisseur qui a l'id que j'ai récupéré
		Fournisseur fournisseurLu = this.fournisseurService.findById(fournisseurSauvegarde.getId());
		
		//Je m'assure que ce que j'ai reçu correspond à ce que j'attends
		// Je m'assure que ce fournisseur n'est pas null
		Assertions.assertNotNull(fournisseurLu);
	}

	@Test
	public void testDelete() throws FournisseurException {
		Fournisseur fournisseur = new Fournisseur();
		Fournisseur fournisseurSauvegarde = this.fournisseurService.save(fournisseur);
		this.fournisseurService.delete(fournisseurSauvegarde.getId());
		
		Fournisseur fournisseurRecupere = this.fournisseurService.findById(fournisseurSauvegarde.getId());
		Assertions.assertNull(fournisseurRecupere);
	}

	@Test
	public void testUpdate() throws FournisseurException {
		// Je prépare mes données
		// J'enregistre en base un nouveau fournisseur
		// je récupère son id
		Fournisseur fournisseur = new Fournisseur();
		Fournisseur fournisseurSauvegarde = this.fournisseurService.save(fournisseur);
		String nom = "Jean";
		fournisseurSauvegarde.setNom(nom);
		String email = "jean@dupont.fr";
		fournisseurSauvegarde.setEmail(email);
		
		//Act
		fournisseurSauvegarde = this.fournisseurService.save(fournisseurSauvegarde);
		
		//Je lance une méthode à tester
		// je récupère en base le fournisseur qui a l'id que j'ai récupéré
		Fournisseur fournisseurLu = this.fournisseurService.findById(fournisseurSauvegarde.getId());
		
		//Je m'assure que ce que j'ai reçu correspond à ce que j'attends
		// Je m'assure que ce fournisseur n'est pas null
		Assertions.assertNotNull(fournisseurLu);
		Assertions.assertEquals(nom, fournisseurLu.getNom());
		Assertions.assertEquals(email, fournisseurLu.getEmail());
	}

}

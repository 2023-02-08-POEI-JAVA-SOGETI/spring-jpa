package com.bigcorp.booking.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDaoTest {
//
//	@Test
//	public void testSave() {
//		String nom = "Foxconn Technology";
//		FournisseurDao fournisseurDao = new FournisseurDao();
//		Fournisseur fournisseur = new Fournisseur();
//
//		fournisseur.setNom(nom);
//
//		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
//
//		Assertions.assertNotNull(savedFournisseur.getId());
//
//		Fournisseur fournisseurRecord = fournisseurDao.findById(savedFournisseur.getId());
//
//		Assertions.assertEquals(nom, fournisseurRecord.getNom());
//	}
//
//	@Test
//	public void testSaveTwo() {
//
//		String nom = "Inditex";
//		FournisseurDao fournisseurDao = new FournisseurDao();
//		Fournisseur fournisseur = new Fournisseur();
//
//		fournisseur.setNom(nom);
//		fournisseur.setEmail("contact@inditex.com");
//
//		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);
//
//		Assertions.assertNotNull(savedFournisseur.getId());
//	}
//
//	@Test
//	public void testGetByName() {
//		String name = "Panzani";
//
//		FournisseurDao fournisseurDao = new FournisseurDao();
//		Fournisseur fournisseur = new Fournisseur();
//
//		fournisseur.setNom(name);
//		fournisseurDao.merge(fournisseur);
//
//		Fournisseur fournisseurDeux = new Fournisseur();
//
//		fournisseurDeux.setNom("Panzanitrate");
//		fournisseurDao.merge(fournisseurDeux);
//
//		List<Fournisseur> fournisseurs = fournisseurDao.findByName("panzani");
//
//		Assertions.assertEquals(2, fournisseurs.size());
//	}

	@Test
	public void testFetchByNameWithArticles() {
		String articleName = "Rechargeable battery";
		String fournisseurName = "Duracell";
		ArticleDao articleDao = new ArticleDao();
		FournisseurDao fournisseurDao =  new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();
		
		fournisseur.setNom(fournisseurName);
		Fournisseur savedFournisseur = fournisseurDao.merge(fournisseur);

		Article article = new Article();
		article.setNom(articleName);
		article.setDescription("New rechargeable batteries by Duracell");

		article.associateWith(savedFournisseur);
		articleDao.merge(article);
		
		List<Fournisseur> fournisseurs = fournisseurDao.fetchByNameWithArticles(fournisseurName);
		
		for(Fournisseur fournisseurRecord: fournisseurs) {
			Assertions.assertEquals(fournisseurName, fournisseurRecord
					.getArticles()
					.stream()
					.map(item -> item.getFournisseur().getNom())
					.collect(Collectors.joining())
			);
		}
	}
}

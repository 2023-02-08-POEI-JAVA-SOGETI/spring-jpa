package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDaoTest {

	@Test
	public void testSave() {

		FournisseurDao dao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();
		String nomFournisseur = "Fournisseur1";
		fournisseur.setNom(nomFournisseur);
		// Faire de même pour les autres attributs...
		Fournisseur fournisseurSauvegarde = dao.merge(fournisseur);

		Assertions.assertNotNull(fournisseurSauvegarde.getId());

		Fournisseur fournisseurLu = dao.findById(Fournisseur.class, fournisseurSauvegarde.getId());

		Assertions.assertEquals(nomFournisseur, fournisseurLu.getNom());
		// Faire de même pour les autres attributs...

	}

	public void testPersist() {
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();
		String nomFournisseur = "Fournisseur1";

		fournisseur.setNom(nomFournisseur);
		fournisseurDao.persist(fournisseur);

		Assertions.assertNotNull(fournisseur.getId());
	}

	@Test
	public void testGetParNomAvecFournisseur() {
		FournisseurDao fournisseurDao = new FournisseurDao();
		Fournisseur fournisseur = new Fournisseur();
		String nomFournisseur = "Un superFournisseur";
		fournisseur.setNom(nomFournisseur);
		Fournisseur fournisseurSauvegarde = fournisseurDao.merge(fournisseur);

		// Sauvegarde article
		ArticleDao articleDao = new ArticleDao();
		Article nouvelArticle = new Article();
		String nomArticle = "Quel bien bel article";
		nouvelArticle.setNom(nomArticle);

		// Rattachement
		nouvelArticle.associe(fournisseurSauvegarde);

		//Sauvegarde
		articleDao.merge(nouvelArticle);

		List<Fournisseur> fournisseurs = fournisseurDao.getParNomAvecArticle(nomFournisseur);
		for (Fournisseur fournisseurLu : fournisseurs) {
			Assertions.assertEquals(1, fournisseurLu.getArticles().size());
		}

	}

}
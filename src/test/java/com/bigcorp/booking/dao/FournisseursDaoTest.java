package com.bigcorp.booking.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Articles;
import com.bigcorp.booking.model.Fournisseurs;

public class FournisseursDaoTest {

	@Test
	public void testSave() {

		FournisseursDao dao = new FournisseursDao();
		Fournisseurs fournisseur = new Fournisseurs();
		String nomFournisseur = "Fournisseur1";
		fournisseur.setNom(nomFournisseur);
		// Faire de même pour les autres attributs...
		Fournisseurs fournisseurSauvegarde = dao.merge(fournisseur);

		Assertions.assertNotNull(fournisseurSauvegarde.getId());

		Fournisseurs fournisseurLu = dao.findById(Fournisseurs.class, fournisseurSauvegarde.getId());

		Assertions.assertEquals(nomFournisseur, fournisseurLu.getNom());
		// Faire de même pour les autres attributs...

	}

	public void testPersist() {
		FournisseursDao fournisseurDao = new FournisseursDao();
		Fournisseurs fournisseur = new Fournisseurs();
		String nomFournisseur = "Fournisseur1";

		fournisseur.setNom(nomFournisseur);
		fournisseurDao.persist(fournisseur);

		Assertions.assertNotNull(fournisseur.getId());
	}

	@Test
	public void testGetParNomAvecFournisseur() {
		FournisseursDao fournisseurDao = new FournisseursDao();
		Fournisseurs fournisseur = new Fournisseurs();
		String nomFournisseur = "Un superFournisseur";
		fournisseur.setNom(nomFournisseur);
		Fournisseurs fournisseurSauvegarde = fournisseurDao.merge(fournisseur);

		// Sauvegarde article
		ArticlesDao articleDao = new ArticlesDao();
		Articles nouvelArticle = new Articles();
		String nomArticle = "Quel bien bel article";
		nouvelArticle.setNom(nomArticle);

		// Rattachement
		nouvelArticle.associe(fournisseurSauvegarde);

		//Sauvegarde
		articleDao.merge(nouvelArticle);

		List<Fournisseurs> fournisseurs = fournisseurDao.getParNomAvecArticle(nomFournisseur);
		for (Fournisseurs fournisseurLu : fournisseurs) {
			Assertions.assertEquals(1, fournisseurLu.getArticles().size());
		}

	}

}
package com.bigcorp.booking.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.booking.model.Utilisateur;

public class UtilisateurDaoTest extends AbstractDao<Utilisateur> {

	@Test
	public void testSave() {
		UtilisateurDao utilisateurDao = new UtilisateurDao();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("NGOM");
		Utilisateur savedUtilisateur = utilisateurDao.merge(utilisateur);
		Assertions.assertNotNull(savedUtilisateur.getId());

	}
}
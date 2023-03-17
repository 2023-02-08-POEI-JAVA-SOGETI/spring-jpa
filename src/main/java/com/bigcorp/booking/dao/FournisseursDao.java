package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bigcorp.booking.model.Fournisseurs;

public class FournisseursDao extends AbstractDao<Fournisseurs> {

	public List<Fournisseurs> getParNomAvecArticle(String nomFournisseur) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseurs> fournisseur = em.createQuery("from Fournisseur fournisseur "
				+ " left outer join fetch fournisseur.articles "
				+ " where fournisseurs.nom = :nomFournisseur ", Fournisseurs.class)
				.setParameter("nomFournisseur", nomFournisseur).getResultList();
		em.close();
		return fournisseur;
	}

}
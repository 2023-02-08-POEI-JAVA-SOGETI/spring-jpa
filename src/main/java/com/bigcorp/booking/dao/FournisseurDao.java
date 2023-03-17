package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDao extends AbstractDao<Fournisseur> {

	public List<Fournisseur> getParNomAvecArticle(String nomFournisseur) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> fournisseurs = em.createQuery("from Fournisseur fournisseur "
				+ " left outer join fetch fournisseur.articles "
				+ " where fournisseur.nom = :nomFournisseur ", Fournisseur.class)
				.setParameter("nomFournisseur", nomFournisseur).getResultList();
		em.close();
		return fournisseurs;
	}

}

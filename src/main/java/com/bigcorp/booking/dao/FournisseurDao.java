package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDao extends AbstractDao<Fournisseur> {

	@Override
	public Fournisseur merge(Fournisseur fournisseur) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		Fournisseur merged = em.merge(fournisseur);

		transaction.commit();
		em.close();

		return merged;
	}

	public Fournisseur findById(Integer id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();

		return em.find(Fournisseur.class, id);
	}

	public List<Fournisseur> findByName(String name) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> matchingFournisseurs = em
				.createQuery("from Fournisseur where lower(nom) like :nomFournisseur", Fournisseur.class)
				.setParameter("nomFournisseur", "%" + name.toLowerCase() + "%").getResultList();

		em.close();

		return matchingFournisseurs;
	}

	public List<Fournisseur> findByStrictName(String name) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> matchingFournisseurs = em
				.createQuery("from Fournisseur where nom = :nomFournisseur", Fournisseur.class)
				.setParameter("nomFournisseur", name).getResultList();

		em.close();

		return matchingFournisseurs;
	}

	public List<Fournisseur> fetchByNameWithArticles(String name) {

		if (name == null || name == "")
			return null;

		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> fournisseurs = em
				.createQuery("FROM Fournisseur fournisseur" + " LEFT OUTER JOIN FETCH fournisseur.articles"
						+ " WHERE fournisseur.nom = :nomFournisseur ", Fournisseur.class)
				.setParameter("nomFournisseur", name).getResultList();
		
		em.close();

		return fournisseurs;
	}
	
	public List<Fournisseur> fetchByNameWithClients(String name) {

		if (name == null || name == "")
			return null;

		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> fournisseurs = em
				.createQuery("FROM Fournisseur fournisseur" + " LEFT OUTER JOIN FETCH fournisseur.clients"
						+ " WHERE fournisseur.nom = :nomFournisseur ", Fournisseur.class)
				.setParameter("nomFournisseur", name).getResultList();
		
		em.close();

		return fournisseurs;
	}


	public void remove(Integer id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		em.createQuery("DELETE FROM Fournisseur p WHERE p.id = :id", Fournisseur.class).executeUpdate();
		transaction.commit();
		em.close();
	}
}

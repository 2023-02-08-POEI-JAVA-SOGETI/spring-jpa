package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDao {
	
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
	
	public List<Fournisseur> getByName(String nomFournisseur){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> fournisseur = em.createQuery("FROM Fournisseur WHERE UPPER(nom) LIKE UPPER(:nomFournisseur)", Fournisseur.class)
										.setParameter("nomFournisseur", "%" + nomFournisseur.toUpperCase() + "%").getResultList();
		em.close();
		return fournisseur;
	}
	
	public List<Fournisseur> getFournisseurNomAvecArticleNom(String nomFournisseur){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> fournisseurs 
			= em.createQuery("from Fournisseur fournisseur "
					+ " left outer join fetch fournisseur.articles "
					+ " where fournisseur.nom = :nomFournisseur ", Fournisseur.class)
				.setParameter("nomFournisseur", nomFournisseur).getResultList();
		em.close();
		return fournisseurs;
	}
}

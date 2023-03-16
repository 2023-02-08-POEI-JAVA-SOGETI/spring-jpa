package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDao extends AbstractDao<Fournisseur> {

	public List<Fournisseur> getByName(String nomFournisseur) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> listFournisseurWithName = em
				.createQuery("from Fournisseur where nom = :nomFournisseur", Fournisseur.class)
				.setParameter("nomFournisseur", nomFournisseur).getResultList();
		em.close();
		return listFournisseurWithName;
	}
	
	public List<Fournisseur> getByPartOfName(String nomFournisseur) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> listFournWithPartOfName = em
				.createQuery("from Fournisseur where nom like :nomFournisseur", Fournisseur.class)
				.setParameter("nomFournisseur", "%" + nomFournisseur + "%").getResultList();
		em.close();
		return listFournWithPartOfName;
	}
	
	public List<Fournisseur> getByPartOfNameNotCaseSensitive(String nomFournisseur) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> listFournWithPartOfNameNotCaseSensitive = em
				.createQuery("from Fournisseur where upper(nom) like :nomFournisseur", Fournisseur.class)
				.setParameter("nomFournisseur", "%" + nomFournisseur.toUpperCase() + "%").getResultList();
		em.close();
		return listFournWithPartOfNameNotCaseSensitive;
	}
	
	public List<Fournisseur> getByNameWithArticles(String nomFournisseur){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List <Fournisseur> fournisseurs = em.createQuery("from Fournisseur fourni " 
											+ "left outer join fetch fourni.articles "
											+ "where fourni.nom = :nomFournisseur", Fournisseur.class)
											.setParameter("nomFournisseur", nomFournisseur)
											.getResultList();
		em.close();
		return fournisseurs;
	}
}

package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Fournisseur;

public class FournisseurDaoEnAbstract extends AbstractDao<Fournisseur> {

	public Fournisseur merge(Fournisseur fournisseur) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Fournisseur merged = em.merge(fournisseur);
		transaction.commit();
		em.close();
		return merged;
	}

	public Fournisseur findById(int id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		return em.find(Fournisseur.class, id);
	}
	
	/**
	 * Récupère tous les clients dont le nom est passé en 
	 * paramètre.
	 * @param nomFournisseur
	 * @return une liste, not null
	 */
	public List<Fournisseur> getParNom(String nomFournisseur){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Fournisseur> laListeDesFournisseursAvecLeBonNom 
			= em.createQuery("from Fournisseur where nom = :nomFournisseur", Fournisseur.class)
			.setParameter("nomFournisseur", nomFournisseur).getResultList();
		em.close();
		return laListeDesFournisseursAvecLeBonNom;
	}
	
	public List<Fournisseur> getParNomAvecArticleles(String nomFournisseur){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		//Va envoyer une requête comme 
		//'SELECT ARTICLE.*, FOURNISSEUR.* , DEPARTEMENT.*
		// FROM ARTICLE 
		// LEFT OUTER JOIN FOURNISSEUR ON ARTICLE.FOURNISSEUR_ID = FOURNISSEUR.ID
		// WHERE ARTICLE.NOM = ' + nomArticle
		List<Fournisseur> fournisseurs
			= em.createQuery("from Fournisseur fournisseur "
					+ " left outer join fetch fournisseur.articles "
					+ " where fournisseur.nom = :nomFournisseur ", Fournisseur.class)
				.setParameter("nomFournisseur", nomFournisseur).getResultList();
		em.close();
		return fournisseurs;
	}
}
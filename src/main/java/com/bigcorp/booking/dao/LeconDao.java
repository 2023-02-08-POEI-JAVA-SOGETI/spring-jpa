package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bigcorp.booking.model.Lecon;

public class LeconDao extends AbstractDao<Lecon>{
	
	public List<Lecon> getParNomAvecExamples(String nomLecon){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		//Va envoyer une requête comme 
		//'SELECT ARTICLE.*, FOURNISSEUR.* , DEPARTEMENT.*
		// FROM ARTICLE 
		// LEFT OUTER JOIN FOURNISSEUR ON ARTICLE.FOURNISSEUR_ID = FOURNISSEUR.ID
		// WHERE ARTICLE.NOM = ' + nomArticle
		List<Lecon> lecons 
			= em.createQuery("from Lecon lecon "
					+ " left outer join fetch lecon.examples "
					+ " where lecon.nom = :nomLecon ", Lecon.class)
				.setParameter("nomLecon", nomLecon).getResultList();
		em.close();
		return lecons;
	}

}

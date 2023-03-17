package com.bigcorp.booking.dao;


import java.util.List;

import javax.persistence.EntityManager;

import com.bigcorp.booking.model.Articles;



/*La classe ArticlesDao étend la classe abstraite AbstractDao en utilisant le type générique Articles. 
 * càd ArticlesDao hérite des méthodes de AbstractDao et peut les utiliser pour accéder à la BDD pour le type Articles.
 */

public class ArticlesDao extends AbstractDao<Articles> {
	public List<Articles> getParNomAvecFournisseur(String nomArticle){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		//Va envoyer une requête comme 
		//'SELECT ARTICLE.*, FOURNISSEUR.* , DEPARTEMENT.*
		// FROM ARTICLE 
		// LEFT OUTER JOIN FOURNISSEUR ON ARTICLE.FOURNISSEUR_ID = FOURNISSEUR.ID
		// WHERE ARTICLE.NOM = ' + nomArticle
		List<Articles> articles 
			= em.createQuery("from Article article "
					+ " left outer join fetch article.fournisseur "
					+ " where article.nom = :nomArticle ", Articles.class)
				.setParameter("nomArticle", nomArticle).getResultList();
		em.close();
		return articles;
	}
}
	
	 
	


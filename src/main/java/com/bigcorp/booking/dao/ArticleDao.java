package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bigcorp.booking.model.Article;

public class ArticleDao extends AbstractDao<Article>{

	public List<Article> getParNomAvecFournisseur(String nomArticle){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		//Va envoyer une requête comme 
		//'SELECT ARTICLE.*, FOURNISSEUR.* , DEPARTEMENT.*
		// FROM ARTICLE 
		// LEFT OUTER JOIN FOURNISSEUR ON ARTICLE.FOURNISSEUR_ID = FOURNISSEUR.ID
		// WHERE ARTICLE.NOM = ' + nomArticle
		List<Article> articles 
			= em.createQuery("from Article article "
					+ " left outer join fetch article.fournisseur "
					+ " where article.nom = :nomArticle ", Article.class)
				.setParameter("nomArticle", nomArticle).getResultList();
		em.close();
		return articles;
	}
	
}
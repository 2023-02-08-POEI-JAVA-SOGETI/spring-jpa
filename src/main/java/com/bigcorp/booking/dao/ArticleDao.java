package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bigcorp.booking.model.Article;


public class ArticleDao extends AbstractDao<Article> {

	public List<Article> getParNom(String nomArticle){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Article> laListeDesArticlesAvecLeBonNom 
			= em.createQuery("from Article where upper (nom) like upper (:nomArticle)", Article.class)
			.setParameter("nomArticle", nomArticle).getResultList();
		em.close();
		return laListeDesArticlesAvecLeBonNom;
	}
	
	

}

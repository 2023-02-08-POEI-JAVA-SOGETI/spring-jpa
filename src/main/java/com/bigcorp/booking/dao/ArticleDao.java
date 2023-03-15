package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bigcorp.booking.model.Article;

public class ArticleDao extends AbstractDao<Article> {
	public List<Article> getParNom(String nomArticle) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Article> listArticleWithName = em
				.createQuery("from Article where nom = :nomArticle", Article.class)
				.setParameter("nomArticle", nomArticle).getResultList();
		em.close();
		return listArticleWithName;

	}
}

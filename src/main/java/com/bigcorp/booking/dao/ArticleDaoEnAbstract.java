package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Article;

public class ArticleDaoEnAbstract extends AbstractDao<Article> {

	public Article merge(Article article) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Article merged = em.merge(article);
		transaction.commit();
		em.close();
		return merged;
	}

	public Article findById(int id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		return em.find(Article.class, id);
	}
	
}
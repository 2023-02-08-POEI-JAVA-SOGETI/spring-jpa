package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bigcorp.booking.model.Article;

public class ArticleDao extends AbstractDao<Article> {
	
	@Override
	public Article merge(Article article) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		Article merged = em.merge(article);

		transaction.commit();
		em.close();

		return merged;
	}
	
	public Article findById(Integer id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();

		return em.find(Article.class, id);
	}
	
	public void remove(Integer id) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		em.createQuery("DELETE FROM Article p WHERE p.id = :id", Article.class).executeUpdate();
		transaction.commit();
		em.close();
	}
}

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
	
	public List<Article> getByNameWithFournisseur(String nomArticle){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Article> articles =
				em.createQuery("from Article art "
						+ "left outer join fetch art.fournisseur "
						+ "where art.nom = :nomArticle", Article.class)
					.setParameter("nomArticle", nomArticle).getResultList();
		em.close();
		return articles;
	}
}

package com.bigcorp.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bigcorp.booking.model.ArticleTest;

public class ArticleTestDao extends AbstractDao<ArticleTest> {

	public List<ArticleTest> getParNomAvecArticle(String nomArticleTest) {
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<ArticleTest> articlestest = em.createQuery("from ArticleTest articleTest "
				+ " left outer join fetch articleTest.articles "
			/*	+ " where fournisseur.nom = :nomFournisseur " - Commit pour modification à venir*/
				, ArticleTest.class)
				.setParameter("nomArticleTest", nomArticleTest).getResultList();
		em.close();
		return articlestest;
	}

}

package com.bigcorp.booking.dao;

import java.util.List;

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
	
	public List<Article> getParNom(String nomArticle){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Article> laListeDesArticlesAvecLeBonNom 
			= em.createQuery("from Article where nom = :nomArticle", Article.class)
			.setParameter("nomArticle", nomArticle).getResultList();
		em.close();
		return laListeDesArticlesAvecLeBonNom;
	}
	
	public List<Article> getParSousChaineNom(String sousChaine){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
	    List<Article> laListeDesArticlesAvecLeBonNom 
	        = em.createQuery("from Article where nom like :sousChaine", Article.class)
	        .setParameter("sousChaine", "%" + sousChaine + "%").getResultList();
	    em.close();
	    return laListeDesArticlesAvecLeBonNom;
	}
	
	public List<Article> getParSousChaineNomInsensibleCasse(String sousChaine){
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
	    List<Article> laListeDesArticlesAvecLeBonNom 
	        = em.createQuery("from Article where lower(nom) LIKE :sousChaine", Article.class)
	        .setParameter("sousChaine", "%" + sousChaine.toLowerCase() + "%").getResultList();
	    em.close();
	    return laListeDesArticlesAvecLeBonNom;
	}
	
}
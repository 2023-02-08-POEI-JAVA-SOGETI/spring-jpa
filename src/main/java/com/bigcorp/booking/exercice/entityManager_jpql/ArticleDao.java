package com.bigcorp.booking.exercice.entityManager_jpql;

import java.util.List;

import javax.persistence.EntityManager;

import com.bigcorp.booking.dao.PersistenceSingleton;
import com.bigcorp.booking.exercice.model.many_to_one.Article;


public class ArticleDao extends AbstractDaoClass<Article>{
	

	
	/*
	 *  METHODES REQUETES JPQL avec la méthode .createQuery
	 *  
	 *  Va s'ajouter à la liste des méthode de la classe AbstractDaoClass
	 *  
	 *  ATTENTION : Le NOM de la classe ARTICLE commence par "A" MAJUSCULE meme si
	 *  en BDD c'est un "a" minuscule
	 */
	
	public List<Article> findByName(String nomArticle)
	{
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Article> listArticleByName = 
				em.createQuery("from Article WHERE nom= :nomArticle", Article.class )
				.setParameter("nomArticle", nomArticle).getResultList();
		
		em.close();
		
		return listArticleByName;
		
	}
	
	
	
	public List<Article> findByNameStartWith(String sousChaine)
	{
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Article> listArticleByName = 
				em.createQuery("from Article WHERE lower(nom) LIKE :sousChaine", Article.class )
				.setParameter("sousChaine", sousChaine.toLowerCase()+"%").getResultList();
		
		em.close();
		
		return listArticleByName;
		
	}
	
	
	/*
	 * REQUETE JPQL DE JOINTURE
	 * 
	 * A faire si le modele MAITRE à un attribut Esclave qui est en 
	 * 
	 * FETCH.LAZY
	 * 
	 */
	
	
	public List<Article> findByNameWithJoiningQuery(String nomArticle)
	{
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Article> listArticleByName = 
				
				/* Equivalent en SQL : 
				 * SELECT article.*, founisseur.*
				 * FROM article art
				 * LEFT JOIN fournisseur f
				 * ON art.fournisseur_id = f.id
				 * WHERE art.nom = :nomArticle
				 */
				
				em.createQuery("from Article art "
						+ " left outer join fetch art.fournisseur "
						+ " WHERE art.nom= :nomArticle", Article.class )
				.setParameter("nomArticle", nomArticle)
				.getResultList();
				
		
		em.close();
		
		return listArticleByName;
		
	}
	
	
	public List<Article> findByIdWithJoiningQuery(Integer id)
	{
		EntityManager em = PersistenceSingleton.INSTANCE.createEntityManager();
		List<Article> listArticleByName = 
				
				/* Equivalent en SQL : 
				 * SELECT article.*, founisseur.*
				 * FROM article art
				 * LEFT JOIN fournisseur f
				 * ON art.fournisseur_id = f.id
				 * WHERE art.id = :id
				 */
				
				em.createQuery("from Article art "
						+ " left outer join fetch art.fournisseur "
//						+ " left outer join fetch f.ville "
//						+ " left outer join fetch ville.departement "
						+ " WHERE art.id= :id", Article.class )
				.setParameter("id", id)
				.getResultList();
				
		
		em.close();
		
		return listArticleByName;
		
	}

}

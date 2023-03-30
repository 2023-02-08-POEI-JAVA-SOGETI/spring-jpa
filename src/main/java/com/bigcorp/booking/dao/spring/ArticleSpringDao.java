package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tp_spring_jpa_pablo.model.Article;


@Repository
public interface ArticleSpringDao extends CrudRepository<Article, Integer> {    
	// JPQL requetes SQL en JPA
	public List<Article> findByNom(String nomArticle);
	
	/**

	Returns a list of articles associated with a given fournisseur ID.
	@param fournisseurId the ID of the fournisseur whose articles are to be retrieved
	@return a list of articles associated with the given fournisseur ID
	@throws SomeException if there is an error while retrieving the articles
	*/
	public List<Article> findByFournisseurId(Integer fournisseurId);
		
	
	
}		
	
	
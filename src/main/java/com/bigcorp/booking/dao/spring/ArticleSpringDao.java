package com.bigcorp.booking.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tp_spring_jpa_pablo.model.Article;


@Repository
public interface ArticleSpringDao extends CrudRepository<Article, Integer> {    
	// JPQL requetes SQL en JPA
	public List<Article> findByNom(String nomArticle);
	// Find the articles linked to fournisseur by FK
	public List<Article> findByFournisseurId(Integer fournisseurId);
		
	
	
}		
	
	